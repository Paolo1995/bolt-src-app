package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsAeadKey;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class KmsAeadKeyManager extends KeyTypeManager<KmsAeadKey> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KmsAeadKeyManager() {
        super(KmsAeadKey.class, new KeyTypeManager.PrimitiveFactory<Aead, KmsAeadKey>(Aead.class) { // from class: com.google.crypto.tink.aead.KmsAeadKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public Aead a(KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
                String G = kmsAeadKey.H().G();
                return KmsClients.a(G).b(G);
            }
        });
    }

    public static void l(boolean z7) throws GeneralSecurityException {
        Registry.q(new KmsAeadKeyManager(), z7);
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, KmsAeadKey> e() {
        return new KeyTypeManager.KeyFactory<KmsAeadKeyFormat, KmsAeadKey>(KmsAeadKeyFormat.class) { // from class: com.google.crypto.tink.aead.KmsAeadKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public KmsAeadKey a(KmsAeadKeyFormat kmsAeadKeyFormat) throws GeneralSecurityException {
                return KmsAeadKey.K().q(kmsAeadKeyFormat).r(KmsAeadKeyManager.this.j()).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public KmsAeadKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return KmsAeadKeyFormat.H(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(KmsAeadKeyFormat kmsAeadKeyFormat) throws GeneralSecurityException {
            }
        };
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    public int j() {
        return 0;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: k */
    public KmsAeadKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return KmsAeadKey.L(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: m */
    public void i(KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
        Validators.c(kmsAeadKey.J(), j());
    }
}
