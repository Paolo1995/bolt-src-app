package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public final class p extends l {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ v f14624g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(v vVar) {
        this.f14624g = vVar;
    }

    @Override // com.google.android.play.integrity.internal.l
    public final void b() {
        IInterface iInterface;
        k kVar;
        Context context;
        ServiceConnection serviceConnection;
        v vVar = this.f14624g;
        iInterface = vVar.f14642m;
        if (iInterface != null) {
            kVar = vVar.f14631b;
            kVar.d("Unbind from service.", new Object[0]);
            v vVar2 = this.f14624g;
            context = vVar2.f14630a;
            serviceConnection = vVar2.f14641l;
            context.unbindService(serviceConnection);
            this.f14624g.f14636g = false;
            this.f14624g.f14642m = null;
            this.f14624g.f14641l = null;
        }
        this.f14624g.t();
    }
}
