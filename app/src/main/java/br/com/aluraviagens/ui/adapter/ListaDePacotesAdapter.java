package br.com.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.aluraviagens.R;
import br.com.aluraviagens.model.Pacotes;
import br.com.aluraviagens.util.DiasUtil;
import br.com.aluraviagens.util.MoedaUtil;
import br.com.aluraviagens.util.ResourcesUtil;

public class ListaDePacotesAdapter extends BaseAdapter {
    private final List<Pacotes> pacote;
    private final Context context;

    public ListaDePacotesAdapter(List<Pacotes> pacote, Context context) {
        this.pacote = pacote;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacote.size();
    }

    @Override
    public Object getItem(int i) {
        return pacote.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);
        Pacotes pacotes = pacote.get(i);
        mostraLocal(viewCriada, pacotes);
        mostraImagem(viewCriada, pacotes);
        mostraDias(viewCriada, pacotes);
        mostraPreco(viewCriada, pacotes);


        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacotes pacotes) {
        TextView preco = viewCriada.findViewById(R.id.item_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaMoedaReal(pacotes.getPreco());
        preco.setText(moedaBrasileira);

    }



    private void mostraDias(View viewCriada, Pacotes pacotes) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataTextoDias(pacotes.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(View viewCriada, Pacotes pacotes) {
        ImageView imagem = viewCriada.findViewById(R.id.item_imagem);
        Drawable drawable = ResourcesUtil.getDrawable(context, pacotes.getImagem());
        imagem.setImageDrawable(drawable);
    }


    private void mostraLocal(View viewCriada, Pacotes pacotes) {
        TextView local = viewCriada.findViewById(R.id.item_local);
        local.setText(pacotes.getLocal());
    }
}
