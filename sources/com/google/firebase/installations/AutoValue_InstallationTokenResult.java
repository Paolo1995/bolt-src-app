package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.installations.InstallationTokenResult;

/* loaded from: classes3.dex */
final class AutoValue_InstallationTokenResult extends InstallationTokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f16344a;

    /* renamed from: b  reason: collision with root package name */
    private final long f16345b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16346c;

    /* loaded from: classes3.dex */
    static final class Builder extends InstallationTokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16347a;

        /* renamed from: b  reason: collision with root package name */
        private Long f16348b;

        /* renamed from: c  reason: collision with root package name */
        private Long f16349c;

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult a() {
            String str = "";
            if (this.f16347a == null) {
                str = " token";
            }
            if (this.f16348b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f16349c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_InstallationTokenResult(this.f16347a, this.f16348b.longValue(), this.f16349c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder b(String str) {
            if (str != null) {
                this.f16347a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder c(long j8) {
            this.f16349c = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder d(long j8) {
            this.f16348b = Long.valueOf(j8);
            return this;
        }
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public String b() {
        return this.f16344a;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public long c() {
        return this.f16346c;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    @NonNull
    public long d() {
        return this.f16345b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        if (this.f16344a.equals(installationTokenResult.b()) && this.f16345b == installationTokenResult.d() && this.f16346c == installationTokenResult.c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f16345b;
        long j9 = this.f16346c;
        return ((((this.f16344a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f16344a + ", tokenExpirationTimestamp=" + this.f16345b + ", tokenCreationTimestamp=" + this.f16346c + "}";
    }

    private AutoValue_InstallationTokenResult(String str, long j8, long j9) {
        this.f16344a = str;
        this.f16345b = j8;
        this.f16346c = j9;
    }
}
