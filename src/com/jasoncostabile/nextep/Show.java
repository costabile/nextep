package com.jasoncostabile.nextep;

public class Show {
	public int ID;				//used to find this show in the local DB
	public int iconID;
    public String title;
    public int nextEpisode;
    public long nextAirdate;	//milliseconds since Jan 1, 1970
    
    public Show(){
        super();
    }
    
    public Show(String title, int iconID) {
        super();
        
        this.ID = -1;	//-1 indicates that the show was not retrieved from the local database
        
        this.iconID = iconID;
        this.title = title;
        
        this.nextEpisode = 101;
        this.nextAirdate = 0;
    }
    
    @Override
    public String toString() {
    	return title;
    }
}
