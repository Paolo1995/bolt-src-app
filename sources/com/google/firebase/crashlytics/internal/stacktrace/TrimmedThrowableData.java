package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes3.dex */
public class TrimmedThrowableData {

    /* renamed from: a  reason: collision with root package name */
    public final String f16198a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16199b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f16200c;

    /* renamed from: d  reason: collision with root package name */
    public final TrimmedThrowableData f16201d;

    public TrimmedThrowableData(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        TrimmedThrowableData trimmedThrowableData;
        this.f16198a = th.getLocalizedMessage();
        this.f16199b = th.getClass().getName();
        this.f16200c = stackTraceTrimmingStrategy.a(th.getStackTrace());
        Throwable cause = th.getCause();
        if (cause != null) {
            trimmedThrowableData = new TrimmedThrowableData(cause, stackTraceTrimmingStrategy);
        } else {
            trimmedThrowableData = null;
        }
        this.f16201d = trimmedThrowableData;
    }
}
