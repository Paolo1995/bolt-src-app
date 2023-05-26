package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {

    /* renamed from: a  reason: collision with root package name */
    private final String f15940a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15941b;

    /* renamed from: c  reason: collision with root package name */
    private final long f15942c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f15943d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15944e;

    /* renamed from: f  reason: collision with root package name */
    private final CrashlyticsReport.Session.Application f15945f;

    /* renamed from: g  reason: collision with root package name */
    private final CrashlyticsReport.Session.User f15946g;

    /* renamed from: h  reason: collision with root package name */
    private final CrashlyticsReport.Session.OperatingSystem f15947h;

    /* renamed from: i  reason: collision with root package name */
    private final CrashlyticsReport.Session.Device f15948i;

    /* renamed from: j  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event> f15949j;

    /* renamed from: k  reason: collision with root package name */
    private final int f15950k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f15951a;

        /* renamed from: b  reason: collision with root package name */
        private String f15952b;

        /* renamed from: c  reason: collision with root package name */
        private Long f15953c;

        /* renamed from: d  reason: collision with root package name */
        private Long f15954d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f15955e;

        /* renamed from: f  reason: collision with root package name */
        private CrashlyticsReport.Session.Application f15956f;

        /* renamed from: g  reason: collision with root package name */
        private CrashlyticsReport.Session.User f15957g;

        /* renamed from: h  reason: collision with root package name */
        private CrashlyticsReport.Session.OperatingSystem f15958h;

        /* renamed from: i  reason: collision with root package name */
        private CrashlyticsReport.Session.Device f15959i;

        /* renamed from: j  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event> f15960j;

        /* renamed from: k  reason: collision with root package name */
        private Integer f15961k;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session a() {
            String str = "";
            if (this.f15951a == null) {
                str = " generator";
            }
            if (this.f15952b == null) {
                str = str + " identifier";
            }
            if (this.f15953c == null) {
                str = str + " startedAt";
            }
            if (this.f15955e == null) {
                str = str + " crashed";
            }
            if (this.f15956f == null) {
                str = str + " app";
            }
            if (this.f15961k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.f15951a, this.f15952b, this.f15953c.longValue(), this.f15954d, this.f15955e.booleanValue(), this.f15956f, this.f15957g, this.f15958h, this.f15959i, this.f15960j, this.f15961k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder b(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.f15956f = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder c(boolean z7) {
            this.f15955e = Boolean.valueOf(z7);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder d(CrashlyticsReport.Session.Device device) {
            this.f15959i = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder e(Long l8) {
            this.f15954d = l8;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder f(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.f15960j = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder g(String str) {
            if (str != null) {
                this.f15951a = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder h(int i8) {
            this.f15961k = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder i(String str) {
            if (str != null) {
                this.f15952b = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder k(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f15958h = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder l(long j8) {
            this.f15953c = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder m(CrashlyticsReport.Session.User user) {
            this.f15957g = user;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.f15951a = session.f();
            this.f15952b = session.h();
            this.f15953c = Long.valueOf(session.k());
            this.f15954d = session.d();
            this.f15955e = Boolean.valueOf(session.m());
            this.f15956f = session.b();
            this.f15957g = session.l();
            this.f15958h = session.j();
            this.f15959i = session.c();
            this.f15960j = session.e();
            this.f15961k = Integer.valueOf(session.g());
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    public CrashlyticsReport.Session.Application b() {
        return this.f15945f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Device c() {
        return this.f15948i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public Long d() {
        return this.f15943d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public ImmutableList<CrashlyticsReport.Session.Event> e() {
        return this.f15949j;
    }

    public boolean equals(Object obj) {
        Long l8;
        CrashlyticsReport.Session.User user;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (this.f15940a.equals(session.f()) && this.f15941b.equals(session.h()) && this.f15942c == session.k() && ((l8 = this.f15943d) != null ? l8.equals(session.d()) : session.d() == null) && this.f15944e == session.m() && this.f15945f.equals(session.b()) && ((user = this.f15946g) != null ? user.equals(session.l()) : session.l() == null) && ((operatingSystem = this.f15947h) != null ? operatingSystem.equals(session.j()) : session.j() == null) && ((device = this.f15948i) != null ? device.equals(session.c()) : session.c() == null) && ((immutableList = this.f15949j) != null ? immutableList.equals(session.e()) : session.e() == null) && this.f15950k == session.g()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    public String f() {
        return this.f15940a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public int g() {
        return this.f15950k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    @NonNull
    public String h() {
        return this.f15941b;
    }

    public int hashCode() {
        int hashCode;
        int i8;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        long j8 = this.f15942c;
        int hashCode5 = (((((this.f15940a.hashCode() ^ 1000003) * 1000003) ^ this.f15941b.hashCode()) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        Long l8 = this.f15943d;
        int i9 = 0;
        if (l8 == null) {
            hashCode = 0;
        } else {
            hashCode = l8.hashCode();
        }
        int i10 = (hashCode5 ^ hashCode) * 1000003;
        if (this.f15944e) {
            i8 = 1231;
        } else {
            i8 = 1237;
        }
        int hashCode6 = (((i10 ^ i8) * 1000003) ^ this.f15945f.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.f15946g;
        if (user == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = user.hashCode();
        }
        int i11 = (hashCode6 ^ hashCode2) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f15947h;
        if (operatingSystem == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = operatingSystem.hashCode();
        }
        int i12 = (i11 ^ hashCode3) * 1000003;
        CrashlyticsReport.Session.Device device = this.f15948i;
        if (device == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = device.hashCode();
        }
        int i13 = (i12 ^ hashCode4) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.f15949j;
        if (immutableList != null) {
            i9 = immutableList.hashCode();
        }
        return ((i13 ^ i9) * 1000003) ^ this.f15950k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.OperatingSystem j() {
        return this.f15947h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public long k() {
        return this.f15942c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.User l() {
        return this.f15946g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public boolean m() {
        return this.f15944e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Builder n() {
        return new Builder(this);
    }

    public String toString() {
        return "Session{generator=" + this.f15940a + ", identifier=" + this.f15941b + ", startedAt=" + this.f15942c + ", endedAt=" + this.f15943d + ", crashed=" + this.f15944e + ", app=" + this.f15945f + ", user=" + this.f15946g + ", os=" + this.f15947h + ", device=" + this.f15948i + ", events=" + this.f15949j + ", generatorType=" + this.f15950k + "}";
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, long j8, Long l8, boolean z7, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device, ImmutableList<CrashlyticsReport.Session.Event> immutableList, int i8) {
        this.f15940a = str;
        this.f15941b = str2;
        this.f15942c = j8;
        this.f15943d = l8;
        this.f15944e = z7;
        this.f15945f = application;
        this.f15946g = user;
        this.f15947h = operatingSystem;
        this.f15948i = device;
        this.f15949j = immutableList;
        this.f15950k = i8;
    }
}
