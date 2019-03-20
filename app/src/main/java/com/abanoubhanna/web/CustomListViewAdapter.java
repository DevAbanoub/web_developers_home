package com.abanoubhanna.web;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

class CustomListViewAdapter extends ArrayAdapter<String>{
    public CustomListViewAdapter(Context context, String[] colorz) {
        super(context, R.layout.color_list_item ,colorz);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.color_list_item, parent, false);

        String colorPos = getItem(position);
        TextView colorName = (TextView) customView.findViewById(R.id.colorName);
        LinearLayout layout = (LinearLayout) customView.findViewById(R.id.linearLayout);

        colorName.setText(colorPos);
        int[] colorz = {0xFFF44336, 0xFFE91E63, 0xFF9C27B0, 0xFF673AB7,0xFF3F51B5,
                0xFF2196F3,0xFF03A9F4,0xFF00BCD4,0xFF009688,0xFF4CAF50,0xFF8BC34A,
                0xFFCDDC39,0xFFFFEB3B,0xFFFFC107,0xFFFF9800,0xFFFF5722,0xFF795548,
                0xFF9E9E9E,0xFF607D8B};
        layout.setBackgroundColor(colorz[position]);

        return customView;
    }
}
