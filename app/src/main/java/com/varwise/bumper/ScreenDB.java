package com.varwise.bumper;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenDB {

    public static String getFinishedDate(String baseKey, Context c){
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        String date = settings.getString(baseKey + "finishedDate", null);
        return date;
    }

    public static void setFinishedDate(String baseKey, Context c){
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        SharedPreferences.Editor edit = settings.edit();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
        String date = sdf.format(new Date());

        ScreenDB.setFinished(baseKey, c, true);

        edit.putString(baseKey + "finishedDate", date);
        edit.apply();
    }

    public static boolean getFinished(String baseKey, Context c) {
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        boolean finished = settings.getBoolean(baseKey + "finished", false);

        return finished;
    }

    public static void setFinished(String baseKey, Context c, boolean finished) {
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        SharedPreferences.Editor edit = settings.edit();
        edit.putBoolean(baseKey + "finished", finished);
        edit.apply();
    }

    public static String getAddress(String baseKey, Context c) {
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        String address = settings.getString(baseKey + "address", "");

        return address;
    }

    public static void setAddress(String baseKey, Context c, String address){
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        SharedPreferences.Editor edit = settings.edit();
        edit.putString(baseKey + "address", address);
        edit.apply();
    }

    public static String getPrettyName(String baseKey){
        if(baseKey.equals(ChooseLocationScreen.baseKey))
            return "Set Accident Location";
        if(baseKey.equals(VictimQuestionScreen.baseKey))
            return "Anyone got injured?";
        if(baseKey.equals(PhotoViewScreen.baseKey))
            return "Take pictures";
        if(baseKey.equals(HealthQuestionScreen.baseKey))
            return "Check driver's state";
        if(baseKey.equals(ObstructQuestionScreen.baseKey))
            return "Make free way";
        if(baseKey.equals(DocumentsCheckScreen.baseKey))
            return "Check documents";
        if(baseKey.equals(InsuranceScreen.baseKey))
            return "Contact Roadside Assistance";
        if(baseKey.equals(OffendersStatement.baseKey))
            return "Offender's Statement";
        return "Unknown";
    }

    public static int getAccidents(String baseKey, Context c) {
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        int accidents = settings.getInt(baseKey + "accidents", 0);

        return accidents;
    }

    public static void setAccidents(String baseKey, Context c, int i){
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        SharedPreferences.Editor edit = settings.edit();
        edit.putInt(baseKey + "accidents", i);
        edit.apply();
    }

    public static long getAccidentDate(String baseKey, Context c, int i) {
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        long accidents = settings.getLong(baseKey + "accidents" + i + "date", 0);
        return accidents;
    }

    public static void setAccidentDate(String baseKey, Context c, int i, long date){
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        SharedPreferences.Editor edit = settings.edit();
        edit.putLong(baseKey + "accidents" + i + "date", date);
        edit.apply();
    }

    public static long getDonated(String baseKey, Context c) {
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        long donated = settings.getLong(baseKey + "donated", 0);
        return donated;
    }

    public static void setDonated(String baseKey, Context c, long donated){
        SharedPreferences settings = c.getSharedPreferences(baseKey, 0);
        SharedPreferences.Editor edit = settings.edit();
        edit.putLong(baseKey + "donated", donated);
        edit.apply();
    }



}
