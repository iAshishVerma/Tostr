package com.example.android.tostr;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    int hrs,min;
    public static  final String EXTRA_MESSAGE="com.example.android.tostr.MESSAGE";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
   //  Switch aSwitch = (Switch)findViewById(R.id.switch_button);
//    boolean isSwitched =aSwitch.isChecked();

//    EditText ed =(EditText) findViewById(R.id.edit);
//       msg =ed.getText().toString();



    public  void set(View view){

        EditText hours =(EditText) findViewById(R.id.edithour);
     hrs =Integer.parseInt(hours.getText().toString());
        EditText mins =(EditText) findViewById(R.id.editmin);
       min =Integer.parseInt(mins.getText().toString());


        alarmMgr = (AlarmManager)Main2Activity.this.getSystemService(Context.ALARM_SERVICE);
        //Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Main2Activity.this, AlarmReceiver.class);
        EditText customText =(EditText) findViewById(R.id.edit);
        String    message =customText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);

        alarmIntent = PendingIntent.getBroadcast(Main2Activity.this, 0, intent, 0);

// Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hrs);
        calendar.set(Calendar.MINUTE, min);

// setRepeating() lets you specify a precise custom interval--in this case,
// 20 minutes.
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 /* this is the interval*/, alarmIntent);
    }

    public void cancelAlarm(View view) {
        if (alarmMgr != null) {
            alarmMgr.cancel(alarmIntent);
            Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
        }
    }
}
