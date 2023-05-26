package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class d extends w {

    /* renamed from: a  reason: collision with root package name */
    private String f14582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.w
    public final w a(String str) {
        this.f14582a = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.w
    public final IntegrityTokenResponse b() {
        String str = this.f14582a;
        if (str != null) {
            return new f(str, null);
        }
        throw new IllegalStateException("Missing required properties: token");
    }
}
