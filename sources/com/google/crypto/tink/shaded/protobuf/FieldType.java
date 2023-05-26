package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum k uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class FieldType {
    public static final FieldType A;
    public static final FieldType B;
    public static final FieldType C;
    public static final FieldType D;
    public static final FieldType E;
    public static final FieldType F;
    public static final FieldType G;
    public static final FieldType H;
    public static final FieldType I;
    public static final FieldType J;
    public static final FieldType K;
    public static final FieldType L;
    public static final FieldType M;
    public static final FieldType N;
    public static final FieldType O;
    public static final FieldType P;
    public static final FieldType Q;
    public static final FieldType R;
    public static final FieldType S;
    public static final FieldType T;
    public static final FieldType U;
    public static final FieldType V;
    public static final FieldType W;
    public static final FieldType X;
    public static final FieldType Y;
    public static final FieldType Z;

    /* renamed from: a0  reason: collision with root package name */
    public static final FieldType f15048a0;

    /* renamed from: b0  reason: collision with root package name */
    public static final FieldType f15049b0;

    /* renamed from: c0  reason: collision with root package name */
    public static final FieldType f15050c0;

    /* renamed from: d0  reason: collision with root package name */
    public static final FieldType f15051d0;

    /* renamed from: e0  reason: collision with root package name */
    public static final FieldType f15052e0;

    /* renamed from: f0  reason: collision with root package name */
    public static final FieldType f15053f0;

    /* renamed from: g0  reason: collision with root package name */
    public static final FieldType f15054g0;

    /* renamed from: h0  reason: collision with root package name */
    public static final FieldType f15055h0;

    /* renamed from: i0  reason: collision with root package name */
    public static final FieldType f15056i0;

    /* renamed from: j0  reason: collision with root package name */
    private static final FieldType[] f15057j0;

    /* renamed from: k  reason: collision with root package name */
    public static final FieldType f15058k;

    /* renamed from: k0  reason: collision with root package name */
    private static final Type[] f15059k0;

    /* renamed from: l  reason: collision with root package name */
    public static final FieldType f15060l;

    /* renamed from: l0  reason: collision with root package name */
    private static final /* synthetic */ FieldType[] f15061l0;

    /* renamed from: m  reason: collision with root package name */
    public static final FieldType f15062m;

    /* renamed from: n  reason: collision with root package name */
    public static final FieldType f15063n;

    /* renamed from: o  reason: collision with root package name */
    public static final FieldType f15064o;

    /* renamed from: p  reason: collision with root package name */
    public static final FieldType f15065p;

    /* renamed from: q  reason: collision with root package name */
    public static final FieldType f15066q;

    /* renamed from: r  reason: collision with root package name */
    public static final FieldType f15067r;

    /* renamed from: s  reason: collision with root package name */
    public static final FieldType f15068s;

    /* renamed from: t  reason: collision with root package name */
    public static final FieldType f15069t;

    /* renamed from: u  reason: collision with root package name */
    public static final FieldType f15070u;

    /* renamed from: v  reason: collision with root package name */
    public static final FieldType f15071v;

    /* renamed from: w  reason: collision with root package name */
    public static final FieldType f15072w;

    /* renamed from: x  reason: collision with root package name */
    public static final FieldType f15073x;

    /* renamed from: y  reason: collision with root package name */
    public static final FieldType f15074y;

    /* renamed from: z  reason: collision with root package name */
    public static final FieldType f15075z;

    /* renamed from: f  reason: collision with root package name */
    private final JavaType f15076f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15077g;

    /* renamed from: h  reason: collision with root package name */
    private final Collection f15078h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<?> f15079i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f15080j;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.FieldType$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15081a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f15082b;

        static {
            int[] iArr = new int[JavaType.values().length];
            f15082b = iArr;
            try {
                iArr[JavaType.f15128p.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15082b[JavaType.f15130r.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15082b[JavaType.f15127o.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Collection.values().length];
            f15081a = iArr2;
            try {
                iArr2[Collection.MAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15081a[Collection.VECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15081a[Collection.SCALAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    enum Collection {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        

        /* renamed from: f  reason: collision with root package name */
        private final boolean f15088f;

        Collection(boolean z7) {
            this.f15088f = z7;
        }
    }

    static {
        Collection collection = Collection.SCALAR;
        JavaType javaType = JavaType.f15125m;
        FieldType fieldType = new FieldType("DOUBLE", 0, 0, collection, javaType);
        f15058k = fieldType;
        JavaType javaType2 = JavaType.f15124l;
        FieldType fieldType2 = new FieldType("FLOAT", 1, 1, collection, javaType2);
        f15060l = fieldType2;
        JavaType javaType3 = JavaType.f15123k;
        FieldType fieldType3 = new FieldType("INT64", 2, 2, collection, javaType3);
        f15062m = fieldType3;
        FieldType fieldType4 = new FieldType("UINT64", 3, 3, collection, javaType3);
        f15063n = fieldType4;
        JavaType javaType4 = JavaType.f15122j;
        FieldType fieldType5 = new FieldType("INT32", 4, 4, collection, javaType4);
        f15064o = fieldType5;
        FieldType fieldType6 = new FieldType("FIXED64", 5, 5, collection, javaType3);
        f15065p = fieldType6;
        FieldType fieldType7 = new FieldType("FIXED32", 6, 6, collection, javaType4);
        f15066q = fieldType7;
        JavaType javaType5 = JavaType.f15126n;
        FieldType fieldType8 = new FieldType("BOOL", 7, 7, collection, javaType5);
        f15067r = fieldType8;
        JavaType javaType6 = JavaType.f15127o;
        FieldType fieldType9 = new FieldType("STRING", 8, 8, collection, javaType6);
        f15068s = fieldType9;
        JavaType javaType7 = JavaType.f15130r;
        FieldType fieldType10 = new FieldType("MESSAGE", 9, 9, collection, javaType7);
        f15069t = fieldType10;
        JavaType javaType8 = JavaType.f15128p;
        FieldType fieldType11 = new FieldType("BYTES", 10, 10, collection, javaType8);
        f15070u = fieldType11;
        FieldType fieldType12 = new FieldType("UINT32", 11, 11, collection, javaType4);
        f15071v = fieldType12;
        JavaType javaType9 = JavaType.f15129q;
        FieldType fieldType13 = new FieldType("ENUM", 12, 12, collection, javaType9);
        f15072w = fieldType13;
        FieldType fieldType14 = new FieldType("SFIXED32", 13, 13, collection, javaType4);
        f15073x = fieldType14;
        FieldType fieldType15 = new FieldType("SFIXED64", 14, 14, collection, javaType3);
        f15074y = fieldType15;
        FieldType fieldType16 = new FieldType("SINT32", 15, 15, collection, javaType4);
        f15075z = fieldType16;
        FieldType fieldType17 = new FieldType("SINT64", 16, 16, collection, javaType3);
        A = fieldType17;
        FieldType fieldType18 = new FieldType("GROUP", 17, 17, collection, javaType7);
        B = fieldType18;
        Collection collection2 = Collection.VECTOR;
        FieldType fieldType19 = new FieldType("DOUBLE_LIST", 18, 18, collection2, javaType);
        C = fieldType19;
        FieldType fieldType20 = new FieldType("FLOAT_LIST", 19, 19, collection2, javaType2);
        D = fieldType20;
        FieldType fieldType21 = new FieldType("INT64_LIST", 20, 20, collection2, javaType3);
        E = fieldType21;
        FieldType fieldType22 = new FieldType("UINT64_LIST", 21, 21, collection2, javaType3);
        F = fieldType22;
        FieldType fieldType23 = new FieldType("INT32_LIST", 22, 22, collection2, javaType4);
        G = fieldType23;
        FieldType fieldType24 = new FieldType("FIXED64_LIST", 23, 23, collection2, javaType3);
        H = fieldType24;
        FieldType fieldType25 = new FieldType("FIXED32_LIST", 24, 24, collection2, javaType4);
        I = fieldType25;
        FieldType fieldType26 = new FieldType("BOOL_LIST", 25, 25, collection2, javaType5);
        J = fieldType26;
        FieldType fieldType27 = new FieldType("STRING_LIST", 26, 26, collection2, javaType6);
        K = fieldType27;
        FieldType fieldType28 = new FieldType("MESSAGE_LIST", 27, 27, collection2, javaType7);
        L = fieldType28;
        FieldType fieldType29 = new FieldType("BYTES_LIST", 28, 28, collection2, javaType8);
        M = fieldType29;
        FieldType fieldType30 = new FieldType("UINT32_LIST", 29, 29, collection2, javaType4);
        N = fieldType30;
        FieldType fieldType31 = new FieldType("ENUM_LIST", 30, 30, collection2, javaType9);
        O = fieldType31;
        FieldType fieldType32 = new FieldType("SFIXED32_LIST", 31, 31, collection2, javaType4);
        P = fieldType32;
        FieldType fieldType33 = new FieldType("SFIXED64_LIST", 32, 32, collection2, javaType3);
        Q = fieldType33;
        FieldType fieldType34 = new FieldType("SINT32_LIST", 33, 33, collection2, javaType4);
        R = fieldType34;
        FieldType fieldType35 = new FieldType("SINT64_LIST", 34, 34, collection2, javaType3);
        S = fieldType35;
        Collection collection3 = Collection.PACKED_VECTOR;
        FieldType fieldType36 = new FieldType("DOUBLE_LIST_PACKED", 35, 35, collection3, javaType);
        T = fieldType36;
        FieldType fieldType37 = new FieldType("FLOAT_LIST_PACKED", 36, 36, collection3, javaType2);
        U = fieldType37;
        FieldType fieldType38 = new FieldType("INT64_LIST_PACKED", 37, 37, collection3, javaType3);
        V = fieldType38;
        FieldType fieldType39 = new FieldType("UINT64_LIST_PACKED", 38, 38, collection3, javaType3);
        W = fieldType39;
        FieldType fieldType40 = new FieldType("INT32_LIST_PACKED", 39, 39, collection3, javaType4);
        X = fieldType40;
        FieldType fieldType41 = new FieldType("FIXED64_LIST_PACKED", 40, 40, collection3, javaType3);
        Y = fieldType41;
        FieldType fieldType42 = new FieldType("FIXED32_LIST_PACKED", 41, 41, collection3, javaType4);
        Z = fieldType42;
        FieldType fieldType43 = new FieldType("BOOL_LIST_PACKED", 42, 42, collection3, javaType5);
        f15048a0 = fieldType43;
        FieldType fieldType44 = new FieldType("UINT32_LIST_PACKED", 43, 43, collection3, javaType4);
        f15049b0 = fieldType44;
        FieldType fieldType45 = new FieldType("ENUM_LIST_PACKED", 44, 44, collection3, javaType9);
        f15050c0 = fieldType45;
        FieldType fieldType46 = new FieldType("SFIXED32_LIST_PACKED", 45, 45, collection3, javaType4);
        f15051d0 = fieldType46;
        FieldType fieldType47 = new FieldType("SFIXED64_LIST_PACKED", 46, 46, collection3, javaType3);
        f15052e0 = fieldType47;
        FieldType fieldType48 = new FieldType("SINT32_LIST_PACKED", 47, 47, collection3, javaType4);
        f15053f0 = fieldType48;
        FieldType fieldType49 = new FieldType("SINT64_LIST_PACKED", 48, 48, collection3, javaType3);
        f15054g0 = fieldType49;
        FieldType fieldType50 = new FieldType("GROUP_LIST", 49, 49, collection2, javaType7);
        f15055h0 = fieldType50;
        FieldType fieldType51 = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.f15121i);
        f15056i0 = fieldType51;
        f15061l0 = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18, fieldType19, fieldType20, fieldType21, fieldType22, fieldType23, fieldType24, fieldType25, fieldType26, fieldType27, fieldType28, fieldType29, fieldType30, fieldType31, fieldType32, fieldType33, fieldType34, fieldType35, fieldType36, fieldType37, fieldType38, fieldType39, fieldType40, fieldType41, fieldType42, fieldType43, fieldType44, fieldType45, fieldType46, fieldType47, fieldType48, fieldType49, fieldType50, fieldType51};
        f15059k0 = new Type[0];
        FieldType[] values = values();
        f15057j0 = new FieldType[values.length];
        for (FieldType fieldType52 : values) {
            f15057j0[fieldType52.f15077g] = fieldType52;
        }
    }

    private FieldType(String str, int i8, int i9, Collection collection, JavaType javaType) {
        int i10;
        this.f15077g = i9;
        this.f15078h = collection;
        this.f15076f = javaType;
        int i11 = AnonymousClass1.f15081a[collection.ordinal()];
        boolean z7 = true;
        if (i11 != 1) {
            if (i11 != 2) {
                this.f15079i = null;
            } else {
                this.f15079i = javaType.a();
            }
        } else {
            this.f15079i = javaType.a();
        }
        this.f15080j = (collection != Collection.SCALAR || (i10 = AnonymousClass1.f15082b[javaType.ordinal()]) == 1 || i10 == 2 || i10 == 3) ? false : false;
    }

    public static FieldType valueOf(String str) {
        return (FieldType) Enum.valueOf(FieldType.class, str);
    }

    public static FieldType[] values() {
        return (FieldType[]) f15061l0.clone();
    }

    public int a() {
        return this.f15077g;
    }
}
