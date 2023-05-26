package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_TransportContext extends TransportContext {

    /* renamed from: a  reason: collision with root package name */
    private final String f12080a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f12081b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f12082c;

    /* loaded from: classes.dex */
    static final class Builder extends TransportContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f12083a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f12084b;

        /* renamed from: c  reason: collision with root package name */
        private Priority f12085c;

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext a() {
            String str = "";
            if (this.f12083a == null) {
                str = " backendName";
            }
            if (this.f12085c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.f12083a, this.f12084b, this.f12085c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder b(String str) {
            if (str != null) {
                this.f12083a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder c(byte[] bArr) {
            this.f12084b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder d(Priority priority) {
            if (priority != null) {
                this.f12085c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public String b() {
        return this.f12080a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public byte[] c() {
        return this.f12081b;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public Priority d() {
        return this.f12082c;
    }

    public boolean equals(Object obj) {
        byte[] c8;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f12080a.equals(transportContext.b())) {
            byte[] bArr = this.f12081b;
            if (transportContext instanceof AutoValue_TransportContext) {
                c8 = ((AutoValue_TransportContext) transportContext).f12081b;
            } else {
                c8 = transportContext.c();
            }
            if (Arrays.equals(bArr, c8) && this.f12082c.equals(transportContext.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f12080a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12081b)) * 1000003) ^ this.f12082c.hashCode();
    }

    private AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.f12080a = str;
        this.f12081b = bArr;
        this.f12082c = priority;
    }
}
