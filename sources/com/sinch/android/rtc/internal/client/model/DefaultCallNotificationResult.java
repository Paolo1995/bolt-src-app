package com.sinch.android.rtc.internal.client.model;

import androidx.annotation.NonNull;
import com.sinch.android.rtc.calling.CallNotificationResult;
import com.sinch.android.rtc.internal.natives.jni.PushPayloadQuery;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultCallNotificationResult implements CallNotificationResult {
    private final Map<String, String> callHeaders;
    private final String callId;
    private final String displayName;
    @NonNull
    private final String domain;
    private final boolean isValid;
    private final String remoteUserId;
    private final boolean timedOut;
    private final boolean videoOffered;

    public DefaultCallNotificationResult(PushPayloadQuery.PushPayloadQueryResult pushPayloadQueryResult, String str) {
        this.isValid = pushPayloadQueryResult.isValid() && pushPayloadQueryResult.isCallQuery();
        this.timedOut = pushPayloadQueryResult.isTimedOut();
        this.callId = pushPayloadQueryResult.getSessionId();
        this.remoteUserId = pushPayloadQueryResult.getUserId();
        this.videoOffered = pushPayloadQueryResult.getVideoOffered();
        this.callHeaders = pushPayloadQueryResult.getHeaders();
        this.domain = pushPayloadQueryResult.getDomain();
        this.displayName = str;
    }

    @Override // com.sinch.android.rtc.calling.CallNotificationResult
    public Map<String, String> getCallHeaders() {
        return this.callHeaders;
    }

    @Override // com.sinch.android.rtc.calling.CallNotificationResult
    public String getCallId() {
        return this.callId;
    }

    @Override // com.sinch.android.rtc.calling.CallNotificationResult
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.sinch.android.rtc.calling.CallNotificationResult
    @NonNull
    public String getDomain() {
        return this.domain;
    }

    @Override // com.sinch.android.rtc.calling.CallNotificationResult
    public String getRemoteUserId() {
        return this.remoteUserId;
    }

    @Override // com.sinch.android.rtc.calling.CallNotificationResult
    public boolean isTimedOut() {
        return this.timedOut;
    }

    public boolean isValid() {
        return this.isValid;
    }

    @Override // com.sinch.android.rtc.calling.CallNotificationResult
    public boolean isVideoOffered() {
        return this.videoOffered;
    }
}
