package com.sinch.android.rtc.internal.client;

import android.content.Context;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.PushConfiguration;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.SinchClientBuilder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class DefaultSinchClientBuilder implements SinchClientBuilder {
    private String mApplicationKey;
    private Context mContext;
    private boolean mEnableVideoCalls = true;
    private String mEnvironmentHost;
    private PushConfiguration mPushConfiguration;
    private String mPushNotificationDisplayName;
    private String mUserId;

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public DefaultSinchClientBuilder applicationKey(@NonNull String str) {
        this.mApplicationKey = str;
        return this;
    }

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public SinchClient build() throws IOException {
        if (this.mContext != null) {
            String str = this.mUserId;
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("The user id must not be null or empty.");
            }
            String str2 = this.mApplicationKey;
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("The application key must not be null or empty.");
            }
            String str3 = this.mEnvironmentHost;
            if (str3 == null || str3.isEmpty()) {
                throw new IllegalArgumentException("The environment host must not be null or empty.");
            }
            String str4 = this.mPushNotificationDisplayName;
            if (str4 == null || str4.getBytes(StandardCharsets.UTF_8).length <= 255) {
                return InternalSinchClientFactory.createSinchClient(this.mContext, this.mUserId, this.mApplicationKey, this.mEnvironmentHost, this.mEnableVideoCalls, this.mPushConfiguration, this.mPushNotificationDisplayName);
            }
            throw new IllegalArgumentException("The push notification display name must not exceed 255 bytes");
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public DefaultSinchClientBuilder context(@NonNull Context context) {
        this.mContext = context;
        return this;
    }

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public DefaultSinchClientBuilder enableVideoCalls(boolean z7) {
        this.mEnableVideoCalls = z7;
        return this;
    }

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public DefaultSinchClientBuilder environmentHost(@NonNull String str) {
        this.mEnvironmentHost = str;
        return this;
    }

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public SinchClientBuilder pushConfiguration(@NonNull PushConfiguration pushConfiguration) {
        this.mPushConfiguration = pushConfiguration;
        return this;
    }

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public SinchClientBuilder pushNotificationDisplayName(String str) {
        this.mPushNotificationDisplayName = str;
        return this;
    }

    @Override // com.sinch.android.rtc.SinchClientBuilder
    public DefaultSinchClientBuilder userId(@NonNull String str) {
        this.mUserId = str;
        return this;
    }
}
