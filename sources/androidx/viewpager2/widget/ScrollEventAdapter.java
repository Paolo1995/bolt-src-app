package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f8155a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f8156b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f8157c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayoutManager f8158d;

    /* renamed from: e  reason: collision with root package name */
    private int f8159e;

    /* renamed from: f  reason: collision with root package name */
    private int f8160f;

    /* renamed from: g  reason: collision with root package name */
    private ScrollEventValues f8161g;

    /* renamed from: h  reason: collision with root package name */
    private int f8162h;

    /* renamed from: i  reason: collision with root package name */
    private int f8163i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8164j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8165k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8166l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8167m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ScrollEventValues {

        /* renamed from: a  reason: collision with root package name */
        int f8168a;

        /* renamed from: b  reason: collision with root package name */
        float f8169b;

        /* renamed from: c  reason: collision with root package name */
        int f8170c;

        ScrollEventValues() {
        }

        void a() {
            this.f8168a = -1;
            this.f8169b = 0.0f;
            this.f8170c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f8156b = viewPager2;
        RecyclerView recyclerView = viewPager2.f8181o;
        this.f8157c = recyclerView;
        this.f8158d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f8161g = new ScrollEventValues();
        n();
    }

    private void c(int i8, float f8, int i9) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f8155a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.b(i8, f8, i9);
        }
    }

    private void d(int i8) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f8155a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.c(i8);
        }
    }

    private void e(int i8) {
        if ((this.f8159e == 3 && this.f8160f == 0) || this.f8160f == i8) {
            return;
        }
        this.f8160f = i8;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f8155a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.a(i8);
        }
    }

    private int f() {
        return this.f8158d.k2();
    }

    private boolean k() {
        int i8 = this.f8159e;
        if (i8 == 1 || i8 == 4) {
            return true;
        }
        return false;
    }

    private void n() {
        this.f8159e = 0;
        this.f8160f = 0;
        this.f8161g.a();
        this.f8162h = -1;
        this.f8163i = -1;
        this.f8164j = false;
        this.f8165k = false;
        this.f8167m = false;
        this.f8166l = false;
    }

    private void p(boolean z7) {
        int i8;
        this.f8167m = z7;
        if (z7) {
            i8 = 4;
        } else {
            i8 = 1;
        }
        this.f8159e = i8;
        int i9 = this.f8163i;
        if (i9 != -1) {
            this.f8162h = i9;
            this.f8163i = -1;
        } else if (this.f8162h == -1) {
            this.f8162h = f();
        }
        e(1);
    }

    private void q() {
        boolean z7;
        int top;
        float f8;
        ScrollEventValues scrollEventValues = this.f8161g;
        int k22 = this.f8158d.k2();
        scrollEventValues.f8168a = k22;
        if (k22 == -1) {
            scrollEventValues.a();
            return;
        }
        View N = this.f8158d.N(k22);
        if (N == null) {
            scrollEventValues.a();
            return;
        }
        int l02 = this.f8158d.l0(N);
        int q02 = this.f8158d.q0(N);
        int t02 = this.f8158d.t0(N);
        int S = this.f8158d.S(N);
        ViewGroup.LayoutParams layoutParams = N.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            l02 += marginLayoutParams.leftMargin;
            q02 += marginLayoutParams.rightMargin;
            t02 += marginLayoutParams.topMargin;
            S += marginLayoutParams.bottomMargin;
        }
        int height = N.getHeight() + t02 + S;
        int width = N.getWidth() + l02 + q02;
        if (this.f8158d.y2() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            top = (N.getLeft() - l02) - this.f8157c.getPaddingLeft();
            if (this.f8156b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (N.getTop() - t02) - this.f8157c.getPaddingTop();
        }
        int i8 = -top;
        scrollEventValues.f8170c = i8;
        if (i8 < 0) {
            if (new AnimateLayoutChangeDetector(this.f8158d).d()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f8170c)));
        }
        if (height == 0) {
            f8 = 0.0f;
        } else {
            f8 = i8 / height;
        }
        scrollEventValues.f8169b = f8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void a(@NonNull RecyclerView recyclerView, int i8) {
        boolean z7 = true;
        if ((this.f8159e != 1 || this.f8160f != 1) && i8 == 1) {
            p(false);
        } else if (k() && i8 == 2) {
            if (this.f8165k) {
                e(2);
                this.f8164j = true;
            }
        } else {
            if (k() && i8 == 0) {
                q();
                if (!this.f8165k) {
                    int i9 = this.f8161g.f8168a;
                    if (i9 != -1) {
                        c(i9, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.f8161g;
                    if (scrollEventValues.f8170c == 0) {
                        int i10 = this.f8162h;
                        int i11 = scrollEventValues.f8168a;
                        if (i10 != i11) {
                            d(i11);
                        }
                    } else {
                        z7 = false;
                    }
                }
                if (z7) {
                    e(0);
                    n();
                }
            }
            if (this.f8159e == 2 && i8 == 0 && this.f8166l) {
                q();
                ScrollEventValues scrollEventValues2 = this.f8161g;
                if (scrollEventValues2.f8170c == 0) {
                    int i12 = this.f8163i;
                    int i13 = scrollEventValues2.f8168a;
                    if (i12 != i13) {
                        if (i13 == -1) {
                            i13 = 0;
                        }
                        d(i13);
                    }
                    e(0);
                    n();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r5 == r3.f8156b.d()) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f8165k = r4
            r3.q()
            boolean r0 = r3.f8164j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.f8164j = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f8156b
            boolean r6 = r6.d()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f8161g
            int r6 = r5.f8170c
            if (r6 == 0) goto L2f
            int r5 = r5.f8168a
            int r5 = r5 + r4
            goto L33
        L2f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f8161g
            int r5 = r5.f8168a
        L33:
            r3.f8163i = r5
            int r6 = r3.f8162h
            if (r6 == r5) goto L4b
            r3.d(r5)
            goto L4b
        L3d:
            int r5 = r3.f8159e
            if (r5 != 0) goto L4b
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f8161g
            int r5 = r5.f8168a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.d(r5)
        L4b:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f8161g
            int r6 = r5.f8168a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.f8169b
            int r5 = r5.f8170c
            r3.c(r6, r0, r5)
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f8161g
            int r6 = r5.f8168a
            int r0 = r3.f8163i
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f8170c
            if (r5 != 0) goto L71
            int r5 = r3.f8160f
            if (r5 == r4) goto L71
            r3.e(r2)
            r3.n()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double g() {
        q();
        ScrollEventValues scrollEventValues = this.f8161g;
        return scrollEventValues.f8168a + scrollEventValues.f8169b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f8160f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f8167m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        if (this.f8160f == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.f8166l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i8, boolean z7) {
        int i9;
        if (z7) {
            i9 = 2;
        } else {
            i9 = 3;
        }
        this.f8159e = i9;
        boolean z8 = false;
        this.f8167m = false;
        if (this.f8163i != i8) {
            z8 = true;
        }
        this.f8163i = i8;
        e(2);
        if (z8) {
            d(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f8155a = onPageChangeCallback;
    }
}
