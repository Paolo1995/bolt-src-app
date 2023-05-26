package io.ktor.client.plugins;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: HttpCallValidator.kt */
/* loaded from: classes5.dex */
public final class ExceptionHandlerWrapper implements HandlerWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<Throwable, Continuation<? super Unit>, Object> f46281a;

    public final Function2<Throwable, Continuation<? super Unit>, Object> a() {
        return this.f46281a;
    }
}
