package com.akshay.hello_world_akshay_deo;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import static com.akshay.hello_world_akshay_deo.R.id.hello_world_tv;


/**
 * A placeholder fragment containing a simple view.
 */
public class Hello_World_Akshay_DeoFragment extends Fragment {

    private View rootView;
    public Hello_World_Akshay_DeoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_hello__world__akshay__deo, container, false);
        //Initialize TextView Object to the textview we provided in our layout xml referencing the id we gave it
        //Activity rootView;
        TextView txt = (TextView) rootView.findViewById(hello_world_tv);
        //Replace the text in the textView with the following text.
        txt.setText("CSCI567 Hello World by Akshay Deo");
return rootView;
    }
}
