package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private final long f14616a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i8, long j8) {
        this.f14616a = j8;
    }

    @Override // com.google.android.play.integrity.internal.e
    public final int a() {
        return 3;
    }

    @Override // com.google.android.play.integrity.internal.e
    public final long b() {
        return this.f14616a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            eVar.a();
            if (this.f14616a == eVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j8 = this.f14616a;
        return (-724379968) ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public final String toString() {
        long j8 = this.f14616a;
        return "EventRecord{eventType=3, eventTimestamp=" + j8 + "}";
    }
}
