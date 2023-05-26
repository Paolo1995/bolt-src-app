package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {

    /* renamed from: a  reason: collision with root package name */
    private final String f15962a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15963b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15964c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Application.Organization f15965d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15966e;

    /* renamed from: f  reason: collision with root package name */
    private final String f15967f;

    /* renamed from: g  reason: collision with root package name */
    private final String f15968g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Application.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f15969a;

        /* renamed from: b  reason: collision with root package name */
        private String f15970b;

        /* renamed from: c  reason: collision with root package name */
        private String f15971c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Application.Organization f15972d;

        /* renamed from: e  reason: collision with root package name */
        private String f15973e;

        /* renamed from: f  reason: collision with root package name */
        private String f15974f;

        /* renamed from: g  reason: collision with root package name */
        private String f15975g;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application a() {
            String str = "";
            if (this.f15969a == null) {
                str = " identifier";
            }
            if (this.f15970b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Application(this.f15969a, this.f15970b, this.f15971c, this.f15972d, this.f15973e, this.f15974f, this.f15975g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder b(String str) {
            this.f15974f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder c(String str) {
            this.f15975g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder d(String str) {
            this.f15971c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder e(String str) {
            if (str != null) {
                this.f15969a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder f(String str) {
            this.f15973e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder g(String str) {
            if (str != null) {
                this.f15970b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String b() {
        return this.f15967f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String c() {
        return this.f15968g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String d() {
        return this.f15964c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @NonNull
    public String e() {
        return this.f15962a;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (this.f15962a.equals(application.e()) && this.f15963b.equals(application.h()) && ((str = this.f15964c) != null ? str.equals(application.d()) : application.d() == null) && ((organization = this.f15965d) != null ? organization.equals(application.g()) : application.g() == null) && ((str2 = this.f15966e) != null ? str2.equals(application.f()) : application.f() == null) && ((str3 = this.f15967f) != null ? str3.equals(application.b()) : application.b() == null)) {
            String str4 = this.f15968g;
            if (str4 == null) {
                if (application.c() == null) {
                    return true;
                }
            } else if (str4.equals(application.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String f() {
        return this.f15966e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public CrashlyticsReport.Session.Application.Organization g() {
        return this.f15965d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    @NonNull
    public String h() {
        return this.f15963b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = (((this.f15962a.hashCode() ^ 1000003) * 1000003) ^ this.f15963b.hashCode()) * 1000003;
        String str = this.f15964c;
        int i8 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i9 = (hashCode5 ^ hashCode) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization = this.f15965d;
        if (organization == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = organization.hashCode();
        }
        int i10 = (i9 ^ hashCode2) * 1000003;
        String str2 = this.f15966e;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i11 = (i10 ^ hashCode3) * 1000003;
        String str3 = this.f15967f;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i12 = (i11 ^ hashCode4) * 1000003;
        String str4 = this.f15968g;
        if (str4 != null) {
            i8 = str4.hashCode();
        }
        return i12 ^ i8;
    }

    public String toString() {
        return "Application{identifier=" + this.f15962a + ", version=" + this.f15963b + ", displayVersion=" + this.f15964c + ", organization=" + this.f15965d + ", installationUuid=" + this.f15966e + ", developmentPlatform=" + this.f15967f + ", developmentPlatformVersion=" + this.f15968g + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, CrashlyticsReport.Session.Application.Organization organization, String str4, String str5, String str6) {
        this.f15962a = str;
        this.f15963b = str2;
        this.f15964c = str3;
        this.f15965d = organization;
        this.f15966e = str4;
        this.f15967f = str5;
        this.f15968g = str6;
    }
}
