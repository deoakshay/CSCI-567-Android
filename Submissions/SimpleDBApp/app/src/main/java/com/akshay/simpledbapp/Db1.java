package com.akshay.simpledbapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Db1 extends Activity implements View.OnClickListener{

  private  Button button_add;
    private Button button_get;
    private TextView t1;
    private EditText et;
    private Database db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db1);

        button_add=(Button)findViewById(R.id.button_add);
        button_add.setOnClickListener(this);
        button_get=(Button)findViewById(R.id.button_get);
        button_get.setOnClickListener(this);
        t1=(TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editText);
       db = new Database(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_db1, menu);
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

        String to,from;

        if(v.getId()==R.id.button_add)
        {
          to=et.getText().toString();
     if(!to.matches("")) {
         db.database(to);
     }
            et.setText("");
            //Log.d("Insertion method",to);
        }

        if(v.getId()==R.id.button_get) {
            Toast.makeText(getBaseContext(),"GET",Toast.LENGTH_SHORT).show();
            from = db.data();
            if (!from.matches("")) {
             t1.setText("");
                t1.setText(from);
            }
        }
    }
}
