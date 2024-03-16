package leiloestdsat.produto;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class ProdutosDTOValidar {
    
    //metodo para validar produto
    public boolean validarProduto(ProdutosDTO p){
        //validacoes
        
        //variaveis de mensagem
        String faltaPreencher;
        String nomeInvalido = "";
        String valorInvalido = "";
        
        //variaveis para formatacao de preenchimento
        BigDecimal valorBigDecimal = p.getValor();
        
        //convertendo para String para verificar formato
        String valorString = valorBigDecimal.toString();
        
        //variavel de verificacao
        boolean tudoPreenchido = true;
        boolean valorValido = valorString.matches("[0-9]{1,10}(\\.[0-9]{1,2})?");
        
        if(p.getNome().isBlank() || p.getNome().isEmpty()){
            nomeInvalido = "Campo Nome precisa ser preenchido\n";
            tudoPreenchido = false;
        }
        
        if(valorValido == false){
            valorInvalido = "Valor com formato inválido.\nDigite valores inteiros ou decimais separados por (.)\nEx: 543 e 232.54";
            tudoPreenchido = false;
        }
        
        //frase com resultado de preenchimento
        faltaPreencher = (nomeInvalido + valorInvalido);
        
        if(tudoPreenchido == true){
            return true;
        } else{
            JOptionPane.showMessageDialog(null, faltaPreencher);
            return false;
        }
    }
}
