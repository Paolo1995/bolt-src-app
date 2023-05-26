package eu.bolt.chat.di;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: DispatcherModule.kt */
/* loaded from: classes5.dex */
public final class DispatcherModuleKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Module f39033a = ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: eu.bolt.chat.di.DispatcherModuleKt$dispatcherModule$1
        public final void b(Module module) {
            List k8;
            List k9;
            List k10;
            List k11;
            Intrinsics.f(module, "$this$module");
            Qualifier c8 = QualifierKt.c(DispatcherType.MAIN);
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, CoroutineDispatcher>() { // from class: eu.bolt.chat.di.DispatcherModuleKt$dispatcherModule$1.1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final CoroutineDispatcher s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return Dispatchers.c();
                }
            };
            ScopeRegistry.Companion companion = ScopeRegistry.f52787e;
            StringQualifier a8 = companion.a();
            Kind kind = Kind.Singleton;
            k8 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(a8, Reflection.b(CoroutineDispatcher.class), c8, anonymousClass1, kind, k8));
            module.g(singleInstanceFactory);
            if (module.e()) {
                module.h(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory);
            Qualifier c9 = QualifierKt.c(DispatcherType.DEFAULT);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, CoroutineDispatcher>() { // from class: eu.bolt.chat.di.DispatcherModuleKt$dispatcherModule$1.2
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final CoroutineDispatcher s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return Dispatchers.a();
                }
            };
            StringQualifier a9 = companion.a();
            k9 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory2 = new SingleInstanceFactory<>(new BeanDefinition(a9, Reflection.b(CoroutineDispatcher.class), c9, anonymousClass2, kind, k9));
            module.g(singleInstanceFactory2);
            if (module.e()) {
                module.h(singleInstanceFactory2);
            }
            new KoinDefinition(module, singleInstanceFactory2);
            Qualifier c10 = QualifierKt.c(DispatcherType.MQTT);
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, CoroutineDispatcher>() { // from class: eu.bolt.chat.di.DispatcherModuleKt$dispatcherModule$1.3
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final CoroutineDispatcher s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return ThreadPoolDispatcherKt.d("MqttWorker");
                }
            };
            StringQualifier a10 = companion.a();
            k10 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(a10, Reflection.b(CoroutineDispatcher.class), c10, anonymousClass3, kind, k10));
            module.g(singleInstanceFactory3);
            if (module.e()) {
                module.h(singleInstanceFactory3);
            }
            new KoinDefinition(module, singleInstanceFactory3);
            final AtomicInt c11 = AtomicFU.c(0);
            Qualifier c12 = QualifierKt.c(DispatcherType.SINGLE);
            Function2<Scope, ParametersHolder, CoroutineDispatcher> function2 = new Function2<Scope, ParametersHolder, CoroutineDispatcher>() { // from class: eu.bolt.chat.di.DispatcherModuleKt$dispatcherModule$1.4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final CoroutineDispatcher s(Scope factory, ParametersHolder it) {
                    Intrinsics.f(factory, "$this$factory");
                    Intrinsics.f(it, "it");
                    return ThreadPoolDispatcherKt.d("SingleWorker-" + AtomicInt.this.b());
                }
            };
            StringQualifier a11 = companion.a();
            Kind kind2 = Kind.Factory;
            k11 = CollectionsKt__CollectionsKt.k();
            InstanceFactory<?> factoryInstanceFactory = new FactoryInstanceFactory<>(new BeanDefinition(a11, Reflection.b(CoroutineDispatcher.class), c12, function2, kind2, k11));
            module.g(factoryInstanceFactory);
            new KoinDefinition(module, factoryInstanceFactory);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            b(module);
            return Unit.f50853a;
        }
    }, 1, null);

    public static final Module a() {
        return f39033a;
    }
}
