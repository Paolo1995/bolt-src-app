package com.sinch.android.rtc.internal.client;

import java.security.MessageDigest;

/* loaded from: classes3.dex */
class Sha1Utils {
    public static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i8 = 0; i8 < bArr.length; i8++) {
            int i9 = bArr[i8] & 255;
            int i10 = i8 * 2;
            char[] cArr2 = hexArray;
            cArr[i10] = cArr2[i9 >>> 4];
            cArr[i10 + 1] = cArr2[i9 & 15];
        }
        return new String(cArr);
    }

    public static byte[] sha1(String str) {
        if (str == null) {
            return null;
        }
        try {
            return MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String sha1RawBytesAsString(String str) {
        return new String(sha1(str));
    }
}
