package com.jasoncostabile.nextep;

import android.content.ContentValues;
import android.content.Context;
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
	static final String colNextAirdate = "NextAirdate";

	public DatabaseHelper(Context context) {
		super(context, dbName, null, 1);	//increment database version number when a DB upgrade is required.
											//onUpgrade() will be invoked.
	}

	public void onCreate(SQLiteDatabase db) {
		
		 db.execSQL("CREATE TABLE " + showTable + " ( "
				 + colID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				 + colTitle + " TEXT, "
				 + colNextEpisode + " Integer, "
				 + colNextAirdate + " TEXT "
				 + ");");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + showTable);

		onCreate(db);
	}
	
	public void insert(Show show) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(colID, 1);
		cv.put(colTitle, show.title);
		cv.put(colNextEpisode, show.nextEpisode);
		cv.put(colNextAirdate, show.nextAirdate);
		db.insert(showTable, colID, cv);

		db.close();
	}
}
