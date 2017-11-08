package com.example.android.tostr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        // For our recurring task, we'll just display a message
      String message = arg1.getStringExtra(Main2Activity.EXTRA_MESSAGE);
        Toast.makeText(arg0, message, Toast.LENGTH_LONG).show();

    }

}

//import android.content.BroadcastReceiver;
//        import android.content.Context;
//        import android.content.Intent;
//        import android.support.v7.app.AppCompatActivity;
//        import android.os.Bundle;
//        import android.widget.Toast;
//
//public class AlarmReceiver extends BroadcastReceiver {
//    Toast b;
//    public void onReceive(Context context, Intent intent) {
//        Toast t =   Toast.makeText(this,"Ashish",Toast.LENGTH_LONG);
//        t.show();
//    }
//}