package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* loaded from: classes3.dex */
final class AutoValue_InstallationResponse extends InstallationResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f16414a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16415b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16416c;

    /* renamed from: d  reason: collision with root package name */
    private final TokenResult f16417d;

    /* renamed from: e  reason: collision with root package name */
    private final InstallationResponse.ResponseCode f16418e;

    /* loaded from: classes3.dex */
    static final class Builder extends InstallationResponse.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16419a;

        /* renamed from: b  reason: collision with root package name */
        private String f16420b;

        /* renamed from: c  reason: collision with root package name */
        private String f16421c;

        /* renamed from: d  reason: collision with root package name */
        private TokenResult f16422d;

        /* renamed from: e  reason: collision with root package name */
        private InstallationResponse.ResponseCode f16423e;

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse a() {
            return new AutoValue_InstallationResponse(this.f16419a, this.f16420b, this.f16421c, this.f16422d, this.f16423e);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder b(TokenResult tokenResult) {
            this.f16422d = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder c(String str) {
            this.f16420b = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder d(String str) {
            this.f16421c = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder e(InstallationResponse.ResponseCode responseCode) {
            this.f16423e = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public InstallationResponse.Builder f(String str) {
            this.f16419a = str;
            return this;
        }
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public TokenResult b() {
        return this.f16417d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String c() {
        return this.f16415b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String d() {
        return this.f16416c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.ResponseCode e() {
        return this.f16418e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f16414a;
        if (str != null ? str.equals(installationResponse.f()) : installationResponse.f() == null) {
            String str2 = this.f16415b;
            if (str2 != null ? str2.equals(installationResponse.c()) : installationResponse.c() == null) {
                String str3 = this.f16416c;
                if (str3 != null ? str3.equals(installationResponse.d()) : installationResponse.d() == null) {
                    TokenResult tokenResult = this.f16417d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.b()) : installationResponse.b() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f16418e;
                        if (responseCode == null) {
                            if (installationResponse.e() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String f() {
        return this.f16414a;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.f16414a;
        int i8 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i9 = (hashCode ^ 1000003) * 1000003;
        String str2 = this.f16415b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i10 = (i9 ^ hashCode2) * 1000003;
        String str3 = this.f16416c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i11 = (i10 ^ hashCode3) * 1000003;
        TokenResult tokenResult = this.f16417d;
        if (tokenResult == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = tokenResult.hashCode();
        }
        int i12 = (i11 ^ hashCode4) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f16418e;
        if (responseCode != null) {
            i8 = responseCode.hashCode();
        }
        return i12 ^ i8;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f16414a + ", fid=" + this.f16415b + ", refreshToken=" + this.f16416c + ", authToken=" + this.f16417d + ", responseCode=" + this.f16418e + "}";
    }

    private AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.f16414a = str;
        this.f16415b = str2;
        this.f16416c = str3;
        this.f16417d = tokenResult;
        this.f16418e = responseCode;
    }
}
