package com.mitu.hi.smsreader.services;

/**
 * Created by Hi on 16-Apr-16.
 */
import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.mitu.hi.smsreader.broadcastreceivers.HeadsetPlugReceiver;

public class MusicService extends IntentService {

    private HeadsetPlugReceiver headsetplugreceiver; // singleton

    public MusicService() {
        super("MusicService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (headsetplugreceiver == null) {
            headsetplugreceiver = new HeadsetPlugReceiver();
        }
        IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        // http://forum.xda-developers.com/showpost.php?s=9f31526e699263e5a233526c70468f40&p=45575003&postcount=4
        this.registerReceiver(headsetplugreceiver, receiverFilter);
        //Log.e("service","create");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        //Log.e("service","destroy");
        super.onDestroy();
        this.unregisterReceiver(headsetplugreceiver);
        // TODO relaunch the service
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Log.e("ok","onhandleintent "+intent.toString());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.e("ok","onstartcommand "+(intent!=null?intent.toString():"(null)"));
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }
}
