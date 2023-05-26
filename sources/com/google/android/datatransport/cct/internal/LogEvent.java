package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;

/* loaded from: classes.dex */
public abstract class LogEvent {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        @NonNull
        public abstract LogEvent a();

        @NonNull
        public abstract Builder b(Integer num);

        @NonNull
        public abstract Builder c(long j8);

        @NonNull
        public abstract Builder d(long j8);

        @NonNull
        public abstract Builder e(NetworkConnectionInfo networkConnectionInfo);

        @NonNull
        abstract Builder f(byte[] bArr);

        @NonNull
        abstract Builder g(String str);

        @NonNull
        public abstract Builder h(long j8);
    }

    private static Builder a() {
        return new AutoValue_LogEvent.Builder();
    }

    @NonNull
    public static Builder i(@NonNull String str) {
        return a().g(str);
    }

    @NonNull
    public static Builder j(@NonNull byte[] bArr) {
        return a().f(bArr);
    }

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract NetworkConnectionInfo e();

    public abstract byte[] f();

    public abstract String g();

    public abstract long h();
}
