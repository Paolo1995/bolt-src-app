package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.R$id;
import ee.mtakso.driver.uikit.R$layout;
import ee.mtakso.driver.uikit.R$style;
import ee.mtakso.driver.uikit.R$styleable;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SegmentControlItemView.kt */
/* loaded from: classes5.dex */
public final class SegmentControlItemView extends ConstraintLayout {
    private final TextView E;
    private final TextView F;
    private final View G;
    private float H;
    private float I;
    private CharSequence J;
    private CharSequence K;
    public Map<Integer, View> L;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SegmentControlItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentControlItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.L = new LinkedHashMap();
        this.I = 6.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f35900y2, i8, R$style.Widget_UIKit_SegmentControlItemView);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…ControlItemView\n        )");
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R$styleable.f35904z2, R$layout.content_segment_control_item), (ViewGroup) this, true);
        View findViewById = findViewById(R$id.f35759m);
        Intrinsics.e(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.E = textView;
        View findViewById2 = findViewById(R$id.f35754b);
        Intrinsics.e(findViewById2, "findViewById(R.id.badge)");
        TextView textView2 = (TextView) findViewById2;
        this.F = textView2;
        View findViewById3 = findViewById(R$id.f35753a);
        Intrinsics.e(findViewById3, "findViewById(R.id.background)");
        this.G = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setBackground(obtainStyledAttributes.getDrawable(R$styleable.D2));
            ViewCompat.x0(findViewById3, obtainStyledAttributes.getColorStateList(R$styleable.E2));
        }
        if (textView != null) {
            setTitle(obtainStyledAttributes.getString(R$styleable.N2));
            TextViewCompat.o(textView, obtainStyledAttributes.getResourceId(R$styleable.O2, R$style.f35777a));
            textView.setBackground(obtainStyledAttributes.getDrawable(R$styleable.L2));
            ViewCompat.x0(textView, obtainStyledAttributes.getColorStateList(R$styleable.M2));
            textView.setTextColor(obtainStyledAttributes.getColorStateList(R$styleable.P2));
        }
        if (textView2 != null) {
            setBadge(obtainStyledAttributes.getString(R$styleable.H2));
            TextViewCompat.o(textView2, obtainStyledAttributes.getResourceId(R$styleable.I2, R$style.TextAppearance_UIKit_BodyXS_Semibold));
            textView2.setBackground(obtainStyledAttributes.getDrawable(R$styleable.F2));
            ViewCompat.x0(textView2, obtainStyledAttributes.getColorStateList(R$styleable.G2));
            textView2.setTextColor(obtainStyledAttributes.getColorStateList(R$styleable.J2));
        }
        setMinimumHeight(obtainStyledAttributes.getDimensionPixelSize(R$styleable.A2, Dimens.c(36)));
        this.H = obtainStyledAttributes.getDimension(R$styleable.K2, this.H);
        this.I = obtainStyledAttributes.getDimension(R$styleable.C2, this.I);
        setActivated(obtainStyledAttributes.getBoolean(R$styleable.B2, false));
        obtainStyledAttributes.recycle();
    }

    public final CharSequence getBadge() {
        return this.K;
    }

    public final float getElevationActivated() {
        return this.I;
    }

    public final float getElevationNormal() {
        return this.H;
    }

    public final CharSequence getTitle() {
        return this.J;
    }

    @Override // android.view.View
    public void setActivated(boolean z7) {
        super.setActivated(z7);
        int i8 = 0;
        if (z7) {
            int childCount = getChildCount();
            while (i8 < childCount) {
                View childAt = getChildAt(i8);
                Intrinsics.e(childAt, "getChildAt(index)");
                ViewCompat.A0(childAt, this.I);
                i8++;
            }
            return;
        }
        int childCount2 = getChildCount();
        while (i8 < childCount2) {
            View childAt2 = getChildAt(i8);
            Intrinsics.e(childAt2, "getChildAt(index)");
            ViewCompat.A0(childAt2, this.H);
            i8++;
        }
    }

    public final void setBadge(CharSequence charSequence) {
        boolean z7;
        this.K = charSequence;
        TextView textView = this.F;
        if (charSequence != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(textView, z7, 0, 2, null);
        this.F.setText(charSequence);
    }

    public final void setElevationActivated(float f8) {
        this.I = f8;
    }

    public final void setElevationNormal(float f8) {
        this.H = f8;
    }

    public final void setTitle(CharSequence charSequence) {
        this.J = charSequence;
        this.E.setText(charSequence);
    }

    public final void setTitleTextColor(int i8) {
        this.E.setTextColor(i8);
    }

    public /* synthetic */ SegmentControlItemView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.segmentControlItemViewStyle : i8);
    }
}
