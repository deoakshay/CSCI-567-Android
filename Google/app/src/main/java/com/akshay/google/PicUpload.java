package com.akshay.google;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class PicUpload extends Activity implements View.OnClickListener {

    private ImageButton btn_pic, btn_share;
    private Button btn_camera;
    private ImageView imageView;
    private TextView textView;
    private List<String> name1 = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_upload);
        btn_pic = (ImageButton)findViewById(R.id.btn_takephoto);
        btn_pic.setOnClickListener(this);
        btn_camera = (Button)findViewById(R.id.btn_save);
        btn_camera.setOnClickListener(this);
        btn_share = (ImageButton)findViewById(R.id.btn_share);
        btn_share.setOnClickListener(this);
        imageView =(ImageView)findViewById(R.id.iv_displayphoto);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pic_upload, menu);
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
        if(v.getId()==R.id.btn_takephoto) {

            Intent gallery = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(gallery, 1);

        }
        if(v.getId()==R.id.btn_save) {


            clickImage();
        }

        if(v.getId()==R.id.btn_share){



            Intent contactPickerIntent = new Intent(Intent.ACTION_PICK);
            contactPickerIntent.setType( ContactsContract.Contacts.CONTENT_TYPE);
            startActivityForResult(contactPickerIntent, 3);
        }
    }
    private File photofile;
    @TargetApi(Build.VERSION_CODES.FROYO)
    private void clickImage() {
        File photostorage = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        photofile = new File(photostorage, (System.currentTimeMillis())
                + ".jpg");

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photofile));
        startActivityForResult(i, 0);
    }


    Bitmap photo;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK && requestCode==1){
            Uri selectedImage=data.getData();
            String path=getPath(selectedImage);

            Bitmap bitmapImage= BitmapFactory.decodeFile(path);
            // imageView=(ImageView)findViewById(R.id.image);
            imageView.setImageBitmap(bitmapImage);

        }
        if (resultCode==RESULT_OK && requestCode==0)
        {
            try {

                photo = (Bitmap) data.getExtras().get("data");
            } catch (NullPointerException ex) {
                photo = BitmapFactory.decodeFile(photofile.getAbsolutePath());
            }

            if (photo != null) {
                imageView.setImageBitmap(photo);


            } else {

                Toast.makeText(this,
                        "Oops,can't get the photo from your gallery",
                        Toast.LENGTH_LONG).show();
            }

        }
        if(resultCode==RESULT_OK &&requestCode==3)
        {
            Uri contactData = data.getData();
            Cursor c =  getContentResolver().query(contactData, null, null, null, null);
            if (c.moveToFirst()) {
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.Data.DATA1));
                name1.add(name);

                textView.setText(c.toString());
            }
        }
    }

    public String getPath(Uri uri){
        String[] filePathColumn={MediaStore.Images.Media.DATA};

        Cursor cursor=getContentResolver().query(uri, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex=cursor.getColumnIndex(filePathColumn[0]);

        return cursor.getString(columnIndex);
    }
    public void onBackPressed(){
        Intent i= new Intent(this,LoggedIn.class);
        startActivity(i);
        PicUpload.this.finish();
    }
}
