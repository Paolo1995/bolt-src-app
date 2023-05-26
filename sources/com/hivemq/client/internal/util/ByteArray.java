package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public class ByteArray {

    /* renamed from: a  reason: collision with root package name */
    protected final byte[] f18667a;

    public ByteArray(byte[] bArr) {
        this.f18667a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a() {
        return this.f18667a.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return 0;
    }

    public int c() {
        return a() - b();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ByteArray)) {
            return false;
        }
        ByteArray byteArray = (ByteArray) obj;
        return ByteArrayUtil.a(this.f18667a, b(), a(), byteArray.f18667a, byteArray.b(), byteArray.a());
    }

    public final int hashCode() {
        return ByteArrayUtil.b(this.f18667a, b(), a());
    }
}
