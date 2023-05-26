package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RadialViewGroup extends ConstraintLayout {
    private final Runnable E;
    private int F;
    private MaterialShapeDrawable G;

    public RadialViewGroup(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B(List<View> list, ConstraintSet constraintSet, int i8) {
        float f8 = 0.0f;
        for (View view : list) {
            constraintSet.k(view.getId(), R$id.circle_center, i8, f8);
            f8 += 360.0f / list.size();
        }
    }

    private Drawable C() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.G = materialShapeDrawable;
        materialShapeDrawable.a0(new RelativeCornerSize(0.5f));
        this.G.c0(ColorStateList.valueOf(-1));
        return this.G;
    }

    private static boolean G(View view) {
        return "skip".equals(view.getTag());
    }

    private void I() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.E);
            handler.post(this.E);
        }
    }

    int D(int i8) {
        if (i8 == 2) {
            return Math.round(this.F * 0.66f);
        }
        return this.F;
    }

    public int E() {
        return this.F;
    }

    public void F(int i8) {
        this.F = i8;
        H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.g(this);
        HashMap hashMap = new HashMap();
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getId() != R$id.circle_center && !G(childAt)) {
                int i9 = (Integer) childAt.getTag(R$id.material_clock_level);
                if (i9 == null) {
                    i9 = 1;
                }
                if (!hashMap.containsKey(i9)) {
                    hashMap.put(i9, new ArrayList());
                }
                ((List) hashMap.get(i9)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            B((List) entry.getValue(), constraintSet, D(((Integer) entry.getKey()).intValue()));
        }
        constraintSet.c(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i8, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.m());
        }
        I();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        H();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        I();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        this.G.c0(ColorStateList.valueOf(i8));
    }

    public RadialViewGroup(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        ViewCompat.w0(this, C());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.F5, i8, 0);
        this.F = obtainStyledAttributes.getDimensionPixelSize(R$styleable.G5, 0);
        this.E = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                RadialViewGroup.this.H();
            }
        };
        obtainStyledAttributes.recycle();
    }
}
