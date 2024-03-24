package leiloestdsat.produto;

import leiloestdsat.conexaojdbc.conectaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class ProdutosBuscarDAO {
    
    //metodo para localizar o produto no banco de dados
    public static boolean buscarProduto(int id){
        //criando variavel booleana
        boolean produtoExiste = false;
        try{
            //criando objeto para fazer conexao com o banco de dados
            conectaDAO conexao = new conectaDAO();
            
            //conexao com o banco de dados
            conexao.conectar();
            
            //instrucao SQL que sera executada
            String sql = "SELECT * FROM produtos WHERE id = ?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setInt(1, id);
            
            //executa instrucao SQL
            ResultSet resposta = consulta.executeQuery();
            
            if(resposta.next()){
                produtoExiste = true;
            }
            
            //desconexao com o banco de dados
            conexao.desconectar(); 
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar"
                    + " produto no banco de dados" + e.getMessage());
        }
        
        return produtoExiste;
    }
}
