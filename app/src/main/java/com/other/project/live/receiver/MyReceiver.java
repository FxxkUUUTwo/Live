package com.other.project.live.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.other.project.live.MainActivity;
import com.other.project.live.R;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = MyReceiver.class.getSimpleName();

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            String extrasString = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.d(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + extrasString);


            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(extrasString);
                String key = jsonObject.getString("key");

                String string = jsonObject.getString("111");

                Intent intent1 = new Intent(context, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent1, PendingIntent.FLAG_ONE_SHOT);

                NotificationManager managerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                Notification.Builder builder = new Notification.Builder(context);

                builder.setContentText(key);
                builder.setSmallIcon(R.mipmap.ic_down);
                builder.setContentTitle(string);
                builder.setContentIntent(pendingIntent);

                managerCompat.notify(1, builder.build());

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
