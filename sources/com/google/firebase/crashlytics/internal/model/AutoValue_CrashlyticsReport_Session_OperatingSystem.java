package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {

    /* renamed from: a  reason: collision with root package name */
    private final int f16079a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16080b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16081c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16082d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f16083a;

        /* renamed from: b  reason: collision with root package name */
        private String f16084b;

        /* renamed from: c  reason: collision with root package name */
        private String f16085c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f16086d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem a() {
            String str = "";
            if (this.f16083a == null) {
                str = " platform";
            }
            if (this.f16084b == null) {
                str = str + " version";
            }
            if (this.f16085c == null) {
                str = str + " buildVersion";
            }
            if (this.f16086d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.f16083a.intValue(), this.f16084b, this.f16085c, this.f16086d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder b(String str) {
            if (str != null) {
                this.f16085c = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder c(boolean z7) {
            this.f16086d = Boolean.valueOf(z7);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder d(int i8) {
            this.f16083a = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder e(String str) {
            if (str != null) {
                this.f16084b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String b() {
        return this.f16081c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public int c() {
        return this.f16079a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String d() {
        return this.f16080b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public boolean e() {
        return this.f16082d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        if (this.f16079a == operatingSystem.c() && this.f16080b.equals(operatingSystem.d()) && this.f16081c.equals(operatingSystem.b()) && this.f16082d == operatingSystem.e()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i8;
        int hashCode = (((((this.f16079a ^ 1000003) * 1000003) ^ this.f16080b.hashCode()) * 1000003) ^ this.f16081c.hashCode()) * 1000003;
        if (this.f16082d) {
            i8 = 1231;
        } else {
            i8 = 1237;
        }
        return hashCode ^ i8;
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f16079a + ", version=" + this.f16080b + ", buildVersion=" + this.f16081c + ", jailbroken=" + this.f16082d + "}";
    }

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i8, String str, String str2, boolean z7) {
        this.f16079a = i8;
        this.f16080b = str;
        this.f16081c = str2;
        this.f16082d = z7;
    }
}
