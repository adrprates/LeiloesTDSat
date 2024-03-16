package leiloestdsat.produto;

import java.math.BigDecimal;

/**
 *
 * @author Adriano
 */
public class ProdutosDTO {
    private int id;
    private String nome;
    private BigDecimal valor;
    private String status;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
