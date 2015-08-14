package com.akshay.contacts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button contact;
    private Button select;

    private ListView listView;
    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact=(Button) findViewById(R.id.contactupload);
        contact.setOnClickListener(this);
        select=(Button)findViewById(R.id.btnDone);
        select.setOnClickListener(this);
        editText=(EditText)findViewById(R.id.txt_searchContact);
        listView=(ListView)findViewById(R.id.lst_contactList);
        checkBox=(CheckBox)findViewById(R.id.chkbxContact);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.contactupload)
        {
            final int request_code = 1010;
            startActivityForResult(new Intent(this,MainActivity.class),request_code);
        }
    }
}
