package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* renamed from: l  reason: collision with root package name */
    static final PorterDuff.Mode f5783l = PorterDuff.Mode.SRC_IN;

    /* renamed from: f  reason: collision with root package name */
    private int f5784f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f5785g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5786h;

    /* renamed from: i  reason: collision with root package name */
    WrappedDrawableState f5787i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5788j;

    /* renamed from: k  reason: collision with root package name */
    Drawable f5789k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableApi14(@NonNull WrappedDrawableState wrappedDrawableState, Resources resources) {
        this.f5787i = wrappedDrawableState;
        e(resources);
    }

    @NonNull
    private WrappedDrawableState d() {
        return new WrappedDrawableState(this.f5787i);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        WrappedDrawableState wrappedDrawableState = this.f5787i;
        if (wrappedDrawableState != null && (constantState = wrappedDrawableState.f5792b) != null) {
            b(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.f5787i;
        ColorStateList colorStateList = wrappedDrawableState.f5793c;
        PorterDuff.Mode mode = wrappedDrawableState.f5794d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f5786h || colorForState != this.f5784f || mode != this.f5785g) {
                setColorFilter(colorForState, mode);
                this.f5784f = colorForState;
                this.f5785g = mode;
                this.f5786h = true;
                return true;
            }
        } else {
            this.f5786h = false;
            clearColorFilter();
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final Drawable a() {
        return this.f5789k;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f5789k;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f5789k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.f5787i;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.f5792b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean c() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f5789k.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int i8;
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.f5787i;
        if (wrappedDrawableState != null) {
            i8 = wrappedDrawableState.getChangingConfigurations();
        } else {
            i8 = 0;
        }
        return changingConfigurations | i8 | this.f5789k.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.f5787i;
        if (wrappedDrawableState != null && wrappedDrawableState.a()) {
            this.f5787i.f5791a = getChangingConfigurations();
            return this.f5787i;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f5789k.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5789k.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5789k.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return DrawableCompat.f(this.f5789k);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f5789k.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f5789k.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5789k.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f5789k.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public int[] getState() {
        return this.f5789k.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f5789k.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.h(this.f5789k);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        WrappedDrawableState wrappedDrawableState;
        if (c() && (wrappedDrawableState = this.f5787i) != null) {
            colorStateList = wrappedDrawableState.f5793c;
        } else {
            colorStateList = null;
        }
        if ((colorStateList != null && colorStateList.isStateful()) || this.f5789k.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f5789k.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.f5788j && super.mutate() == this) {
            this.f5787i = d();
            Drawable drawable = this.f5789k;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.f5787i;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.f5789k;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                wrappedDrawableState.f5792b = constantState;
            }
            this.f5788j = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5789k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i8) {
        return DrawableCompat.m(this.f5789k, i8);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i8) {
        return this.f5789k.setLevel(i8);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j8) {
        scheduleSelf(runnable, j8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f5789k.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        DrawableCompat.j(this.f5789k, z7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i8) {
        this.f5789k.setChangingConfigurations(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5789k.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z7) {
        this.f5789k.setDither(z7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z7) {
        this.f5789k.setFilterBitmap(z7);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        boolean state = this.f5789k.setState(iArr);
        if (!f(iArr) && !state) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i8) {
        setTintList(ColorStateList.valueOf(i8));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f5787i.f5793c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.f5787i.f5794d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        if (!super.setVisible(z7, z8) && !this.f5789k.setVisible(z7, z8)) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableApi14(Drawable drawable) {
        this.f5787i = d();
        b(drawable);
    }
}
