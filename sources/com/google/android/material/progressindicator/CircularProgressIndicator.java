package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;

/* loaded from: classes.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* renamed from: u  reason: collision with root package name */
    public static final int f13806u = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    private void u() {
        setIndeterminateDrawable(IndeterminateDrawable.t(getContext(), (CircularProgressIndicatorSpec) this.f13763f));
        setProgressDrawable(DeterminateDrawable.v(getContext(), (CircularProgressIndicatorSpec) this.f13763f));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f13763f).f13809i;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f13763f).f13808h;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f13763f).f13807g;
    }

    public void setIndicatorDirection(int i8) {
        ((CircularProgressIndicatorSpec) this.f13763f).f13809i = i8;
        invalidate();
    }

    public void setIndicatorInset(int i8) {
        S s7 = this.f13763f;
        if (((CircularProgressIndicatorSpec) s7).f13808h != i8) {
            ((CircularProgressIndicatorSpec) s7).f13808h = i8;
            invalidate();
        }
    }

    public void setIndicatorSize(int i8) {
        int max = Math.max(i8, getTrackThickness() * 2);
        S s7 = this.f13763f;
        if (((CircularProgressIndicatorSpec) s7).f13807g != max) {
            ((CircularProgressIndicatorSpec) s7).f13807g = max;
            ((CircularProgressIndicatorSpec) s7).e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i8) {
        super.setTrackThickness(i8);
        ((CircularProgressIndicatorSpec) this.f13763f).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: t */
    public CircularProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public CircularProgressIndicator(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8, f13806u);
        u();
    }
}
