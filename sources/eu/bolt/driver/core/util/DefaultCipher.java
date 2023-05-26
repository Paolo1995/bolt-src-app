package eu.bolt.driver.core.util;

import android.util.Base64;
import eu.bolt.kalev.Kalev;
import j$.util.Spliterator;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DefaultCipher.kt */
/* loaded from: classes5.dex */
public final class DefaultCipher implements CipherWrapper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41304b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f41305a;

    /* compiled from: DefaultCipher.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DefaultCipher() {
        this(null, 1, null);
    }

    public DefaultCipher(String encryptionKey) {
        Intrinsics.f(encryptionKey, "encryptionKey");
        this.f41305a = encryptionKey;
    }

    private final SecretKeySpec c(byte[] bArr) {
        char[] charArray = this.f41305a.toCharArray();
        Intrinsics.e(charArray, "this as java.lang.String).toCharArray()");
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(charArray, bArr, 1000, Spliterator.NONNULL)).getEncoded(), "AES");
    }

    @Override // eu.bolt.driver.core.util.CipherWrapper
    public String a(String input) {
        Intrinsics.f(input, "input");
        try {
            byte[] bytes = input.getBytes(Charsets.f51135b);
            Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr = new byte[Spliterator.NONNULL];
            secureRandom.nextBytes(bArr);
            byte[] bArr2 = new byte[16];
            new SecureRandom().nextBytes(bArr2);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec c8 = c(bArr);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, c8, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(bytes);
            String encodeToString = Base64.encodeToString(bArr, 2);
            String encodeToString2 = Base64.encodeToString(bArr2, 2);
            String encodeToString3 = Base64.encodeToString(doFinal, 2);
            return encodeToString + "!@)(*&^%$" + encodeToString2 + "!@)(*&^%$" + encodeToString3;
        } catch (IllegalAccessException e8) {
            Kalev.d("Cipher encrypt method: No access right");
            throw new RuntimeException(e8);
        } catch (InvalidAlgorithmParameterException e9) {
            Kalev.d("Cipher encrypt method: Algorithm parameter is not correct, it could be key spec or initialization vector");
            throw new RuntimeException(e9);
        } catch (InvalidKeyException e10) {
            Kalev.d("Cipher encrypt method: Key for encryption is not correct");
            throw new RuntimeException(e10);
        } catch (NoSuchAlgorithmException e11) {
            Kalev.d("Cipher encrypt method: Algorithm not found");
            throw new RuntimeException(e11);
        } catch (InvalidKeySpecException e12) {
            Kalev.d("Cipher encrypt method: Key Spec for encryption is not correct");
            throw new RuntimeException(e12);
        } catch (BadPaddingException e13) {
            Kalev.d("Cipher encrypt method: Cipher transformation padding exception");
            throw new RuntimeException(e13);
        } catch (IllegalBlockSizeException e14) {
            Kalev.d("Cipher encrypt method: block size for that algorithm is not correct");
            throw new RuntimeException(e14);
        } catch (NoSuchPaddingException e15) {
            Kalev.d("Cipher encrypt method: Padding for that algorithm is not correct");
            throw new RuntimeException(e15);
        }
    }

    @Override // eu.bolt.driver.core.util.CipherWrapper
    public String b(String encryptedInput) {
        List C0;
        Intrinsics.f(encryptedInput, "encryptedInput");
        try {
            C0 = StringsKt__StringsKt.C0(encryptedInput, new String[]{"!@)(*&^%$"}, false, 0, 6, null);
            byte[] salt = Base64.decode((String) C0.get(0), 2);
            byte[] decode = Base64.decode((String) C0.get(1), 2);
            byte[] decode2 = Base64.decode((String) C0.get(2), 2);
            Intrinsics.e(salt, "salt");
            SecretKeySpec c8 = c(salt);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(decode);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, c8, ivParameterSpec);
            byte[] decryptedValue = cipher.doFinal(decode2);
            Intrinsics.e(decryptedValue, "decryptedValue");
            return new String(decryptedValue, Charsets.f51135b);
        } catch (IllegalArgumentException | IndexOutOfBoundsException unused) {
            return encryptedInput;
        } catch (InvalidAlgorithmParameterException e8) {
            Kalev.d("Cipher decrypt method: Algorithm parameter is not correct, it could be key spec or initialization vector");
            throw new RuntimeException(e8);
        } catch (InvalidKeyException e9) {
            Kalev.d("Cipher decrypt method: Key for decryption is not correct");
            throw new RuntimeException(e9);
        } catch (NoSuchAlgorithmException e10) {
            Kalev.d("Cipher decrypt method: Algorithm not found");
            throw new RuntimeException(e10);
        } catch (InvalidKeySpecException e11) {
            Kalev.d("Cipher decrypt method: Key Spec for decryption is not correct");
            throw new RuntimeException(e11);
        } catch (BadPaddingException e12) {
            Kalev.d("Cipher decrypt method: Cipher transformation padding exception");
            throw new RuntimeException(e12);
        } catch (IllegalBlockSizeException e13) {
            Kalev.d("Cipher decrypt method: Encryption and decryption block size is different");
            throw new RuntimeException(e13);
        } catch (NoSuchPaddingException e14) {
            Kalev.d("Cipher decrypt method: Encryption and decryption padding is not the same");
            throw new RuntimeException(e14);
        }
    }

    public /* synthetic */ DefaultCipher(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "BoltPrefEncryptionKey" : str);
    }
}
