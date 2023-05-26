package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Mac;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EncryptThenAuthenticate implements Aead {

    /* renamed from: a  reason: collision with root package name */
    private final IndCpaCipher f15345a;

    /* renamed from: b  reason: collision with root package name */
    private final Mac f15346b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15347c;

    public EncryptThenAuthenticate(IndCpaCipher indCpaCipher, Mac mac, int i8) {
        this.f15345a = indCpaCipher;
        this.f15346b = mac;
        this.f15347c = i8;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] a8 = this.f15345a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return Bytes.a(a8, this.f15346b.b(Bytes.a(bArr2, a8, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i8 = this.f15347c;
        if (length >= i8) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i8);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.f15347c, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            this.f15346b.a(copyOfRange2, Bytes.a(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
            return this.f15345a.b(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
