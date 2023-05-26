package io.ktor.client.plugins.cache;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCache.kt */
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {196}, m = "cacheResponse")
/* loaded from: classes5.dex */
public final class HttpCache$cacheResponse$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f46436f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ HttpCache f46437g;

    /* renamed from: h  reason: collision with root package name */
    int f46438h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$cacheResponse$1(HttpCache httpCache, Continuation<? super HttpCache$cacheResponse$1> continuation) {
        super(continuation);
        this.f46437g = httpCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f8;
        this.f46436f = obj;
        this.f46438h |= Integer.MIN_VALUE;
        f8 = this.f46437g.f(null, this);
        return f8;
    }
}
