package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.HttpUrl;

/* compiled from: TypesJVM.kt */
/* loaded from: classes5.dex */
public final class TypesJVMKt {

    /* compiled from: TypesJVM.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51086a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f51086a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type c(KType kType, boolean z7) {
        Class a8;
        Object u02;
        int i8;
        KClassifier c8 = kType.c();
        if (c8 instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) c8);
        }
        if (c8 instanceof KClass) {
            KClass kClass = (KClass) c8;
            if (z7) {
                a8 = JvmClassMappingKt.b(kClass);
            } else {
                a8 = JvmClassMappingKt.a(kClass);
            }
            List<KTypeProjection> d8 = kType.d();
            if (d8.isEmpty()) {
                return a8;
            }
            if (a8.isArray()) {
                if (a8.getComponentType().isPrimitive()) {
                    return a8;
                }
                u02 = CollectionsKt___CollectionsKt.u0(d8);
                KTypeProjection kTypeProjection = (KTypeProjection) u02;
                if (kTypeProjection != null) {
                    KVariance a9 = kTypeProjection.a();
                    KType b8 = kTypeProjection.b();
                    if (a9 == null) {
                        i8 = -1;
                    } else {
                        i8 = WhenMappings.f51086a[a9.ordinal()];
                    }
                    if (i8 != -1 && i8 != 1) {
                        if (i8 != 2 && i8 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Intrinsics.c(b8);
                        Type d9 = d(b8, false, 1, null);
                        if (!(d9 instanceof Class)) {
                            return new GenericArrayTypeImpl(d9);
                        }
                        return a8;
                    }
                    return a8;
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
            }
            return e(a8, d8);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    static /* synthetic */ Type d(KType kType, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return c(kType, z7);
    }

    private static final Type e(Class<?> cls, List<KTypeProjection> list) {
        int v7;
        int v8;
        int v9;
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            v9 = CollectionsKt__IterablesKt.v(list, 10);
            ArrayList arrayList = new ArrayList(v9);
            for (KTypeProjection kTypeProjection : list) {
                arrayList.add(g(kTypeProjection));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            v8 = CollectionsKt__IterablesKt.v(list, 10);
            ArrayList arrayList2 = new ArrayList(v8);
            for (KTypeProjection kTypeProjection2 : list) {
                arrayList2.add(g(kTypeProjection2));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type e8 = e(declaringClass, list.subList(length, list.size()));
            List<KTypeProjection> subList = list.subList(0, length);
            v7 = CollectionsKt__IterablesKt.v(subList, 10);
            ArrayList arrayList3 = new ArrayList(v7);
            for (KTypeProjection kTypeProjection3 : subList) {
                arrayList3.add(g(kTypeProjection3));
            }
            return new ParameterizedTypeImpl(cls, e8, arrayList3);
        }
    }

    public static final Type f(KType kType) {
        Type b8;
        Intrinsics.f(kType, "<this>");
        if ((kType instanceof KTypeBase) && (b8 = ((KTypeBase) kType).b()) != null) {
            return b8;
        }
        return d(kType, false, 1, null);
    }

    private static final Type g(KTypeProjection kTypeProjection) {
        KVariance d8 = kTypeProjection.d();
        if (d8 == null) {
            return WildcardTypeImpl.f51088h.a();
        }
        KType c8 = kTypeProjection.c();
        Intrinsics.c(c8);
        int i8 = WhenMappings.f51086a[d8.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return new WildcardTypeImpl(c(c8, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return c(c8, true);
        }
        return new WildcardTypeImpl(null, c(c8, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Type type) {
        String name;
        Sequence h8;
        Object u7;
        int l8;
        String B;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                h8 = SequencesKt__SequencesKt.h(type, TypesJVMKt$typeToString$unwrap$1.f51087o);
                StringBuilder sb = new StringBuilder();
                u7 = SequencesKt___SequencesKt.u(h8);
                sb.append(((Class) u7).getName());
                l8 = SequencesKt___SequencesKt.l(h8);
                B = StringsKt__StringsJVMKt.B(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, l8);
                sb.append(B);
                name = sb.toString();
            } else {
                name = cls.getName();
            }
            Intrinsics.e(name, "{\n        if (type.isArr…   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }
}
