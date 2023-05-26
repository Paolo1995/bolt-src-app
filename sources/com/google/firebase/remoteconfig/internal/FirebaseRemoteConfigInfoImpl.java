package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {

    /* renamed from: a  reason: collision with root package name */
    private final long f17127a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17128b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseRemoteConfigSettings f17129c;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f17130a;

        /* renamed from: b  reason: collision with root package name */
        private int f17131b;

        /* renamed from: c  reason: collision with root package name */
        private FirebaseRemoteConfigSettings f17132c;

        private Builder() {
        }

        public FirebaseRemoteConfigInfoImpl a() {
            return new FirebaseRemoteConfigInfoImpl(this.f17130a, this.f17131b, this.f17132c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder b(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.f17132c = firebaseRemoteConfigSettings;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder c(int i8) {
            this.f17131b = i8;
            return this;
        }

        public Builder d(long j8) {
            this.f17130a = j8;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder b() {
        return new Builder();
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public int a() {
        return this.f17128b;
    }

    private FirebaseRemoteConfigInfoImpl(long j8, int i8, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f17127a = j8;
        this.f17128b = i8;
        this.f17129c = firebaseRemoteConfigSettings;
    }
}
