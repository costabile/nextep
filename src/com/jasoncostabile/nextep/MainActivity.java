package com.jasoncostabile.nextep;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//TheTVDB API key in privnotes.txt

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//TODO replace ArrayAdapter with SimpleCursorAdapter to get show info
		String[] exampleRows = {"String1", "String2", "String3", "String4", "String5", "String6"};
		ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exampleRows);

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
