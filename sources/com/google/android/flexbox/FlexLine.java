package com.google.android.flexbox;

import android.view.View;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlexLine {

    /* renamed from: e  reason: collision with root package name */
    int f12373e;

    /* renamed from: f  reason: collision with root package name */
    int f12374f;

    /* renamed from: g  reason: collision with root package name */
    int f12375g;

    /* renamed from: h  reason: collision with root package name */
    int f12376h;

    /* renamed from: i  reason: collision with root package name */
    int f12377i;

    /* renamed from: j  reason: collision with root package name */
    float f12378j;

    /* renamed from: k  reason: collision with root package name */
    float f12379k;

    /* renamed from: l  reason: collision with root package name */
    int f12380l;

    /* renamed from: m  reason: collision with root package name */
    int f12381m;

    /* renamed from: o  reason: collision with root package name */
    int f12383o;

    /* renamed from: p  reason: collision with root package name */
    int f12384p;

    /* renamed from: q  reason: collision with root package name */
    boolean f12385q;

    /* renamed from: r  reason: collision with root package name */
    boolean f12386r;

    /* renamed from: a  reason: collision with root package name */
    int f12369a = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: b  reason: collision with root package name */
    int f12370b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: c  reason: collision with root package name */
    int f12371c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    int f12372d = Integer.MIN_VALUE;

    /* renamed from: n  reason: collision with root package name */
    List<Integer> f12382n = new ArrayList();

    public int a() {
        return this.f12375g;
    }

    public int b() {
        return this.f12376h;
    }

    public int c() {
        return this.f12376h - this.f12377i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view, int i8, int i9, int i10, int i11) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f12369a = Math.min(this.f12369a, (view.getLeft() - flexItem.G0()) - i8);
        this.f12370b = Math.min(this.f12370b, (view.getTop() - flexItem.y()) - i9);
        this.f12371c = Math.max(this.f12371c, view.getRight() + flexItem.Z0() + i10);
        this.f12372d = Math.max(this.f12372d, view.getBottom() + flexItem.D0() + i11);
    }
}
