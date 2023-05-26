package com.google.android.datatransport.cct.internal;

/* loaded from: classes.dex */
final class AutoValue_LogResponse extends LogResponse {

    /* renamed from: a  reason: collision with root package name */
    private final long f11976a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LogResponse(long j8) {
        this.f11976a = j8;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long c() {
        return this.f11976a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof LogResponse) && this.f11976a == ((LogResponse) obj).c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f11976a;
        return 1000003 ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f11976a + "}";
    }
}
