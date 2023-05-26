package eu.bolt.coroutines.base;

import eu.bolt.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: DefaultCoroutineExceptionHandler.kt */
/* loaded from: classes5.dex */
public final class DefaultCoroutineExceptionHandlerKt {
    public static final CoroutineExceptionHandler a(String tag, Logger logger) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(logger, "logger");
        return new DefaultCoroutineExceptionHandlerKt$DefaultCoroutineExceptionHandler$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.f51243c, logger, tag);
    }
}
