package com.laioffer.laiofferproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Neal on 10/27/15.
 */
public class RestaurantAdapter extends BaseAdapter {

    Context context;
    List<Restaurant> restauranData;

    public RestaurantAdapter(Context context) {
        this.context = context;
        restauranData = DataService.getRestaurantData();
    }

    @Override
    public int getCount() {
        return restauranData.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return restauranData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_restaurant_list_item,
                    parent, false);
        }

        TextView restaurantName = (TextView) convertView.findViewById(
                R.id.restaurant_name);
        TextView restaurantAddress = (TextView) convertView.findViewById(
                R.id.restaurant_address);
        TextView restaurantType = (TextView) convertView.findViewById(
                R.id.restaurant_type);

        Restaurant r = restauranData.get(position);
        restaurantName.setText(r.getName());
        restaurantAddress.setText(r.getAddress());
        restaurantType.setText(r.getType());

        return convertView;
    }

}
