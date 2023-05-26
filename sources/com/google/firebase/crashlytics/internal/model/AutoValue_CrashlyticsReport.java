package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport extends CrashlyticsReport {

    /* renamed from: b  reason: collision with root package name */
    private final String f15896b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15897c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15898d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15899e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15900f;

    /* renamed from: g  reason: collision with root package name */
    private final String f15901g;

    /* renamed from: h  reason: collision with root package name */
    private final CrashlyticsReport.Session f15902h;

    /* renamed from: i  reason: collision with root package name */
    private final CrashlyticsReport.FilesPayload f15903i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f15904a;

        /* renamed from: b  reason: collision with root package name */
        private String f15905b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f15906c;

        /* renamed from: d  reason: collision with root package name */
        private String f15907d;

        /* renamed from: e  reason: collision with root package name */
        private String f15908e;

        /* renamed from: f  reason: collision with root package name */
        private String f15909f;

        /* renamed from: g  reason: collision with root package name */
        private CrashlyticsReport.Session f15910g;

        /* renamed from: h  reason: collision with root package name */
        private CrashlyticsReport.FilesPayload f15911h;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport a() {
            String str = "";
            if (this.f15904a == null) {
                str = " sdkVersion";
            }
            if (this.f15905b == null) {
                str = str + " gmpAppId";
            }
            if (this.f15906c == null) {
                str = str + " platform";
            }
            if (this.f15907d == null) {
                str = str + " installationUuid";
            }
            if (this.f15908e == null) {
                str = str + " buildVersion";
            }
            if (this.f15909f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport(this.f15904a, this.f15905b, this.f15906c.intValue(), this.f15907d, this.f15908e, this.f15909f, this.f15910g, this.f15911h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder b(String str) {
            if (str != null) {
                this.f15908e = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder c(String str) {
            if (str != null) {
                this.f15909f = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder d(String str) {
            if (str != null) {
                this.f15905b = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder e(String str) {
            if (str != null) {
                this.f15907d = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder f(CrashlyticsReport.FilesPayload filesPayload) {
            this.f15911h = filesPayload;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder g(int i8) {
            this.f15906c = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder h(String str) {
            if (str != null) {
                this.f15904a = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder i(CrashlyticsReport.Session session) {
            this.f15910g = session;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.f15904a = crashlyticsReport.i();
            this.f15905b = crashlyticsReport.e();
            this.f15906c = Integer.valueOf(crashlyticsReport.h());
            this.f15907d = crashlyticsReport.f();
            this.f15908e = crashlyticsReport.c();
            this.f15909f = crashlyticsReport.d();
            this.f15910g = crashlyticsReport.j();
            this.f15911h = crashlyticsReport.g();
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String c() {
        return this.f15900f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String d() {
        return this.f15901g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String e() {
        return this.f15897c;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.Session session;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.f15896b.equals(crashlyticsReport.i()) && this.f15897c.equals(crashlyticsReport.e()) && this.f15898d == crashlyticsReport.h() && this.f15899e.equals(crashlyticsReport.f()) && this.f15900f.equals(crashlyticsReport.c()) && this.f15901g.equals(crashlyticsReport.d()) && ((session = this.f15902h) != null ? session.equals(crashlyticsReport.j()) : crashlyticsReport.j() == null)) {
            CrashlyticsReport.FilesPayload filesPayload = this.f15903i;
            if (filesPayload == null) {
                if (crashlyticsReport.g() == null) {
                    return true;
                }
            } else if (filesPayload.equals(crashlyticsReport.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String f() {
        return this.f15899e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.FilesPayload g() {
        return this.f15903i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int h() {
        return this.f15898d;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((((((((((this.f15896b.hashCode() ^ 1000003) * 1000003) ^ this.f15897c.hashCode()) * 1000003) ^ this.f15898d) * 1000003) ^ this.f15899e.hashCode()) * 1000003) ^ this.f15900f.hashCode()) * 1000003) ^ this.f15901g.hashCode()) * 1000003;
        CrashlyticsReport.Session session = this.f15902h;
        int i8 = 0;
        if (session == null) {
            hashCode = 0;
        } else {
            hashCode = session.hashCode();
        }
        int i9 = (hashCode2 ^ hashCode) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.f15903i;
        if (filesPayload != null) {
            i8 = filesPayload.hashCode();
        }
        return i9 ^ i8;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    @NonNull
    public String i() {
        return this.f15896b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.Session j() {
        return this.f15902h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    protected CrashlyticsReport.Builder k() {
        return new Builder(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f15896b + ", gmpAppId=" + this.f15897c + ", platform=" + this.f15898d + ", installationUuid=" + this.f15899e + ", buildVersion=" + this.f15900f + ", displayVersion=" + this.f15901g + ", session=" + this.f15902h + ", ndkPayload=" + this.f15903i + "}";
    }

    private AutoValue_CrashlyticsReport(String str, String str2, int i8, String str3, String str4, String str5, CrashlyticsReport.Session session, CrashlyticsReport.FilesPayload filesPayload) {
        this.f15896b = str;
        this.f15897c = str2;
        this.f15898d = i8;
        this.f15899e = str3;
        this.f15900f = str4;
        this.f15901g = str5;
        this.f15902h = session;
        this.f15903i = filesPayload;
    }
}
