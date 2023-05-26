package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_CustomAttribute extends CrashlyticsReport.CustomAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final String f15928a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15929b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.CustomAttribute.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f15930a;

        /* renamed from: b  reason: collision with root package name */
        private String f15931b;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute a() {
            String str = "";
            if (this.f15930a == null) {
                str = " key";
            }
            if (this.f15931b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_CustomAttribute(this.f15930a, this.f15931b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder b(String str) {
            if (str != null) {
                this.f15930a = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder c(String str) {
            if (str != null) {
                this.f15931b = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    @NonNull
    public String b() {
        return this.f15928a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    @NonNull
    public String c() {
        return this.f15929b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.CustomAttribute)) {
            return false;
        }
        CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
        if (this.f15928a.equals(customAttribute.b()) && this.f15929b.equals(customAttribute.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f15928a.hashCode() ^ 1000003) * 1000003) ^ this.f15929b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f15928a + ", value=" + this.f15929b + "}";
    }

    private AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2) {
        this.f15928a = str;
        this.f15929b = str2;
    }
}
