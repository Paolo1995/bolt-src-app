package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class c extends IntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f14580a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f14581b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(String str, Long l8, b bVar) {
        this.f14580a = str;
        this.f14581b = l8;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Long b() {
        return this.f14581b;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String c() {
        return this.f14580a;
    }

    public final boolean equals(Object obj) {
        Long l8;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (this.f14580a.equals(integrityTokenRequest.c()) && ((l8 = this.f14581b) != null ? l8.equals(integrityTokenRequest.b()) : integrityTokenRequest.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.f14580a.hashCode() ^ 1000003;
        Long l8 = this.f14581b;
        if (l8 == null) {
            hashCode = 0;
        } else {
            hashCode = l8.hashCode();
        }
        return (hashCode2 * 1000003) ^ hashCode;
    }

    public final String toString() {
        String str = this.f14580a;
        Long l8 = this.f14581b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l8 + "}";
    }
}
