package com.example.sajid.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anees on 5/11/2018.
 */

public class Show_request_list extends ArrayAdapter<request> {

    private Activity context;
    private List<request> ListOfComplain;
    ProgressBar progressBar;

    public Show_request_list(Activity context, List<request> ListOfComplain)
    {
        super(context,R.layout.request_view_user,ListOfComplain);
        this.context=context;
        this.ListOfComplain=ListOfComplain;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //  super.getView(position, convertView, parent);
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.request_view_user, null,true);
        TextView head= (TextView) listViewItem.findViewById(R.id.head);
        TextView body= (TextView) listViewItem.findViewById(R.id.body);

        request complaintList=ListOfComplain.get(position);
        head.setText(complaintList.getMyRider_Name());

         String a=complaintList.getMyRider_time()+" "+ complaintList.getMyRider_place();
        body.setText(a);

        return listViewItem;

    }
}
