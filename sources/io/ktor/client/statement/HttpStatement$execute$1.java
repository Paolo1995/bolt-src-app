package io.ktor.client.statement;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpStatement.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {47, 50, 52, 52}, m = "execute")
/* loaded from: classes5.dex */
public final class HttpStatement$execute$1<T> extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46680f;

    /* renamed from: g  reason: collision with root package name */
    Object f46681g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46682h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpStatement f46683i;

    /* renamed from: j  reason: collision with root package name */
    int f46684j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$execute$1(HttpStatement httpStatement, Continuation<? super HttpStatement$execute$1> continuation) {
        super(continuation);
        this.f46683i = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46682h = obj;
        this.f46684j |= Integer.MIN_VALUE;
        return this.f46683i.d(null, this);
    }
}
