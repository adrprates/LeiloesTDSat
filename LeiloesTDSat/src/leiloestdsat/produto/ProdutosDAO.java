package leiloestdsat.produto;

import leiloestdsat.conexaojdbc.conectaDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class ProdutosDAO {
    
    public void cadastrarProduto (ProdutosDTO produto){
        try{
            //criando objeto para fazer conexao com o banco de dados
            conectaDAO conexao = new conectaDAO();
            
            //conexao com o banco de dados
            conexao.conectar();
            
            //instrucao SQL que sera executada
            String sql = "INSERT INTO produtos (nome, valor, status) VALUES "
                    + "(?, ?, ?)";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setString(1, produto.getNome());
            consulta.setDouble(2, produto.getValor());
            consulta.setString(3, produto.getStatus());
            
            //executa instrucao SQL
            consulta.execute();
            
            //desconexao com o banco de dados
            conexao.desconectar();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar"
                    + " produto no banco de dados" + e.getMessage());
        }
    }     
}

