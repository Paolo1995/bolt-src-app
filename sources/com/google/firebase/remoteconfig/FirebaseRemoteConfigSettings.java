package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfigSettings {

    /* renamed from: a  reason: collision with root package name */
    private final long f17034a;

    /* renamed from: b  reason: collision with root package name */
    private final long f17035b;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f17036a = 60;

        /* renamed from: b  reason: collision with root package name */
        private long f17037b = ConfigFetchHandler.f17075j;

        @NonNull
        public FirebaseRemoteConfigSettings c() {
            return new FirebaseRemoteConfigSettings(this);
        }

        @NonNull
        public Builder d(long j8) throws IllegalArgumentException {
            if (j8 >= 0) {
                this.f17036a = j8;
                return this;
            }
            throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j8)));
        }

        @NonNull
        public Builder e(long j8) {
            if (j8 >= 0) {
                this.f17037b = j8;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j8 + " is an invalid argument");
        }
    }

    public long a() {
        return this.f17034a;
    }

    public long b() {
        return this.f17035b;
    }

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.f17034a = builder.f17036a;
        this.f17035b = builder.f17037b;
    }
}
