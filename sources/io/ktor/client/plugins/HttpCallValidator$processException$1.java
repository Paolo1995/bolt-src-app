package io.ktor.client.plugins;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {53, 54}, m = "processException")
/* loaded from: classes5.dex */
public final class HttpCallValidator$processException$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46303f;

    /* renamed from: g  reason: collision with root package name */
    Object f46304g;

    /* renamed from: h  reason: collision with root package name */
    Object f46305h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46306i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpCallValidator f46307j;

    /* renamed from: k  reason: collision with root package name */
    int f46308k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$processException$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$processException$1> continuation) {
        super(continuation);
        this.f46307j = httpCallValidator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e8;
        this.f46306i = obj;
        this.f46308k |= Integer.MIN_VALUE;
        e8 = this.f46307j.e(null, null, this);
        return e8;
    }
}
