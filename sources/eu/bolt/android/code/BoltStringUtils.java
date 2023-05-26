package eu.bolt.android.code;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes5.dex */
public class BoltStringUtils {
    private static final int MY_FLAG;
    public static boolean RANDOM_BOOLEAN = false;
    public static String RANDOM_CHARS = null;
    public static String RANDOM_STRING = null;
    private static final String TYPE_MD5 = "MD5";

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            MY_FLAG = 134217857;
        } else {
            MY_FLAG = 193;
        }
        RANDOM_STRING = "";
        RANDOM_BOOLEAN = true;
        RANDOM_CHARS = "";
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b8 : bArr) {
            sb.append(cArr[(b8 & 240) >> 4]);
            sb.append(cArr[b8 & 15]);
        }
        return sb.toString();
    }

    public static String generateKebab() {
        return "dev_" + Native.bolt_native_o90() + Native.bolt_native_Cub() + Native.bolt_native_EOtV();
    }

    public static String generateShishas() {
        return "prod_" + Native.bolt_native_fMV() + Native.bolt_native_MVIt() + Native.bolt_native_Lwfn();
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String[] getRandomStrings(Context context) {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        ArrayList<Signature> arrayList = new ArrayList();
        MessageDigest messageDigest = null;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                packageInfo = packageManager.getPackageInfo(context.getPackageName(), MY_FLAG);
            } catch (Exception unused) {
                packageInfo = null;
            }
            if (packageInfo != null) {
                RANDOM_BOOLEAN = packageInfo.signingInfo.hasMultipleSigners();
                arrayList.addAll(Arrays.asList(packageInfo.signingInfo.getApkContentsSigners()));
                arrayList.addAll(Arrays.asList(packageInfo.signingInfo.getSigningCertificateHistory()));
            }
        } else {
            try {
                RANDOM_BOOLEAN = false;
                arrayList.addAll(Arrays.asList(packageManager.getPackageInfo(context.getPackageName(), MY_FLAG).signatures));
            } catch (Exception unused2) {
            }
        }
        try {
            messageDigest = MessageDigest.getInstance(TYPE_MD5);
        } catch (NoSuchAlgorithmException e8) {
            e8.printStackTrace();
        }
        HashSet hashSet = new HashSet();
        if (messageDigest != null) {
            for (Signature signature : arrayList) {
                hashSet.add(byteArrayToHex(messageDigest.digest(signature.toByteArray())));
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    public static String helloSultans() {
        return Native.bolt_native_KF3() + Native.bolt_native_vB4() + Native.bolt_native_AvQR();
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i8 = 0; i8 < length; i8 += 2) {
            bArr[i8 / 2] = (byte) ((Character.digit(str.charAt(i8), 16) << 4) + Character.digit(str.charAt(i8 + 1), 16));
        }
        return bArr;
    }

    public static String houstonWeHaveAProblem() {
        return Native.bolt_native_r2kU() + Native.bolt_native_EOtV() + Native.bolt_native_RP8l();
    }

    public static String iSeeDeadPeople() {
        return Native.bolt_native_HRu() + Native.bolt_native_Kz7() + Native.bolt_native_RP8l();
    }

    public static String mayTheForceBeWithYou() {
        return Native.bolt_native_GzYm() + Native.bolt_native_EOtV() + Native.bolt_native_xvM();
    }

    public static String ohMyGod() {
        return Native.bolt_native_qfrv() + Native.bolt_native_AvQR() + Native.bolt_native_alF();
    }

    public static String sayHelloToMyLittleFriend() {
        return Native.bolt_native_fMV() + Native.bolt_native_uflU() + Native.bolt_native_VqD4();
    }
}
