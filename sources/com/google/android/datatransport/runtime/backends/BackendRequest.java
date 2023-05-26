package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;

/* loaded from: classes.dex */
public abstract class BackendRequest {

    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract BackendRequest a();

        public abstract Builder b(Iterable<EventInternal> iterable);

        public abstract Builder c(byte[] bArr);
    }

    public static Builder a() {
        return new AutoValue_BackendRequest.Builder();
    }

    public abstract Iterable<EventInternal> b();

    public abstract byte[] c();
}
