package ee.mtakso.driver.ui.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import java.util.Map;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentFactoryImpl.kt */
/* loaded from: classes3.dex */
public final class FragmentFactoryImpl extends FragmentFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends Fragment>, Provider<Fragment>> f26232a;

    public FragmentFactoryImpl(Map<Class<? extends Fragment>, Provider<Fragment>> fragmentFactories) {
        Intrinsics.f(fragmentFactories, "fragmentFactories");
        this.f26232a = fragmentFactories;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public Fragment instantiate(ClassLoader classLoader, String className) {
        Fragment fragment;
        Intrinsics.f(classLoader, "classLoader");
        Intrinsics.f(className, "className");
        Class<?> cls = Class.forName(className, false, classLoader);
        Provider<Fragment> provider = this.f26232a.get(cls);
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
