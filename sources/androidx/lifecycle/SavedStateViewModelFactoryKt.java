package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateViewModelFactory.kt */
/* loaded from: classes.dex */
public final class SavedStateViewModelFactoryKt {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Class<?>> f6773a;

    /* renamed from: b  reason: collision with root package name */
    private static final List<Class<?>> f6774b;

    static {
        List<Class<?>> n8;
        List<Class<?>> e8;
        n8 = CollectionsKt__CollectionsKt.n(Application.class, SavedStateHandle.class);
        f6773a = n8;
        e8 = CollectionsKt__CollectionsJVMKt.e(SavedStateHandle.class);
        f6774b = e8;
    }

    public static final <T> Constructor<T> c(Class<T> modelClass, List<? extends Class<?>> signature) {
        List f02;
        Intrinsics.f(modelClass, "modelClass");
        Intrinsics.f(signature, "signature");
        Constructor<?>[] constructors = modelClass.getConstructors();
        Intrinsics.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            Intrinsics.e(parameterTypes, "constructor.parameterTypes");
            f02 = ArraysKt___ArraysKt.f0(parameterTypes);
            if (Intrinsics.a(signature, f02)) {
                return constructor2;
            }
            if (signature.size() == f02.size() && f02.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T d(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        Intrinsics.f(modelClass, "modelClass");
        Intrinsics.f(constructor, "constructor");
        Intrinsics.f(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Failed to access " + modelClass, e8);
        } catch (InstantiationException e9) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e9);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e10.getCause());
        }
    }
}
