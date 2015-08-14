package com.akshay.assignment2_simpleui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;


/**
 * A placeholder fragment containing a simple view.
 */
public class SimpleUIFragment extends Fragment implements View.OnClickListener{

    private View rootView;
    private Button b1;
    private Button b2;
    private Button b3;
    private TextView t1;
    private TextView t2;
    private int b1i;
    private int b2i;
    public SimpleUIFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_simple_ui, container, false);
        b1=(Button) rootView.findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2= (Button) rootView.findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3= (Button) rootView.findViewById(R.id.button3);
        b3.setOnClickListener(this);
        t1=(TextView)rootView.findViewById(R.id.textView1);
        t1.setText("Count Text View 1: 0");
        t2=(TextView)rootView.findViewById(R.id.textView2);
        t2.setText("Count Text View 2: 0");
        b1i=0;
        b2i=0;
        return rootView;
    }




    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button1:
                b1i++;
                t1.setText("Count Text View 1: " + b1i);
                break;
            case R.id.button2:
                b2i--;
                t2.setText("Count Text View 2: "+ b2i);
               break;
            case R.id.button3:
                t1.setText("Count Text View 1: 0");
                t2.setText("Count Text View 2: 0");
                b1i=0;
                b2i=0;
                break;

        }

    }
}
