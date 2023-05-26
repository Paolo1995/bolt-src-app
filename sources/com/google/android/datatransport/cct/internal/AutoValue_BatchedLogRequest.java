package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_BatchedLogRequest extends BatchedLogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List<LogRequest> f11943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_BatchedLogRequest(List<LogRequest> list) {
        if (list != null) {
            this.f11943a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    @Override // com.google.android.datatransport.cct.internal.BatchedLogRequest
    @NonNull
    public List<LogRequest> c() {
        return this.f11943a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.f11943a.equals(((BatchedLogRequest) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f11943a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f11943a + "}";
    }
}
