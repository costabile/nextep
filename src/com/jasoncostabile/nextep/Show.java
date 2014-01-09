package com.jasoncostabile.nextep;

public class Show {
	public int ID;
	public int iconID;
    public String title;
    public int nextEpisode;
    public int nextAirdate;			//milliseconds since Jan 1, 1970
    
    public Show(){
        super();
    }
    
    public Show(int showID, int iconID, String title) {
        super();
        
        this.ID = showID;
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
