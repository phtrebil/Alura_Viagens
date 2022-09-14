package br.com.aluraviagens.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pacotes implements Serializable {
    
    private final String local;
    private final String imagem;
    private final int dias;
    private final BigDecimal preco;


    public String getLocal() {
        return local;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }



    public Pacotes(String local, String imagem, int dias, BigDecimal preco) {
        this.local = local;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
    }
}
