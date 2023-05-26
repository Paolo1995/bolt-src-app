package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {

    /* renamed from: a  reason: collision with root package name */
    private final long f16055a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16056b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16057c;

    /* renamed from: d  reason: collision with root package name */
    private final long f16058d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16059e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f16060a;

        /* renamed from: b  reason: collision with root package name */
        private String f16061b;

        /* renamed from: c  reason: collision with root package name */
        private String f16062c;

        /* renamed from: d  reason: collision with root package name */
        private Long f16063d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f16064e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame a() {
            String str = "";
            if (this.f16060a == null) {
                str = " pc";
            }
            if (this.f16061b == null) {
                str = str + " symbol";
            }
            if (this.f16063d == null) {
                str = str + " offset";
            }
            if (this.f16064e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f16060a.longValue(), this.f16061b, this.f16062c, this.f16063d.longValue(), this.f16064e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder b(String str) {
            this.f16062c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder c(int i8) {
            this.f16064e = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder d(long j8) {
            this.f16063d = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder e(long j8) {
            this.f16060a = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder f(String str) {
            if (str != null) {
                this.f16061b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public String b() {
        return this.f16057c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public int c() {
        return this.f16059e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public long d() {
        return this.f16058d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public long e() {
        return this.f16055a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f16055a == frame.e() && this.f16056b.equals(frame.f()) && ((str = this.f16057c) != null ? str.equals(frame.b()) : frame.b() == null) && this.f16058d == frame.d() && this.f16059e == frame.c()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    @NonNull
    public String f() {
        return this.f16056b;
    }

    public int hashCode() {
        int hashCode;
        long j8 = this.f16055a;
        int hashCode2 = (((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f16056b.hashCode()) * 1000003;
        String str = this.f16057c;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j9 = this.f16058d;
        return this.f16059e ^ ((((hashCode2 ^ hashCode) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f16055a + ", symbol=" + this.f16056b + ", file=" + this.f16057c + ", offset=" + this.f16058d + ", importance=" + this.f16059e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j8, String str, String str2, long j9, int i8) {
        this.f16055a = j8;
        this.f16056b = str;
        this.f16057c = str2;
        this.f16058d = j9;
        this.f16059e = i8;
    }
}
