package com.ptp.phamtanphat.sqlite0405;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemmonanActivity extends AppCompatActivity {

    EditText edtTen,edtGia,edtDiachi;
    Button btnHuy,btnXacnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themmonan);

        anhxa();

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString();
                String gia = edtGia.getText().toString();
                String diachi = edtDiachi.getText().toString();

                if (!ten.isEmpty() && !gia.isEmpty() && !diachi.isEmpty()){
                    MainActivity.sqLite.QueryData("INSERT INTO Nhahang VALUES(null , '" + ten+ "' , "+ gia +" , '" + diachi +"')");
                    Intent intent = new Intent(ThemmonanActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(ThemmonanActivity.this, "Thanh cong!!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ThemmonanActivity.this, "Hay du thong tin!!", Toast.LENGTH_SHORT).show();
                }
           }
        });
    }

    private void anhxa() {
        edtTen = findViewById(R.id.edittextTenmonan);
        edtGia = findViewById(R.id.edittextGiamonan);
        edtDiachi = findViewById(R.id.edittextDiachi);
        btnHuy = findViewById(R.id.buttonHuy);
        btnXacnhan = findViewById(R.id.buttonXacnhan);
    }
}
