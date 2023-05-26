package com.google.crypto.tink.shaded.protobuf;

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
public final class JavaType {

    /* renamed from: i  reason: collision with root package name */
    public static final JavaType f15121i;

    /* renamed from: j  reason: collision with root package name */
    public static final JavaType f15122j;

    /* renamed from: k  reason: collision with root package name */
    public static final JavaType f15123k;

    /* renamed from: l  reason: collision with root package name */
    public static final JavaType f15124l;

    /* renamed from: m  reason: collision with root package name */
    public static final JavaType f15125m;

    /* renamed from: n  reason: collision with root package name */
    public static final JavaType f15126n;

    /* renamed from: o  reason: collision with root package name */
    public static final JavaType f15127o;

    /* renamed from: p  reason: collision with root package name */
    public static final JavaType f15128p;

    /* renamed from: q  reason: collision with root package name */
    public static final JavaType f15129q;

    /* renamed from: r  reason: collision with root package name */
    public static final JavaType f15130r;

    /* renamed from: s  reason: collision with root package name */
    private static final /* synthetic */ JavaType[] f15131s;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f15132f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f15133g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f15134h;

    static {
        JavaType javaType = new JavaType("VOID", 0, Void.class, Void.class, null);
        f15121i = javaType;
        Class cls = Integer.TYPE;
        JavaType javaType2 = new JavaType("INT", 1, cls, Integer.class, 0);
        f15122j = javaType2;
        JavaType javaType3 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        f15123k = javaType3;
        JavaType javaType4 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f15124l = javaType4;
        JavaType javaType5 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f15125m = javaType5;
        JavaType javaType6 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f15126n = javaType6;
        JavaType javaType7 = new JavaType("STRING", 6, String.class, String.class, "");
        f15127o = javaType7;
        JavaType javaType8 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.f14989g);
        f15128p = javaType8;
        JavaType javaType9 = new JavaType("ENUM", 8, cls, Integer.class, null);
        f15129q = javaType9;
        JavaType javaType10 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        f15130r = javaType10;
        f15131s = new JavaType[]{javaType, javaType2, javaType3, javaType4, javaType5, javaType6, javaType7, javaType8, javaType9, javaType10};
    }

    private JavaType(String str, int i8, Class cls, Class cls2, Object obj) {
        this.f15132f = cls;
        this.f15133g = cls2;
        this.f15134h = obj;
    }

    public static JavaType valueOf(String str) {
        return (JavaType) Enum.valueOf(JavaType.class, str);
    }

    public static JavaType[] values() {
        return (JavaType[]) f15131s.clone();
    }

    public Class<?> a() {
        return this.f15133g;
    }
}
