package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.Session.Event.Application.Execution.Exception {

    /* renamed from: a  reason: collision with root package name */
    private final String f16033a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16034b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f16035c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f16036d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16037e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16038a;

        /* renamed from: b  reason: collision with root package name */
        private String f16039b;

        /* renamed from: c  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f16040c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f16041d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f16042e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception a() {
            String str = "";
            if (this.f16038a == null) {
                str = " type";
            }
            if (this.f16040c == null) {
                str = str + " frames";
            }
            if (this.f16042e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(this.f16038a, this.f16039b, this.f16040c, this.f16041d, this.f16042e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder b(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f16041d = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder c(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            if (immutableList != null) {
                this.f16040c = immutableList;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder d(int i8) {
            this.f16042e = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder e(String str) {
            this.f16039b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder f(String str) {
            if (str != null) {
                this.f16038a = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public CrashlyticsReport.Session.Event.Application.Execution.Exception b() {
        return this.f16036d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> c() {
        return this.f16035c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public int d() {
        return this.f16037e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public String e() {
        return this.f16034b;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception2 = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
        if (this.f16033a.equals(exception2.f()) && ((str = this.f16034b) != null ? str.equals(exception2.e()) : exception2.e() == null) && this.f16035c.equals(exception2.c()) && ((exception = this.f16036d) != null ? exception.equals(exception2.b()) : exception2.b() == null) && this.f16037e == exception2.d()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    @NonNull
    public String f() {
        return this.f16033a;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f16033a.hashCode() ^ 1000003) * 1000003;
        String str = this.f16034b;
        int i8 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((hashCode2 ^ hashCode) * 1000003) ^ this.f16035c.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f16036d;
        if (exception != null) {
            i8 = exception.hashCode();
        }
        return ((hashCode3 ^ i8) * 1000003) ^ this.f16037e;
    }

    public String toString() {
        return "Exception{type=" + this.f16033a + ", reason=" + this.f16034b + ", frames=" + this.f16035c + ", causedBy=" + this.f16036d + ", overflowCount=" + this.f16037e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int i8) {
        this.f16033a = str;
        this.f16034b = str2;
        this.f16035c = immutableList;
        this.f16036d = exception;
        this.f16037e = i8;
    }
}
