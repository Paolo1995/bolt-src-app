package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_BackendRequest extends BackendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<EventInternal> f12124a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f12125b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends BackendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Iterable<EventInternal> f12126a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f12127b;

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest a() {
            String str = "";
            if (this.f12126a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new AutoValue_BackendRequest(this.f12126a, this.f12127b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder b(Iterable<EventInternal> iterable) {
            if (iterable != null) {
                this.f12126a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder c(byte[] bArr) {
            this.f12127b = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public Iterable<EventInternal> b() {
        return this.f12124a;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public byte[] c() {
        return this.f12125b;
    }

    public boolean equals(Object obj) {
        byte[] c8;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f12124a.equals(backendRequest.b())) {
            byte[] bArr = this.f12125b;
            if (backendRequest instanceof AutoValue_BackendRequest) {
                c8 = ((AutoValue_BackendRequest) backendRequest).f12125b;
            } else {
                c8 = backendRequest.c();
            }
            if (Arrays.equals(bArr, c8)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f12124a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12125b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f12124a + ", extras=" + Arrays.toString(this.f12125b) + "}";
    }

    private AutoValue_BackendRequest(Iterable<EventInternal> iterable, byte[] bArr) {
        this.f12124a = iterable;
        this.f12125b = bArr;
    }
}
