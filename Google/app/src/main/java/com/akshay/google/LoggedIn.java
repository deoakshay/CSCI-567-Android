package com.akshay.google;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class LoggedIn extends Activity implements View.OnClickListener{

    private TextView t1,t2;


    private ImageButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);




        b1=(ImageButton)findViewById(R.id.imageButton_refresh);

        b1.setOnClickListener(this);

        b2=(ImageButton)findViewById(R.id.imageButton_add);

        b2.setOnClickListener(this);

        b3=(ImageButton)findViewById(R.id.imageButton_upload);

        b3.setOnClickListener(this);

        b4=(ImageButton)findViewById(R.id.imageButton_profile);

        b4.setOnClickListener(this);


        


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logged_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


String name1,profile1,photo,email1;
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imageButton_upload)
        {
            Intent i1=new Intent(this, PicUpload.class);
            startActivity(i1);
        }
        if (v.getId()==R.id.imageButton_profile)
        {
            Intent i = new Intent(this,Profile.class);
            startActivity(i);
        }
        if(v.getId()==R.id.imageButton_add)
        {
            Intent i = new Intent(this,Add_friends.class);
            startActivity(i);

        }

    }
}
