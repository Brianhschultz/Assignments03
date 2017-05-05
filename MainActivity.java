package co.example.brian.timeractivity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //handles timer button
    public void onTimerButtonClick(View v){
        Intent timerIntent = new Intent(this, TimerActivity.class);
        startActivity(timerIntent);
    }
    //handles alarm button
    public void onAlarmButtonClick(View v){
        Intent alarmIntent = new Intent(this, AlarmActivity.class);
        startActivity(alarmIntent);
    }
    //handles exit button
    public void onExitButtonClick(View v){
        finish();
        System.exit(0);
    }
}
