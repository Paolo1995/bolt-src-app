package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes3.dex */
final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {

    /* renamed from: b  reason: collision with root package name */
    private final String f16388b;

    /* renamed from: c  reason: collision with root package name */
    private final PersistedInstallation.RegistrationStatus f16389c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16390d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16391e;

    /* renamed from: f  reason: collision with root package name */
    private final long f16392f;

    /* renamed from: g  reason: collision with root package name */
    private final long f16393g;

    /* renamed from: h  reason: collision with root package name */
    private final String f16394h;

    /* loaded from: classes3.dex */
    static final class Builder extends PersistedInstallationEntry.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16395a;

        /* renamed from: b  reason: collision with root package name */
        private PersistedInstallation.RegistrationStatus f16396b;

        /* renamed from: c  reason: collision with root package name */
        private String f16397c;

        /* renamed from: d  reason: collision with root package name */
        private String f16398d;

        /* renamed from: e  reason: collision with root package name */
        private Long f16399e;

        /* renamed from: f  reason: collision with root package name */
        private Long f16400f;

        /* renamed from: g  reason: collision with root package name */
        private String f16401g;

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry a() {
            String str = "";
            if (this.f16396b == null) {
                str = " registrationStatus";
            }
            if (this.f16399e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f16400f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.f16395a, this.f16396b, this.f16397c, this.f16398d, this.f16399e.longValue(), this.f16400f.longValue(), this.f16401g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder b(String str) {
            this.f16397c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder c(long j8) {
            this.f16399e = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder d(String str) {
            this.f16395a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder e(String str) {
            this.f16401g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder f(String str) {
            this.f16398d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder g(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus != null) {
                this.f16396b = registrationStatus;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder h(long j8) {
            this.f16400f = Long.valueOf(j8);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(PersistedInstallationEntry persistedInstallationEntry) {
            this.f16395a = persistedInstallationEntry.d();
            this.f16396b = persistedInstallationEntry.g();
            this.f16397c = persistedInstallationEntry.b();
            this.f16398d = persistedInstallationEntry.f();
            this.f16399e = Long.valueOf(persistedInstallationEntry.c());
            this.f16400f = Long.valueOf(persistedInstallationEntry.h());
            this.f16401g = persistedInstallationEntry.e();
        }
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String b() {
        return this.f16390d;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long c() {
        return this.f16392f;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String d() {
        return this.f16388b;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String e() {
        return this.f16394h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f16388b;
        if (str3 != null ? str3.equals(persistedInstallationEntry.d()) : persistedInstallationEntry.d() == null) {
            if (this.f16389c.equals(persistedInstallationEntry.g()) && ((str = this.f16390d) != null ? str.equals(persistedInstallationEntry.b()) : persistedInstallationEntry.b() == null) && ((str2 = this.f16391e) != null ? str2.equals(persistedInstallationEntry.f()) : persistedInstallationEntry.f() == null) && this.f16392f == persistedInstallationEntry.c() && this.f16393g == persistedInstallationEntry.h()) {
                String str4 = this.f16394h;
                if (str4 == null) {
                    if (persistedInstallationEntry.e() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String f() {
        return this.f16391e;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    @NonNull
    public PersistedInstallation.RegistrationStatus g() {
        return this.f16389c;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long h() {
        return this.f16393g;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.f16388b;
        int i8 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode4 = (((hashCode ^ 1000003) * 1000003) ^ this.f16389c.hashCode()) * 1000003;
        String str2 = this.f16390d;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i9 = (hashCode4 ^ hashCode2) * 1000003;
        String str3 = this.f16391e;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        long j8 = this.f16392f;
        long j9 = this.f16393g;
        int i10 = (((((i9 ^ hashCode3) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003;
        String str4 = this.f16394h;
        if (str4 != null) {
            i8 = str4.hashCode();
        }
        return i10 ^ i8;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public PersistedInstallationEntry.Builder n() {
        return new Builder(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f16388b + ", registrationStatus=" + this.f16389c + ", authToken=" + this.f16390d + ", refreshToken=" + this.f16391e + ", expiresInSecs=" + this.f16392f + ", tokenCreationEpochInSecs=" + this.f16393g + ", fisError=" + this.f16394h + "}";
    }

    private AutoValue_PersistedInstallationEntry(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j8, long j9, String str4) {
        this.f16388b = str;
        this.f16389c = registrationStatus;
        this.f16390d = str2;
        this.f16391e = str3;
        this.f16392f = j8;
        this.f16393g = j9;
        this.f16394h = str4;
    }
}
