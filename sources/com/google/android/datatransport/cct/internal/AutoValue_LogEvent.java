package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_LogEvent extends LogEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f11948a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f11949b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11950c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f11951d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11952e;

    /* renamed from: f  reason: collision with root package name */
    private final long f11953f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkConnectionInfo f11954g;

    /* loaded from: classes.dex */
    static final class Builder extends LogEvent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f11955a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f11956b;

        /* renamed from: c  reason: collision with root package name */
        private Long f11957c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f11958d;

        /* renamed from: e  reason: collision with root package name */
        private String f11959e;

        /* renamed from: f  reason: collision with root package name */
        private Long f11960f;

        /* renamed from: g  reason: collision with root package name */
        private NetworkConnectionInfo f11961g;

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent a() {
            String str = "";
            if (this.f11955a == null) {
                str = " eventTimeMs";
            }
            if (this.f11957c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f11960f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.f11955a.longValue(), this.f11956b, this.f11957c.longValue(), this.f11958d, this.f11959e, this.f11960f.longValue(), this.f11961g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder b(Integer num) {
            this.f11956b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder c(long j8) {
            this.f11955a = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder d(long j8) {
            this.f11957c = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder e(NetworkConnectionInfo networkConnectionInfo) {
            this.f11961g = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder f(byte[] bArr) {
            this.f11958d = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder g(String str) {
            this.f11959e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder h(long j8) {
            this.f11960f = Long.valueOf(j8);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public Integer b() {
        return this.f11949b;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long c() {
        return this.f11948a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long d() {
        return this.f11950c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public NetworkConnectionInfo e() {
        return this.f11954g;
    }

    public boolean equals(Object obj) {
        Integer num;
        byte[] f8;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.f11948a == logEvent.c() && ((num = this.f11949b) != null ? num.equals(logEvent.b()) : logEvent.b() == null) && this.f11950c == logEvent.d()) {
            byte[] bArr = this.f11951d;
            if (logEvent instanceof AutoValue_LogEvent) {
                f8 = ((AutoValue_LogEvent) logEvent).f11951d;
            } else {
                f8 = logEvent.f();
            }
            if (Arrays.equals(bArr, f8) && ((str = this.f11952e) != null ? str.equals(logEvent.g()) : logEvent.g() == null) && this.f11953f == logEvent.h()) {
                NetworkConnectionInfo networkConnectionInfo = this.f11954g;
                if (networkConnectionInfo == null) {
                    if (logEvent.e() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(logEvent.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public byte[] f() {
        return this.f11951d;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public String g() {
        return this.f11952e;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long h() {
        return this.f11953f;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        long j8 = this.f11948a;
        int i8 = (((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f11949b;
        int i9 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        long j9 = this.f11950c;
        int hashCode3 = (((((i8 ^ hashCode) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f11951d)) * 1000003;
        String str = this.f11952e;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        long j10 = this.f11953f;
        int i10 = (((hashCode3 ^ hashCode2) * 1000003) ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f11954g;
        if (networkConnectionInfo != null) {
            i9 = networkConnectionInfo.hashCode();
        }
        return i10 ^ i9;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f11948a + ", eventCode=" + this.f11949b + ", eventUptimeMs=" + this.f11950c + ", sourceExtension=" + Arrays.toString(this.f11951d) + ", sourceExtensionJsonProto3=" + this.f11952e + ", timezoneOffsetSeconds=" + this.f11953f + ", networkConnectionInfo=" + this.f11954g + "}";
    }

    private AutoValue_LogEvent(long j8, Integer num, long j9, byte[] bArr, String str, long j10, NetworkConnectionInfo networkConnectionInfo) {
        this.f11948a = j8;
        this.f11949b = num;
        this.f11950c = j9;
        this.f11951d = bArr;
        this.f11952e = str;
        this.f11953f = j10;
        this.f11954g = networkConnectionInfo;
    }
}
