package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public final class r extends com.google.android.play.integrity.internal.l {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ byte[] f14597g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Long f14598h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f14599i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f14600j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ t f14601k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(t tVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l8, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f14601k = tVar;
        this.f14597g = bArr;
        this.f14598h = l8;
        this.f14599i = taskCompletionSource2;
        this.f14600j = integrityTokenRequest;
    }

    @Override // com.google.android.play.integrity.internal.l
    public final void a(Exception exc) {
        if (exc instanceof com.google.android.play.integrity.internal.w) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.integrity.internal.h] */
    @Override // com.google.android.play.integrity.internal.l
    protected final void b() {
        com.google.android.play.integrity.internal.k kVar;
        try {
            this.f14601k.f14607c.e().v(t.a(this.f14601k, this.f14597g, this.f14598h), new s(this.f14601k, this.f14599i));
        } catch (RemoteException e8) {
            kVar = this.f14601k.f14605a;
            kVar.c(e8, "requestIntegrityToken(%s)", this.f14600j);
            this.f14599i.trySetException(new IntegrityServiceException(-100, e8));
        }
    }
}
