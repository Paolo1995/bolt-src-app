package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private boolean f1957f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1958g;

    /* renamed from: h  reason: collision with root package name */
    private int f1959h;

    public ButtonBarLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1959h = -1;
        int[] iArr = R$styleable.N0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.q0(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f1957f = obtainStyledAttributes.getBoolean(R$styleable.O0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1957f);
        }
    }

    private int a(int i8) {
        int childCount = getChildCount();
        while (i8 < childCount) {
            if (getChildAt(i8).getVisibility() == 0) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    private boolean b() {
        return this.f1958g;
    }

    private void setStacked(boolean z7) {
        int i8;
        int i9;
        if (this.f1958g != z7) {
            if (!z7 || this.f1957f) {
                this.f1958g = z7;
                setOrientation(z7 ? 1 : 0);
                if (z7) {
                    i8 = 8388613;
                } else {
                    i8 = 80;
                }
                setGravity(i8);
                View findViewById = findViewById(R$id.G);
                if (findViewById != null) {
                    if (z7) {
                        i9 = 8;
                    } else {
                        i9 = 4;
                    }
                    findViewById.setVisibility(i9);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        int i10;
        boolean z7;
        boolean z8;
        int size = View.MeasureSpec.getSize(i8);
        int i11 = 0;
        if (this.f1957f) {
            if (size > this.f1959h && b()) {
                setStacked(false);
            }
            this.f1959h = size;
        }
        if (!b() && View.MeasureSpec.getMode(i8) == 1073741824) {
            i10 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z7 = true;
        } else {
            i10 = i8;
            z7 = false;
        }
        super.onMeasure(i10, i9);
        if (this.f1957f && !b()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                setStacked(true);
                z7 = true;
            }
        }
        if (z7) {
            super.onMeasure(i8, i9);
        }
        int a8 = a(0);
        if (a8 >= 0) {
            View childAt = getChildAt(a8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int a9 = a(a8 + 1);
                if (a9 >= 0) {
                    paddingTop += getChildAt(a9).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i11 = paddingTop;
            } else {
                i11 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.F(this) != i11) {
            setMinimumHeight(i11);
            if (i9 == 0) {
                super.onMeasure(i8, i9);
            }
        }
    }

    public void setAllowStacking(boolean z7) {
        if (this.f1957f != z7) {
            this.f1957f = z7;
            if (!z7 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
