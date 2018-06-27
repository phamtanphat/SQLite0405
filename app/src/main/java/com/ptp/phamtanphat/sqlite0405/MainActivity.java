package com.ptp.phamtanphat.sqlite0405;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

   static SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tao ra database
        sqLite = new SQLite(MainActivity.this,"Quanlymonan.sql",null,1);
        // Tao ra bang

//        String createTable = "CREATE TABLE IF NOT EXISTS Nhahang(Id INTEGER PRIMARY KEY AUTOINCREMENT , Tenmonan VARCHAR , Giamonan INTEGER , Diadiem VARCHAR )";
//        sqLite.QueryData(createTable);

//        String insertData = "INSERT INTO Nhahang VALUES(null , 'Banh beo', 15000 , 'Quận 2')";
//        sqLite.QueryData(insertData);
        String datatable = "SELECT * FROM Nhahang";
        Cursor cursor = sqLite.GetData(datatable);
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String tenmonan = cursor.getString(1);
            int giamonan = cursor.getInt(2);
            String diadiem = cursor.getString(3);
            Log.d("BBB","Id : " + id + "\n" + "Ten mon an : " + tenmonan);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chuyen_man_hinh,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemChuyenmanhinh :
                Intent intent = new Intent(this,ThemmonanActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
}
}


