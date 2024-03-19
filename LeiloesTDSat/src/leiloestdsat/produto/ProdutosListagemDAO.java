package leiloestdsat.produto;

import java.util.ArrayList;
import java.util.List;
import leiloestdsat.conexaojdbc.conectaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class ProdutosListagemDAO {
    
    //metodo para listagem de produtos
    public static List<ProdutosDTO> listarProdutos(){
        //criando lista de produtos
        List<ProdutosDTO> lista = new ArrayList<ProdutosDTO>();
        try{
            //criando objeto para fazer conexao com o banco de dados
            conectaDAO conexao = new conectaDAO();
            
            //conexao com o banco de dados
            conexao.conectar();
            
            //instrucao SQL que sera executada
            String sql = "SELECT * FROM produtos WHERE status = 'A Venda';";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            //executa instrucao SQL
            ResultSet resposta = consulta.executeQuery();
            
            while(resposta.next()){
                ProdutosDTO p = new ProdutosDTO();
                
                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("nome"));
                p.setValor(resposta.getBigDecimal("valor"));
                p.setStatus(resposta.getString("status"));
                
                lista.add(p);
            }
            
            //desconexao com o banco de dados
            conexao.desconectar();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar listar"
                    + " produtos no banco de dados" + e.getMessage());
        }
        
        return lista;
    }
}
