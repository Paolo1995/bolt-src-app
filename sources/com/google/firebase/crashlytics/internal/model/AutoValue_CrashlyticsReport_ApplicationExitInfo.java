package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f15912a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15913b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15914c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15915d;

    /* renamed from: e  reason: collision with root package name */
    private final long f15916e;

    /* renamed from: f  reason: collision with root package name */
    private final long f15917f;

    /* renamed from: g  reason: collision with root package name */
    private final long f15918g;

    /* renamed from: h  reason: collision with root package name */
    private final String f15919h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f15920a;

        /* renamed from: b  reason: collision with root package name */
        private String f15921b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f15922c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f15923d;

        /* renamed from: e  reason: collision with root package name */
        private Long f15924e;

        /* renamed from: f  reason: collision with root package name */
        private Long f15925f;

        /* renamed from: g  reason: collision with root package name */
        private Long f15926g;

        /* renamed from: h  reason: collision with root package name */
        private String f15927h;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo a() {
            String str = "";
            if (this.f15920a == null) {
                str = " pid";
            }
            if (this.f15921b == null) {
                str = str + " processName";
            }
            if (this.f15922c == null) {
                str = str + " reasonCode";
            }
            if (this.f15923d == null) {
                str = str + " importance";
            }
            if (this.f15924e == null) {
                str = str + " pss";
            }
            if (this.f15925f == null) {
                str = str + " rss";
            }
            if (this.f15926g == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.f15920a.intValue(), this.f15921b, this.f15922c.intValue(), this.f15923d.intValue(), this.f15924e.longValue(), this.f15925f.longValue(), this.f15926g.longValue(), this.f15927h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder b(int i8) {
            this.f15923d = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder c(int i8) {
            this.f15920a = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder d(String str) {
            if (str != null) {
                this.f15921b = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder e(long j8) {
            this.f15924e = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder f(int i8) {
            this.f15922c = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder g(long j8) {
            this.f15925f = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder h(long j8) {
            this.f15926g = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder i(String str) {
            this.f15927h = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public int b() {
        return this.f15915d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public int c() {
        return this.f15912a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public String d() {
        return this.f15913b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public long e() {
        return this.f15916e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
        if (this.f15912a == applicationExitInfo.c() && this.f15913b.equals(applicationExitInfo.d()) && this.f15914c == applicationExitInfo.f() && this.f15915d == applicationExitInfo.b() && this.f15916e == applicationExitInfo.e() && this.f15917f == applicationExitInfo.g() && this.f15918g == applicationExitInfo.h()) {
            String str = this.f15919h;
            if (str == null) {
                if (applicationExitInfo.i() == null) {
                    return true;
                }
            } else if (str.equals(applicationExitInfo.i())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public int f() {
        return this.f15914c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public long g() {
        return this.f15917f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    @NonNull
    public long h() {
        return this.f15918g;
    }

    public int hashCode() {
        int hashCode;
        long j8 = this.f15916e;
        long j9 = this.f15917f;
        long j10 = this.f15918g;
        int hashCode2 = (((((((((((((this.f15912a ^ 1000003) * 1000003) ^ this.f15913b.hashCode()) * 1000003) ^ this.f15914c) * 1000003) ^ this.f15915d) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        String str = this.f15919h;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public String i() {
        return this.f15919h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f15912a + ", processName=" + this.f15913b + ", reasonCode=" + this.f15914c + ", importance=" + this.f15915d + ", pss=" + this.f15916e + ", rss=" + this.f15917f + ", timestamp=" + this.f15918g + ", traceFile=" + this.f15919h + "}";
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i8, String str, int i9, int i10, long j8, long j9, long j10, String str2) {
        this.f15912a = i8;
        this.f15913b = str;
        this.f15914c = i9;
        this.f15915d = i10;
        this.f15916e = j8;
        this.f15917f = j9;
        this.f15918g = j10;
        this.f15919h = str2;
    }
}
