/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ProjetoVendas.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author danilo
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
            return DriverManager.getConnection("jdbc:mysql://bdvendasspc.mysql.uhserver.com/bdvendasspc","danilos01","Saibot@1");
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }
    
}
