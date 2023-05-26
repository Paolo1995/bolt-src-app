package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: q  reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.Flow f4769q;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f4769q = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f5303n1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.f5312o1) {
                    this.f4769q.D2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.f5321p1) {
                    this.f4769q.I1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.f5403z1) {
                    this.f4769q.N1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.A1) {
                    this.f4769q.K1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.f5330q1) {
                    this.f4769q.L1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.f5339r1) {
                    this.f4769q.O1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.f5347s1) {
                    this.f4769q.M1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.f5355t1) {
                    this.f4769q.J1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.Z1) {
                    this.f4769q.I2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.P1) {
                    this.f4769q.x2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.Y1) {
                    this.f4769q.H2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.J1) {
                    this.f4769q.r2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.R1) {
                    this.f4769q.z2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.L1) {
                    this.f4769q.t2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.T1) {
                    this.f4769q.B2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.N1) {
                    this.f4769q.v2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.I1) {
                    this.f4769q.q2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.Q1) {
                    this.f4769q.y2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.K1) {
                    this.f4769q.s2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.S1) {
                    this.f4769q.A2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.W1) {
                    this.f4769q.F2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.M1) {
                    this.f4769q.u2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.V1) {
                    this.f4769q.E2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.O1) {
                    this.f4769q.w2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.X1) {
                    this.f4769q.G2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.U1) {
                    this.f4769q.C2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f4966i = this.f4769q;
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void o(ConstraintWidget constraintWidget, boolean z7) {
        this.f4769q.t1(z7);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onMeasure(int i8, int i9) {
        u(this.f4769q, i8, i9);
    }

    public void setFirstHorizontalBias(float f8) {
        this.f4769q.q2(f8);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i8) {
        this.f4769q.r2(i8);
        requestLayout();
    }

    public void setFirstVerticalBias(float f8) {
        this.f4769q.s2(f8);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i8) {
        this.f4769q.t2(i8);
        requestLayout();
    }

    public void setHorizontalAlign(int i8) {
        this.f4769q.u2(i8);
        requestLayout();
    }

    public void setHorizontalBias(float f8) {
        this.f4769q.v2(f8);
        requestLayout();
    }

    public void setHorizontalGap(int i8) {
        this.f4769q.w2(i8);
        requestLayout();
    }

    public void setHorizontalStyle(int i8) {
        this.f4769q.x2(i8);
        requestLayout();
    }

    public void setLastHorizontalBias(float f8) {
        this.f4769q.y2(f8);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i8) {
        this.f4769q.z2(i8);
        requestLayout();
    }

    public void setLastVerticalBias(float f8) {
        this.f4769q.A2(f8);
        requestLayout();
    }

    public void setLastVerticalStyle(int i8) {
        this.f4769q.B2(i8);
        requestLayout();
    }

    public void setMaxElementsWrap(int i8) {
        this.f4769q.C2(i8);
        requestLayout();
    }

    public void setOrientation(int i8) {
        this.f4769q.D2(i8);
        requestLayout();
    }

    public void setPadding(int i8) {
        this.f4769q.I1(i8);
        requestLayout();
    }

    public void setPaddingBottom(int i8) {
        this.f4769q.J1(i8);
        requestLayout();
    }

    public void setPaddingLeft(int i8) {
        this.f4769q.L1(i8);
        requestLayout();
    }

    public void setPaddingRight(int i8) {
        this.f4769q.M1(i8);
        requestLayout();
    }

    public void setPaddingTop(int i8) {
        this.f4769q.O1(i8);
        requestLayout();
    }

    public void setVerticalAlign(int i8) {
        this.f4769q.E2(i8);
        requestLayout();
    }

    public void setVerticalBias(float f8) {
        this.f4769q.F2(f8);
        requestLayout();
    }

    public void setVerticalGap(int i8) {
        this.f4769q.G2(i8);
        requestLayout();
    }

    public void setVerticalStyle(int i8) {
        this.f4769q.H2(i8);
        requestLayout();
    }

    public void setWrapMode(int i8) {
        this.f4769q.I2(i8);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void u(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i8, int i9) {
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i9);
        if (virtualLayout != null) {
            virtualLayout.C1(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.x1(), virtualLayout.w1());
            return;
        }
        setMeasuredDimension(0, 0);
    }
}
