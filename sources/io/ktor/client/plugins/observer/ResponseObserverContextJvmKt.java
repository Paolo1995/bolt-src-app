package io.ktor.client.plugins.observer;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.slf4j.MDCContext;

/* compiled from: ResponseObserverContextJvm.kt */
/* loaded from: classes5.dex */
public final class ResponseObserverContextJvmKt {
    public static final Object a(Continuation<? super CoroutineContext> continuation) {
        MDCContext mDCContext = (MDCContext) continuation.getContext().g(MDCContext.f51993h);
        if (mDCContext == null) {
            return EmptyCoroutineContext.f50912f;
        }
        return mDCContext;
    }
}
