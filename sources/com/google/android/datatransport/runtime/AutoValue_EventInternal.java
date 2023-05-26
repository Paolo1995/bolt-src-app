package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

/* loaded from: classes.dex */
final class AutoValue_EventInternal extends EventInternal {

    /* renamed from: a  reason: collision with root package name */
    private final String f12058a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f12059b;

    /* renamed from: c  reason: collision with root package name */
    private final EncodedPayload f12060c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12061d;

    /* renamed from: e  reason: collision with root package name */
    private final long f12062e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f12063f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends EventInternal.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f12064a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f12065b;

        /* renamed from: c  reason: collision with root package name */
        private EncodedPayload f12066c;

        /* renamed from: d  reason: collision with root package name */
        private Long f12067d;

        /* renamed from: e  reason: collision with root package name */
        private Long f12068e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f12069f;

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal d() {
            String str = "";
            if (this.f12064a == null) {
                str = " transportName";
            }
            if (this.f12066c == null) {
                str = str + " encodedPayload";
            }
            if (this.f12067d == null) {
                str = str + " eventMillis";
            }
            if (this.f12068e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f12069f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal(this.f12064a, this.f12065b, this.f12066c, this.f12067d.longValue(), this.f12068e.longValue(), this.f12069f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        protected Map<String, String> e() {
            Map<String, String> map = this.f12069f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder f(Map<String, String> map) {
            if (map != null) {
                this.f12069f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder g(Integer num) {
            this.f12065b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder h(EncodedPayload encodedPayload) {
            if (encodedPayload != null) {
                this.f12066c = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder i(long j8) {
            this.f12067d = Long.valueOf(j8);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder j(String str) {
            if (str != null) {
                this.f12064a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder k(long j8) {
            this.f12068e = Long.valueOf(j8);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.datatransport.runtime.EventInternal
    public Map<String, String> c() {
        return this.f12063f;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public Integer d() {
        return this.f12059b;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public EncodedPayload e() {
        return this.f12060c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (this.f12058a.equals(eventInternal.j()) && ((num = this.f12059b) != null ? num.equals(eventInternal.d()) : eventInternal.d() == null) && this.f12060c.equals(eventInternal.e()) && this.f12061d == eventInternal.f() && this.f12062e == eventInternal.k() && this.f12063f.equals(eventInternal.c())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long f() {
        return this.f12061d;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f12058a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f12059b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        long j8 = this.f12061d;
        long j9 = this.f12062e;
        return ((((((((hashCode2 ^ hashCode) * 1000003) ^ this.f12060c.hashCode()) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003) ^ this.f12063f.hashCode();
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public String j() {
        return this.f12058a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long k() {
        return this.f12062e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f12058a + ", code=" + this.f12059b + ", encodedPayload=" + this.f12060c + ", eventMillis=" + this.f12061d + ", uptimeMillis=" + this.f12062e + ", autoMetadata=" + this.f12063f + "}";
    }

    private AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j8, long j9, Map<String, String> map) {
        this.f12058a = str;
        this.f12059b = num;
        this.f12060c = encodedPayload;
        this.f12061d = j8;
        this.f12062e = j9;
        this.f12063f = map;
    }
}
