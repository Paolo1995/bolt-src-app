package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: o  reason: collision with root package name */
    private int f4942o;

    /* renamed from: p  reason: collision with root package name */
    private int f4943p;

    /* renamed from: q  reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.Barrier f4944q;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void u(ConstraintWidget constraintWidget, int i8, boolean z7) {
        this.f4943p = i8;
        if (z7) {
            int i9 = this.f4942o;
            if (i9 == 5) {
                this.f4943p = 1;
            } else if (i9 == 6) {
                this.f4943p = 0;
            }
        } else {
            int i10 = this.f4942o;
            if (i10 == 5) {
                this.f4943p = 0;
            } else if (i10 == 6) {
                this.f4943p = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            ((androidx.constraintlayout.core.widgets.Barrier) constraintWidget).A1(this.f4943p);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f4944q.u1();
    }

    public int getMargin() {
        return this.f4944q.w1();
    }

    public int getType() {
        return this.f4942o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f4944q = new androidx.constraintlayout.core.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f5303n1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.D1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.C1) {
                    this.f4944q.z1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R$styleable.E1) {
                    this.f4944q.B1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4966i = this.f4944q;
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void o(ConstraintWidget constraintWidget, boolean z7) {
        u(constraintWidget, this.f4942o, z7);
    }

    public void setAllowsGoneWidget(boolean z7) {
        this.f4944q.z1(z7);
    }

    public void setDpMargin(int i8) {
        androidx.constraintlayout.core.widgets.Barrier barrier = this.f4944q;
        barrier.B1((int) ((i8 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i8) {
        this.f4944q.B1(i8);
    }

    public void setType(int i8) {
        this.f4942o = i8;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
