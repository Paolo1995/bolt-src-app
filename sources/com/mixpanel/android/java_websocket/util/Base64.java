package com.mixpanel.android.java_websocket.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

@SuppressLint({"Assert"})
/* loaded from: classes3.dex */
public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f19049a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f19050b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f19051c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f19052d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f19053e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f19054f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private Base64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        int i11;
        int i12;
        if (bArr != null) {
            if (bArr2 != null) {
                if (i8 >= 0 && (i11 = i8 + 3) < bArr.length) {
                    if (i9 >= 0 && (i12 = i9 + 2) < bArr2.length) {
                        byte[] k8 = k(i10);
                        byte b8 = bArr[i8 + 2];
                        if (b8 == 61) {
                            bArr2[i9] = (byte) ((((k8[bArr[i8 + 1]] & 255) << 12) | ((k8[bArr[i8]] & 255) << 18)) >>> 16);
                            return 1;
                        }
                        byte b9 = bArr[i11];
                        if (b9 == 61) {
                            int i13 = ((k8[bArr[i8 + 1]] & 255) << 12) | ((k8[bArr[i8]] & 255) << 18) | ((k8[b8] & 255) << 6);
                            bArr2[i9] = (byte) (i13 >>> 16);
                            bArr2[i9 + 1] = (byte) (i13 >>> 8);
                            return 2;
                        }
                        int i14 = ((k8[bArr[i8 + 1]] & 255) << 12) | ((k8[bArr[i8]] & 255) << 18) | ((k8[b8] & 255) << 6) | (k8[b9] & 255);
                        bArr2[i9] = (byte) (i14 >> 16);
                        bArr2[i9 + 1] = (byte) (i14 >> 8);
                        bArr2[i12] = (byte) i14;
                        return 3;
                    }
                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i9)));
                }
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i8)));
            }
            throw new NullPointerException("Destination array was null.");
        }
        throw new NullPointerException("Source array was null.");
    }

    private static byte[] e(byte[] bArr, int i8, int i9, byte[] bArr2, int i10, int i11) {
        int i12;
        int i13;
        byte[] j8 = j(i11);
        int i14 = 0;
        if (i9 > 0) {
            i12 = (bArr[i8] << 24) >>> 8;
        } else {
            i12 = 0;
        }
        if (i9 > 1) {
            i13 = (bArr[i8 + 1] << 24) >>> 16;
        } else {
            i13 = 0;
        }
        int i15 = i12 | i13;
        if (i9 > 2) {
            i14 = (bArr[i8 + 2] << 24) >>> 24;
        }
        int i16 = i15 | i14;
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    return bArr2;
                }
                bArr2[i10] = j8[i16 >>> 18];
                bArr2[i10 + 1] = j8[(i16 >>> 12) & 63];
                bArr2[i10 + 2] = j8[(i16 >>> 6) & 63];
                bArr2[i10 + 3] = j8[i16 & 63];
                return bArr2;
            }
            bArr2[i10] = j8[i16 >>> 18];
            bArr2[i10 + 1] = j8[(i16 >>> 12) & 63];
            bArr2[i10 + 2] = j8[(i16 >>> 6) & 63];
            bArr2[i10 + 3] = 61;
            return bArr2;
        }
        bArr2[i10] = j8[i16 >>> 18];
        bArr2[i10 + 1] = j8[(i16 >>> 12) & 63];
        bArr2[i10 + 2] = 61;
        bArr2[i10 + 3] = 61;
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] f(byte[] bArr, byte[] bArr2, int i8, int i9) {
        e(bArr2, 0, i8, bArr, 0, i9);
        return bArr;
    }

    public static String g(byte[] bArr) {
        try {
            return h(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String h(byte[] bArr, int i8, int i9, int i10) throws IOException {
        byte[] i11 = i(bArr, i8, i9, i10);
        try {
            return new String(i11, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static byte[] i(byte[] bArr, int i8, int i9, int i10) throws IOException {
        boolean z7;
        int i11;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ?? r42;
        if (bArr != null) {
            if (i8 >= 0) {
                if (i9 >= 0) {
                    if (i8 + i9 <= bArr.length) {
                        if ((i10 & 2) != 0) {
                            ByteArrayOutputStream byteArrayOutputStream2 = null;
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    outputStream = new OutputStream(byteArrayOutputStream, i10 | 1);
                                } catch (IOException e8) {
                                    e = e8;
                                    outputStream = null;
                                    r42 = 0;
                                } catch (Throwable th) {
                                    th = th;
                                    outputStream = null;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                outputStream = null;
                                r42 = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream = null;
                                outputStream = null;
                            }
                            try {
                                r42 = new GZIPOutputStream(outputStream);
                                try {
                                    r42.write(bArr, i8, i9);
                                    r42.close();
                                    try {
                                        r42.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                    return byteArrayOutputStream.toByteArray();
                                } catch (IOException e10) {
                                    e = e10;
                                    byteArrayOutputStream2 = byteArrayOutputStream;
                                    r42 = r42;
                                    try {
                                        throw e;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayOutputStream2 = r42;
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Exception unused4) {
                                        }
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused5) {
                                        }
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused6) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    byteArrayOutputStream2 = r42;
                                    byteArrayOutputStream2.close();
                                    outputStream.close();
                                    byteArrayOutputStream.close();
                                    throw th;
                                }
                            } catch (IOException e11) {
                                e = e11;
                                r42 = 0;
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream2.close();
                                outputStream.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } else {
                            if ((i10 & 8) != 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            int i12 = (i9 / 3) * 4;
                            if (i9 % 3 > 0) {
                                i11 = 4;
                            } else {
                                i11 = 0;
                            }
                            int i13 = i12 + i11;
                            if (z7) {
                                i13 += i13 / 76;
                            }
                            int i14 = i13;
                            byte[] bArr2 = new byte[i14];
                            int i15 = i9 - 2;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            while (i16 < i15) {
                                int i19 = i16;
                                e(bArr, i16 + i8, 3, bArr2, i17, i10);
                                int i20 = i18 + 4;
                                if (z7 && i20 >= 76) {
                                    bArr2[i17 + 4] = 10;
                                    i17++;
                                    i18 = 0;
                                } else {
                                    i18 = i20;
                                }
                                i16 = i19 + 3;
                                i17 += 4;
                            }
                            int i21 = i16;
                            if (i21 < i9) {
                                e(bArr, i21 + i8, i9 - i21, bArr2, i17, i10);
                                i17 += 4;
                            }
                            int i22 = i17;
                            if (i22 <= i14 - 1) {
                                byte[] bArr3 = new byte[i22];
                                System.arraycopy(bArr2, 0, bArr3, 0, i22);
                                return bArr3;
                            }
                            return bArr2;
                        }
                    } else {
                        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(bArr.length)));
                    }
                } else {
                    throw new IllegalArgumentException("Cannot have length offset: " + i9);
                }
            } else {
                throw new IllegalArgumentException("Cannot have negative offset: " + i8);
            }
        } else {
            throw new NullPointerException("Cannot serialize a null array.");
        }
    }

    private static final byte[] j(int i8) {
        if ((i8 & 16) == 16) {
            return f19051c;
        }
        if ((i8 & 32) == 32) {
            return f19053e;
        }
        return f19049a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] k(int i8) {
        if ((i8 & 16) == 16) {
            return f19052d;
        }
        if ((i8 & 32) == 32) {
            return f19054f;
        }
        return f19050b;
    }

    /* loaded from: classes3.dex */
    public static class OutputStream extends FilterOutputStream {

        /* renamed from: f  reason: collision with root package name */
        private boolean f19055f;

        /* renamed from: g  reason: collision with root package name */
        private int f19056g;

        /* renamed from: h  reason: collision with root package name */
        private byte[] f19057h;

        /* renamed from: i  reason: collision with root package name */
        private int f19058i;

        /* renamed from: j  reason: collision with root package name */
        private int f19059j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f19060k;

        /* renamed from: l  reason: collision with root package name */
        private byte[] f19061l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f19062m;

        /* renamed from: n  reason: collision with root package name */
        private int f19063n;

        /* renamed from: o  reason: collision with root package name */
        private byte[] f19064o;

        public OutputStream(java.io.OutputStream outputStream, int i8) {
            super(outputStream);
            boolean z7;
            int i9;
            if ((i8 & 8) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f19060k = z7;
            boolean z8 = (i8 & 1) != 0;
            this.f19055f = z8;
            if (z8) {
                i9 = 3;
            } else {
                i9 = 4;
            }
            this.f19058i = i9;
            this.f19057h = new byte[i9];
            this.f19056g = 0;
            this.f19059j = 0;
            this.f19062m = false;
            this.f19061l = new byte[4];
            this.f19063n = i8;
            this.f19064o = Base64.k(i8);
        }

        public void a() throws IOException {
            int i8 = this.f19056g;
            if (i8 > 0) {
                if (this.f19055f) {
                    ((FilterOutputStream) this).out.write(Base64.f(this.f19061l, this.f19057h, i8, this.f19063n));
                    this.f19056g = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.f19057h = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i8) throws IOException {
            if (this.f19062m) {
                ((FilterOutputStream) this).out.write(i8);
            } else if (this.f19055f) {
                byte[] bArr = this.f19057h;
                int i9 = this.f19056g;
                int i10 = i9 + 1;
                this.f19056g = i10;
                bArr[i9] = (byte) i8;
                int i11 = this.f19058i;
                if (i10 >= i11) {
                    ((FilterOutputStream) this).out.write(Base64.f(this.f19061l, bArr, i11, this.f19063n));
                    int i12 = this.f19059j + 4;
                    this.f19059j = i12;
                    if (this.f19060k && i12 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.f19059j = 0;
                    }
                    this.f19056g = 0;
                }
            } else {
                byte b8 = this.f19064o[i8 & 127];
                if (b8 <= -5) {
                    if (b8 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr2 = this.f19057h;
                int i13 = this.f19056g;
                int i14 = i13 + 1;
                this.f19056g = i14;
                bArr2[i13] = (byte) i8;
                if (i14 >= this.f19058i) {
                    ((FilterOutputStream) this).out.write(this.f19061l, 0, Base64.d(bArr2, 0, this.f19061l, 0, this.f19063n));
                    this.f19056g = 0;
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) throws IOException {
            if (this.f19062m) {
                ((FilterOutputStream) this).out.write(bArr, i8, i9);
                return;
            }
            for (int i10 = 0; i10 < i9; i10++) {
                write(bArr[i8 + i10]);
            }
        }
    }
}
