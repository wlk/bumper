package com.varwise.bumper;

/**
 * Created by rembam on 12.07.14.
 */
public class ScreenCheck {
    private int id;
    private int accidentId;
    private int screenId;

    public ScreenCheck() {};

    public ScreenCheck(int accidentId, int screenId){
        this.accidentId = accidentId;
        this.screenId = screenId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(int accidentId) {
        this.accidentId = accidentId;
    }
    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }
}
