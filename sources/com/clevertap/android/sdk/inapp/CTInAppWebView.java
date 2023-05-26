package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class CTInAppWebView extends WebView {

    /* renamed from: f  reason: collision with root package name */
    final Point f11417f;

    /* renamed from: g  reason: collision with root package name */
    private int f11418g;

    /* renamed from: h  reason: collision with root package name */
    private int f11419h;

    /* renamed from: i  reason: collision with root package name */
    private int f11420i;

    /* renamed from: j  reason: collision with root package name */
    private int f11421j;

    @SuppressLint({"ResourceType"})
    public CTInAppWebView(Context context, int i8, int i9, int i10, int i11) {
        super(context);
        this.f11417f = new Point();
        this.f11420i = i8;
        this.f11418g = i9;
        this.f11421j = i10;
        this.f11419h = i11;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setOverScrollMode(2);
        setBackgroundColor(0);
        setId(188293);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int i8 = this.f11420i;
        if (i8 != 0) {
            this.f11417f.x = (int) TypedValue.applyDimension(1, i8, getResources().getDisplayMetrics());
        } else {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.f11417f.x = (int) ((displayMetrics.widthPixels * this.f11421j) / 100.0f);
        }
        int i9 = this.f11418g;
        if (i9 != 0) {
            this.f11417f.y = (int) TypedValue.applyDimension(1, i9, getResources().getDisplayMetrics());
            return;
        }
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        this.f11417f.y = (int) ((displayMetrics2.heightPixels * this.f11419h) / 100.0f);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        a();
        Point point = this.f11417f;
        setMeasuredDimension(point.x, point.y);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }
}
