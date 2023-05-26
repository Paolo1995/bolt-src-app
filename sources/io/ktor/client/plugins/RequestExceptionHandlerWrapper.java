package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpCallValidator.kt */
/* loaded from: classes5.dex */
public final class RequestExceptionHandlerWrapper implements HandlerWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> f46410a;

    public final Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> a() {
        return this.f46410a;
    }
}
