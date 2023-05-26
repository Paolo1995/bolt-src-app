package eu.bolt.chat.di;

import co.touchlab.kermit.Logger;
import com.russhwolf.settings.NoArgKt;
import com.russhwolf.settings.Settings;
import eu.bolt.chat.storage.ActiveChatIdStorage;
import eu.bolt.chat.storage.ActiveChatIdStorageKt;
import eu.bolt.chat.storage.ChatStorage;
import eu.bolt.chat.storage.DefaultPendingRawMessageStorage;
import eu.bolt.chat.storage.InMemoryChatStorage;
import eu.bolt.chat.storage.PendingRawMessageStorage;
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

/* compiled from: StorageModule.kt */
/* loaded from: classes5.dex */
public final class StorageModuleKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Module f39085a = ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: eu.bolt.chat.di.StorageModuleKt$storageModule$1
        public final void b(Module module) {
            List k8;
            List k9;
            List k10;
            List k11;
            Intrinsics.f(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, ChatStorage>() { // from class: eu.bolt.chat.di.StorageModuleKt$storageModule$1.1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ChatStorage s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return new InMemoryChatStorage((Logger) single.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ChatStorage"})));
                }
            };
            ScopeRegistry.Companion companion = ScopeRegistry.f52787e;
            StringQualifier a8 = companion.a();
            Kind kind = Kind.Singleton;
            k8 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(a8, Reflection.b(ChatStorage.class), null, anonymousClass1, kind, k8));
            module.g(singleInstanceFactory);
            if (module.e()) {
                module.h(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, ActiveChatIdStorage>() { // from class: eu.bolt.chat.di.StorageModuleKt$storageModule$1.2
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ActiveChatIdStorage s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return ActiveChatIdStorageKt.a((Settings) single.f(Reflection.b(Settings.class), null, null), (Logger) single.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ActiveChatIdStorage"})));
                }
            };
            StringQualifier a9 = companion.a();
            k9 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory2 = new SingleInstanceFactory<>(new BeanDefinition(a9, Reflection.b(ActiveChatIdStorage.class), null, anonymousClass2, kind, k9));
            module.g(singleInstanceFactory2);
            if (module.e()) {
                module.h(singleInstanceFactory2);
            }
            new KoinDefinition(module, singleInstanceFactory2);
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, PendingRawMessageStorage>() { // from class: eu.bolt.chat.di.StorageModuleKt$storageModule$1.3
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final PendingRawMessageStorage s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return new DefaultPendingRawMessageStorage((Settings) single.f(Reflection.b(Settings.class), null, null), (Logger) single.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"PendingRawMessageStorage"})));
                }
            };
            StringQualifier a10 = companion.a();
            k10 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(a10, Reflection.b(PendingRawMessageStorage.class), null, anonymousClass3, kind, k10));
            module.g(singleInstanceFactory3);
            if (module.e()) {
                module.h(singleInstanceFactory3);
            }
            new KoinDefinition(module, singleInstanceFactory3);
            AnonymousClass4 anonymousClass4 = new Function2<Scope, ParametersHolder, Settings>() { // from class: eu.bolt.chat.di.StorageModuleKt$storageModule$1.4
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final Settings s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return NoArgKt.a();
                }
            };
            StringQualifier a11 = companion.a();
            k11 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory4 = new SingleInstanceFactory<>(new BeanDefinition(a11, Reflection.b(Settings.class), null, anonymousClass4, kind, k11));
            module.g(singleInstanceFactory4);
            if (module.e()) {
                module.h(singleInstanceFactory4);
            }
            new KoinDefinition(module, singleInstanceFactory4);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            b(module);
            return Unit.f50853a;
        }
    }, 1, null);

    public static final Module a() {
        return f39085a;
    }
}
