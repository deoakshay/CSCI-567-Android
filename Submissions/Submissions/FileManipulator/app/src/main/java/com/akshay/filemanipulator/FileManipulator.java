package com.akshay.filemanipulator;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class FileManipulator extends Activity implements View.OnClickListener{

    private Button bread;
    private Button bwrite;
    private Button bappend;
    private TextView textView1;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manipulator);
        bread = (Button)findViewById(R.id.button_read);
        bread.setOnClickListener(this);
        bwrite=(Button)findViewById(R.id.button_write);
        bwrite.setOnClickListener(this);
        bappend=(Button)findViewById(R.id.button_replace);
        bappend.setOnClickListener(this);
        editText=(EditText)findViewById(R.id.editText);
        editText.setOnClickListener(this);
        textView1=(TextView)findViewById(R.id.textView);
        textView1.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_file_manipulator, menu);
        return true;
    }
private String input;
    private String output;

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
        if (v.getId()==R.id.button_replace)
        {

            replace();
            textView1.setText(" ");
            editText.setText(" ");
        }
        if (v.getId()==R.id.button_read)
        {
            read();
            editText.setText(" ");

        }
        if(v.getId()==R.id.button_write)
        {
            write();
            editText.setText(" ");

        }

    }
    private String fpath = "/sdcard/akshay.txt";
    private void replace() {

        //Toast.makeText(getBaseContext(),"Replace",Toast.LENGTH_SHORT).show();
        if (editText.getText().toString() != "") {
            File f = new File(fpath);
            if (f.exists()) {
                boolean d = f.delete();
            }
            write();

        }

    }
    private void write() {
        input = editText.getText().toString();
        if (!input.equals("")) {
            try {

                 input= "\r\n" +input;
                File file = new File(fpath);

                // If file does not exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(input);
                bw.close();

                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();


            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void read() {
        input= editText.getText().toString();
        if(!input.matches(""))
    {
       BufferedReader bufferedReader;
        StringBuffer o = new StringBuffer();
        try {
            bufferedReader= new BufferedReader(new FileReader(fpath));
            while ((output=bufferedReader.readLine())!=null)
            {
                o.append(output+"\r\n");
            }
            textView1.setText(o.toString());
            textView1.setMovementMethod(new ScrollingMovementMethod());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
    }

