package com.varwise.bumper;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rembam on 12.07.14.
 */
public class AccidentInformation {


    private int number;
    private Date date;

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDateSimpleFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
        Log.d("AccidentInforamtion", number+"");
        String dateString;
        if(date!=null)
            dateString = " accident date: " + sdf.format(date);
        else
            dateString = "";
        return dateString;
    }
}
