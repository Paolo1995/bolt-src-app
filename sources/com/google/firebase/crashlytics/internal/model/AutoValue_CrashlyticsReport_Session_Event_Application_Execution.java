package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> f16015a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f16016b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsReport.ApplicationExitInfo f16017c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Signal f16018d;

    /* renamed from: e  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f16019e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> f16020a;

        /* renamed from: b  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f16021b;

        /* renamed from: c  reason: collision with root package name */
        private CrashlyticsReport.ApplicationExitInfo f16022c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Signal f16023d;

        /* renamed from: e  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f16024e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution a() {
            String str = "";
            if (this.f16023d == null) {
                str = " signal";
            }
            if (this.f16024e == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.f16020a, this.f16021b, this.f16022c, this.f16023d, this.f16024e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f16022c = applicationExitInfo;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder c(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList) {
            if (immutableList != null) {
                this.f16024e = immutableList;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder d(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f16021b = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder e(CrashlyticsReport.Session.Event.Application.Execution.Signal signal) {
            if (signal != null) {
                this.f16023d = signal;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder f(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList) {
            this.f16020a = immutableList;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public CrashlyticsReport.ApplicationExitInfo b() {
        return this.f16017c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> c() {
        return this.f16019e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public CrashlyticsReport.Session.Event.Application.Execution.Exception d() {
        return this.f16016b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Signal e() {
        return this.f16018d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList = this.f16015a;
        if (immutableList != null ? immutableList.equals(execution.f()) : execution.f() == null) {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f16016b;
            if (exception != null ? exception.equals(execution.d()) : execution.d() == null) {
                CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f16017c;
                if (applicationExitInfo != null ? applicationExitInfo.equals(execution.b()) : execution.b() == null) {
                    if (this.f16018d.equals(execution.e()) && this.f16019e.equals(execution.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> f() {
        return this.f16015a;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList = this.f16015a;
        int i8 = 0;
        if (immutableList == null) {
            hashCode = 0;
        } else {
            hashCode = immutableList.hashCode();
        }
        int i9 = (hashCode ^ 1000003) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f16016b;
        if (exception == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = exception.hashCode();
        }
        int i10 = (i9 ^ hashCode2) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f16017c;
        if (applicationExitInfo != null) {
            i8 = applicationExitInfo.hashCode();
        }
        return ((((i10 ^ i8) * 1000003) ^ this.f16018d.hashCode()) * 1000003) ^ this.f16019e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f16015a + ", exception=" + this.f16016b + ", appExitInfo=" + this.f16017c + ", signal=" + this.f16018d + ", binaries=" + this.f16019e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, CrashlyticsReport.ApplicationExitInfo applicationExitInfo, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList2) {
        this.f16015a = immutableList;
        this.f16016b = exception;
        this.f16017c = applicationExitInfo;
        this.f16018d = signal;
        this.f16019e = immutableList2;
    }
}
