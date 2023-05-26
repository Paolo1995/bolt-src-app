package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class WireFormat {

    /* renamed from: a  reason: collision with root package name */
    static final int f17667a = c(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f17668b = c(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f17669c = c(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f17670d = c(3, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.WireFormat$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17671a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f17671a = iArr;
            try {
                iArr[FieldType.f17672h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17671a[FieldType.f17673i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17671a[FieldType.f17674j.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17671a[FieldType.f17675k.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17671a[FieldType.f17676l.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17671a[FieldType.f17677m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17671a[FieldType.f17678n.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17671a[FieldType.f17679o.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17671a[FieldType.f17683s.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17671a[FieldType.f17684t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17671a[FieldType.f17686v.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17671a[FieldType.f17687w.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17671a[FieldType.f17688x.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17671a[FieldType.f17689y.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17671a[FieldType.f17680p.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f17671a[FieldType.f17681q.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17671a[FieldType.f17682r.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f17671a[FieldType.f17685u.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

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
    /* loaded from: classes3.dex */
    public static class FieldType {

        /* renamed from: h  reason: collision with root package name */
        public static final FieldType f17672h;

        /* renamed from: i  reason: collision with root package name */
        public static final FieldType f17673i;

        /* renamed from: j  reason: collision with root package name */
        public static final FieldType f17674j;

        /* renamed from: k  reason: collision with root package name */
        public static final FieldType f17675k;

        /* renamed from: l  reason: collision with root package name */
        public static final FieldType f17676l;

        /* renamed from: m  reason: collision with root package name */
        public static final FieldType f17677m;

        /* renamed from: n  reason: collision with root package name */
        public static final FieldType f17678n;

        /* renamed from: o  reason: collision with root package name */
        public static final FieldType f17679o;

        /* renamed from: p  reason: collision with root package name */
        public static final FieldType f17680p;

        /* renamed from: q  reason: collision with root package name */
        public static final FieldType f17681q;

        /* renamed from: r  reason: collision with root package name */
        public static final FieldType f17682r;

        /* renamed from: s  reason: collision with root package name */
        public static final FieldType f17683s;

        /* renamed from: t  reason: collision with root package name */
        public static final FieldType f17684t;

        /* renamed from: u  reason: collision with root package name */
        public static final FieldType f17685u;

        /* renamed from: v  reason: collision with root package name */
        public static final FieldType f17686v;

        /* renamed from: w  reason: collision with root package name */
        public static final FieldType f17687w;

        /* renamed from: x  reason: collision with root package name */
        public static final FieldType f17688x;

        /* renamed from: y  reason: collision with root package name */
        public static final FieldType f17689y;

        /* renamed from: z  reason: collision with root package name */
        private static final /* synthetic */ FieldType[] f17690z;

        /* renamed from: f  reason: collision with root package name */
        private final JavaType f17691f;

        /* renamed from: g  reason: collision with root package name */
        private final int f17692g;

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            f17672h = fieldType;
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            f17673i = fieldType2;
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            f17674j = fieldType3;
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            f17675k = fieldType4;
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            f17676l = fieldType5;
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            f17677m = fieldType6;
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            f17678n = fieldType7;
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            f17679o = fieldType8;
            FieldType fieldType9 = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: com.google.protobuf.WireFormat.FieldType.1
                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean e() {
                    return false;
                }
            };
            f17680p = fieldType9;
            JavaType javaType3 = JavaType.MESSAGE;
            FieldType fieldType10 = new FieldType("GROUP", 9, javaType3, 3) { // from class: com.google.protobuf.WireFormat.FieldType.2
                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean e() {
                    return false;
                }
            };
            f17681q = fieldType10;
            FieldType fieldType11 = new FieldType("MESSAGE", 10, javaType3, 2) { // from class: com.google.protobuf.WireFormat.FieldType.3
                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean e() {
                    return false;
                }
            };
            f17682r = fieldType11;
            FieldType fieldType12 = new FieldType("BYTES", 11, JavaType.BYTE_STRING, 2) { // from class: com.google.protobuf.WireFormat.FieldType.4
                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean e() {
                    return false;
                }
            };
            f17683s = fieldType12;
            FieldType fieldType13 = new FieldType("UINT32", 12, javaType2, 0);
            f17684t = fieldType13;
            FieldType fieldType14 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            f17685u = fieldType14;
            FieldType fieldType15 = new FieldType("SFIXED32", 14, javaType2, 5);
            f17686v = fieldType15;
            FieldType fieldType16 = new FieldType("SFIXED64", 15, javaType, 1);
            f17687w = fieldType16;
            FieldType fieldType17 = new FieldType("SINT32", 16, javaType2, 0);
            f17688x = fieldType17;
            FieldType fieldType18 = new FieldType("SINT64", 17, javaType, 0);
            f17689y = fieldType18;
            f17690z = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18};
        }

        /* synthetic */ FieldType(String str, int i8, JavaType javaType, int i9, AnonymousClass1 anonymousClass1) {
            this(str, i8, javaType, i9);
        }

        public static FieldType valueOf(String str) {
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) f17690z.clone();
        }

        public JavaType a() {
            return this.f17691f;
        }

        public int c() {
            return this.f17692g;
        }

        public boolean e() {
            return true;
        }

        private FieldType(String str, int i8, JavaType javaType, int i9) {
            this.f17691f = javaType;
            this.f17692g = i9;
        }
    }

    /* loaded from: classes3.dex */
    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.f17177g),
        ENUM(null),
        MESSAGE(null);
        

        /* renamed from: f  reason: collision with root package name */
        private final Object f17703f;

        JavaType(Object obj) {
            this.f17703f = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Utf8Validation {
        LOOSE { // from class: com.google.protobuf.WireFormat.Utf8Validation.1
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.I();
            }
        },
        STRICT { // from class: com.google.protobuf.WireFormat.Utf8Validation.2
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.J();
            }
        },
        LAZY { // from class: com.google.protobuf.WireFormat.Utf8Validation.3
            @Override // com.google.protobuf.WireFormat.Utf8Validation
            Object a(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.s();
            }
        };

        abstract Object a(CodedInputStream codedInputStream) throws IOException;

        /* synthetic */ Utf8Validation(AnonymousClass1 anonymousClass1) {
            this();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(CodedInputStream codedInputStream, FieldType fieldType, Utf8Validation utf8Validation) throws IOException {
        switch (AnonymousClass1.f17671a[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.t());
            case 2:
                return Float.valueOf(codedInputStream.x());
            case 3:
                return Long.valueOf(codedInputStream.A());
            case 4:
                return Long.valueOf(codedInputStream.M());
            case 5:
                return Integer.valueOf(codedInputStream.z());
            case 6:
                return Long.valueOf(codedInputStream.w());
            case 7:
                return Integer.valueOf(codedInputStream.v());
            case 8:
                return Boolean.valueOf(codedInputStream.r());
            case 9:
                return codedInputStream.s();
            case 10:
                return Integer.valueOf(codedInputStream.L());
            case 11:
                return Integer.valueOf(codedInputStream.E());
            case 12:
                return Long.valueOf(codedInputStream.F());
            case 13:
                return Integer.valueOf(codedInputStream.G());
            case 14:
                return Long.valueOf(codedInputStream.H());
            case 15:
                return utf8Validation.a(codedInputStream);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
