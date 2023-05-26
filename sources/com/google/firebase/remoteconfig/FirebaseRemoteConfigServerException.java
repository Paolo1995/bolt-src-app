package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {

    /* renamed from: f  reason: collision with root package name */
    private final int f17033f;

    public FirebaseRemoteConfigServerException(int i8, @NonNull String str) {
        super(str);
        this.f17033f = i8;
    }

    public int a() {
        return this.f17033f;
    }

    public FirebaseRemoteConfigServerException(int i8, @NonNull String str, Throwable th) {
        super(str, th);
        this.f17033f = i8;
    }
}
