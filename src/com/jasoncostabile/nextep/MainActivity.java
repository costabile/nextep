package com.jasoncostabile.nextep;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

//TheTVDB API key in privnotes.txt

//TODO add Icon column to all DB methods
//TODO check that show icon stuff works
//TODO db methods: check and return whether successful
//TODO show list should be orderable
//TODO option to set time zone. Apply to date display.
//TODO nextAirdate: representations for airdate unknown and show ended
//TODO detail screen for show when clicked on? + edit current ep
//TODO watched button onClick (increment next episode). Disable when not aired yet?
//TODO adding, deleting shows
//TODO get info from TheTVDB
	//add tvdbID to Show class/db table? add unique constraint on tvdbID
//TODO button to refresh data
//TODO fix app icon
//TODO use dark theme
//TODO menu (settings, donate?, ...)

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DatabaseHelper db = new DatabaseHelper(this);
		
		ArrayList<Show> shows = db.getShows();
		ShowListAdapter adapter = new ShowListAdapter(this, R.layout.showlist_row, shows);

		ListView showList = (ListView)findViewById(R.id.showList);
		showList.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showClick(View view) {
		new AlertDialog.Builder(this)
		    .setTitle("Show click")
		    .setMessage("Show")
		    .show();
	}
	
	public void watchedClick(View view) {
		new AlertDialog.Builder(this)
		    .setTitle("Watched click")
		    .setMessage("Watched")
		    .show();
	}
}
