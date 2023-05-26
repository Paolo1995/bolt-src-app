package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public abstract class IntegrityTokenRequest {

    /* compiled from: com.google.android.play:integrity@@1.1.0 */
    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract IntegrityTokenRequest a();

        public abstract Builder b(String str);
    }

    public static Builder a() {
        return new a();
    }

    public abstract Long b();

    public abstract String c();
}
