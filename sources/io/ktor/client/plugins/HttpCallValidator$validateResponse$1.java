package io.ktor.client.plugins;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {47}, m = "validateResponse")
/* loaded from: classes5.dex */
public final class HttpCallValidator$validateResponse$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46309f;

    /* renamed from: g  reason: collision with root package name */
    Object f46310g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46311h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpCallValidator f46312i;

    /* renamed from: j  reason: collision with root package name */
    int f46313j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$validateResponse$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$validateResponse$1> continuation) {
        super(continuation);
        this.f46312i = httpCallValidator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f8;
        this.f46311h = obj;
        this.f46313j |= Integer.MIN_VALUE;
        f8 = this.f46312i.f(null, this);
        return f8;
    }
}
