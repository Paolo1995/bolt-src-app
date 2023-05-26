package eu.bolt.verification.sdk.internal;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class o {

    /* renamed from: b  reason: collision with root package name */
    public static final a f44367b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f44368a;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public o(byte[] initialVector) {
        Intrinsics.f(initialVector, "initialVector");
        this.f44368a = initialVector;
    }

    private final Cipher a(int i8, byte[] bArr) {
        b(bArr, this.f44368a);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f44368a);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        Intrinsics.e(cipher, "getInstance(AES_CBC_PKCS5_PADDING)");
        cipher.init(i8, secretKeySpec, ivParameterSpec);
        return cipher;
    }

    private final void b(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 16 || bArr2.length != 16) {
            throw new h6("Secret and initial vector must be 16 bytes");
        }
    }

    private final byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            byte[] doFinal = a(2, bArr2).doFinal(bArr);
            Intrinsics.e(doFinal, "{\n            val decryp….doFinal(bytes)\n        }");
            return doFinal;
        } catch (Exception e8) {
            throw new h6(e8);
        }
    }

    private final byte[] f(byte[] bArr, byte[] bArr2) {
        try {
            byte[] doFinal = a(1, bArr2).doFinal(bArr);
            Intrinsics.e(doFinal, "{\n            val encryp….doFinal(bytes)\n        }");
            return doFinal;
        } catch (Exception e8) {
            throw new h6(e8);
        }
    }

    public final byte[] c(byte[] bytes, byte[] secretKeyBytes) {
        Intrinsics.f(bytes, "bytes");
        Intrinsics.f(secretKeyBytes, "secretKeyBytes");
        return d(bytes, secretKeyBytes);
    }

    public final byte[] e(byte[] bytes, byte[] secretKeyBytes) {
        Intrinsics.f(bytes, "bytes");
        Intrinsics.f(secretKeyBytes, "secretKeyBytes");
        return f(bytes, secretKeyBytes);
    }
}
