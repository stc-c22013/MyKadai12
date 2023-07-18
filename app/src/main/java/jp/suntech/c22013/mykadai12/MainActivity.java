package jp.suntech.c22013.mykadai12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リスナオブジェクトの用意
        HelloListener listener = new HelloListener();

        //クリアボタンであるButtonオブジェクトの取得
        Button btClear = findViewById(R.id.btClear);
        Button btSend = findViewById(R.id.btSend);
        Button btConfirm = findViewById(R.id.btConfirm);
        //クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);
        btSend.setOnClickListener(listener);
        btConfirm.setOnClickListener(listener);
    }

    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //名前入力欄であるEdittextオブジェクトを取得
            EditText input = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etMail);
            EditText input3 = findViewById(R.id.etMailTitle);
            EditText input4 = findViewById(R.id.etComment);

            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.btConfirm);

            int id = view.getId();
            String inputStr = input.getText().toString();
            String inputStr2 = input2.getText().toString();
            String inputStr3 = input3.getText().toString();
            String inputStr4 = input4.getText().toString();

            if(id == R.id.btSend){
                Snackbar.make(view,"名前："+inputStr+"、"+"メールアドレス："+inputStr2+"、"+"メールタイトル"+inputStr3+"、"+"質問内容："+inputStr4+","+"を送信しました",Snackbar.LENGTH_LONG).show();
            } else if (id == R.id.btConfirm) {
                Dialog dialogFragment = new Dialog();
                dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                Snackbar.make(view,"名前："+inputStr+"、"+"メールアドレス："+inputStr2+"、"+"メールタイトル"+inputStr3+"、"+"質問内容："+inputStr4+","+"を送信しました",Snackbar.LENGTH_LONG).show();

            }else if(id == R.id.btClear){
                input.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");
            }
        }
    }
}