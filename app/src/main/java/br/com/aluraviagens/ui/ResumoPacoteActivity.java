package br.com.aluraviagens.ui;

import static br.com.aluraviagens.util.DataUtil.dataEmTexto;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.aluraviagens.R;
import br.com.aluraviagens.model.Pacotes;
import br.com.aluraviagens.util.DiasUtil;
import br.com.aluraviagens.util.MoedaUtil;
import br.com.aluraviagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE_APP_BAR = "Resudo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITLE_APP_BAR);

        Pacotes pacoteSP = new Pacotes("São Paulo", "sao_paulo_sp", 2, new BigDecimal("399.90"));
        mostraLocal(pacoteSP);
        mostraImagem(pacoteSP);
        mostraDias(pacoteSP);
        mostraPreco(pacoteSP);

        mostraData(pacoteSP);


    }

    private void mostraData(Pacotes pacote) {
        TextView data = findViewById(R.id.resumo_data);
        String dataPacote = dataEmTexto(pacote.getDias());
        data.setText(dataPacote);
    }



    private void mostraPreco(Pacotes pacote) {
        TextView preco = findViewById(R.id.resumo_valor_preco);
        String s1 = MoedaUtil.formataParaMoedaReal(pacote.getPreco());
        preco.setText(s1);
    }

    private void mostraDias(Pacotes pacote) {
        TextView dias = findViewById(R.id.resumo_dias);
        String s = DiasUtil.formataTextoDias(pacote.getDias());
        dias.setText(s);
    }

    private void mostraImagem(Pacotes pacote) {
        ImageView ImagemSP = findViewById(R.id.resumo_imagem_sp);
        Drawable drawable = ResourcesUtil.getDrawable(this, pacote.getImagem());
        ImagemSP.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacotes pacote) {
        TextView local = findViewById(R.id.resumo_local);
        local.setText(pacote.getLocal());
    }
}