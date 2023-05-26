package kotlinx.serialization.internal;

import j$.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes5.dex */
final class ConcurrentHashMapCache<T> implements SerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<KClass<?>, KSerializer<T>> f52152a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<Class<?>, CacheEntry<T>> f52153b;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMapCache(Function1<? super KClass<?>, ? extends KSerializer<T>> compute) {
        Intrinsics.f(compute, "compute");
        this.f52152a = compute;
        this.f52153b = new ConcurrentHashMap<>();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer<T> a(KClass<Object> key) {
        CacheEntry<T> putIfAbsent;
        Intrinsics.f(key, "key");
        ConcurrentHashMap<Class<?>, CacheEntry<T>> concurrentHashMap = this.f52153b;
        Class<?> a8 = JvmClassMappingKt.a(key);
        CacheEntry<T> cacheEntry = concurrentHashMap.get(a8);
        if (cacheEntry == null && (putIfAbsent = concurrentHashMap.putIfAbsent(a8, (cacheEntry = new CacheEntry<>(this.f52152a.invoke(key))))) != null) {
            cacheEntry = putIfAbsent;
        }
        return cacheEntry.f52139a;
    }
}
