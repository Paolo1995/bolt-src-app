package io.ktor.client.statement;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpResponse.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {97}, m = "bodyAsText")
/* loaded from: classes5.dex */
public final class HttpResponseKt$bodyAsText$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46664f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f46665g;

    /* renamed from: h  reason: collision with root package name */
    int f46666h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpResponseKt$bodyAsText$1(Continuation<? super HttpResponseKt$bodyAsText$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46665g = obj;
        this.f46666h |= Integer.MIN_VALUE;
        return HttpResponseKt.a(null, null, this);
    }
}
