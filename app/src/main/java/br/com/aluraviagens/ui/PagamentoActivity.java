package br.com.aluraviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.aluraviagens.R;
import br.com.aluraviagens.model.Pacotes;
import br.com.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);
        Pacotes pacoteSP = new Pacotes("São Paulo", "sao_paulo_sp", 2, new BigDecimal("399.90"));
        mostraPreco(pacoteSP);

    }

    private void mostraPreco(Pacotes pacote) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String real = MoedaUtil.formataParaMoedaReal((pacote.getPreco()));
        preco.setText(real);
    }
}