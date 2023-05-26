package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    private final ClockHandView H;
    private final Rect I;
    private final RectF J;
    private final Rect K;
    private final SparseArray<TextView> L;
    private final AccessibilityDelegateCompat M;
    private final int[] N;
    private final float[] O;
    private final int P;
    private final int Q;
    private final int R;
    private final int S;
    private String[] T;
    private float U;
    private final ColorStateList V;

    public ClockFaceView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    private void N() {
        boolean z7;
        RectF e8 = this.H.e();
        TextView P = P(e8);
        for (int i8 = 0; i8 < this.L.size(); i8++) {
            TextView textView = this.L.get(i8);
            if (textView != null) {
                if (textView == P) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                textView.setSelected(z7);
                textView.getPaint().setShader(O(e8, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient O(RectF rectF, TextView textView) {
        textView.getHitRect(this.I);
        this.J.set(this.I);
        textView.getLineBounds(0, this.K);
        RectF rectF2 = this.J;
        Rect rect = this.K;
        rectF2.inset(rect.left, rect.top);
        if (!RectF.intersects(rectF, this.J)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.J.left, rectF.centerY() - this.J.top, rectF.width() * 0.5f, this.N, this.O, Shader.TileMode.CLAMP);
    }

    private TextView P(RectF rectF) {
        float f8 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i8 = 0; i8 < this.L.size(); i8++) {
            TextView textView2 = this.L.get(i8);
            if (textView2 != null) {
                textView2.getHitRect(this.I);
                this.J.set(this.I);
                this.J.union(rectF);
                float width = this.J.width() * this.J.height();
                if (width < f8) {
                    textView = textView2;
                    f8 = width;
                }
            }
        }
        return textView;
    }

    private static float Q(float f8, float f9, float f10) {
        return Math.max(Math.max(f8, f9), f10);
    }

    private void S(int i8) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.L.size();
        boolean z7 = false;
        for (int i9 = 0; i9 < Math.max(this.T.length, size); i9++) {
            TextView textView = this.L.get(i9);
            if (i9 >= this.T.length) {
                removeView(textView);
                this.L.remove(i9);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.L.put(i9, textView);
                    addView(textView);
                }
                textView.setText(this.T[i9]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i9));
                int i10 = (i9 / 12) + 1;
                textView.setTag(R$id.material_clock_level, Integer.valueOf(i10));
                if (i10 > 1) {
                    z7 = true;
                }
                ViewCompat.s0(textView, this.M);
                textView.setTextColor(this.V);
                if (i8 != 0) {
                    textView.setContentDescription(getResources().getString(i8, this.T[i9]));
                }
            }
        }
        this.H.q(z7);
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void F(int i8) {
        if (i8 != E()) {
            super.F(i8);
            this.H.m(E());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void H() {
        super.H();
        for (int i8 = 0; i8 < this.L.size(); i8++) {
            this.L.get(i8).setVisibility(0);
        }
    }

    public void R(String[] strArr, int i8) {
        this.T = strArr;
        S(i8);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void a(float f8, boolean z7) {
        if (Math.abs(this.U - f8) > 0.001f) {
            this.U = f8;
            N();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo).a0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(1, this.T.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int Q = (int) (this.S / Q(this.Q / displayMetrics.heightPixels, this.R / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Q, Pow2.MAX_POW2);
        setMeasuredDimension(Q, Q);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.I = new Rect();
        this.J = new RectF();
        this.K = new Rect();
        this.L = new SparseArray<>();
        this.O = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.I1, i8, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a8 = MaterialResources.a(context, obtainStyledAttributes, R$styleable.K1);
        this.V = a8;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.H = clockHandView;
        this.P = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = a8.getColorForState(new int[]{16842913}, a8.getDefaultColor());
        this.N = new int[]{colorForState, colorForState, a8.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a9 = MaterialResources.a(context, obtainStyledAttributes, R$styleable.J1);
        setBackgroundColor(a9 != null ? a9.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.timepicker.ClockFaceView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (!ClockFaceView.this.isShown()) {
                    return true;
                }
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.F(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.H.i()) - ClockFaceView.this.P);
                return true;
            }
        });
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.M = new AccessibilityDelegateCompat() { // from class: com.google.android.material.timepicker.ClockFaceView.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
                if (intValue > 0) {
                    accessibilityNodeInfoCompat.x0((View) ClockFaceView.this.L.get(intValue - 1));
                }
                accessibilityNodeInfoCompat.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, intValue, 1, false, view.isSelected()));
                accessibilityNodeInfoCompat.Z(true);
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6045i);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean j(View view, int i9, Bundle bundle) {
                if (i9 == 16) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    view.getHitRect(ClockFaceView.this.I);
                    float centerX = ClockFaceView.this.I.centerX();
                    float centerY = ClockFaceView.this.I.centerY();
                    ClockFaceView.this.H.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
                    ClockFaceView.this.H.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
                    return true;
                }
                return super.j(view, i9, bundle);
            }
        };
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        R(strArr, 0);
        this.Q = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.R = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.S = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }
}
