package br.com.aluraviagens.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

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
        Pacotes pacoteSP = new Pacotes("São Paulo", "sao_paulo_sp", 2, new BigDecimal("399.90"));
        mostraLocal(pacoteSP);
        mostraImagem(pacoteSP);
        mostraData(pacoteSP);
        mostraPreco(pacoteSP);

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