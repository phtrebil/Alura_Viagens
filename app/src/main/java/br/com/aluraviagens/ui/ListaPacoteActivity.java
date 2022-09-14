package br.com.aluraviagens.ui;

import static br.com.aluraviagens.ui.PacoteActivityConstantes.CHAVE_PACOTE;
import static br.com.aluraviagens.ui.PacoteActivityConstantes.PACOTES;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.aluraviagens.R;
import br.com.aluraviagens.dao.PacoteDao;
import br.com.aluraviagens.model.Pacotes;
import br.com.aluraviagens.ui.adapter.ListaDePacotesAdapter;

public class ListaPacoteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_pacotes);
        setTitle(PACOTES);
        configuraLista();

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.listaDePacotes);
        final List<Pacotes> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter(new ListaDePacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener((adapterView, view, posicao, id) -> {

            Pacotes pacoteClicado = pacotes.get(posicao);
            vaiParaResumoPacote(pacoteClicado);
        });
    }

    private void vaiParaResumoPacote(Pacotes pacoteClicado) {
        Intent intent = new Intent(ListaPacoteActivity.this, ResumoPacoteActivity.class)
                .putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }


}