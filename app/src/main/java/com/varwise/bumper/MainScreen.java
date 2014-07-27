package com.varwise.bumper;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;


public class MainScreen extends ListActivity  {
    public static String baseKey = "MainScreen";

    private ArrayList<AccidentInformation> m_accidents = null;
    private AccidentInformationAdapter m_adapter;
    private Runnable viewAccidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainScreen", "onCreate");
        setContentView(R.layout.activity_main_screen);
        m_accidents = new ArrayList<AccidentInformation>();

        m_adapter = new AccidentInformationAdapter(this, R.layout.accident_list_item, m_accidents);

        setListAdapter(this.m_adapter);


        ListView lv = (ListView) this.findViewById(android.R.id.list);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainScreen", "setOnItemClickListener");


                if(position==ScreenDB.getAccidents(baseKey, getApplicationContext())){
                    addAccident();
                }else{
                Intent nextScreen = null;
                nextScreen = new Intent(getApplicationContext(), EditScreen.class);
                startActivity(nextScreen);
                }

            }
        });
    }


    protected void onResume(){
        super.onResume();

        Log.d("MainScreen", "onResume");
        viewAccidents = new Runnable(){
            @Override
            public void run() {
                getAccidentsList();
            }
        };

        Thread thread =  new Thread(null, viewAccidents, "MagentoBackground");
        thread.start();
    }

    private Runnable returnRes = new Runnable() {

        @Override
        public void run() {

            if(m_accidents != null && m_accidents.size() > 0){
                m_adapter.clear();
                m_adapter.notifyDataSetChanged();
                for(int i=0;i<m_accidents.size();i++)
                    m_adapter.add(m_accidents.get(i));
            }
            m_adapter.notifyDataSetChanged();
        }
    };

    protected void getAccidentsList(){
        m_accidents = new ArrayList<AccidentInformation>();
        Log.d("MainScreen", "getAccidentsList");
        int accidents = ScreenDB.getAccidents(baseKey, getApplicationContext());
        for(int i = 0;i<accidents;++i){
            AccidentInformation ai = new AccidentInformation();
            ai.setNumber(i+1);
            ai.setDate(new Date(ScreenDB.getAccidentDate(baseKey, getApplicationContext(), i) ) );
            m_accidents.add(ai);
        }

        Log.d("MainScreen", "3");
        AccidentInformation ai = new AccidentInformation();
        ai.setNumber(-1);

        Log.d("MainScreen", "2");
        m_accidents.add(ai);
        Log.d("MainScreen", "1");
        runOnUiThread(returnRes);

    }
    public void addAccident(){
        Log.d("MainScreen","addAccident");
        int accidents = ScreenDB.getAccidents(baseKey, getApplicationContext());
        Log.d("MainScreen",""+accidents);
        ScreenDB.setAccidents(baseKey, getApplicationContext(), accidents + 1);
        ScreenDB.setAccidentDate(baseKey, getApplicationContext(), accidents, new Date().getTime());

        onResume();
    }

}
