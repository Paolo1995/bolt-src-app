package com.google.crypto.tink.subtle;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f15323a = Charset.forName("UTF-8");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Coder {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f15324a;

        /* renamed from: b  reason: collision with root package name */
        public int f15325b;

        Coder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Decoder extends Coder {

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f15326f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g  reason: collision with root package name */
        private static final int[] f15327g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c  reason: collision with root package name */
        private int f15328c;

        /* renamed from: d  reason: collision with root package name */
        private int f15329d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f15330e;

        public Decoder(int i8, byte[] bArr) {
            int[] iArr;
            this.f15324a = bArr;
            if ((i8 & 8) == 0) {
                iArr = f15326f;
            } else {
                iArr = f15327g;
            }
            this.f15330e = iArr;
            this.f15328c = 0;
            this.f15329d = 0;
        }

        public boolean a(byte[] bArr, int i8, int i9, boolean z7) {
            int i10 = this.f15328c;
            if (i10 == 6) {
                return false;
            }
            int i11 = i9 + i8;
            int i12 = this.f15329d;
            byte[] bArr2 = this.f15324a;
            int[] iArr = this.f15330e;
            int i13 = i12;
            int i14 = 0;
            int i15 = i10;
            int i16 = i8;
            while (i16 < i11) {
                if (i15 == 0) {
                    while (true) {
                        int i17 = i16 + 4;
                        if (i17 > i11 || (i13 = (iArr[bArr[i16] & 255] << 18) | (iArr[bArr[i16 + 1] & 255] << 12) | (iArr[bArr[i16 + 2] & 255] << 6) | iArr[bArr[i16 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i14 + 2] = (byte) i13;
                        bArr2[i14 + 1] = (byte) (i13 >> 8);
                        bArr2[i14] = (byte) (i13 >> 16);
                        i14 += 3;
                        i16 = i17;
                    }
                    if (i16 >= i11) {
                        break;
                    }
                }
                int i18 = i16 + 1;
                int i19 = iArr[bArr[i16] & 255];
                if (i15 != 0) {
                    if (i15 != 1) {
                        if (i15 != 2) {
                            if (i15 != 3) {
                                if (i15 != 4) {
                                    if (i15 == 5 && i19 != -1) {
                                        this.f15328c = 6;
                                        return false;
                                    }
                                } else if (i19 == -2) {
                                    i15++;
                                } else if (i19 != -1) {
                                    this.f15328c = 6;
                                    return false;
                                }
                            } else if (i19 >= 0) {
                                int i20 = i19 | (i13 << 6);
                                bArr2[i14 + 2] = (byte) i20;
                                bArr2[i14 + 1] = (byte) (i20 >> 8);
                                bArr2[i14] = (byte) (i20 >> 16);
                                i14 += 3;
                                i13 = i20;
                                i15 = 0;
                            } else if (i19 == -2) {
                                bArr2[i14 + 1] = (byte) (i13 >> 2);
                                bArr2[i14] = (byte) (i13 >> 10);
                                i14 += 2;
                                i15 = 5;
                            } else if (i19 != -1) {
                                this.f15328c = 6;
                                return false;
                            }
                        } else {
                            if (i19 < 0) {
                                if (i19 == -2) {
                                    bArr2[i14] = (byte) (i13 >> 4);
                                    i14++;
                                    i15 = 4;
                                } else if (i19 != -1) {
                                    this.f15328c = 6;
                                    return false;
                                }
                            }
                            i19 |= i13 << 6;
                        }
                    } else {
                        if (i19 < 0) {
                            if (i19 != -1) {
                                this.f15328c = 6;
                                return false;
                            }
                        }
                        i19 |= i13 << 6;
                    }
                    i15++;
                    i13 = i19;
                } else {
                    if (i19 < 0) {
                        if (i19 != -1) {
                            this.f15328c = 6;
                            return false;
                        }
                    }
                    i15++;
                    i13 = i19;
                }
                i16 = i18;
            }
            if (!z7) {
                this.f15328c = i15;
                this.f15329d = i13;
                this.f15325b = i14;
                return true;
            } else if (i15 != 1) {
                if (i15 != 2) {
                    if (i15 != 3) {
                        if (i15 == 4) {
                            this.f15328c = 6;
                            return false;
                        }
                    } else {
                        int i21 = i14 + 1;
                        bArr2[i14] = (byte) (i13 >> 10);
                        i14 = i21 + 1;
                        bArr2[i21] = (byte) (i13 >> 2);
                    }
                } else {
                    bArr2[i14] = (byte) (i13 >> 4);
                    i14++;
                }
                this.f15328c = i15;
                this.f15325b = i14;
                return true;
            } else {
                this.f15328c = 6;
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Encoder extends Coder {

        /* renamed from: j  reason: collision with root package name */
        private static final byte[] f15331j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k  reason: collision with root package name */
        private static final byte[] f15332k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f15333c;

        /* renamed from: d  reason: collision with root package name */
        int f15334d;

        /* renamed from: e  reason: collision with root package name */
        private int f15335e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f15336f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f15337g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f15338h;

        /* renamed from: i  reason: collision with root package name */
        private final byte[] f15339i;

        public Encoder(int i8, byte[] bArr) {
            boolean z7;
            boolean z8;
            byte[] bArr2;
            int i9;
            this.f15324a = bArr;
            if ((i8 & 1) == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f15336f = z7;
            if ((i8 & 2) == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            this.f15337g = z8;
            this.f15338h = (i8 & 4) != 0;
            if ((i8 & 8) == 0) {
                bArr2 = f15331j;
            } else {
                bArr2 = f15332k;
            }
            this.f15339i = bArr2;
            this.f15333c = new byte[2];
            this.f15334d = 0;
            if (z8) {
                i9 = 19;
            } else {
                i9 = -1;
            }
            this.f15335e = i9;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00dd -> B:22:0x008a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 475
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Base64.Encoder.a(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }

    public static byte[] a(String str, int i8) {
        return b(str.getBytes(f15323a), i8);
    }

    public static byte[] b(byte[] bArr, int i8) {
        return c(bArr, 0, bArr.length, i8);
    }

    public static byte[] c(byte[] bArr, int i8, int i9, int i10) {
        Decoder decoder = new Decoder(i10, new byte[(i9 * 3) / 4]);
        if (decoder.a(bArr, i8, i9, true)) {
            int i11 = decoder.f15325b;
            byte[] bArr2 = decoder.f15324a;
            if (i11 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i11];
            System.arraycopy(bArr2, 0, bArr3, 0, i11);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String d(byte[] bArr) {
        return g(bArr, 2);
    }

    public static byte[] e(byte[] bArr, int i8) {
        return f(bArr, 0, bArr.length, i8);
    }

    public static byte[] f(byte[] bArr, int i8, int i9, int i10) {
        Encoder encoder = new Encoder(i10, null);
        int i11 = (i9 / 3) * 4;
        int i12 = 2;
        if (encoder.f15336f) {
            if (i9 % 3 > 0) {
                i11 += 4;
            }
        } else {
            int i13 = i9 % 3;
            if (i13 != 1) {
                if (i13 == 2) {
                    i11 += 3;
                }
            } else {
                i11 += 2;
            }
        }
        if (encoder.f15337g && i9 > 0) {
            int i14 = ((i9 - 1) / 57) + 1;
            if (!encoder.f15338h) {
                i12 = 1;
            }
            i11 += i14 * i12;
        }
        encoder.f15324a = new byte[i11];
        encoder.a(bArr, i8, i9, true);
        return encoder.f15324a;
    }

    public static String g(byte[] bArr, int i8) {
        try {
            return new String(e(bArr, i8), "US-ASCII");
        } catch (UnsupportedEncodingException e8) {
            throw new AssertionError(e8);
        }
    }
}
