package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import com.google.firebase.installations.remote.TokenResult;

/* loaded from: classes3.dex */
final class AutoValue_TokenResult extends TokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f16424a;

    /* renamed from: b  reason: collision with root package name */
    private final long f16425b;

    /* renamed from: c  reason: collision with root package name */
    private final TokenResult.ResponseCode f16426c;

    /* loaded from: classes3.dex */
    static final class Builder extends TokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16427a;

        /* renamed from: b  reason: collision with root package name */
        private Long f16428b;

        /* renamed from: c  reason: collision with root package name */
        private TokenResult.ResponseCode f16429c;

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult a() {
            String str = "";
            if (this.f16428b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.f16427a, this.f16428b.longValue(), this.f16429c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder b(TokenResult.ResponseCode responseCode) {
            this.f16429c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder c(String str) {
            this.f16427a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public TokenResult.Builder d(long j8) {
            this.f16428b = Long.valueOf(j8);
            return this;
        }
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode b() {
        return this.f16426c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String c() {
        return this.f16424a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @NonNull
    public long d() {
        return this.f16425b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f16424a;
        if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
            if (this.f16425b == tokenResult.d()) {
                TokenResult.ResponseCode responseCode = this.f16426c;
                if (responseCode == null) {
                    if (tokenResult.b() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f16424a;
        int i8 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j8 = this.f16425b;
        int i9 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f16426c;
        if (responseCode != null) {
            i8 = responseCode.hashCode();
        }
        return i9 ^ i8;
    }

    public String toString() {
        return "TokenResult{token=" + this.f16424a + ", tokenExpirationTimestamp=" + this.f16425b + ", responseCode=" + this.f16426c + "}";
    }

    private AutoValue_TokenResult(String str, long j8, TokenResult.ResponseCode responseCode) {
        this.f16424a = str;
        this.f16425b = j8;
        this.f16426c = responseCode;
    }
}
