package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {

    /* renamed from: s  reason: collision with root package name */
    private static final int f12862s = R$style.Widget_MaterialComponents_Badge;

    /* renamed from: t  reason: collision with root package name */
    private static final int f12863t = R$attr.badgeStyle;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final WeakReference<Context> f12864f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final MaterialShapeDrawable f12865g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextDrawableHelper f12866h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final Rect f12867i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final BadgeState f12868j;

    /* renamed from: k  reason: collision with root package name */
    private float f12869k;

    /* renamed from: l  reason: collision with root package name */
    private float f12870l;

    /* renamed from: m  reason: collision with root package name */
    private int f12871m;

    /* renamed from: n  reason: collision with root package name */
    private float f12872n;

    /* renamed from: o  reason: collision with root package name */
    private float f12873o;

    /* renamed from: p  reason: collision with root package name */
    private float f12874p;

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<View> f12875q;

    /* renamed from: r  reason: collision with root package name */
    private WeakReference<FrameLayout> f12876r;

    private BadgeDrawable(@NonNull Context context, int i8, int i9, int i10, BadgeState.State state) {
        this.f12864f = new WeakReference<>(context);
        ThemeEnforcement.c(context);
        this.f12867i = new Rect();
        this.f12865g = new MaterialShapeDrawable();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f12866h = textDrawableHelper;
        textDrawableHelper.e().setTextAlign(Paint.Align.CENTER);
        w(R$style.TextAppearance_MaterialComponents_Badge);
        this.f12868j = new BadgeState(context, i8, i9, i10, state);
        u();
    }

    private void A() {
        View view;
        Context context = this.f12864f.get();
        WeakReference<View> weakReference = this.f12875q;
        FrameLayout frameLayout = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f12867i);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f12876r;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null || BadgeUtils.f12903a) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            b(context, rect2, view);
            BadgeUtils.d(this.f12867i, this.f12869k, this.f12870l, this.f12873o, this.f12874p);
            this.f12865g.Z(this.f12872n);
            if (!rect.equals(this.f12867i)) {
                this.f12865g.setBounds(this.f12867i);
            }
        }
    }

    private void B() {
        this.f12871m = ((int) Math.pow(10.0d, i() - 1.0d)) - 1;
    }

    private void b(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i8;
        float f8;
        float f9;
        float f10;
        int l8 = l();
        int f11 = this.f12868j.f();
        if (f11 != 8388691 && f11 != 8388693) {
            this.f12870l = rect.top + l8;
        } else {
            this.f12870l = rect.bottom - l8;
        }
        if (j() <= 9) {
            if (!m()) {
                f10 = this.f12868j.f12882c;
            } else {
                f10 = this.f12868j.f12883d;
            }
            this.f12872n = f10;
            this.f12874p = f10;
            this.f12873o = f10;
        } else {
            float f12 = this.f12868j.f12883d;
            this.f12872n = f12;
            this.f12874p = f12;
            this.f12873o = (this.f12866h.f(e()) / 2.0f) + this.f12868j.f12884e;
        }
        Resources resources = context.getResources();
        if (m()) {
            i8 = R$dimen.mtrl_badge_text_horizontal_edge_offset;
        } else {
            i8 = R$dimen.mtrl_badge_horizontal_edge_offset;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i8);
        int k8 = k();
        int f13 = this.f12868j.f();
        if (f13 != 8388659 && f13 != 8388691) {
            if (ViewCompat.E(view) == 0) {
                f9 = ((rect.right + this.f12873o) - dimensionPixelSize) - k8;
            } else {
                f9 = (rect.left - this.f12873o) + dimensionPixelSize + k8;
            }
            this.f12869k = f9;
            return;
        }
        if (ViewCompat.E(view) == 0) {
            f8 = (rect.left - this.f12873o) + dimensionPixelSize + k8;
        } else {
            f8 = ((rect.right + this.f12873o) - dimensionPixelSize) - k8;
        }
        this.f12869k = f8;
    }

    @NonNull
    public static BadgeDrawable c(@NonNull Context context) {
        return new BadgeDrawable(context, 0, f12863t, f12862s, null);
    }

    private void d(Canvas canvas) {
        Rect rect = new Rect();
        String e8 = e();
        this.f12866h.e().getTextBounds(e8, 0, e8.length(), rect);
        canvas.drawText(e8, this.f12869k, this.f12870l + (rect.height() / 2), this.f12866h.e());
    }

    @NonNull
    private String e() {
        if (j() <= this.f12871m) {
            return NumberFormat.getInstance(this.f12868j.o()).format(j());
        }
        Context context = this.f12864f.get();
        if (context == null) {
            return "";
        }
        return String.format(this.f12868j.o(), context.getString(R$string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f12871m), "+");
    }

    private int k() {
        int l8;
        if (m()) {
            l8 = this.f12868j.k();
        } else {
            l8 = this.f12868j.l();
        }
        return l8 + this.f12868j.b();
    }

    private int l() {
        int q8;
        if (m()) {
            q8 = this.f12868j.p();
        } else {
            q8 = this.f12868j.q();
        }
        return q8 + this.f12868j.c();
    }

    private void n() {
        this.f12866h.e().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void o() {
        ColorStateList valueOf = ColorStateList.valueOf(this.f12868j.e());
        if (this.f12865g.x() != valueOf) {
            this.f12865g.c0(valueOf);
            invalidateSelf();
        }
    }

    private void p() {
        FrameLayout frameLayout;
        WeakReference<View> weakReference = this.f12875q;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.f12875q.get();
            WeakReference<FrameLayout> weakReference2 = this.f12876r;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            } else {
                frameLayout = null;
            }
            z(view, frameLayout);
        }
    }

    private void q() {
        this.f12866h.e().setColor(this.f12868j.g());
        invalidateSelf();
    }

    private void r() {
        B();
        this.f12866h.i(true);
        A();
        invalidateSelf();
    }

    private void s() {
        this.f12866h.i(true);
        A();
        invalidateSelf();
    }

    private void t() {
        boolean s7 = this.f12868j.s();
        setVisible(s7, false);
        if (BadgeUtils.f12903a && g() != null && !s7) {
            ((ViewGroup) g().getParent()).invalidate();
        }
    }

    private void u() {
        r();
        s();
        n();
        o();
        q();
        p();
        A();
        t();
    }

    private void v(TextAppearance textAppearance) {
        Context context;
        if (this.f12866h.d() == textAppearance || (context = this.f12864f.get()) == null) {
            return;
        }
        this.f12866h.h(textAppearance, context);
        A();
    }

    private void w(int i8) {
        Context context = this.f12864f.get();
        if (context == null) {
            return;
        }
        v(new TextAppearance(context, i8));
    }

    private void x(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f12876r;
            if (weakReference != null && weakReference.get() == viewGroup) {
                return;
            }
            y(view);
            final FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(R$id.mtrl_anchor_parent);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(view.getLayoutParams());
            frameLayout.setMinimumWidth(view.getWidth());
            frameLayout.setMinimumHeight(view.getHeight());
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewAt(indexOfChild);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(view);
            viewGroup.addView(frameLayout, indexOfChild);
            this.f12876r = new WeakReference<>(frameLayout);
            frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    BadgeDrawable.this.z(view, frameLayout);
                }
            });
        }
    }

    private static void y(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f12865g.draw(canvas);
            if (m()) {
                d(canvas);
            }
        }
    }

    public CharSequence f() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (m()) {
            if (this.f12868j.j() == 0 || (context = this.f12864f.get()) == null) {
                return null;
            }
            if (j() <= this.f12871m) {
                return context.getResources().getQuantityString(this.f12868j.j(), j(), Integer.valueOf(j()));
            }
            return context.getString(this.f12868j.h(), Integer.valueOf(this.f12871m));
        }
        return this.f12868j.i();
    }

    public FrameLayout g() {
        WeakReference<FrameLayout> weakReference = this.f12876r;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f12868j.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f12867i.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f12867i.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f12868j.l();
    }

    public int i() {
        return this.f12868j.m();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        if (m()) {
            return this.f12868j.n();
        }
        return 0;
    }

    public boolean m() {
        return this.f12868j.r();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f12868j.u(i8);
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void z(@NonNull View view, FrameLayout frameLayout) {
        this.f12875q = new WeakReference<>(view);
        boolean z7 = BadgeUtils.f12903a;
        if (z7 && frameLayout == null) {
            x(view);
        } else {
            this.f12876r = new WeakReference<>(frameLayout);
        }
        if (!z7) {
            y(view);
        }
        A();
        invalidateSelf();
    }
}
