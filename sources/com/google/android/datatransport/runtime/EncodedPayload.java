package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EncodedPayload {

    /* renamed from: a  reason: collision with root package name */
    private final Encoding f12100a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f12101b;

    public EncodedPayload(@NonNull Encoding encoding, @NonNull byte[] bArr) {
        if (encoding != null) {
            if (bArr != null) {
                this.f12100a = encoding;
                this.f12101b = bArr;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }

    public byte[] a() {
        return this.f12101b;
    }

    public Encoding b() {
        return this.f12100a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.f12100a.equals(encodedPayload.f12100a)) {
            return false;
        }
        return Arrays.equals(this.f12101b, encodedPayload.f12101b);
    }

    public int hashCode() {
        return ((this.f12100a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12101b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f12100a + ", bytes=[...]}";
    }
}
