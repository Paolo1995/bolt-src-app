package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class m implements IntegrityManager {

    /* renamed from: a  reason: collision with root package name */
    private final t f14591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(t tVar) {
        this.f14591a = tVar;
    }

    @Override // com.google.android.play.core.integrity.IntegrityManager
    public final Task<IntegrityTokenResponse> a(IntegrityTokenRequest integrityTokenRequest) {
        return this.f14591a.b(integrityTokenRequest);
    }
}
