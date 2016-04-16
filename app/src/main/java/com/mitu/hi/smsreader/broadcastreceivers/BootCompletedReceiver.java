package com.mitu.hi.smsreader.broadcastreceivers;

/**
 * Created by Hi on 16-Apr-16.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mitu.hi.smsreader.services.MusicService;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            context.startService(new Intent(context, MusicService.class));
        }
    }
}
