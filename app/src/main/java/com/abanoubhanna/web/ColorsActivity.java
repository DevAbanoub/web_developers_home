package com.abanoubhanna.web;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final String[] colorsNameValue = {"#F44336\nRED", "#E91E63\nPINK", "#9C27B0\nPURPLE",
                "#673AB7\nDEEP PURPLE","#3F51B5\nINDIGO","#2196F3\nBLUE","#03A9F4\nLIGHT BLUE",
                "#00BCD4\nCYAN","#009688\nTEAL","#4CAF50\nGREEN","#8BC34A\nLIGHT GREEN",
                "#CDDC39\nLIME","#FFEB3B\nYELLOW","#FFC107\nAMBER","#FF9800\nORANGE",
                "#FF5722\nDEEP ORANGE","#795548\nBROWN","#9E9E9E\nGREY","#607D8B\nBLUE GREY"};

        ListAdapter customListAdapter = new CustomListViewAdapter(this,colorsNameValue);
        ListView lv =(ListView)findViewById(R.id.lv);
        lv.setAdapter(customListAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                copy2Clipboard(colorsNameValue[i].substring(0, Math.min(colorsNameValue[i].length(), 7)));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    void copy2Clipboard(CharSequence text){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("copy text", text);
        if (clipboard != null){
            clipboard.setPrimaryClip(clip);
        }
        Toast.makeText(this," Color Value Copied ", Toast.LENGTH_LONG).show();
    }
}
