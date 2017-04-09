package vasu.gro.gef.grosiri;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vasu.grosiri.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Shivangi Jain on 3/18/2017.
 */

public class LocationDemo extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final String APP_ID = "AIzaSyCMGmZNqhbmHMH_uK6hED0FPP-Q4XOd7W4";

    private static final int PERMISSION_ACCESS_COARSE_LOCATION = 1;
    private static final String TAG ="HELLO" ;
    private GoogleApiClient googleApiClient;
 TextView t1;
    Spinner spinner2;
    Spinner spinner3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getalert);
            t1 = (TextView) findViewById(R.id.textView11);
             b1 = (Button) findViewById(R.id.button3);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { android.Manifest.permission.ACCESS_COARSE_LOCATION },
                    PERMISSION_ACCESS_COARSE_LOCATION);
        }

        googleApiClient = new GoogleApiClient.Builder(this, this, this).addApi(LocationServices.API).build();

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("route 1: rosa parks rts downtown station to butler plaza transfer station ");
        list.add("route 2: rosa parks rts downtown station to ne walmart supercenter");
        list.add("route 3: rosa parts rts downtown station to n main post office");
        list.add("route 5: rosa parks rts downtown station to oaks mall");
        list.add("route 6: rosa parks rts downtown station to n walmart supercenter ");
        list.add("route 7: rosa parks rts downtown station to eastwood meadows ");
        list.add("route 9: reitz union to hunters run ");
        list.add("route 10: rosa parks rts downtown station to santa fe ");
        list.add("route 11: rosa parks rts downtown station to eastwood meadows ");
        list.add("route 12: reitz union to butler plaza");
        list.add("route 13: beaty towers to cottage grove apartments");
        list.add("route 15: rosa parks rts downtown station to nw 13th street ");
        list.add("route 16: beaty towers to sugar hill");
        list.add("route 17: beaty towers to rosa parks rts downtown station");
        list.add("route 19: reitz union to sw 23rd terrace");
        list.add("route 20: reitz union to oaks mall");
        list.add("route 23: oaks mall to santa fe (via fort clarke blvd)");
        list.add("route 24: rosa parks rts downtown station to job corps ");
        list.add("route 25A: uf commuter lot to airport ");
        list.add("route 25B: uf cultural plaza to airport ");
        list.add("route 26: rosa parks rts downtown station to airport");
        list.add("route 27: downtown to ne walmart supercenter");
        list.add("route 28: the hub to forest park");
        list.add("route 29: beaty towers to kiwanis park");
        list.add("route 34: the hub to lexington crossingroute 35: reitz union to sw 35th place");
        list.add("route 36: reitz union to sw 34th st. post office");
        list.add("route 37: reitz union to butler plaza(lowes)");
        list.add("route 38: the hub to gainesville place");
        list.add("route 39: santa fe to airport");
        list.add("route 40: the hub to hunters crossing");
        list.add("route 43: shands to santa fe ");
        list.add("route 46: reitz union to rosa parks rts downtown station");
        list.add("route 62: oaks mall to lexington crossing\n");
        list.add("route 75: oaks mall to butler plaza transfer station ");
        list.add("route 76: santa fe to haile market square");
        list.add("route 77: santa fe to cabana beach apts");
        list.add("route 711: rosa parks rts downtown station to eastwood meadows");



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<String> list1 = new ArrayList<String>();
        list1.add("Walmart");
        list1.add("Publix");
        list1.add("Trader Joe");
        list1.add("Sam's Club");
        list1.add("Target");
        list1.add("Dollar Tree");
        list1.add("Dollar General");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduleNotification(getNotification("Seems like you are near bus stop you can plan your meal."), 5000);
                //scheduleNotification(getNotification("Walmart is near by please check your fridge."), 10000);
            }
        });


    }

    private void scheduleNotification(Notification notification, int delay) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Gro-Siri");
        builder.setContentText(content);
        Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.siri);
        builder.setSound(sound);

        builder.setSmallIcon(R.drawable.alert);
        return builder.build();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // All good!
                } else {
                    Toast.makeText(this, "Need your location!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(MainActivity.class.getSimpleName(), "Connected to Google Play Services!");

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

            double lat = lastLocation.getLatitude(), lon = lastLocation.getLongitude();
            String l1 = Double.toString(lat);
            String l2 = Double.toString(lon);
            try{
                Geocoder geo = new Geocoder(LocationDemo.this.getApplicationContext(), Locale.getDefault());
                List<Address> addresses = geo.getFromLocation(lat, lon, 1);
                if (addresses.isEmpty()) {
                    t1.setText("Waiting for Location");
                }
                else {
                    if (addresses.size() > 0) {
                       /* Log.d(TAG,addresses.get(0).getFeatureName() + ","+
                                " + addresses.get(0).getLocality() +",
                                " + addresses.get(0).getAdminArea() + ",
                                " + addresses.get(0).getCountryName()"); */
                        t1.setText(addresses.get(0).getAddressLine(0));

                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

           // String units = "imperial";
           // String url = String.format("http://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=%s&appid=%s",
                 //   lat, lon, units, APP_ID);

        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(MainActivity.class.getSimpleName(), "Can't connect to Google Play Services!");
    }



}
