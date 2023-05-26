package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class HmacKeyManager extends KeyTypeManager<HmacKey> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.crypto.tink.mac.HmacKeyManager$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14892a;

        static {
            int[] iArr = new int[HashType.values().length];
            f14892a = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14892a[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14892a[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HmacKeyManager() {
        super(HmacKey.class, new KeyTypeManager.PrimitiveFactory<Mac, HmacKey>(Mac.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            /* renamed from: c */
            public Mac a(HmacKey hmacKey) throws GeneralSecurityException {
                HashType G = hmacKey.L().G();
                SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey.K().y(), "HMAC");
                int H = hmacKey.L().H();
                int i8 = AnonymousClass3.f14892a[G.ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 == 3) {
                            return new PrfMac(new PrfHmacJce("HMACSHA512", secretKeySpec), H);
                        }
                        throw new GeneralSecurityException("unknown hash");
                    }
                    return new PrfMac(new PrfHmacJce("HMACSHA256", secretKeySpec), H);
                }
                return new PrfMac(new PrfHmacJce("HMACSHA1", secretKeySpec), H);
            }
        });
    }

    public static void m(boolean z7) throws GeneralSecurityException {
        Registry.q(new HmacKeyManager(), z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(HmacParams hmacParams) throws GeneralSecurityException {
        if (hmacParams.H() >= 10) {
            int i8 = AnonymousClass3.f14892a[hmacParams.G().ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        if (hmacParams.H() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                        return;
                    }
                    throw new GeneralSecurityException("unknown hash type");
                } else if (hmacParams.H() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                } else {
                    return;
                }
            } else if (hmacParams.H() <= 20) {
                return;
            } else {
                throw new GeneralSecurityException("tag size too big");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, HmacKey> e() {
        return new KeyTypeManager.KeyFactory<HmacKeyFormat, HmacKey>(HmacKeyFormat.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: e */
            public HmacKey a(HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
                return HmacKey.N().s(HmacKeyManager.this.k()).r(hmacKeyFormat.H()).q(ByteString.i(Random.c(hmacKeyFormat.G()))).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: f */
            public HmacKeyFormat c(ByteString byteString) throws InvalidProtocolBufferException {
                return HmacKeyFormat.J(byteString, ExtensionRegistryLite.b());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            /* renamed from: g */
            public void d(HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
                if (hmacKeyFormat.G() >= 16) {
                    HmacKeyManager.o(hmacKeyFormat.H());
                    return;
                }
                throw new GeneralSecurityException("key too short");
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
    public HmacKey g(ByteString byteString) throws InvalidProtocolBufferException {
        return HmacKey.O(byteString, ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    /* renamed from: n */
    public void i(HmacKey hmacKey) throws GeneralSecurityException {
        Validators.c(hmacKey.M(), k());
        if (hmacKey.K().size() >= 16) {
            o(hmacKey.L());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
