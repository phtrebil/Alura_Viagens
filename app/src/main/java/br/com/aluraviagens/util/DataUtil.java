package br.com.aluraviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String dataEmTexto(int dias) {
        Calendar dataDeIda = Calendar.getInstance();
        Calendar dataDeVolta = Calendar.getInstance();
        dataDeVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES, Locale.CANADA);
        String dataFormatadaDeIda = formatoBrasileiro.format(dataDeIda.getTime());
        String dataFormatadaDeVolta = formatoBrasileiro.format(dataDeVolta.getTime());
        return dataFormatadaDeIda + " - "
                + dataFormatadaDeVolta + " de "
                + dataDeVolta.get(Calendar.YEAR);
    }
}
