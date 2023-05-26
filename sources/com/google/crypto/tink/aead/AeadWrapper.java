package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class AeadWrapper implements PrimitiveWrapper<Aead, Aead> {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f14845a = Logger.getLogger(AeadWrapper.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WrappedAead implements Aead {

        /* renamed from: a  reason: collision with root package name */
        private final PrimitiveSet<Aead> f14846a;

        @Override // com.google.crypto.tink.Aead
        public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return Bytes.a(this.f14846a.b().a(), this.f14846a.b().c().a(bArr, bArr2));
        }

        @Override // com.google.crypto.tink.Aead
        public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry<Aead> entry : this.f14846a.c(copyOfRange)) {
                    try {
                        return entry.c().b(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e8) {
                        Logger logger = AeadWrapper.f14845a;
                        logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e8.toString());
                    }
                }
            }
            for (PrimitiveSet.Entry<Aead> entry2 : this.f14846a.e()) {
                try {
                    return entry2.c().b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }

        private WrappedAead(PrimitiveSet<Aead> primitiveSet) {
            this.f14846a = primitiveSet;
        }
    }

    AeadWrapper() {
    }

    public static void e() throws GeneralSecurityException {
        Registry.r(new AeadWrapper());
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Aead> b() {
        return Aead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Aead> c() {
        return Aead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    /* renamed from: f */
    public Aead a(PrimitiveSet<Aead> primitiveSet) throws GeneralSecurityException {
        return new WrappedAead(primitiveSet);
    }
}
