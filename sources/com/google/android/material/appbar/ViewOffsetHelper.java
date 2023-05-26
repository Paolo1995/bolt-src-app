package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class ViewOffsetHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f12844a;

    /* renamed from: b  reason: collision with root package name */
    private int f12845b;

    /* renamed from: c  reason: collision with root package name */
    private int f12846c;

    /* renamed from: d  reason: collision with root package name */
    private int f12847d;

    /* renamed from: e  reason: collision with root package name */
    private int f12848e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12849f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12850g = true;

    public ViewOffsetHelper(View view) {
        this.f12844a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f12844a;
        ViewCompat.d0(view, this.f12847d - (view.getTop() - this.f12845b));
        View view2 = this.f12844a;
        ViewCompat.c0(view2, this.f12848e - (view2.getLeft() - this.f12846c));
    }

    public int b() {
        return this.f12845b;
    }

    public int c() {
        return this.f12847d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f12845b = this.f12844a.getTop();
        this.f12846c = this.f12844a.getLeft();
    }

    public boolean e(int i8) {
        if (this.f12850g && this.f12848e != i8) {
            this.f12848e = i8;
            a();
            return true;
        }
        return false;
    }

    public boolean f(int i8) {
        if (this.f12849f && this.f12847d != i8) {
            this.f12847d = i8;
            a();
            return true;
        }
        return false;
    }
}
