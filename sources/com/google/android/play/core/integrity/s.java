package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class s extends com.google.android.play.integrity.internal.i {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.k f14602a = new com.google.android.play.integrity.internal.k("OnRequestIntegrityTokenCallback");

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f14603b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ t f14604c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(t tVar, TaskCompletionSource taskCompletionSource) {
        this.f14604c = tVar;
        this.f14603b = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.j
    public final void g(Bundle bundle) {
        this.f14604c.f14607c.r(this.f14603b);
        this.f14602a.d("onRequestIntegrityToken", new Object[0]);
        int i8 = bundle.getInt("error");
        if (i8 != 0) {
            this.f14603b.trySetException(new IntegrityServiceException(i8, null));
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f14603b.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        TaskCompletionSource taskCompletionSource = this.f14603b;
        d dVar = new d();
        dVar.a(string);
        taskCompletionSource.trySetResult(dVar.b());
    }
}
