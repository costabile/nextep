package com.jasoncostabile.nextep;

public class Show {
	public int iconID;
    public String title;
    
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
