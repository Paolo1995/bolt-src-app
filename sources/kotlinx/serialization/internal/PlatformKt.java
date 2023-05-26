package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Platform.kt */
/* loaded from: classes5.dex */
public final class PlatformKt {
    private static final Object a(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final <T> KSerializer<T> b(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        return d(kClass, new KSerializer[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
        if (r3 == false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> kotlinx.serialization.KSerializer<T> c(java.lang.Class<T> r8, kotlinx.serialization.KSerializer<java.lang.Object>... r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            boolean r0 = r8.isEnum()
            if (r0 == 0) goto L1b
            boolean r0 = j(r8)
            if (r0 == 0) goto L1b
            kotlinx.serialization.KSerializer r8 = e(r8)
            return r8
        L1b:
            boolean r0 = r8.isInterface()
            if (r0 == 0) goto L28
            kotlinx.serialization.KSerializer r0 = g(r8)
            if (r0 == 0) goto L28
            return r0
        L28:
            int r0 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            kotlinx.serialization.KSerializer[] r9 = (kotlinx.serialization.KSerializer[]) r9
            kotlinx.serialization.KSerializer r9 = h(r8, r9)
            if (r9 == 0) goto L36
            return r9
        L36:
            kotlinx.serialization.KSerializer r9 = f(r8)
            if (r9 == 0) goto L3d
            return r9
        L3d:
            r9 = 0
            java.lang.Class[] r0 = r8.getDeclaredClasses()     // Catch: java.lang.NoSuchFieldException -> L7f
            java.lang.String r1 = "declaredClasses"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)     // Catch: java.lang.NoSuchFieldException -> L7f
            int r1 = r0.length     // Catch: java.lang.NoSuchFieldException -> L7f
            r2 = 0
            r4 = r9
            r3 = 0
        L4b:
            if (r2 >= r1) goto L63
            r5 = r0[r2]     // Catch: java.lang.NoSuchFieldException -> L7f
            java.lang.String r6 = r5.getSimpleName()     // Catch: java.lang.NoSuchFieldException -> L7f
            java.lang.String r7 = "$serializer"
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r7)     // Catch: java.lang.NoSuchFieldException -> L7f
            if (r6 == 0) goto L60
            if (r3 == 0) goto L5e
            goto L65
        L5e:
            r3 = 1
            r4 = r5
        L60:
            int r2 = r2 + 1
            goto L4b
        L63:
            if (r3 != 0) goto L66
        L65:
            r4 = r9
        L66:
            java.lang.Class r4 = (java.lang.Class) r4     // Catch: java.lang.NoSuchFieldException -> L7f
            if (r4 == 0) goto L77
            java.lang.String r0 = "INSTANCE"
            java.lang.reflect.Field r0 = r4.getField(r0)     // Catch: java.lang.NoSuchFieldException -> L7f
            if (r0 == 0) goto L77
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.NoSuchFieldException -> L7f
            goto L78
        L77:
            r0 = r9
        L78:
            boolean r1 = r0 instanceof kotlinx.serialization.KSerializer     // Catch: java.lang.NoSuchFieldException -> L7f
            if (r1 == 0) goto L80
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch: java.lang.NoSuchFieldException -> L7f
            goto L81
        L7f:
        L80:
            r0 = r9
        L81:
            if (r0 == 0) goto L84
            return r0
        L84:
            boolean r0 = k(r8)
            if (r0 == 0) goto L93
            kotlinx.serialization.PolymorphicSerializer r9 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r8 = kotlin.jvm.JvmClassMappingKt.c(r8)
            r9.<init>(r8)
        L93:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.c(java.lang.Class, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    public static final <T> KSerializer<T> d(KClass<T> kClass, KSerializer<Object>... args) {
        Intrinsics.f(kClass, "<this>");
        Intrinsics.f(args, "args");
        return c(JvmClassMappingKt.a(kClass), (KSerializer[]) Arrays.copyOf(args, args.length));
    }

    private static final <T> KSerializer<T> e(Class<T> cls) {
        T[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.e(canonicalName, "canonicalName");
        Intrinsics.d(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r5 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
        if (r5 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final <T> kotlinx.serialization.KSerializer<T> f(java.lang.Class<T> r11) {
        /*
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r1 = "declaredFields"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r6 = r3
            r4 = 0
            r5 = 0
        Lf:
            r7 = 1
            if (r4 >= r1) goto L41
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r10)
            if (r9 == 0) goto L36
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r11)
            if (r9 == 0) goto L36
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L36
            r9 = 1
            goto L37
        L36:
            r9 = 0
        L37:
            if (r9 == 0) goto L3e
            if (r5 == 0) goto L3c
            goto L43
        L3c:
            r6 = r8
            r5 = 1
        L3e:
            int r4 = r4 + 1
            goto Lf
        L41:
            if (r5 != 0) goto L44
        L43:
            r6 = r3
        L44:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L49
            return r3
        L49:
            java.lang.Object r0 = r6.get(r3)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r1 = "methods"
            kotlin.jvm.internal.Intrinsics.e(r11, r1)
            int r1 = r11.length
            r6 = r3
            r4 = 0
            r5 = 0
        L5a:
            if (r4 >= r1) goto L94
            r8 = r11[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "serializer"
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r10)
            if (r9 == 0) goto L89
            java.lang.Class[] r9 = r8.getParameterTypes()
            java.lang.String r10 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.e(r9, r10)
            int r9 = r9.length
            if (r9 != 0) goto L78
            r9 = 1
            goto L79
        L78:
            r9 = 0
        L79:
            if (r9 == 0) goto L89
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r10 = kotlinx.serialization.KSerializer.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r10)
            if (r9 == 0) goto L89
            r9 = 1
            goto L8a
        L89:
            r9 = 0
        L8a:
            if (r9 == 0) goto L91
            if (r5 == 0) goto L8f
            goto L96
        L8f:
            r6 = r8
            r5 = 1
        L91:
            int r4 = r4 + 1
            goto L5a
        L94:
            if (r5 != 0) goto L97
        L96:
            r6 = r3
        L97:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L9c
            return r3
        L9c:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Object r11 = r6.invoke(r0, r11)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto La9
            r3 = r11
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
        La9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.f(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    private static final <T> KSerializer<T> g(Class<T> cls) {
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable != null && !Intrinsics.a(Reflection.b(serializable.with()), Reflection.b(PolymorphicSerializer.class))) {
            return null;
        }
        return new PolymorphicSerializer(JvmClassMappingKt.c(cls));
    }

    private static final <T> KSerializer<T> h(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        boolean z7;
        Class[] clsArr;
        Object a8 = a(cls);
        if (a8 == null) {
            return null;
        }
        try {
            if (kSerializerArr.length == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i8 = 0; i8 < length; i8++) {
                    clsArr2[i8] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = a8.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(a8, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (!(invoke instanceof KSerializer)) {
                return null;
            }
            return (KSerializer) invoke;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e8) {
            Throwable cause = e8.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e8.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e8;
        }
    }

    public static final boolean i(Object obj, KClass<?> kclass) {
        Intrinsics.f(obj, "<this>");
        Intrinsics.f(kclass, "kclass");
        return JvmClassMappingKt.b(kclass).isInstance(obj);
    }

    private static final <T> boolean j(Class<T> cls) {
        if (cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null) {
            return true;
        }
        return false;
    }

    private static final <T> boolean k(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable != null && Intrinsics.a(Reflection.b(serializable.with()), Reflection.b(PolymorphicSerializer.class))) {
            return true;
        }
        return false;
    }

    public static final boolean l(KClass<Object> rootClass) {
        Intrinsics.f(rootClass, "rootClass");
        return JvmClassMappingKt.a(rootClass).isArray();
    }

    public static final Void m(KClass<?> kClass) {
        Intrinsics.f(kClass, "<this>");
        Platform_commonKt.d(kClass);
        throw new KotlinNothingValueException();
    }

    public static final <T, E extends T> E[] n(ArrayList<E> arrayList, KClass<T> eClass) {
        Intrinsics.f(arrayList, "<this>");
        Intrinsics.f(eClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.a(eClass), arrayList.size());
        Intrinsics.d(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) newInstance);
        Intrinsics.e(eArr, "toArray(java.lang.reflec….java, size) as Array<E>)");
        return eArr;
    }
}
