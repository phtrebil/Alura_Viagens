package br.com.aluraviagens.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.aluraviagens.R;
import br.com.aluraviagens.model.Pacotes;
import br.com.aluraviagens.util.DataUtil;
import br.com.aluraviagens.util.MoedaUtil;
import br.com.aluraviagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);
        recebePacote();


    }

    private void recebePacote() {
        Intent intent = getIntent();
        if (intent.hasExtra("pacote")) {

            final Pacotes pacote = (Pacotes) intent.getSerializableExtra("pacote");

            carregaItens(pacote);
        }
    }

    private void carregaItens(Pacotes pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacotes pacote) {
        TextView preco = findViewById(R.id.compra_txt_preco);
        String real = MoedaUtil.formataParaMoedaReal(pacote.getPreco());
        preco.setText(real);
    }

    private void mostraData(Pacotes pacote) {
        TextView data = findViewById(R.id.compra_txt_data);
        String s = DataUtil.dataEmTexto(pacote.getDias());
        data.setText(s);
    }

    private void mostraImagem(Pacotes pacote) {
        ImageView imagem = findViewById(R.id.compra_imagem_local);
        Drawable drawable = ResourcesUtil.getDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacotes pacote) {
        TextView local = findViewById(R.id.compra_txt_local);
        local.setText(pacote.getLocal());
    }
}