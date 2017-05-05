package co.example.brian.timeractivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class TimerActivity extends AppCompatActivity {
    EditText messageText, duration;
    int time;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
    }
    //associate EditText variable with widgets
    public void onEnterButtonClick(View v) {
        //associate EditText variable with widgets
        messageText = (EditText) findViewById(R.id.message);
        duration = (EditText) findViewById(R.id.duration);
        message = messageText.getText().toString();
        //make sure widget text can be converted to int
        try {
            time = Integer.parseInt(duration.getText().toString());
            //use AlarmClock intent
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_LENGTH, time)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
            //start activity if you can

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
            boolean isIntentSafe = activities.size() > 0;
// Start an activity if it is safe
            if (isIntentSafe) {
                startActivity(intent);
            }
            else {
                messageText.setText("No app to handle this.");
            }
        }

        // catch exception
        catch(NumberFormatException e){
            duration.setText("Not a number.");
        }
        //start alarm activity from timer activity??
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
        super.finish();
    }
}
