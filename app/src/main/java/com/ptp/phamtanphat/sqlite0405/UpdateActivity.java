package com.ptp.phamtanphat.sqlite0405;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {


    EditText edtTen,edtGia,edtDiachi;
    Button btnHuy,btnXacnhan;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edtTen = findViewById(R.id.edittextUpdateTenmonan);
        edtGia = findViewById(R.id.edittextUpdateGiamonan);
        edtDiachi = findViewById(R.id.edittextUpdateDiachi);
        btnHuy = findViewById(R.id.buttonUpdateHuy);
        btnXacnhan = findViewById(R.id.buttonUpdateXacnhan);

        Intent intent = getIntent();
        Monan monan = intent.getParcelableExtra("monan");
        id = monan.getId();
        edtTen.setText(monan.getTenmonan());
        edtDiachi.setText(monan.getDiachi());
        edtGia.setText(monan.getGiamonan() + "");

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmonan = edtTen.getText().toString();
                int giamonan = Integer.parseInt(edtGia.getText().toString());
                String diachi = edtDiachi.getText().toString();

                MainActivity.sqLite.QueryData("UPDATE Nhahang SET Tenmonan = '" + tenmonan+ "' , Giamonan = '"+ giamonan +"' , Diadiem = '" + diachi + "' WHERE Id = '"+id+"' ");
                Toast.makeText(UpdateActivity.this, "Thanh cong!!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
