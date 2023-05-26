package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_LogRequest extends LogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final long f11962a;

    /* renamed from: b  reason: collision with root package name */
    private final long f11963b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientInfo f11964c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f11965d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11966e;

    /* renamed from: f  reason: collision with root package name */
    private final List<LogEvent> f11967f;

    /* renamed from: g  reason: collision with root package name */
    private final QosTier f11968g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends LogRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f11969a;

        /* renamed from: b  reason: collision with root package name */
        private Long f11970b;

        /* renamed from: c  reason: collision with root package name */
        private ClientInfo f11971c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f11972d;

        /* renamed from: e  reason: collision with root package name */
        private String f11973e;

        /* renamed from: f  reason: collision with root package name */
        private List<LogEvent> f11974f;

        /* renamed from: g  reason: collision with root package name */
        private QosTier f11975g;

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest a() {
            String str = "";
            if (this.f11969a == null) {
                str = " requestTimeMs";
            }
            if (this.f11970b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogRequest(this.f11969a.longValue(), this.f11970b.longValue(), this.f11971c, this.f11972d, this.f11973e, this.f11974f, this.f11975g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder b(ClientInfo clientInfo) {
            this.f11971c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder c(List<LogEvent> list) {
            this.f11974f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder d(Integer num) {
            this.f11972d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder e(String str) {
            this.f11973e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder f(QosTier qosTier) {
            this.f11975g = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder g(long j8) {
            this.f11969a = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder h(long j8) {
            this.f11970b = Long.valueOf(j8);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public ClientInfo b() {
        return this.f11964c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public List<LogEvent> c() {
        return this.f11967f;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public Integer d() {
        return this.f11965d;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public String e() {
        return this.f11966e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f11962a == logRequest.g() && this.f11963b == logRequest.h() && ((clientInfo = this.f11964c) != null ? clientInfo.equals(logRequest.b()) : logRequest.b() == null) && ((num = this.f11965d) != null ? num.equals(logRequest.d()) : logRequest.d() == null) && ((str = this.f11966e) != null ? str.equals(logRequest.e()) : logRequest.e() == null) && ((list = this.f11967f) != null ? list.equals(logRequest.c()) : logRequest.c() == null)) {
            QosTier qosTier = this.f11968g;
            if (qosTier == null) {
                if (logRequest.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public QosTier f() {
        return this.f11968g;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long g() {
        return this.f11962a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long h() {
        return this.f11963b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        long j8 = this.f11962a;
        long j9 = this.f11963b;
        int i8 = (((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003;
        ClientInfo clientInfo = this.f11964c;
        int i9 = 0;
        if (clientInfo == null) {
            hashCode = 0;
        } else {
            hashCode = clientInfo.hashCode();
        }
        int i10 = (i8 ^ hashCode) * 1000003;
        Integer num = this.f11965d;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i11 = (i10 ^ hashCode2) * 1000003;
        String str = this.f11966e;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i12 = (i11 ^ hashCode3) * 1000003;
        List<LogEvent> list = this.f11967f;
        if (list == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = list.hashCode();
        }
        int i13 = (i12 ^ hashCode4) * 1000003;
        QosTier qosTier = this.f11968g;
        if (qosTier != null) {
            i9 = qosTier.hashCode();
        }
        return i13 ^ i9;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f11962a + ", requestUptimeMs=" + this.f11963b + ", clientInfo=" + this.f11964c + ", logSource=" + this.f11965d + ", logSourceName=" + this.f11966e + ", logEvents=" + this.f11967f + ", qosTier=" + this.f11968g + "}";
    }

    private AutoValue_LogRequest(long j8, long j9, ClientInfo clientInfo, Integer num, String str, List<LogEvent> list, QosTier qosTier) {
        this.f11962a = j8;
        this.f11963b = j9;
        this.f11964c = clientInfo;
        this.f11965d = num;
        this.f11966e = str;
        this.f11967f = list;
        this.f11968g = qosTier;
    }
}
