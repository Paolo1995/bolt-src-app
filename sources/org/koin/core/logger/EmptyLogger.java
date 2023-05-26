package org.koin.core.logger;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyLogger.kt */
/* loaded from: classes5.dex */
public final class EmptyLogger extends Logger {
    public EmptyLogger() {
        super(Level.NONE);
    }

    @Override // org.koin.core.logger.Logger
    public void a(Level level, String msg) {
        Intrinsics.f(level, "level");
        Intrinsics.f(msg, "msg");
    }
}
