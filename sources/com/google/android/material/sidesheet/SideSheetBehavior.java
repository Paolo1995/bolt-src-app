package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: w  reason: collision with root package name */
    private static final int f14099w = R$string.side_sheet_accessibility_pane_title;

    /* renamed from: x  reason: collision with root package name */
    private static final int f14100x = R$style.Widget_Material3_SideSheet;

    /* renamed from: a  reason: collision with root package name */
    private SheetDelegate f14101a;

    /* renamed from: b  reason: collision with root package name */
    private float f14102b;

    /* renamed from: c  reason: collision with root package name */
    private MaterialShapeDrawable f14103c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f14104d;

    /* renamed from: e  reason: collision with root package name */
    private ShapeAppearanceModel f14105e;

    /* renamed from: f  reason: collision with root package name */
    private final SideSheetBehavior<V>.StateSettlingTracker f14106f;

    /* renamed from: g  reason: collision with root package name */
    private float f14107g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14108h;

    /* renamed from: i  reason: collision with root package name */
    private int f14109i;

    /* renamed from: j  reason: collision with root package name */
    private int f14110j;

    /* renamed from: k  reason: collision with root package name */
    private ViewDragHelper f14111k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14112l;

    /* renamed from: m  reason: collision with root package name */
    private float f14113m;

    /* renamed from: n  reason: collision with root package name */
    private int f14114n;

    /* renamed from: o  reason: collision with root package name */
    private int f14115o;

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<V> f14116p;

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<View> f14117q;

    /* renamed from: r  reason: collision with root package name */
    private int f14118r;

    /* renamed from: s  reason: collision with root package name */
    private VelocityTracker f14119s;

    /* renamed from: t  reason: collision with root package name */
    private int f14120t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    private final Set<SideSheetCallback> f14121u;

    /* renamed from: v  reason: collision with root package name */
    private final ViewDragHelper.Callback f14122v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class StateSettlingTracker {

        /* renamed from: a  reason: collision with root package name */
        private int f14125a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14126b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f14127c = new Runnable() { // from class: com.google.android.material.sidesheet.c
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.StateSettlingTracker.this.c();
            }
        };

        StateSettlingTracker() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f14126b = false;
            if (SideSheetBehavior.this.f14111k != null && SideSheetBehavior.this.f14111k.m(true)) {
                b(this.f14125a);
            } else if (SideSheetBehavior.this.f14109i == 2) {
                SideSheetBehavior.this.s0(this.f14125a);
            }
        }

        void b(int i8) {
            if (SideSheetBehavior.this.f14116p != null && SideSheetBehavior.this.f14116p.get() != null) {
                this.f14125a = i8;
                if (!this.f14126b) {
                    ViewCompat.k0((View) SideSheetBehavior.this.f14116p.get(), this.f14127c);
                    this.f14126b = true;
                }
            }
        }
    }

    public SideSheetBehavior() {
        this.f14106f = new StateSettlingTracker();
        this.f14108h = true;
        this.f14109i = 5;
        this.f14110j = 5;
        this.f14113m = 0.1f;
        this.f14118r = -1;
        this.f14121u = new LinkedHashSet();
        this.f14122v = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(@NonNull View view, int i8, int i9) {
                return MathUtils.b(i8, SideSheetBehavior.this.Z(), SideSheetBehavior.this.f14115o);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(@NonNull View view, int i8, int i9) {
                return view.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int d(@NonNull View view) {
                return SideSheetBehavior.this.f14115o;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i8) {
                if (i8 == 1 && SideSheetBehavior.this.f14108h) {
                    SideSheetBehavior.this.s0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(@NonNull View view, int i8, int i9, int i10, int i11) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                View X = SideSheetBehavior.this.X();
                if (X != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) X.getLayoutParams()) != null) {
                    SideSheetBehavior.this.f14101a.h(marginLayoutParams, view.getLeft(), view.getRight());
                    X.setLayoutParams(marginLayoutParams);
                }
                SideSheetBehavior.this.T(view, i8);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void l(@NonNull View view, float f8, float f9) {
                int b8 = SideSheetBehavior.this.f14101a.b(view, f8, f9);
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                sideSheetBehavior.w0(view, b8, sideSheetBehavior.v0());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(@NonNull View view, int i8) {
                if (SideSheetBehavior.this.f14109i == 1 || SideSheetBehavior.this.f14116p == null || SideSheetBehavior.this.f14116p.get() != view) {
                    return false;
                }
                return true;
            }
        };
    }

    private int O(int i8, V v7) {
        int i9 = this.f14109i;
        if (i9 != 1 && i9 != 2) {
            if (i9 != 3) {
                if (i9 == 5) {
                    return this.f14101a.d();
                }
                throw new IllegalStateException("Unexpected value: " + this.f14109i);
            }
            return 0;
        }
        return i8 - this.f14101a.e(v7);
    }

    private float P(float f8, float f9) {
        return Math.abs(f8 - f9);
    }

    private void Q() {
        WeakReference<View> weakReference = this.f14117q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f14117q = null;
    }

    private AccessibilityViewCommand R(final int i8) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.a
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                boolean i02;
                i02 = SideSheetBehavior.this.i0(i8, view, commandArguments);
                return i02;
            }
        };
    }

    private void S(@NonNull Context context) {
        if (this.f14105e == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f14105e);
        this.f14103c = materialShapeDrawable;
        materialShapeDrawable.R(context);
        ColorStateList colorStateList = this.f14104d;
        if (colorStateList != null) {
            this.f14103c.c0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842801, typedValue, true);
        this.f14103c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(@NonNull View view, int i8) {
        if (!this.f14121u.isEmpty()) {
            float a8 = this.f14101a.a(i8);
            for (SideSheetCallback sideSheetCallback : this.f14121u) {
                sideSheetCallback.b(view, a8);
            }
        }
    }

    private void U(View view) {
        if (ViewCompat.r(view) == null) {
            ViewCompat.v0(view, view.getResources().getString(f14099w));
        }
    }

    private int V(int i8, int i9, int i10, int i11) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, i9, i11);
        if (i10 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i10 = Math.min(size, i10);
            }
            return View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i10), Pow2.MAX_POW2);
    }

    private int Y() {
        return 0;
    }

    private boolean g0(@NonNull MotionEvent motionEvent) {
        if (!t0() || P(this.f14120t, motionEvent.getX()) <= this.f14111k.z()) {
            return false;
        }
        return true;
    }

    private boolean h0(@NonNull V v7) {
        ViewParent parent = v7.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.V(v7)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i0(int i8, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        r0(i8);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i8) {
        V v7 = this.f14116p.get();
        if (v7 != null) {
            w0(v7, i8, false);
        }
    }

    private void k0(@NonNull CoordinatorLayout coordinatorLayout) {
        int i8;
        View findViewById;
        if (this.f14117q == null && (i8 = this.f14118r) != -1 && (findViewById = coordinatorLayout.findViewById(i8)) != null) {
            this.f14117q = new WeakReference<>(findViewById);
        }
    }

    private void l0(V v7, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i8) {
        ViewCompat.o0(v7, accessibilityActionCompat, null, R(i8));
    }

    private void m0() {
        VelocityTracker velocityTracker = this.f14119s;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f14119s = null;
        }
    }

    private void n0(@NonNull V v7, Runnable runnable) {
        if (h0(v7)) {
            v7.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void q0(int i8) {
        SheetDelegate sheetDelegate = this.f14101a;
        if (sheetDelegate != null && sheetDelegate.f() == i8) {
            return;
        }
        if (i8 == 0) {
            this.f14101a = new RightSheetDelegate(this);
            return;
        }
        throw new IllegalArgumentException("Invalid sheet edge position value: " + i8 + ". Must be 0");
    }

    private boolean t0() {
        if (this.f14111k != null && (this.f14108h || this.f14109i == 1)) {
            return true;
        }
        return false;
    }

    private boolean u0(@NonNull V v7) {
        if ((v7.isShown() || ViewCompat.r(v7) != null) && this.f14108h) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(View view, int i8, boolean z7) {
        if (this.f14101a.g(view, i8, z7)) {
            s0(2);
            this.f14106f.b(i8);
            return;
        }
        s0(i8);
    }

    private void x0() {
        V v7;
        WeakReference<V> weakReference = this.f14116p;
        if (weakReference == null || (v7 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.m0(v7, 262144);
        ViewCompat.m0(v7, 1048576);
        if (this.f14109i != 5) {
            l0(v7, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6061y, 5);
        }
        if (this.f14109i != 3) {
            l0(v7, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6059w, 3);
        }
    }

    private void y0(@NonNull View view) {
        int i8;
        if (this.f14109i == 5) {
            i8 = 4;
        } else {
            i8 = 0;
        }
        if (view.getVisibility() != i8) {
            view.setVisibility(i8);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
        if (!v7.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f14109i == 1 && actionMasked == 0) {
            return true;
        }
        if (t0()) {
            this.f14111k.F(motionEvent);
        }
        if (actionMasked == 0) {
            m0();
        }
        if (this.f14119s == null) {
            this.f14119s = VelocityTracker.obtain();
        }
        this.f14119s.addMovement(motionEvent);
        if (t0() && actionMasked == 2 && !this.f14112l && g0(motionEvent)) {
            this.f14111k.b(v7, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f14112l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int W() {
        return this.f14114n;
    }

    public View X() {
        WeakReference<View> weakReference = this.f14117q;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int Z() {
        return this.f14101a.c();
    }

    public float a0() {
        return this.f14113m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b0() {
        return 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c0(int i8) {
        if (i8 != 3) {
            if (i8 == 5) {
                return this.f14101a.d();
            }
            throw new IllegalArgumentException("Invalid state to get outward edge offset: " + i8);
        }
        return Z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d0() {
        return this.f14115o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e0() {
        return CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewDragHelper f0() {
        return this.f14111k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void g(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.g(layoutParams);
        this.f14116p = null;
        this.f14111k = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void j() {
        super.j();
        this.f14116p = null;
        this.f14111k = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!u0(v7)) {
            this.f14112l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m0();
        }
        if (this.f14119s == null) {
            this.f14119s = VelocityTracker.obtain();
        }
        this.f14119s.addMovement(motionEvent);
        if (actionMasked != 0) {
            if ((actionMasked == 1 || actionMasked == 3) && this.f14112l) {
                this.f14112l = false;
                return false;
            }
        } else {
            this.f14120t = (int) motionEvent.getX();
        }
        if (!this.f14112l && (viewDragHelper = this.f14111k) != null && viewDragHelper.N(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8) {
        if (ViewCompat.B(coordinatorLayout) && !ViewCompat.B(v7)) {
            v7.setFitsSystemWindows(true);
        }
        if (this.f14116p == null) {
            this.f14116p = new WeakReference<>(v7);
            MaterialShapeDrawable materialShapeDrawable = this.f14103c;
            if (materialShapeDrawable != null) {
                ViewCompat.w0(v7, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.f14103c;
                float f8 = this.f14107g;
                if (f8 == -1.0f) {
                    f8 = ViewCompat.y(v7);
                }
                materialShapeDrawable2.b0(f8);
            } else {
                ColorStateList colorStateList = this.f14104d;
                if (colorStateList != null) {
                    ViewCompat.x0(v7, colorStateList);
                }
            }
            y0(v7);
            x0();
            if (ViewCompat.C(v7) == 0) {
                ViewCompat.D0(v7, 1);
            }
            U(v7);
        }
        if (this.f14111k == null) {
            this.f14111k = ViewDragHelper.o(coordinatorLayout, this.f14122v);
        }
        int e8 = this.f14101a.e(v7);
        coordinatorLayout.J(v7, i8);
        this.f14115o = coordinatorLayout.getWidth();
        this.f14114n = v7.getWidth();
        ViewCompat.c0(v7, O(e8, v7));
        k0(coordinatorLayout);
        for (SideSheetCallback sideSheetCallback : this.f14121u) {
            if (sideSheetCallback instanceof SideSheetCallback) {
                sideSheetCallback.c(v7);
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v7.getLayoutParams();
        v7.measure(V(i8, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, -1, marginLayoutParams.width), V(i10, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, -1, marginLayoutParams.height));
        return true;
    }

    public void o0(int i8) {
        this.f14118r = i8;
        Q();
        WeakReference<V> weakReference = this.f14116p;
        if (weakReference != null) {
            V v7 = weakReference.get();
            if (i8 != -1 && ViewCompat.W(v7)) {
                v7.requestLayout();
            }
        }
    }

    public void p0(boolean z7) {
        this.f14108h = z7;
    }

    public void r0(final int i8) {
        String str;
        if (i8 != 1 && i8 != 2) {
            WeakReference<V> weakReference = this.f14116p;
            if (weakReference != null && weakReference.get() != null) {
                n0(this.f14116p.get(), new Runnable() { // from class: com.google.android.material.sidesheet.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        SideSheetBehavior.this.j0(i8);
                    }
                });
                return;
            } else {
                s0(i8);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("STATE_");
        if (i8 == 1) {
            str = "DRAGGING";
        } else {
            str = "SETTLING";
        }
        sb.append(str);
        sb.append(" should not be set externally.");
        throw new IllegalArgumentException(sb.toString());
    }

    void s0(int i8) {
        V v7;
        if (this.f14109i == i8) {
            return;
        }
        this.f14109i = i8;
        if (i8 == 3 || i8 == 5) {
            this.f14110j = i8;
        }
        WeakReference<V> weakReference = this.f14116p;
        if (weakReference == null || (v7 = weakReference.get()) == null) {
            return;
        }
        y0(v7);
        for (SideSheetCallback sideSheetCallback : this.f14121u) {
            sideSheetCallback.a(v7, i8);
        }
        x0();
    }

    public boolean v0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.a() != null) {
            super.x(coordinatorLayout, v7, savedState.a());
        }
        int i8 = savedState.f14124h;
        i8 = (i8 == 1 || i8 == 2) ? 5 : 5;
        this.f14109i = i8;
        this.f14110j = i8;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7) {
        return new SavedState(super.y(coordinatorLayout, v7), (SideSheetBehavior<?>) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        final int f14124h;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f14124h = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f14124h);
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.f14124h = ((SideSheetBehavior) sideSheetBehavior).f14109i;
        }
    }

    public SideSheetBehavior(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14106f = new StateSettlingTracker();
        this.f14108h = true;
        this.f14109i = 5;
        this.f14110j = 5;
        this.f14113m = 0.1f;
        this.f14118r = -1;
        this.f14121u = new LinkedHashSet();
        this.f14122v = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(@NonNull View view, int i8, int i9) {
                return MathUtils.b(i8, SideSheetBehavior.this.Z(), SideSheetBehavior.this.f14115o);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(@NonNull View view, int i8, int i9) {
                return view.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int d(@NonNull View view) {
                return SideSheetBehavior.this.f14115o;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i8) {
                if (i8 == 1 && SideSheetBehavior.this.f14108h) {
                    SideSheetBehavior.this.s0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(@NonNull View view, int i8, int i9, int i10, int i11) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                View X = SideSheetBehavior.this.X();
                if (X != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) X.getLayoutParams()) != null) {
                    SideSheetBehavior.this.f14101a.h(marginLayoutParams, view.getLeft(), view.getRight());
                    X.setLayoutParams(marginLayoutParams);
                }
                SideSheetBehavior.this.T(view, i8);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void l(@NonNull View view, float f8, float f9) {
                int b8 = SideSheetBehavior.this.f14101a.b(view, f8, f9);
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                sideSheetBehavior.w0(view, b8, sideSheetBehavior.v0());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(@NonNull View view, int i8) {
                if (SideSheetBehavior.this.f14109i == 1 || SideSheetBehavior.this.f14116p == null || SideSheetBehavior.this.f14116p.get() != view) {
                    return false;
                }
                return true;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f12592k6);
        int i8 = R$styleable.f12610m6;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.f14104d = MaterialResources.a(context, obtainStyledAttributes, i8);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.f12637p6)) {
            this.f14105e = ShapeAppearanceModel.e(context, attributeSet, 0, f14100x).m();
        }
        int i9 = R$styleable.f12628o6;
        if (obtainStyledAttributes.hasValue(i9)) {
            o0(obtainStyledAttributes.getResourceId(i9, -1));
        }
        S(context);
        this.f14107g = obtainStyledAttributes.getDimension(R$styleable.f12601l6, -1.0f);
        p0(obtainStyledAttributes.getBoolean(R$styleable.f12619n6, true));
        obtainStyledAttributes.recycle();
        q0(Y());
        this.f14102b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
