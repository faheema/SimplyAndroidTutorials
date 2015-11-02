package fam.sa.simplebroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyPhoneReceiver extends BroadcastReceiver {
    Context context;

    public MyPhoneReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            // This code will execute when the phone has an incoming call

            // get the phone number
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "Call from:" + incomingNumber, Toast.LENGTH_LONG).show();

        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                TelephonyManager.EXTRA_STATE_IDLE)
                || intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            // This code will execute when the call is disconnected
            Toast.makeText(context, "Detected call hangup event", Toast.LENGTH_LONG).show();

        }
    }
}
 /*
 * // Another way to here on the telephone call reciver
 @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;
        MyPhoneStateListener phoneListener=new MyPhoneStateListener();
        TelephonyManager telephony = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        telephony.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        }
    class MyPhoneStateListener extends PhoneStateListener {
        public void onCallStateChanged(int state,String incomingNumber){
            String msg="";
            switch(state){
                case TelephonyManager.CALL_STATE_IDLE:
                    msg="CALL_STATE_IDLE";
                    Log.d("DEBUG", "IDLE");
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    msg="CALL_STATE_OFFHOOK";
                    Log.d("DEBUG", "OFFHOOK");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    msg="CALL_STATE_RINGING";
                    Log.d("DEBUG", "RINGING");
                    break;
            }

            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();


    }
}

*/
