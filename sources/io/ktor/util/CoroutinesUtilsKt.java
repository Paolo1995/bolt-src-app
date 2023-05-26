package io.ktor.util;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: CoroutinesUtils.kt */
/* loaded from: classes5.dex */
public final class CoroutinesUtilsKt {
    public static final CoroutineContext a(Job job) {
        return SupervisorKt.a(job).s0(new CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.f51243c));
    }

    public static /* synthetic */ CoroutineContext b(Job job, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            job = null;
        }
        return a(job);
    }
}
