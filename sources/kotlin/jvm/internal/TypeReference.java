package kotlin.jvm.internal;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* compiled from: TypeReference.kt */
/* loaded from: classes5.dex */
public final class TypeReference implements KType {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f51022e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final KClassifier f51023a;

    /* renamed from: b  reason: collision with root package name */
    private final List<KTypeProjection> f51024b;

    /* renamed from: c  reason: collision with root package name */
    private final KType f51025c;

    /* renamed from: d  reason: collision with root package name */
    private final int f51026d;

    /* compiled from: TypeReference.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TypeReference.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51027a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f51027a = iArr;
        }
    }

    public TypeReference(KClassifier classifier, List<KTypeProjection> arguments, KType kType, int i8) {
        Intrinsics.f(classifier, "classifier");
        Intrinsics.f(arguments, "arguments");
        this.f51023a = classifier;
        this.f51024b = arguments;
        this.f51025c = kType;
        this.f51026d = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(KTypeProjection kTypeProjection) {
        TypeReference typeReference;
        String valueOf;
        if (kTypeProjection.d() == null) {
            return "*";
        }
        KType c8 = kTypeProjection.c();
        if (c8 instanceof TypeReference) {
            typeReference = (TypeReference) c8;
        } else {
            typeReference = null;
        }
        if (typeReference == null || (valueOf = typeReference.g(true)) == null) {
            valueOf = String.valueOf(kTypeProjection.c());
        }
        int i8 = WhenMappings.f51027a[kTypeProjection.d().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return "out " + valueOf;
                }
                throw new NoWhenBranchMatchedException();
            }
            return "in " + valueOf;
        }
        return valueOf;
    }

    private final String g(boolean z7) {
        KClass kClass;
        String name;
        String f02;
        KClassifier c8 = c();
        Class<?> cls = null;
        if (c8 instanceof KClass) {
            kClass = (KClass) c8;
        } else {
            kClass = null;
        }
        if (kClass != null) {
            cls = JvmClassMappingKt.a(kClass);
        }
        if (cls == null) {
            name = c().toString();
        } else if ((this.f51026d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (cls.isArray()) {
            name = h(cls);
        } else if (z7 && cls.isPrimitive()) {
            KClassifier c9 = c();
            Intrinsics.d(c9, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = JvmClassMappingKt.b((KClass) c9).getName();
        } else {
            name = cls.getName();
        }
        String str = "";
        if (d().isEmpty()) {
            f02 = "";
        } else {
            f02 = CollectionsKt___CollectionsKt.f0(d(), ", ", "<", ">", 0, null, new Function1<KTypeProjection, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CharSequence invoke(KTypeProjection it) {
                    String f8;
                    Intrinsics.f(it, "it");
                    f8 = TypeReference.this.f(it);
                    return f8;
                }
            }, 24, null);
        }
        if (a()) {
            str = "?";
        }
        String str2 = name + f02 + str;
        KType kType = this.f51025c;
        if (kType instanceof TypeReference) {
            String g8 = ((TypeReference) kType).g(true);
            if (!Intrinsics.a(g8, str2)) {
                if (Intrinsics.a(g8, str2 + '?')) {
                    return str2 + '!';
                }
                return '(' + str2 + ".." + g8 + ')';
            }
            return str2;
        }
        return str2;
    }

    private final String h(Class<?> cls) {
        if (Intrinsics.a(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (Intrinsics.a(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (Intrinsics.a(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (Intrinsics.a(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (Intrinsics.a(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (Intrinsics.a(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (Intrinsics.a(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        if (Intrinsics.a(cls, double[].class)) {
            return "kotlin.DoubleArray";
        }
        return "kotlin.Array";
    }

    @Override // kotlin.reflect.KType
    public boolean a() {
        if ((this.f51026d & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.KType
    public KClassifier c() {
        return this.f51023a;
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> d() {
        return this.f51024b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (Intrinsics.a(c(), typeReference.c()) && Intrinsics.a(d(), typeReference.d()) && Intrinsics.a(this.f51025c, typeReference.f51025c) && this.f51026d == typeReference.f51026d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((c().hashCode() * 31) + d().hashCode()) * 31) + this.f51026d;
    }

    public String toString() {
        return g(false) + " (Kotlin reflection is not available)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(KClassifier classifier, List<KTypeProjection> arguments, boolean z7) {
        this(classifier, arguments, null, z7 ? 1 : 0);
        Intrinsics.f(classifier, "classifier");
        Intrinsics.f(arguments, "arguments");
    }
}
