package eu.bolt.verification.sdk.internal;

import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.verification.sdk.internal.k7;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class z7 {

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45822a;

        static {
            int[] iArr = new int[k7.a.values().length];
            try {
                iArr[k7.a.CLOSE_FORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k7.a.GO_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[k7.a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f45822a = iArr;
        }
    }

    public final DesignToolbarView.c a(k7.a from) {
        Intrinsics.f(from, "from");
        int i8 = a.f45822a[from.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return DesignToolbarView.c.C0026c.f40252h;
                }
                throw new NoWhenBranchMatchedException();
            }
            return DesignToolbarView.c.a.f40250h;
        }
        return DesignToolbarView.c.b.f40251h;
    }
}
