package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    ConstraintSet f5176f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ConstraintSet getConstraintSet() {
        if (this.f5176f == null) {
            this.f5176f = new ConstraintSet();
        }
        this.f5176f.h(this);
        return this.f5176f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float H0;
        public float I0;
        public float J0;

        /* renamed from: x0  reason: collision with root package name */
        public float f5177x0;

        /* renamed from: y0  reason: collision with root package name */
        public boolean f5178y0;

        /* renamed from: z0  reason: collision with root package name */
        public float f5179z0;

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f5177x0 = 1.0f;
            this.f5178y0 = false;
            this.f5179z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5177x0 = 1.0f;
            this.f5178y0 = false;
            this.f5179z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.K4);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.L4) {
                    this.f5177x0 = obtainStyledAttributes.getFloat(index, this.f5177x0);
                } else if (index == R$styleable.W4) {
                    this.f5179z0 = obtainStyledAttributes.getFloat(index, this.f5179z0);
                    this.f5178y0 = true;
                } else if (index == R$styleable.T4) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == R$styleable.U4) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == R$styleable.S4) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == R$styleable.Q4) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == R$styleable.R4) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == R$styleable.M4) {
                    this.F0 = obtainStyledAttributes.getFloat(index, this.F0);
                } else if (index == R$styleable.N4) {
                    this.G0 = obtainStyledAttributes.getFloat(index, this.G0);
                } else if (index == R$styleable.O4) {
                    this.H0 = obtainStyledAttributes.getFloat(index, this.H0);
                } else if (index == R$styleable.P4) {
                    this.I0 = obtainStyledAttributes.getFloat(index, this.I0);
                } else if (index == R$styleable.V4) {
                    this.J0 = obtainStyledAttributes.getFloat(index, this.J0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
