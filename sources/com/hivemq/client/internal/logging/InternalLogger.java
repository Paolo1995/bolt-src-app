package com.hivemq.client.internal.logging;

/* loaded from: classes3.dex */
public interface InternalLogger {
    void error(String str);

    void error(String str, Object obj);

    void error(String str, Object obj, Object obj2);

    void error(String str, Throwable th);

    void warn(String str);

    void warn(String str, Object obj);

    void warn(String str, Object obj, Object obj2);
}
