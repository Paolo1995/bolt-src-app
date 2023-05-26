package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;

/* loaded from: classes.dex */
public abstract class AndroidClientInfo {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        @NonNull
        public abstract AndroidClientInfo a();

        @NonNull
        public abstract Builder b(String str);

        @NonNull
        public abstract Builder c(String str);

        @NonNull
        public abstract Builder d(String str);

        @NonNull
        public abstract Builder e(String str);

        @NonNull
        public abstract Builder f(String str);

        @NonNull
        public abstract Builder g(String str);

        @NonNull
        public abstract Builder h(String str);

        @NonNull
        public abstract Builder i(String str);

        @NonNull
        public abstract Builder j(String str);

        @NonNull
        public abstract Builder k(String str);

        @NonNull
        public abstract Builder l(String str);

        @NonNull
        public abstract Builder m(Integer num);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_AndroidClientInfo.Builder();
    }

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract String i();

    public abstract String j();

    public abstract String k();

    public abstract String l();

    public abstract Integer m();
}
