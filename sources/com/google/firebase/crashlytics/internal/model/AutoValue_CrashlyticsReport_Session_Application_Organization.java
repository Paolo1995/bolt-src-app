package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Application_Organization extends CrashlyticsReport.Session.Application.Organization {

    /* renamed from: a  reason: collision with root package name */
    private final String f15976a;

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization
    @NonNull
    public String a() {
        return this.f15976a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Application.Organization) {
            return this.f15976a.equals(((CrashlyticsReport.Session.Application.Organization) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f15976a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.f15976a + "}";
    }
}
