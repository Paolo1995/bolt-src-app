package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.aa;
import com.google.android.play.integrity.internal.ac;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public final class v implements aa {

    /* renamed from: a  reason: collision with root package name */
    private final ac f14609a;

    /* renamed from: b  reason: collision with root package name */
    private final ac f14610b;

    public v(ac acVar, ac acVar2) {
        this.f14609a = acVar;
        this.f14610b = acVar2;
    }

    @Override // com.google.android.play.integrity.internal.ac
    public final /* bridge */ /* synthetic */ Object a() {
        return new t((Context) this.f14609a.a(), (com.google.android.play.integrity.internal.k) this.f14610b.a());
    }
}
