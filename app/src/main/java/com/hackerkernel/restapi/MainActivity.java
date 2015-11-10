package com.hackerkernel.restapi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ProgressBar pb;
    private ListView lv;
    private List<String> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        lv = (ListView) findViewById(R.id.listView);
        
        /*fetch data from the web*/
        Fetcher fetcher = new Fetcher();
        fetcher.execute("http://10rsfreerecharge.site11.com/getJsonResponse.php");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) lv.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,detail.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }


    public void ContactAdapter(String json){
        contactList = JsonParser.Parse(json);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactList);
        lv.setAdapter(adapter);
    }

    //AsyncTask
    private class Fetcher extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            String data = HttpManger.getData(params[0]);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            ContactAdapter(s);
            pb.setVisibility(View.INVISIBLE);
        }
    }
}
