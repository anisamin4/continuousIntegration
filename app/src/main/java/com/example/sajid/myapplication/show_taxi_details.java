package com.example.sajid.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anees on 5/11/2018.
 */

public class show_taxi_details extends ArrayAdapter<request> {

private Activity context;
private List<request> ListOfComplain;
        ProgressBar progressBar;
        int counter;

public show_taxi_details(Activity context, List<request> ListOfComplain)
        {
        super(context,R.layout.request_view_user,ListOfComplain);
        this.context=context;
        this.ListOfComplain=ListOfComplain;
         counter =1;
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
        if(!complaintList.getMyTaxiDriver_Name().equals("non")){
                String b=String.valueOf(counter)+". Driver Name:  "+complaintList.getMyTaxiDriver_Name();
                head.setText(b);

                String a="Phone No : "+complaintList.getMyTaxiDriver_phonenumber()+" ::: Taxi no. "+ complaintList.getMyTaxi_number();
                body.setText(a);

        }else {
                head.setText(counter+" : Pending");
                body.setText("wait till admin assigns a taxi");
        }
counter++;
        return listViewItem;

        }
        }
