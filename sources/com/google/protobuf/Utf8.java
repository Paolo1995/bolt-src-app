package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static final Processor f17656a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b8, byte b9, byte b10, byte b11, char[] cArr, int i8) throws InvalidProtocolBufferException {
            if (!m(b9) && (((b8 << 28) + (b9 + 112)) >> 30) == 0 && !m(b10) && !m(b11)) {
                int r7 = ((b8 & 7) << 18) | (r(b9) << 12) | (r(b10) << 6) | r(b11);
                cArr[i8] = l(r7);
                cArr[i8 + 1] = q(r7);
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b8, char[] cArr, int i8) {
            cArr[i8] = (char) b8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b8, byte b9, byte b10, char[] cArr, int i8) throws InvalidProtocolBufferException {
            if (!m(b9) && ((b8 != -32 || b9 >= -96) && ((b8 != -19 || b9 < -96) && !m(b10)))) {
                cArr[i8] = (char) (((b8 & 15) << 12) | (r(b9) << 6) | r(b10));
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b8, byte b9, char[] cArr, int i8) throws InvalidProtocolBufferException {
            if (b8 >= -62 && !m(b9)) {
                cArr[i8] = (char) (((b8 & 31) << 6) | r(b9));
                return;
            }
            throw InvalidProtocolBufferException.d();
        }

        private static char l(int i8) {
            return (char) ((i8 >>> 10) + 55232);
        }

        private static boolean m(byte b8) {
            return b8 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b8) {
            return b8 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b8) {
            return b8 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b8) {
            return b8 < -32;
        }

        private static char q(int i8) {
            return (char) ((i8 & 1023) + 56320);
        }

        private static int r(byte b8) {
            return b8 & 63;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class Processor {
        Processor() {
        }

        private static int j(ByteBuffer byteBuffer, int i8, int i9) {
            int l8 = i8 + Utf8.l(byteBuffer, i8, i9);
            while (l8 < i9) {
                int i10 = l8 + 1;
                byte b8 = byteBuffer.get(l8);
                if (b8 < 0) {
                    if (b8 < -32) {
                        if (i10 >= i9) {
                            return b8;
                        }
                        if (b8 < -62 || byteBuffer.get(i10) > -65) {
                            return -1;
                        }
                        i10++;
                    } else if (b8 < -16) {
                        if (i10 >= i9 - 1) {
                            return Utf8.p(byteBuffer, b8, i10, i9 - i10);
                        }
                        int i11 = i10 + 1;
                        byte b9 = byteBuffer.get(i10);
                        if (b9 > -65 || ((b8 == -32 && b9 < -96) || ((b8 == -19 && b9 >= -96) || byteBuffer.get(i11) > -65))) {
                            return -1;
                        }
                        l8 = i11 + 1;
                    } else if (i10 >= i9 - 2) {
                        return Utf8.p(byteBuffer, b8, i10, i9 - i10);
                    } else {
                        int i12 = i10 + 1;
                        byte b10 = byteBuffer.get(i10);
                        if (b10 <= -65 && (((b8 << 28) + (b10 + 112)) >> 30) == 0) {
                            int i13 = i12 + 1;
                            if (byteBuffer.get(i12) <= -65) {
                                i10 = i13 + 1;
                                if (byteBuffer.get(i13) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                l8 = i10;
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i8, i9);
            } else if (byteBuffer.isDirect()) {
                return d(byteBuffer, i8, i9);
            } else {
                return c(byteBuffer, i8, i9);
            }
        }

        abstract String b(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException;

        final String c(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            if ((i8 | i9 | ((byteBuffer.limit() - i8) - i9)) >= 0) {
                int i10 = i8 + i9;
                char[] cArr = new char[i9];
                int i11 = 0;
                while (i8 < i10) {
                    byte b8 = byteBuffer.get(i8);
                    if (!DecodeUtil.n(b8)) {
                        break;
                    }
                    i8++;
                    DecodeUtil.i(b8, cArr, i11);
                    i11++;
                }
                int i12 = i11;
                while (i8 < i10) {
                    int i13 = i8 + 1;
                    byte b9 = byteBuffer.get(i8);
                    if (DecodeUtil.n(b9)) {
                        int i14 = i12 + 1;
                        DecodeUtil.i(b9, cArr, i12);
                        while (i13 < i10) {
                            byte b10 = byteBuffer.get(i13);
                            if (!DecodeUtil.n(b10)) {
                                break;
                            }
                            i13++;
                            DecodeUtil.i(b10, cArr, i14);
                            i14++;
                        }
                        i8 = i13;
                        i12 = i14;
                    } else if (DecodeUtil.p(b9)) {
                        if (i13 < i10) {
                            DecodeUtil.k(b9, byteBuffer.get(i13), cArr, i12);
                            i8 = i13 + 1;
                            i12++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (DecodeUtil.o(b9)) {
                        if (i13 < i10 - 1) {
                            int i15 = i13 + 1;
                            DecodeUtil.j(b9, byteBuffer.get(i13), byteBuffer.get(i15), cArr, i12);
                            i8 = i15 + 1;
                            i12++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (i13 < i10 - 2) {
                        int i16 = i13 + 1;
                        byte b11 = byteBuffer.get(i13);
                        int i17 = i16 + 1;
                        DecodeUtil.h(b9, b11, byteBuffer.get(i16), byteBuffer.get(i17), cArr, i12);
                        i8 = i17 + 1;
                        i12 = i12 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.d();
                    }
                }
                return new String(cArr, 0, i12);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i8), Integer.valueOf(i9)));
        }

        abstract String d(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException;

        abstract int e(CharSequence charSequence, byte[] bArr, int i8, int i9);

        final boolean f(ByteBuffer byteBuffer, int i8, int i9) {
            if (h(0, byteBuffer, i8, i9) != 0) {
                return false;
            }
            return true;
        }

        final boolean g(byte[] bArr, int i8, int i9) {
            if (i(0, bArr, i8, i9) != 0) {
                return false;
            }
            return true;
        }

        final int h(int i8, ByteBuffer byteBuffer, int i9, int i10) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return i(i8, byteBuffer.array(), i9 + arrayOffset, arrayOffset + i10);
            } else if (byteBuffer.isDirect()) {
                return l(i8, byteBuffer, i9, i10);
            } else {
                return k(i8, byteBuffer, i9, i10);
            }
        }

        abstract int i(int i8, byte[] bArr, int i9, int i10);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r8.get(r9) > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
            if (r8.get(r9) > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
            if (r8.get(r9) > (-65)) goto L51;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final int k(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L8e
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L8e
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.protobuf.Utf8.a(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L65
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L63
                int r7 = com.google.protobuf.Utf8.a(r0, r1)
                return r7
            L63:
                r9 = r7
                goto L68
            L65:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L68:
                if (r4 != 0) goto L78
                int r7 = r9 + 1
                byte r4 = r8.get(r9)
                if (r7 < r10) goto L77
                int r7 = com.google.protobuf.Utf8.b(r0, r1, r4)
                return r7
            L77:
                r9 = r7
            L78:
                if (r1 > r3) goto L8d
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L8d
                if (r4 > r3) goto L8d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L8d:
                return r2
            L8e:
                int r7 = j(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.k(int, java.nio.ByteBuffer, int, int):int");
        }

        abstract int l(int i8, ByteBuffer byteBuffer, int i9, int i10);
    }

    /* loaded from: classes3.dex */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int m(byte[] bArr, int i8, int i9) {
            while (i8 < i9 && bArr[i8] >= 0) {
                i8++;
            }
            if (i8 >= i9) {
                return 0;
            }
            return n(bArr, i8, i9);
        }

        private static int n(byte[] bArr, int i8, int i9) {
            while (i8 < i9) {
                int i10 = i8 + 1;
                byte b8 = bArr[i8];
                if (b8 < 0) {
                    if (b8 < -32) {
                        if (i10 >= i9) {
                            return b8;
                        }
                        if (b8 >= -62) {
                            i8 = i10 + 1;
                            if (bArr[i10] > -65) {
                            }
                        }
                        return -1;
                    } else if (b8 < -16) {
                        if (i10 >= i9 - 1) {
                            return Utf8.q(bArr, i10, i9);
                        }
                        int i11 = i10 + 1;
                        byte b9 = bArr[i10];
                        if (b9 <= -65 && ((b8 != -32 || b9 >= -96) && (b8 != -19 || b9 < -96))) {
                            i8 = i11 + 1;
                            if (bArr[i11] > -65) {
                            }
                        }
                        return -1;
                    } else if (i10 >= i9 - 2) {
                        return Utf8.q(bArr, i10, i9);
                    } else {
                        int i12 = i10 + 1;
                        byte b10 = bArr[i10];
                        if (b10 <= -65 && (((b8 << 28) + (b10 + 112)) >> 30) == 0) {
                            int i13 = i12 + 1;
                            if (bArr[i12] <= -65) {
                                i10 = i13 + 1;
                                if (bArr[i13] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i8 = i10;
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        String b(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException {
            if ((i8 | i9 | ((bArr.length - i8) - i9)) >= 0) {
                int i10 = i8 + i9;
                char[] cArr = new char[i9];
                int i11 = 0;
                while (i8 < i10) {
                    byte b8 = bArr[i8];
                    if (!DecodeUtil.n(b8)) {
                        break;
                    }
                    i8++;
                    DecodeUtil.i(b8, cArr, i11);
                    i11++;
                }
                int i12 = i11;
                while (i8 < i10) {
                    int i13 = i8 + 1;
                    byte b9 = bArr[i8];
                    if (DecodeUtil.n(b9)) {
                        int i14 = i12 + 1;
                        DecodeUtil.i(b9, cArr, i12);
                        while (i13 < i10) {
                            byte b10 = bArr[i13];
                            if (!DecodeUtil.n(b10)) {
                                break;
                            }
                            i13++;
                            DecodeUtil.i(b10, cArr, i14);
                            i14++;
                        }
                        i8 = i13;
                        i12 = i14;
                    } else if (DecodeUtil.p(b9)) {
                        if (i13 < i10) {
                            DecodeUtil.k(b9, bArr[i13], cArr, i12);
                            i8 = i13 + 1;
                            i12++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (DecodeUtil.o(b9)) {
                        if (i13 < i10 - 1) {
                            int i15 = i13 + 1;
                            DecodeUtil.j(b9, bArr[i13], bArr[i15], cArr, i12);
                            i8 = i15 + 1;
                            i12++;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    } else if (i13 < i10 - 2) {
                        int i16 = i13 + 1;
                        byte b11 = bArr[i13];
                        int i17 = i16 + 1;
                        DecodeUtil.h(b9, b11, bArr[i16], bArr[i17], cArr, i12);
                        i8 = i17 + 1;
                        i12 = i12 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.d();
                    }
                }
                return new String(cArr, 0, i12);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        String d(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            return c(byteBuffer, i8, i9);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int e(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.e(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r8[r9] > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
            if (r8[r9] > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x007f, code lost:
            if (r8[r9] > (-65)) goto L51;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int i(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L82
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L82
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.Utf8.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L5d
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5b
                int r7 = com.google.protobuf.Utf8.a(r0, r1)
                return r7
            L5b:
                r9 = r7
                goto L60
            L5d:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L60:
                if (r4 != 0) goto L6e
                int r7 = r9 + 1
                r4 = r8[r9]
                if (r7 < r10) goto L6d
                int r7 = com.google.protobuf.Utf8.b(r0, r1, r4)
                return r7
            L6d:
                r9 = r7
            L6e:
                if (r1 > r3) goto L81
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L81
                if (r4 > r3) goto L81
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L81:
                return r2
            L82:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.i(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        int l(int i8, ByteBuffer byteBuffer, int i9, int i10) {
            return k(i8, byteBuffer, i9, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i8, int i9) {
            super("Unpaired surrogate at index " + i8 + " of " + i9);
        }
    }

    /* loaded from: classes3.dex */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean m() {
            if (UnsafeUtil.I() && UnsafeUtil.J()) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int n(long r8, int r10) {
            /*
                int r0 = p(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r10 <= 0) goto L1a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.w(r8)
                if (r1 < 0) goto L19
                int r10 = r10 + (-1)
                r8 = r4
                goto L9
            L19:
                r8 = r4
            L1a:
                if (r10 != 0) goto L1d
                return r0
            L1d:
                int r10 = r10 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r10 != 0) goto L29
                return r1
            L29:
                int r10 = r10 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.w(r8)
                if (r8 <= r4) goto L37
                goto L39
            L37:
                r8 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r10 >= r6) goto L46
                int r8 = r(r8, r1, r10)
                return r8
            L46:
                int r10 = r10 + (-2)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.w(r8)
                if (r8 > r4) goto L63
                r9 = -96
                if (r1 != r0) goto L56
                if (r8 < r9) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r8 >= r9) goto L63
            L5c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.UnsafeUtil.w(r6)
                if (r8 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r10 >= r0) goto L6c
                int r8 = r(r8, r1, r10)
                return r8
            L6c:
                int r10 = r10 + (-3)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.w(r8)
                if (r8 > r4) goto L8e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L8e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.w(r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.w(r8)
                if (r8 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.n(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int o(byte[] r8, long r9, int r11) {
            /*
                int r0 = q(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r11 <= 0) goto L1a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r8, r9)
                if (r1 < 0) goto L19
                int r11 = r11 + (-1)
                r9 = r4
                goto L9
            L19:
                r9 = r4
            L1a:
                if (r11 != 0) goto L1d
                return r0
            L1d:
                int r11 = r11 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r11 != 0) goto L29
                return r1
            L29:
                int r11 = r11 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.x(r8, r9)
                if (r9 <= r4) goto L37
                goto L39
            L37:
                r9 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r11 >= r6) goto L46
                int r8 = s(r8, r1, r9, r11)
                return r8
            L46:
                int r11 = r11 + (-2)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.x(r8, r9)
                if (r9 > r4) goto L63
                r10 = -96
                if (r1 != r0) goto L56
                if (r9 < r10) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r9 >= r10) goto L63
            L5c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.UnsafeUtil.x(r8, r6)
                if (r9 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r11 >= r0) goto L6c
                int r8 = s(r8, r1, r9, r11)
                return r8
            L6c:
                int r11 = r11 + (-3)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.x(r8, r9)
                if (r9 > r4) goto L8e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L8e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.x(r8, r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.x(r8, r9)
                if (r9 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.o(byte[], long, int):int");
        }

        private static int p(long j8, int i8) {
            if (i8 < 16) {
                return 0;
            }
            int i9 = (int) ((-j8) & 7);
            int i10 = i9;
            while (i10 > 0) {
                long j9 = 1 + j8;
                if (UnsafeUtil.w(j8) < 0) {
                    return i9 - i10;
                }
                i10--;
                j8 = j9;
            }
            int i11 = i8 - i9;
            while (i11 >= 8 && (UnsafeUtil.D(j8) & (-9187201950435737472L)) == 0) {
                j8 += 8;
                i11 -= 8;
            }
            return i8 - i11;
        }

        private static int q(byte[] bArr, long j8, int i8) {
            int i9 = 0;
            if (i8 < 16) {
                return 0;
            }
            int i10 = 8 - (((int) j8) & 7);
            while (i9 < i10) {
                long j9 = 1 + j8;
                if (UnsafeUtil.x(bArr, j8) < 0) {
                    return i9;
                }
                i9++;
                j8 = j9;
            }
            while (true) {
                int i11 = i9 + 8;
                if (i11 > i8 || (UnsafeUtil.E(bArr, UnsafeUtil.f17639h + j8) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j8 += 8;
                i9 = i11;
            }
            while (i9 < i8) {
                long j10 = j8 + 1;
                if (UnsafeUtil.x(bArr, j8) < 0) {
                    return i9;
                }
                i9++;
                j8 = j10;
            }
            return i8;
        }

        private static int r(long j8, int i8, int i9) {
            if (i9 == 0) {
                return Utf8.m(i8);
            }
            if (i9 == 1) {
                return Utf8.n(i8, UnsafeUtil.w(j8));
            }
            if (i9 == 2) {
                return Utf8.o(i8, UnsafeUtil.w(j8), UnsafeUtil.w(j8 + 1));
            }
            throw new AssertionError();
        }

        private static int s(byte[] bArr, int i8, long j8, int i9) {
            if (i9 == 0) {
                return Utf8.m(i8);
            }
            if (i9 == 1) {
                return Utf8.n(i8, UnsafeUtil.x(bArr, j8));
            }
            if (i9 == 2) {
                return Utf8.o(i8, UnsafeUtil.x(bArr, j8), UnsafeUtil.x(bArr, j8 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.Processor
        String b(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException {
            Charset charset = Internal.f17450b;
            String str = new String(bArr, i8, i9, charset);
            if (!str.contains("�")) {
                return str;
            }
            if (Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i8, i9 + i8))) {
                return str;
            }
            throw InvalidProtocolBufferException.d();
        }

        @Override // com.google.protobuf.Utf8.Processor
        String d(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
            if ((i8 | i9 | ((byteBuffer.limit() - i8) - i9)) >= 0) {
                long k8 = UnsafeUtil.k(byteBuffer) + i8;
                long j8 = i9 + k8;
                char[] cArr = new char[i9];
                int i10 = 0;
                while (k8 < j8) {
                    byte w7 = UnsafeUtil.w(k8);
                    if (!DecodeUtil.n(w7)) {
                        break;
                    }
                    k8++;
                    DecodeUtil.i(w7, cArr, i10);
                    i10++;
                }
                while (true) {
                    int i11 = i10;
                    while (k8 < j8) {
                        long j9 = k8 + 1;
                        byte w8 = UnsafeUtil.w(k8);
                        if (DecodeUtil.n(w8)) {
                            int i12 = i11 + 1;
                            DecodeUtil.i(w8, cArr, i11);
                            while (j9 < j8) {
                                byte w9 = UnsafeUtil.w(j9);
                                if (!DecodeUtil.n(w9)) {
                                    break;
                                }
                                j9++;
                                DecodeUtil.i(w9, cArr, i12);
                                i12++;
                            }
                            i11 = i12;
                            k8 = j9;
                        } else if (DecodeUtil.p(w8)) {
                            if (j9 < j8) {
                                k8 = j9 + 1;
                                DecodeUtil.k(w8, UnsafeUtil.w(j9), cArr, i11);
                                i11++;
                            } else {
                                throw InvalidProtocolBufferException.d();
                            }
                        } else if (DecodeUtil.o(w8)) {
                            if (j9 < j8 - 1) {
                                long j10 = j9 + 1;
                                DecodeUtil.j(w8, UnsafeUtil.w(j9), UnsafeUtil.w(j10), cArr, i11);
                                i11++;
                                k8 = j10 + 1;
                            } else {
                                throw InvalidProtocolBufferException.d();
                            }
                        } else if (j9 < j8 - 2) {
                            long j11 = j9 + 1;
                            byte w10 = UnsafeUtil.w(j9);
                            long j12 = j11 + 1;
                            byte w11 = UnsafeUtil.w(j11);
                            k8 = j12 + 1;
                            DecodeUtil.h(w8, w10, w11, UnsafeUtil.w(j12), cArr, i11);
                            i10 = i11 + 1 + 1;
                        } else {
                            throw InvalidProtocolBufferException.d();
                        }
                    }
                    return new String(cArr, 0, i11);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i8), Integer.valueOf(i9)));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int e(CharSequence charSequence, byte[] bArr, int i8, int i9) {
            char c8;
            long j8;
            long j9;
            long j10;
            int i10;
            char charAt;
            long j11 = i8;
            long j12 = i9 + j11;
            int length = charSequence.length();
            if (length > i9 || bArr.length - i9 < i8) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i8 + i9));
            }
            int i11 = 0;
            while (true) {
                c8 = 128;
                j8 = 1;
                if (i11 >= length || (charAt = charSequence.charAt(i11)) >= 128) {
                    break;
                }
                UnsafeUtil.O(bArr, j11, (byte) charAt);
                i11++;
                j11 = 1 + j11;
            }
            if (i11 == length) {
                return (int) j11;
            }
            while (i11 < length) {
                char charAt2 = charSequence.charAt(i11);
                if (charAt2 >= c8 || j11 >= j12) {
                    if (charAt2 < 2048 && j11 <= j12 - 2) {
                        long j13 = j11 + j8;
                        UnsafeUtil.O(bArr, j11, (byte) ((charAt2 >>> 6) | 960));
                        UnsafeUtil.O(bArr, j13, (byte) ((charAt2 & '?') | 128));
                        j9 = j13 + j8;
                        j10 = j8;
                    } else if ((charAt2 >= 55296 && 57343 >= charAt2) || j11 > j12 - 3) {
                        if (j11 <= j12 - 4) {
                            int i12 = i11 + 1;
                            if (i12 != length) {
                                char charAt3 = charSequence.charAt(i12);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j14 = j11 + 1;
                                    UnsafeUtil.O(bArr, j11, (byte) ((codePoint >>> 18) | 240));
                                    long j15 = j14 + 1;
                                    UnsafeUtil.O(bArr, j14, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j16 = j15 + 1;
                                    UnsafeUtil.O(bArr, j15, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j10 = 1;
                                    j9 = j16 + 1;
                                    UnsafeUtil.O(bArr, j16, (byte) ((codePoint & 63) | 128));
                                    i11 = i12;
                                } else {
                                    i11 = i12;
                                }
                            }
                            throw new UnpairedSurrogateException(i11 - 1, length);
                        } else if (55296 <= charAt2 && charAt2 <= 57343 && ((i10 = i11 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i10)))) {
                            throw new UnpairedSurrogateException(i11, length);
                        } else {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j11);
                        }
                    } else {
                        long j17 = j11 + j8;
                        UnsafeUtil.O(bArr, j11, (byte) ((charAt2 >>> '\f') | 480));
                        long j18 = j17 + j8;
                        UnsafeUtil.O(bArr, j17, (byte) (((charAt2 >>> 6) & 63) | 128));
                        UnsafeUtil.O(bArr, j18, (byte) ((charAt2 & '?') | 128));
                        j9 = j18 + 1;
                        j10 = 1;
                    }
                    i11++;
                    c8 = 128;
                    long j19 = j10;
                    j11 = j9;
                    j8 = j19;
                } else {
                    long j20 = j11 + j8;
                    UnsafeUtil.O(bArr, j11, (byte) charAt2);
                    j10 = j8;
                    j9 = j20;
                }
                i11++;
                c8 = 128;
                long j192 = j10;
                j11 = j9;
                j8 = j192;
            }
            return (int) j11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
            if (com.google.protobuf.UnsafeUtil.x(r13, r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
            if (com.google.protobuf.UnsafeUtil.x(r13, r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int i(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.i(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
            if (com.google.protobuf.UnsafeUtil.w(r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
            if (com.google.protobuf.UnsafeUtil.w(r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int l(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.l(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        Processor safeProcessor;
        if (UnsafeProcessor.m() && !Android.c()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        f17656a = safeProcessor;
    }

    private Utf8() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(ByteBuffer byteBuffer, int i8, int i9) throws InvalidProtocolBufferException {
        return f17656a.a(byteBuffer, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(byte[] bArr, int i8, int i9) throws InvalidProtocolBufferException {
        return f17656a.b(bArr, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(CharSequence charSequence, byte[] bArr, int i8, int i9) {
        return f17656a.e(charSequence, bArr, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i8 = 0;
        while (i8 < length && charSequence.charAt(i8) < 128) {
            i8++;
        }
        int i9 = length;
        while (true) {
            if (i8 < length) {
                char charAt = charSequence.charAt(i8);
                if (charAt < 2048) {
                    i9 += (127 - charAt) >>> 31;
                    i8++;
                } else {
                    i9 += k(charSequence, i8);
                    break;
                }
            } else {
                break;
            }
        }
        if (i9 >= length) {
            return i9;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i9 + 4294967296L));
    }

    private static int k(CharSequence charSequence, int i8) {
        int length = charSequence.length();
        int i9 = 0;
        while (i8 < length) {
            char charAt = charSequence.charAt(i8);
            if (charAt < 2048) {
                i9 += (127 - charAt) >>> 31;
            } else {
                i9 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i8) >= 65536) {
                        i8++;
                    } else {
                        throw new UnpairedSurrogateException(i8, length);
                    }
                }
            }
            i8++;
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(ByteBuffer byteBuffer, int i8, int i9) {
        int i10 = i9 - 7;
        int i11 = i8;
        while (i11 < i10 && (byteBuffer.getLong(i11) & (-9187201950435737472L)) == 0) {
            i11 += 8;
        }
        return i11 - i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i8) {
        if (i8 > -12) {
            return -1;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i8, int i9) {
        if (i8 > -12 || i9 > -65) {
            return -1;
        }
        return i8 ^ (i9 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i8, int i9, int i10) {
        if (i8 > -12 || i9 > -65 || i10 > -65) {
            return -1;
        }
        return (i8 ^ (i9 << 8)) ^ (i10 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(ByteBuffer byteBuffer, int i8, int i9, int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return o(i8, byteBuffer.get(i9), byteBuffer.get(i9 + 1));
                }
                throw new AssertionError();
            }
            return n(i8, byteBuffer.get(i9));
        }
        return m(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(byte[] bArr, int i8, int i9) {
        byte b8 = bArr[i8 - 1];
        int i10 = i9 - i8;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return o(b8, bArr[i8], bArr[i8 + 1]);
                }
                throw new AssertionError();
            }
            return n(b8, bArr[i8]);
        }
        return m(b8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(ByteBuffer byteBuffer) {
        return f17656a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(byte[] bArr) {
        return f17656a.g(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(byte[] bArr, int i8, int i9) {
        return f17656a.g(bArr, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i8, ByteBuffer byteBuffer, int i9, int i10) {
        return f17656a.h(i8, byteBuffer, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i8, byte[] bArr, int i9, int i10) {
        return f17656a.i(i8, bArr, i9, i10);
    }
}
