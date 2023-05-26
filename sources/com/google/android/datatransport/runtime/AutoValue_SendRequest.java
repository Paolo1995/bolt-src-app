package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* loaded from: classes.dex */
final class AutoValue_SendRequest extends SendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f12070a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12071b;

    /* renamed from: c  reason: collision with root package name */
    private final Event<?> f12072c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<?, byte[]> f12073d;

    /* renamed from: e  reason: collision with root package name */
    private final Encoding f12074e;

    /* loaded from: classes.dex */
    static final class Builder extends SendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private TransportContext f12075a;

        /* renamed from: b  reason: collision with root package name */
        private String f12076b;

        /* renamed from: c  reason: collision with root package name */
        private Event<?> f12077c;

        /* renamed from: d  reason: collision with root package name */
        private Transformer<?, byte[]> f12078d;

        /* renamed from: e  reason: collision with root package name */
        private Encoding f12079e;

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest a() {
            String str = "";
            if (this.f12075a == null) {
                str = " transportContext";
            }
            if (this.f12076b == null) {
                str = str + " transportName";
            }
            if (this.f12077c == null) {
                str = str + " event";
            }
            if (this.f12078d == null) {
                str = str + " transformer";
            }
            if (this.f12079e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new AutoValue_SendRequest(this.f12075a, this.f12076b, this.f12077c, this.f12078d, this.f12079e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder b(Encoding encoding) {
            if (encoding != null) {
                this.f12079e = encoding;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder c(Event<?> event) {
            if (event != null) {
                this.f12077c = event;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder d(Transformer<?, byte[]> transformer) {
            if (transformer != null) {
                this.f12078d = transformer;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder e(TransportContext transportContext) {
            if (transportContext != null) {
                this.f12075a = transportContext;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder f(String str) {
            if (str != null) {
                this.f12076b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Encoding b() {
        return this.f12074e;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    Event<?> c() {
        return this.f12072c;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    Transformer<?, byte[]> e() {
        return this.f12073d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        if (this.f12070a.equals(sendRequest.f()) && this.f12071b.equals(sendRequest.g()) && this.f12072c.equals(sendRequest.c()) && this.f12073d.equals(sendRequest.e()) && this.f12074e.equals(sendRequest.b())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public TransportContext f() {
        return this.f12070a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public String g() {
        return this.f12071b;
    }

    public int hashCode() {
        return ((((((((this.f12070a.hashCode() ^ 1000003) * 1000003) ^ this.f12071b.hashCode()) * 1000003) ^ this.f12072c.hashCode()) * 1000003) ^ this.f12073d.hashCode()) * 1000003) ^ this.f12074e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f12070a + ", transportName=" + this.f12071b + ", event=" + this.f12072c + ", transformer=" + this.f12073d + ", encoding=" + this.f12074e + "}";
    }

    private AutoValue_SendRequest(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, Encoding encoding) {
        this.f12070a = transportContext;
        this.f12071b = str;
        this.f12072c = event;
        this.f12073d = transformer;
        this.f12074e = encoding;
    }
}
