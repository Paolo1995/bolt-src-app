package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends CrashlyticsReport.Session.Event.Application.Execution.Signal {

    /* renamed from: a  reason: collision with root package name */
    private final String f16043a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16044b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16046a;

        /* renamed from: b  reason: collision with root package name */
        private String f16047b;

        /* renamed from: c  reason: collision with root package name */
        private Long f16048c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal a() {
            String str = "";
            if (this.f16046a == null) {
                str = " name";
            }
            if (this.f16047b == null) {
                str = str + " code";
            }
            if (this.f16048c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(this.f16046a, this.f16047b, this.f16048c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder b(long j8) {
            this.f16048c = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder c(String str) {
            if (str != null) {
                this.f16047b = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder d(String str) {
            if (str != null) {
                this.f16046a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    @NonNull
    public long b() {
        return this.f16045c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    @NonNull
    public String c() {
        return this.f16044b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    @NonNull
    public String d() {
        return this.f16043a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
        if (this.f16043a.equals(signal.d()) && this.f16044b.equals(signal.c()) && this.f16045c == signal.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f16045c;
        return ((((this.f16043a.hashCode() ^ 1000003) * 1000003) ^ this.f16044b.hashCode()) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f16043a + ", code=" + this.f16044b + ", address=" + this.f16045c + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String str, String str2, long j8) {
        this.f16043a = str;
        this.f16044b = str2;
        this.f16045c = j8;
    }
}
