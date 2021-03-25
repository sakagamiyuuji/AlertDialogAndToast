package com.example.alertdialogandtoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etContent;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeId();

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();

                String warn = "Apakah akan menampilkan notifikasi ini?";

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(warn);

                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, title + " " + content, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Tidak", null);

                builder.create().show();

            }
        });

    }

    private void initializeId() {
        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        btnShow =  findViewById(R.id.btn_show);
    }
}