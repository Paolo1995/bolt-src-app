package io.ktor.client.plugins.cache.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCacheStorage.kt */
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.HttpCacheStorageKt", f = "HttpCacheStorage.kt", l = {45}, m = "store")
/* loaded from: classes5.dex */
public final class HttpCacheStorageKt$store$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46460f;

    /* renamed from: g  reason: collision with root package name */
    Object f46461g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46462h;

    /* renamed from: i  reason: collision with root package name */
    int f46463i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCacheStorageKt$store$1(Continuation<? super HttpCacheStorageKt$store$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46462h = obj;
        this.f46463i |= Integer.MIN_VALUE;
        return HttpCacheStorageKt.a(null, null, null, this);
    }
}
