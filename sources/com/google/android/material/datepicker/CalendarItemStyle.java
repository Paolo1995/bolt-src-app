package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes.dex */
final class CalendarItemStyle {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Rect f13259a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f13260b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f13261c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f13262d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13263e;

    /* renamed from: f  reason: collision with root package name */
    private final ShapeAppearanceModel f13264f;

    private CalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i8, ShapeAppearanceModel shapeAppearanceModel, @NonNull Rect rect) {
        Preconditions.d(rect.left);
        Preconditions.d(rect.top);
        Preconditions.d(rect.right);
        Preconditions.d(rect.bottom);
        this.f13259a = rect;
        this.f13260b = colorStateList2;
        this.f13261c = colorStateList;
        this.f13262d = colorStateList3;
        this.f13263e = i8;
        this.f13264f = shapeAppearanceModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static CalendarItemStyle a(@NonNull Context context, int i8) {
        boolean z7;
        if (i8 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i8, R$styleable.f12572i4);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f12581j4, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f12599l4, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f12590k4, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f12608m4, 0));
        ColorStateList a8 = MaterialResources.a(context, obtainStyledAttributes, R$styleable.f12617n4);
        ColorStateList a9 = MaterialResources.a(context, obtainStyledAttributes, R$styleable.f12661s4);
        ColorStateList a10 = MaterialResources.a(context, obtainStyledAttributes, R$styleable.f12644q4);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f12653r4, 0);
        ShapeAppearanceModel m8 = ShapeAppearanceModel.b(context, obtainStyledAttributes.getResourceId(R$styleable.f12626o4, 0), obtainStyledAttributes.getResourceId(R$styleable.f12635p4, 0)).m();
        obtainStyledAttributes.recycle();
        return new CalendarItemStyle(a8, a9, a10, dimensionPixelSize, m8, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f13259a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f13259a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(@NonNull TextView textView) {
        e(textView, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@NonNull TextView textView, ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f13264f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f13264f);
        if (colorStateList == null) {
            colorStateList = this.f13261c;
        }
        materialShapeDrawable.c0(colorStateList);
        materialShapeDrawable.l0(this.f13263e, this.f13262d);
        textView.setTextColor(this.f13260b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f13260b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.f13259a;
        ViewCompat.w0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
