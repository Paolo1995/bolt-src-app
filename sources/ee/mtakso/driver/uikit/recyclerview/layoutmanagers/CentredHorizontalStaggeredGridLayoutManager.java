package ee.mtakso.driver.uikit.recyclerview.layoutmanagers;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.core.text.TextUtilsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.Locale;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CentredHorizontalStaggeredGridLayoutManager.kt */
/* loaded from: classes5.dex */
public final class CentredHorizontalStaggeredGridLayoutManager extends RecyclerView.LayoutManager {
    private final int A;
    private int B;
    private boolean C;
    private int[] D = new int[0];
    private int E;

    /* renamed from: x  reason: collision with root package name */
    private final int f36021x;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f36022y;

    /* renamed from: z  reason: collision with root package name */
    private final int f36023z;

    public CentredHorizontalStaggeredGridLayoutManager(int i8, boolean z7, int i9, int i10) {
        this.f36021x = i8;
        this.f36022y = z7;
        this.f36023z = i9;
        this.A = i10;
    }

    private final int X1(int[] iArr) {
        int length = iArr.length;
        int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i9 = -1;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            if (i11 < i8) {
                i9 = i10;
                i8 = i11;
            }
        }
        return i9;
    }

    private final boolean Y1() {
        if (TextUtilsCompat.a(Locale.getDefault()) != 0) {
            return true;
        }
        return false;
    }

    private final void Z1(RecyclerView.Recycler recycler, RecyclerView.State state, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[this.f36021x];
        int b8 = state.b();
        for (int i8 = 0; i8 < b8; i8++) {
            View o8 = recycler.o(i8);
            Intrinsics.e(o8, "recycler.getViewForPosition(i)");
            int X1 = X1(iArr3);
            o(o8);
            J0(o8, 0, 0);
            int v02 = ((v0() - iArr[X1]) / 2) + iArr3[X1];
            int i9 = iArr2[X1];
            int i10 = this.A;
            I0(o8, v02, i9 + i10, v02 + c2(o8), iArr2[X1 + 1] + i10);
            iArr3[X1] = iArr3[X1] + c2(o8);
        }
    }

    private final void a2(RecyclerView.Recycler recycler, RecyclerView.State state, int[] iArr) {
        Integer W;
        int i8;
        int[] iArr2 = new int[this.f36021x];
        int b8 = state.b();
        int i9 = 0;
        for (int i10 = 0; i10 < b8; i10++) {
            View o8 = recycler.o(i10);
            Intrinsics.e(o8, "recycler.getViewForPosition(i)");
            int X1 = X1(iArr2);
            o(o8);
            J0(o8, 0, 0);
            int i11 = iArr[X1];
            int i12 = this.A;
            int i13 = i11 + i12;
            int i14 = iArr[X1 + 1] + i12;
            if (Y1()) {
                i8 = (((v0() + this.B) - iArr2[X1]) - c2(o8)) - this.f36023z;
            } else {
                i8 = this.B + iArr2[X1] + this.f36023z;
            }
            int i15 = i8;
            I0(o8, i15, i13, i15 + c2(o8), i14);
            iArr2[X1] = iArr2[X1] + c2(o8);
        }
        W = ArraysKt___ArraysKt.W(iArr2);
        if (W != null) {
            i9 = W.intValue();
        }
        this.E = i9;
    }

    private final int b2(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Integer num;
        List p8;
        int y02;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Integer num2 = null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        Integer[] numArr = new Integer[3];
        numArr[0] = Integer.valueOf(view.getMeasuredHeight());
        if (marginLayoutParams != null) {
            num = Integer.valueOf(marginLayoutParams.topMargin);
        } else {
            num = null;
        }
        numArr[1] = num;
        if (marginLayoutParams != null) {
            num2 = Integer.valueOf(marginLayoutParams.topMargin);
        }
        numArr[2] = num2;
        p8 = CollectionsKt__CollectionsKt.p(numArr);
        y02 = CollectionsKt___CollectionsKt.y0(p8);
        return y02;
    }

    private final int c2(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Integer num;
        List p8;
        int y02;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Integer num2 = null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        Integer[] numArr = new Integer[3];
        numArr[0] = Integer.valueOf(view.getMeasuredWidth());
        if (marginLayoutParams != null) {
            num = Integer.valueOf(marginLayoutParams.leftMargin);
        } else {
            num = null;
        }
        numArr[1] = num;
        if (marginLayoutParams != null) {
            num2 = Integer.valueOf(marginLayoutParams.rightMargin);
        }
        numArr[2] = num2;
        p8 = CollectionsKt__CollectionsKt.p(numArr);
        y02 = CollectionsKt___CollectionsKt.y0(p8);
        return y02;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int G1(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int b8;
        if (recycler != null && state != null) {
            if (Y1()) {
                b8 = MathUtils.b(this.B - i8, 0, (this.E - v0()) + this.f36023z);
            } else {
                b8 = MathUtils.b(this.B - i8, -((this.E - v0()) + this.f36023z), 0);
            }
            this.B = b8;
            H(recycler);
            a2(recycler, state, this.D);
            return i8;
        }
        return super.G1(i8, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams O() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void g1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z7;
        super.g1(recycler, state);
        if (recycler != null && state != null) {
            int i8 = this.f36021x;
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int b8 = state.b();
            boolean z8 = false;
            for (int i9 = 0; i9 < b8; i9++) {
                View o8 = recycler.o(i9);
                Intrinsics.e(o8, "recycler.getViewForPosition(i)");
                o8.measure(View.MeasureSpec.makeMeasureSpec(v0(), 0), View.MeasureSpec.makeMeasureSpec(h0(), 0));
                int X1 = X1(iArr);
                iArr[X1] = iArr[X1] + c2(o8);
                iArr2[X1] = Math.max(iArr2[X1], b2(o8));
            }
            int i10 = this.f36021x;
            this.D = new int[i10 + 1];
            for (int i11 = 0; i11 < i10; i11++) {
                if (i11 > 0) {
                    int[] iArr3 = this.D;
                    int i12 = i11 - 1;
                    iArr3[i11] = iArr2[i12] + iArr3[i12];
                }
            }
            int[] iArr4 = this.D;
            iArr4[iArr4.length - 1] = iArr4[iArr4.length - 2] + iArr2[iArr4.length - 2];
            int i13 = 0;
            while (true) {
                if (i13 >= i8) {
                    break;
                }
                if (iArr[i13] > v0()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    z8 = true;
                    break;
                }
                i13++;
            }
            this.C = z8;
            H(recycler);
            if (!this.C && !this.f36022y) {
                Z1(recycler, state, iArr, this.D);
            } else {
                a2(recycler, state, this.D);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean v() {
        return this.C;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean z0() {
        return true;
    }
}
