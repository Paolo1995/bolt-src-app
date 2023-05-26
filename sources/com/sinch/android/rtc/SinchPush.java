package com.sinch.android.rtc;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.calling.CallNotificationResult;
import com.sinch.android.rtc.internal.client.DefaultSinchClient;
import com.sinch.android.rtc.internal.client.libloader.NativeLibLoader;
import com.sinch.android.rtc.internal.client.model.DefaultCallNotificationResult;
import com.sinch.android.rtc.internal.natives.jni.PushPayloadQuery;
import java.util.Map;

/* loaded from: classes3.dex */
public class SinchPush {
    private static final String TAG = "SinchPush";

    public static boolean isSinchPushPayload(Map<String, String> map) {
        return (map == null || map.get(DefaultSinchClient.PAYLOAD_TAG_SINCH) == null) ? false : true;
    }

    private static CallNotificationResult queryPushNotificationPayload(Context context, String str, String str2) {
        NativeLibLoader.loadAllRequiredLibraries(context.getApplicationContext());
        PushPayloadQuery.PushPayloadQueryResult queryPayload = PushPayloadQuery.queryPayload(str, System.currentTimeMillis() / 1000);
        if (queryPayload.isValid()) {
            if (queryPayload.isCallQuery()) {
                return new DefaultCallNotificationResult(queryPayload, str2);
            }
            Log.e(TAG, "Passing non call related payload to relayRemotePushNotificationPayload");
            throw new IllegalArgumentException("Payload is not a call related Sinch payload");
        }
        String str3 = TAG;
        Log.e(str3, "Error in payload query: " + queryPayload.getError());
        throw new IllegalArgumentException("Payload is not a valid Sinch push payload " + queryPayload.getError());
    }

    public static CallNotificationResult queryPushNotificationPayload(Context context, @NonNull Map<String, String> map) throws IllegalArgumentException {
        if (map != null) {
            if (map.get(DefaultSinchClient.PAYLOAD_TAG_SINCH) != null) {
                return queryPushNotificationPayload(context, map.get(DefaultSinchClient.PAYLOAD_TAG_SINCH), map.get("name"));
            }
            if (map.get("mxp") != null) {
                return queryPushNotificationPayload(context, map.get("mxp"), null);
            }
            throw new IllegalArgumentException("Provided payload is not a valid Sinch push payload.");
        }
        throw new IllegalArgumentException("Payload cannot be null");
    }
}
