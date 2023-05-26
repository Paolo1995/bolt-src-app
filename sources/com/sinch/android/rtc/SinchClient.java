package com.sinch.android.rtc;

import androidx.annotation.NonNull;
import com.sinch.android.rtc.calling.CallController;
import com.sinch.android.rtc.calling.CallNotificationResult;
import com.sinch.android.rtc.video.VideoController;

/* loaded from: classes3.dex */
public interface SinchClient {
    void addSinchClientListener(SinchClientListener sinchClientListener);

    void checkManifest();

    AudioController getAudioController();

    CallController getCallController();

    String getLocalUserId();

    VideoController getVideoController();

    boolean isStarted();

    void relayRemotePushNotification(@NonNull CallNotificationResult callNotificationResult) throws IllegalArgumentException;

    void removeSinchClientListener(SinchClientListener sinchClientListener);

    void start();

    void terminateGracefully();

    void unregisterPushToken(PushTokenUnregistrationCallback pushTokenUnregistrationCallback) throws UnsupportedOperationException;
}
