package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugMetadata.kt */
/* loaded from: classes5.dex */
public final class ModuleNameRetriever {

    /* renamed from: a  reason: collision with root package name */
    public static final ModuleNameRetriever f50928a = new ModuleNameRetriever();

    /* renamed from: b  reason: collision with root package name */
    private static final Cache f50929b = new Cache(null, null, null);

    /* renamed from: c  reason: collision with root package name */
    private static Cache f50930c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugMetadata.kt */
    /* loaded from: classes5.dex */
    public static final class Cache {

        /* renamed from: a  reason: collision with root package name */
        public final Method f50931a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f50932b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f50933c;

        public Cache(Method method, Method method2, Method method3) {
            this.f50931a = method;
            this.f50932b = method2;
            this.f50933c = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final Cache a(BaseContinuationImpl baseContinuationImpl) {
        try {
            Cache cache = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f50930c = cache;
            return cache;
        } catch (Exception unused) {
            Cache cache2 = f50929b;
            f50930c = cache2;
            return cache2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.f(continuation, "continuation");
        Cache cache = f50930c;
        if (cache == null) {
            cache = a(continuation);
        }
        if (cache == f50929b) {
            return null;
        }
        Method method = cache.f50931a;
        if (method != null) {
            obj = method.invoke(continuation.getClass(), new Object[0]);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = cache.f50932b;
        if (method2 != null) {
            obj2 = method2.invoke(obj, new Object[0]);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = cache.f50933c;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, new Object[0]);
        } else {
            obj3 = null;
        }
        if (!(obj3 instanceof String)) {
            return null;
        }
        return (String) obj3;
    }
}
