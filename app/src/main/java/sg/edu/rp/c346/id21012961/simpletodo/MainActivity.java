package sg.edu.rp.c346.id21012961.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner AddRem;
    EditText task;
    Button Add;
    Button Clr;
    Button Rem;
    ListView tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddRem = findViewById(R.id.spinTask);
        task = findViewById(R.id.editTask);
        Add = findViewById(R.id.btnAdd);
        Clr = findViewById(R.id.btnClr);
        Rem = findViewById(R.id.btnRem);
        tvList = findViewById(R.id.SimpleView);


        ArrayList<String> LTask = new ArrayList<>();

        ArrayAdapter ATask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LTask);
        tvList.setAdapter(ATask);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CTask = task.getText().toString();
                LTask.add(CTask);
                ATask.notifyDataSetChanged();
            }
        });

        Clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LTask.clear();
                ATask.notifyDataSetChanged();
            }
        });

        AddRem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        task.setHint("Add new Task");
                        Add.setEnabled(true);
                        Rem.setEnabled(false);
                        break;
                    case 1:
                        task.setHint("Input index of task to remove");
                        Add.setEnabled(false);
                        Rem.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(task.getText().toString());
                LTask.remove(id);
                ATask.notifyDataSetChanged();
            }
        });
    }
}