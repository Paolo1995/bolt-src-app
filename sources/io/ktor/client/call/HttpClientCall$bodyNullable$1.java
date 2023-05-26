package io.ktor.client.call;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientCall.kt */
@DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", l = {85, 88}, m = "bodyNullable")
/* loaded from: classes5.dex */
public final class HttpClientCall$bodyNullable$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46077f;

    /* renamed from: g  reason: collision with root package name */
    Object f46078g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46079h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpClientCall f46080i;

    /* renamed from: j  reason: collision with root package name */
    int f46081j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCall$bodyNullable$1(HttpClientCall httpClientCall, Continuation<? super HttpClientCall$bodyNullable$1> continuation) {
        super(continuation);
        this.f46080i = httpClientCall;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46079h = obj;
        this.f46081j |= Integer.MIN_VALUE;
        return this.f46080i.a(null, this);
    }
}
