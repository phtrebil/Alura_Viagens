package br.com.aluraviagens.util;

import android.widget.TextView;

import br.com.aluraviagens.model.Pacotes;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataTextoDias(int quantidadeDeDias) {
        String diasEmTexto = "";
        if (quantidadeDeDias > 1) {
            return quantidadeDeDias + PLURAL;
        }
        return quantidadeDeDias + SINGULAR;
        }

}
