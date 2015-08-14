package com.akshay.eventreciever;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.GpsStatus;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter f1 = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
         this.registerReceiver(reciever,f1);
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
    private final BroadcastReceiver reciever = new BroadcastReceiver() {
NotificationManager mgr;
        BluetoothAdapter m = BluetoothAdapter.getDefaultAdapter();

        public void onReceive(Context context, Intent intent) {
            if (m.isEnabled()) {
                Toast.makeText(context, "ON", Toast.LENGTH_SHORT).show();
                mgr=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                PendingIntent pIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);


                NotificationCompat.Builder notify_me = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(context.getString(R.string.alert))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("BLUETOOTH STATUS")).setContentText("ON");

                notify_me.setContentIntent(pIntent);
                mgr.notify(1, notify_me.build());



            }
            if (!m.isEnabled()) {
                Toast.makeText(context, "OFF", Toast.LENGTH_SHORT).show();
                mgr=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                PendingIntent pIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);


                NotificationCompat.Builder notify_me = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(context.getString(R.string.alert))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("BLUETOOTH STATUS")).setContentText("OFF");

                notify_me.setContentIntent(pIntent);
                mgr.notify(1, notify_me.build());
            }
        }
    };

}