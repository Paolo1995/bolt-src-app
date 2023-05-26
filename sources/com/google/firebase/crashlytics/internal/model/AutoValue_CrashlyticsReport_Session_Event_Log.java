package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.Session.Event.Log {

    /* renamed from: a  reason: collision with root package name */
    private final String f16077a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Log.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16078a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public CrashlyticsReport.Session.Event.Log a() {
            String str = "";
            if (this.f16078a == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Log(this.f16078a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public CrashlyticsReport.Session.Event.Log.Builder b(String str) {
            if (str != null) {
                this.f16078a = str;
                return this;
            }
            throw new NullPointerException("Null content");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log
    @NonNull
    public String b() {
        return this.f16077a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.f16077a.equals(((CrashlyticsReport.Session.Event.Log) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f16077a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f16077a + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Log(String str) {
        this.f16077a = str;
    }
}
