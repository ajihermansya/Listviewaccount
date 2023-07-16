package com.example.listviewexternalorsql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listviewexternalorsql.Model.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<User> implements View.OnClickListener {
    private ArrayList<User> dataSet;
    Context mContext;

    public CustomAdapter(ArrayList<User> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;
    }


    @Override
    public void onClick(View view) {

    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        User dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);

        TextView tvUser = convertView.findViewById(R.id.txtUsernameList);
        TextView tvEmail = convertView.findViewById(R.id.txtEmailList);


        String uname = this.dataSet.get(position).username;
        tvUser.setText(uname);
        tvEmail.setText(this.dataSet.get(position).email);

        // Return the completed view to render on screen
        return convertView;
    }
}
