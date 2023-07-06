package sg.edu.rp.c346.id22016788.songs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView nameid, titleid, yearid;
    ListView list;

    RadioButton radiobtn1, radiobtn2, radiobtn3, radiobtn4, radiobtn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        list = findViewById(R.id.lv);
        nameid = findViewById(R.id.nameid);
        titleid = findViewById(R.id.titleid);
        yearid = findViewById(R.id.yearid);
        radiobtn1 = findViewById(R.id.radiobtn1);
        radiobtn2 = findViewById(R.id.radiobtn2);
        radiobtn3 = findViewById(R.id.radiobtn3);
        radiobtn4 = findViewById(R.id.radiobtn4);
        radiobtn5 = findViewById(R.id.radiobtn5);



        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                if (radiobtn1.isSelected()){
                    db.insertTask(nameid, titleid, yearid, "1");
                }
                else if (radiobtn2.isSelected()) {
                    db.insertTask(nameid, titleid, yearid, "2");
                }
                else if (radiobtn2.isSelected()) {
                    db.insertTask(nameid, titleid, yearid, "3");
                }
                else if (radiobtn2.isSelected()) {
                    db.insertTask(nameid, titleid, yearid, "4");
                }
                else {
                    db.insertTask(nameid, titleid, yearid, "5");
                }
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the

                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                list.setAdapter(adapter);

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
            }
        });
    }
}

