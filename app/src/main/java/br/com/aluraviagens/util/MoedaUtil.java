package br.com.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static String formataParaMoedaReal(BigDecimal valor) {
        NumberFormat formatoMoedaReal = DecimalFormat
                .getCurrencyInstance(new Locale("pt", "br"));
        return formatoMoedaReal.format(valor);
    }
}
