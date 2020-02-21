package com.example.synqtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTime;
    private Button btnRunAsync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setId();
        setListener();
    }
    public void setId(){
        edtTime=findViewById(R.id.sleepTime);
        btnRunAsync=findViewById(R.id.runAsync);
    }
    public void setListener(){
        btnRunAsync.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.runAsync:
                String sleepTime = edtTime.getText().toString().trim();
                AsyncTask asyncTask = new AsyncTask(sleepTime,MainActivity.this);
                asyncTask.execute(sleepTime);
                break;
        }
    }
}
