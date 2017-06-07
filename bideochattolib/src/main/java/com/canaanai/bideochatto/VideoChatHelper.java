package com.canaanai.bideochatto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by kk on 2016/12/21
 */



public class VideoChatHelper {

    /**
     * makeCall
     *
     * @param context activity instance
     * @param serverUrl room server as "https://114.55.151.237"; if null, will use default room server
     * @param userId    user id
     * @param userName  user name
     */
    public static void makeCall(Activity context, String serverUrl, String room, String userId, String userName) {
        Intent intent = new Intent(context.getApplicationContext(), ConnectActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.putExtra(CallActivity.EXTRA_ROOM_SERVER, (serverUrl!=null)?serverUrl:"");
        intent.putExtra(CallActivity.EXTRA_ROOMID, room);
        intent.putExtra(CallActivity.EXTRA_USER_ID, userId);
        intent.putExtra(CallActivity.EXTRA_USER_NAME, userName);

        context.startActivityForResult(intent, 10001);
    }

    /**
     * makeCall
     * @param context
     * @param roomId 对方roomid
     * @param userName 对方Name
     */
    public static void makeCall(Context context, String roomId, String userName){
        Intent intent = new Intent(context.getApplicationContext(), ConnectActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.putExtra(CallActivity.EXTRA_ROOMID, roomId);
        intent.putExtra(CallActivity.EXTRA_USER_NAME, userName);

        context.startActivity(intent);
    }

    /**
     * 挂断
     * @param context
     */
    public static void hungUp(Context context){
        Intent intent = new Intent(CallActivity.ACTION_HUNG_UP);

        context.sendBroadcast(intent);
    }
}
