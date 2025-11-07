package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtSo = findViewById(R.id.edtSo);
        Button btnXuLySo = findViewById(R.id.btnXuLySo);

        EditText edtChuoi = findViewById(R.id.edtChuoi);
        Button btnXuLyChuoi = findViewById(R.id.btnXuLyChuoi);
        TextView txtKetQua = findViewById(R.id.txtKetQua);

        btnXuLySo.setOnClickListener(v -> {
            String input = edtSo.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show();
                return;
            }

            ArrayList<Integer> arrNumbers = new ArrayList<>();
            ArrayList<Integer> soChan = new ArrayList<>();
            ArrayList<Integer> soLe = new ArrayList<>();

            if (!input.contains(",")) {
                try {
                    int num = Integer.parseInt(input);
                    arrNumbers.add(num);

                    if (num % 2 == 0)
                        soChan.add(num);
                    else
                        soLe.add(num);

                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Giá trị không hợp lệ!", Toast.LENGTH_SHORT).show();
                    return;
                }
            } else {
                for (String s : input.split(",")) {
                    s = s.trim();
                    if (!s.isEmpty()) {
                        try {
                            int num = Integer.parseInt(s);
                            arrNumbers.add(num);

                            if (num % 2 == 0)
                                soChan.add(num);
                            else
                                soLe.add(num);

                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Có phần tử không phải số: " + s, Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
            }
            Log.d("SO_CHAN", "Số chẵn: " + soChan);
            Log.d("SO_LE",   "Số lẻ: " + soLe);
            txtKetQua.setText("Số chẵn: " + soChan + "\nSố lẻ: " + soLe);
        });

        btnXuLyChuoi.setOnClickListener(v -> {
            String s = edtChuoi.getText().toString().trim();
            if (s.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                return;
            }
            String[] words = s.split("\\s+");
            StringBuilder builder = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                builder.append(words[i]);

                if (i > 0) builder.append(" ");
            }

            String ketQua = builder.toString().toUpperCase();
            txtKetQua.setText(ketQua);
            Toast.makeText(MainActivity.this, ketQua, Toast.LENGTH_SHORT).show();
        });
    }
}
