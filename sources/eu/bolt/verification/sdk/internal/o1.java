package eu.bolt.verification.sdk.internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class o1 {

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44370a;

        static {
            int[] iArr = new int[n1.values().length];
            try {
                iArr[n1.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[n1.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f44370a = iArr;
        }
    }

    public final wl a(n1 from) {
        Intrinsics.f(from, "from");
        int i8 = a.f44370a[from.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return qb.f44642g;
            }
            throw new NoWhenBranchMatchedException();
        }
        return p3.f44499g;
    }
}
