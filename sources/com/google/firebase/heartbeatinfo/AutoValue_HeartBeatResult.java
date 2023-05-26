package com.google.firebase.heartbeatinfo;

import java.util.List;

/* loaded from: classes3.dex */
final class AutoValue_HeartBeatResult extends HeartBeatResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f16256a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f16257b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_HeartBeatResult(String str, List<String> list) {
        if (str != null) {
            this.f16256a = str;
            if (list != null) {
                this.f16257b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public List<String> b() {
        return this.f16257b;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public String c() {
        return this.f16256a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        if (this.f16256a.equals(heartBeatResult.c()) && this.f16257b.equals(heartBeatResult.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f16256a.hashCode() ^ 1000003) * 1000003) ^ this.f16257b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f16256a + ", usedDates=" + this.f16257b + "}";
    }
}
