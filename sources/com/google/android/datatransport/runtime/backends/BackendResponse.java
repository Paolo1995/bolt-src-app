package com.google.android.datatransport.runtime.backends;

/* loaded from: classes.dex */
public abstract class BackendResponse {

    /* loaded from: classes.dex */
    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static BackendResponse a() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse d() {
        return new AutoValue_BackendResponse(Status.INVALID_PAYLOAD, -1L);
    }

    public static BackendResponse e(long j8) {
        return new AutoValue_BackendResponse(Status.OK, j8);
    }

    public static BackendResponse f() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract Status c();
}
