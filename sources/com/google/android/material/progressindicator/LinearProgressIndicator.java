package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* renamed from: u  reason: collision with root package name */
    public static final int f13864u = R$style.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    private void u() {
        setIndeterminateDrawable(IndeterminateDrawable.u(getContext(), (LinearProgressIndicatorSpec) this.f13763f));
        setProgressDrawable(DeterminateDrawable.w(getContext(), (LinearProgressIndicatorSpec) this.f13763f));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f13763f).f13865g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f13763f).f13866h;
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        S s7 = this.f13763f;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s7;
        boolean z8 = true;
        if (((LinearProgressIndicatorSpec) s7).f13866h != 1 && ((ViewCompat.E(this) != 1 || ((LinearProgressIndicatorSpec) this.f13763f).f13866h != 2) && (ViewCompat.E(this) != 0 || ((LinearProgressIndicatorSpec) this.f13763f).f13866h != 3))) {
            z8 = false;
        }
        linearProgressIndicatorSpec.f13867i = z8;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        int paddingLeft = i8 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i9 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        DeterminateDrawable<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void p(int i8, boolean z7) {
        S s7 = this.f13763f;
        if (s7 != 0 && ((LinearProgressIndicatorSpec) s7).f13865g == 0 && isIndeterminate()) {
            return;
        }
        super.p(i8, z7);
    }

    public void setIndeterminateAnimationType(int i8) {
        if (((LinearProgressIndicatorSpec) this.f13763f).f13865g == i8) {
            return;
        }
        if (s() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s7 = this.f13763f;
        ((LinearProgressIndicatorSpec) s7).f13865g = i8;
        ((LinearProgressIndicatorSpec) s7).e();
        if (i8 == 0) {
            getIndeterminateDrawable().x(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.f13763f));
        } else {
            getIndeterminateDrawable().x(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.f13763f));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f13763f).e();
    }

    public void setIndicatorDirection(int i8) {
        S s7 = this.f13763f;
        ((LinearProgressIndicatorSpec) s7).f13866h = i8;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s7;
        boolean z7 = true;
        if (i8 != 1 && ((ViewCompat.E(this) != 1 || ((LinearProgressIndicatorSpec) this.f13763f).f13866h != 2) && (ViewCompat.E(this) != 0 || i8 != 3))) {
            z7 = false;
        }
        linearProgressIndicatorSpec.f13867i = z7;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i8) {
        super.setTrackCornerRadius(i8);
        ((LinearProgressIndicatorSpec) this.f13763f).e();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: t */
    public LinearProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public LinearProgressIndicator(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8, f13864u);
        u();
    }
}
