package com.example.cardimagedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtCardId = findViewById(R.id.edt_card_id);
        Button btnEnter = findViewById(R.id.btn_enter);
        ImageView imgCard = findViewById(R.id.img_card);
        TextView txtBookInfo = findViewById(R.id.txt_book_info);

        // NFCカードIDを入力してボタンを押すと、対応する画像を表示する
        btnEnter.setOnClickListener(v -> {
            String cardId = edtCardId.getText().toString(); // NFCカードIDを取得する ex) "card_id_001"
            NFCCardItem cardItem = NFCCardItem.findByCardId(cardId); // NFCカードIDから対応する情報を取得する
            if (cardItem != null) {

                imgCard.setImageResource(cardItem.getResourceId());

                List<Book> books = cardItem.getBooks(); // 対応する本の情報を取得する

                txtBookInfo.setText(cardItem.getBooks().toString()); // debug::: 本の情報を表示する
            } else {
                // error::: 1、トーストメッセージを表示する
                Toast.makeText(MainActivity.this, "対応するデータが見つかりませんでした", Toast.LENGTH_LONG).show();
            }
        });
    }
}
