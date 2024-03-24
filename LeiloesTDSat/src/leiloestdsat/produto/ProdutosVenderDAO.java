package leiloestdsat.produto;

import leiloestdsat.conexaojdbc.conectaDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class ProdutosVenderDAO {
    
    //metodo para vender produto
    public static void venderProduto(int id){
        try{
            //criando objeto para fazer conexao com o banco de dados
            conectaDAO conexao = new conectaDAO();
        
            //conexao com o banco de dados
            conexao.conectar();
        
            //instrucao SQL que sera executada
            String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setInt(1, id);
            
            //executa instrucao SQL
            consulta.execute();
            
            //desconexao com o banco de dados
            conexao.desconectar();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar"
                    + " status do registro no banco de dados" + e.getMessage());
        }
    }
}
