package com.hivemq.client.internal.logging;

import com.hivemq.client.internal.util.ClassUtil;

/* loaded from: classes3.dex */
public final class InternalLoggerFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f17760a = ClassUtil.a("org.slf4j.Logger");

    private InternalLoggerFactory() {
    }

    public static InternalLogger a(Class<?> cls) {
        if (f17760a) {
            return new InternalSlf4jLogger(cls);
        }
        return InternalNoopLogger.f17761a;
    }
}
