package com.ptp.phamtanphat.sqlite0405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tao ra database
        sqLite = new SQLite(MainActivity.this,"Quanlymonan.sql",null,1);
        // Tao ra bang

        String createTable = "CREATE TABLE IF NOT EXISTS Nhahang(Id INTEGER PRIMARY KEY AUTOINCREMENT , Tenmonan VARCHAR , Giamonan INTEGER , Diadiem VARCHAR )";
        sqLite.QueryData(createTable);
    }
}


