package com.hackerkernel.restapi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class detail extends ActionBarActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv = (TextView)findViewById(R.id.textView);

        //store the text in variable
        String name = getIntent().getExtras().getString("name");
        //display text
        tv.setText(name);
    }

}
