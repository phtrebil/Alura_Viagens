package br.com.aluraviagens.ui;

import static br.com.aluraviagens.ui.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent1 = getIntent();
        if (intent1.hasExtra(CHAVE_PACOTE)) {
            final Pacotes pacote = (Pacotes) intent1.getSerializableExtra(CHAVE_PACOTE);
            mostraPreco(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacotes pacote) {
        Button confirmaPagamento = findViewById(R.id.pagamento_button);
        confirmaPagamento.setOnClickListener(view -> vaiParaResumoCompra(pacote));
    }

    private void vaiParaResumoCompra(Pacotes pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class).putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacotes pacote) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String real = MoedaUtil.formataParaMoedaReal((pacote.getPreco()));
        preco.setText(real);
    }
}