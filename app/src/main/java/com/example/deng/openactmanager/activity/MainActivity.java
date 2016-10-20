package com.example.deng.openactmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.deng.openactmanager.model.MainActTransfer;
import com.example.deng.openactmanager.utils.OpenActManager;
import com.example.deng.openactmanager.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActTransfer mainActTransfer = new MainActTransfer(1, "deng", new ArrayList<String>());
        OpenActManager.get().goActivity(this, SecondActivity.class, mainActTransfer);
    }
}
