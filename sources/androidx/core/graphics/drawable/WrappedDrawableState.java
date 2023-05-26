package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f5791a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f5792b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f5793c;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f5794d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        this.f5793c = null;
        this.f5794d = WrappedDrawableApi14.f5783l;
        if (wrappedDrawableState != null) {
            this.f5791a = wrappedDrawableState.f5791a;
            this.f5792b = wrappedDrawableState.f5792b;
            this.f5793c = wrappedDrawableState.f5793c;
            this.f5794d = wrappedDrawableState.f5794d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.f5792b != null) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i8;
        int i9 = this.f5791a;
        Drawable.ConstantState constantState = this.f5792b;
        if (constantState != null) {
            i8 = constantState.getChangingConfigurations();
        } else {
            i8 = 0;
        }
        return i9 | i8;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
