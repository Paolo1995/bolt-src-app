package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CalendarStyle {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final CalendarItemStyle f13265a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final CalendarItemStyle f13266b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final CalendarItemStyle f13267c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final CalendarItemStyle f13268d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final CalendarItemStyle f13269e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final CalendarItemStyle f13270f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    final CalendarItemStyle f13271g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    final Paint f13272h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarStyle(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.d(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R$styleable.Z3);
        this.f13265a = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R$styleable.f12518c4, 0));
        this.f13271g = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R$styleable.f12500a4, 0));
        this.f13266b = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R$styleable.f12509b4, 0));
        this.f13267c = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R$styleable.f12527d4, 0));
        ColorStateList a8 = MaterialResources.a(context, obtainStyledAttributes, R$styleable.f12536e4);
        this.f13268d = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R$styleable.f12554g4, 0));
        this.f13269e = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R$styleable.f12545f4, 0));
        this.f13270f = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R$styleable.f12563h4, 0));
        Paint paint = new Paint();
        this.f13272h = paint;
        paint.setColor(a8.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
