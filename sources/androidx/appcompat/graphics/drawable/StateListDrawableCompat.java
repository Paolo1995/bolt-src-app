package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;

/* loaded from: classes.dex */
public class StateListDrawableCompat extends DrawableContainerCompat {

    /* renamed from: r  reason: collision with root package name */
    private StateListState f1409r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1410s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] J;

        /* JADX INFO: Access modifiers changed from: package-private */
        public StateListState(StateListState stateListState, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            super(stateListState, stateListDrawableCompat, resources);
            if (stateListState != null) {
                this.J = stateListState.J;
            } else {
                this.J = new int[f()];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int A(int[] iArr, Drawable drawable) {
            int a8 = a(drawable);
            this.J[a8] = iArr;
            return a8;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int B(int[] iArr) {
            int[][] iArr2 = this.J;
            int h8 = h();
            for (int i8 = 0; i8 < h8; i8++) {
                if (StateSet.stateSetMatches(iArr2[i8], iArr)) {
                    return i8;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void o(int i8, int i9) {
            super.o(i8, i9);
            int[][] iArr = new int[i9];
            System.arraycopy(this.J, 0, iArr, 0, i8);
            this.J = iArr;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void s() {
            int[] iArr;
            int[][] iArr2 = this.J;
            int[][] iArr3 = new int[iArr2.length];
            for (int length = iArr2.length - 1; length >= 0; length--) {
                int[] iArr4 = this.J[length];
                if (iArr4 != null) {
                    iArr = (int[]) iArr4.clone();
                } else {
                    iArr = null;
                }
                iArr3[length] = iArr;
            }
            this.J = iArr3;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawableCompat(this, resources);
        }
    }

    public StateListDrawableCompat() {
        this(null, null);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void h(@NonNull DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.h(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.f1409r = (StateListState) drawableContainerState;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* renamed from: j */
    public StateListState b() {
        return new StateListState(this.f1409r, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i8 = 0;
        for (int i9 = 0; i9 < attributeCount; i9++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i9);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i10 = i8 + 1;
                if (!attributeSet.getAttributeBooleanValue(i9, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i8] = attributeNameResource;
                i8 = i10;
            }
        }
        return StateSet.trimStateSet(iArr, i8);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f1410s && super.mutate() == this) {
            this.f1409r.s();
            this.f1410s = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int B = this.f1409r.B(iArr);
        if (B < 0) {
            B = this.f1409r.B(StateSet.WILD_CARD);
        }
        if (!g(B) && !onStateChange) {
            return false;
        }
        return true;
    }

    StateListDrawableCompat(StateListState stateListState, Resources resources) {
        h(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StateListDrawableCompat(StateListState stateListState) {
        if (stateListState != null) {
            h(stateListState);
        }
    }
}
