package com.google.firebase.remoteconfig;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigException {

    /* renamed from: f  reason: collision with root package name */
    private final long f17032f;

    public FirebaseRemoteConfigFetchThrottledException(long j8) {
        this("Fetch was throttled.", j8);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j8) {
        super(str);
        this.f17032f = j8;
    }
}
