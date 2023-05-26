package ee.mtakso.driver.utils.ext;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentFactoryExt.kt */
/* loaded from: classes5.dex */
public final class FragmentFactoryUtils {
    public static final <T extends Fragment> T a(FragmentFactory fragmentFactory, Context context, Class<T> clazz) {
        Intrinsics.f(fragmentFactory, "<this>");
        Intrinsics.f(context, "context");
        Intrinsics.f(clazz, "clazz");
        return (T) c(fragmentFactory, context, clazz, null, 4, null);
    }

    public static final <T extends Fragment> T b(FragmentFactory fragmentFactory, Context context, Class<T> clazz, Bundle bundle) {
        Intrinsics.f(fragmentFactory, "<this>");
        Intrinsics.f(context, "context");
        Intrinsics.f(clazz, "clazz");
        T t7 = (T) fragmentFactory.instantiate(context.getClassLoader(), clazz.getName());
        Intrinsics.e(t7, "instantiate(context.classLoader, clazz.name)");
        t7.setArguments(bundle);
        return t7;
    }

    public static /* synthetic */ Fragment c(FragmentFactory fragmentFactory, Context context, Class cls, Bundle bundle, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            bundle = null;
        }
        return b(fragmentFactory, context, cls, bundle);
    }
}
