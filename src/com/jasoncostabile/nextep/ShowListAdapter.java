package com.jasoncostabile.nextep;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//reference: http://sogacity.com/how-to-make-a-custom-arrayadapter-for-listview/

public class ShowListAdapter extends ArrayAdapter<Show> {
	private ArrayList<Show> shows;
	private Activity activity;
	
	public ShowListAdapter(Activity a, int textViewResourceId, ArrayList<Show> shows) {
        super(a, textViewResourceId, shows);
        
        this.shows = shows;
        this.activity = a;
    }
	
	public static class ViewHolder {
        public ImageView icon;
        public TextView title;
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
        ViewHolder holder;
        if (v == null) {
            LayoutInflater vi =
                (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.showlist_row, null);
            holder = new ViewHolder();
            holder.icon = (ImageView)v.findViewById(R.id.imgIcon);
            holder.title = (TextView)v.findViewById(R.id.txtTitle);
            v.setTag(holder);
        }
        else
            holder = (ViewHolder)v.getTag();
        
        final Show show = shows.get(position);
        if (show != null) {
            //holder.icon.setImageResource(show.iconID);
        	Drawable image = null;
        	image = new BitmapDrawable(BitmapFactory.decodeByteArray(show.icon, 0, show.icon.length));
            holder.icon.setImageDrawable(image);
            holder.icon.setContentDescription(show.title + " " + activity.getString(R.string.thumbnail));
            holder.title.setText(show.title);
        }
        
        return v;
	}
}
