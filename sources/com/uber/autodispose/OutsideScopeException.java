package com.uber.autodispose;

/* loaded from: classes3.dex */
public class OutsideScopeException extends RuntimeException {
    public OutsideScopeException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        if (AutoDisposePlugins.f19746a) {
            return super.fillInStackTrace();
        }
        return this;
    }
}
