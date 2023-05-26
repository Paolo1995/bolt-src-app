package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread extends CrashlyticsReport.Session.Event.Application.Execution.Thread {

    /* renamed from: a  reason: collision with root package name */
    private final String f16049a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16050b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f16051c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16052a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f16053b;

        /* renamed from: c  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f16054c;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread a() {
            String str = "";
            if (this.f16052a == null) {
                str = " name";
            }
            if (this.f16053b == null) {
                str = str + " importance";
            }
            if (this.f16054c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(this.f16052a, this.f16053b.intValue(), this.f16054c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder b(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            if (immutableList != null) {
                this.f16054c = immutableList;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder c(int i8) {
            this.f16053b = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder d(String str) {
            if (str != null) {
                this.f16052a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> b() {
        return this.f16051c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public int c() {
        return this.f16050b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    @NonNull
    public String d() {
        return this.f16049a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
        if (this.f16049a.equals(thread.d()) && this.f16050b == thread.c() && this.f16051c.equals(thread.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f16049a.hashCode() ^ 1000003) * 1000003) ^ this.f16050b) * 1000003) ^ this.f16051c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f16049a + ", importance=" + this.f16050b + ", frames=" + this.f16051c + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String str, int i8, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
        this.f16049a = str;
        this.f16050b = i8;
        this.f16051c = immutableList;
    }
}
