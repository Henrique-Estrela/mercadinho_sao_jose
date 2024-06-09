package Controller;

import Models.Cliente;
import Views.JPClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.DB;
//import Exceptions.Exception;

public class ClienteController {
    
    /*
    * Função: registrar novo cliente
    * Requisitos:
    * - Nome deve ter 2 letras
    * - Não pode deixar um campo em branco
    */
    
    public static void registrarCliente(String cpf, String nome, String data_nasc, String telefone){
        String templateComandoSql = "INSERT INTO cliente(cpf, nome, data_nasc, telefone) VALUES (?, ?, ?, ?)";
        try {
            Connection dbConectado = DB.getConexao();
            PreparedStatement comandoSql = dbConectado.prepareStatement(templateComandoSql);
            comandoSql.setString(1, cpf);
            comandoSql.setString(2, nome);
            comandoSql.setString(3, data_nasc);
            comandoSql.setString(4, telefone);
            comandoSql.execute();
        } catch (SQLException excecao) {
            Logger.getLogger(JPClientes.class.getName()).log(Level.SEVERE, null, excecao);
        } finally {
            DB.closeConexao();
        }
    }
        
    /*
    * Função: acessar cliente
    */
    public static Cliente acessarCliente(int codigo){
        String templateComandoSql = "SELECT * FROM cliente WHERE id=" + codigo;
        Cliente clienteAcessado = null;
        try {
            Connection dbConectado = DB.getConexao();
            ResultSet retornoSql = dbConectado.createStatement().executeQuery(templateComandoSql);
            clienteAcessado = new Cliente(retornoSql);
        } catch (SQLException excecaoSql) {
            Logger.getLogger(JPClientes.class.getName()).log(Level.SEVERE, null, excecaoSql);
        } finally {
            DB.closeConexao();
        }
        System.out.println(clienteAcessado);
        return clienteAcessado;
    }
    
    /*
    * Função: alterar cliente
    */
    
    public static void alterarCliente(Cliente cliente) {
        String templateComandoSql = "UPDATE cliente  "+
                                    "   SET NOME = ?,   "+
                                    "       CPF  = ?,   "+
                                    "       TELEFONE = ?"+
                                    " WHERE ID = ?      ";
        try {
            Connection dbConectado = DB.getConexao();
            PreparedStatement comandoSql = dbConectado.prepareStatement(templateComandoSql);
            comandoSql.setString(1, cliente.getNome());
            comandoSql.setString(2, cliente.getCpf());
            comandoSql.setString(3, cliente.getTelefone());
            comandoSql.setInt(4, cliente.getId());
            comandoSql.execute();
        } catch (SQLException ex) {
             Logger.getLogger(JPClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DB.closeConexao();
        }        
    }
    
    
    
    // ------------------------------------------------------------------- //

    
}




/*
public class ClienteController {



    

    // ------------------------------------------------------------------------------------------ //

    // public ArrayList<Cliente> conultarCliente() {
    //     ArrayList<Cliente> lista = new ArrayList();
    //     try {
    //         // TODO add your handling code here:
    //         Connection conn = DB.getConexao();
    //         //
    //         Statement st = conn.createStatement();
    //         ResultSet rs = st.executeQuery("SELECT * FROM TB_CLIENTE");
    //         while (rs.next()) {
    //             Cliente cliente = new Cliente(rs);
    //             lista.add(cliente);
    //         }
    //     } catch (SQLException ex) {
    //         Logger.getLogger(JPClientes.class.getName()).log(Level.SEVERE, null, ex);
    //     } finally {
    //         DB.closeConexao();
    //     }
    //     return lista;
    // }


}
}

*/