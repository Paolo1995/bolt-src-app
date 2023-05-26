package androidx.fragment.app;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentTransaction.kt */
/* loaded from: classes.dex */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, int i8, String str, Bundle bundle) {
        Intrinsics.f(add, "$this$add");
        Intrinsics.k(4, "F");
        FragmentTransaction add2 = add.add(i8, Fragment.class, bundle, str);
        Intrinsics.e(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i8, String str, Bundle bundle, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            str = null;
        }
        if ((i9 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.f(add, "$this$add");
        Intrinsics.k(4, "F");
        FragmentTransaction add2 = add.add(i8, Fragment.class, bundle, str);
        Intrinsics.e(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction replace, int i8, String str, Bundle bundle) {
        Intrinsics.f(replace, "$this$replace");
        Intrinsics.k(4, "F");
        FragmentTransaction replace2 = replace.replace(i8, Fragment.class, bundle, str);
        Intrinsics.e(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i8, String str, Bundle bundle, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            str = null;
        }
        if ((i9 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.f(replace, "$this$replace");
        Intrinsics.k(4, "F");
        FragmentTransaction replace2 = replace.replace(i8, Fragment.class, bundle, str);
        Intrinsics.e(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, String tag, Bundle bundle) {
        Intrinsics.f(add, "$this$add");
        Intrinsics.f(tag, "tag");
        Intrinsics.k(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        Intrinsics.e(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            bundle = null;
        }
        Intrinsics.f(add, "$this$add");
        Intrinsics.f(tag, "tag");
        Intrinsics.k(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        Intrinsics.e(add2, "add(F::class.java, args, tag)");
        return add2;
    }
}
