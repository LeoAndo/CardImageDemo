package com.example.cardimagedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        // NFCカードIDを入力してボタンを押すと、対応する画像を表示する
        btnEnter.setOnClickListener(v -> {
            String cardId = edtCardId.getText().toString();
            NFCCardItem cardItem = NFCCardItem.findByCardId(cardId);
            if (cardItem != null) {
                imgCard.setImageResource(cardItem.getResourceId());
            } else {
                Toast.makeText(MainActivity.this, "対応する画像が見つかりませんでした", Toast.LENGTH_LONG).show();
            }
        });
    }
}