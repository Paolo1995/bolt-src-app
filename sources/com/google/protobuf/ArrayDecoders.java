package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.WireFormat;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ArrayDecoders {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.ArrayDecoders$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17160a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f17160a = iArr;
            try {
                iArr[WireFormat.FieldType.f17672h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17160a[WireFormat.FieldType.f17673i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17160a[WireFormat.FieldType.f17674j.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17160a[WireFormat.FieldType.f17675k.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17160a[WireFormat.FieldType.f17676l.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17160a[WireFormat.FieldType.f17684t.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17160a[WireFormat.FieldType.f17677m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17160a[WireFormat.FieldType.f17687w.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17160a[WireFormat.FieldType.f17678n.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17160a[WireFormat.FieldType.f17686v.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17160a[WireFormat.FieldType.f17679o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17160a[WireFormat.FieldType.f17688x.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17160a[WireFormat.FieldType.f17689y.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17160a[WireFormat.FieldType.f17685u.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17160a[WireFormat.FieldType.f17683s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f17160a[WireFormat.FieldType.f17680p.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17160a[WireFormat.FieldType.f17681q.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f17160a[WireFormat.FieldType.f17682r.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    private ArrayDecoders() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i9, registers);
        intArrayList.s0(CodedInputStream.c(registers.f17161a));
        while (I < i10) {
            int I2 = I(bArr, I, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.s0(CodedInputStream.c(registers.f17161a));
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i9, registers);
        longArrayList.v0(CodedInputStream.d(registers.f17162b));
        while (L < i10) {
            int I = I(bArr, L, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            L = L(bArr, I, registers);
            longArrayList.v0(CodedInputStream.d(registers.f17162b));
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(byte[] bArr, int i8, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a;
        if (i9 >= 0) {
            if (i9 == 0) {
                registers.f17163c = "";
                return I;
            }
            registers.f17163c = new String(bArr, I, i9, Internal.f17450b);
            return I + i9;
        }
        throw InvalidProtocolBufferException.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x001a -> B:9:0x001b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int D(int r4, byte[] r5, int r6, int r7, com.google.protobuf.Internal.ProtobufList<?> r8, com.google.protobuf.ArrayDecoders.Registers r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = I(r5, r6, r9)
            int r0 = r9.f17161a
            if (r0 < 0) goto L45
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
            r8.add(r1)
            goto L1b
        L10:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f17450b
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L1a:
            int r6 = r6 + r0
        L1b:
            if (r6 >= r7) goto L44
            int r0 = I(r5, r6, r9)
            int r2 = r9.f17161a
            if (r4 == r2) goto L26
            goto L44
        L26:
            int r6 = I(r5, r0, r9)
            int r0 = r9.f17161a
            if (r0 < 0) goto L3f
            if (r0 != 0) goto L34
            r8.add(r1)
            goto L1b
        L34:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f17450b
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L1a
        L3f:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.g()
            throw r4
        L44:
            return r6
        L45:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.g()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.D(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int E(int r5, byte[] r6, int r7, int r8, com.google.protobuf.Internal.ProtobufList<?> r9, com.google.protobuf.ArrayDecoders.Registers r10) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = I(r6, r7, r10)
            int r0 = r10.f17161a
            if (r0 < 0) goto L5f
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
            r9.add(r1)
            goto L23
        L10:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.t(r6, r7, r2)
            if (r3 == 0) goto L5a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f17450b
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L22:
            r7 = r2
        L23:
            if (r7 >= r8) goto L59
            int r0 = I(r6, r7, r10)
            int r2 = r10.f17161a
            if (r5 == r2) goto L2e
            goto L59
        L2e:
            int r7 = I(r6, r0, r10)
            int r0 = r10.f17161a
            if (r0 < 0) goto L54
            if (r0 != 0) goto L3c
            r9.add(r1)
            goto L23
        L3c:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.t(r6, r7, r2)
            if (r3 == 0) goto L4f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f17450b
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L22
        L4f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.d()
            throw r5
        L54:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.g()
            throw r5
        L59:
            return r7
        L5a:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.d()
            throw r5
        L5f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.g()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.E(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(byte[] bArr, int i8, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a;
        if (i9 >= 0) {
            if (i9 == 0) {
                registers.f17163c = "";
                return I;
            }
            registers.f17163c = Utf8.h(bArr, I, i9);
            return I + i9;
        }
        throw InvalidProtocolBufferException.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i8, byte[] bArr, int i9, int i10, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i8) != 0) {
            int b8 = WireFormat.b(i8);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 == 5) {
                                unknownFieldSetLite.q(i8, Integer.valueOf(h(bArr, i9)));
                                return i9 + 4;
                            }
                            throw InvalidProtocolBufferException.c();
                        }
                        UnknownFieldSetLite n8 = UnknownFieldSetLite.n();
                        int i11 = (i8 & (-8)) | 4;
                        int i12 = 0;
                        while (true) {
                            if (i9 >= i10) {
                                break;
                            }
                            int I = I(bArr, i9, registers);
                            int i13 = registers.f17161a;
                            if (i13 == i11) {
                                i12 = i13;
                                i9 = I;
                                break;
                            }
                            i12 = i13;
                            i9 = G(i13, bArr, I, i10, n8, registers);
                        }
                        if (i9 <= i10 && i12 == i11) {
                            unknownFieldSetLite.q(i8, n8);
                            return i9;
                        }
                        throw InvalidProtocolBufferException.h();
                    }
                    int I2 = I(bArr, i9, registers);
                    int i14 = registers.f17161a;
                    if (i14 >= 0) {
                        if (i14 <= bArr.length - I2) {
                            if (i14 == 0) {
                                unknownFieldSetLite.q(i8, ByteString.f17177g);
                            } else {
                                unknownFieldSetLite.q(i8, ByteString.p(bArr, I2, i14));
                            }
                            return I2 + i14;
                        }
                        throw InvalidProtocolBufferException.m();
                    }
                    throw InvalidProtocolBufferException.g();
                }
                unknownFieldSetLite.q(i8, Long.valueOf(j(bArr, i9)));
                return i9 + 8;
            }
            int L = L(bArr, i9, registers);
            unknownFieldSetLite.q(i8, Long.valueOf(registers.f17162b));
            return L;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i8, byte[] bArr, int i9, Registers registers) {
        int i10 = i8 & 127;
        int i11 = i9 + 1;
        byte b8 = bArr[i9];
        if (b8 >= 0) {
            registers.f17161a = i10 | (b8 << 7);
            return i11;
        }
        int i12 = i10 | ((b8 & Byte.MAX_VALUE) << 7);
        int i13 = i11 + 1;
        byte b9 = bArr[i11];
        if (b9 >= 0) {
            registers.f17161a = i12 | (b9 << 14);
            return i13;
        }
        int i14 = i12 | ((b9 & Byte.MAX_VALUE) << 14);
        int i15 = i13 + 1;
        byte b10 = bArr[i13];
        if (b10 >= 0) {
            registers.f17161a = i14 | (b10 << 21);
            return i15;
        }
        int i16 = i14 | ((b10 & Byte.MAX_VALUE) << 21);
        int i17 = i15 + 1;
        byte b11 = bArr[i15];
        if (b11 >= 0) {
            registers.f17161a = i16 | (b11 << 28);
            return i17;
        }
        int i18 = i16 | ((b11 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] < 0) {
                i17 = i19;
            } else {
                registers.f17161a = i18;
                return i19;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(byte[] bArr, int i8, Registers registers) {
        int i9 = i8 + 1;
        byte b8 = bArr[i8];
        if (b8 >= 0) {
            registers.f17161a = b8;
            return i9;
        }
        return H(b8, bArr, i9, registers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i9, registers);
        intArrayList.s0(registers.f17161a);
        while (I < i10) {
            int I2 = I(bArr, I, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.s0(registers.f17161a);
        }
        return I;
    }

    static int K(long j8, byte[] bArr, int i8, Registers registers) {
        int i9 = i8 + 1;
        byte b8 = bArr[i8];
        long j9 = (j8 & 127) | ((b8 & Byte.MAX_VALUE) << 7);
        int i10 = 7;
        while (b8 < 0) {
            int i11 = i9 + 1;
            byte b9 = bArr[i9];
            i10 += 7;
            j9 |= (b9 & Byte.MAX_VALUE) << i10;
            i9 = i11;
            b8 = b9;
        }
        registers.f17162b = j9;
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(byte[] bArr, int i8, Registers registers) {
        int i9 = i8 + 1;
        long j8 = bArr[i8];
        if (j8 >= 0) {
            registers.f17162b = j8;
            return i9;
        }
        return K(j8, bArr, i9, registers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i9, registers);
        longArrayList.v0(registers.f17162b);
        while (L < i10) {
            int I = I(bArr, L, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            L = L(bArr, I, registers);
            longArrayList.v0(registers.f17162b);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int N(int i8, byte[] bArr, int i9, int i10, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i8) != 0) {
            int b8 = WireFormat.b(i8);
            if (b8 != 0) {
                if (b8 != 1) {
                    if (b8 != 2) {
                        if (b8 != 3) {
                            if (b8 == 5) {
                                return i9 + 4;
                            }
                            throw InvalidProtocolBufferException.c();
                        }
                        int i11 = (i8 & (-8)) | 4;
                        int i12 = 0;
                        while (i9 < i10) {
                            i9 = I(bArr, i9, registers);
                            i12 = registers.f17161a;
                            if (i12 == i11) {
                                break;
                            }
                            i9 = N(i12, bArr, i9, i10, registers);
                        }
                        if (i9 <= i10 && i12 == i11) {
                            return i9;
                        }
                        throw InvalidProtocolBufferException.h();
                    }
                    return I(bArr, i9, registers) + registers.f17161a;
                }
                return i9 + 8;
            }
            return L(bArr, i9, registers);
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        boolean z7;
        boolean z8;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int L = L(bArr, i9, registers);
        if (registers.f17162b != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        booleanArrayList.i(z7);
        while (L < i10) {
            int I = I(bArr, L, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            L = L(bArr, I, registers);
            if (registers.f17162b != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            booleanArrayList.i(z8);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i8, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a;
        if (i9 >= 0) {
            if (i9 <= bArr.length - I) {
                if (i9 == 0) {
                    registers.f17163c = ByteString.f17177g;
                    return I;
                }
                registers.f17163c = ByteString.p(bArr, I, i9);
                return I + i9;
            }
            throw InvalidProtocolBufferException.m();
        }
        throw InvalidProtocolBufferException.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001b -> B:10:0x001c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(int r2, byte[] r3, int r4, int r5, com.google.protobuf.Internal.ProtobufList<?> r6, com.google.protobuf.ArrayDecoders.Registers r7) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = I(r3, r4, r7)
            int r0 = r7.f17161a
            if (r0 < 0) goto L53
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L4e
            if (r0 != 0) goto L14
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.f17177g
            r6.add(r0)
            goto L1c
        L14:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.p(r3, r4, r0)
            r6.add(r1)
        L1b:
            int r4 = r4 + r0
        L1c:
            if (r4 >= r5) goto L4d
            int r0 = I(r3, r4, r7)
            int r1 = r7.f17161a
            if (r2 == r1) goto L27
            goto L4d
        L27:
            int r4 = I(r3, r0, r7)
            int r0 = r7.f17161a
            if (r0 < 0) goto L48
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L43
            if (r0 != 0) goto L3b
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.f17177g
            r6.add(r0)
            goto L1c
        L3b:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.p(r3, r4, r0)
            r6.add(r1)
            goto L1b
        L43:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.m()
            throw r2
        L48:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.g()
            throw r2
        L4d:
            return r4
        L4e:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.m()
            throw r2
        L53:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.g()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.c(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double d(byte[] bArr, int i8) {
        return Double.longBitsToDouble(j(bArr, i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.K0(d(bArr, i9));
        int i11 = i9 + 8;
        while (i11 < i10) {
            int I = I(bArr, i11, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            doubleArrayList.K0(d(bArr, I));
            i11 = I + 8;
        }
        return i11;
    }

    static int f(int i8, byte[] bArr, int i9, int i10, GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        boolean z7;
        Object i11;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i12 = i8 >>> 3;
        Object obj = null;
        if (generatedExtension.f17435d.b() && generatedExtension.f17435d.i()) {
            switch (AnonymousClass1.f17160a[generatedExtension.d().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int s7 = s(bArr, i9, doubleArrayList, registers);
                    fieldSet.C(generatedExtension.f17435d, doubleArrayList);
                    return s7;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int v7 = v(bArr, i9, floatArrayList, registers);
                    fieldSet.C(generatedExtension.f17435d, floatArrayList);
                    return v7;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int z8 = z(bArr, i9, longArrayList, registers);
                    fieldSet.C(generatedExtension.f17435d, longArrayList);
                    return z8;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int y7 = y(bArr, i9, intArrayList, registers);
                    fieldSet.C(generatedExtension.f17435d, intArrayList);
                    return y7;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int u7 = u(bArr, i9, longArrayList2, registers);
                    fieldSet.C(generatedExtension.f17435d, longArrayList2);
                    return u7;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int t7 = t(bArr, i9, intArrayList2, registers);
                    fieldSet.C(generatedExtension.f17435d, intArrayList2);
                    return t7;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int r7 = r(bArr, i9, booleanArrayList, registers);
                    fieldSet.C(generatedExtension.f17435d, booleanArrayList);
                    return r7;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int w7 = w(bArr, i9, intArrayList3, registers);
                    fieldSet.C(generatedExtension.f17435d, intArrayList3);
                    return w7;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int x7 = x(bArr, i9, longArrayList3, registers);
                    fieldSet.C(generatedExtension.f17435d, longArrayList3);
                    return x7;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int y8 = y(bArr, i9, intArrayList4, registers);
                    UnknownFieldSetLite unknownFieldSetLite = extendableMessage.unknownFields;
                    if (unknownFieldSetLite != UnknownFieldSetLite.c()) {
                        obj = unknownFieldSetLite;
                    }
                    UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.z(i12, intArrayList4, generatedExtension.f17435d.c(), obj, unknownFieldSchema);
                    if (unknownFieldSetLite2 != null) {
                        extendableMessage.unknownFields = unknownFieldSetLite2;
                    }
                    fieldSet.C(generatedExtension.f17435d, intArrayList4);
                    return y8;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f17435d.d());
            }
        }
        if (generatedExtension.d() == WireFormat.FieldType.f17685u) {
            i9 = I(bArr, i9, registers);
            if (generatedExtension.f17435d.c().a(registers.f17161a) == null) {
                UnknownFieldSetLite unknownFieldSetLite3 = extendableMessage.unknownFields;
                if (unknownFieldSetLite3 == UnknownFieldSetLite.c()) {
                    unknownFieldSetLite3 = UnknownFieldSetLite.n();
                    extendableMessage.unknownFields = unknownFieldSetLite3;
                }
                SchemaUtil.L(i12, registers.f17161a, unknownFieldSetLite3, unknownFieldSchema);
                return i9;
            }
            obj = Integer.valueOf(registers.f17161a);
        } else {
            switch (AnonymousClass1.f17160a[generatedExtension.d().ordinal()]) {
                case 1:
                    obj = Double.valueOf(d(bArr, i9));
                    i9 += 8;
                    break;
                case 2:
                    obj = Float.valueOf(l(bArr, i9));
                    i9 += 4;
                    break;
                case 3:
                case 4:
                    i9 = L(bArr, i9, registers);
                    obj = Long.valueOf(registers.f17162b);
                    break;
                case 5:
                case 6:
                    i9 = I(bArr, i9, registers);
                    obj = Integer.valueOf(registers.f17161a);
                    break;
                case 7:
                case 8:
                    obj = Long.valueOf(j(bArr, i9));
                    i9 += 8;
                    break;
                case 9:
                case 10:
                    obj = Integer.valueOf(h(bArr, i9));
                    i9 += 4;
                    break;
                case 11:
                    i9 = L(bArr, i9, registers);
                    if (registers.f17162b != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    obj = Boolean.valueOf(z7);
                    break;
                case 12:
                    i9 = I(bArr, i9, registers);
                    obj = Integer.valueOf(CodedInputStream.c(registers.f17161a));
                    break;
                case 13:
                    i9 = L(bArr, i9, registers);
                    obj = Long.valueOf(CodedInputStream.d(registers.f17162b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i9 = b(bArr, i9, registers);
                    obj = registers.f17163c;
                    break;
                case 16:
                    i9 = C(bArr, i9, registers);
                    obj = registers.f17163c;
                    break;
                case 17:
                    i9 = n(Protobuf.a().d(generatedExtension.e().getClass()), bArr, i9, i10, (i12 << 3) | 4, registers);
                    obj = registers.f17163c;
                    break;
                case 18:
                    i9 = p(Protobuf.a().d(generatedExtension.e().getClass()), bArr, i9, i10, registers);
                    obj = registers.f17163c;
                    break;
            }
        }
        if (generatedExtension.g()) {
            fieldSet.a(generatedExtension.f17435d, obj);
        } else {
            int i13 = AnonymousClass1.f17160a[generatedExtension.d().ordinal()];
            if ((i13 == 17 || i13 == 18) && (i11 = fieldSet.i(generatedExtension.f17435d)) != null) {
                obj = Internal.h(i11, obj);
            }
            fieldSet.C(generatedExtension.f17435d, obj);
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i8, byte[] bArr, int i9, int i10, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension a8 = registers.f17164d.a(messageLite, i8 >>> 3);
        if (a8 == null) {
            return G(i8, bArr, i9, i10, MessageSchema.u(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return f(i8, bArr, i9, i10, extendableMessage, a8, unknownFieldSchema, registers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i8) {
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.s0(h(bArr, i9));
        int i11 = i9 + 4;
        while (i11 < i10) {
            int I = I(bArr, i11, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            intArrayList.s0(h(bArr, I));
            i11 = I + 4;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long j(byte[] bArr, int i8) {
        return ((bArr[i8 + 7] & 255) << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.v0(j(bArr, i9));
        int i11 = i9 + 8;
        while (i11 < i10) {
            int I = I(bArr, i11, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            longArrayList.v0(j(bArr, I));
            i11 = I + 8;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float l(byte[] bArr, int i8) {
        return Float.intBitsToFloat(h(bArr, i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.g(l(bArr, i9));
        int i11 = i9 + 4;
        while (i11 < i10) {
            int I = I(bArr, i11, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            floatArrayList.g(l(bArr, I));
            i11 = I + 4;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(Schema schema, byte[] bArr, int i8, int i9, int i10, Registers registers) throws IOException {
        MessageSchema messageSchema = (MessageSchema) schema;
        Object e8 = messageSchema.e();
        int b02 = messageSchema.b0(e8, bArr, i8, i9, i10, registers);
        messageSchema.b(e8);
        registers.f17163c = e8;
        return b02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(Schema schema, int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i11 = (i8 & (-8)) | 4;
        int n8 = n(schema, bArr, i9, i10, i11, registers);
        protobufList.add(registers.f17163c);
        while (n8 < i10) {
            int I = I(bArr, n8, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            n8 = n(schema, bArr, I, i10, i11, registers);
            protobufList.add(registers.f17163c);
        }
        return n8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(Schema schema, byte[] bArr, int i8, int i9, Registers registers) throws IOException {
        int i10 = i8 + 1;
        int i11 = bArr[i8];
        if (i11 < 0) {
            i10 = H(i11, bArr, i10, registers);
            i11 = registers.f17161a;
        }
        int i12 = i10;
        if (i11 >= 0 && i11 <= i9 - i12) {
            Object e8 = schema.e();
            int i13 = i11 + i12;
            schema.h(e8, bArr, i12, i13, registers);
            schema.b(e8);
            registers.f17163c = e8;
            return i13;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(Schema<?> schema, int i8, byte[] bArr, int i9, int i10, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int p8 = p(schema, bArr, i9, i10, registers);
        protobufList.add(registers.f17163c);
        while (p8 < i10) {
            int I = I(bArr, p8, registers);
            if (i8 != registers.f17161a) {
                break;
            }
            p8 = p(schema, bArr, I, i10, registers);
            protobufList.add(registers.f17163c);
        }
        return p8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        boolean z7;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            I = L(bArr, I, registers);
            if (registers.f17162b != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            booleanArrayList.i(z7);
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            doubleArrayList.K0(d(bArr, I));
            I += 8;
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            intArrayList.s0(h(bArr, I));
            I += 4;
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            longArrayList.v0(j(bArr, I));
            I += 8;
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            floatArrayList.g(l(bArr, I));
            I += 4;
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            I = I(bArr, I, registers);
            intArrayList.s0(CodedInputStream.c(registers.f17161a));
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            I = L(bArr, I, registers);
            longArrayList.v0(CodedInputStream.d(registers.f17162b));
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            I = I(bArr, I, registers);
            intArrayList.s0(registers.f17161a);
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(byte[] bArr, int i8, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i8, registers);
        int i9 = registers.f17161a + I;
        while (I < i9) {
            I = L(bArr, I, registers);
            longArrayList.v0(registers.f17162b);
        }
        if (I == i9) {
            return I;
        }
        throw InvalidProtocolBufferException.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Registers {

        /* renamed from: a  reason: collision with root package name */
        public int f17161a;

        /* renamed from: b  reason: collision with root package name */
        public long f17162b;

        /* renamed from: c  reason: collision with root package name */
        public Object f17163c;

        /* renamed from: d  reason: collision with root package name */
        public final ExtensionRegistryLite f17164d;

        Registers() {
            this.f17164d = ExtensionRegistryLite.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.f17164d = extensionRegistryLite;
        }
    }
}
