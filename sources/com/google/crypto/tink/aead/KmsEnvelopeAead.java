package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyTemplate;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class KmsEnvelopeAead implements Aead {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f14854c = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final KeyTemplate f14855a;

    /* renamed from: b  reason: collision with root package name */
    private final Aead f14856b;

    public KmsEnvelopeAead(KeyTemplate keyTemplate, Aead aead) {
        this.f14855a = keyTemplate;
        this.f14856b = aead;
    }

    private byte[] c(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] a8 = Registry.o(this.f14855a).a();
        return c(this.f14856b.a(a8, f14854c), ((Aead) Registry.i(this.f14855a.L(), a8, Aead.class)).a(bArr, bArr2));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i8 = wrap.getInt();
            if (i8 > 0 && i8 <= bArr.length - 4) {
                byte[] bArr3 = new byte[i8];
                wrap.get(bArr3, 0, i8);
                byte[] bArr4 = new byte[wrap.remaining()];
                wrap.get(bArr4, 0, wrap.remaining());
                return ((Aead) Registry.i(this.f14855a.L(), this.f14856b.b(bArr3, f14854c), Aead.class)).b(bArr4, bArr2);
            }
            throw new GeneralSecurityException("invalid ciphertext");
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e8) {
            throw new GeneralSecurityException("invalid ciphertext", e8);
        }
    }
}
