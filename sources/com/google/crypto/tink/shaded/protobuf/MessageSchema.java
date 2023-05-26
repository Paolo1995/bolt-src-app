package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessageSchema<T> implements Schema<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f15159r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f15160s = UnsafeUtil.B();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f15161a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f15162b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15163c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15164d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f15165e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15166f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f15167g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f15168h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f15169i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f15170j;

    /* renamed from: k  reason: collision with root package name */
    private final int f15171k;

    /* renamed from: l  reason: collision with root package name */
    private final int f15172l;

    /* renamed from: m  reason: collision with root package name */
    private final NewInstanceSchema f15173m;

    /* renamed from: n  reason: collision with root package name */
    private final ListFieldSchema f15174n;

    /* renamed from: o  reason: collision with root package name */
    private final UnknownFieldSchema<?, ?> f15175o;

    /* renamed from: p  reason: collision with root package name */
    private final ExtensionSchema<?> f15176p;

    /* renamed from: q  reason: collision with root package name */
    private final MapFieldSchema f15177q;

    private MessageSchema(int[] iArr, Object[] objArr, int i8, int i9, MessageLite messageLite, boolean z7, boolean z8, int[] iArr2, int i10, int i11, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.f15161a = iArr;
        this.f15162b = objArr;
        this.f15163c = i8;
        this.f15164d = i9;
        this.f15167g = messageLite instanceof GeneratedMessageLite;
        this.f15168h = z7;
        this.f15166f = extensionSchema != null && extensionSchema.e(messageLite);
        this.f15169i = z8;
        this.f15170j = iArr2;
        this.f15171k = i10;
        this.f15172l = i11;
        this.f15173m = newInstanceSchema;
        this.f15174n = listFieldSchema;
        this.f15175o = unknownFieldSchema;
        this.f15176p = extensionSchema;
        this.f15165e = messageLite;
        this.f15177q = mapFieldSchema;
    }

    private boolean A(T t7, int i8, int i9, int i10) {
        if (this.f15168h) {
            return z(t7, i8);
        }
        if ((i9 & i10) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean B(Object obj, int i8, Schema schema) {
        return schema.c(UnsafeUtil.A(obj, S(i8)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean C(Object obj, int i8, int i9) {
        List list = (List) UnsafeUtil.A(obj, S(i8));
        if (list.isEmpty()) {
            return true;
        }
        Schema s7 = s(i9);
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!s7.c(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private boolean D(T t7, int i8, int i9) {
        if (this.f15177q.e(UnsafeUtil.A(t7, S(i8))).isEmpty()) {
            return true;
        }
        this.f15177q.b(r(i9));
        throw null;
    }

    private boolean E(T t7, T t8, int i8) {
        long f02 = f0(i8) & 1048575;
        if (UnsafeUtil.x(t7, f02) == UnsafeUtil.x(t8, f02)) {
            return true;
        }
        return false;
    }

    private boolean F(T t7, int i8, int i9) {
        if (UnsafeUtil.x(t7, f0(i9) & 1048575) == i8) {
            return true;
        }
        return false;
    }

    private static boolean G(int i8) {
        return (i8 & 268435456) != 0;
    }

    private static List<?> H(Object obj, long j8) {
        return (List) UnsafeUtil.A(obj, j8);
    }

    private static <T> long I(T t7, long j8) {
        return UnsafeUtil.y(t7, j8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
        r0 = r16.f15171k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (r0 >= r16.f15172l) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        r13 = n(r19, r16.f15170j[r0], r13, r17);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
        if (r13 == null) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
        r17.o(r19, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <UT, UB, ET extends com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite<ET>> void J(com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<UT, UB> r17, com.google.crypto.tink.shaded.protobuf.ExtensionSchema<ET> r18, T r19, com.google.crypto.tink.shaded.protobuf.Reader r20, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.J(com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ExtensionSchema, java.lang.Object, com.google.crypto.tink.shaded.protobuf.Reader, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void K(Object obj, int i8, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long S = S(p0(i8));
        Object A = UnsafeUtil.A(obj, S);
        if (A == null) {
            A = this.f15177q.d(obj2);
            UnsafeUtil.O(obj, S, A);
        } else if (this.f15177q.h(A)) {
            Object d8 = this.f15177q.d(obj2);
            this.f15177q.a(d8, A);
            UnsafeUtil.O(obj, S, d8);
            A = d8;
        }
        Map<?, ?> c8 = this.f15177q.c(A);
        this.f15177q.b(obj2);
        reader.L(c8, null, extensionRegistryLite);
    }

    private void L(T t7, T t8, int i8) {
        long S = S(p0(i8));
        if (!z(t8, i8)) {
            return;
        }
        Object A = UnsafeUtil.A(t7, S);
        Object A2 = UnsafeUtil.A(t8, S);
        if (A != null && A2 != null) {
            UnsafeUtil.O(t7, S, Internal.h(A, A2));
            l0(t7, i8);
        } else if (A2 != null) {
            UnsafeUtil.O(t7, S, A2);
            l0(t7, i8);
        }
    }

    private void M(T t7, T t8, int i8) {
        int p02 = p0(i8);
        int R = R(i8);
        long S = S(p02);
        if (!F(t8, R, i8)) {
            return;
        }
        Object A = UnsafeUtil.A(t7, S);
        Object A2 = UnsafeUtil.A(t8, S);
        if (A != null && A2 != null) {
            UnsafeUtil.O(t7, S, Internal.h(A, A2));
            m0(t7, R, i8);
        } else if (A2 != null) {
            UnsafeUtil.O(t7, S, A2);
            m0(t7, R, i8);
        }
    }

    private void N(T t7, T t8, int i8) {
        int p02 = p0(i8);
        long S = S(p02);
        int R = R(i8);
        switch (o0(p02)) {
            case 0:
                if (z(t8, i8)) {
                    UnsafeUtil.K(t7, S, UnsafeUtil.v(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 1:
                if (z(t8, i8)) {
                    UnsafeUtil.L(t7, S, UnsafeUtil.w(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 2:
                if (z(t8, i8)) {
                    UnsafeUtil.N(t7, S, UnsafeUtil.y(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 3:
                if (z(t8, i8)) {
                    UnsafeUtil.N(t7, S, UnsafeUtil.y(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 4:
                if (z(t8, i8)) {
                    UnsafeUtil.M(t7, S, UnsafeUtil.x(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 5:
                if (z(t8, i8)) {
                    UnsafeUtil.N(t7, S, UnsafeUtil.y(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 6:
                if (z(t8, i8)) {
                    UnsafeUtil.M(t7, S, UnsafeUtil.x(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 7:
                if (z(t8, i8)) {
                    UnsafeUtil.E(t7, S, UnsafeUtil.p(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 8:
                if (z(t8, i8)) {
                    UnsafeUtil.O(t7, S, UnsafeUtil.A(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 9:
                L(t7, t8, i8);
                return;
            case 10:
                if (z(t8, i8)) {
                    UnsafeUtil.O(t7, S, UnsafeUtil.A(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 11:
                if (z(t8, i8)) {
                    UnsafeUtil.M(t7, S, UnsafeUtil.x(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 12:
                if (z(t8, i8)) {
                    UnsafeUtil.M(t7, S, UnsafeUtil.x(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 13:
                if (z(t8, i8)) {
                    UnsafeUtil.M(t7, S, UnsafeUtil.x(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 14:
                if (z(t8, i8)) {
                    UnsafeUtil.N(t7, S, UnsafeUtil.y(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 15:
                if (z(t8, i8)) {
                    UnsafeUtil.M(t7, S, UnsafeUtil.x(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 16:
                if (z(t8, i8)) {
                    UnsafeUtil.N(t7, S, UnsafeUtil.y(t8, S));
                    l0(t7, i8);
                    return;
                }
                return;
            case 17:
                L(t7, t8, i8);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f15174n.d(t7, t8, S);
                return;
            case 50:
                SchemaUtil.F(this.f15177q, t7, t8, S);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (F(t8, R, i8)) {
                    UnsafeUtil.O(t7, S, UnsafeUtil.A(t8, S));
                    m0(t7, R, i8);
                    return;
                }
                return;
            case 60:
                M(t7, t8, i8);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (F(t8, R, i8)) {
                    UnsafeUtil.O(t7, S, UnsafeUtil.A(t8, S));
                    m0(t7, R, i8);
                    return;
                }
                return;
            case 68:
                M(t7, t8, i8);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSchema<T> O(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return Q((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return P((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> P(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        boolean z7;
        if (structuralMessageInfo.c() == ProtoSyntax.PROTO3) {
            z7 = true;
        } else {
            z7 = false;
        }
        FieldInfo[] e8 = structuralMessageInfo.e();
        if (e8.length == 0) {
            int length = e8.length;
            int[] iArr = new int[length * 3];
            Object[] objArr = new Object[length * 2];
            if (e8.length <= 0) {
                int[] d8 = structuralMessageInfo.d();
                if (d8 == null) {
                    d8 = f15159r;
                }
                if (e8.length <= 0) {
                    int[] iArr2 = f15159r;
                    int[] iArr3 = f15159r;
                    int[] iArr4 = new int[d8.length + iArr2.length + iArr3.length];
                    System.arraycopy(d8, 0, iArr4, 0, d8.length);
                    System.arraycopy(iArr2, 0, iArr4, d8.length, iArr2.length);
                    System.arraycopy(iArr3, 0, iArr4, d8.length + iArr2.length, iArr3.length);
                    return new MessageSchema<>(iArr, objArr, 0, 0, structuralMessageInfo.b(), z7, true, iArr4, d8.length, d8.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
                }
                FieldInfo fieldInfo = e8[0];
                throw null;
            }
            FieldInfo fieldInfo2 = e8[0];
            throw null;
        }
        FieldInfo fieldInfo3 = e8[0];
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x039f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.crypto.tink.shaded.protobuf.MessageSchema<T> Q(com.google.crypto.tink.shaded.protobuf.RawMessageInfo r36, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema r37, com.google.crypto.tink.shaded.protobuf.ListFieldSchema r38, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r39, com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r40, com.google.crypto.tink.shaded.protobuf.MapFieldSchema r41) {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.Q(com.google.crypto.tink.shaded.protobuf.RawMessageInfo, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema, com.google.crypto.tink.shaded.protobuf.ListFieldSchema, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ExtensionSchema, com.google.crypto.tink.shaded.protobuf.MapFieldSchema):com.google.crypto.tink.shaded.protobuf.MessageSchema");
    }

    private int R(int i8) {
        return this.f15161a[i8];
    }

    private static long S(int i8) {
        return i8 & 1048575;
    }

    private static <T> boolean T(T t7, long j8) {
        return ((Boolean) UnsafeUtil.A(t7, j8)).booleanValue();
    }

    private static <T> double U(T t7, long j8) {
        return ((Double) UnsafeUtil.A(t7, j8)).doubleValue();
    }

    private static <T> float V(T t7, long j8) {
        return ((Float) UnsafeUtil.A(t7, j8)).floatValue();
    }

    private static <T> int W(T t7, long j8) {
        return ((Integer) UnsafeUtil.A(t7, j8)).intValue();
    }

    private static <T> long X(T t7, long j8) {
        return ((Long) UnsafeUtil.A(t7, j8)).longValue();
    }

    private <K, V> int Y(T t7, byte[] bArr, int i8, int i9, int i10, long j8, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f15160s;
        Object r7 = r(i10);
        Object object = unsafe.getObject(t7, j8);
        if (this.f15177q.h(object)) {
            Object d8 = this.f15177q.d(r7);
            this.f15177q.a(d8, object);
            unsafe.putObject(t7, j8, d8);
            object = d8;
        }
        this.f15177q.b(r7);
        return k(bArr, i8, i9, null, this.f15177q.c(object), registers);
    }

    private int Z(T t7, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j8, int i15, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f15160s;
        long j9 = this.f15161a[i15 + 2] & 1048575;
        switch (i14) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(t7, j8, Double.valueOf(ArrayDecoders.d(bArr, i8)));
                    int i16 = i8 + 8;
                    unsafe.putInt(t7, j9, i11);
                    return i16;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(t7, j8, Float.valueOf(ArrayDecoders.l(bArr, i8)));
                    int i17 = i8 + 4;
                    unsafe.putInt(t7, j9, i11);
                    return i17;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int L = ArrayDecoders.L(bArr, i8, registers);
                    unsafe.putObject(t7, j8, Long.valueOf(registers.f14976b));
                    unsafe.putInt(t7, j9, i11);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int I = ArrayDecoders.I(bArr, i8, registers);
                    unsafe.putObject(t7, j8, Integer.valueOf(registers.f14975a));
                    unsafe.putInt(t7, j9, i11);
                    return I;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(t7, j8, Long.valueOf(ArrayDecoders.j(bArr, i8)));
                    int i18 = i8 + 8;
                    unsafe.putInt(t7, j9, i11);
                    return i18;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(t7, j8, Integer.valueOf(ArrayDecoders.h(bArr, i8)));
                    int i19 = i8 + 4;
                    unsafe.putInt(t7, j9, i11);
                    return i19;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int L2 = ArrayDecoders.L(bArr, i8, registers);
                    unsafe.putObject(t7, j8, Boolean.valueOf(registers.f14976b != 0));
                    unsafe.putInt(t7, j9, i11);
                    return L2;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int I2 = ArrayDecoders.I(bArr, i8, registers);
                    int i20 = registers.f14975a;
                    if (i20 == 0) {
                        unsafe.putObject(t7, j8, "");
                    } else if ((i13 & 536870912) != 0 && !Utf8.n(bArr, I2, I2 + i20)) {
                        throw InvalidProtocolBufferException.c();
                    } else {
                        unsafe.putObject(t7, j8, new String(bArr, I2, i20, Internal.f15115a));
                        I2 += i20;
                    }
                    unsafe.putInt(t7, j9, i11);
                    return I2;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int p8 = ArrayDecoders.p(s(i15), bArr, i8, i9, registers);
                    Object object = unsafe.getInt(t7, j9) == i11 ? unsafe.getObject(t7, j8) : null;
                    if (object == null) {
                        unsafe.putObject(t7, j8, registers.f14977c);
                    } else {
                        unsafe.putObject(t7, j8, Internal.h(object, registers.f14977c));
                    }
                    unsafe.putInt(t7, j9, i11);
                    return p8;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int b8 = ArrayDecoders.b(bArr, i8, registers);
                    unsafe.putObject(t7, j8, registers.f14977c);
                    unsafe.putInt(t7, j9, i11);
                    return b8;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int I3 = ArrayDecoders.I(bArr, i8, registers);
                    int i21 = registers.f14975a;
                    Internal.EnumVerifier q8 = q(i15);
                    if (q8 != null && !q8.a(i21)) {
                        t(t7).n(i10, Long.valueOf(i21));
                    } else {
                        unsafe.putObject(t7, j8, Integer.valueOf(i21));
                        unsafe.putInt(t7, j9, i11);
                    }
                    return I3;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int I4 = ArrayDecoders.I(bArr, i8, registers);
                    unsafe.putObject(t7, j8, Integer.valueOf(CodedInputStream.b(registers.f14975a)));
                    unsafe.putInt(t7, j9, i11);
                    return I4;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int L3 = ArrayDecoders.L(bArr, i8, registers);
                    unsafe.putObject(t7, j8, Long.valueOf(CodedInputStream.c(registers.f14976b)));
                    unsafe.putInt(t7, j9, i11);
                    return L3;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int n8 = ArrayDecoders.n(s(i15), bArr, i8, i9, (i10 & (-8)) | 4, registers);
                    Object object2 = unsafe.getInt(t7, j9) == i11 ? unsafe.getObject(t7, j8) : null;
                    if (object2 == null) {
                        unsafe.putObject(t7, j8, registers.f14977c);
                    } else {
                        unsafe.putObject(t7, j8, Internal.h(object2, registers.f14977c));
                    }
                    unsafe.putInt(t7, j9, i11);
                    return n8;
                }
                break;
        }
        return i8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0229, code lost:
        if (r0 != r15) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x022c, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01dc, code lost:
        if (r0 != r15) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x020a, code lost:
        if (r0 != r15) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b0(T r28, byte[] r29, int r30, int r31, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.b0(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    private int c0(T t7, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, long j8, int i14, long j9, ArrayDecoders.Registers registers) throws IOException {
        int J;
        Unsafe unsafe = f15160s;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t7, j9);
        if (!protobufList.h()) {
            int size = protobufList.size();
            protobufList = protobufList.a(size == 0 ? 10 : size * 2);
            unsafe.putObject(t7, j9, protobufList);
        }
        switch (i14) {
            case 18:
            case 35:
                if (i12 == 2) {
                    return ArrayDecoders.s(bArr, i8, protobufList, registers);
                }
                if (i12 == 1) {
                    return ArrayDecoders.e(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i12 == 2) {
                    return ArrayDecoders.v(bArr, i8, protobufList, registers);
                }
                if (i12 == 5) {
                    return ArrayDecoders.m(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    return ArrayDecoders.z(bArr, i8, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.M(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i12 == 2) {
                    return ArrayDecoders.y(bArr, i8, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.J(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i12 == 2) {
                    return ArrayDecoders.u(bArr, i8, protobufList, registers);
                }
                if (i12 == 1) {
                    return ArrayDecoders.k(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i12 == 2) {
                    return ArrayDecoders.t(bArr, i8, protobufList, registers);
                }
                if (i12 == 5) {
                    return ArrayDecoders.i(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i12 == 2) {
                    return ArrayDecoders.r(bArr, i8, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.a(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 26:
                if (i12 == 2) {
                    if ((j8 & 536870912) == 0) {
                        return ArrayDecoders.D(i10, bArr, i8, i9, protobufList, registers);
                    }
                    return ArrayDecoders.E(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 27:
                if (i12 == 2) {
                    return ArrayDecoders.q(s(i13), i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 28:
                if (i12 == 2) {
                    return ArrayDecoders.c(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i12 == 2) {
                    J = ArrayDecoders.y(bArr, i8, protobufList, registers);
                } else if (i12 == 0) {
                    J = ArrayDecoders.J(i10, bArr, i8, i9, protobufList, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t7;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.e()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.A(i11, protobufList, q(i13), unknownFieldSetLite, this.f15175o);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return J;
            case 33:
            case 47:
                if (i12 == 2) {
                    return ArrayDecoders.w(bArr, i8, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.A(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i12 == 2) {
                    return ArrayDecoders.x(bArr, i8, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.B(i10, bArr, i8, i9, protobufList, registers);
                }
                break;
            case 49:
                if (i12 == 3) {
                    return ArrayDecoders.o(s(i13), i10, bArr, i8, i9, protobufList, registers);
                }
                break;
        }
        return i8;
    }

    private int d0(int i8) {
        if (i8 >= this.f15163c && i8 <= this.f15164d) {
            return n0(i8, 0);
        }
        return -1;
    }

    private int e0(int i8, int i9) {
        if (i8 >= this.f15163c && i8 <= this.f15164d) {
            return n0(i8, i9);
        }
        return -1;
    }

    private int f0(int i8) {
        return this.f15161a[i8 + 2];
    }

    private <E> void g0(Object obj, long j8, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.P(this.f15174n.e(obj, j8), schema, extensionRegistryLite);
    }

    private <E> void h0(Object obj, int i8, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.M(this.f15174n.e(obj, S(i8)), schema, extensionRegistryLite);
    }

    private boolean i(T t7, T t8, int i8) {
        if (z(t7, i8) == z(t8, i8)) {
            return true;
        }
        return false;
    }

    private void i0(Object obj, int i8, Reader reader) throws IOException {
        if (y(i8)) {
            UnsafeUtil.O(obj, S(i8), reader.I());
        } else if (this.f15167g) {
            UnsafeUtil.O(obj, S(i8), reader.z());
        } else {
            UnsafeUtil.O(obj, S(i8), reader.o());
        }
    }

    private static <T> boolean j(T t7, long j8) {
        return UnsafeUtil.p(t7, j8);
    }

    private void j0(Object obj, int i8, Reader reader) throws IOException {
        if (y(i8)) {
            reader.n(this.f15174n.e(obj, S(i8)));
        } else {
            reader.B(this.f15174n.e(obj, S(i8)));
        }
    }

    private <K, V> int k(byte[] bArr, int i8, int i9, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int I = ArrayDecoders.I(bArr, i8, registers);
        int i10 = registers.f14975a;
        if (i10 >= 0 && i10 <= i9 - I) {
            throw null;
        }
        throw InvalidProtocolBufferException.j();
    }

    private static Field k0(Class<?> cls, String str) {
        Field[] declaredFields;
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static <T> double l(T t7, long j8) {
        return UnsafeUtil.v(t7, j8);
    }

    private void l0(T t7, int i8) {
        if (this.f15168h) {
            return;
        }
        int f02 = f0(i8);
        long j8 = f02 & 1048575;
        UnsafeUtil.M(t7, j8, UnsafeUtil.x(t7, j8) | (1 << (f02 >>> 20)));
    }

    private boolean m(T t7, T t8, int i8) {
        int p02 = p0(i8);
        long S = S(p02);
        switch (o0(p02)) {
            case 0:
                if (!i(t7, t8, i8) || Double.doubleToLongBits(UnsafeUtil.v(t7, S)) != Double.doubleToLongBits(UnsafeUtil.v(t8, S))) {
                    return false;
                }
                return true;
            case 1:
                if (!i(t7, t8, i8) || Float.floatToIntBits(UnsafeUtil.w(t7, S)) != Float.floatToIntBits(UnsafeUtil.w(t8, S))) {
                    return false;
                }
                return true;
            case 2:
                if (!i(t7, t8, i8) || UnsafeUtil.y(t7, S) != UnsafeUtil.y(t8, S)) {
                    return false;
                }
                return true;
            case 3:
                if (!i(t7, t8, i8) || UnsafeUtil.y(t7, S) != UnsafeUtil.y(t8, S)) {
                    return false;
                }
                return true;
            case 4:
                if (!i(t7, t8, i8) || UnsafeUtil.x(t7, S) != UnsafeUtil.x(t8, S)) {
                    return false;
                }
                return true;
            case 5:
                if (!i(t7, t8, i8) || UnsafeUtil.y(t7, S) != UnsafeUtil.y(t8, S)) {
                    return false;
                }
                return true;
            case 6:
                if (!i(t7, t8, i8) || UnsafeUtil.x(t7, S) != UnsafeUtil.x(t8, S)) {
                    return false;
                }
                return true;
            case 7:
                if (!i(t7, t8, i8) || UnsafeUtil.p(t7, S) != UnsafeUtil.p(t8, S)) {
                    return false;
                }
                return true;
            case 8:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.A(t7, S), UnsafeUtil.A(t8, S))) {
                    return false;
                }
                return true;
            case 9:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.A(t7, S), UnsafeUtil.A(t8, S))) {
                    return false;
                }
                return true;
            case 10:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.A(t7, S), UnsafeUtil.A(t8, S))) {
                    return false;
                }
                return true;
            case 11:
                if (!i(t7, t8, i8) || UnsafeUtil.x(t7, S) != UnsafeUtil.x(t8, S)) {
                    return false;
                }
                return true;
            case 12:
                if (!i(t7, t8, i8) || UnsafeUtil.x(t7, S) != UnsafeUtil.x(t8, S)) {
                    return false;
                }
                return true;
            case 13:
                if (!i(t7, t8, i8) || UnsafeUtil.x(t7, S) != UnsafeUtil.x(t8, S)) {
                    return false;
                }
                return true;
            case 14:
                if (!i(t7, t8, i8) || UnsafeUtil.y(t7, S) != UnsafeUtil.y(t8, S)) {
                    return false;
                }
                return true;
            case 15:
                if (!i(t7, t8, i8) || UnsafeUtil.x(t7, S) != UnsafeUtil.x(t8, S)) {
                    return false;
                }
                return true;
            case 16:
                if (!i(t7, t8, i8) || UnsafeUtil.y(t7, S) != UnsafeUtil.y(t8, S)) {
                    return false;
                }
                return true;
            case 17:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.A(t7, S), UnsafeUtil.A(t8, S))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.K(UnsafeUtil.A(t7, S), UnsafeUtil.A(t8, S));
            case 50:
                return SchemaUtil.K(UnsafeUtil.A(t7, S), UnsafeUtil.A(t8, S));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!E(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.A(t7, S), UnsafeUtil.A(t8, S))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private void m0(T t7, int i8, int i9) {
        UnsafeUtil.M(t7, f0(i9) & 1048575, i8);
    }

    private final <UT, UB> UB n(Object obj, int i8, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        int R = R(i8);
        Object A = UnsafeUtil.A(obj, S(p0(i8)));
        if (A == null) {
            return ub;
        }
        Internal.EnumVerifier q8 = q(i8);
        if (q8 == null) {
            return ub;
        }
        return (UB) o(i8, R, this.f15177q.c(A), q8, ub, unknownFieldSchema);
    }

    private int n0(int i8, int i9) {
        int length = (this.f15161a.length / 3) - 1;
        while (i9 <= length) {
            int i10 = (length + i9) >>> 1;
            int i11 = i10 * 3;
            int R = R(i11);
            if (i8 == R) {
                return i11;
            }
            if (i8 < R) {
                length = i10 - 1;
            } else {
                i9 = i10 + 1;
            }
        }
        return -1;
    }

    private final <K, V, UT, UB> UB o(int i8, int i9, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        this.f15177q.b(r(i8));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.n();
                }
                ByteString.CodedBuilder s7 = ByteString.s(MapEntryLite.b(null, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.d(s7.b(), null, next.getKey(), next.getValue());
                    unknownFieldSchema.d(ub, i9, s7.a());
                    it.remove();
                } catch (IOException e8) {
                    throw new RuntimeException(e8);
                }
            }
        }
        return ub;
    }

    private static int o0(int i8) {
        return (i8 & 267386880) >>> 20;
    }

    private static <T> float p(T t7, long j8) {
        return UnsafeUtil.w(t7, j8);
    }

    private int p0(int i8) {
        return this.f15161a[i8 + 1];
    }

    private Internal.EnumVerifier q(int i8) {
        return (Internal.EnumVerifier) this.f15162b[((i8 / 3) * 2) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x049e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void q0(T r18, com.google.crypto.tink.shaded.protobuf.Writer r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.q0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    private Object r(int i8) {
        return this.f15162b[(i8 / 3) * 2];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0588  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r0(T r13, com.google.crypto.tink.shaded.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.r0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    private Schema s(int i8) {
        int i9 = (i8 / 3) * 2;
        Schema schema = (Schema) this.f15162b[i9];
        if (schema != null) {
            return schema;
        }
        Schema<T> d8 = Protobuf.a().d((Class) this.f15162b[i9 + 1]);
        this.f15162b[i9] = d8;
        return d8;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x058e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s0(T r11, com.google.crypto.tink.shaded.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.s0(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite t(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.e()) {
            UnknownFieldSetLite l8 = UnknownFieldSetLite.l();
            generatedMessageLite.unknownFields = l8;
            return l8;
        }
        return unknownFieldSetLite;
    }

    private <K, V> void t0(Writer writer, int i8, Object obj, int i9) throws IOException {
        if (obj != null) {
            this.f15177q.b(r(i9));
            writer.J(i8, null, this.f15177q.e(obj));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int u(T t7) {
        int i8;
        int i9;
        int i10;
        int d8;
        int K;
        int i11;
        int U;
        int W;
        Unsafe unsafe = f15160s;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < this.f15161a.length) {
            int p02 = p0(i13);
            int R = R(i13);
            int o02 = o0(p02);
            if (o02 <= 17) {
                i8 = this.f15161a[i13 + 2];
                int i16 = 1048575 & i8;
                int i17 = 1 << (i8 >>> 20);
                if (i16 != i12) {
                    i15 = unsafe.getInt(t7, i16);
                    i12 = i16;
                }
                i9 = i17;
            } else {
                if (this.f15169i && o02 >= FieldType.T.a() && o02 <= FieldType.f15054g0.a()) {
                    i8 = this.f15161a[i13 + 2] & 1048575;
                } else {
                    i8 = 0;
                }
                i9 = 0;
            }
            long S = S(p02);
            int i18 = i12;
            switch (o02) {
                case 0:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        i10 = CodedOutputStream.i(R, 0.0d);
                        i14 += i10;
                        break;
                    }
                case 1:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        i10 = CodedOutputStream.q(R, 0.0f);
                        i14 += i10;
                        break;
                    }
                case 2:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        i10 = CodedOutputStream.x(R, unsafe.getLong(t7, S));
                        i14 += i10;
                        break;
                    }
                case 3:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        i10 = CodedOutputStream.X(R, unsafe.getLong(t7, S));
                        i14 += i10;
                        break;
                    }
                case 4:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        i10 = CodedOutputStream.v(R, unsafe.getInt(t7, S));
                        i14 += i10;
                        break;
                    }
                case 5:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        i10 = CodedOutputStream.o(R, 0L);
                        i14 += i10;
                        break;
                    }
                case 6:
                    if ((i15 & i9) != 0) {
                        i10 = CodedOutputStream.m(R, 0);
                        i14 += i10;
                        break;
                    }
                    break;
                case 7:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.d(R, true);
                        i14 += d8;
                    }
                    break;
                case 8:
                    if ((i15 & i9) != 0) {
                        Object object = unsafe.getObject(t7, S);
                        if (object instanceof ByteString) {
                            d8 = CodedOutputStream.g(R, (ByteString) object);
                        } else {
                            d8 = CodedOutputStream.S(R, (String) object);
                        }
                        i14 += d8;
                    }
                    break;
                case 9:
                    if ((i15 & i9) != 0) {
                        d8 = SchemaUtil.o(R, unsafe.getObject(t7, S), s(i13));
                        i14 += d8;
                    }
                    break;
                case 10:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.g(R, (ByteString) unsafe.getObject(t7, S));
                        i14 += d8;
                    }
                    break;
                case 11:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.V(R, unsafe.getInt(t7, S));
                        i14 += d8;
                    }
                    break;
                case 12:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.k(R, unsafe.getInt(t7, S));
                        i14 += d8;
                    }
                    break;
                case 13:
                    if ((i15 & i9) != 0) {
                        K = CodedOutputStream.K(R, 0);
                        i14 += K;
                    }
                    break;
                case 14:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.M(R, 0L);
                        i14 += d8;
                    }
                    break;
                case 15:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.O(R, unsafe.getInt(t7, S));
                        i14 += d8;
                    }
                    break;
                case 16:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.Q(R, unsafe.getLong(t7, S));
                        i14 += d8;
                    }
                    break;
                case 17:
                    if ((i15 & i9) != 0) {
                        d8 = CodedOutputStream.s(R, (MessageLite) unsafe.getObject(t7, S), s(i13));
                        i14 += d8;
                    }
                    break;
                case 18:
                    d8 = SchemaUtil.h(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 19:
                    d8 = SchemaUtil.f(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 20:
                    d8 = SchemaUtil.m(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 21:
                    d8 = SchemaUtil.x(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 22:
                    d8 = SchemaUtil.k(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 23:
                    d8 = SchemaUtil.h(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 24:
                    d8 = SchemaUtil.f(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 25:
                    d8 = SchemaUtil.a(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 26:
                    d8 = SchemaUtil.u(R, (List) unsafe.getObject(t7, S));
                    i14 += d8;
                    break;
                case 27:
                    d8 = SchemaUtil.p(R, (List) unsafe.getObject(t7, S), s(i13));
                    i14 += d8;
                    break;
                case 28:
                    d8 = SchemaUtil.c(R, (List) unsafe.getObject(t7, S));
                    i14 += d8;
                    break;
                case 29:
                    d8 = SchemaUtil.v(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 30:
                    d8 = SchemaUtil.d(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 31:
                    d8 = SchemaUtil.f(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 32:
                    d8 = SchemaUtil.h(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 33:
                    d8 = SchemaUtil.q(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 34:
                    d8 = SchemaUtil.s(R, (List) unsafe.getObject(t7, S), false);
                    i14 += d8;
                    break;
                case 35:
                    i11 = SchemaUtil.i((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 36:
                    i11 = SchemaUtil.g((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 37:
                    i11 = SchemaUtil.n((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 38:
                    i11 = SchemaUtil.y((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 39:
                    i11 = SchemaUtil.l((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 40:
                    i11 = SchemaUtil.i((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 41:
                    i11 = SchemaUtil.g((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 42:
                    i11 = SchemaUtil.b((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 43:
                    i11 = SchemaUtil.w((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 44:
                    i11 = SchemaUtil.e((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 45:
                    i11 = SchemaUtil.g((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 46:
                    i11 = SchemaUtil.i((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 47:
                    i11 = SchemaUtil.r((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 48:
                    i11 = SchemaUtil.t((List) unsafe.getObject(t7, S));
                    if (i11 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i11);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i11);
                        K = U + W + i11;
                        i14 += K;
                    }
                    break;
                case 49:
                    d8 = SchemaUtil.j(R, (List) unsafe.getObject(t7, S), s(i13));
                    i14 += d8;
                    break;
                case 50:
                    d8 = this.f15177q.g(R, unsafe.getObject(t7, S), r(i13));
                    i14 += d8;
                    break;
                case 51:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.i(R, 0.0d);
                        i14 += d8;
                    }
                    break;
                case 52:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.q(R, 0.0f);
                        i14 += d8;
                    }
                    break;
                case 53:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.x(R, X(t7, S));
                        i14 += d8;
                    }
                    break;
                case 54:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.X(R, X(t7, S));
                        i14 += d8;
                    }
                    break;
                case 55:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.v(R, W(t7, S));
                        i14 += d8;
                    }
                    break;
                case 56:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.o(R, 0L);
                        i14 += d8;
                    }
                    break;
                case 57:
                    if (F(t7, R, i13)) {
                        K = CodedOutputStream.m(R, 0);
                        i14 += K;
                    }
                    break;
                case 58:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.d(R, true);
                        i14 += d8;
                    }
                    break;
                case 59:
                    if (F(t7, R, i13)) {
                        Object object2 = unsafe.getObject(t7, S);
                        if (object2 instanceof ByteString) {
                            d8 = CodedOutputStream.g(R, (ByteString) object2);
                        } else {
                            d8 = CodedOutputStream.S(R, (String) object2);
                        }
                        i14 += d8;
                    }
                    break;
                case 60:
                    if (F(t7, R, i13)) {
                        d8 = SchemaUtil.o(R, unsafe.getObject(t7, S), s(i13));
                        i14 += d8;
                    }
                    break;
                case 61:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.g(R, (ByteString) unsafe.getObject(t7, S));
                        i14 += d8;
                    }
                    break;
                case 62:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.V(R, W(t7, S));
                        i14 += d8;
                    }
                    break;
                case 63:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.k(R, W(t7, S));
                        i14 += d8;
                    }
                    break;
                case 64:
                    if (F(t7, R, i13)) {
                        K = CodedOutputStream.K(R, 0);
                        i14 += K;
                    }
                    break;
                case 65:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.M(R, 0L);
                        i14 += d8;
                    }
                    break;
                case 66:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.O(R, W(t7, S));
                        i14 += d8;
                    }
                    break;
                case 67:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.Q(R, X(t7, S));
                        i14 += d8;
                    }
                    break;
                case 68:
                    if (F(t7, R, i13)) {
                        d8 = CodedOutputStream.s(R, (MessageLite) unsafe.getObject(t7, S), s(i13));
                        i14 += d8;
                    }
                    break;
            }
            i13 += 3;
            i12 = i18;
        }
        int w7 = i14 + w(this.f15175o, t7);
        if (this.f15166f) {
            return w7 + this.f15176p.c(t7).l();
        }
        return w7;
    }

    private void u0(int i8, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.e(i8, (String) obj);
        } else {
            writer.M(i8, (ByteString) obj);
        }
    }

    private int v(T t7) {
        int i8;
        int i9;
        int i10;
        int U;
        int W;
        Unsafe unsafe = f15160s;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f15161a.length; i12 += 3) {
            int p02 = p0(i12);
            int o02 = o0(p02);
            int R = R(i12);
            long S = S(p02);
            if (o02 >= FieldType.T.a() && o02 <= FieldType.f15054g0.a()) {
                i8 = this.f15161a[i12 + 2] & 1048575;
            } else {
                i8 = 0;
            }
            switch (o02) {
                case 0:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.i(R, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.q(R, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.x(R, UnsafeUtil.y(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.X(R, UnsafeUtil.y(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.v(R, UnsafeUtil.x(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.o(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.m(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.d(R, true);
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (z(t7, i12)) {
                        Object A = UnsafeUtil.A(t7, S);
                        if (A instanceof ByteString) {
                            i9 = CodedOutputStream.g(R, (ByteString) A);
                            break;
                        } else {
                            i9 = CodedOutputStream.S(R, (String) A);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if (z(t7, i12)) {
                        i9 = SchemaUtil.o(R, UnsafeUtil.A(t7, S), s(i12));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.g(R, (ByteString) UnsafeUtil.A(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 11:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.V(R, UnsafeUtil.x(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 12:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.k(R, UnsafeUtil.x(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.K(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.M(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.O(R, UnsafeUtil.x(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.Q(R, UnsafeUtil.y(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if (z(t7, i12)) {
                        i9 = CodedOutputStream.s(R, (MessageLite) UnsafeUtil.A(t7, S), s(i12));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    i9 = SchemaUtil.h(R, H(t7, S), false);
                    break;
                case 19:
                    i9 = SchemaUtil.f(R, H(t7, S), false);
                    break;
                case 20:
                    i9 = SchemaUtil.m(R, H(t7, S), false);
                    break;
                case 21:
                    i9 = SchemaUtil.x(R, H(t7, S), false);
                    break;
                case 22:
                    i9 = SchemaUtil.k(R, H(t7, S), false);
                    break;
                case 23:
                    i9 = SchemaUtil.h(R, H(t7, S), false);
                    break;
                case 24:
                    i9 = SchemaUtil.f(R, H(t7, S), false);
                    break;
                case 25:
                    i9 = SchemaUtil.a(R, H(t7, S), false);
                    break;
                case 26:
                    i9 = SchemaUtil.u(R, H(t7, S));
                    break;
                case 27:
                    i9 = SchemaUtil.p(R, H(t7, S), s(i12));
                    break;
                case 28:
                    i9 = SchemaUtil.c(R, H(t7, S));
                    break;
                case 29:
                    i9 = SchemaUtil.v(R, H(t7, S), false);
                    break;
                case 30:
                    i9 = SchemaUtil.d(R, H(t7, S), false);
                    break;
                case 31:
                    i9 = SchemaUtil.f(R, H(t7, S), false);
                    break;
                case 32:
                    i9 = SchemaUtil.h(R, H(t7, S), false);
                    break;
                case 33:
                    i9 = SchemaUtil.q(R, H(t7, S), false);
                    break;
                case 34:
                    i9 = SchemaUtil.s(R, H(t7, S), false);
                    break;
                case 35:
                    i10 = SchemaUtil.i((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 36:
                    i10 = SchemaUtil.g((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 37:
                    i10 = SchemaUtil.n((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 38:
                    i10 = SchemaUtil.y((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 39:
                    i10 = SchemaUtil.l((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 40:
                    i10 = SchemaUtil.i((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 41:
                    i10 = SchemaUtil.g((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 42:
                    i10 = SchemaUtil.b((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 43:
                    i10 = SchemaUtil.w((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 44:
                    i10 = SchemaUtil.e((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 45:
                    i10 = SchemaUtil.g((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 46:
                    i10 = SchemaUtil.i((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 47:
                    i10 = SchemaUtil.r((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 48:
                    i10 = SchemaUtil.t((List) unsafe.getObject(t7, S));
                    if (i10 > 0) {
                        if (this.f15169i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        U = CodedOutputStream.U(R);
                        W = CodedOutputStream.W(i10);
                        i9 = U + W + i10;
                        break;
                    } else {
                        continue;
                    }
                case 49:
                    i9 = SchemaUtil.j(R, H(t7, S), s(i12));
                    break;
                case 50:
                    i9 = this.f15177q.g(R, UnsafeUtil.A(t7, S), r(i12));
                    break;
                case 51:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.i(R, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.q(R, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.x(R, X(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.X(R, X(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.v(R, W(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 56:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.o(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.m(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.d(R, true);
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (F(t7, R, i12)) {
                        Object A2 = UnsafeUtil.A(t7, S);
                        if (A2 instanceof ByteString) {
                            i9 = CodedOutputStream.g(R, (ByteString) A2);
                            break;
                        } else {
                            i9 = CodedOutputStream.S(R, (String) A2);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (F(t7, R, i12)) {
                        i9 = SchemaUtil.o(R, UnsafeUtil.A(t7, S), s(i12));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.g(R, (ByteString) UnsafeUtil.A(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 62:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.V(R, W(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 63:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.k(R, W(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 64:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.K(R, 0);
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.M(R, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.O(R, W(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 67:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.Q(R, X(t7, S));
                        break;
                    } else {
                        continue;
                    }
                case 68:
                    if (F(t7, R, i12)) {
                        i9 = CodedOutputStream.s(R, (MessageLite) UnsafeUtil.A(t7, S), s(i12));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i11 += i9;
        }
        return i11 + w(this.f15175o, t7);
    }

    private <UT, UB> void v0(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t7, Writer writer) throws IOException {
        unknownFieldSchema.t(unknownFieldSchema.g(t7), writer);
    }

    private <UT, UB> int w(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t7) {
        return unknownFieldSchema.h(unknownFieldSchema.g(t7));
    }

    private static <T> int x(T t7, long j8) {
        return UnsafeUtil.x(t7, j8);
    }

    private static boolean y(int i8) {
        return (i8 & 536870912) != 0;
    }

    private boolean z(T t7, int i8) {
        if (this.f15168h) {
            int p02 = p0(i8);
            long S = S(p02);
            switch (o0(p02)) {
                case 0:
                    if (UnsafeUtil.v(t7, S) == 0.0d) {
                        return false;
                    }
                    return true;
                case 1:
                    if (UnsafeUtil.w(t7, S) == 0.0f) {
                        return false;
                    }
                    return true;
                case 2:
                    if (UnsafeUtil.y(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (UnsafeUtil.y(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (UnsafeUtil.x(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (UnsafeUtil.y(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (UnsafeUtil.x(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return UnsafeUtil.p(t7, S);
                case 8:
                    Object A = UnsafeUtil.A(t7, S);
                    if (A instanceof String) {
                        return !((String) A).isEmpty();
                    }
                    if (A instanceof ByteString) {
                        return !ByteString.f14989g.equals(A);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.A(t7, S) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    return !ByteString.f14989g.equals(UnsafeUtil.A(t7, S));
                case 11:
                    if (UnsafeUtil.x(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (UnsafeUtil.x(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (UnsafeUtil.x(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (UnsafeUtil.y(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (UnsafeUtil.x(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (UnsafeUtil.y(t7, S) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (UnsafeUtil.A(t7, S) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int f02 = f0(i8);
        if ((UnsafeUtil.x(t7, f02 & 1048575) & (1 << (f02 >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void a(T t7, T t8) {
        t8.getClass();
        for (int i8 = 0; i8 < this.f15161a.length; i8 += 3) {
            N(t7, t8, i8);
        }
        SchemaUtil.G(this.f15175o, t7, t8);
        if (this.f15166f) {
            SchemaUtil.E(this.f15176p, t7, t8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0345, code lost:
        if (r0 != r11) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0347, code lost:
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r9 = r35;
        r1 = r17;
        r3 = r18;
        r7 = r19;
        r2 = r20;
        r6 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x038e, code lost:
        if (r0 != r15) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03b1, code lost:
        if (r0 != r15) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03b4, code lost:
        r2 = r0;
        r8 = r18;
        r0 = r34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a0(T r30, byte[] r31, int r32, int r33, int r34, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1152
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.a0(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void b(T t7) {
        int i8;
        int i9 = this.f15171k;
        while (true) {
            i8 = this.f15172l;
            if (i9 >= i8) {
                break;
            }
            long S = S(p0(this.f15170j[i9]));
            Object A = UnsafeUtil.A(t7, S);
            if (A != null) {
                UnsafeUtil.O(t7, S, this.f15177q.f(A));
            }
            i9++;
        }
        int length = this.f15170j.length;
        while (i8 < length) {
            this.f15174n.c(t7, this.f15170j[i8]);
            i8++;
        }
        this.f15175o.j(t7);
        if (this.f15166f) {
            this.f15176p.f(t7);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean c(T t7) {
        int i8;
        int i9 = -1;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f15171k; i11++) {
            int i12 = this.f15170j[i11];
            int R = R(i12);
            int p02 = p0(i12);
            if (!this.f15168h) {
                int i13 = this.f15161a[i12 + 2];
                int i14 = 1048575 & i13;
                i8 = 1 << (i13 >>> 20);
                if (i14 != i9) {
                    i10 = f15160s.getInt(t7, i14);
                    i9 = i14;
                }
            } else {
                i8 = 0;
            }
            if (G(p02) && !A(t7, i12, i10, i8)) {
                return false;
            }
            int o02 = o0(p02);
            if (o02 != 9 && o02 != 17) {
                if (o02 != 27) {
                    if (o02 != 60 && o02 != 68) {
                        if (o02 != 49) {
                            if (o02 == 50 && !D(t7, p02, i12)) {
                                return false;
                            }
                        }
                    } else if (F(t7, R, i12) && !B(t7, p02, s(i12))) {
                        return false;
                    }
                }
                if (!C(t7, p02, i12)) {
                    return false;
                }
            } else if (A(t7, i12, i10, i8) && !B(t7, p02, s(i12))) {
                return false;
            }
        }
        if (this.f15166f && !this.f15176p.c(t7).o()) {
            return false;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int d(T t7) {
        if (this.f15168h) {
            return v(t7);
        }
        return u(t7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T e() {
        return (T) this.f15173m.a(this.f15165e);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T t7, T t8) {
        int length = this.f15161a.length;
        for (int i8 = 0; i8 < length; i8 += 3) {
            if (!m(t7, t8, i8)) {
                return false;
            }
        }
        if (!this.f15175o.g(t7).equals(this.f15175o.g(t8))) {
            return false;
        }
        if (this.f15166f) {
            return this.f15176p.c(t7).equals(this.f15176p.c(t8));
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void f(T t7, byte[] bArr, int i8, int i9, ArrayDecoders.Registers registers) throws IOException {
        if (this.f15168h) {
            b0(t7, bArr, i8, i9, registers);
        } else {
            a0(t7, bArr, i8, i9, 0, registers);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void g(T t7, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        J(this.f15175o, this.f15176p, t7, reader, extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void h(T t7, Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            s0(t7, writer);
        } else if (this.f15168h) {
            r0(t7, writer);
        } else {
            q0(t7, writer);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T t7) {
        int i8;
        int f8;
        int length = this.f15161a.length;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int p02 = p0(i10);
            int R = R(i10);
            long S = S(p02);
            int i11 = 37;
            switch (o0(p02)) {
                case 0:
                    i8 = i9 * 53;
                    f8 = Internal.f(Double.doubleToLongBits(UnsafeUtil.v(t7, S)));
                    i9 = i8 + f8;
                    break;
                case 1:
                    i8 = i9 * 53;
                    f8 = Float.floatToIntBits(UnsafeUtil.w(t7, S));
                    i9 = i8 + f8;
                    break;
                case 2:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.y(t7, S));
                    i9 = i8 + f8;
                    break;
                case 3:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.y(t7, S));
                    i9 = i8 + f8;
                    break;
                case 4:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.x(t7, S);
                    i9 = i8 + f8;
                    break;
                case 5:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.y(t7, S));
                    i9 = i8 + f8;
                    break;
                case 6:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.x(t7, S);
                    i9 = i8 + f8;
                    break;
                case 7:
                    i8 = i9 * 53;
                    f8 = Internal.c(UnsafeUtil.p(t7, S));
                    i9 = i8 + f8;
                    break;
                case 8:
                    i8 = i9 * 53;
                    f8 = ((String) UnsafeUtil.A(t7, S)).hashCode();
                    i9 = i8 + f8;
                    break;
                case 9:
                    Object A = UnsafeUtil.A(t7, S);
                    if (A != null) {
                        i11 = A.hashCode();
                    }
                    i9 = (i9 * 53) + i11;
                    break;
                case 10:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.A(t7, S).hashCode();
                    i9 = i8 + f8;
                    break;
                case 11:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.x(t7, S);
                    i9 = i8 + f8;
                    break;
                case 12:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.x(t7, S);
                    i9 = i8 + f8;
                    break;
                case 13:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.x(t7, S);
                    i9 = i8 + f8;
                    break;
                case 14:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.y(t7, S));
                    i9 = i8 + f8;
                    break;
                case 15:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.x(t7, S);
                    i9 = i8 + f8;
                    break;
                case 16:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.y(t7, S));
                    i9 = i8 + f8;
                    break;
                case 17:
                    Object A2 = UnsafeUtil.A(t7, S);
                    if (A2 != null) {
                        i11 = A2.hashCode();
                    }
                    i9 = (i9 * 53) + i11;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.A(t7, S).hashCode();
                    i9 = i8 + f8;
                    break;
                case 50:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.A(t7, S).hashCode();
                    i9 = i8 + f8;
                    break;
                case 51:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(Double.doubleToLongBits(U(t7, S)));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Float.floatToIntBits(V(t7, S));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(X(t7, S));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(X(t7, S));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = W(t7, S);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(X(t7, S));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = W(t7, S);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.c(T(t7, S));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = ((String) UnsafeUtil.A(t7, S)).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = UnsafeUtil.A(t7, S).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = UnsafeUtil.A(t7, S).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = W(t7, S);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = W(t7, S);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = W(t7, S);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(X(t7, S));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = W(t7, S);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(X(t7, S));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (F(t7, R, i10)) {
                        i8 = i9 * 53;
                        f8 = UnsafeUtil.A(t7, S).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i9 * 53) + this.f15175o.g(t7).hashCode();
        if (this.f15166f) {
            return (hashCode * 53) + this.f15176p.c(t7).hashCode();
        }
        return hashCode;
    }
}
