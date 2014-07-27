package com.varwise.bumper;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EditScreen extends ListActivity  {

    private ArrayList<ScreenInformation> m_screens = null;
    private ScreenInformationAdapter m_adapter;
    private Runnable viewScreens;
    private  ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_screen);
        m_screens = new ArrayList<ScreenInformation>();

        m_adapter = new ScreenInformationAdapter(this, R.layout.edit_screen_list_item, m_screens);

        setListAdapter(this.m_adapter);


        lv = (ListView) this.findViewById(android.R.id.list);
        lv.setClickable(true);
        lv.setFocusable(true);
        lv.setFocusableInTouchMode(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextScreen = null;
                switch(position){
                    case 0:
                        nextScreen = new Intent(getApplicationContext(), VictimQuestionScreen.class);
                        break;
                    case 1:
                        nextScreen = new Intent(getApplicationContext(), HealthQuestionScreen.class);
                        break;
                    case 2:
                        nextScreen = new Intent(getApplicationContext(), PhotoViewScreen.class);
                        break;
                    case 3:
                        nextScreen = new Intent(getApplicationContext(), ObstructQuestionScreen.class);
                        break;
                    case 4:
                        nextScreen = new Intent(getApplicationContext(), ChooseLocationScreen.class);
                        break;
                    case 5:
                        nextScreen = new Intent(getApplicationContext(), DocumentsCheckScreen.class);
                        break;
                    case 6:
                        nextScreen = new Intent(getApplicationContext(), OffendersStatement.class);
                        break;
                    case 7:
                        nextScreen = new Intent(getApplicationContext(), InsuranceScreen.class);
                        break;
                }
                if(nextScreen!=null)
                    startActivity(nextScreen);
            }
        });

    }

    protected void onResume(){
        super.onResume();
        viewScreens = new Runnable(){
            @Override
            public void run() {
                getScreens();
            }
        };
        Thread thread =  new Thread(null, viewScreens, "MagentoBackground");
        thread.start();
    }

    private Runnable returnRes = new Runnable() {

        @Override
        public void run() {

            if(m_screens != null && m_screens.size() > 0){
                m_adapter.clear();
                m_adapter.notifyDataSetChanged();
                for(int i=0;i<m_screens.size();i++)
                    m_adapter.add(m_screens.get(i));
            }
            lv.destroyDrawingCache();
            m_adapter.notifyDataSetInvalidated();
            m_adapter.notifyDataSetChanged();
        }
    };

    private void getScreens() {
        m_screens = new ArrayList<ScreenInformation>();

        ScreenInformation o = new ScreenInformation();
        o.setNumber(1);
        o.setBottomInformation(ScreenDB.getFinishedDate(VictimQuestionScreen.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(VictimQuestionScreen.baseKey, (getApplicationContext())));
        o.setScreenName(ScreenDB.getPrettyName(VictimQuestionScreen.baseKey));
        m_screens.add(o);

        o = new ScreenInformation();
        o.setNumber(2);
        o.setBottomInformation(ScreenDB.getFinishedDate(HealthQuestionScreen.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(HealthQuestionScreen.baseKey, getApplicationContext()));
        o.setScreenName(ScreenDB.getPrettyName(HealthQuestionScreen.baseKey));
        m_screens.add(o);

        o = new ScreenInformation();
        o.setNumber(3);
        o.setBottomInformation(ScreenDB.getFinishedDate(PhotoViewScreen.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(PhotoViewScreen.baseKey, getApplicationContext()));
        o.setScreenName(ScreenDB.getPrettyName(PhotoViewScreen.baseKey));

        m_screens.add(o);

        o = new ScreenInformation();
        o.setNumber(4);
        o.setBottomInformation(ScreenDB.getFinishedDate(ObstructQuestionScreen.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(ObstructQuestionScreen.baseKey, getApplicationContext()));
        o.setScreenName(ScreenDB.getPrettyName(ObstructQuestionScreen.baseKey));

        m_screens.add(o);

        o = new ScreenInformation();
        o.setNumber(5);
        o.setBottomInformation(ScreenDB.getFinishedDate(ChooseLocationScreen.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(ChooseLocationScreen.baseKey, getApplicationContext()));
        o.setScreenName(ScreenDB.getPrettyName(ChooseLocationScreen.baseKey));

        m_screens.add(o);

        o = new ScreenInformation();
        o.setNumber(6);
        o.setBottomInformation(ScreenDB.getFinishedDate(DocumentsCheckScreen.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(DocumentsCheckScreen.baseKey, getApplicationContext()));
        o.setScreenName(ScreenDB.getPrettyName(DocumentsCheckScreen.baseKey));

        m_screens.add(o);

        o = new ScreenInformation();
        o.setNumber(7);
        o.setBottomInformation(ScreenDB.getFinishedDate(OffendersStatement.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(OffendersStatement.baseKey, getApplicationContext()));
        o.setScreenName(ScreenDB.getPrettyName(OffendersStatement.baseKey));

        m_screens.add(o);

        o = new ScreenInformation();
        o.setNumber(8);
        o.setBottomInformation(ScreenDB.getFinishedDate(InsuranceScreen.baseKey, getApplicationContext()));
        o.setDone(ScreenDB.getFinished(InsuranceScreen.baseKey, getApplicationContext()));
        o.setScreenName(ScreenDB.getPrettyName(InsuranceScreen.baseKey));

        m_screens.add(o);


        runOnUiThread(returnRes);
    }

}
