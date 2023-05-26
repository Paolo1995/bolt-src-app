package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead, DeterministicAead> {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f14865a = Logger.getLogger(DeterministicAeadWrapper.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WrappedDeterministicAead implements DeterministicAead {

        /* renamed from: a  reason: collision with root package name */
        private PrimitiveSet<DeterministicAead> f14866a;

        public WrappedDeterministicAead(PrimitiveSet<DeterministicAead> primitiveSet) {
            this.f14866a = primitiveSet;
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return Bytes.a(this.f14866a.b().a(), this.f14866a.b().c().a(bArr, bArr2));
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry<DeterministicAead> entry : this.f14866a.c(copyOfRange)) {
                    try {
                        return entry.c().b(copyOfRange2, bArr2);
                    } catch (GeneralSecurityException e8) {
                        Logger logger = DeterministicAeadWrapper.f14865a;
                        logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e8.toString());
                    }
                }
            }
            for (PrimitiveSet.Entry<DeterministicAead> entry2 : this.f14866a.e()) {
                try {
                    return entry2.c().b(bArr, bArr2);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    DeterministicAeadWrapper() {
    }

    public static void e() throws GeneralSecurityException {
        Registry.r(new DeterministicAeadWrapper());
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<DeterministicAead> b() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<DeterministicAead> c() {
        return DeterministicAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    /* renamed from: f */
    public DeterministicAead a(PrimitiveSet<DeterministicAead> primitiveSet) {
        return new WrappedDeterministicAead(primitiveSet);
    }
}
