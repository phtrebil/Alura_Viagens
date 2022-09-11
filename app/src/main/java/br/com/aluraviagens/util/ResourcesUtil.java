package br.com.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class ResourcesUtil {

    @Nullable
    public static Drawable getDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idImagem = resources.getIdentifier(drawableEmTexto, "drawable", context.getPackageName());
        return ContextCompat.getDrawable(context, idImagem);
    }
}
