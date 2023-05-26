package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* loaded from: classes5.dex */
public class Reflection {

    /* renamed from: a  reason: collision with root package name */
    private static final ReflectionFactory f51017a;

    /* renamed from: b  reason: collision with root package name */
    private static final KClass[] f51018b;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f51017a = reflectionFactory;
        f51018b = new KClass[0];
    }

    public static KFunction a(FunctionReference functionReference) {
        return f51017a.a(functionReference);
    }

    public static KClass b(Class cls) {
        return f51017a.b(cls);
    }

    public static KDeclarationContainer c(Class cls) {
        return f51017a.c(cls, "");
    }

    public static KMutableProperty1 d(MutablePropertyReference1 mutablePropertyReference1) {
        return f51017a.d(mutablePropertyReference1);
    }

    public static KProperty0 e(PropertyReference0 propertyReference0) {
        return f51017a.e(propertyReference0);
    }

    public static KProperty1 f(PropertyReference1 propertyReference1) {
        return f51017a.f(propertyReference1);
    }

    public static String g(FunctionBase functionBase) {
        return f51017a.g(functionBase);
    }

    public static String h(Lambda lambda) {
        return f51017a.h(lambda);
    }

    public static KType i(Class cls) {
        return f51017a.i(b(cls), Collections.emptyList(), false);
    }

    public static KType j(Class cls, KTypeProjection kTypeProjection) {
        return f51017a.i(b(cls), Collections.singletonList(kTypeProjection), false);
    }

    public static KType k(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f51017a.i(b(cls), Arrays.asList(kTypeProjection, kTypeProjection2), false);
    }
}
