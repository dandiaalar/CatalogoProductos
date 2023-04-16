package com.example.catalogodeproductos.support;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Button;
import android.widget.TextView;

import com.example.catalogodeproductos.R;

import java.util.Objects;

public class MessageUtilities {
    public static Dialog showLoadingMessage(Context context, String message){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);
        TextView mensajeTxt = dialog.findViewById(R.id.loading_description);
        mensajeTxt.setText(message);
        Objects.requireNonNull(dialog.getWindow())
                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    public static void showErrorMessage(Context context, String message){
        if (context != null){
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.dialog_error);
            TextView mensajeTxt = dialog.findViewById(R.id.error_description);
            Button okBtn = dialog.findViewById(R.id.error_ok);
            mensajeTxt.setText(message);
            okBtn.setOnClickListener(v -> dialog.dismiss());
            Objects.requireNonNull(dialog.getWindow())
                    .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }
    }
}
