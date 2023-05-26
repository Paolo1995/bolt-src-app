package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes5.dex */
public class LazyKt__LazyJVMKt {

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50811a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            try {
                iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f50811a = iArr;
        }
    }

    public static <T> Lazy<T> a(LazyThreadSafetyMode mode, Function0<? extends T> initializer) {
        Intrinsics.f(mode, "mode");
        Intrinsics.f(initializer, "initializer");
        int i8 = WhenMappings.f50811a[mode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(initializer);
        }
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }

    public static <T> Lazy<T> b(Function0<? extends T> initializer) {
        Intrinsics.f(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }
}
