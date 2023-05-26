package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution f16005a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.CustomAttribute> f16006b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.CustomAttribute> f16007c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f16008d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16009e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {

        /* renamed from: a  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution f16010a;

        /* renamed from: b  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.CustomAttribute> f16011b;

        /* renamed from: c  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.CustomAttribute> f16012c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f16013d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f16014e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application a() {
            String str = "";
            if (this.f16010a == null) {
                str = " execution";
            }
            if (this.f16014e == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(this.f16010a, this.f16011b, this.f16012c, this.f16013d, this.f16014e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder b(Boolean bool) {
            this.f16013d = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder c(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.f16011b = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder d(CrashlyticsReport.Session.Event.Application.Execution execution) {
            if (execution != null) {
                this.f16010a = execution;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder e(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.f16012c = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder f(int i8) {
            this.f16014e = Integer.valueOf(i8);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event.Application application) {
            this.f16010a = application.d();
            this.f16011b = application.c();
            this.f16012c = application.e();
            this.f16013d = application.b();
            this.f16014e = Integer.valueOf(application.f());
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public Boolean b() {
        return this.f16008d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public ImmutableList<CrashlyticsReport.CustomAttribute> c() {
        return this.f16006b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution d() {
        return this.f16005a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public ImmutableList<CrashlyticsReport.CustomAttribute> e() {
        return this.f16007c;
    }

    public boolean equals(Object obj) {
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
        if (this.f16005a.equals(application.d()) && ((immutableList = this.f16006b) != null ? immutableList.equals(application.c()) : application.c() == null) && ((immutableList2 = this.f16007c) != null ? immutableList2.equals(application.e()) : application.e() == null) && ((bool = this.f16008d) != null ? bool.equals(application.b()) : application.b() == null) && this.f16009e == application.f()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public int f() {
        return this.f16009e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public CrashlyticsReport.Session.Event.Application.Builder g() {
        return new Builder(this);
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (this.f16005a.hashCode() ^ 1000003) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList = this.f16006b;
        int i8 = 0;
        if (immutableList == null) {
            hashCode = 0;
        } else {
            hashCode = immutableList.hashCode();
        }
        int i9 = (hashCode3 ^ hashCode) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2 = this.f16007c;
        if (immutableList2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = immutableList2.hashCode();
        }
        int i10 = (i9 ^ hashCode2) * 1000003;
        Boolean bool = this.f16008d;
        if (bool != null) {
            i8 = bool.hashCode();
        }
        return ((i10 ^ i8) * 1000003) ^ this.f16009e;
    }

    public String toString() {
        return "Application{execution=" + this.f16005a + ", customAttributes=" + this.f16006b + ", internalKeys=" + this.f16007c + ", background=" + this.f16008d + ", uiOrientation=" + this.f16009e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution, ImmutableList<CrashlyticsReport.CustomAttribute> immutableList, ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2, Boolean bool, int i8) {
        this.f16005a = execution;
        this.f16006b = immutableList;
        this.f16007c = immutableList2;
        this.f16008d = bool;
        this.f16009e = i8;
    }
}
