package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class f extends IntegrityTokenResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f14583a;

    @Override // com.google.android.play.core.integrity.IntegrityTokenResponse
    public final String a() {
        return this.f14583a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenResponse) {
            return this.f14583a.equals(((IntegrityTokenResponse) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f14583a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String str = this.f14583a;
        return "IntegrityTokenResponse{token=" + str + "}";
    }
}
