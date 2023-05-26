package io.ktor.client.statement;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpStatement.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {126}, m = "cleanup")
/* loaded from: classes5.dex */
public final class HttpStatement$cleanup$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46676f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f46677g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ HttpStatement f46678h;

    /* renamed from: i  reason: collision with root package name */
    int f46679i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$cleanup$1(HttpStatement httpStatement, Continuation<? super HttpStatement$cleanup$1> continuation) {
        super(continuation);
        this.f46678h = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46677g = obj;
        this.f46679i |= Integer.MIN_VALUE;
        return this.f46678h.b(null, this);
    }
}
