package com.sinch.android.rtc;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface SinchClientBuilder {
    SinchClientBuilder applicationKey(@NonNull String str);

    SinchClient build() throws IOException;

    SinchClientBuilder context(@NonNull Context context);

    SinchClientBuilder enableVideoCalls(boolean z7);

    SinchClientBuilder environmentHost(@NonNull String str);

    SinchClientBuilder pushConfiguration(PushConfiguration pushConfiguration);

    SinchClientBuilder pushNotificationDisplayName(String str);

    SinchClientBuilder userId(@NonNull String str);
}
