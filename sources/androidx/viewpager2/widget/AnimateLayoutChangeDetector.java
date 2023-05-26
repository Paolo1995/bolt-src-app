package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AnimateLayoutChangeDetector {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f8146b;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f8147a;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f8146b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.f8147a = linearLayoutManager;
    }

    private boolean a() {
        boolean z7;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i8;
        int bottom;
        int i9;
        int U = this.f8147a.U();
        if (U == 0) {
            return true;
        }
        if (this.f8147a.y2() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, U, 2);
        for (int i10 = 0; i10 < U; i10++) {
            View T = this.f8147a.T(i10);
            if (T != null) {
                ViewGroup.LayoutParams layoutParams = T.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f8146b;
                }
                int[] iArr2 = iArr[i10];
                if (z7) {
                    top = T.getLeft();
                    i8 = marginLayoutParams.leftMargin;
                } else {
                    top = T.getTop();
                    i8 = marginLayoutParams.topMargin;
                }
                iArr2[0] = top - i8;
                int[] iArr3 = iArr[i10];
                if (z7) {
                    bottom = T.getRight();
                    i9 = marginLayoutParams.rightMargin;
                } else {
                    bottom = T.getBottom();
                    i9 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i9;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.widget.AnimateLayoutChangeDetector.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i11 = 1; i11 < U; i11++) {
            if (iArr[i11 - 1][1] != iArr[i11][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i12 = iArr4[1];
        int i13 = iArr4[0];
        int i14 = i12 - i13;
        if (i13 <= 0 && iArr[U - 1][1] >= i14) {
            return true;
        }
        return false;
    }

    private boolean b() {
        int U = this.f8147a.U();
        for (int i8 = 0; i8 < U; i8++) {
            if (c(this.f8147a.T(i8))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                if (c(viewGroup.getChildAt(i8))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        if ((!a() || this.f8147a.U() <= 1) && b()) {
            return true;
        }
        return false;
    }
}
