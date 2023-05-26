package com.google.crypto.tink.subtle;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.Aead;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

/* loaded from: classes.dex */
abstract class ChaCha20Poly1305Base implements Aead {

    /* renamed from: a  reason: collision with root package name */
    private final ChaCha20Base f15343a;

    /* renamed from: b  reason: collision with root package name */
    private final ChaCha20Base f15344b;

    public ChaCha20Poly1305Base(byte[] bArr) throws InvalidKeyException {
        this.f15343a = g(bArr, 1);
        this.f15344b = g(bArr, 0);
    }

    private byte[] c(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= this.f15343a.g() + 16) {
            int position = byteBuffer.position();
            byte[] bArr2 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr2);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            byte[] bArr3 = new byte[this.f15343a.g()];
            byteBuffer.get(bArr3);
            if (bArr == null) {
                bArr = new byte[0];
            }
            try {
                Poly1305.f(e(bArr3), f(bArr, byteBuffer), bArr2);
                byteBuffer.position(position);
                return this.f15343a.e(byteBuffer);
            } catch (GeneralSecurityException e8) {
                throw new AEADBadTagException(e8.toString());
            }
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    private void d(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr.length + this.f15343a.g() + 16) {
            int position = byteBuffer.position();
            this.f15343a.f(byteBuffer, bArr);
            byteBuffer.position(position);
            byte[] bArr3 = new byte[this.f15343a.g()];
            byteBuffer.get(bArr3);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] a8 = Poly1305.a(e(bArr3), f(bArr2, byteBuffer));
            byteBuffer.limit(byteBuffer.limit() + 16);
            byteBuffer.put(a8);
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    private byte[] e(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = new byte[32];
        this.f15344b.c(bArr, 0).get(bArr2);
        return bArr2;
    }

    private static byte[] f(byte[] bArr, ByteBuffer byteBuffer) {
        int length;
        int i8;
        if (bArr.length % 16 == 0) {
            length = bArr.length;
        } else {
            length = (bArr.length + 16) - (bArr.length % 16);
        }
        int remaining = byteBuffer.remaining();
        int i9 = remaining % 16;
        if (i9 == 0) {
            i8 = remaining;
        } else {
            i8 = (remaining + 16) - i9;
        }
        int i10 = i8 + length;
        ByteBuffer order = ByteBuffer.allocate(i10 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i10);
        order.putLong(bArr.length);
        order.putLong(remaining);
        return order.array();
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.f15343a.g()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.f15343a.g() + 16);
            d(allocate, bArr, bArr2);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return c(ByteBuffer.wrap(bArr), bArr2);
    }

    abstract ChaCha20Base g(byte[] bArr, int i8) throws InvalidKeyException;
}
