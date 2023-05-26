package io.ktor.client.plugins.cache;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCacheEntry.kt */
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheEntryKt", f = "HttpCacheEntry.kt", l = {17}, m = "HttpCacheEntry")
/* loaded from: classes5.dex */
public final class HttpCacheEntryKt$HttpCacheEntry$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46444f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f46445g;

    /* renamed from: h  reason: collision with root package name */
    int f46446h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCacheEntryKt$HttpCacheEntry$1(Continuation<? super HttpCacheEntryKt$HttpCacheEntry$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46445g = obj;
        this.f46446h |= Integer.MIN_VALUE;
        return HttpCacheEntryKt.a(null, this);
    }
}
