package com.jasoncostabile.nextep;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

//TheTVDB API key in privnotes.txt

//TODO in progress: add DB
	//have the insert method auto-increment ID instead of inserting 1
	//add column for Icons
//TODO add nextEp, nextAirdate stuff to Show.java. store date as Calendar?
//TODO detail screen for show when clicked on? + edit current ep
//TODO watched button onClick (increment next episode). Disable when not aired yet?
//TODO adding, deleting shows
//TODO get info from TheTVDB
//TODO button to refresh data
//TODO fix app icon
//TODO use dark theme
//TODO menu (settings, donate?, ...)

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//----Example show list; remove once real show list is implemented
		ArrayList<Show> exampleShows = new ArrayList<Show>();
		for (int i = 0; i <= 5; ++i) {
			exampleShows.add(i, new Show(R.drawable.show_icon_default, "show" + i));
		}
		//----
		ShowListAdapter adapter = new ShowListAdapter(this, R.layout.showlist_row, exampleShows);

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
