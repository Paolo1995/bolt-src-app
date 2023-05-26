package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class SendRequest {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract SendRequest a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Builder b(Encoding encoding);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Builder c(Event<?> event);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Builder d(Transformer<?, byte[]> transformer);

        public abstract Builder e(TransportContext transportContext);

        public abstract Builder f(String str);
    }

    public static Builder a() {
        return new AutoValue_SendRequest.Builder();
    }

    public abstract Encoding b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Event<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Transformer<?, byte[]> e();

    public abstract TransportContext f();

    public abstract String g();
}
