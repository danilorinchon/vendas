/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ProjetoVendas.DAO;

import br.com.ProjetoVendas.JDBC.ConnectionFactory;
import br.com.ProjetoVendas.Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danilo
 */
public class ClientesDAO {
    
    private Connection con;
    
    private ClientesDAO(){
        
        this.con = new ConnectionFactory().getConnection();
    }
    
    //metodo cadastrar cliente
    public void cadastrarCliente(Clientes obj){
        try {
            // 1 passo criar o comando sql
            String sql = "INSERT INTO `tb_clientes` (`id`, `nome`, `rg`, `cpf`, `email`, `telefone`, `celular`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`)" 
                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);"; 
            
            // 2 passo conectar no DB e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "NULL");
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getRg());
            stmt.setString(4, obj.getCpf());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getTelefone());
            stmt.setString(7, obj.getCelular());
            stmt.setString(8, obj.getCep());
            stmt.setString(9, obj.getEndereco());
            stmt.setInt(10, obj.getNumero());
            stmt.setString(11, obj.getComplemento());
            stmt.setString(12, obj.getBairro());
            stmt.setString(13, obj.getCidade());
            stmt.setString(14, obj.getEstado());
            
            // 3 passo executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ops! O cadastro do cliente falhou. Erro: " + erro);

        }
        
        
    }
    
    //metodo alterar cliente
    public void alterarCliente(){
        
    }
    
    //metodo excluir cliente
    public void excluirCliente(){
        
    }

}
