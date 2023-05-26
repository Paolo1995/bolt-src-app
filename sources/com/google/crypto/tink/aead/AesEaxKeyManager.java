package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesEaxKey;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class AesEaxKeyManager extends KeyTypeManager<AesEaxKey> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AesEaxKeyManager() {
        super(AesEaxKey.class, new KeyTypeManager.PrimitiveFactory<Aead, AesEaxKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesEaxKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public Aead a(AesEaxKey aesEaxKey) throws GeneralSecurityException {
                return new AesEaxJce(aesEaxKey.J().y(), aesEaxKey.K().G());
            }
        });
    }

    public static void l(boolean z7) throws GeneralSecurityException {
        Registry.q(new AesEaxKeyManager(), z7);
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesEaxKey> e() {
        return new KeyTypeManager.KeyFactory<AesEaxKeyFormat, AesEaxKey>(AesEaxKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesEaxKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public AesEaxKey a(AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                return AesEaxKey.M().q(ByteString.i(Random.c(aesEaxKeyFormat.F()))).r(aesEaxKeyFormat.G()).s(AesEaxKeyManager.this.j()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public AesEaxKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return AesEaxKeyFormat.H(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                Validators.a(aesEaxKeyFormat.F());
                if (aesEaxKeyFormat.G().G() != 12 && aesEaxKeyFormat.G().G() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    public int j() {
        return 0;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: k */
    public AesEaxKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return AesEaxKey.N(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: m */
    public void i(AesEaxKey aesEaxKey) throws GeneralSecurityException {
        Validators.c(aesEaxKey.L(), j());
        Validators.a(aesEaxKey.J().size());
        if (aesEaxKey.K().G() != 12 && aesEaxKey.K().G() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
