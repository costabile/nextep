package com.jasoncostabile.nextep;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//reference: http://www.codeproject.com/Articles/119293/Using-SQLite-Database-with-Android

public class DatabaseHelper extends SQLiteOpenHelper {
	static final String dbName = "NextEpDB";
	static final String showTable = "Shows";
	static final String colID = "ShowID";
	static final String colTitle = "Title";
	static final String colIcon = "Icon";
	static final String colNextEpisode = "NextEpisode";
	static final String colNextAirdate = "NextAirdate";		//stored as milliseconds since Jan. 1, 1970

	public DatabaseHelper(Context context) {
		super(context, dbName, null, 1);	//increment database version number when a DB upgrade is required.
											//onUpgrade() will be invoked.
	}

	public void onCreate(SQLiteDatabase db) {
		
		 db.execSQL("CREATE TABLE " + showTable + " ( "
				 + colID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				 + colTitle + " TEXT, "
				 + colIcon + " TEXT, "
				 + colNextEpisode + " Integer, "
				 + colNextAirdate + " Integer "
				 + ");");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + showTable);

		onCreate(db);
	}
	
	public void insert(Show show) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(colTitle, show.title);
		cv.put(colNextEpisode, show.nextEpisode);
		cv.put(colNextAirdate, show.nextAirdate);
		db.insert(showTable, colID, cv);

		db.close();
	}
	
	public int update(Show show)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();

		cv.put(colTitle, show.title);
		cv.put(colNextEpisode, show.nextEpisode);
		cv.put(colNextAirdate, show.nextAirdate);
		return db.update(showTable, cv, colID+"=?", 
				new String[]{String.valueOf(show.ID)});   
	}
	
	public void delete(int showID)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete(showTable, colID+"=?", new String[]{String.valueOf(showID)});
		
		db.close();
	}
	
	public ArrayList<Show> getShows()
	{
		SQLiteDatabase db = this.getReadableDatabase();
		
		String[] columns = new String[]{colID, colTitle, colIcon, colNextEpisode, colNextAirdate};
		Cursor c = db.query(showTable, columns, null, null, null, null, null);
		
		int id = c.getColumnIndex(colID);
		int title = c.getColumnIndex(colTitle);
		int icon = c.getColumnIndex(colIcon);
		int nextEpisode = c.getColumnIndex(colNextEpisode);
		int nextAirdate = c.getColumnIndex(colNextAirdate);
		ArrayList<Show> shows = new ArrayList<Show>();
		while (c.moveToNext()) {
			Show show = new Show(c.getString(title), c.getInt(icon));
			show.ID = c.getInt(id);
			show.nextEpisode = c.getInt(nextEpisode);
			show.nextAirdate = c.getLong(nextAirdate);
			
			shows.add(show);
		}

		c.close();
		db.close();
		
		return shows;
	}
}
