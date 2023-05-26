package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* loaded from: classes.dex */
final class AutoValue_ClientInfo extends ClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ClientInfo.ClientType f11944a;

    /* renamed from: b  reason: collision with root package name */
    private final AndroidClientInfo f11945b;

    /* loaded from: classes.dex */
    static final class Builder extends ClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ClientInfo.ClientType f11946a;

        /* renamed from: b  reason: collision with root package name */
        private AndroidClientInfo f11947b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo a() {
            return new AutoValue_ClientInfo(this.f11946a, this.f11947b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder b(AndroidClientInfo androidClientInfo) {
            this.f11947b = androidClientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder c(ClientInfo.ClientType clientType) {
            this.f11946a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public AndroidClientInfo b() {
        return this.f11945b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType c() {
        return this.f11944a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f11944a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            AndroidClientInfo androidClientInfo = this.f11945b;
            if (androidClientInfo == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        ClientInfo.ClientType clientType = this.f11944a;
        int i8 = 0;
        if (clientType == null) {
            hashCode = 0;
        } else {
            hashCode = clientType.hashCode();
        }
        int i9 = (hashCode ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f11945b;
        if (androidClientInfo != null) {
            i8 = androidClientInfo.hashCode();
        }
        return i9 ^ i8;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f11944a + ", androidClientInfo=" + this.f11945b + "}";
    }

    private AutoValue_ClientInfo(ClientInfo.ClientType clientType, AndroidClientInfo androidClientInfo) {
        this.f11944a = clientType;
        this.f11945b = androidClientInfo;
    }
}
