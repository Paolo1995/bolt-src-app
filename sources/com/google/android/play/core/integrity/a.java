package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.IntegrityTokenRequest;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class a extends IntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f14578a;

    /* renamed from: b  reason: collision with root package name */
    private Long f14579b;

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest.Builder
    public final IntegrityTokenRequest a() {
        String str = this.f14578a;
        if (str != null) {
            return new c(str, this.f14579b, null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest.Builder
    public final IntegrityTokenRequest.Builder b(String str) {
        if (str != null) {
            this.f14578a = str;
            return this;
        }
        throw new NullPointerException("Null nonce");
    }
}
