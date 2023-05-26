package io.ktor.client.plugins.logging;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoggingUtils.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingUtilsKt", f = "LoggingUtils.kt", l = {62}, m = "logResponseBody")
/* loaded from: classes5.dex */
public final class LoggingUtilsKt$logResponseBody$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46569f;

    /* renamed from: g  reason: collision with root package name */
    Object f46570g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46571h;

    /* renamed from: i  reason: collision with root package name */
    int f46572i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoggingUtilsKt$logResponseBody$1(Continuation<? super LoggingUtilsKt$logResponseBody$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46571h = obj;
        this.f46572i |= Integer.MIN_VALUE;
        return LoggingUtilsKt.c(null, null, null, this);
    }
}
