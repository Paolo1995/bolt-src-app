package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;

/* loaded from: classes3.dex */
public abstract class InstallationResponse {

    /* loaded from: classes3.dex */
    public static abstract class Builder {
        @NonNull
        public abstract InstallationResponse a();

        @NonNull
        public abstract Builder b(@NonNull TokenResult tokenResult);

        @NonNull
        public abstract Builder c(@NonNull String str);

        @NonNull
        public abstract Builder d(@NonNull String str);

        @NonNull
        public abstract Builder e(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder f(@NonNull String str);
    }

    /* loaded from: classes3.dex */
    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_InstallationResponse.Builder();
    }

    public abstract TokenResult b();

    public abstract String c();

    public abstract String d();

    public abstract ResponseCode e();

    public abstract String f();
}
