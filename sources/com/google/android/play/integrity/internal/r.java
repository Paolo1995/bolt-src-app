package com.google.android.play.integrity.internal;

import android.os.IBinder;
import java.util.List;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class r extends l {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ IBinder f14625g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ u f14626h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(u uVar, IBinder iBinder) {
        this.f14626h = uVar;
        this.f14625g = iBinder;
    }

    @Override // com.google.android.play.integrity.internal.l
    public final void b() {
        List<Runnable> list;
        List list2;
        this.f14626h.f14628a.f14642m = g.z(this.f14625g);
        v.n(this.f14626h.f14628a);
        this.f14626h.f14628a.f14636g = false;
        list = this.f14626h.f14628a.f14633d;
        for (Runnable runnable : list) {
            runnable.run();
        }
        list2 = this.f14626h.f14628a.f14633d;
        list2.clear();
    }
}
