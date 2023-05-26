package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;

/* loaded from: classes.dex */
public abstract class ClientInfo {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        @NonNull
        public abstract ClientInfo a();

        @NonNull
        public abstract Builder b(AndroidClientInfo androidClientInfo);

        @NonNull
        public abstract Builder c(ClientType clientType);
    }

    /* loaded from: classes.dex */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f11984f;

        ClientType(int i8) {
            this.f11984f = i8;
        }
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_ClientInfo.Builder();
    }

    public abstract AndroidClientInfo b();

    public abstract ClientType c();
}
