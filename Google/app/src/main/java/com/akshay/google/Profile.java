package com.akshay.google;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class Profile extends Activity implements View.OnClickListener{

    private String name, email,photo,profile_link;

    private TextView t1,t2;

    private ImageView imageView;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        t1=(TextView)findViewById(R.id.textView);

        t2=(TextView)findViewById(R.id.textView2);

        imageView=(ImageView)findViewById(R.id.imageView);

        Intent i1= getIntent();

        email  = i1.getStringExtra("Email");

        t2.setText(email);

        name = i1.getStringExtra("Name");

        t1.setText(name);

        photo= i1.getStringExtra("Photo");

        profile_link=i1.getStringExtra("Profile Link");

        button=(Button)findViewById(R.id.sign_out_button);
        button.setOnClickListener(this);
        t2.setText(email);
        t1.setText(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(this,LoggedIn.class);
        startActivity(intent);
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

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.sign_out_button)
        {

            MainActivity mainActivity = null;
            mainActivity.onStop();
        }
    }
}
