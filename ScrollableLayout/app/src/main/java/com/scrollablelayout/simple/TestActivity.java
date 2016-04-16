package com.scrollablelayout.simple;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.scrollablelayout.ScrollableLayout;

public class TestActivity extends AppCompatActivity {

    private TextView tv_title;
    private ScrollableLayout sl_root;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        sl_root = (ScrollableLayout) findViewById(R.id.sl_root);
        listview = (ListView) findViewById(R.id.vp_scroll);
        tv_title = (TextView) findViewById(R.id.tv_title);

        int size = 100;
        String[] stringArray = new String[size];
        for (int i = 0; i < size; ++i) {
            stringArray[i] = ""+i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringArray);
        listview.setAdapter(adapter);
        sl_root.getHelper().setCurrentScrollableContainer(listview);

        TextView tv = (TextView) findViewById(R.id.tv_right);
        tv.setText("Github");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/w446108264/ScrollableLayout");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
