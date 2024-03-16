package leiloestdsat.produto;

import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class ProdutosDTOCadastrarController {
    
    //associacao entre classes
    private ProdutosDTOValidar validar;
    private ProdutosCadastrarDAO cadastrar;
    
    //construtor
    public ProdutosDTOCadastrarController(ProdutosDTOValidar validar, ProdutosCadastrarDAO cadastrar) {
        this.validar = validar;
        this.cadastrar = cadastrar;
    }
    
    //metodo para adequar os dados do cadastro
    public boolean adequarProduto(ProdutosDTO p){
        if(validar.validarProduto(p)){
            cadastrar.cadastrarProduto(p);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            return true;
        } else{
            return false;
        }
    }
    
}
