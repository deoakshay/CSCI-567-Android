package com.akshay.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private View rootView;
    private File im1;
    private Bitmap photo;
    private int pp=0;
    private ImageView im=(ImageView)rootView.findViewById(R.id.current_image);
    private Button shr;
    private Button gallery;
    private Button capture;
    private Button save;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_main, container, false);
        shr=(Button) rootView.findViewById(R.id.share_btn);
        //shr.setOnClickListener(this);
        save=(Button) rootView.findViewById(R.id.save_btn);
        //save.setOnClickListener(this);
        capture=(Button) rootView.findViewById(R.id.capture_btn);
        //capture.setOnClickListener(this);
        gallery=(Button) rootView.findViewById(R.id.gallery_btn);
        //gallery.setOnClickListener(this);

        return rootView;
    }
    public void onClick(View v) {


        File ims= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        switch (v.getId())
        {
            case R.id.share_btn:

                break;
            case R.id.save_btn:
                im.setDrawingCacheEnabled(true);
                final Bitmap al=im.getDrawingCache();
                String filepath = Environment.getExternalStorageDirectory().toString();
                File strfile= new File(filepath + "/ll");
                strfile.mkdirs();
                Random gen = new Random();
                int n= gen.nextInt(10000);
                String picname= "Pic-"+n+".jpg";
                final File p= new File(strfile,picname);
                if(p.exists())
                {
                    AlertDialog.Builder adb= new AlertDialog.Builder(im.getContext());
                    adb.setTitle("Alert");
                    adb.setMessage("Do you want to replace??").setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            try {
                                                FileOutputStream o = new FileOutputStream(p);
                                                al.compress(Bitmap.CompressFormat.JPEG, 100, o);
                                                o.flush();
                                                o.close();
                                                Toast.makeText(im.getContext(), "Saved", Toast.LENGTH_SHORT).show();

                                            } catch (Exception e) {

                                            }
                                        }
                                    }

                            )
                            .setNegativeButton("No", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                }
                else
                {
                    try {
                        FileOutputStream o = new FileOutputStream(p);
                        al.compress(Bitmap.CompressFormat.JPEG, 100, o);
                        o.flush();
                        o.close();
                        Toast.makeText(im.getContext(),"Saved",Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {

                    }

                }
                break;
            case R.id.capture_btn:
                im1=new File(ims,(System.currentTimeMillis()) + ".jpg");
                Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);///start camera
                i.putExtra(MediaStore.ACTION_IMAGE_CAPTURE, Uri.fromFile(im1));
                startActivityForResult(i, pp);
                break;
            case R.id.gallery_btn:
                break;

        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==pp)
        {
            try{
                photo=(Bitmap) data.getExtras().get("i");

            }catch (NullPointerException e){
                photo= BitmapFactory.decodeFile(im1.getAbsolutePath());

            }
            if(photo!=null)
            {
                im.setImageBitmap(photo);

            }
            else {
                Toast.makeText(im.getContext(), "Photo Cannot be selected", Toast.LENGTH_LONG).show();
            }
        }
    }
}
