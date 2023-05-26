package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {

    /* renamed from: a  reason: collision with root package name */
    private final int f15977a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15978b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15979c;

    /* renamed from: d  reason: collision with root package name */
    private final long f15980d;

    /* renamed from: e  reason: collision with root package name */
    private final long f15981e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15982f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15983g;

    /* renamed from: h  reason: collision with root package name */
    private final String f15984h;

    /* renamed from: i  reason: collision with root package name */
    private final String f15985i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Device.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f15986a;

        /* renamed from: b  reason: collision with root package name */
        private String f15987b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f15988c;

        /* renamed from: d  reason: collision with root package name */
        private Long f15989d;

        /* renamed from: e  reason: collision with root package name */
        private Long f15990e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f15991f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f15992g;

        /* renamed from: h  reason: collision with root package name */
        private String f15993h;

        /* renamed from: i  reason: collision with root package name */
        private String f15994i;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device a() {
            String str = "";
            if (this.f15986a == null) {
                str = " arch";
            }
            if (this.f15987b == null) {
                str = str + " model";
            }
            if (this.f15988c == null) {
                str = str + " cores";
            }
            if (this.f15989d == null) {
                str = str + " ram";
            }
            if (this.f15990e == null) {
                str = str + " diskSpace";
            }
            if (this.f15991f == null) {
                str = str + " simulator";
            }
            if (this.f15992g == null) {
                str = str + " state";
            }
            if (this.f15993h == null) {
                str = str + " manufacturer";
            }
            if (this.f15994i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.f15986a.intValue(), this.f15987b, this.f15988c.intValue(), this.f15989d.longValue(), this.f15990e.longValue(), this.f15991f.booleanValue(), this.f15992g.intValue(), this.f15993h, this.f15994i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder b(int i8) {
            this.f15986a = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder c(int i8) {
            this.f15988c = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder d(long j8) {
            this.f15990e = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder e(String str) {
            if (str != null) {
                this.f15993h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder f(String str) {
            if (str != null) {
                this.f15987b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder g(String str) {
            if (str != null) {
                this.f15994i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder h(long j8) {
            this.f15989d = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder i(boolean z7) {
            this.f15991f = Boolean.valueOf(z7);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder j(int i8) {
            this.f15992g = Integer.valueOf(i8);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public int b() {
        return this.f15977a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int c() {
        return this.f15979c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long d() {
        return this.f15981e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String e() {
        return this.f15984h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        if (this.f15977a == device.b() && this.f15978b.equals(device.f()) && this.f15979c == device.c() && this.f15980d == device.h() && this.f15981e == device.d() && this.f15982f == device.j() && this.f15983g == device.i() && this.f15984h.equals(device.e()) && this.f15985i.equals(device.g())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String f() {
        return this.f15978b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    @NonNull
    public String g() {
        return this.f15985i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long h() {
        return this.f15980d;
    }

    public int hashCode() {
        int i8;
        long j8 = this.f15980d;
        long j9 = this.f15981e;
        int hashCode = (((((((((this.f15977a ^ 1000003) * 1000003) ^ this.f15978b.hashCode()) * 1000003) ^ this.f15979c) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003;
        if (this.f15982f) {
            i8 = 1231;
        } else {
            i8 = 1237;
        }
        return ((((((hashCode ^ i8) * 1000003) ^ this.f15983g) * 1000003) ^ this.f15984h.hashCode()) * 1000003) ^ this.f15985i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int i() {
        return this.f15983g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public boolean j() {
        return this.f15982f;
    }

    public String toString() {
        return "Device{arch=" + this.f15977a + ", model=" + this.f15978b + ", cores=" + this.f15979c + ", ram=" + this.f15980d + ", diskSpace=" + this.f15981e + ", simulator=" + this.f15982f + ", state=" + this.f15983g + ", manufacturer=" + this.f15984h + ", modelClass=" + this.f15985i + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Device(int i8, String str, int i9, long j8, long j9, boolean z7, int i10, String str2, String str3) {
        this.f15977a = i8;
        this.f15978b = str;
        this.f15979c = i9;
        this.f15980d = j8;
        this.f15981e = j9;
        this.f15982f = z7;
        this.f15983g = i10;
        this.f15984h = str2;
        this.f15985i = str3;
    }
}
