package org.koin.dsl;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.KoinDefinition;

/* compiled from: DefinitionBinding.kt */
/* loaded from: classes5.dex */
public final class DefinitionBindingKt {
    public static final <S> KoinDefinition<? extends S> a(KoinDefinition<? extends S> koinDefinition, KClass<S> clazz) {
        List<? extends KClass<?>> o02;
        Intrinsics.f(koinDefinition, "<this>");
        Intrinsics.f(clazz, "clazz");
        BeanDefinition<? extends S> c8 = koinDefinition.a().c();
        o02 = CollectionsKt___CollectionsKt.o0(koinDefinition.a().c().f(), clazz);
        c8.g(o02);
        koinDefinition.b().i(BeanDefinitionKt.a(clazz, koinDefinition.a().c().d(), koinDefinition.a().c().e()), koinDefinition.a());
        return koinDefinition;
    }

    public static final KoinDefinition<?> b(KoinDefinition<?> koinDefinition, KClass<?>[] classes) {
        List<? extends KClass<?>> q02;
        Intrinsics.f(koinDefinition, "<this>");
        Intrinsics.f(classes, "classes");
        BeanDefinition<?> c8 = koinDefinition.a().c();
        q02 = CollectionsKt___CollectionsKt.q0(c8.f(), classes);
        c8.g(q02);
        for (KClass<?> kClass : classes) {
            koinDefinition.b().i(BeanDefinitionKt.a(kClass, koinDefinition.a().c().d(), koinDefinition.a().c().e()), koinDefinition.a());
        }
        return koinDefinition;
    }
}
