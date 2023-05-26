package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {

    /* renamed from: a  reason: collision with root package name */
    private final long f15995a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15996b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application f15997c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Device f15998d;

    /* renamed from: e  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Log f15999e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f16000a;

        /* renamed from: b  reason: collision with root package name */
        private String f16001b;

        /* renamed from: c  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application f16002c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Device f16003d;

        /* renamed from: e  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Log f16004e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event a() {
            String str = "";
            if (this.f16000a == null) {
                str = " timestamp";
            }
            if (this.f16001b == null) {
                str = str + " type";
            }
            if (this.f16002c == null) {
                str = str + " app";
            }
            if (this.f16003d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.f16000a.longValue(), this.f16001b, this.f16002c, this.f16003d, this.f16004e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder b(CrashlyticsReport.Session.Event.Application application) {
            if (application != null) {
                this.f16002c = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder c(CrashlyticsReport.Session.Event.Device device) {
            if (device != null) {
                this.f16003d = device;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder d(CrashlyticsReport.Session.Event.Log log) {
            this.f16004e = log;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder e(long j8) {
            this.f16000a = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder f(String str) {
            if (str != null) {
                this.f16001b = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.f16000a = Long.valueOf(event.e());
            this.f16001b = event.f();
            this.f16002c = event.b();
            this.f16003d = event.c();
            this.f16004e = event.d();
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public CrashlyticsReport.Session.Event.Application b() {
        return this.f15997c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public CrashlyticsReport.Session.Event.Device c() {
        return this.f15998d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Log d() {
        return this.f15999e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public long e() {
        return this.f15995a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.f15995a == event.e() && this.f15996b.equals(event.f()) && this.f15997c.equals(event.b()) && this.f15998d.equals(event.c())) {
            CrashlyticsReport.Session.Event.Log log = this.f15999e;
            if (log == null) {
                if (event.d() == null) {
                    return true;
                }
            } else if (log.equals(event.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    @NonNull
    public String f() {
        return this.f15996b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Builder g() {
        return new Builder(this);
    }

    public int hashCode() {
        int hashCode;
        long j8 = this.f15995a;
        int hashCode2 = (((((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f15996b.hashCode()) * 1000003) ^ this.f15997c.hashCode()) * 1000003) ^ this.f15998d.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.f15999e;
        if (log == null) {
            hashCode = 0;
        } else {
            hashCode = log.hashCode();
        }
        return hashCode ^ hashCode2;
    }

    public String toString() {
        return "Event{timestamp=" + this.f15995a + ", type=" + this.f15996b + ", app=" + this.f15997c + ", device=" + this.f15998d + ", log=" + this.f15999e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event(long j8, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, CrashlyticsReport.Session.Event.Log log) {
        this.f15995a = j8;
        this.f15996b = str;
        this.f15997c = application;
        this.f15998d = device;
        this.f15999e = log;
    }
}
