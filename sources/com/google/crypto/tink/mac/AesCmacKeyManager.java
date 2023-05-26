package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCmacKey;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class AesCmacKeyManager extends KeyTypeManager<AesCmacKey> {
    AesCmacKeyManager() {
        super(AesCmacKey.class, new KeyTypeManager.PrimitiveFactory<Mac, AesCmacKey>(Mac.class) { // from class: com.google.crypto.tink.mac.AesCmacKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public Mac a(AesCmacKey aesCmacKey) throws GeneralSecurityException {
                return new PrfMac(new PrfAesCmac(aesCmacKey.J().y()), aesCmacKey.K().G());
            }
        });
    }

    public static void n(boolean z7) throws GeneralSecurityException {
        Registry.q(new AesCmacKeyManager(), z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(AesCmacParams aesCmacParams) throws GeneralSecurityException {
        if (aesCmacParams.G() >= 10) {
            if (aesCmacParams.G() <= 16) {
                return;
            }
            throw new GeneralSecurityException("tag size too long");
        }
        throw new GeneralSecurityException("tag size too short");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(int i8) throws GeneralSecurityException {
        if (i8 == 32) {
            return;
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesCmacKey> e() {
        return new KeyTypeManager.KeyFactory<AesCmacKeyFormat, AesCmacKey>(AesCmacKeyFormat.class) { // from class: com.google.crypto.tink.mac.AesCmacKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public AesCmacKey a(AesCmacKeyFormat aesCmacKeyFormat) throws GeneralSecurityException {
                return AesCmacKey.M().s(0).q(ByteString.i(Random.c(aesCmacKeyFormat.F()))).r(aesCmacKeyFormat.G()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public AesCmacKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCmacKeyFormat.H(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(AesCmacKeyFormat aesCmacKeyFormat) throws GeneralSecurityException {
                AesCmacKeyManager.p(aesCmacKeyFormat.G());
                AesCmacKeyManager.q(aesCmacKeyFormat.F());
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int l() {
        return 0;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: m */
    public AesCmacKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCmacKey.N(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: o */
    public void i(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        Validators.c(aesCmacKey.L(), l());
        q(aesCmacKey.J().size());
        p(aesCmacKey.K());
    }
}
