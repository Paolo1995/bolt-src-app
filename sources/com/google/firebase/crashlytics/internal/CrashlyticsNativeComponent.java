package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes3.dex */
public interface CrashlyticsNativeComponent {
    @NonNull
    NativeSessionFileProvider a(@NonNull String str);

    boolean b();

    void c(@NonNull String str, @NonNull String str2, long j8, @NonNull StaticSessionData staticSessionData);

    boolean d(@NonNull String str);
}
