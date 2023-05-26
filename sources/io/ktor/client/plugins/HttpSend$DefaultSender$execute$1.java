package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpSend;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpSend.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$DefaultSender", f = "HttpSend.kt", l = {138}, m = "execute")
/* loaded from: classes5.dex */
public final class HttpSend$DefaultSender$execute$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46379f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f46380g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ HttpSend.DefaultSender f46381h;

    /* renamed from: i  reason: collision with root package name */
    int f46382i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$DefaultSender$execute$1(HttpSend.DefaultSender defaultSender, Continuation<? super HttpSend$DefaultSender$execute$1> continuation) {
        super(continuation);
        this.f46381h = defaultSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46380g = obj;
        this.f46382i |= Integer.MIN_VALUE;
        return this.f46381h.a(null, this);
    }
}
