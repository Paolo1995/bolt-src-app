package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: m0  reason: collision with root package name */
    static final int[] f8053m0 = {16842931};

    /* renamed from: n0  reason: collision with root package name */
    private static final Comparator<ItemInfo> f8054n0 = new Comparator<ItemInfo>() { // from class: androidx.viewpager.widget.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f8094b - itemInfo2.f8094b;
        }
    };

    /* renamed from: o0  reason: collision with root package name */
    private static final Interpolator f8055o0 = new Interpolator() { // from class: androidx.viewpager.widget.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    };

    /* renamed from: p0  reason: collision with root package name */
    private static final ViewPositionComparator f8056p0 = new ViewPositionComparator();
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private float K;
    private float L;
    private int M;
    private VelocityTracker N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private EdgeEffect T;
    private EdgeEffect U;
    private boolean V;
    private boolean W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f8057a0;

    /* renamed from: b0  reason: collision with root package name */
    private int f8058b0;

    /* renamed from: c0  reason: collision with root package name */
    private List<OnPageChangeListener> f8059c0;

    /* renamed from: d0  reason: collision with root package name */
    private OnPageChangeListener f8060d0;

    /* renamed from: e0  reason: collision with root package name */
    private OnPageChangeListener f8061e0;

    /* renamed from: f  reason: collision with root package name */
    private int f8062f;

    /* renamed from: f0  reason: collision with root package name */
    private List<OnAdapterChangeListener> f8063f0;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<ItemInfo> f8064g;

    /* renamed from: g0  reason: collision with root package name */
    private PageTransformer f8065g0;

    /* renamed from: h  reason: collision with root package name */
    private final ItemInfo f8066h;

    /* renamed from: h0  reason: collision with root package name */
    private int f8067h0;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f8068i;

    /* renamed from: i0  reason: collision with root package name */
    private int f8069i0;

    /* renamed from: j  reason: collision with root package name */
    PagerAdapter f8070j;

    /* renamed from: j0  reason: collision with root package name */
    private ArrayList<View> f8071j0;

    /* renamed from: k  reason: collision with root package name */
    int f8072k;

    /* renamed from: k0  reason: collision with root package name */
    private final Runnable f8073k0;

    /* renamed from: l  reason: collision with root package name */
    private int f8074l;

    /* renamed from: l0  reason: collision with root package name */
    private int f8075l0;

    /* renamed from: m  reason: collision with root package name */
    private Parcelable f8076m;

    /* renamed from: n  reason: collision with root package name */
    private ClassLoader f8077n;

    /* renamed from: o  reason: collision with root package name */
    private Scroller f8078o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8079p;

    /* renamed from: q  reason: collision with root package name */
    private PagerObserver f8080q;

    /* renamed from: r  reason: collision with root package name */
    private int f8081r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f8082s;

    /* renamed from: t  reason: collision with root package name */
    private int f8083t;

    /* renamed from: u  reason: collision with root package name */
    private int f8084u;

    /* renamed from: v  reason: collision with root package name */
    private float f8085v;

    /* renamed from: w  reason: collision with root package name */
    private float f8086w;

    /* renamed from: x  reason: collision with root package name */
    private int f8087x;

    /* renamed from: y  reason: collision with root package name */
    private int f8088y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f8089z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface DecorView {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ItemInfo {

        /* renamed from: a  reason: collision with root package name */
        Object f8093a;

        /* renamed from: b  reason: collision with root package name */
        int f8094b;

        /* renamed from: c  reason: collision with root package name */
        boolean f8095c;

        /* renamed from: d  reason: collision with root package name */
        float f8096d;

        /* renamed from: e  reason: collision with root package name */
        float f8097e;

        ItemInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean n() {
            PagerAdapter pagerAdapter = ViewPager.this.f8070j;
            if (pagerAdapter != null && pagerAdapter.getCount() > 1) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = ViewPager.this.f8070j) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.f8072k);
                accessibilityEvent.setToIndex(ViewPager.this.f8072k);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.Y(ViewPager.class.getName());
            accessibilityNodeInfoCompat.s0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(FragmentTransaction.TRANSIT_EXIT_MASK);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean j(View view, int i8, Bundle bundle) {
            if (super.j(view, i8, bundle)) {
                return true;
            }
            if (i8 != 4096) {
                if (i8 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f8072k - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f8072k + 1);
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnAdapterChangeListener {
        void b(@NonNull ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes.dex */
    public interface OnPageChangeListener {
        void a(int i8, float f8, int i9);

        void c(int i8);

        void d(int i8);
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
        void a(@NonNull View view, float f8);
    }

    /* loaded from: classes.dex */
    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.h();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.h();
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager.widget.ViewPager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        int f8106h;

        /* renamed from: i  reason: collision with root package name */
        Parcelable f8107i;

        /* renamed from: j  reason: collision with root package name */
        ClassLoader f8108j;

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f8106h + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f8106h);
            parcel.writeParcelable(this.f8107i, i8);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f8106h = parcel.readInt();
            this.f8107i = parcel.readParcelable(classLoader);
            this.f8108j = classLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z7 = layoutParams.f8098a;
            if (z7 != layoutParams2.f8098a) {
                if (z7) {
                    return 1;
                }
                return -1;
            }
            return layoutParams.f8102e - layoutParams2.f8102e;
        }
    }

    public ViewPager(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8064g = new ArrayList<>();
        this.f8066h = new ItemInfo();
        this.f8068i = new Rect();
        this.f8074l = -1;
        this.f8076m = null;
        this.f8077n = null;
        this.f8085v = -3.4028235E38f;
        this.f8086w = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.f8073k0 = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.E();
            }
        };
        this.f8075l0 = 0;
        v();
    }

    private boolean C(int i8) {
        if (this.f8064g.size() == 0) {
            if (this.V) {
                return false;
            }
            this.f8057a0 = false;
            y(0, 0.0f, 0);
            if (this.f8057a0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo t7 = t();
        int clientWidth = getClientWidth();
        int i9 = this.f8081r;
        int i10 = clientWidth + i9;
        float f8 = clientWidth;
        int i11 = t7.f8094b;
        float f9 = ((i8 / f8) - t7.f8097e) / (t7.f8096d + (i9 / f8));
        this.f8057a0 = false;
        y(i11, f9, (int) (i10 * f9));
        if (this.f8057a0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean D(float f8) {
        boolean z7;
        boolean z8;
        float f9 = this.I - f8;
        this.I = f8;
        float scrollX = getScrollX() + f9;
        float clientWidth = getClientWidth();
        float f10 = this.f8085v * clientWidth;
        float f11 = this.f8086w * clientWidth;
        boolean z9 = false;
        ItemInfo itemInfo = this.f8064g.get(0);
        ArrayList<ItemInfo> arrayList = this.f8064g;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.f8094b != 0) {
            f10 = itemInfo.f8097e * clientWidth;
            z7 = false;
        } else {
            z7 = true;
        }
        if (itemInfo2.f8094b != this.f8070j.getCount() - 1) {
            f11 = itemInfo2.f8097e * clientWidth;
            z8 = false;
        } else {
            z8 = true;
        }
        if (scrollX < f10) {
            if (z7) {
                this.T.onPull(Math.abs(f10 - scrollX) / clientWidth);
                z9 = true;
            }
            scrollX = f10;
        } else if (scrollX > f11) {
            if (z8) {
                this.U.onPull(Math.abs(scrollX - f11) / clientWidth);
                z9 = true;
            }
            scrollX = f11;
        }
        int i8 = (int) scrollX;
        this.I += scrollX - i8;
        scrollTo(i8, getScrollY());
        C(i8);
        return z9;
    }

    private void G(int i8, int i9, int i10, int i11) {
        float f8;
        if (i9 > 0 && !this.f8064g.isEmpty()) {
            if (!this.f8078o.isFinished()) {
                this.f8078o.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            scrollTo((int) ((getScrollX() / (((i9 - getPaddingLeft()) - getPaddingRight()) + i11)) * (((i8 - getPaddingLeft()) - getPaddingRight()) + i10)), getScrollY());
            return;
        }
        ItemInfo u7 = u(this.f8072k);
        if (u7 != null) {
            f8 = Math.min(u7.f8097e, this.f8086w);
        } else {
            f8 = 0.0f;
        }
        int paddingLeft = (int) (f8 * ((i8 - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            g(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private void H() {
        int i8 = 0;
        while (i8 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i8).getLayoutParams()).f8098a) {
                removeViewAt(i8);
                i8--;
            }
            i8++;
        }
    }

    private void K(boolean z7) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z7);
        }
    }

    private boolean L() {
        this.M = -1;
        o();
        this.T.onRelease();
        this.U.onRelease();
        if (!this.T.isFinished() && !this.U.isFinished()) {
            return false;
        }
        return true;
    }

    private void M(int i8, boolean z7, int i9, boolean z8) {
        int i10;
        ItemInfo u7 = u(i8);
        if (u7 != null) {
            i10 = (int) (getClientWidth() * Math.max(this.f8085v, Math.min(u7.f8097e, this.f8086w)));
        } else {
            i10 = 0;
        }
        if (z7) {
            R(i10, 0, i9);
            if (z8) {
                k(i8);
                return;
            }
            return;
        }
        if (z8) {
            k(i8);
        }
        g(false);
        scrollTo(i10, 0);
        C(i10);
    }

    private void S() {
        if (this.f8069i0 != 0) {
            ArrayList<View> arrayList = this.f8071j0;
            if (arrayList == null) {
                this.f8071j0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                this.f8071j0.add(getChildAt(i8));
            }
            Collections.sort(this.f8071j0, f8056p0);
        }
    }

    private void e(ItemInfo itemInfo, int i8, ItemInfo itemInfo2) {
        float f8;
        float f9;
        float f10;
        int i9;
        int i10;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.f8070j.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f8 = this.f8081r / clientWidth;
        } else {
            f8 = 0.0f;
        }
        if (itemInfo2 != null) {
            int i11 = itemInfo2.f8094b;
            int i12 = itemInfo.f8094b;
            if (i11 < i12) {
                float f11 = itemInfo2.f8097e + itemInfo2.f8096d + f8;
                int i13 = i11 + 1;
                int i14 = 0;
                while (i13 <= itemInfo.f8094b && i14 < this.f8064g.size()) {
                    ItemInfo itemInfo5 = this.f8064g.get(i14);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i13 <= itemInfo4.f8094b || i14 >= this.f8064g.size() - 1) {
                            break;
                        }
                        i14++;
                        itemInfo5 = this.f8064g.get(i14);
                    }
                    while (i13 < itemInfo4.f8094b) {
                        f11 += this.f8070j.getPageWidth(i13) + f8;
                        i13++;
                    }
                    itemInfo4.f8097e = f11;
                    f11 += itemInfo4.f8096d + f8;
                    i13++;
                }
            } else if (i11 > i12) {
                int size = this.f8064g.size() - 1;
                float f12 = itemInfo2.f8097e;
                while (true) {
                    i11--;
                    if (i11 < itemInfo.f8094b || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.f8064g.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i11 >= itemInfo3.f8094b || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.f8064g.get(size);
                    }
                    while (i11 > itemInfo3.f8094b) {
                        f12 -= this.f8070j.getPageWidth(i11) + f8;
                        i11--;
                    }
                    f12 -= itemInfo3.f8096d + f8;
                    itemInfo3.f8097e = f12;
                }
            }
        }
        int size2 = this.f8064g.size();
        float f13 = itemInfo.f8097e;
        int i15 = itemInfo.f8094b;
        int i16 = i15 - 1;
        if (i15 == 0) {
            f9 = f13;
        } else {
            f9 = -3.4028235E38f;
        }
        this.f8085v = f9;
        int i17 = count - 1;
        if (i15 == i17) {
            f10 = (itemInfo.f8096d + f13) - 1.0f;
        } else {
            f10 = Float.MAX_VALUE;
        }
        this.f8086w = f10;
        int i18 = i8 - 1;
        while (i18 >= 0) {
            ItemInfo itemInfo7 = this.f8064g.get(i18);
            while (true) {
                i10 = itemInfo7.f8094b;
                if (i16 <= i10) {
                    break;
                }
                f13 -= this.f8070j.getPageWidth(i16) + f8;
                i16--;
            }
            f13 -= itemInfo7.f8096d + f8;
            itemInfo7.f8097e = f13;
            if (i10 == 0) {
                this.f8085v = f13;
            }
            i18--;
            i16--;
        }
        float f14 = itemInfo.f8097e + itemInfo.f8096d + f8;
        int i19 = itemInfo.f8094b + 1;
        int i20 = i8 + 1;
        while (i20 < size2) {
            ItemInfo itemInfo8 = this.f8064g.get(i20);
            while (true) {
                i9 = itemInfo8.f8094b;
                if (i19 >= i9) {
                    break;
                }
                f14 += this.f8070j.getPageWidth(i19) + f8;
                i19++;
            }
            if (i9 == i17) {
                this.f8086w = (itemInfo8.f8096d + f14) - 1.0f;
            }
            itemInfo8.f8097e = f14;
            f14 += itemInfo8.f8096d + f8;
            i20++;
            i19++;
        }
        this.W = false;
    }

    private void g(boolean z7) {
        boolean z8;
        if (this.f8075l0 == 2) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            setScrollingCacheEnabled(false);
            if (!this.f8078o.isFinished()) {
                this.f8078o.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f8078o.getCurrX();
                int currY = this.f8078o.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        C(currX);
                    }
                }
            }
        }
        this.B = false;
        for (int i8 = 0; i8 < this.f8064g.size(); i8++) {
            ItemInfo itemInfo = this.f8064g.get(i8);
            if (itemInfo.f8095c) {
                itemInfo.f8095c = false;
                z8 = true;
            }
        }
        if (z8) {
            if (z7) {
                ViewCompat.k0(this, this.f8073k0);
            } else {
                this.f8073k0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int i(int i8, float f8, int i9, int i10) {
        float f9;
        if (Math.abs(i10) > this.Q && Math.abs(i9) > this.O) {
            if (i9 <= 0) {
                i8++;
            }
        } else {
            if (i8 >= this.f8072k) {
                f9 = 0.4f;
            } else {
                f9 = 0.6f;
            }
            i8 += (int) (f8 + f9);
        }
        if (this.f8064g.size() > 0) {
            ArrayList<ItemInfo> arrayList = this.f8064g;
            return Math.max(this.f8064g.get(0).f8094b, Math.min(i8, arrayList.get(arrayList.size() - 1).f8094b));
        }
        return i8;
    }

    private void j(int i8, float f8, int i9) {
        OnPageChangeListener onPageChangeListener = this.f8060d0;
        if (onPageChangeListener != null) {
            onPageChangeListener.a(i8, f8, i9);
        }
        List<OnPageChangeListener> list = this.f8059c0;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                OnPageChangeListener onPageChangeListener2 = this.f8059c0.get(i10);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.a(i8, f8, i9);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f8061e0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.a(i8, f8, i9);
        }
    }

    private void k(int i8) {
        OnPageChangeListener onPageChangeListener = this.f8060d0;
        if (onPageChangeListener != null) {
            onPageChangeListener.d(i8);
        }
        List<OnPageChangeListener> list = this.f8059c0;
        if (list != null) {
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                OnPageChangeListener onPageChangeListener2 = this.f8059c0.get(i9);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.d(i8);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f8061e0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.d(i8);
        }
    }

    private void l(int i8) {
        OnPageChangeListener onPageChangeListener = this.f8060d0;
        if (onPageChangeListener != null) {
            onPageChangeListener.c(i8);
        }
        List<OnPageChangeListener> list = this.f8059c0;
        if (list != null) {
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                OnPageChangeListener onPageChangeListener2 = this.f8059c0.get(i9);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.c(i8);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.f8061e0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.c(i8);
        }
    }

    private void n(boolean z7) {
        int i8;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            if (z7) {
                i8 = this.f8067h0;
            } else {
                i8 = 0;
            }
            getChildAt(i9).setLayerType(i8, null);
        }
    }

    private void o() {
        this.D = false;
        this.E = false;
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.N = null;
        }
    }

    private Rect q(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void setScrollingCacheEnabled(boolean z7) {
        if (this.A != z7) {
            this.A = z7;
        }
    }

    private ItemInfo t() {
        float f8;
        float f9;
        int i8;
        int clientWidth = getClientWidth();
        float f10 = 0.0f;
        if (clientWidth > 0) {
            f8 = getScrollX() / clientWidth;
        } else {
            f8 = 0.0f;
        }
        if (clientWidth > 0) {
            f9 = this.f8081r / clientWidth;
        } else {
            f9 = 0.0f;
        }
        ItemInfo itemInfo = null;
        float f11 = 0.0f;
        int i9 = -1;
        int i10 = 0;
        boolean z7 = true;
        while (i10 < this.f8064g.size()) {
            ItemInfo itemInfo2 = this.f8064g.get(i10);
            if (!z7 && itemInfo2.f8094b != (i8 = i9 + 1)) {
                itemInfo2 = this.f8066h;
                itemInfo2.f8097e = f10 + f11 + f9;
                itemInfo2.f8094b = i8;
                itemInfo2.f8096d = this.f8070j.getPageWidth(i8);
                i10--;
            }
            f10 = itemInfo2.f8097e;
            float f12 = itemInfo2.f8096d + f10 + f9;
            if (!z7 && f8 < f10) {
                return itemInfo;
            }
            if (f8 >= f12 && i10 != this.f8064g.size() - 1) {
                i9 = itemInfo2.f8094b;
                f11 = itemInfo2.f8096d;
                i10++;
                itemInfo = itemInfo2;
                z7 = false;
            } else {
                return itemInfo2;
            }
        }
        return itemInfo;
    }

    private static boolean w(@NonNull View view) {
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            return true;
        }
        return false;
    }

    private boolean x(float f8, float f9) {
        if ((f8 < this.G && f9 > 0.0f) || (f8 > getWidth() - this.G && f9 < 0.0f)) {
            return true;
        }
        return false;
    }

    private void z(MotionEvent motionEvent) {
        int i8;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.M) {
            if (actionIndex == 0) {
                i8 = 1;
            } else {
                i8 = 0;
            }
            this.I = motionEvent.getX(i8);
            this.M = motionEvent.getPointerId(i8);
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    boolean A() {
        int i8 = this.f8072k;
        if (i8 > 0) {
            N(i8 - 1, true);
            return true;
        }
        return false;
    }

    boolean B() {
        PagerAdapter pagerAdapter = this.f8070j;
        if (pagerAdapter != null && this.f8072k < pagerAdapter.getCount() - 1) {
            N(this.f8072k + 1, true);
            return true;
        }
        return false;
    }

    void E() {
        F(this.f8072k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void F(int r18) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.F(int):void");
    }

    public void I(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.f8063f0;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void J(@NonNull OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.f8059c0;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    public void N(int i8, boolean z7) {
        this.B = false;
        O(i8, z7, false);
    }

    void O(int i8, boolean z7, boolean z8) {
        P(i8, z7, z8, 0);
    }

    void P(int i8, boolean z7, boolean z8, int i9) {
        PagerAdapter pagerAdapter = this.f8070j;
        boolean z9 = false;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z8 && this.f8072k == i8 && this.f8064g.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i8 < 0) {
                i8 = 0;
            } else if (i8 >= this.f8070j.getCount()) {
                i8 = this.f8070j.getCount() - 1;
            }
            int i10 = this.C;
            int i11 = this.f8072k;
            if (i8 > i11 + i10 || i8 < i11 - i10) {
                for (int i12 = 0; i12 < this.f8064g.size(); i12++) {
                    this.f8064g.get(i12).f8095c = true;
                }
            }
            if (this.f8072k != i8) {
                z9 = true;
            }
            if (this.V) {
                this.f8072k = i8;
                if (z9) {
                    k(i8);
                }
                requestLayout();
                return;
            }
            F(i8);
            M(i8, z7, i9, z9);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnPageChangeListener Q(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.f8061e0;
        this.f8061e0 = onPageChangeListener;
        return onPageChangeListener2;
    }

    void R(int i8, int i9, int i10) {
        boolean z7;
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f8078o;
        if (scroller != null && !scroller.isFinished()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (this.f8079p) {
                scrollX = this.f8078o.getCurrX();
            } else {
                scrollX = this.f8078o.getStartX();
            }
            this.f8078o.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i11 = scrollX;
        int scrollY = getScrollY();
        int i12 = i8 - i11;
        int i13 = i9 - scrollY;
        if (i12 == 0 && i13 == 0) {
            g(false);
            E();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i14 = clientWidth / 2;
        float f8 = clientWidth;
        float f9 = i14;
        float m8 = f9 + (m(Math.min(1.0f, (Math.abs(i12) * 1.0f) / f8)) * f9);
        int abs2 = Math.abs(i10);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(m8 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i12) / ((f8 * this.f8070j.getPageWidth(this.f8072k)) + this.f8081r)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.f8079p = false;
        this.f8078o.startScroll(i11, scrollY, i12, i13, min);
        ViewCompat.j0(this);
    }

    ItemInfo a(int i8, int i9) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f8094b = i8;
        itemInfo.f8093a = this.f8070j.instantiateItem((ViewGroup) this, i8);
        itemInfo.f8096d = this.f8070j.getPageWidth(i8);
        if (i9 >= 0 && i9 < this.f8064g.size()) {
            this.f8064g.add(i9, itemInfo);
        } else {
            this.f8064g.add(itemInfo);
        }
        return itemInfo;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i8, int i9) {
        ItemInfo s7;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 0 && (s7 = s(childAt)) != null && s7.f8094b == this.f8072k) {
                    childAt.addFocusables(arrayList, i8, i9);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i9 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo s7;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 0 && (s7 = s(childAt)) != null && s7.f8094b == this.f8072k) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean w7 = layoutParams2.f8098a | w(view);
        layoutParams2.f8098a = w7;
        if (this.f8089z) {
            if (!w7) {
                layoutParams2.f8101d = true;
                addViewInLayout(view, i8, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i8, layoutParams);
    }

    public void b(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.f8063f0 == null) {
            this.f8063f0 = new ArrayList();
        }
        this.f8063f0.add(onAdapterChangeListener);
    }

    public void c(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.f8059c0 == null) {
            this.f8059c0 = new ArrayList();
        }
        this.f8059c0.add(onPageChangeListener);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i8) {
        if (this.f8070j == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i8 < 0) {
            if (scrollX <= ((int) (clientWidth * this.f8085v))) {
                return false;
            }
            return true;
        } else if (i8 <= 0 || scrollX >= ((int) (clientWidth * this.f8086w))) {
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f8079p = true;
        if (!this.f8078o.isFinished() && this.f8078o.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f8078o.getCurrX();
            int currY = this.f8078o.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!C(currX)) {
                    this.f8078o.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.j0(this);
            return;
        }
        g(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto Lb
        L9:
            r0 = r3
            goto L69
        Lb:
            if (r0 == 0) goto L69
            android.view.ViewParent r4 = r0.getParent()
        L11:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1e
            if (r4 != r6) goto L19
            r4 = 1
            goto L1f
        L19:
            android.view.ViewParent r4 = r4.getParent()
            goto L11
        L1e:
            r4 = 0
        L1f:
            if (r4 != 0) goto L69
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L35:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L35
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L9
        L69:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto Lba
            if (r3 == r0) goto Lba
            if (r7 != r5) goto L9a
            android.graphics.Rect r1 = r6.f8068i
            android.graphics.Rect r1 = r6.q(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f8068i
            android.graphics.Rect r2 = r6.q(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L94
            if (r1 < r2) goto L94
            boolean r0 = r6.A()
            goto L98
        L94:
            boolean r0 = r3.requestFocus()
        L98:
            r2 = r0
            goto Lcd
        L9a:
            if (r7 != r4) goto Lcd
            android.graphics.Rect r1 = r6.f8068i
            android.graphics.Rect r1 = r6.q(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.f8068i
            android.graphics.Rect r2 = r6.q(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto Lb5
            if (r1 > r2) goto Lb5
            boolean r0 = r6.B()
            goto L98
        Lb5:
            boolean r0 = r3.requestFocus()
            goto L98
        Lba:
            if (r7 == r5) goto Lc9
            if (r7 != r1) goto Lbf
            goto Lc9
        Lbf:
            if (r7 == r4) goto Lc4
            r0 = 2
            if (r7 != r0) goto Lcd
        Lc4:
            boolean r2 = r6.B()
            goto Lcd
        Lc9:
            boolean r2 = r6.A()
        Lcd:
            if (r2 == 0) goto Ld6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.d(int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !p(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo s7;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 0 && (s7 = s(childAt)) != null && s7.f8094b == this.f8072k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z7 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f8070j) == null || pagerAdapter.getCount() <= 1)) {
            this.T.finish();
            this.U.finish();
        } else {
            if (!this.T.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f8085v * width);
                this.T.setSize(height, width);
                z7 = false | this.T.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.U.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f8086w + 1.0f)) * width2);
                this.U.setSize(height2, width2);
                z7 |= this.U.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z7) {
            ViewCompat.j0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8082s;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    protected boolean f(View view, boolean z7, int i8, int i9, int i10) {
        int i11;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i12 = i9 + scrollX;
                if (i12 >= childAt.getLeft() && i12 < childAt.getRight() && (i11 = i10 + scrollY) >= childAt.getTop() && i11 < childAt.getBottom() && f(childAt, true, i8, i12 - childAt.getLeft(), i11 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z7 && view.canScrollHorizontally(-i8)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.f8070j;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i8, int i9) {
        if (this.f8069i0 == 2) {
            i9 = (i8 - 1) - i9;
        }
        return ((LayoutParams) this.f8071j0.get(i9).getLayoutParams()).f8103f;
    }

    public int getCurrentItem() {
        return this.f8072k;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getPageMargin() {
        return this.f8081r;
    }

    void h() {
        boolean z7;
        int count = this.f8070j.getCount();
        this.f8062f = count;
        if (this.f8064g.size() < (this.C * 2) + 1 && this.f8064g.size() < count) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i8 = this.f8072k;
        int i9 = 0;
        boolean z8 = false;
        while (i9 < this.f8064g.size()) {
            ItemInfo itemInfo = this.f8064g.get(i9);
            int itemPosition = this.f8070j.getItemPosition(itemInfo.f8093a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f8064g.remove(i9);
                    i9--;
                    if (!z8) {
                        this.f8070j.startUpdate((ViewGroup) this);
                        z8 = true;
                    }
                    this.f8070j.destroyItem((ViewGroup) this, itemInfo.f8094b, itemInfo.f8093a);
                    int i10 = this.f8072k;
                    if (i10 == itemInfo.f8094b) {
                        i8 = Math.max(0, Math.min(i10, count - 1));
                    }
                } else {
                    int i11 = itemInfo.f8094b;
                    if (i11 != itemPosition) {
                        if (i11 == this.f8072k) {
                            i8 = itemPosition;
                        }
                        itemInfo.f8094b = itemPosition;
                    }
                }
                z7 = true;
            }
            i9++;
        }
        if (z8) {
            this.f8070j.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f8064g, f8054n0);
        if (z7) {
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i12).getLayoutParams();
                if (!layoutParams.f8098a) {
                    layoutParams.f8100c = 0.0f;
                }
            }
            O(i8, false, true);
            requestLayout();
        }
    }

    float m(float f8) {
        return (float) Math.sin((f8 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f8073k0);
        Scroller scroller = this.f8078o;
        if (scroller != null && !scroller.isFinished()) {
            this.f8078o.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i8;
        float f8;
        float f9;
        super.onDraw(canvas);
        if (this.f8081r > 0 && this.f8082s != null && this.f8064g.size() > 0 && this.f8070j != null) {
            int scrollX = getScrollX();
            float width2 = getWidth();
            float f10 = this.f8081r / width2;
            int i9 = 0;
            ItemInfo itemInfo = this.f8064g.get(0);
            float f11 = itemInfo.f8097e;
            int size = this.f8064g.size();
            int i10 = itemInfo.f8094b;
            int i11 = this.f8064g.get(size - 1).f8094b;
            while (i10 < i11) {
                while (true) {
                    i8 = itemInfo.f8094b;
                    if (i10 <= i8 || i9 >= size) {
                        break;
                    }
                    i9++;
                    itemInfo = this.f8064g.get(i9);
                }
                if (i10 == i8) {
                    float f12 = itemInfo.f8097e;
                    float f13 = itemInfo.f8096d;
                    f8 = (f12 + f13) * width2;
                    f11 = f12 + f13 + f10;
                } else {
                    float pageWidth = this.f8070j.getPageWidth(i10);
                    f8 = (f11 + pageWidth) * width2;
                    f11 += pageWidth + f10;
                }
                if (this.f8081r + f8 > scrollX) {
                    f9 = f10;
                    this.f8082s.setBounds(Math.round(f8), this.f8083t, Math.round(this.f8081r + f8), this.f8084u);
                    this.f8082s.draw(canvas);
                } else {
                    f9 = f10;
                }
                if (f8 <= scrollX + width) {
                    i10++;
                    f10 = f9;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f8;
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.D) {
                    return true;
                }
                if (this.E) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        z(motionEvent);
                    }
                } else {
                    int i8 = this.M;
                    if (i8 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i8);
                        float x7 = motionEvent.getX(findPointerIndex);
                        float f9 = x7 - this.I;
                        float abs = Math.abs(f9);
                        float y7 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y7 - this.L);
                        int i9 = (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1));
                        if (i9 != 0 && !x(this.I, f9) && f(this, false, (int) f9, (int) x7, (int) y7)) {
                            this.I = x7;
                            this.J = y7;
                            this.E = true;
                            return false;
                        }
                        int i10 = this.H;
                        if (abs > i10 && abs * 0.5f > abs2) {
                            this.D = true;
                            K(true);
                            setScrollState(1);
                            float f10 = this.K;
                            float f11 = this.H;
                            if (i9 > 0) {
                                f8 = f10 + f11;
                            } else {
                                f8 = f10 - f11;
                            }
                            this.I = f8;
                            this.J = y7;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > i10) {
                            this.E = true;
                        }
                        if (this.D && D(x7)) {
                            ViewCompat.j0(this);
                        }
                    }
                }
            } else {
                float x8 = motionEvent.getX();
                this.K = x8;
                this.I = x8;
                float y8 = motionEvent.getY();
                this.L = y8;
                this.J = y8;
                this.M = motionEvent.getPointerId(0);
                this.E = false;
                this.f8079p = true;
                this.f8078o.computeScrollOffset();
                if (this.f8075l0 == 2 && Math.abs(this.f8078o.getFinalX() - this.f8078o.getCurrX()) > this.R) {
                    this.f8078o.abortAnimation();
                    this.B = false;
                    E();
                    this.D = true;
                    K(true);
                    setScrollState(1);
                } else {
                    g(false);
                    this.D = false;
                }
            }
            if (this.N == null) {
                this.N = VelocityTracker.obtain();
            }
            this.N.addMovement(motionEvent);
            return this.D;
        }
        L();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i8, Rect rect) {
        int i9;
        int i10;
        ItemInfo s7;
        int childCount = getChildCount();
        int i11 = -1;
        if ((i8 & 2) != 0) {
            i11 = childCount;
            i9 = 0;
            i10 = 1;
        } else {
            i9 = childCount - 1;
            i10 = -1;
        }
        while (i9 != i11) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 0 && (s7 = s(childAt)) != null && s7.f8094b == this.f8072k && childAt.requestFocus(i8, rect)) {
                return true;
            }
            i9 += i10;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        PagerAdapter pagerAdapter = this.f8070j;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f8107i, savedState.f8108j);
            O(savedState.f8106h, false, true);
            return;
        }
        this.f8074l = savedState.f8106h;
        this.f8076m = savedState.f8107i;
        this.f8077n = savedState.f8108j;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8106h = this.f8072k;
        PagerAdapter pagerAdapter = this.f8070j;
        if (pagerAdapter != null) {
            savedState.f8107i = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i8 != i10) {
            int i12 = this.f8081r;
            G(i8, i10, i12, i12);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float f8;
        if (this.S) {
            return true;
        }
        boolean z7 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f8070j) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                z(motionEvent);
                                this.I = motionEvent.getX(motionEvent.findPointerIndex(this.M));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.I = motionEvent.getX(actionIndex);
                            this.M = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (this.D) {
                        M(this.f8072k, true, 0, false);
                        z7 = L();
                    }
                } else {
                    if (!this.D) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.M);
                        if (findPointerIndex == -1) {
                            z7 = L();
                        } else {
                            float x7 = motionEvent.getX(findPointerIndex);
                            float abs = Math.abs(x7 - this.I);
                            float y7 = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y7 - this.J);
                            if (abs > this.H && abs > abs2) {
                                this.D = true;
                                K(true);
                                float f9 = this.K;
                                if (x7 - f9 > 0.0f) {
                                    f8 = f9 + this.H;
                                } else {
                                    f8 = f9 - this.H;
                                }
                                this.I = f8;
                                this.J = y7;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (this.D) {
                        z7 = false | D(motionEvent.getX(motionEvent.findPointerIndex(this.M)));
                    }
                }
            } else if (this.D) {
                VelocityTracker velocityTracker = this.N;
                velocityTracker.computeCurrentVelocity(1000, this.P);
                int xVelocity = (int) velocityTracker.getXVelocity(this.M);
                this.B = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo t7 = t();
                float f10 = clientWidth;
                P(i(t7.f8094b, ((scrollX / f10) - t7.f8097e) / (t7.f8096d + (this.f8081r / f10)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.M)) - this.K)), true, true, xVelocity);
                z7 = L();
            }
        } else {
            this.f8078o.abortAnimation();
            this.B = false;
            E();
            float x8 = motionEvent.getX();
            this.K = x8;
            this.I = x8;
            float y8 = motionEvent.getY();
            this.L = y8;
            this.J = y8;
            this.M = motionEvent.getPointerId(0);
        }
        if (z7) {
            ViewCompat.j0(this);
        }
        return true;
    }

    public boolean p(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return d(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return d(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return B();
                } else {
                    return d(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return A();
            } else {
                return d(17);
            }
        }
        return false;
    }

    ItemInfo r(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return s(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f8089z) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    ItemInfo s(View view) {
        for (int i8 = 0; i8 < this.f8064g.size(); i8++) {
            ItemInfo itemInfo = this.f8064g.get(i8);
            if (this.f8070j.isViewFromObject(view, itemInfo.f8093a)) {
                return itemInfo;
            }
        }
        return null;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.f8070j;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.f8070j.startUpdate((ViewGroup) this);
            for (int i8 = 0; i8 < this.f8064g.size(); i8++) {
                ItemInfo itemInfo = this.f8064g.get(i8);
                this.f8070j.destroyItem((ViewGroup) this, itemInfo.f8094b, itemInfo.f8093a);
            }
            this.f8070j.finishUpdate((ViewGroup) this);
            this.f8064g.clear();
            H();
            this.f8072k = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f8070j;
        this.f8070j = pagerAdapter;
        this.f8062f = 0;
        if (pagerAdapter != null) {
            if (this.f8080q == null) {
                this.f8080q = new PagerObserver();
            }
            this.f8070j.setViewPagerObserver(this.f8080q);
            this.B = false;
            boolean z7 = this.V;
            this.V = true;
            this.f8062f = this.f8070j.getCount();
            if (this.f8074l >= 0) {
                this.f8070j.restoreState(this.f8076m, this.f8077n);
                O(this.f8074l, false, true);
                this.f8074l = -1;
                this.f8076m = null;
                this.f8077n = null;
            } else if (!z7) {
                E();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.f8063f0;
        if (list != null && !list.isEmpty()) {
            int size = this.f8063f0.size();
            for (int i9 = 0; i9 < size; i9++) {
                this.f8063f0.get(i9).b(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i8) {
        this.B = false;
        O(i8, !this.V, false);
    }

    public void setOffscreenPageLimit(int i8) {
        if (i8 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i8 + " too small; defaulting to 1");
            i8 = 1;
        }
        if (i8 != this.C) {
            this.C = i8;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f8060d0 = onPageChangeListener;
    }

    public void setPageMargin(int i8) {
        int i9 = this.f8081r;
        this.f8081r = i8;
        int width = getWidth();
        G(width, width, i8, i9);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f8082s = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i8) {
        boolean z7;
        if (this.f8075l0 == i8) {
            return;
        }
        this.f8075l0 = i8;
        if (this.f8065g0 != null) {
            if (i8 != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            n(z7);
        }
        l(i8);
    }

    ItemInfo u(int i8) {
        for (int i9 = 0; i9 < this.f8064g.size(); i9++) {
            ItemInfo itemInfo = this.f8064g.get(i9);
            if (itemInfo.f8094b == i8) {
                return itemInfo;
            }
        }
        return null;
    }

    void v() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f8078o = new Scroller(context, f8055o0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.H = viewConfiguration.getScaledPagingTouchSlop();
        this.O = (int) (400.0f * f8);
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new EdgeEffect(context);
        this.U = new EdgeEffect(context);
        this.Q = (int) (25.0f * f8);
        this.R = (int) (2.0f * f8);
        this.F = (int) (f8 * 16.0f);
        ViewCompat.s0(this, new MyAccessibilityDelegate());
        if (ViewCompat.C(this) == 0) {
            ViewCompat.D0(this, 1);
        }
        ViewCompat.G0(this, new OnApplyWindowInsetsListener() { // from class: androidx.viewpager.widget.ViewPager.4

            /* renamed from: a  reason: collision with root package name */
            private final Rect f8091a = new Rect();

            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat e02 = ViewCompat.e0(view, windowInsetsCompat);
                if (e02.o()) {
                    return e02;
                }
                Rect rect = this.f8091a;
                rect.left = e02.j();
                rect.top = e02.l();
                rect.right = e02.k();
                rect.bottom = e02.i();
                int childCount = ViewPager.this.getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    WindowInsetsCompat i9 = ViewCompat.i(ViewPager.this.getChildAt(i8), e02);
                    rect.left = Math.min(i9.j(), rect.left);
                    rect.top = Math.min(i9.l(), rect.top);
                    rect.right = Math.min(i9.k(), rect.right);
                    rect.bottom = Math.min(i9.i(), rect.bottom);
                }
                return e02.p(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f8082s) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void y(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f8058b0
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f8098a
            if (r10 != 0) goto L2c
            goto L68
        L2c:
            int r9 = r9.f8099b
            r9 = r9 & 7
            if (r9 == r2) goto L4d
            r10 = 3
            if (r9 == r10) goto L47
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5c
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L59
        L47:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L59:
            r11 = r9
            r9 = r3
            r3 = r11
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            r12.j(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$PageTransformer r13 = r12.f8065g0
            if (r13 == 0) goto L9f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f8098a
            if (r0 == 0) goto L8b
            goto L9c
        L8b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$PageTransformer r3 = r12.f8065g0
            r3.a(r15, r0)
        L9c:
            int r1 = r1 + 1
            goto L7a
        L9f:
            r12.f8057a0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.y(int, float, int):void");
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8098a;

        /* renamed from: b  reason: collision with root package name */
        public int f8099b;

        /* renamed from: c  reason: collision with root package name */
        float f8100c;

        /* renamed from: d  reason: collision with root package name */
        boolean f8101d;

        /* renamed from: e  reason: collision with root package name */
        int f8102e;

        /* renamed from: f  reason: collision with root package name */
        int f8103f;

        public LayoutParams() {
            super(-1, -1);
            this.f8100c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8100c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f8053m0);
            this.f8099b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i8) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i8));
    }
}
