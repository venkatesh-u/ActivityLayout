package com.example.meghana.activitylayout;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<HousesInfor> {

    private Activity activity;
    private List<HousesInfor> list;

    public ListViewAdapter(Activity activity, int resource, List<HousesInfor> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        list=objects;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;

        // inflate layout from xml
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0; // determined by view type
        int viewType = getItemViewType(position);
        switch (viewType) {


        case 0:
        layoutResource = R.layout.evenrow;
        break;

        case 1:
        layoutResource = R.layout.oddrow;
        break;
    }

    if (convertView != null) {
        holder = (ViewHolder) convertView.getTag();
    } else {
        convertView = inflater.inflate(layoutResource, null);
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);
    }

    // set data to views

        holder.type.setImageResource(R.drawable.sample21);

    holder.name.setText(getItem(position).getName());

    return convertView;
}

private class ViewHolder {
    private ImageView type;
    private TextView name;

    public ViewHolder(View v) {
        type = (ImageView) v.findViewById(R.id.type_image);
        name=(TextView)v.findViewById(R.id.name);

    }
}

}




