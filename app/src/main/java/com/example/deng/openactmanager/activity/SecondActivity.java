package com.example.deng.openactmanager.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.deng.openactmanager.model.MainActTransfer;
import com.example.deng.openactmanager.utils.OpenActManager;
import com.example.deng.openactmanager.R;

import java.util.ArrayList;

/**
 * Created by deng on 2016/10/20.
 */

public class SecondActivity extends AppCompatActivity {

    private final String TAG = "SecondActivity";

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        MainActTransfer mainActTransfer = OpenActManager.get().getParcelableExtra(this);
        if (mainActTransfer != null) {
            int id = mainActTransfer.id;
            String name = mainActTransfer.name;
            ArrayList<String> data = mainActTransfer.data;
            Log.e(TAG, "id:" + id + "\nname" + name);
        }

    }
}
