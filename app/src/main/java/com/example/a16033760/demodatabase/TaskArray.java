package com.example.a16033760.demodatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskArray extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    int resource;
    private Context context;
    private TextView tvID;
    private TextView tvDesc;
    private TextView tvDate;

    public TaskArray(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        this.context = context;
        this.task = objects;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvID = (TextView) rowView.findViewById(R.id.tvID);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);

        Task data = task.get(position);

        tvID.setText(""+data.getId());
        tvDesc.setText(data.getDescription());
        tvDate.setText(data.getDate());

        return rowView;
    }
}
