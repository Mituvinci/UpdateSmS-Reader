package com.mitu.hi.smsreader.broadcastreceivers;

/**
 * Created by Hi on 16-Apr-16.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;

import com.mitu.hi.smsreader.services.SmsReader;

public class SmsReceiver extends BroadcastReceiver {

    @SuppressWarnings("deprecation")
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = context.getSharedPreferences("eu.romainpellerin.smsreader", Context.MODE_PRIVATE);
        if (prefs.getBoolean("enable_all", true)) {
            AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            if (prefs.getBoolean("only_when_headphones", true)) {
                if (!am.isWiredHeadsetOn()) return;
            }
            Intent inte = new Intent(context, SmsReader.class);
            inte.putExtras(intent);
            context.startService(inte);
        }
    }
}
