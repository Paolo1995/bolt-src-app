package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l4 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f43991a;

    /* renamed from: b  reason: collision with root package name */
    private final List<i4> f43992b;

    /* loaded from: classes5.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int a8;
            a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((i4) t8).h().a()), Integer.valueOf(((i4) t7).h().a()));
            return a8;
        }
    }

    public l4(Context context) {
        Intrinsics.f(context, "context");
        this.f43991a = context;
        this.f43992b = new ArrayList();
    }

    public static /* synthetic */ h4 a(l4 l4Var, vq vqVar, h4 h4Var, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            h4Var = null;
        }
        return l4Var.b(vqVar, h4Var);
    }

    private final j4 c() {
        j4 j4Var = new j4(this.f43991a, null, 0, 6, null);
        j4Var.setId(View.generateViewId());
        j4Var.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -2));
        return j4Var;
    }

    private final boolean h() {
        Object W;
        if (this.f43992b.size() == 2) {
            W = CollectionsKt___CollectionsKt.W(this.f43992b);
            if (!((i4) W).j()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final eu.bolt.verification.sdk.internal.h4 b(eu.bolt.verification.sdk.internal.vq r4, eu.bolt.verification.sdk.internal.h4 r5) {
        /*
            r3 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.util.List<eu.bolt.verification.sdk.internal.i4> r0 = r3.f43992b
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto Lf
            return r1
        Lf:
            if (r5 == 0) goto L17
            eu.bolt.verification.sdk.internal.j4 r5 = r5.b()
            if (r5 != 0) goto L1b
        L17:
            eu.bolt.verification.sdk.internal.j4 r5 = r3.c()
        L1b:
            int r0 = r4.c()
            java.util.List<eu.bolt.verification.sdk.internal.i4> r2 = r3.f43992b
            int r2 = r2.size()
            if (r0 >= r2) goto L34
            java.util.List<eu.bolt.verification.sdk.internal.i4> r0 = r3.f43992b
            int r4 = r4.c()
            java.lang.Object r4 = r0.get(r4)
        L31:
            eu.bolt.verification.sdk.internal.i4 r4 = (eu.bolt.verification.sdk.internal.i4) r4
            goto L42
        L34:
            boolean r4 = r3.h()
            if (r4 == 0) goto L41
            java.util.List<eu.bolt.verification.sdk.internal.i4> r4 = r3.f43992b
            java.lang.Object r4 = kotlin.collections.CollectionsKt.W(r4)
            goto L31
        L41:
            r4 = r1
        L42:
            if (r4 == 0) goto L49
            eu.bolt.verification.sdk.internal.h4 r1 = new eu.bolt.verification.sdk.internal.h4
            r1.<init>(r5, r4)
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.l4.b(eu.bolt.verification.sdk.internal.vq, eu.bolt.verification.sdk.internal.h4):eu.bolt.verification.sdk.internal.h4");
    }

    public final void d(List<i4> items) {
        List v02;
        Intrinsics.f(items, "items");
        this.f43992b.clear();
        List<i4> list = this.f43992b;
        v02 = CollectionsKt___CollectionsKt.v0(items, new a());
        list.addAll(v02);
    }

    public final boolean e() {
        return this.f43992b.isEmpty();
    }

    public final boolean f() {
        Object W;
        if (this.f43992b.size() == 1) {
            W = CollectionsKt___CollectionsKt.W(this.f43992b);
            if (!((i4) W).j()) {
                return true;
            }
        }
        return false;
    }

    public final void g() {
        if (this.f43992b.isEmpty()) {
            return;
        }
        i4 remove = this.f43992b.remove(0);
        if (remove.j()) {
            return;
        }
        this.f43992b.add(remove);
    }
}
