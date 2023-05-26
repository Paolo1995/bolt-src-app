package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* loaded from: classes.dex */
final class AutoValue_BackendResponse extends BackendResponse {

    /* renamed from: a  reason: collision with root package name */
    private final BackendResponse.Status f12128a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12129b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_BackendResponse(BackendResponse.Status status, long j8) {
        if (status != null) {
            this.f12128a = status;
            this.f12129b = j8;
            return;
        }
        throw new NullPointerException("Null status");
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f12129b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f12128a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (this.f12128a.equals(backendResponse.c()) && this.f12129b == backendResponse.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f12129b;
        return ((this.f12128a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f12128a + ", nextRequestWaitMillis=" + this.f12129b + "}";
    }
}
