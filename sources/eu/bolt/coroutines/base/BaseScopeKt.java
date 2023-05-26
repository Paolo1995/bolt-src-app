package eu.bolt.coroutines.base;

import eu.bolt.logger.Logger;
import eu.bolt.logger.StaticLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: BaseScope.kt */
/* loaded from: classes5.dex */
public final class BaseScopeKt {
    public static final CoroutineScope a(String tag, Logger logger, CoroutineExceptionHandler exceptionHandler, Job job, CoroutineDispatcher dispatcher) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(logger, "logger");
        Intrinsics.f(exceptionHandler, "exceptionHandler");
        Intrinsics.f(job, "job");
        Intrinsics.f(dispatcher, "dispatcher");
        return CoroutineScopeKt.a(job.s0(dispatcher).s0(exceptionHandler));
    }

    public static /* synthetic */ CoroutineScope b(String str, Logger logger, CoroutineExceptionHandler coroutineExceptionHandler, Job job, CoroutineDispatcher coroutineDispatcher, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "Unknown";
        }
        if ((i8 & 2) != 0) {
            logger = StaticLogger.f41686a;
        }
        if ((i8 & 4) != 0) {
            coroutineExceptionHandler = DefaultCoroutineExceptionHandlerKt.a(str, logger);
        }
        if ((i8 & 8) != 0) {
            job = SupervisorKt.b(null, 1, null);
        }
        if ((i8 & 16) != 0) {
            coroutineDispatcher = Dispatchers.c();
        }
        return a(str, logger, coroutineExceptionHandler, job, coroutineDispatcher);
    }
}
