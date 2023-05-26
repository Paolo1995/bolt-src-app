package eu.bolt.android.audio_recording_engine.engine;

import android.os.Build;
import com.yalantis.ucrop.view.CropImageView;
import j$.util.Spliterator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: EncryptionHandler.kt */
/* loaded from: classes5.dex */
public final class EncryptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final EncryptionHandler f36667a = new EncryptionHandler();

    private EncryptionHandler() {
    }

    private final SecretKey c(String str) {
        SecretKeyFactory secretKeyFactory;
        if (Build.VERSION.SDK_INT >= 26) {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } else {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        }
        char[] charArray = str.toCharArray();
        Intrinsics.e(charArray, "this as java.lang.String).toCharArray()");
        byte[] bytes = "72ff7e5e-ef19-4915-ae1f-4ca7908cc55a".getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKey generateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(charArray, bytes, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, Spliterator.NONNULL));
        Intrinsics.e(generateSecret, "secretKeyFactory.generateSecret(pbeKeySpec)");
        return generateSecret;
    }

    private final void d(byte[] bArr, File file) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public final File a(String cryptoKey, File file, String filePathParent) {
        byte[] a8;
        String k8;
        Intrinsics.f(cryptoKey, "cryptoKey");
        Intrinsics.f(file, "file");
        Intrinsics.f(filePathParent, "filePathParent");
        SecretKey c8 = c(cryptoKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(2, c8, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        a8 = FilesKt__FileReadWriteKt.a(file);
        byte[] decryptedFileData = cipher.doFinal(a8);
        StringBuilder sb = new StringBuilder();
        sb.append(filePathParent);
        k8 = FilesKt__UtilsKt.k(file);
        sb.append(k8);
        sb.append(".m4a");
        String sb2 = sb.toString();
        Intrinsics.e(decryptedFileData, "decryptedFileData");
        d(decryptedFileData, new File(sb2));
        return new File(sb2);
    }

    public final void b(String cryptoKey, List<? extends File> list) {
        byte[] a8;
        Intrinsics.f(cryptoKey, "cryptoKey");
        byte[] encoded = c(cryptoKey).getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, 0, encoded.length, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        if (list != null) {
            for (File file : list) {
                a8 = FilesKt__FileReadWriteKt.a(file);
                byte[] encryptedFile = cipher.doFinal(a8);
                EncryptionHandler encryptionHandler = f36667a;
                Intrinsics.e(encryptedFile, "encryptedFile");
                encryptionHandler.d(encryptedFile, file);
            }
        }
    }
}
