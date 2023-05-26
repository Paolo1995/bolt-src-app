package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class AesGcmKeyManager extends KeyTypeManager<AesGcmKey> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AesGcmKeyManager() {
        super(AesGcmKey.class, new KeyTypeManager.PrimitiveFactory<Aead, AesGcmKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesGcmKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public Aead a(AesGcmKey aesGcmKey) throws GeneralSecurityException {
                return new AesGcmJce(aesGcmKey.H().y());
            }
        });
    }

    public static final KeyTemplate j() {
        return k(32, KeyTemplate.OutputPrefixType.TINK);
    }

    private static KeyTemplate k(int i8, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.a(new AesGcmKeyManager().c(), AesGcmKeyFormat.H().q(i8).build().a(), outputPrefixType);
    }

    public static void n(boolean z7) throws GeneralSecurityException {
        Registry.q(new AesGcmKeyManager(), z7);
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesGcmKey> e() {
        return new KeyTypeManager.KeyFactory<AesGcmKeyFormat, AesGcmKey>(AesGcmKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesGcmKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public AesGcmKey a(AesGcmKeyFormat aesGcmKeyFormat) throws GeneralSecurityException {
                return AesGcmKey.K().q(ByteString.i(Random.c(aesGcmKeyFormat.G()))).r(AesGcmKeyManager.this.l()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public AesGcmKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return AesGcmKeyFormat.J(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(AesGcmKeyFormat aesGcmKeyFormat) throws GeneralSecurityException {
                Validators.a(aesGcmKeyFormat.G());
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
    public AesGcmKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return AesGcmKey.L(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: o */
    public void i(AesGcmKey aesGcmKey) throws GeneralSecurityException {
        Validators.c(aesGcmKey.J(), l());
        Validators.a(aesGcmKey.H().size());
    }
}
