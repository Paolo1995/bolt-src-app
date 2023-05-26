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
final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> f52149a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassValueParametrizedCache$initClassValue$1 f52150b;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.f(compute, "compute");
        this.f52149a = compute;
        this.f52150b = b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.internal.ClassValueParametrizedCache$initClassValue$1] */
    private final ClassValueParametrizedCache$initClassValue$1 b() {
        return new ClassValue<ParametrizedCacheEntry<T>>() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$initClassValue$1
        };
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    public Object a(KClass<Object> key, List<? extends KType> types) {
        Object b8;
        Intrinsics.f(key, "key");
        Intrinsics.f(types, "types");
        ConcurrentHashMap a8 = ParametrizedCacheEntry.a((ParametrizedCacheEntry) get(JvmClassMappingKt.a(key)));
        Object obj = a8.get(types);
        if (obj == null) {
            try {
                Result.Companion companion = Result.f50818g;
                b8 = Result.b(this.f52149a.s(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f50818g;
                b8 = Result.b(ResultKt.a(th));
            }
            Result a9 = Result.a(b8);
            Object putIfAbsent = a8.putIfAbsent(types, a9);
            if (putIfAbsent == null) {
                obj = a9;
            } else {
                obj = putIfAbsent;
            }
        }
        Intrinsics.e(obj, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj).j();
    }
}
