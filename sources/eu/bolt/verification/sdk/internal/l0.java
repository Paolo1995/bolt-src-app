package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.d;
import eu.bolt.verification.sdk.internal.ha;
import eu.bolt.verification.sdk.internal.ll;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l0 {

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43929a;

        static {
            int[] iArr = new int[b1.b.values().length];
            try {
                iArr[b1.b.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b1.b.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b1.b.DANGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b1.b.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f43929a = iArr;
        }
    }

    private final ha.a.b a(b1.b bVar) {
        int i8 = a.f43929a[bVar.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return ha.a.b.TEXT;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return ha.a.b.DANGER;
            }
            return ha.a.b.SECONDARY;
        }
        return ha.a.b.PRIMARY;
    }

    public final ha b(d.C0042d from) {
        int v7;
        Intrinsics.f(from, "from");
        ll.d c8 = ll.f44093f.c(from.d());
        ll.b bVar = new ll.b(from.c());
        ha.b bVar2 = ha.b.START;
        List<b1> b8 = from.b();
        v7 = CollectionsKt__IterablesKt.v(b8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (b1 b1Var : b8) {
            arrayList.add(new ha.a(ll.f44093f.c(b1Var.c()), a(b1Var.d()), new ha.a.AbstractC0058a.C0059a(new k0(b1Var.b()))));
        }
        return new ha(c8, bVar, arrayList, false, bVar2, bVar2, 8, null);
    }
}
