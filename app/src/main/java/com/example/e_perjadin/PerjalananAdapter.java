package com.example.e_perjadin;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

import java.util.List;


public class PerjalananAdapter extends ArrayAdapter<Perjalanan> {
    private Context context;
    private List<Perjalanan> perjalananList;

    public PerjalananAdapter(Context context, List<Perjalanan> perjalananList) {
        super(context, 0, perjalananList);
        this.context = context;
        this.perjalananList = perjalananList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Implement your custom adapter logic here
        // This method is responsible for inflating the layout for each item in the ListView
        // and binding the data from the Perjalanan object to the corresponding views in the layout

        return convertView;
    }
}
