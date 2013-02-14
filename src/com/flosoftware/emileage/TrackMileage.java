package com.flosoftware.emileage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.flosoftware.emileage.activity.UserActivity;
import com.flosoftware.emileage.activity.UserListActivity;


import java.text.DecimalFormat;
import java.util.Date;

public class TrackMileage extends Activity {
    private static final String TAG = "TrackMileage";
    private Date date;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem addUser = (MenuItem)menu.findItem(R.id.addUser);
        addUser.setIntent(new Intent(this, UserActivity.class));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){
            case R.id.addUser:
                intent = new Intent(TrackMileage.this, UserActivity.class);
                startActivity(intent);
                return true;
            case R.id.editUser:
                intent = new Intent(TrackMileage.this, UserListActivity.class);
                startActivity(intent);
                return true;
        }
        return false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ToggleButton startStop = (ToggleButton) findViewById(R.id.startstop);
        final ToggleButton pauseUnPause = (ToggleButton) findViewById(R.id.Pause);
        final Button sync = (Button) findViewById(R.id.sync);


        super.onCreate(savedInstanceState);


        // set view
        setContentView(R.layout.main);

        /*Log.v(TAG, "TrackMileage.Main");

        date = new Date();*/

       /* LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, new LocationListener() {
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            public void onProviderEnabled(String provider) {
                // called when the provider is enabled by the user
            }

            public void onProviderDisabled(String provider) {
                if (provider.equalsIgnoreCase(LocationManager.GPS_PROVIDER)){
                    //Toast.makeText(OutdoorRunActivity.this, "Can't Run without GPS Provider", Toast.LENGTH_LONG).show();
                }
            }

            public void onLocationChanged(Location location) {

                if (startStop.isChecked()){
                    //run.setCurrentLocation(location);
                    updateView(location);
                    //locationCount = locationCount + 1;

                }

            }
        });*/
    }

    private void updateView(Location location){
        Toast.makeText(TrackMileage.this, "Update View", Toast.LENGTH_SHORT).show();
        // do whatever you want with the coordinates

        DecimalFormat df = new DecimalFormat("####.##");

       /* View empSpeed = findViewById(R.id.startLocation);
        ((TextView)empSpeed).setText(location.);

        View empPace = findViewById(R.id.pace);
        ((TextView)empPace).setText(String.format("%s min/mile", run.getImperialPace()));

        View empDistance = findViewById(R.id.distance);
        ((TextView)empDistance).setText(String.format("%s mile(s)", df.format(run.getImperialDistance())));*/

    }

}
