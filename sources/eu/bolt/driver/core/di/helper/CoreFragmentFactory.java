package eu.bolt.driver.core.di.helper;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import java.util.Map;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreFragmentFactory.kt */
/* loaded from: classes5.dex */
public final class CoreFragmentFactory extends FragmentFactory {

    /* renamed from: a */
    private final Map<Class<? extends Fragment>, Provider<Fragment>> f40790a;

    public CoreFragmentFactory(Map<Class<? extends Fragment>, Provider<Fragment>> fragmentFactories) {
        Intrinsics.f(fragmentFactories, "fragmentFactories");
        this.f40790a = fragmentFactories;
    }

    public static /* synthetic */ Fragment b(CoreFragmentFactory coreFragmentFactory, Context context, Class cls, Bundle bundle, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            bundle = null;
        }
        return coreFragmentFactory.a(context, cls, bundle);
    }

    public final <T extends Fragment> T a(Context context, Class<T> clazz, Bundle bundle) {
        Intrinsics.f(context, "context");
        Intrinsics.f(clazz, "clazz");
        ClassLoader classLoader = context.getClassLoader();
        Intrinsics.e(classLoader, "context.classLoader");
        String name = clazz.getName();
        Intrinsics.e(name, "clazz.name");
        T t7 = (T) instantiate(classLoader, name);
        t7.setArguments(bundle);
        Intrinsics.d(t7, "null cannot be cast to non-null type T of eu.bolt.driver.core.di.helper.CoreFragmentFactory.instantiate");
        return t7;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public Fragment instantiate(ClassLoader classLoader, String className) {
        Fragment fragment;
        Intrinsics.f(classLoader, "classLoader");
        Intrinsics.f(className, "className");
        Class<?> cls = Class.forName(className, false, classLoader);
        Provider<Fragment> provider = this.f40790a.get(cls);
        if (provider != null) {
            fragment = provider.get();
        } else {
            fragment = null;
        }
        if (fragment == null) {
            Object newInstance = cls.newInstance();
            Intrinsics.d(newInstance, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            return (Fragment) newInstance;
        }
        return fragment;
    }
}
