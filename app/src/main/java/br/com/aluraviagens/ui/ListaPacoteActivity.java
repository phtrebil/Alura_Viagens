package br.com.aluraviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.aluraviagens.R;
import br.com.aluraviagens.dao.PacoteDao;
import br.com.aluraviagens.model.Pacotes;
import br.com.aluraviagens.ui.adapter.ListaDePacotesAdapter;

public class ListaPacoteActivity extends AppCompatActivity {

    public static final String PACOTES = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_pacotes);
        setTitle(PACOTES);
        configuraLista();
        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.listaDePacotes);
        List<Pacotes> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter(new ListaDePacotesAdapter(pacotes, this));
    }

}