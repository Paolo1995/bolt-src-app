package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {

    /* renamed from: a  reason: collision with root package name */
    private final String f16087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.User.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f16088a;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User a() {
            String str = "";
            if (this.f16088a == null) {
                str = " identifier";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_User(this.f16088a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User.Builder b(String str) {
            if (str != null) {
                this.f16088a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User
    @NonNull
    public String b() {
        return this.f16087a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.f16087a.equals(((CrashlyticsReport.Session.User) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f16087a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f16087a + "}";
    }

    private AutoValue_CrashlyticsReport_Session_User(String str) {
        this.f16087a = str;
    }
}
