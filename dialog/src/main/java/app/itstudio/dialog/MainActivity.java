/*
 * Created by Evgeny V. Lobach on 30.09.18 22:38
 * Copyright (c) 2018 | www.itstudio.app | All rights reserved.
 * Last modified 30.09.18 22:38
 */

package app.itstudio.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentDialogFragment.DialogCallback {

    DialogFragment dlg;
    public static final String TAG = FragmentDialogFragment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSimpleDialog = findViewById(R.id.btnSimpleDialog);
        btnSimpleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo();
            }
        });

        dlg = new FragmentDialogFragment();
        Button btnDialogFragment = findViewById(R.id.btnDialogFragment);
        btnDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.show(getSupportFragmentManager(), TAG);
            }
        });
    }

    private void showInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Info")
                .setMessage("London is the capital of Great Britain")
                .setPositiveButton("true", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You are absolutely right", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("false", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @Override
    public void setPositiveResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
