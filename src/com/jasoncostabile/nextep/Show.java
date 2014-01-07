package com.jasoncostabile.nextep;

import java.util.Calendar;

public class Show {
	public int iconID;
    public String title;
    public int nextEpisode;
    public String nextAirdate;
    
    public Show(){
        super();
    }
    
    public Show(int iconID, String title) {
        super();
        
        this.iconID = iconID;
        this.title = title;
    }
    
    @Override
    public String toString() {
    	return title;
    }
}
