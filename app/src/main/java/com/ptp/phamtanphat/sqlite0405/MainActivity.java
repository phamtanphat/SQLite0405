package com.ptp.phamtanphat.sqlite0405;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static SQLite sqLite;
    ListView lvMonan;
    ArrayList<Monan> mangmonan;
    MonanAdapter monanAdapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tao ra database
        sqLite = new SQLite(MainActivity.this, "Quanlymonan.sql", null, 1);
        // Tao ra bang

//        String createTable = "CREATE TABLE IF NOT EXISTS Nhahang(Id INTEGER PRIMARY KEY AUTOINCREMENT , Tenmonan VARCHAR , Giamonan INTEGER , Diadiem VARCHAR )";
//        sqLite.QueryData(createTable);

//        String insertData = "INSERT INTO Nhahang VALUES(null , 'Banh beo', 15000 , 'Quận 2')";
//        sqLite.QueryData(insertData);
        lvMonan = findViewById(R.id.listviewMonan);
        mangmonan = new ArrayList<>();

        String datatable = "SELECT * FROM Nhahang";
        Cursor cursor = sqLite.GetData(datatable);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String tenmonan = cursor.getString(1);
            int giamonan = cursor.getInt(2);
            String diadiem = cursor.getString(3);
            mangmonan.add(new Monan(Integer.parseInt(id),tenmonan,giamonan,diadiem));
        }
        monanAdapter = new MonanAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangmonan);
        lvMonan.setAdapter(monanAdapter);
        lvMonan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                intent.putExtra("monan",mangmonan.get(position));
                startActivity(intent);
            }
        });
        lvMonan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.sqLite.QueryData("DELETE FROM Nhahang WHERE Id = '" + mangmonan.get(position).getId() + "'");
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chuyen_man_hinh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemChuyenmanhinh:
                Intent intent = new Intent(this, ThemmonanActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


