package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import com.google.firebase.installations.remote.AutoValue_TokenResult;

/* loaded from: classes3.dex */
public abstract class TokenResult {

    /* loaded from: classes3.dex */
    public static abstract class Builder {
        @NonNull
        public abstract TokenResult a();

        @NonNull
        public abstract Builder b(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder c(@NonNull String str);

        @NonNull
        public abstract Builder d(long j8);
    }

    /* loaded from: classes3.dex */
    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_TokenResult.Builder().d(0L);
    }

    public abstract ResponseCode b();

    public abstract String c();

    @NonNull
    public abstract long d();
}
