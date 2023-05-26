package com.google.crypto.tink.aead;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesCtrJceCipher;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class AesCtrKeyManager extends KeyTypeManager<AesCtrKey> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AesCtrKeyManager() {
        super(AesCtrKey.class, new KeyTypeManager.PrimitiveFactory<IndCpaCipher, AesCtrKey>(IndCpaCipher.class) { // from class: com.google.crypto.tink.aead.AesCtrKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public IndCpaCipher a(AesCtrKey aesCtrKey) throws GeneralSecurityException {
                return new AesCtrJceCipher(aesCtrKey.K().y(), aesCtrKey.L().G());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AesCtrParams aesCtrParams) throws GeneralSecurityException {
        if (aesCtrParams.G() >= 12 && aesCtrParams.G() <= 16) {
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesCtrKey> e() {
        return new KeyTypeManager.KeyFactory<AesCtrKeyFormat, AesCtrKey>(AesCtrKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesCtrKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public AesCtrKey a(AesCtrKeyFormat aesCtrKeyFormat) throws GeneralSecurityException {
                return AesCtrKey.N().r(aesCtrKeyFormat.H()).q(ByteString.i(Random.c(aesCtrKeyFormat.G()))).s(AesCtrKeyManager.this.k()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public AesCtrKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrKeyFormat.J(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(AesCtrKeyFormat aesCtrKeyFormat) throws GeneralSecurityException {
                Validators.a(aesCtrKeyFormat.G());
                AesCtrKeyManager.this.n(aesCtrKeyFormat.H());
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int k() {
        return 0;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: l */
    public AesCtrKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrKey.O(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: m */
    public void i(AesCtrKey aesCtrKey) throws GeneralSecurityException {
        Validators.c(aesCtrKey.M(), k());
        Validators.a(aesCtrKey.K().size());
        n(aesCtrKey.L());
    }
}
