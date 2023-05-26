package kotlinx.serialization.internal;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes5.dex */
final class ClassValueCache<T> implements SerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<KClass<?>, KSerializer<T>> f52146a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassValueCache$initClassValue$1 f52147b;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueCache(Function1<? super KClass<?>, ? extends KSerializer<T>> compute) {
        Intrinsics.f(compute, "compute");
        this.f52146a = compute;
        this.f52147b = b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.internal.ClassValueCache$initClassValue$1] */
    private final ClassValueCache$initClassValue$1 b() {
        return new ClassValue<CacheEntry<T>>(this) { // from class: kotlinx.serialization.internal.ClassValueCache$initClassValue$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ClassValueCache<T> f52148a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f52148a = this;
            }
        };
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer<T> a(KClass<Object> key) {
        Intrinsics.f(key, "key");
        return ((CacheEntry) get(JvmClassMappingKt.a(key))).f52139a;
    }
}
