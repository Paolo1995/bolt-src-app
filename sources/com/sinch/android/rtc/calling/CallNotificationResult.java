package com.sinch.android.rtc.calling;

import androidx.annotation.NonNull;
import java.util.Map;

/* loaded from: classes3.dex */
public interface CallNotificationResult {
    Map<String, String> getCallHeaders();

    String getCallId();

    String getDisplayName();

    @NonNull
    String getDomain();

    String getRemoteUserId();

    boolean isTimedOut();

    boolean isVideoOffered();
}
