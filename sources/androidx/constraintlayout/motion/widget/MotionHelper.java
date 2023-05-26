package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.TransitionListener {

    /* renamed from: o  reason: collision with root package name */
    private boolean f4852o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4853p;

    /* renamed from: q  reason: collision with root package name */
    private float f4854q;

    /* renamed from: r  reason: collision with root package name */
    protected View[] f4855r;

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void a(MotionLayout motionLayout, int i8, int i9, float f8) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void b(MotionLayout motionLayout, int i8) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void c(MotionLayout motionLayout, int i8, int i9) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void d(MotionLayout motionLayout, int i8, boolean z7, float f8) {
    }

    public float getProgress() {
        return this.f4854q;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f5309n7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.f5327p7) {
                    this.f4852o = obtainStyledAttributes.getBoolean(index, this.f4852o);
                } else if (index == R$styleable.f5318o7) {
                    this.f4853p = obtainStyledAttributes.getBoolean(index, this.f4853p);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f8) {
        this.f4854q = f8;
        int i8 = 0;
        if (this.f4964g > 0) {
            this.f4855r = m((ConstraintLayout) getParent());
            while (i8 < this.f4964g) {
                y(this.f4855r[i8], f8);
                i8++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i8 < childCount) {
            View childAt = viewGroup.getChildAt(i8);
            if (!(childAt instanceof MotionHelper)) {
                y(childAt, f8);
            }
            i8++;
        }
    }

    public boolean u() {
        return false;
    }

    public boolean v() {
        return this.f4853p;
    }

    public boolean w() {
        return this.f4852o;
    }

    public void x(Canvas canvas) {
    }

    public void y(View view, float f8) {
    }
}
