package com.jasoncostabile.nextep;

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

	// static final String deptTable="Dept";
	// static final String colDeptID="DeptID";
	// static final String colDeptName="DeptName";

	// static final String viewShows = "ViewShows";

	public DatabaseHelper(Context context) {
		super(context, dbName, null, 1);
	}

	public void onCreate(SQLiteDatabase db) {
		/*
		 * db.execSQL("CREATE TABLE "+deptTable+" ("+colDeptID+
		 * " INTEGER PRIMARY KEY , "+ colDeptName+ " TEXT)");
		 */

		//----continue from here
		
		/*
		 * db.execSQL("CREATE TABLE " + showTable + " (" + colID +
		 * " INTEGER PRIMARY KEY AUTOINCREMENT, " + colTitle + " TEXT, " +
		 * colNextEpisode + " Integer, " + colNextEpisode +
		 * " INTEGER NOT NULL, FOREIGN KEY (" + colDept + ") REFERENCES " +
		 * deptTable + " (" + colDeptID + "));");
		 */

		/*
		 * db.execSQL("CREATE TRIGGER fk_empdept_deptid " + " BEFORE INSERT "+
		 * " ON "+showTable+
		 * 
		 * " FOR EACH ROW BEGIN"+
		 * " SELECT CASE WHEN ((SELECT "+colDeptID+" FROM "+deptTable+" WHERE
		 * "+colDeptID+"=new."+colDept+" ) IS NULL)"+
		 * " THEN RAISE (ABORT,'Foreign Key Violation') END;"+ "  END;");
		 */

		/*
		 * db.execSQL("CREATE VIEW "+viewShows+
		 * " AS SELECT "+employeeTable+"."+colID+" AS _id,"+
		 * " "+employeeTable+"."+colName+","+ " "+employeeTable+"."+colAge+","+
		 * " "+deptTable+"."+colDeptName+""+
		 * " FROM "+employeeTable+" JOIN "+deptTable+
		 * " ON "+employeeTable+"."+colDept+" ="+deptTable+"."+colDeptID );
		 */
		// Inserts pre-defined departments
		// InsertDepts(db);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + showTable);
		// db.execSQL("DROP TABLE IF EXISTS " + deptTable);

		db.execSQL("DROP TRIGGER IF EXISTS dept_id_trigger");
		db.execSQL("DROP TRIGGER IF EXISTS dept_id_trigger22");
		// db.execSQL("DROP TRIGGER IF EXISTS fk_empdept_deptid");
		// db.execSQL("DROP VIEW IF EXISTS " + viewShows);
		onCreate(db);
	}
}
