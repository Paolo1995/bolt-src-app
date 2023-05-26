package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class WireFormat {

    /* renamed from: a  reason: collision with root package name */
    static final int f15267a = c(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f15268b = c(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f15269c = c(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f15270d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum j uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static class FieldType {

        /* renamed from: h  reason: collision with root package name */
        public static final FieldType f15271h;

        /* renamed from: i  reason: collision with root package name */
        public static final FieldType f15272i;

        /* renamed from: j  reason: collision with root package name */
        public static final FieldType f15273j;

        /* renamed from: k  reason: collision with root package name */
        public static final FieldType f15274k;

        /* renamed from: l  reason: collision with root package name */
        public static final FieldType f15275l;

        /* renamed from: m  reason: collision with root package name */
        public static final FieldType f15276m;

        /* renamed from: n  reason: collision with root package name */
        public static final FieldType f15277n;

        /* renamed from: o  reason: collision with root package name */
        public static final FieldType f15278o;

        /* renamed from: p  reason: collision with root package name */
        public static final FieldType f15279p;

        /* renamed from: q  reason: collision with root package name */
        public static final FieldType f15280q;

        /* renamed from: r  reason: collision with root package name */
        public static final FieldType f15281r;

        /* renamed from: s  reason: collision with root package name */
        public static final FieldType f15282s;

        /* renamed from: t  reason: collision with root package name */
        public static final FieldType f15283t;

        /* renamed from: u  reason: collision with root package name */
        public static final FieldType f15284u;

        /* renamed from: v  reason: collision with root package name */
        public static final FieldType f15285v;

        /* renamed from: w  reason: collision with root package name */
        public static final FieldType f15286w;

        /* renamed from: x  reason: collision with root package name */
        public static final FieldType f15287x;

        /* renamed from: y  reason: collision with root package name */
        public static final FieldType f15288y;

        /* renamed from: z  reason: collision with root package name */
        private static final /* synthetic */ FieldType[] f15289z;

        /* renamed from: f  reason: collision with root package name */
        private final JavaType f15290f;

        /* renamed from: g  reason: collision with root package name */
        private final int f15291g;

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            f15271h = fieldType;
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            f15272i = fieldType2;
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            f15273j = fieldType3;
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            f15274k = fieldType4;
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            f15275l = fieldType5;
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            f15276m = fieldType6;
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            f15277n = fieldType7;
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            f15278o = fieldType8;
            FieldType fieldType9 = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.1
            };
            f15279p = fieldType9;
            JavaType javaType3 = JavaType.MESSAGE;
            FieldType fieldType10 = new FieldType("GROUP", 9, javaType3, 3) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.2
            };
            f15280q = fieldType10;
            FieldType fieldType11 = new FieldType("MESSAGE", 10, javaType3, 2) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.3
            };
            f15281r = fieldType11;
            FieldType fieldType12 = new FieldType("BYTES", 11, JavaType.BYTE_STRING, 2) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.4
            };
            f15282s = fieldType12;
            FieldType fieldType13 = new FieldType("UINT32", 12, javaType2, 0);
            f15283t = fieldType13;
            FieldType fieldType14 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            f15284u = fieldType14;
            FieldType fieldType15 = new FieldType("SFIXED32", 14, javaType2, 5);
            f15285v = fieldType15;
            FieldType fieldType16 = new FieldType("SFIXED64", 15, javaType, 1);
            f15286w = fieldType16;
            FieldType fieldType17 = new FieldType("SINT32", 16, javaType2, 0);
            f15287x = fieldType17;
            FieldType fieldType18 = new FieldType("SINT64", 17, javaType, 0);
            f15288y = fieldType18;
            f15289z = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18};
        }

        public static FieldType valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) f15289z.clone();
        }

        public JavaType a() {
            return this.f15290f;
        }

        private FieldType(String str, int i8, JavaType javaType, int i9) {
            this.f15290f = javaType;
            this.f15291g = i9;
        }
    }

    /* loaded from: classes.dex */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.f14989g),
        ENUM(null),
        MESSAGE(null);
        

        /* renamed from: f  reason: collision with root package name */
        private final Object f15302f;

        JavaType(Object obj) {
            this.f15302f = obj;
        }
    }

    private WireFormat() {
    }

    public static int a(int i8) {
        return i8 >>> 3;
    }

    public static int b(int i8) {
        return i8 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i8, int i9) {
        return (i8 << 3) | i9;
    }
}
