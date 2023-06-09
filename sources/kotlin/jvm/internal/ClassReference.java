package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ClassReference.kt */
/* loaded from: classes5.dex */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f50996b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends Function<?>>, Integer> f50997c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f50998d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f50999e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f51000f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, String> f51001g;

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f51002a;

    /* compiled from: ClassReference.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Class<?> jClass) {
            String str;
            Intrinsics.f(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) ClassReference.f51000f.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) ClassReference.f51000f.get(jClass.getName());
            if (str3 == null) {
                return jClass.getCanonicalName();
            }
            return str3;
        }

        public final String b(Class<?> jClass) {
            String str;
            Method enclosingMethod;
            Constructor<?> enclosingConstructor;
            String M0;
            String N0;
            String N02;
            Intrinsics.f(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    if (jClass.getEnclosingMethod() != null) {
                        Intrinsics.e(name, "name");
                        N02 = StringsKt__StringsKt.N0(name, enclosingMethod.getName() + '$', null, 2, null);
                        if (N02 != null) {
                            return N02;
                        }
                    }
                    if (jClass.getEnclosingConstructor() != null) {
                        Intrinsics.e(name, "name");
                        N0 = StringsKt__StringsKt.N0(name, enclosingConstructor.getName() + '$', null, 2, null);
                        return N0;
                    }
                    Intrinsics.e(name, "name");
                    M0 = StringsKt__StringsKt.M0(name, '$', null, 2, null);
                    return M0;
                } else if (jClass.isArray()) {
                    Class<?> componentType = jClass.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) ClassReference.f51001g.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                } else {
                    String str3 = (String) ClassReference.f51001g.get(jClass.getName());
                    if (str3 == null) {
                        return jClass.getSimpleName();
                    }
                    return str3;
                }
            }
            return str2;
        }

        public final boolean c(Object obj, Class<?> jClass) {
            Intrinsics.f(jClass, "jClass");
            Map map = ClassReference.f50997c;
            Intrinsics.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return TypeIntrinsics.k(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = JvmClassMappingKt.b(JvmClassMappingKt.c(jClass));
            }
            return jClass.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List n8;
        int v7;
        Map<Class<? extends Function<?>>, Integer> q8;
        int b8;
        String Q0;
        String Q02;
        int i8 = 0;
        n8 = CollectionsKt__CollectionsKt.n(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        v7 = CollectionsKt__IterablesKt.v(n8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Object obj : n8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            arrayList.add(TuplesKt.a((Class) obj, Integer.valueOf(i8)));
            i8 = i9;
        }
        q8 = MapsKt__MapsKt.q(arrayList);
        f50997c = q8;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f50998d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f50999e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        Intrinsics.e(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.e(kotlinName, "kotlinName");
            Q02 = StringsKt__StringsKt.Q0(kotlinName, '.', null, 2, null);
            sb.append(Q02);
            sb.append("CompanionObject");
            Pair a8 = TuplesKt.a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(a8.d(), a8.e());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : f50997c.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        f51000f = hashMap3;
        b8 = MapsKt__MapsJVMKt.b(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(b8);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            Q0 = StringsKt__StringsKt.Q0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, Q0);
        }
        f51001g = linkedHashMap;
    }

    public ClassReference(Class<?> jClass) {
        Intrinsics.f(jClass, "jClass");
        this.f51002a = jClass;
    }

    @Override // kotlin.reflect.KClass
    public boolean a(Object obj) {
        return f50996b.c(obj, b());
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> b() {
        return this.f51002a;
    }

    @Override // kotlin.reflect.KClass
    public String c() {
        return f50996b.a(b());
    }

    @Override // kotlin.reflect.KClass
    public String d() {
        return f50996b.b(b());
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ClassReference) && Intrinsics.a(JvmClassMappingKt.b(this), JvmClassMappingKt.b((KClass) obj))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return JvmClassMappingKt.b(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
