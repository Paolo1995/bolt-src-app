package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
/* loaded from: classes5.dex */
public final class CachingKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f52140a;

    static {
        Object b8;
        try {
            Result.Companion companion = Result.f50818g;
            b8 = Result.b(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        if (Result.h(b8)) {
            Class cls = (Class) b8;
            b8 = Boolean.TRUE;
        }
        Object b9 = Result.b(b8);
        Boolean bool = Boolean.FALSE;
        if (Result.g(b9)) {
            b9 = bool;
        }
        f52140a = ((Boolean) b9).booleanValue();
    }

    public static final <T> SerializerCache<T> a(Function1<? super KClass<?>, ? extends KSerializer<T>> factory) {
        Intrinsics.f(factory, "factory");
        if (f52140a) {
            return new ClassValueCache(factory);
        }
        return new ConcurrentHashMapCache(factory);
    }

    public static final <T> ParametrizedSerializerCache<T> b(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> factory) {
        Intrinsics.f(factory, "factory");
        if (f52140a) {
            return new ClassValueParametrizedCache(factory);
        }
        return new ConcurrentHashMapParametrizedCache(factory);
    }
}
