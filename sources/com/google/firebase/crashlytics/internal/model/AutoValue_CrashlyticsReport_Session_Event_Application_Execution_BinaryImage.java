package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {

    /* renamed from: a  reason: collision with root package name */
    private final long f16025a;

    /* renamed from: b  reason: collision with root package name */
    private final long f16026b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16027c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16028d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f16029a;

        /* renamed from: b  reason: collision with root package name */
        private Long f16030b;

        /* renamed from: c  reason: collision with root package name */
        private String f16031c;

        /* renamed from: d  reason: collision with root package name */
        private String f16032d;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage a() {
            String str = "";
            if (this.f16029a == null) {
                str = " baseAddress";
            }
            if (this.f16030b == null) {
                str = str + " size";
            }
            if (this.f16031c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.f16029a.longValue(), this.f16030b.longValue(), this.f16031c, this.f16032d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder b(long j8) {
            this.f16029a = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder c(String str) {
            if (str != null) {
                this.f16031c = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder d(long j8) {
            this.f16030b = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder e(String str) {
            this.f16032d = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    @NonNull
    public long b() {
        return this.f16025a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    @NonNull
    public String c() {
        return this.f16027c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public long d() {
        return this.f16026b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public String e() {
        return this.f16028d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.f16025a == binaryImage.b() && this.f16026b == binaryImage.d() && this.f16027c.equals(binaryImage.c())) {
            String str = this.f16028d;
            if (str == null) {
                if (binaryImage.e() == null) {
                    return true;
                }
            } else if (str.equals(binaryImage.e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        long j8 = this.f16025a;
        long j9 = this.f16026b;
        int hashCode2 = (((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003) ^ this.f16027c.hashCode()) * 1000003;
        String str = this.f16028d;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode ^ hashCode2;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f16025a + ", size=" + this.f16026b + ", name=" + this.f16027c + ", uuid=" + this.f16028d + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j8, long j9, String str, String str2) {
        this.f16025a = j8;
        this.f16026b = j9;
        this.f16027c = str;
        this.f16028d = str2;
    }
}
