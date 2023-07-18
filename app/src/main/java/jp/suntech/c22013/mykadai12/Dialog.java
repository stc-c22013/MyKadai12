package jp.suntech.c22013.mykadai12;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class Dialog extends DialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstate){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("内容確認");
        builder.setMessage("以上の内容を送信します。");
        builder.setPositiveButton("OK",new DialogButtonClickListener());
        builder.setNegativeButton("変更",new DialogButtonClickListener());
        AlertDialog dialog = builder.create();

        return dialog;

    }
    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which){
            String msg="";
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg = "ありがとうございます。";
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = "送信をキャンセルしました。";
                    break;
            }

        }
    }

}
