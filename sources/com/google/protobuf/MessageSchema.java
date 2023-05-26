package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class MessageSchema<T> implements Schema<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f17514r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f17515s = UnsafeUtil.H();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f17516a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f17517b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17518c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17519d;

    /* renamed from: e  reason: collision with root package name */
    private final MessageLite f17520e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17521f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f17522g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17523h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f17524i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f17525j;

    /* renamed from: k  reason: collision with root package name */
    private final int f17526k;

    /* renamed from: l  reason: collision with root package name */
    private final int f17527l;

    /* renamed from: m  reason: collision with root package name */
    private final NewInstanceSchema f17528m;

    /* renamed from: n  reason: collision with root package name */
    private final ListFieldSchema f17529n;

    /* renamed from: o  reason: collision with root package name */
    private final UnknownFieldSchema<?, ?> f17530o;

    /* renamed from: p  reason: collision with root package name */
    private final ExtensionSchema<?> f17531p;

    /* renamed from: q  reason: collision with root package name */
    private final MapFieldSchema f17532q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.MessageSchema$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17533a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f17533a = iArr;
            try {
                iArr[WireFormat.FieldType.f17679o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17533a[WireFormat.FieldType.f17683s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17533a[WireFormat.FieldType.f17672h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17533a[WireFormat.FieldType.f17678n.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17533a[WireFormat.FieldType.f17686v.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17533a[WireFormat.FieldType.f17677m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17533a[WireFormat.FieldType.f17687w.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17533a[WireFormat.FieldType.f17673i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17533a[WireFormat.FieldType.f17685u.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17533a[WireFormat.FieldType.f17676l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17533a[WireFormat.FieldType.f17684t.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17533a[WireFormat.FieldType.f17674j.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17533a[WireFormat.FieldType.f17675k.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17533a[WireFormat.FieldType.f17682r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17533a[WireFormat.FieldType.f17688x.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f17533a[WireFormat.FieldType.f17689y.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17533a[WireFormat.FieldType.f17680p.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i8, int i9, MessageLite messageLite, boolean z7, boolean z8, int[] iArr2, int i10, int i11, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        boolean z9;
        this.f17516a = iArr;
        this.f17517b = objArr;
        this.f17518c = i8;
        this.f17519d = i9;
        this.f17522g = messageLite instanceof GeneratedMessageLite;
        this.f17523h = z7;
        if (extensionSchema != null && extensionSchema.e(messageLite)) {
            z9 = true;
        } else {
            z9 = false;
        }
        this.f17521f = z9;
        this.f17524i = z8;
        this.f17525j = iArr2;
        this.f17526k = i10;
        this.f17527l = i11;
        this.f17528m = newInstanceSchema;
        this.f17529n = listFieldSchema;
        this.f17530o = unknownFieldSchema;
        this.f17531p = extensionSchema;
        this.f17520e = messageLite;
        this.f17532q = mapFieldSchema;
    }

    private boolean A(T t7, int i8) {
        int g02 = g0(i8);
        long j8 = 1048575 & g02;
        if (j8 == 1048575) {
            int q02 = q0(i8);
            long T = T(q02);
            switch (p0(q02)) {
                case 0:
                    if (Double.doubleToRawLongBits(UnsafeUtil.A(t7, T)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(UnsafeUtil.B(t7, T)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (UnsafeUtil.E(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (UnsafeUtil.E(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (UnsafeUtil.C(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (UnsafeUtil.E(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (UnsafeUtil.C(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return UnsafeUtil.t(t7, T);
                case 8:
                    Object G = UnsafeUtil.G(t7, T);
                    if (G instanceof String) {
                        return !((String) G).isEmpty();
                    }
                    if (G instanceof ByteString) {
                        return !ByteString.f17177g.equals(G);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.G(t7, T) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    return !ByteString.f17177g.equals(UnsafeUtil.G(t7, T));
                case 11:
                    if (UnsafeUtil.C(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (UnsafeUtil.C(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (UnsafeUtil.C(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (UnsafeUtil.E(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (UnsafeUtil.C(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (UnsafeUtil.E(t7, T) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (UnsafeUtil.G(t7, T) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((UnsafeUtil.C(t7, j8) & (1 << (g02 >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private boolean B(T t7, int i8, int i9, int i10, int i11) {
        if (i9 == 1048575) {
            return A(t7, i8);
        }
        if ((i10 & i11) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean C(Object obj, int i8, Schema schema) {
        return schema.c(UnsafeUtil.G(obj, T(i8)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean D(Object obj, int i8, int i9) {
        List list = (List) UnsafeUtil.G(obj, T(i8));
        if (list.isEmpty()) {
            return true;
        }
        Schema t7 = t(i9);
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!t7.c(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.Schema] */
    private boolean E(T t7, int i8, int i9) {
        Map<?, ?> e8 = this.f17532q.e(UnsafeUtil.G(t7, T(i8)));
        if (e8.isEmpty()) {
            return true;
        }
        if (this.f17532q.b(s(i9)).f17508c.a() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<T> schema = 0;
        for (Object obj : e8.values()) {
            if (schema == null) {
                schema = Protobuf.a().d(obj.getClass());
            }
            boolean c8 = schema.c(obj);
            schema = schema;
            if (!c8) {
                return false;
            }
        }
        return true;
    }

    private boolean F(T t7, T t8, int i8) {
        long g02 = g0(i8) & 1048575;
        if (UnsafeUtil.C(t7, g02) == UnsafeUtil.C(t8, g02)) {
            return true;
        }
        return false;
    }

    private boolean G(T t7, int i8, int i9) {
        if (UnsafeUtil.C(t7, g0(i9) & 1048575) == i8) {
            return true;
        }
        return false;
    }

    private static boolean H(int i8) {
        return (i8 & 268435456) != 0;
    }

    private static List<?> I(Object obj, long j8) {
        return (List) UnsafeUtil.G(obj, j8);
    }

    private static <T> long J(T t7, long j8) {
        return UnsafeUtil.E(t7, j8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
        r0 = r16.f17526k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (r0 >= r16.f17527l) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        r13 = o(r19, r16.f17525j[r0], r13, r17);
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
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void K(com.google.protobuf.UnknownFieldSchema<UT, UB> r17, com.google.protobuf.ExtensionSchema<ET> r18, T r19, com.google.protobuf.Reader r20, com.google.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.K(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void L(Object obj, int i8, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long T = T(q0(i8));
        Object G = UnsafeUtil.G(obj, T);
        if (G == null) {
            G = this.f17532q.d(obj2);
            UnsafeUtil.V(obj, T, G);
        } else if (this.f17532q.h(G)) {
            Object d8 = this.f17532q.d(obj2);
            this.f17532q.a(d8, G);
            UnsafeUtil.V(obj, T, d8);
            G = d8;
        }
        reader.M(this.f17532q.c(G), this.f17532q.b(obj2), extensionRegistryLite);
    }

    private void M(T t7, T t8, int i8) {
        long T = T(q0(i8));
        if (!A(t8, i8)) {
            return;
        }
        Object G = UnsafeUtil.G(t7, T);
        Object G2 = UnsafeUtil.G(t8, T);
        if (G != null && G2 != null) {
            UnsafeUtil.V(t7, T, Internal.h(G, G2));
            m0(t7, i8);
        } else if (G2 != null) {
            UnsafeUtil.V(t7, T, G2);
            m0(t7, i8);
        }
    }

    private void N(T t7, T t8, int i8) {
        int q02 = q0(i8);
        int S = S(i8);
        long T = T(q02);
        if (!G(t8, S, i8)) {
            return;
        }
        Object obj = null;
        if (G(t7, S, i8)) {
            obj = UnsafeUtil.G(t7, T);
        }
        Object G = UnsafeUtil.G(t8, T);
        if (obj != null && G != null) {
            UnsafeUtil.V(t7, T, Internal.h(obj, G));
            n0(t7, S, i8);
        } else if (G != null) {
            UnsafeUtil.V(t7, T, G);
            n0(t7, S, i8);
        }
    }

    private void O(T t7, T t8, int i8) {
        int q02 = q0(i8);
        long T = T(q02);
        int S = S(i8);
        switch (p0(q02)) {
            case 0:
                if (A(t8, i8)) {
                    UnsafeUtil.R(t7, T, UnsafeUtil.A(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 1:
                if (A(t8, i8)) {
                    UnsafeUtil.S(t7, T, UnsafeUtil.B(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 2:
                if (A(t8, i8)) {
                    UnsafeUtil.U(t7, T, UnsafeUtil.E(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 3:
                if (A(t8, i8)) {
                    UnsafeUtil.U(t7, T, UnsafeUtil.E(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 4:
                if (A(t8, i8)) {
                    UnsafeUtil.T(t7, T, UnsafeUtil.C(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 5:
                if (A(t8, i8)) {
                    UnsafeUtil.U(t7, T, UnsafeUtil.E(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 6:
                if (A(t8, i8)) {
                    UnsafeUtil.T(t7, T, UnsafeUtil.C(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 7:
                if (A(t8, i8)) {
                    UnsafeUtil.L(t7, T, UnsafeUtil.t(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 8:
                if (A(t8, i8)) {
                    UnsafeUtil.V(t7, T, UnsafeUtil.G(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 9:
                M(t7, t8, i8);
                return;
            case 10:
                if (A(t8, i8)) {
                    UnsafeUtil.V(t7, T, UnsafeUtil.G(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 11:
                if (A(t8, i8)) {
                    UnsafeUtil.T(t7, T, UnsafeUtil.C(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 12:
                if (A(t8, i8)) {
                    UnsafeUtil.T(t7, T, UnsafeUtil.C(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 13:
                if (A(t8, i8)) {
                    UnsafeUtil.T(t7, T, UnsafeUtil.C(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 14:
                if (A(t8, i8)) {
                    UnsafeUtil.U(t7, T, UnsafeUtil.E(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 15:
                if (A(t8, i8)) {
                    UnsafeUtil.T(t7, T, UnsafeUtil.C(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 16:
                if (A(t8, i8)) {
                    UnsafeUtil.U(t7, T, UnsafeUtil.E(t8, T));
                    m0(t7, i8);
                    return;
                }
                return;
            case 17:
                M(t7, t8, i8);
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
                this.f17529n.d(t7, t8, T);
                return;
            case 50:
                SchemaUtil.F(this.f17532q, t7, t8, T);
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
                if (G(t8, S, i8)) {
                    UnsafeUtil.V(t7, T, UnsafeUtil.G(t8, T));
                    n0(t7, S, i8);
                    return;
                }
                return;
            case 60:
                N(t7, t8, i8);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (G(t8, S, i8)) {
                    UnsafeUtil.V(t7, T, UnsafeUtil.G(t8, T));
                    n0(t7, S, i8);
                    return;
                }
                return;
            case 68:
                N(t7, t8, i8);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSchema<T> P(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return R((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return Q((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> Q(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
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
                    d8 = f17514r;
                }
                if (e8.length <= 0) {
                    int[] iArr2 = f17514r;
                    int[] iArr3 = f17514r;
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

    /* JADX WARN: Removed duplicated region for block: B:122:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x037c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.protobuf.MessageSchema<T> R(com.google.protobuf.RawMessageInfo r34, com.google.protobuf.NewInstanceSchema r35, com.google.protobuf.ListFieldSchema r36, com.google.protobuf.UnknownFieldSchema<?, ?> r37, com.google.protobuf.ExtensionSchema<?> r38, com.google.protobuf.MapFieldSchema r39) {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.R(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    private int S(int i8) {
        return this.f17516a[i8];
    }

    private static long T(int i8) {
        return i8 & 1048575;
    }

    private static <T> boolean U(T t7, long j8) {
        return ((Boolean) UnsafeUtil.G(t7, j8)).booleanValue();
    }

    private static <T> double V(T t7, long j8) {
        return ((Double) UnsafeUtil.G(t7, j8)).doubleValue();
    }

    private static <T> float W(T t7, long j8) {
        return ((Float) UnsafeUtil.G(t7, j8)).floatValue();
    }

    private static <T> int X(T t7, long j8) {
        return ((Integer) UnsafeUtil.G(t7, j8)).intValue();
    }

    private static <T> long Y(T t7, long j8) {
        return ((Long) UnsafeUtil.G(t7, j8)).longValue();
    }

    private <K, V> int Z(T t7, byte[] bArr, int i8, int i9, int i10, long j8, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f17515s;
        Object s7 = s(i10);
        Object object = unsafe.getObject(t7, j8);
        if (this.f17532q.h(object)) {
            Object d8 = this.f17532q.d(s7);
            this.f17532q.a(d8, object);
            unsafe.putObject(t7, j8, d8);
            object = d8;
        }
        return k(bArr, i8, i9, this.f17532q.b(s7), this.f17532q.c(object), registers);
    }

    private int a0(T t7, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j8, int i15, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = f17515s;
        long j9 = this.f17516a[i15 + 2] & 1048575;
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
                    unsafe.putObject(t7, j8, Long.valueOf(registers.f17162b));
                    unsafe.putInt(t7, j9, i11);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int I = ArrayDecoders.I(bArr, i8, registers);
                    unsafe.putObject(t7, j8, Integer.valueOf(registers.f17161a));
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
                    unsafe.putObject(t7, j8, Boolean.valueOf(registers.f17162b != 0));
                    unsafe.putInt(t7, j9, i11);
                    return L2;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int I2 = ArrayDecoders.I(bArr, i8, registers);
                    int i20 = registers.f17161a;
                    if (i20 == 0) {
                        unsafe.putObject(t7, j8, "");
                    } else if ((i13 & 536870912) != 0 && !Utf8.t(bArr, I2, I2 + i20)) {
                        throw InvalidProtocolBufferException.d();
                    } else {
                        unsafe.putObject(t7, j8, new String(bArr, I2, i20, Internal.f17450b));
                        I2 += i20;
                    }
                    unsafe.putInt(t7, j9, i11);
                    return I2;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int p8 = ArrayDecoders.p(t(i15), bArr, i8, i9, registers);
                    Object object = unsafe.getInt(t7, j9) == i11 ? unsafe.getObject(t7, j8) : null;
                    if (object == null) {
                        unsafe.putObject(t7, j8, registers.f17163c);
                    } else {
                        unsafe.putObject(t7, j8, Internal.h(object, registers.f17163c));
                    }
                    unsafe.putInt(t7, j9, i11);
                    return p8;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int b8 = ArrayDecoders.b(bArr, i8, registers);
                    unsafe.putObject(t7, j8, registers.f17163c);
                    unsafe.putInt(t7, j9, i11);
                    return b8;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int I3 = ArrayDecoders.I(bArr, i8, registers);
                    int i21 = registers.f17161a;
                    Internal.EnumVerifier r7 = r(i15);
                    if (r7 != null && !r7.a(i21)) {
                        u(t7).q(i10, Long.valueOf(i21));
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
                    unsafe.putObject(t7, j8, Integer.valueOf(CodedInputStream.c(registers.f17161a)));
                    unsafe.putInt(t7, j9, i11);
                    return I4;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int L3 = ArrayDecoders.L(bArr, i8, registers);
                    unsafe.putObject(t7, j8, Long.valueOf(CodedInputStream.d(registers.f17162b)));
                    unsafe.putInt(t7, j9, i11);
                    return L3;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int n8 = ArrayDecoders.n(t(i15), bArr, i8, i9, (i10 & (-8)) | 4, registers);
                    Object object2 = unsafe.getInt(t7, j9) == i11 ? unsafe.getObject(t7, j8) : null;
                    if (object2 == null) {
                        unsafe.putObject(t7, j8, registers.f17163c);
                    } else {
                        unsafe.putObject(t7, j8, Internal.h(object2, registers.f17163c));
                    }
                    unsafe.putInt(t7, j9, i11);
                    return n8;
                }
                break;
        }
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0296, code lost:
        if (r0 != r15) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0298, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r1 = r19;
        r2 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02dd, code lost:
        if (r0 != r15) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0300, code lost:
        if (r0 != r15) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0303, code lost:
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int c0(T r31, byte[] r32, int r33, int r34, com.google.protobuf.ArrayDecoders.Registers r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 876
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.c0(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    private int d0(T t7, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, long j8, int i14, long j9, ArrayDecoders.Registers registers) throws IOException {
        int J;
        Unsafe unsafe = f17515s;
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
                    return ArrayDecoders.q(t(i13), i10, bArr, i8, i9, protobufList, registers);
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
                if (unknownFieldSetLite == UnknownFieldSetLite.c()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.A(i11, protobufList, r(i13), unknownFieldSetLite, this.f17530o);
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
                    return ArrayDecoders.o(t(i13), i10, bArr, i8, i9, protobufList, registers);
                }
                break;
        }
        return i8;
    }

    private int e0(int i8) {
        if (i8 >= this.f17518c && i8 <= this.f17519d) {
            return o0(i8, 0);
        }
        return -1;
    }

    private int f0(int i8, int i9) {
        if (i8 >= this.f17518c && i8 <= this.f17519d) {
            return o0(i8, i9);
        }
        return -1;
    }

    private int g0(int i8) {
        return this.f17516a[i8 + 2];
    }

    private <E> void h0(Object obj, long j8, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.J(this.f17529n.e(obj, j8), schema, extensionRegistryLite);
    }

    private boolean i(T t7, T t8, int i8) {
        if (A(t7, i8) == A(t8, i8)) {
            return true;
        }
        return false;
    }

    private <E> void i0(Object obj, int i8, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.K(this.f17529n.e(obj, T(i8)), schema, extensionRegistryLite);
    }

    private static <T> boolean j(T t7, long j8) {
        return UnsafeUtil.t(t7, j8);
    }

    private void j0(Object obj, int i8, Reader reader) throws IOException {
        if (z(i8)) {
            UnsafeUtil.V(obj, T(i8), reader.I());
        } else if (this.f17522g) {
            UnsafeUtil.V(obj, T(i8), reader.z());
        } else {
            UnsafeUtil.V(obj, T(i8), reader.o());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int k(byte[] bArr, int i8, int i9, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int i10;
        int I = ArrayDecoders.I(bArr, i8, registers);
        int i11 = registers.f17161a;
        if (i11 >= 0 && i11 <= i9 - I) {
            int i12 = I + i11;
            K k8 = metadata.f17507b;
            V v7 = metadata.f17509d;
            while (I < i12) {
                int i13 = I + 1;
                byte b8 = bArr[I];
                if (b8 < 0) {
                    i10 = ArrayDecoders.H(b8, bArr, i13, registers);
                    b8 = registers.f17161a;
                } else {
                    i10 = i13;
                }
                int i14 = b8 >>> 3;
                int i15 = b8 & 7;
                if (i14 != 1) {
                    if (i14 == 2 && i15 == metadata.f17508c.c()) {
                        I = l(bArr, i10, i9, metadata.f17508c, metadata.f17509d.getClass(), registers);
                        v7 = registers.f17163c;
                    }
                    I = ArrayDecoders.N(b8, bArr, i10, i9, registers);
                } else if (i15 == metadata.f17506a.c()) {
                    I = l(bArr, i10, i9, metadata.f17506a, null, registers);
                    k8 = registers.f17163c;
                } else {
                    I = ArrayDecoders.N(b8, bArr, i10, i9, registers);
                }
            }
            if (I == i12) {
                map.put(k8, v7);
                return i12;
            }
            throw InvalidProtocolBufferException.h();
        }
        throw InvalidProtocolBufferException.m();
    }

    private void k0(Object obj, int i8, Reader reader) throws IOException {
        if (z(i8)) {
            reader.n(this.f17529n.e(obj, T(i8)));
        } else {
            reader.B(this.f17529n.e(obj, T(i8)));
        }
    }

    private int l(byte[] bArr, int i8, int i9, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        boolean z7;
        switch (AnonymousClass1.f17533a[fieldType.ordinal()]) {
            case 1:
                int L = ArrayDecoders.L(bArr, i8, registers);
                if (registers.f17162b != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                registers.f17163c = Boolean.valueOf(z7);
                return L;
            case 2:
                return ArrayDecoders.b(bArr, i8, registers);
            case 3:
                registers.f17163c = Double.valueOf(ArrayDecoders.d(bArr, i8));
                return i8 + 8;
            case 4:
            case 5:
                registers.f17163c = Integer.valueOf(ArrayDecoders.h(bArr, i8));
                return i8 + 4;
            case 6:
            case 7:
                registers.f17163c = Long.valueOf(ArrayDecoders.j(bArr, i8));
                return i8 + 8;
            case 8:
                registers.f17163c = Float.valueOf(ArrayDecoders.l(bArr, i8));
                return i8 + 4;
            case 9:
            case 10:
            case 11:
                int I = ArrayDecoders.I(bArr, i8, registers);
                registers.f17163c = Integer.valueOf(registers.f17161a);
                return I;
            case 12:
            case 13:
                int L2 = ArrayDecoders.L(bArr, i8, registers);
                registers.f17163c = Long.valueOf(registers.f17162b);
                return L2;
            case 14:
                return ArrayDecoders.p(Protobuf.a().d(cls), bArr, i8, i9, registers);
            case 15:
                int I2 = ArrayDecoders.I(bArr, i8, registers);
                registers.f17163c = Integer.valueOf(CodedInputStream.c(registers.f17161a));
                return I2;
            case 16:
                int L3 = ArrayDecoders.L(bArr, i8, registers);
                registers.f17163c = Long.valueOf(CodedInputStream.d(registers.f17162b));
                return L3;
            case 17:
                return ArrayDecoders.F(bArr, i8, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static java.lang.reflect.Field l0(Class<?> cls, String str) {
        java.lang.reflect.Field[] declaredFields;
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static <T> double m(T t7, long j8) {
        return UnsafeUtil.A(t7, j8);
    }

    private void m0(T t7, int i8) {
        int g02 = g0(i8);
        long j8 = 1048575 & g02;
        if (j8 == 1048575) {
            return;
        }
        UnsafeUtil.T(t7, j8, (1 << (g02 >>> 20)) | UnsafeUtil.C(t7, j8));
    }

    private boolean n(T t7, T t8, int i8) {
        int q02 = q0(i8);
        long T = T(q02);
        switch (p0(q02)) {
            case 0:
                if (!i(t7, t8, i8) || Double.doubleToLongBits(UnsafeUtil.A(t7, T)) != Double.doubleToLongBits(UnsafeUtil.A(t8, T))) {
                    return false;
                }
                return true;
            case 1:
                if (!i(t7, t8, i8) || Float.floatToIntBits(UnsafeUtil.B(t7, T)) != Float.floatToIntBits(UnsafeUtil.B(t8, T))) {
                    return false;
                }
                return true;
            case 2:
                if (!i(t7, t8, i8) || UnsafeUtil.E(t7, T) != UnsafeUtil.E(t8, T)) {
                    return false;
                }
                return true;
            case 3:
                if (!i(t7, t8, i8) || UnsafeUtil.E(t7, T) != UnsafeUtil.E(t8, T)) {
                    return false;
                }
                return true;
            case 4:
                if (!i(t7, t8, i8) || UnsafeUtil.C(t7, T) != UnsafeUtil.C(t8, T)) {
                    return false;
                }
                return true;
            case 5:
                if (!i(t7, t8, i8) || UnsafeUtil.E(t7, T) != UnsafeUtil.E(t8, T)) {
                    return false;
                }
                return true;
            case 6:
                if (!i(t7, t8, i8) || UnsafeUtil.C(t7, T) != UnsafeUtil.C(t8, T)) {
                    return false;
                }
                return true;
            case 7:
                if (!i(t7, t8, i8) || UnsafeUtil.t(t7, T) != UnsafeUtil.t(t8, T)) {
                    return false;
                }
                return true;
            case 8:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.G(t7, T), UnsafeUtil.G(t8, T))) {
                    return false;
                }
                return true;
            case 9:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.G(t7, T), UnsafeUtil.G(t8, T))) {
                    return false;
                }
                return true;
            case 10:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.G(t7, T), UnsafeUtil.G(t8, T))) {
                    return false;
                }
                return true;
            case 11:
                if (!i(t7, t8, i8) || UnsafeUtil.C(t7, T) != UnsafeUtil.C(t8, T)) {
                    return false;
                }
                return true;
            case 12:
                if (!i(t7, t8, i8) || UnsafeUtil.C(t7, T) != UnsafeUtil.C(t8, T)) {
                    return false;
                }
                return true;
            case 13:
                if (!i(t7, t8, i8) || UnsafeUtil.C(t7, T) != UnsafeUtil.C(t8, T)) {
                    return false;
                }
                return true;
            case 14:
                if (!i(t7, t8, i8) || UnsafeUtil.E(t7, T) != UnsafeUtil.E(t8, T)) {
                    return false;
                }
                return true;
            case 15:
                if (!i(t7, t8, i8) || UnsafeUtil.C(t7, T) != UnsafeUtil.C(t8, T)) {
                    return false;
                }
                return true;
            case 16:
                if (!i(t7, t8, i8) || UnsafeUtil.E(t7, T) != UnsafeUtil.E(t8, T)) {
                    return false;
                }
                return true;
            case 17:
                if (!i(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.G(t7, T), UnsafeUtil.G(t8, T))) {
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
                return SchemaUtil.K(UnsafeUtil.G(t7, T), UnsafeUtil.G(t8, T));
            case 50:
                return SchemaUtil.K(UnsafeUtil.G(t7, T), UnsafeUtil.G(t8, T));
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
                if (!F(t7, t8, i8) || !SchemaUtil.K(UnsafeUtil.G(t7, T), UnsafeUtil.G(t8, T))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private void n0(T t7, int i8, int i9) {
        UnsafeUtil.T(t7, g0(i9) & 1048575, i8);
    }

    private final <UT, UB> UB o(Object obj, int i8, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        int S = S(i8);
        Object G = UnsafeUtil.G(obj, T(q0(i8)));
        if (G == null) {
            return ub;
        }
        Internal.EnumVerifier r7 = r(i8);
        if (r7 == null) {
            return ub;
        }
        return (UB) p(i8, S, this.f17532q.c(G), r7, ub, unknownFieldSchema);
    }

    private int o0(int i8, int i9) {
        int length = (this.f17516a.length / 3) - 1;
        while (i9 <= length) {
            int i10 = (length + i9) >>> 1;
            int i11 = i10 * 3;
            int S = S(i11);
            if (i8 == S) {
                return i11;
            }
            if (i8 < S) {
                length = i10 - 1;
            } else {
                i9 = i10 + 1;
            }
        }
        return -1;
    }

    private final <K, V, UT, UB> UB p(int i8, int i9, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> b8 = this.f17532q.b(s(i8));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.n();
                }
                ByteString.CodedBuilder A = ByteString.A(MapEntryLite.b(b8, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.e(A.b(), b8, next.getKey(), next.getValue());
                    unknownFieldSchema.d(ub, i9, A.a());
                    it.remove();
                } catch (IOException e8) {
                    throw new RuntimeException(e8);
                }
            }
        }
        return ub;
    }

    private static int p0(int i8) {
        return (i8 & 267386880) >>> 20;
    }

    private static <T> float q(T t7, long j8) {
        return UnsafeUtil.B(t7, j8);
    }

    private int q0(int i8) {
        return this.f17516a[i8 + 1];
    }

    private Internal.EnumVerifier r(int i8) {
        return (Internal.EnumVerifier) this.f17517b[((i8 / 3) * 2) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0491  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r0(T r18, com.google.protobuf.Writer r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.r0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private Object s(int i8) {
        return this.f17517b[(i8 / 3) * 2];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0588  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s0(T r13, com.google.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.s0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private Schema t(int i8) {
        int i9 = (i8 / 3) * 2;
        Schema schema = (Schema) this.f17517b[i9];
        if (schema != null) {
            return schema;
        }
        Schema<T> d8 = Protobuf.a().d((Class) this.f17517b[i9 + 1]);
        this.f17517b[i9] = d8;
        return d8;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x058e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t0(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.t0(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite u(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.c()) {
            UnknownFieldSetLite n8 = UnknownFieldSetLite.n();
            generatedMessageLite.unknownFields = n8;
            return n8;
        }
        return unknownFieldSetLite;
    }

    private <K, V> void u0(Writer writer, int i8, Object obj, int i9) throws IOException {
        if (obj != null) {
            writer.O(i8, this.f17532q.b(s(i9)), this.f17532q.e(obj));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int v(T t7) {
        int i8;
        int i9;
        int j8;
        int e8;
        int L;
        int i10;
        int V;
        int X;
        Unsafe unsafe = f17515s;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        int i15 = 0;
        while (i12 < this.f17516a.length) {
            int q02 = q0(i12);
            int S = S(i12);
            int p02 = p0(q02);
            if (p02 <= 17) {
                i8 = this.f17516a[i12 + 2];
                int i16 = i8 & i11;
                i9 = 1 << (i8 >>> 20);
                if (i16 != i14) {
                    i15 = unsafe.getInt(t7, i16);
                    i14 = i16;
                }
            } else {
                if (this.f17524i && p02 >= FieldType.T.a() && p02 <= FieldType.f17378g0.a()) {
                    i8 = this.f17516a[i12 + 2] & i11;
                } else {
                    i8 = 0;
                }
                i9 = 0;
            }
            long T = T(q02);
            switch (p02) {
                case 0:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        j8 = CodedOutputStream.j(S, 0.0d);
                        i13 += j8;
                        break;
                    }
                case 1:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        j8 = CodedOutputStream.r(S, 0.0f);
                        i13 += j8;
                        break;
                    }
                case 2:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        j8 = CodedOutputStream.y(S, unsafe.getLong(t7, T));
                        i13 += j8;
                        break;
                    }
                case 3:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        j8 = CodedOutputStream.Y(S, unsafe.getLong(t7, T));
                        i13 += j8;
                        break;
                    }
                case 4:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        j8 = CodedOutputStream.w(S, unsafe.getInt(t7, T));
                        i13 += j8;
                        break;
                    }
                case 5:
                    if ((i15 & i9) == 0) {
                        break;
                    } else {
                        j8 = CodedOutputStream.p(S, 0L);
                        i13 += j8;
                        break;
                    }
                case 6:
                    if ((i15 & i9) != 0) {
                        j8 = CodedOutputStream.n(S, 0);
                        i13 += j8;
                        break;
                    }
                    break;
                case 7:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.e(S, true);
                        i13 += e8;
                    }
                    break;
                case 8:
                    if ((i15 & i9) != 0) {
                        Object object = unsafe.getObject(t7, T);
                        if (object instanceof ByteString) {
                            e8 = CodedOutputStream.h(S, (ByteString) object);
                        } else {
                            e8 = CodedOutputStream.T(S, (String) object);
                        }
                        i13 += e8;
                    }
                    break;
                case 9:
                    if ((i15 & i9) != 0) {
                        e8 = SchemaUtil.o(S, unsafe.getObject(t7, T), t(i12));
                        i13 += e8;
                    }
                    break;
                case 10:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.h(S, (ByteString) unsafe.getObject(t7, T));
                        i13 += e8;
                    }
                    break;
                case 11:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.W(S, unsafe.getInt(t7, T));
                        i13 += e8;
                    }
                    break;
                case 12:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.l(S, unsafe.getInt(t7, T));
                        i13 += e8;
                    }
                    break;
                case 13:
                    if ((i15 & i9) != 0) {
                        L = CodedOutputStream.L(S, 0);
                        i13 += L;
                    }
                    break;
                case 14:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.N(S, 0L);
                        i13 += e8;
                    }
                    break;
                case 15:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.P(S, unsafe.getInt(t7, T));
                        i13 += e8;
                    }
                    break;
                case 16:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.R(S, unsafe.getLong(t7, T));
                        i13 += e8;
                    }
                    break;
                case 17:
                    if ((i15 & i9) != 0) {
                        e8 = CodedOutputStream.t(S, (MessageLite) unsafe.getObject(t7, T), t(i12));
                        i13 += e8;
                    }
                    break;
                case 18:
                    e8 = SchemaUtil.h(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 19:
                    e8 = SchemaUtil.f(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 20:
                    e8 = SchemaUtil.m(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 21:
                    e8 = SchemaUtil.x(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 22:
                    e8 = SchemaUtil.k(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 23:
                    e8 = SchemaUtil.h(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 24:
                    e8 = SchemaUtil.f(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 25:
                    e8 = SchemaUtil.a(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 26:
                    e8 = SchemaUtil.u(S, (List) unsafe.getObject(t7, T));
                    i13 += e8;
                    break;
                case 27:
                    e8 = SchemaUtil.p(S, (List) unsafe.getObject(t7, T), t(i12));
                    i13 += e8;
                    break;
                case 28:
                    e8 = SchemaUtil.c(S, (List) unsafe.getObject(t7, T));
                    i13 += e8;
                    break;
                case 29:
                    e8 = SchemaUtil.v(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 30:
                    e8 = SchemaUtil.d(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 31:
                    e8 = SchemaUtil.f(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 32:
                    e8 = SchemaUtil.h(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 33:
                    e8 = SchemaUtil.q(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 34:
                    e8 = SchemaUtil.s(S, (List) unsafe.getObject(t7, T), false);
                    i13 += e8;
                    break;
                case 35:
                    i10 = SchemaUtil.i((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 36:
                    i10 = SchemaUtil.g((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 37:
                    i10 = SchemaUtil.n((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 38:
                    i10 = SchemaUtil.y((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 39:
                    i10 = SchemaUtil.l((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 40:
                    i10 = SchemaUtil.i((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 41:
                    i10 = SchemaUtil.g((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 42:
                    i10 = SchemaUtil.b((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 43:
                    i10 = SchemaUtil.w((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 44:
                    i10 = SchemaUtil.e((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 45:
                    i10 = SchemaUtil.g((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 46:
                    i10 = SchemaUtil.i((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 47:
                    i10 = SchemaUtil.r((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 48:
                    i10 = SchemaUtil.t((List) unsafe.getObject(t7, T));
                    if (i10 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i10);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i10);
                        L = V + X + i10;
                        i13 += L;
                    }
                    break;
                case 49:
                    e8 = SchemaUtil.j(S, (List) unsafe.getObject(t7, T), t(i12));
                    i13 += e8;
                    break;
                case 50:
                    e8 = this.f17532q.g(S, unsafe.getObject(t7, T), s(i12));
                    i13 += e8;
                    break;
                case 51:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.j(S, 0.0d);
                        i13 += e8;
                    }
                    break;
                case 52:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.r(S, 0.0f);
                        i13 += e8;
                    }
                    break;
                case 53:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.y(S, Y(t7, T));
                        i13 += e8;
                    }
                    break;
                case 54:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.Y(S, Y(t7, T));
                        i13 += e8;
                    }
                    break;
                case 55:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.w(S, X(t7, T));
                        i13 += e8;
                    }
                    break;
                case 56:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.p(S, 0L);
                        i13 += e8;
                    }
                    break;
                case 57:
                    if (G(t7, S, i12)) {
                        L = CodedOutputStream.n(S, 0);
                        i13 += L;
                    }
                    break;
                case 58:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.e(S, true);
                        i13 += e8;
                    }
                    break;
                case 59:
                    if (G(t7, S, i12)) {
                        Object object2 = unsafe.getObject(t7, T);
                        if (object2 instanceof ByteString) {
                            e8 = CodedOutputStream.h(S, (ByteString) object2);
                        } else {
                            e8 = CodedOutputStream.T(S, (String) object2);
                        }
                        i13 += e8;
                    }
                    break;
                case 60:
                    if (G(t7, S, i12)) {
                        e8 = SchemaUtil.o(S, unsafe.getObject(t7, T), t(i12));
                        i13 += e8;
                    }
                    break;
                case 61:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.h(S, (ByteString) unsafe.getObject(t7, T));
                        i13 += e8;
                    }
                    break;
                case 62:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.W(S, X(t7, T));
                        i13 += e8;
                    }
                    break;
                case 63:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.l(S, X(t7, T));
                        i13 += e8;
                    }
                    break;
                case 64:
                    if (G(t7, S, i12)) {
                        L = CodedOutputStream.L(S, 0);
                        i13 += L;
                    }
                    break;
                case 65:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.N(S, 0L);
                        i13 += e8;
                    }
                    break;
                case 66:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.P(S, X(t7, T));
                        i13 += e8;
                    }
                    break;
                case 67:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.R(S, Y(t7, T));
                        i13 += e8;
                    }
                    break;
                case 68:
                    if (G(t7, S, i12)) {
                        e8 = CodedOutputStream.t(S, (MessageLite) unsafe.getObject(t7, T), t(i12));
                        i13 += e8;
                    }
                    break;
            }
            i12 += 3;
            i11 = 1048575;
        }
        int x7 = i13 + x(this.f17530o, t7);
        if (this.f17521f) {
            return x7 + this.f17531p.c(t7).n();
        }
        return x7;
    }

    private void v0(int i8, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.e(i8, (String) obj);
        } else {
            writer.L(i8, (ByteString) obj);
        }
    }

    private int w(T t7) {
        int i8;
        int j8;
        int i9;
        int V;
        int X;
        Unsafe unsafe = f17515s;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f17516a.length; i11 += 3) {
            int q02 = q0(i11);
            int p02 = p0(q02);
            int S = S(i11);
            long T = T(q02);
            if (p02 >= FieldType.T.a() && p02 <= FieldType.f17378g0.a()) {
                i8 = this.f17516a[i11 + 2] & 1048575;
            } else {
                i8 = 0;
            }
            switch (p02) {
                case 0:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.j(S, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.r(S, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.y(S, UnsafeUtil.E(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.Y(S, UnsafeUtil.E(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.w(S, UnsafeUtil.C(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.p(S, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.n(S, 0);
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.e(S, true);
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (A(t7, i11)) {
                        Object G = UnsafeUtil.G(t7, T);
                        if (G instanceof ByteString) {
                            j8 = CodedOutputStream.h(S, (ByteString) G);
                            break;
                        } else {
                            j8 = CodedOutputStream.T(S, (String) G);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if (A(t7, i11)) {
                        j8 = SchemaUtil.o(S, UnsafeUtil.G(t7, T), t(i11));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.h(S, (ByteString) UnsafeUtil.G(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 11:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.W(S, UnsafeUtil.C(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 12:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.l(S, UnsafeUtil.C(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 13:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.L(S, 0);
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.N(S, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.P(S, UnsafeUtil.C(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 16:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.R(S, UnsafeUtil.E(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if (A(t7, i11)) {
                        j8 = CodedOutputStream.t(S, (MessageLite) UnsafeUtil.G(t7, T), t(i11));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    j8 = SchemaUtil.h(S, I(t7, T), false);
                    break;
                case 19:
                    j8 = SchemaUtil.f(S, I(t7, T), false);
                    break;
                case 20:
                    j8 = SchemaUtil.m(S, I(t7, T), false);
                    break;
                case 21:
                    j8 = SchemaUtil.x(S, I(t7, T), false);
                    break;
                case 22:
                    j8 = SchemaUtil.k(S, I(t7, T), false);
                    break;
                case 23:
                    j8 = SchemaUtil.h(S, I(t7, T), false);
                    break;
                case 24:
                    j8 = SchemaUtil.f(S, I(t7, T), false);
                    break;
                case 25:
                    j8 = SchemaUtil.a(S, I(t7, T), false);
                    break;
                case 26:
                    j8 = SchemaUtil.u(S, I(t7, T));
                    break;
                case 27:
                    j8 = SchemaUtil.p(S, I(t7, T), t(i11));
                    break;
                case 28:
                    j8 = SchemaUtil.c(S, I(t7, T));
                    break;
                case 29:
                    j8 = SchemaUtil.v(S, I(t7, T), false);
                    break;
                case 30:
                    j8 = SchemaUtil.d(S, I(t7, T), false);
                    break;
                case 31:
                    j8 = SchemaUtil.f(S, I(t7, T), false);
                    break;
                case 32:
                    j8 = SchemaUtil.h(S, I(t7, T), false);
                    break;
                case 33:
                    j8 = SchemaUtil.q(S, I(t7, T), false);
                    break;
                case 34:
                    j8 = SchemaUtil.s(S, I(t7, T), false);
                    break;
                case 35:
                    i9 = SchemaUtil.i((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 36:
                    i9 = SchemaUtil.g((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 37:
                    i9 = SchemaUtil.n((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 38:
                    i9 = SchemaUtil.y((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 39:
                    i9 = SchemaUtil.l((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 40:
                    i9 = SchemaUtil.i((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 41:
                    i9 = SchemaUtil.g((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 42:
                    i9 = SchemaUtil.b((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 43:
                    i9 = SchemaUtil.w((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 44:
                    i9 = SchemaUtil.e((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 45:
                    i9 = SchemaUtil.g((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 46:
                    i9 = SchemaUtil.i((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 47:
                    i9 = SchemaUtil.r((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 48:
                    i9 = SchemaUtil.t((List) unsafe.getObject(t7, T));
                    if (i9 > 0) {
                        if (this.f17524i) {
                            unsafe.putInt(t7, i8, i9);
                        }
                        V = CodedOutputStream.V(S);
                        X = CodedOutputStream.X(i9);
                        j8 = V + X + i9;
                        break;
                    } else {
                        continue;
                    }
                case 49:
                    j8 = SchemaUtil.j(S, I(t7, T), t(i11));
                    break;
                case 50:
                    j8 = this.f17532q.g(S, UnsafeUtil.G(t7, T), s(i11));
                    break;
                case 51:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.j(S, 0.0d);
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.r(S, 0.0f);
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.y(S, Y(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.Y(S, Y(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.w(S, X(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 56:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.p(S, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.n(S, 0);
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.e(S, true);
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (G(t7, S, i11)) {
                        Object G2 = UnsafeUtil.G(t7, T);
                        if (G2 instanceof ByteString) {
                            j8 = CodedOutputStream.h(S, (ByteString) G2);
                            break;
                        } else {
                            j8 = CodedOutputStream.T(S, (String) G2);
                            break;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (G(t7, S, i11)) {
                        j8 = SchemaUtil.o(S, UnsafeUtil.G(t7, T), t(i11));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.h(S, (ByteString) UnsafeUtil.G(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 62:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.W(S, X(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 63:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.l(S, X(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 64:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.L(S, 0);
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.N(S, 0L);
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.P(S, X(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 67:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.R(S, Y(t7, T));
                        break;
                    } else {
                        continue;
                    }
                case 68:
                    if (G(t7, S, i11)) {
                        j8 = CodedOutputStream.t(S, (MessageLite) UnsafeUtil.G(t7, T), t(i11));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i10 += j8;
        }
        return i10 + x(this.f17530o, t7);
    }

    private <UT, UB> void w0(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t7, Writer writer) throws IOException {
        unknownFieldSchema.t(unknownFieldSchema.g(t7), writer);
    }

    private <UT, UB> int x(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t7) {
        return unknownFieldSchema.h(unknownFieldSchema.g(t7));
    }

    private static <T> int y(T t7, long j8) {
        return UnsafeUtil.C(t7, j8);
    }

    private static boolean z(int i8) {
        return (i8 & 536870912) != 0;
    }

    @Override // com.google.protobuf.Schema
    public void a(T t7, T t8) {
        t8.getClass();
        for (int i8 = 0; i8 < this.f17516a.length; i8 += 3) {
            O(t7, t8, i8);
        }
        SchemaUtil.G(this.f17530o, t7, t8);
        if (this.f17521f) {
            SchemaUtil.E(this.f17531p, t7, t8);
        }
    }

    @Override // com.google.protobuf.Schema
    public void b(T t7) {
        int i8;
        int i9 = this.f17526k;
        while (true) {
            i8 = this.f17527l;
            if (i9 >= i8) {
                break;
            }
            long T = T(q0(this.f17525j[i9]));
            Object G = UnsafeUtil.G(t7, T);
            if (G != null) {
                UnsafeUtil.V(t7, T, this.f17532q.f(G));
            }
            i9++;
        }
        int length = this.f17525j.length;
        while (i8 < length) {
            this.f17529n.c(t7, this.f17525j[i8]);
            i8++;
        }
        this.f17530o.j(t7);
        if (this.f17521f) {
            this.f17531p.f(t7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b0(T t7, byte[] bArr, int i8, int i9, int i10, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i11;
        MessageSchema<T> messageSchema;
        int i12;
        T t8;
        byte b8;
        int e02;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        T t9;
        T t10;
        int i21;
        T t11;
        int i22;
        int i23;
        MessageSchema<T> messageSchema2 = this;
        T t12 = t7;
        byte[] bArr2 = bArr;
        int i24 = i9;
        int i25 = i10;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe2 = f17515s;
        int i26 = i8;
        int i27 = -1;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 1048575;
        while (true) {
            if (i26 < i24) {
                int i32 = i26 + 1;
                byte b9 = bArr2[i26];
                if (b9 < 0) {
                    int H = ArrayDecoders.H(b9, bArr2, i32, registers2);
                    b8 = registers2.f17161a;
                    i32 = H;
                } else {
                    b8 = b9;
                }
                int i33 = b8 >>> 3;
                int i34 = b8 & 7;
                if (i33 > i27) {
                    e02 = messageSchema2.f0(i33, i28 / 3);
                } else {
                    e02 = messageSchema2.e0(i33);
                }
                int i35 = e02;
                if (i35 == -1) {
                    i13 = i33;
                    i14 = i32;
                    i15 = b8;
                    i16 = i30;
                    i17 = i31;
                    unsafe = unsafe2;
                    i11 = i25;
                    i18 = 0;
                } else {
                    int i36 = messageSchema2.f17516a[i35 + 1];
                    int p02 = p0(i36);
                    long T = T(i36);
                    int i37 = b8;
                    if (p02 <= 17) {
                        int i38 = messageSchema2.f17516a[i35 + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = i38 & 1048575;
                        if (i40 != i31) {
                            if (i31 != 1048575) {
                                unsafe2.putInt(t12, i31, i30);
                            }
                            i30 = unsafe2.getInt(t12, i40);
                            i17 = i40;
                        } else {
                            i17 = i31;
                        }
                        int i41 = i30;
                        switch (p02) {
                            case 0:
                                t9 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 1) {
                                    UnsafeUtil.R(t9, T, ArrayDecoders.d(bArr2, i32));
                                    i26 = i32 + 8;
                                    i30 = i41 | i39;
                                    i24 = i9;
                                    t12 = t9;
                                    i28 = i19;
                                    i29 = i20;
                                    i27 = i13;
                                    i31 = i17;
                                    i25 = i10;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 1:
                                t9 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 5) {
                                    UnsafeUtil.S(t9, T, ArrayDecoders.l(bArr2, i32));
                                    i26 = i32 + 4;
                                    i30 = i41 | i39;
                                    i24 = i9;
                                    t12 = t9;
                                    i28 = i19;
                                    i29 = i20;
                                    i27 = i13;
                                    i31 = i17;
                                    i25 = i10;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 2:
                            case 3:
                                T t13 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 0) {
                                    int L = ArrayDecoders.L(bArr2, i32, registers2);
                                    t10 = t13;
                                    unsafe2.putLong(t7, T, registers2.f17162b);
                                    i30 = i41 | i39;
                                    i26 = L;
                                    i28 = i19;
                                    i29 = i20;
                                    t12 = t10;
                                    i27 = i13;
                                    i31 = i17;
                                    i24 = i9;
                                    i25 = i10;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 4:
                            case 11:
                                t9 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.I(bArr2, i32, registers2);
                                    unsafe2.putInt(t9, T, registers2.f17161a);
                                    i30 = i41 | i39;
                                    i24 = i9;
                                    t12 = t9;
                                    i28 = i19;
                                    i29 = i20;
                                    i27 = i13;
                                    i31 = i17;
                                    i25 = i10;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 5:
                            case 14:
                                T t14 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 1) {
                                    t10 = t14;
                                    unsafe2.putLong(t7, T, ArrayDecoders.j(bArr2, i32));
                                    i26 = i32 + 8;
                                    i30 = i41 | i39;
                                    i28 = i19;
                                    i29 = i20;
                                    t12 = t10;
                                    i27 = i13;
                                    i31 = i17;
                                    i24 = i9;
                                    i25 = i10;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 6:
                            case 13:
                                i21 = i9;
                                t11 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 5) {
                                    unsafe2.putInt(t11, T, ArrayDecoders.h(bArr2, i32));
                                    i26 = i32 + 4;
                                    int i42 = i41 | i39;
                                    t12 = t11;
                                    i24 = i21;
                                    i28 = i19;
                                    i29 = i20;
                                    i31 = i17;
                                    i25 = i10;
                                    i30 = i42;
                                    i27 = i13;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 7:
                                i21 = i9;
                                t11 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.L(bArr2, i32, registers2);
                                    UnsafeUtil.L(t11, T, registers2.f17162b != 0);
                                    int i422 = i41 | i39;
                                    t12 = t11;
                                    i24 = i21;
                                    i28 = i19;
                                    i29 = i20;
                                    i31 = i17;
                                    i25 = i10;
                                    i30 = i422;
                                    i27 = i13;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 8:
                                i21 = i9;
                                t11 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 2) {
                                    if ((i36 & 536870912) == 0) {
                                        i26 = ArrayDecoders.C(bArr2, i32, registers2);
                                    } else {
                                        i26 = ArrayDecoders.F(bArr2, i32, registers2);
                                    }
                                    unsafe2.putObject(t11, T, registers2.f17163c);
                                    int i4222 = i41 | i39;
                                    t12 = t11;
                                    i24 = i21;
                                    i28 = i19;
                                    i29 = i20;
                                    i31 = i17;
                                    i25 = i10;
                                    i30 = i4222;
                                    i27 = i13;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 9:
                                t11 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 2) {
                                    i21 = i9;
                                    i26 = ArrayDecoders.p(messageSchema2.t(i19), bArr2, i32, i21, registers2);
                                    if ((i41 & i39) == 0) {
                                        unsafe2.putObject(t11, T, registers2.f17163c);
                                    } else {
                                        unsafe2.putObject(t11, T, Internal.h(unsafe2.getObject(t11, T), registers2.f17163c));
                                    }
                                    int i42222 = i41 | i39;
                                    t12 = t11;
                                    i24 = i21;
                                    i28 = i19;
                                    i29 = i20;
                                    i31 = i17;
                                    i25 = i10;
                                    i30 = i42222;
                                    i27 = i13;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 10:
                                t9 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 2) {
                                    i26 = ArrayDecoders.b(bArr2, i32, registers2);
                                    unsafe2.putObject(t9, T, registers2.f17163c);
                                    i30 = i41 | i39;
                                    i24 = i9;
                                    t12 = t9;
                                    i28 = i19;
                                    i29 = i20;
                                    i27 = i13;
                                    i31 = i17;
                                    i25 = i10;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 12:
                                t9 = t12;
                                i19 = i35;
                                i13 = i33;
                                i20 = i37;
                                bArr2 = bArr;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.I(bArr2, i32, registers2);
                                    int i43 = registers2.f17161a;
                                    Internal.EnumVerifier r7 = messageSchema2.r(i19);
                                    if (r7 != null && !r7.a(i43)) {
                                        u(t7).q(i20, Long.valueOf(i43));
                                        i24 = i9;
                                        t12 = t9;
                                        i30 = i41;
                                        i28 = i19;
                                        i29 = i20;
                                        i27 = i13;
                                        i31 = i17;
                                        i25 = i10;
                                    } else {
                                        unsafe2.putInt(t9, T, i43);
                                        i30 = i41 | i39;
                                        i24 = i9;
                                        t12 = t9;
                                        i28 = i19;
                                        i29 = i20;
                                        i27 = i13;
                                        i31 = i17;
                                        i25 = i10;
                                        break;
                                    }
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                                break;
                            case 15:
                                i19 = i35;
                                i20 = i37;
                                bArr2 = bArr;
                                i13 = i33;
                                if (i34 == 0) {
                                    i26 = ArrayDecoders.I(bArr2, i32, registers2);
                                    t9 = t7;
                                    unsafe2.putInt(t9, T, CodedInputStream.c(registers2.f17161a));
                                    i30 = i41 | i39;
                                    i24 = i9;
                                    t12 = t9;
                                    i28 = i19;
                                    i29 = i20;
                                    i27 = i13;
                                    i31 = i17;
                                    i25 = i10;
                                    break;
                                } else {
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 16:
                                i19 = i35;
                                i13 = i33;
                                if (i34 == 0) {
                                    bArr2 = bArr;
                                    int L2 = ArrayDecoders.L(bArr2, i32, registers2);
                                    i20 = i37;
                                    unsafe2.putLong(t7, T, CodedInputStream.d(registers2.f17162b));
                                    i30 = i41 | i39;
                                    t12 = t7;
                                    i24 = i9;
                                    i26 = L2;
                                    i28 = i19;
                                    i29 = i20;
                                    i27 = i13;
                                    i31 = i17;
                                    i25 = i10;
                                    break;
                                } else {
                                    i20 = i37;
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            case 17:
                                if (i34 == 3) {
                                    i26 = ArrayDecoders.n(messageSchema2.t(i35), bArr, i32, i9, (i33 << 3) | 4, registers);
                                    if ((i41 & i39) == 0) {
                                        unsafe2.putObject(t12, T, registers2.f17163c);
                                    } else {
                                        unsafe2.putObject(t12, T, Internal.h(unsafe2.getObject(t12, T), registers2.f17163c));
                                    }
                                    i30 = i41 | i39;
                                    bArr2 = bArr;
                                    i24 = i9;
                                    i25 = i10;
                                    i29 = i37;
                                    i28 = i35;
                                    i27 = i33;
                                    i31 = i17;
                                    break;
                                } else {
                                    i19 = i35;
                                    i13 = i33;
                                    i20 = i37;
                                    i14 = i32;
                                    i16 = i41;
                                    i18 = i19;
                                    unsafe = unsafe2;
                                    i15 = i20;
                                    i11 = i10;
                                    break;
                                }
                            default:
                                i19 = i35;
                                i20 = i37;
                                i13 = i33;
                                i14 = i32;
                                i16 = i41;
                                i18 = i19;
                                unsafe = unsafe2;
                                i15 = i20;
                                i11 = i10;
                                break;
                        }
                    } else {
                        i13 = i33;
                        T t15 = t12;
                        bArr2 = bArr;
                        if (p02 != 27) {
                            i18 = i35;
                            i16 = i30;
                            i17 = i31;
                            if (p02 <= 49) {
                                int i44 = i32;
                                unsafe = unsafe2;
                                i23 = i37;
                                i26 = d0(t7, bArr, i32, i9, i37, i13, i34, i18, i36, p02, T, registers);
                                if (i26 != i44) {
                                    messageSchema2 = this;
                                    t12 = t7;
                                    bArr2 = bArr;
                                    i24 = i9;
                                    i25 = i10;
                                    registers2 = registers;
                                    i27 = i13;
                                    i29 = i23;
                                    i28 = i18;
                                    i30 = i16;
                                    i31 = i17;
                                    unsafe2 = unsafe;
                                } else {
                                    i11 = i10;
                                    i14 = i26;
                                    i15 = i23;
                                }
                            } else {
                                i22 = i32;
                                unsafe = unsafe2;
                                i23 = i37;
                                if (p02 != 50) {
                                    i26 = a0(t7, bArr, i22, i9, i23, i13, i34, i36, p02, T, i18, registers);
                                    if (i26 != i22) {
                                        messageSchema2 = this;
                                        t12 = t7;
                                        bArr2 = bArr;
                                        i24 = i9;
                                        i25 = i10;
                                        registers2 = registers;
                                        i27 = i13;
                                        i29 = i23;
                                        i28 = i18;
                                        i30 = i16;
                                        i31 = i17;
                                        unsafe2 = unsafe;
                                    } else {
                                        i11 = i10;
                                        i14 = i26;
                                        i15 = i23;
                                    }
                                } else if (i34 == 2) {
                                    i26 = Z(t7, bArr, i22, i9, i18, T, registers);
                                    if (i26 != i22) {
                                        messageSchema2 = this;
                                        t12 = t7;
                                        bArr2 = bArr;
                                        i24 = i9;
                                        i25 = i10;
                                        registers2 = registers;
                                        i27 = i13;
                                        i29 = i23;
                                        i28 = i18;
                                        i30 = i16;
                                        i31 = i17;
                                        unsafe2 = unsafe;
                                    } else {
                                        i11 = i10;
                                        i14 = i26;
                                        i15 = i23;
                                    }
                                }
                            }
                        } else if (i34 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t15, T);
                            if (!protobufList.h()) {
                                int size = protobufList.size();
                                protobufList = protobufList.a(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t15, T, protobufList);
                            }
                            i17 = i31;
                            i26 = ArrayDecoders.q(messageSchema2.t(i35), i37, bArr, i32, i9, protobufList, registers);
                            t12 = t7;
                            i24 = i9;
                            i29 = i37;
                            i27 = i13;
                            i28 = i35;
                            i30 = i30;
                            i31 = i17;
                            i25 = i10;
                        } else {
                            i18 = i35;
                            i16 = i30;
                            i17 = i31;
                            i22 = i32;
                            unsafe = unsafe2;
                            i23 = i37;
                        }
                        i11 = i10;
                        i14 = i22;
                        i15 = i23;
                    }
                }
                if (i15 != i11 || i11 == 0) {
                    if (this.f17521f && registers.f17164d != ExtensionRegistryLite.b()) {
                        i26 = ArrayDecoders.g(i15, bArr, i14, i9, t7, this.f17520e, this.f17530o, registers);
                    } else {
                        i26 = ArrayDecoders.G(i15, bArr, i14, i9, u(t7), registers);
                    }
                    t12 = t7;
                    bArr2 = bArr;
                    i24 = i9;
                    i29 = i15;
                    messageSchema2 = this;
                    registers2 = registers;
                    i27 = i13;
                    i28 = i18;
                    i30 = i16;
                    i31 = i17;
                    unsafe2 = unsafe;
                    i25 = i11;
                } else {
                    i12 = 1048575;
                    messageSchema = this;
                    i26 = i14;
                    i29 = i15;
                    i30 = i16;
                    i31 = i17;
                }
            } else {
                unsafe = unsafe2;
                i11 = i25;
                messageSchema = messageSchema2;
                i12 = 1048575;
            }
        }
        if (i31 != i12) {
            t8 = t7;
            unsafe.putInt(t8, i31, i30);
        } else {
            t8 = t7;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i45 = messageSchema.f17526k; i45 < messageSchema.f17527l; i45++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.o(t8, messageSchema.f17525j[i45], unknownFieldSetLite, messageSchema.f17530o);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.f17530o.o(t8, unknownFieldSetLite);
        }
        if (i11 == 0) {
            if (i26 != i9) {
                throw InvalidProtocolBufferException.h();
            }
        } else if (i26 > i9 || i29 != i11) {
            throw InvalidProtocolBufferException.h();
        }
        return i26;
    }

    @Override // com.google.protobuf.Schema
    public final boolean c(T t7) {
        int i8;
        int i9;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 0;
        while (i12 < this.f17526k) {
            int i13 = this.f17525j[i12];
            int S = S(i13);
            int q02 = q0(i13);
            int i14 = this.f17516a[i13 + 2];
            int i15 = i14 & 1048575;
            int i16 = 1 << (i14 >>> 20);
            if (i15 != i10) {
                if (i15 != 1048575) {
                    i11 = f17515s.getInt(t7, i15);
                }
                i9 = i11;
                i8 = i15;
            } else {
                i8 = i10;
                i9 = i11;
            }
            if (H(q02) && !B(t7, i13, i8, i9, i16)) {
                return false;
            }
            int p02 = p0(q02);
            if (p02 != 9 && p02 != 17) {
                if (p02 != 27) {
                    if (p02 != 60 && p02 != 68) {
                        if (p02 != 49) {
                            if (p02 == 50 && !E(t7, q02, i13)) {
                                return false;
                            }
                        }
                    } else if (G(t7, S, i13) && !C(t7, q02, t(i13))) {
                        return false;
                    }
                }
                if (!D(t7, q02, i13)) {
                    return false;
                }
            } else if (B(t7, i13, i8, i9, i16) && !C(t7, q02, t(i13))) {
                return false;
            }
            i12++;
            i10 = i8;
            i11 = i9;
        }
        if (this.f17521f && !this.f17531p.c(t7).s()) {
            return false;
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int d(T t7) {
        if (this.f17523h) {
            return w(t7);
        }
        return v(t7);
    }

    @Override // com.google.protobuf.Schema
    public T e() {
        return (T) this.f17528m.a(this.f17520e);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t7, T t8) {
        int length = this.f17516a.length;
        for (int i8 = 0; i8 < length; i8 += 3) {
            if (!n(t7, t8, i8)) {
                return false;
            }
        }
        if (!this.f17530o.g(t7).equals(this.f17530o.g(t8))) {
            return false;
        }
        if (this.f17521f) {
            return this.f17531p.c(t7).equals(this.f17531p.c(t8));
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public void f(T t7, Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            t0(t7, writer);
        } else if (this.f17523h) {
            s0(t7, writer);
        } else {
            r0(t7, writer);
        }
    }

    @Override // com.google.protobuf.Schema
    public void g(T t7, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        K(this.f17530o, this.f17531p, t7, reader, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Schema
    public void h(T t7, byte[] bArr, int i8, int i9, ArrayDecoders.Registers registers) throws IOException {
        if (this.f17523h) {
            c0(t7, bArr, i8, i9, registers);
        } else {
            b0(t7, bArr, i8, i9, 0, registers);
        }
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t7) {
        int i8;
        int f8;
        int length = this.f17516a.length;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int q02 = q0(i10);
            int S = S(i10);
            long T = T(q02);
            int i11 = 37;
            switch (p0(q02)) {
                case 0:
                    i8 = i9 * 53;
                    f8 = Internal.f(Double.doubleToLongBits(UnsafeUtil.A(t7, T)));
                    i9 = i8 + f8;
                    break;
                case 1:
                    i8 = i9 * 53;
                    f8 = Float.floatToIntBits(UnsafeUtil.B(t7, T));
                    i9 = i8 + f8;
                    break;
                case 2:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.E(t7, T));
                    i9 = i8 + f8;
                    break;
                case 3:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.E(t7, T));
                    i9 = i8 + f8;
                    break;
                case 4:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.C(t7, T);
                    i9 = i8 + f8;
                    break;
                case 5:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.E(t7, T));
                    i9 = i8 + f8;
                    break;
                case 6:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.C(t7, T);
                    i9 = i8 + f8;
                    break;
                case 7:
                    i8 = i9 * 53;
                    f8 = Internal.c(UnsafeUtil.t(t7, T));
                    i9 = i8 + f8;
                    break;
                case 8:
                    i8 = i9 * 53;
                    f8 = ((String) UnsafeUtil.G(t7, T)).hashCode();
                    i9 = i8 + f8;
                    break;
                case 9:
                    Object G = UnsafeUtil.G(t7, T);
                    if (G != null) {
                        i11 = G.hashCode();
                    }
                    i9 = (i9 * 53) + i11;
                    break;
                case 10:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.G(t7, T).hashCode();
                    i9 = i8 + f8;
                    break;
                case 11:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.C(t7, T);
                    i9 = i8 + f8;
                    break;
                case 12:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.C(t7, T);
                    i9 = i8 + f8;
                    break;
                case 13:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.C(t7, T);
                    i9 = i8 + f8;
                    break;
                case 14:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.E(t7, T));
                    i9 = i8 + f8;
                    break;
                case 15:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.C(t7, T);
                    i9 = i8 + f8;
                    break;
                case 16:
                    i8 = i9 * 53;
                    f8 = Internal.f(UnsafeUtil.E(t7, T));
                    i9 = i8 + f8;
                    break;
                case 17:
                    Object G2 = UnsafeUtil.G(t7, T);
                    if (G2 != null) {
                        i11 = G2.hashCode();
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
                    f8 = UnsafeUtil.G(t7, T).hashCode();
                    i9 = i8 + f8;
                    break;
                case 50:
                    i8 = i9 * 53;
                    f8 = UnsafeUtil.G(t7, T).hashCode();
                    i9 = i8 + f8;
                    break;
                case 51:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(Double.doubleToLongBits(V(t7, T)));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Float.floatToIntBits(W(t7, T));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(Y(t7, T));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(Y(t7, T));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = X(t7, T);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(Y(t7, T));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = X(t7, T);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.c(U(t7, T));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = ((String) UnsafeUtil.G(t7, T)).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = UnsafeUtil.G(t7, T).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = UnsafeUtil.G(t7, T).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = X(t7, T);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = X(t7, T);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = X(t7, T);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(Y(t7, T));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = X(t7, T);
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = Internal.f(Y(t7, T));
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (G(t7, S, i10)) {
                        i8 = i9 * 53;
                        f8 = UnsafeUtil.G(t7, T).hashCode();
                        i9 = i8 + f8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i9 * 53) + this.f17530o.g(t7).hashCode();
        if (this.f17521f) {
            return (hashCode * 53) + this.f17531p.c(t7).hashCode();
        }
        return hashCode;
    }
}
