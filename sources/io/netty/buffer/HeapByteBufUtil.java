package io.netty.buffer;

/* loaded from: classes5.dex */
final class HeapByteBufUtil {
    private HeapByteBufUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, int i8) {
        return bArr[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i8) {
        return (bArr[i8 + 3] & 255) | ((bArr[i8] & 255) << 24) | ((bArr[i8 + 1] & 255) << 16) | ((bArr[i8 + 2] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(byte[] bArr, int i8) {
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i8) {
        return (bArr[i8 + 7] & 255) | ((bArr[i8] & 255) << 56) | ((bArr[i8 + 1] & 255) << 48) | ((bArr[i8 + 2] & 255) << 40) | ((bArr[i8 + 3] & 255) << 32) | ((bArr[i8 + 4] & 255) << 24) | ((bArr[i8 + 5] & 255) << 16) | ((bArr[i8 + 6] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i8) {
        return (short) ((bArr[i8 + 1] & 255) | (bArr[i8] << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(byte[] bArr, int i8) {
        return (short) ((bArr[i8 + 1] << 8) | (bArr[i8] & 255));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(byte[] bArr, int i8) {
        return (bArr[i8 + 2] & 255) | ((bArr[i8] & 255) << 16) | ((bArr[i8 + 1] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) (i9 >>> 24);
        bArr[i8 + 1] = (byte) (i9 >>> 16);
        bArr[i8 + 2] = (byte) (i9 >>> 8);
        bArr[i8 + 3] = (byte) i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(byte[] bArr, int i8, long j8) {
        bArr[i8] = (byte) (j8 >>> 56);
        bArr[i8 + 1] = (byte) (j8 >>> 48);
        bArr[i8 + 2] = (byte) (j8 >>> 40);
        bArr[i8 + 3] = (byte) (j8 >>> 32);
        bArr[i8 + 4] = (byte) (j8 >>> 24);
        bArr[i8 + 5] = (byte) (j8 >>> 16);
        bArr[i8 + 6] = (byte) (j8 >>> 8);
        bArr[i8 + 7] = (byte) j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) (i9 >>> 16);
        bArr[i8 + 1] = (byte) (i9 >>> 8);
        bArr[i8 + 2] = (byte) i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) i9;
        bArr[i8 + 1] = (byte) (i9 >>> 8);
        bArr[i8 + 2] = (byte) (i9 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) (i9 >>> 8);
        bArr[i8 + 1] = (byte) i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) i9;
        bArr[i8 + 1] = (byte) (i9 >>> 8);
    }
}
