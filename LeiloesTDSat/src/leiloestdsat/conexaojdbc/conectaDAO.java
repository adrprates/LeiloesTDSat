package leiloestdsat.conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class conectaDAO {
    
    //variavel
    private Connection conexao;
    
    //metodo para conectar no banco de dados
    public void conectar(){      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root", "q1w2e3r4@");
            System.out.println("Conexão realizada com sucesso!");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Falha ao carregar classe de"
                    + " conexão. Classe não encontrada." + e.getMessage());
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao se conectar com o"
                    + " banco de dados. Erro de SQL." + e.getMessage());
        }
    }
    
    //metodo para desconectar do banco de dados
    public void desconectar(){
        try{
            if(conexao != null && !conexao.isClosed()){
                conexao.close();
                System.out.println("Desconexão realizada com sucesso!");
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Falha ao realizar desconexão."
                    + e.getMessage());
        }
    }
    
    
    //get Conexao
    public Connection getConexao(){
        return conexao;
    }
    
}
