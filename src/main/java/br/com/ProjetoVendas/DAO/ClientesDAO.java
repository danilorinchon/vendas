/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ProjetoVendas.DAO;

import br.com.ProjetoVendas.JDBC.ConnectionFactory;
import br.com.ProjetoVendas.Model.Clientes;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author danilo
 */
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {

        this.con = new ConnectionFactory().getConnection();
    }

    //metodo cadastrar cliente
    public void cadastrarCliente(Clientes obj) {
        try {
            // 1 passo criar o comando sql
            String sql = "INSERT INTO `tb_clientes` (`id`, `nome`, `rg`, `cpf`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`)"
                    + "VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            // 2 passo conectar no DB e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, NULL);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());

            // 3 passo executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ops! O cadastro do cliente falhou. Erro: " + erro);

        }

    }

    //metodo alterar cliente
    public void alterarCliente(Clientes obj) {

        try {
            // 1 passo criar o comando sql
            String sql = "UPDATE `tb_clientes` SET `nome`=?, `rg`=?, `cpf`=?, `email`=?, "
                    + "`telefone`=?, `celular`=?, `cep`=?, `endereco`=?, `numero`=?, "
                    + "`complemento`=?, `bairro`=?, `cidade`=?, `estado`=? WHERE `tb_clientes`.`id`=?";

            //UPDATE `tb_clientes` SET `nome` = 'danilo rinchon teste 2', `email` = 'danilo@teste.com.br', 
            //`cep` = '55555-666', `endereco` = 'rua do codigo 2' WHERE `tb_clientes`.`id` = 6
            // 2 passo conectar no DB e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            //stmt.setInt(1, NULL);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14, obj.getId());

            //System.out.println("SQL: " + stmt);
            //JOptionPane.showMessageDialog(null, "Comando sql gerado: " + stmt);
            // 3 passo executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ops! A atualização do cliente falhou. Erro: " + erro);

        }
    }

    //metodo excluir cliente
    public void excluirCliente(Clientes obj) {

        try {
            // 1 passo criar o comando sql
            String sql = "delete from `tb_clientes` where `id` = ?;";

            // 2 passo conectar no DB e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, NULL);
            stmt.setInt(1, obj.getId());

            // 3 passo executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ops! A exclusão do cliente falhou. Erro: " + erro);

        }

    }

    //metodo listar todos os clientes
    public List<Clientes> listarClientes() {

        try {
            //primeiro passo criar a lista
            List<Clientes> lista = new ArrayList<>();

            // segundo passo criar o comando sql, organizar e executar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                // adicionar na lista
                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    //Buscar Cliente por Nome
    public List<Clientes> buscaClientePorNome(String nome) {

        try {
            //primeiro passo criar a lista
            List<Clientes> lista = new ArrayList<>();

            // segundo passo criar o comando sql, organizar e executar
            String sql = "select * from tb_clientes where `nome` like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                // adicionar na lista
                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    // Busca Cliente por CPF
    public Clientes consultaClientePorCPF(String CPF) {
        try {
            // segundo passo criar o comando sql, organizar e executar
            String sql = "select * from tb_clientes where `cpf` = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, CPF);

            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
}
