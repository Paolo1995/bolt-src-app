package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.subtle.AesGcmSiv;
import com.google.crypto.tink.proto.AesGcmSivKey;
import com.google.crypto.tink.proto.AesGcmSivKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public final class AesGcmSivKeyManager extends KeyTypeManager<AesGcmSivKey> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AesGcmSivKeyManager() {
        super(AesGcmSivKey.class, new KeyTypeManager.PrimitiveFactory<Aead, AesGcmSivKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public Aead a(AesGcmSivKey aesGcmSivKey) throws GeneralSecurityException {
                return new AesGcmSiv(aesGcmSivKey.H().y());
            }
        });
    }

    private static boolean j() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void m(boolean z7) throws GeneralSecurityException {
        if (j()) {
            Registry.q(new AesGcmSivKeyManager(), z7);
        }
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesGcmSivKey> e() {
        return new KeyTypeManager.KeyFactory<AesGcmSivKeyFormat, AesGcmSivKey>(AesGcmSivKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public AesGcmSivKey a(AesGcmSivKeyFormat aesGcmSivKeyFormat) {
                return AesGcmSivKey.K().q(ByteString.i(Random.c(aesGcmSivKeyFormat.F()))).r(AesGcmSivKeyManager.this.k()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public AesGcmSivKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return AesGcmSivKeyFormat.G(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(AesGcmSivKeyFormat aesGcmSivKeyFormat) throws GeneralSecurityException {
                Validators.a(aesGcmSivKeyFormat.F());
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
    public AesGcmSivKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return AesGcmSivKey.L(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: n */
    public void i(AesGcmSivKey aesGcmSivKey) throws GeneralSecurityException {
        Validators.c(aesGcmSivKey.J(), k());
        Validators.a(aesGcmSivKey.H().size());
    }
}
