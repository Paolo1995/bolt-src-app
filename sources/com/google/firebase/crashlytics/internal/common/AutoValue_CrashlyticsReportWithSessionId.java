package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReport f15566a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15567b;

    /* renamed from: c  reason: collision with root package name */
    private final File f15568c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport != null) {
            this.f15566a = crashlyticsReport;
            if (str != null) {
                this.f15567b = str;
                if (file != null) {
                    this.f15568c = file;
                    return;
                }
                throw new NullPointerException("Null reportFile");
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public CrashlyticsReport b() {
        return this.f15566a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public File c() {
        return this.f15568c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public String d() {
        return this.f15567b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        if (this.f15566a.equals(crashlyticsReportWithSessionId.b()) && this.f15567b.equals(crashlyticsReportWithSessionId.d()) && this.f15568c.equals(crashlyticsReportWithSessionId.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f15566a.hashCode() ^ 1000003) * 1000003) ^ this.f15567b.hashCode()) * 1000003) ^ this.f15568c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f15566a + ", sessionId=" + this.f15567b + ", reportFile=" + this.f15568c + "}";
    }
}
