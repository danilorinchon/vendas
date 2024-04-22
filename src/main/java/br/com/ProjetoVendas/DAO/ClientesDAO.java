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
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danilo
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO(){
        
        this.con = new ConnectionFactory().getConnection();
    }
    
    //metodo cadastrar cliente
    public void cadastrarCliente(Clientes obj){
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
    public void alterarCliente(){
        
    }
    
    //metodo excluir cliente
    public void excluirCliente(){
        
    }

}
