package co.example.brian.timeractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class AlarmActivity extends AppCompatActivity {
    int hours, minutes;
    EditText hoursText, minutesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

    }
    //handles the alarm button

    public void onAlarmButtonClick(View v) {
        //associate EditText variable with widgets
        hoursText = (EditText) findViewById(R.id.hours);
        minutesText = (EditText) findViewById(R.id.minutes);
        //make sure widget text can be converted to int
        try {
            hours = Integer.parseInt(hoursText.getText().toString());
            minutes = Integer.parseInt(minutesText.getText().toString());
            //use AlarmClock intent
            Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_HOUR, hours)
                    .putExtra(AlarmClock.EXTRA_MINUTES, minutes);

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(alarmIntent, 0);
            boolean isIntentSafe = activities.size() > 0;
// Start an activity if it is safe
            if (isIntentSafe) {
                startActivity(alarmIntent);
            }
            else {
                hoursText.setText("No app to handle this.");
            }
            // catch exception
        }
        catch (NumberFormatException e) {
            hoursText.setText("One time not a number.");
        }
    }
}
