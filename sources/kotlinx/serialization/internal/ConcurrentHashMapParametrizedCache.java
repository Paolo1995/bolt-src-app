package kotlinx.serialization.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes5.dex */
final class ConcurrentHashMapParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> f52154a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<Class<?>, ParametrizedCacheEntry<T>> f52155b;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMapParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.f(compute, "compute");
        this.f52154a = compute;
        this.f52155b = new ConcurrentHashMap<>();
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    public Object a(KClass<Object> key, List<? extends KType> types) {
        Object b8;
        ParametrizedCacheEntry<T> putIfAbsent;
        Intrinsics.f(key, "key");
        Intrinsics.f(types, "types");
        ConcurrentHashMap<Class<?>, ParametrizedCacheEntry<T>> concurrentHashMap = this.f52155b;
        Class<?> a8 = JvmClassMappingKt.a(key);
        ParametrizedCacheEntry<T> parametrizedCacheEntry = concurrentHashMap.get(a8);
        if (parametrizedCacheEntry == null && (putIfAbsent = concurrentHashMap.putIfAbsent(a8, (parametrizedCacheEntry = new ParametrizedCacheEntry<>()))) != null) {
            parametrizedCacheEntry = putIfAbsent;
        }
        ConcurrentHashMap a9 = ParametrizedCacheEntry.a(parametrizedCacheEntry);
        Object obj = a9.get(types);
        if (obj == null) {
            try {
                Result.Companion companion = Result.f50818g;
                b8 = Result.b(this.f52154a.s(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f50818g;
                b8 = Result.b(ResultKt.a(th));
            }
            Result a10 = Result.a(b8);
            Object putIfAbsent2 = a9.putIfAbsent(types, a10);
            if (putIfAbsent2 == null) {
                obj = a10;
            } else {
                obj = putIfAbsent2;
            }
        }
        Intrinsics.e(obj, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj).j();
    }
}
