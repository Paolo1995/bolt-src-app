package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesSiv;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
public final class AesSivKeyManager extends KeyTypeManager<AesSivKey> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AesSivKeyManager() {
        super(AesSivKey.class, new KeyTypeManager.PrimitiveFactory<DeterministicAead, AesSivKey>(DeterministicAead.class) { // from class: com.google.crypto.tink.daead.AesSivKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public DeterministicAead a(AesSivKey aesSivKey) throws GeneralSecurityException {
                return new AesSiv(aesSivKey.H().y());
            }
        });
    }

    public static final KeyTemplate j() {
        return k(64, KeyTemplate.OutputPrefixType.TINK);
    }

    private static KeyTemplate k(int i8, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.a(new AesSivKeyManager().c(), AesSivKeyFormat.H().q(i8).build().a(), outputPrefixType);
    }

    public static void n(boolean z7) throws GeneralSecurityException {
        Registry.q(new AesSivKeyManager(), z7);
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesSivKey> e() {
        return new KeyTypeManager.KeyFactory<AesSivKeyFormat, AesSivKey>(AesSivKeyFormat.class) { // from class: com.google.crypto.tink.daead.AesSivKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public AesSivKey a(AesSivKeyFormat aesSivKeyFormat) throws GeneralSecurityException {
                return AesSivKey.K().q(ByteString.i(Random.c(aesSivKeyFormat.G()))).r(AesSivKeyManager.this.l()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public AesSivKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return AesSivKeyFormat.J(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(AesSivKeyFormat aesSivKeyFormat) throws GeneralSecurityException {
                if (aesSivKeyFormat.G() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + aesSivKeyFormat.G() + ". Valid keys must have 64 bytes.");
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
    public AesSivKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return AesSivKey.L(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: o */
    public void i(AesSivKey aesSivKey) throws GeneralSecurityException {
        Validators.c(aesSivKey.J(), l());
        if (aesSivKey.H().size() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + aesSivKey.H().size() + ". Valid keys must have 64 bytes.");
    }
}
