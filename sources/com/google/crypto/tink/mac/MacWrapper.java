package com.google.crypto.tink.mac;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MacWrapper implements PrimitiveWrapper<Mac, Mac> {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f14897a = Logger.getLogger(MacWrapper.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WrappedMac implements Mac {

        /* renamed from: a  reason: collision with root package name */
        private final PrimitiveSet<Mac> f14898a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f14899b;

        @Override // com.google.crypto.tink.Mac
        public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry<Mac> entry : this.f14898a.c(copyOf)) {
                    try {
                        if (entry.b().equals(OutputPrefixType.LEGACY)) {
                            entry.c().a(copyOfRange, Bytes.a(bArr2, this.f14899b));
                            return;
                        } else {
                            entry.c().a(copyOfRange, bArr2);
                            return;
                        }
                    } catch (GeneralSecurityException e8) {
                        Logger logger = MacWrapper.f14897a;
                        logger.info("tag prefix matches a key, but cannot verify: " + e8);
                    }
                }
                for (PrimitiveSet.Entry<Mac> entry2 : this.f14898a.e()) {
                    try {
                        entry2.c().a(bArr, bArr2);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                throw new GeneralSecurityException("invalid MAC");
            }
            throw new GeneralSecurityException("tag too short");
        }

        @Override // com.google.crypto.tink.Mac
        public byte[] b(byte[] bArr) throws GeneralSecurityException {
            if (this.f14898a.b().b().equals(OutputPrefixType.LEGACY)) {
                return Bytes.a(this.f14898a.b().a(), this.f14898a.b().c().b(Bytes.a(bArr, this.f14899b)));
            }
            return Bytes.a(this.f14898a.b().a(), this.f14898a.b().c().b(bArr));
        }

        private WrappedMac(PrimitiveSet<Mac> primitiveSet) {
            this.f14899b = new byte[]{0};
            this.f14898a = primitiveSet;
        }
    }

    MacWrapper() {
    }

    public static void e() throws GeneralSecurityException {
        Registry.r(new MacWrapper());
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Mac> b() {
        return Mac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Mac> c() {
        return Mac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    /* renamed from: f */
    public Mac a(PrimitiveSet<Mac> primitiveSet) throws GeneralSecurityException {
        return new WrappedMac(primitiveSet);
    }
}
