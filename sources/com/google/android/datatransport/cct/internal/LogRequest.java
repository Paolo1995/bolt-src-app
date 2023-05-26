package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import java.util.List;

/* loaded from: classes.dex */
public abstract class LogRequest {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        @NonNull
        public abstract LogRequest a();

        @NonNull
        public abstract Builder b(ClientInfo clientInfo);

        @NonNull
        public abstract Builder c(List<LogEvent> list);

        @NonNull
        abstract Builder d(Integer num);

        @NonNull
        abstract Builder e(String str);

        @NonNull
        public abstract Builder f(QosTier qosTier);

        @NonNull
        public abstract Builder g(long j8);

        @NonNull
        public abstract Builder h(long j8);

        @NonNull
        public Builder i(int i8) {
            return d(Integer.valueOf(i8));
        }

        @NonNull
        public Builder j(@NonNull String str) {
            return e(str);
        }
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_LogRequest.Builder();
    }

    public abstract ClientInfo b();

    public abstract List<LogEvent> c();

    public abstract Integer d();

    public abstract String e();

    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
