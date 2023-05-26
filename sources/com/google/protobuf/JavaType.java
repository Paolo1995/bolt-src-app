package com.google.protobuf;

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
public final class JavaType {

    /* renamed from: i  reason: collision with root package name */
    public static final JavaType f17468i;

    /* renamed from: j  reason: collision with root package name */
    public static final JavaType f17469j;

    /* renamed from: k  reason: collision with root package name */
    public static final JavaType f17470k;

    /* renamed from: l  reason: collision with root package name */
    public static final JavaType f17471l;

    /* renamed from: m  reason: collision with root package name */
    public static final JavaType f17472m;

    /* renamed from: n  reason: collision with root package name */
    public static final JavaType f17473n;

    /* renamed from: o  reason: collision with root package name */
    public static final JavaType f17474o;

    /* renamed from: p  reason: collision with root package name */
    public static final JavaType f17475p;

    /* renamed from: q  reason: collision with root package name */
    public static final JavaType f17476q;

    /* renamed from: r  reason: collision with root package name */
    public static final JavaType f17477r;

    /* renamed from: s  reason: collision with root package name */
    private static final /* synthetic */ JavaType[] f17478s;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f17479f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f17480g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f17481h;

    static {
        JavaType javaType = new JavaType("VOID", 0, Void.class, Void.class, null);
        f17468i = javaType;
        Class cls = Integer.TYPE;
        JavaType javaType2 = new JavaType("INT", 1, cls, Integer.class, 0);
        f17469j = javaType2;
        JavaType javaType3 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        f17470k = javaType3;
        JavaType javaType4 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f17471l = javaType4;
        JavaType javaType5 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f17472m = javaType5;
        JavaType javaType6 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f17473n = javaType6;
        JavaType javaType7 = new JavaType("STRING", 6, String.class, String.class, "");
        f17474o = javaType7;
        JavaType javaType8 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.f17177g);
        f17475p = javaType8;
        JavaType javaType9 = new JavaType("ENUM", 8, cls, Integer.class, null);
        f17476q = javaType9;
        JavaType javaType10 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        f17477r = javaType10;
        f17478s = new JavaType[]{javaType, javaType2, javaType3, javaType4, javaType5, javaType6, javaType7, javaType8, javaType9, javaType10};
    }

    private JavaType(String str, int i8, Class cls, Class cls2, Object obj) {
        this.f17479f = cls;
        this.f17480g = cls2;
        this.f17481h = obj;
    }

    public static JavaType valueOf(String str) {
        return (JavaType) java.lang.Enum.valueOf(JavaType.class, str);
    }

    public static JavaType[] values() {
        return (JavaType[]) f17478s.clone();
    }

    public Class<?> a() {
        return this.f17480g;
    }
}
