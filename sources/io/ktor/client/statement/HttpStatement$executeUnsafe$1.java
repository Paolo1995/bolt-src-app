package io.ktor.client.statement;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpStatement.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {108}, m = "executeUnsafe")
/* loaded from: classes5.dex */
public final class HttpStatement$executeUnsafe$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f46687f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ HttpStatement f46688g;

    /* renamed from: h  reason: collision with root package name */
    int f46689h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$executeUnsafe$1(HttpStatement httpStatement, Continuation<? super HttpStatement$executeUnsafe$1> continuation) {
        super(continuation);
        this.f46688g = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46687f = obj;
        this.f46689h |= Integer.MIN_VALUE;
        return this.f46688g.e(this);
    }
}
