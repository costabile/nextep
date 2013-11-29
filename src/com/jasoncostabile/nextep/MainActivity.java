package com.jasoncostabile.nextep;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.view.ViewGroup;

//TheTVDB API key in privnotes.txt

//TODO finish show row layout (line things up horizontally, add next episode airdate + current episode num fields)
//TODO detail screen for show when clicked on?
//TODO adding, deleting shows
//TODO get info from TheTVDB
//TODO button to refresh data
//TODO fix app icon

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

}
