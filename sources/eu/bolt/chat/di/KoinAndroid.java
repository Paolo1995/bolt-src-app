package eu.bolt.chat.di;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.engine.okhttp.OkHttp;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: Koin.kt */
/* loaded from: classes5.dex */
public final class KoinAndroid {

    /* renamed from: a  reason: collision with root package name */
    private static final Module f39058a = ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: eu.bolt.chat.di.KoinAndroid$platformModule$1
        public final void b(Module module) {
            List k8;
            Intrinsics.f(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, HttpClientEngine>() { // from class: eu.bolt.chat.di.KoinAndroid$platformModule$1.1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final HttpClientEngine s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return HttpClientEngineFactory.DefaultImpls.a(OkHttp.f46144a, null, 1, null);
                }
            };
            StringQualifier a8 = ScopeRegistry.f52787e.a();
            Kind kind = Kind.Singleton;
            k8 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(a8, Reflection.b(HttpClientEngine.class), null, anonymousClass1, kind, k8));
            module.g(singleInstanceFactory);
            if (module.e()) {
                module.h(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            b(module);
            return Unit.f50853a;
        }
    }, 1, null);

    public static final Module a() {
        return f39058a;
    }
}
