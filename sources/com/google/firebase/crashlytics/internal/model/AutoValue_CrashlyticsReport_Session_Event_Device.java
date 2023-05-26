package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {

    /* renamed from: a  reason: collision with root package name */
    private final Double f16065a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16066b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16067c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16068d;

    /* renamed from: e  reason: collision with root package name */
    private final long f16069e;

    /* renamed from: f  reason: collision with root package name */
    private final long f16070f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Double f16071a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f16072b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f16073c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f16074d;

        /* renamed from: e  reason: collision with root package name */
        private Long f16075e;

        /* renamed from: f  reason: collision with root package name */
        private Long f16076f;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device a() {
            String str = "";
            if (this.f16072b == null) {
                str = " batteryVelocity";
            }
            if (this.f16073c == null) {
                str = str + " proximityOn";
            }
            if (this.f16074d == null) {
                str = str + " orientation";
            }
            if (this.f16075e == null) {
                str = str + " ramUsed";
            }
            if (this.f16076f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.f16071a, this.f16072b.intValue(), this.f16073c.booleanValue(), this.f16074d.intValue(), this.f16075e.longValue(), this.f16076f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder b(Double d8) {
            this.f16071a = d8;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder c(int i8) {
            this.f16072b = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder d(long j8) {
            this.f16076f = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder e(int i8) {
            this.f16074d = Integer.valueOf(i8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder f(boolean z7) {
            this.f16073c = Boolean.valueOf(z7);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder g(long j8) {
            this.f16075e = Long.valueOf(j8);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public Double b() {
        return this.f16065a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int c() {
        return this.f16066b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long d() {
        return this.f16070f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int e() {
        return this.f16068d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d8 = this.f16065a;
        if (d8 != null ? d8.equals(device.b()) : device.b() == null) {
            if (this.f16066b == device.c() && this.f16067c == device.g() && this.f16068d == device.e() && this.f16069e == device.f() && this.f16070f == device.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long f() {
        return this.f16069e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public boolean g() {
        return this.f16067c;
    }

    public int hashCode() {
        int hashCode;
        int i8;
        Double d8 = this.f16065a;
        if (d8 == null) {
            hashCode = 0;
        } else {
            hashCode = d8.hashCode();
        }
        int i9 = (((hashCode ^ 1000003) * 1000003) ^ this.f16066b) * 1000003;
        if (this.f16067c) {
            i8 = 1231;
        } else {
            i8 = 1237;
        }
        long j8 = this.f16069e;
        long j9 = this.f16070f;
        return ((((((i9 ^ i8) * 1000003) ^ this.f16068d) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f16065a + ", batteryVelocity=" + this.f16066b + ", proximityOn=" + this.f16067c + ", orientation=" + this.f16068d + ", ramUsed=" + this.f16069e + ", diskUsed=" + this.f16070f + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Device(Double d8, int i8, boolean z7, int i9, long j8, long j9) {
        this.f16065a = d8;
        this.f16066b = i8;
        this.f16067c = z7;
        this.f16068d = i9;
        this.f16069e = j8;
        this.f16070f = j9;
    }
}
