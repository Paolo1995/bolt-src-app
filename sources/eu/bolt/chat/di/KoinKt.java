package eu.bolt.chat.di;

import co.touchlab.kermit.Logger;
import eu.bolt.chat.client.ChatClientDisposerKt;
import eu.bolt.chat.client.ChatClientManager;
import eu.bolt.chat.client.ChatManagerFactory;
import eu.bolt.chat.client.ChatManagerImpl;
import eu.bolt.chat.client.ChatNotificationManager;
import eu.bolt.chat.client.ChatNotificationManagerKt;
import eu.bolt.chat.client.ChatPushParser;
import eu.bolt.chat.client.ChatPushParserKt;
import eu.bolt.chat.client.ChatSubscriber;
import eu.bolt.chat.client.DefaultChatClient;
import eu.bolt.chat.client.DefaultChatClientManager;
import eu.bolt.chat.client.DefaultChatManagerFactory;
import eu.bolt.chat.client.DefaultChatSubscriber;
import eu.bolt.chat.client.DefaultMessagePublisher;
import eu.bolt.chat.client.DefaultMessageRouter;
import eu.bolt.chat.client.InternalChatClient;
import eu.bolt.chat.client.InternalChatClientManager;
import eu.bolt.chat.client.InternalChatManager;
import eu.bolt.chat.client.InternalNotificationManager;
import eu.bolt.chat.client.MessagePublisher;
import eu.bolt.chat.client.MessageRouter;
import eu.bolt.chat.data.connection.ChatConnectionSettings;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import eu.bolt.chat.data.util.MessageDirectionDetectorKt;
import eu.bolt.chat.logger.KoinLogger;
import eu.bolt.chat.network.data.ChatConfig;
import eu.bolt.chat.network.data.ClientContext;
import eu.bolt.chat.network.data.parser.MqttMessageParser;
import eu.bolt.chat.network.data.parser.MqttMessageParserKt;
import eu.bolt.chat.network.data.serializer.DefaultMqttChatMessageEncoder;
import eu.bolt.chat.network.data.serializer.MqttChatMessageEncoder;
import eu.bolt.chat.network.engine.BoltMqttSettings;
import eu.bolt.chat.network.engine.InternalPlatformMqttClientDelegate;
import eu.bolt.chat.network.engine.MqttClient;
import eu.bolt.chat.network.engine.MqttClientImpl;
import eu.bolt.chat.network.engine.MqttSettings;
import eu.bolt.chat.network.engine.PlatformMqttClient;
import eu.bolt.chat.network.engine.PlatformMqttClientDelegate;
import eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl;
import eu.bolt.chat.network.engine.PlatformMqttClientFactory;
import eu.bolt.chat.storage.ActiveChatIdStorage;
import eu.bolt.chat.storage.ChatStorage;
import eu.bolt.chat.storage.PendingRawMessageStorage;
import eu.bolt.chat.util.AppStateObserver;
import eu.bolt.chat.util.CoroutineRunner;
import eu.bolt.chat.util.CoroutineRunnerKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.KoinApplication;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.DefinitionBindingKt;
import org.koin.dsl.KoinApplicationKt;
import org.koin.dsl.ModuleDSLKt;
import org.koin.dsl.ScopeDSL;

/* compiled from: Koin.kt */
/* loaded from: classes5.dex */
public final class KoinKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Module f39061a = ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1
        public final void b(Module module) {
            List k8;
            List k9;
            List k10;
            List k11;
            List k12;
            List k13;
            List k14;
            List k15;
            List k16;
            List k17;
            List k18;
            List k19;
            List k20;
            List k21;
            List k22;
            List k23;
            List k24;
            List k25;
            List k26;
            List k27;
            Intrinsics.f(module, "$this$module");
            module.f(HttpModuleKt.b(), DispatcherModuleKt.a(), StorageModuleKt.a());
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, InternalNotificationManager>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final InternalNotificationManager s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return ChatNotificationManagerKt.a();
                }
            };
            ScopeRegistry.Companion companion = ScopeRegistry.f52787e;
            StringQualifier a8 = companion.a();
            Kind kind = Kind.Singleton;
            k8 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(a8, Reflection.b(InternalNotificationManager.class), null, anonymousClass1, kind, k8));
            module.g(singleInstanceFactory);
            if (module.e()) {
                module.h(singleInstanceFactory);
            }
            DefinitionBindingKt.a(new KoinDefinition(module, singleInstanceFactory), Reflection.b(ChatNotificationManager.class));
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, InternalChatClientManager>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.2
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final InternalChatClientManager s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return new DefaultChatClientManager(ChatClientDisposerKt.a((PendingRawMessageStorage) single.f(Reflection.b(PendingRawMessageStorage.class), null, null), (ActiveChatIdStorage) single.f(Reflection.b(ActiveChatIdStorage.class), null, null), SupervisorKt.b(null, 1, null).s0((CoroutineDispatcher) single.f(Reflection.b(CoroutineDispatcher.class), QualifierKt.c(DispatcherType.DEFAULT), null))), (Logger) single.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ChatClientManager"})));
                }
            };
            StringQualifier a9 = companion.a();
            k9 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory2 = new SingleInstanceFactory<>(new BeanDefinition(a9, Reflection.b(InternalChatClientManager.class), null, anonymousClass2, kind, k9));
            module.g(singleInstanceFactory2);
            if (module.e()) {
                module.h(singleInstanceFactory2);
            }
            DefinitionBindingKt.a(new KoinDefinition(module, singleInstanceFactory2), Reflection.b(ChatClientManager.class));
            AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, InternalChatClient>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.3
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final InternalChatClient s(Scope factory, ParametersHolder it) {
                    Intrinsics.f(factory, "$this$factory");
                    Intrinsics.f(it, "it");
                    DefaultChatClient defaultChatClient = new DefaultChatClient((Logger) factory.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ChatClient"})));
                    defaultChatClient.b0();
                    return defaultChatClient;
                }
            };
            StringQualifier a10 = companion.a();
            Kind kind2 = Kind.Factory;
            k10 = CollectionsKt__CollectionsKt.k();
            InstanceFactory<?> factoryInstanceFactory = new FactoryInstanceFactory<>(new BeanDefinition(a10, Reflection.b(InternalChatClient.class), null, anonymousClass3, kind2, k10));
            module.g(factoryInstanceFactory);
            new KoinDefinition(module, factoryInstanceFactory);
            Qualifier typeQualifier = new TypeQualifier(Reflection.b(DefaultChatClient.class));
            ScopeDSL scopeDSL = new ScopeDSL(typeQualifier, module);
            KoinKt$coreModule$1$4$1 koinKt$coreModule$1$4$1 = new Function2<Scope, ParametersHolder, CoroutineScope>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final CoroutineScope s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    Qualifier c8 = QualifierKt.c(DispatcherType.MQTT);
                    return CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).s0((CoroutineDispatcher) scoped.f(Reflection.b(CoroutineDispatcher.class), c8, null)));
                }
            };
            Qualifier b8 = scopeDSL.b();
            Kind kind3 = Kind.Scoped;
            k11 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(b8, Reflection.b(CoroutineScope.class), null, koinKt$coreModule$1$4$1, kind3, k11));
            scopeDSL.a().g(scopedInstanceFactory);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory);
            KoinKt$coreModule$1$4$2 koinKt$coreModule$1$4$2 = new Function2<Scope, ParametersHolder, CoroutineRunner>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$2
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final CoroutineRunner s(Scope factory, ParametersHolder it) {
                    Intrinsics.f(factory, "$this$factory");
                    Intrinsics.f(it, "it");
                    return CoroutineRunnerKt.a((CoroutineScope) factory.f(Reflection.b(CoroutineScope.class), null, null));
                }
            };
            Module a11 = scopeDSL.a();
            Qualifier b9 = scopeDSL.b();
            k12 = CollectionsKt__CollectionsKt.k();
            FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(b9, Reflection.b(CoroutineRunner.class), null, koinKt$coreModule$1$4$2, kind2, k12));
            a11.g(factoryInstanceFactory2);
            new KoinDefinition(a11, factoryInstanceFactory2);
            KoinKt$coreModule$1$4$3 koinKt$coreModule$1$4$3 = new Function2<Scope, ParametersHolder, InternalPlatformMqttClientDelegate>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$3
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final InternalPlatformMqttClientDelegate s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    return new PlatformMqttClientDelegateImpl((CoroutineRunner) scoped.f(Reflection.b(CoroutineRunner.class), null, null), (Logger) scoped.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"MqttClient"})));
                }
            };
            Qualifier b10 = scopeDSL.b();
            k13 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory2 = new ScopedInstanceFactory(new BeanDefinition(b10, Reflection.b(InternalPlatformMqttClientDelegate.class), null, koinKt$coreModule$1$4$3, kind3, k13));
            scopeDSL.a().g(scopedInstanceFactory2);
            DefinitionBindingKt.a(new KoinDefinition(scopeDSL.a(), scopedInstanceFactory2), Reflection.b(PlatformMqttClientDelegate.class));
            KoinKt$coreModule$1$4$4 koinKt$coreModule$1$4$4 = new Function2<Scope, ParametersHolder, PlatformMqttClient>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$4
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final PlatformMqttClient s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    MqttSettings mqttSettings = (MqttSettings) scoped.f(Reflection.b(MqttSettings.class), null, null);
                    return ((PlatformMqttClientFactory) scoped.f(Reflection.b(PlatformMqttClientFactory.class), null, null)).a(mqttSettings.c(), mqttSettings.b(), (PlatformMqttClientDelegate) scoped.f(Reflection.b(PlatformMqttClientDelegate.class), null, null));
                }
            };
            Qualifier b11 = scopeDSL.b();
            k14 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory3 = new ScopedInstanceFactory(new BeanDefinition(b11, Reflection.b(PlatformMqttClient.class), null, koinKt$coreModule$1$4$4, kind3, k14));
            scopeDSL.a().g(scopedInstanceFactory3);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory3);
            KoinKt$coreModule$1$4$5 koinKt$coreModule$1$4$5 = new Function2<Scope, ParametersHolder, MqttClient>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$5
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final MqttClient s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    return new MqttClientImpl((CoroutineRunner) scoped.f(Reflection.b(CoroutineRunner.class), null, null), (PlatformMqttClient) scoped.f(Reflection.b(PlatformMqttClient.class), null, null), (InternalPlatformMqttClientDelegate) scoped.f(Reflection.b(InternalPlatformMqttClientDelegate.class), null, null), (AppStateObserver) scoped.f(Reflection.b(AppStateObserver.class), null, null), (Logger) scoped.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"MqttClient"})));
                }
            };
            Qualifier b12 = scopeDSL.b();
            k15 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory4 = new ScopedInstanceFactory(new BeanDefinition(b12, Reflection.b(MqttClient.class), null, koinKt$coreModule$1$4$5, kind3, k15));
            scopeDSL.a().g(scopedInstanceFactory4);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory4);
            KoinKt$coreModule$1$4$6 koinKt$coreModule$1$4$6 = new Function2<Scope, ParametersHolder, ChatSubscriber>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$6
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ChatSubscriber s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    return new DefaultChatSubscriber((CoroutineRunner) scoped.f(Reflection.b(CoroutineRunner.class), null, null), (MqttClient) scoped.f(Reflection.b(MqttClient.class), null, null), (Logger) scoped.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ChatSubscriber"})));
                }
            };
            Qualifier b13 = scopeDSL.b();
            k16 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory5 = new ScopedInstanceFactory(new BeanDefinition(b13, Reflection.b(ChatSubscriber.class), null, koinKt$coreModule$1$4$6, kind3, k16));
            scopeDSL.a().g(scopedInstanceFactory5);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory5);
            KoinKt$coreModule$1$4$7 koinKt$coreModule$1$4$7 = new Function2<Scope, ParametersHolder, MessageRouter>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$7
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final MessageRouter s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    return new DefaultMessageRouter((MqttMessageParser) scoped.f(Reflection.b(MqttMessageParser.class), null, null), (Logger) scoped.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"MessageRouter"})));
                }
            };
            Qualifier b14 = scopeDSL.b();
            k17 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory6 = new ScopedInstanceFactory(new BeanDefinition(b14, Reflection.b(MessageRouter.class), null, koinKt$coreModule$1$4$7, kind3, k17));
            scopeDSL.a().g(scopedInstanceFactory6);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory6);
            KoinKt$coreModule$1$4$8 koinKt$coreModule$1$4$8 = new Function2<Scope, ParametersHolder, MessagePublisher>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$8
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final MessagePublisher s(Scope factory, ParametersHolder it) {
                    Intrinsics.f(factory, "$this$factory");
                    Intrinsics.f(it, "it");
                    return new DefaultMessagePublisher((Logger) factory.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"MessagePublisher"})), (ChatConfig) factory.f(Reflection.b(ChatConfig.class), null, null), (MqttClient) factory.f(Reflection.b(MqttClient.class), null, null), (MqttChatMessageEncoder) factory.f(Reflection.b(MqttChatMessageEncoder.class), null, null), (PendingRawMessageStorage) factory.f(Reflection.b(PendingRawMessageStorage.class), null, null));
                }
            };
            Module a12 = scopeDSL.a();
            Qualifier b15 = scopeDSL.b();
            k18 = CollectionsKt__CollectionsKt.k();
            FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(b15, Reflection.b(MessagePublisher.class), null, koinKt$coreModule$1$4$8, kind2, k18));
            a12.g(factoryInstanceFactory3);
            new KoinDefinition(a12, factoryInstanceFactory3);
            KoinKt$coreModule$1$4$9 koinKt$coreModule$1$4$9 = new Function2<Scope, ParametersHolder, MqttMessageParser>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$9
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final MqttMessageParser s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    return MqttMessageParserKt.a((MessageDirectionDetector) scoped.f(Reflection.b(MessageDirectionDetector.class), null, null), (Logger) scoped.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"MessageParser"})));
                }
            };
            Qualifier b16 = scopeDSL.b();
            k19 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory7 = new ScopedInstanceFactory(new BeanDefinition(b16, Reflection.b(MqttMessageParser.class), null, koinKt$coreModule$1$4$9, kind3, k19));
            scopeDSL.a().g(scopedInstanceFactory7);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory7);
            KoinKt$coreModule$1$4$10 koinKt$coreModule$1$4$10 = new Function2<Scope, ParametersHolder, MqttChatMessageEncoder>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$10
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final MqttChatMessageEncoder s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    ChatConnectionSettings chatConnectionSettings = (ChatConnectionSettings) scoped.f(Reflection.b(ChatConnectionSettings.class), null, null);
                    return new DefaultMqttChatMessageEncoder(new ClientContext(chatConnectionSettings.j(), chatConnectionSettings.l()));
                }
            };
            Qualifier b17 = scopeDSL.b();
            k20 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory8 = new ScopedInstanceFactory(new BeanDefinition(b17, Reflection.b(MqttChatMessageEncoder.class), null, koinKt$coreModule$1$4$10, kind3, k20));
            scopeDSL.a().g(scopedInstanceFactory8);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory8);
            KoinKt$coreModule$1$4$11 koinKt$coreModule$1$4$11 = new Function2<Scope, ParametersHolder, ChatManagerFactory>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$11
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ChatManagerFactory s(Scope scoped, ParametersHolder it) {
                    Intrinsics.f(scoped, "$this$scoped");
                    Intrinsics.f(it, "it");
                    return new DefaultChatManagerFactory((CoroutineDispatcher) scoped.f(Reflection.b(CoroutineDispatcher.class), QualifierKt.c(DispatcherType.MQTT), null), scoped, (Logger) scoped.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ChatManagerFactory"})));
                }
            };
            Qualifier b18 = scopeDSL.b();
            k21 = CollectionsKt__CollectionsKt.k();
            ScopedInstanceFactory scopedInstanceFactory9 = new ScopedInstanceFactory(new BeanDefinition(b18, Reflection.b(ChatManagerFactory.class), null, koinKt$coreModule$1$4$11, kind3, k21));
            scopeDSL.a().g(scopedInstanceFactory9);
            new KoinDefinition(scopeDSL.a(), scopedInstanceFactory9);
            KoinKt$coreModule$1$4$12 koinKt$coreModule$1$4$12 = new Function2<Scope, ParametersHolder, InternalChatManager>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1$4$12
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final InternalChatManager s(Scope factory, ParametersHolder parametersHolder) {
                    Intrinsics.f(factory, "$this$factory");
                    Intrinsics.f(parametersHolder, "<name for destructuring parameter 0>");
                    return new ChatManagerImpl((String) parametersHolder.a(0, Reflection.b(String.class)), (ChatConfig) factory.f(Reflection.b(ChatConfig.class), null, null), (CoroutineRunner) parametersHolder.a(1, Reflection.b(CoroutineRunner.class)), (ChatStorage) factory.f(Reflection.b(ChatStorage.class), null, null), (MessagePublisher) factory.f(Reflection.b(MessagePublisher.class), null, null), (InternalNotificationManager) factory.f(Reflection.b(InternalNotificationManager.class), null, null), (Logger) factory.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ChatManager"})));
                }
            };
            Module a13 = scopeDSL.a();
            Qualifier b19 = scopeDSL.b();
            k22 = CollectionsKt__CollectionsKt.k();
            FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(b19, Reflection.b(InternalChatManager.class), null, koinKt$coreModule$1$4$12, kind2, k22));
            a13.g(factoryInstanceFactory4);
            new KoinDefinition(a13, factoryInstanceFactory4);
            module.d().add(typeQualifier);
            AnonymousClass5 anonymousClass5 = new Function2<Scope, ParametersHolder, MqttSettings>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.5
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final MqttSettings s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return new BoltMqttSettings((ChatConnectionSettings) single.f(Reflection.b(ChatConnectionSettings.class), null, null));
                }
            };
            StringQualifier a14 = companion.a();
            k23 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(a14, Reflection.b(MqttSettings.class), null, anonymousClass5, kind, k23));
            module.g(singleInstanceFactory3);
            if (module.e()) {
                module.h(singleInstanceFactory3);
            }
            new KoinDefinition(module, singleInstanceFactory3);
            AnonymousClass6 anonymousClass6 = new Function2<Scope, ParametersHolder, ChatConfig>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.6
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ChatConfig s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return ((MqttSettings) single.f(Reflection.b(MqttSettings.class), null, null)).a();
                }
            };
            StringQualifier a15 = companion.a();
            k24 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory4 = new SingleInstanceFactory<>(new BeanDefinition(a15, Reflection.b(ChatConfig.class), null, anonymousClass6, kind, k24));
            module.g(singleInstanceFactory4);
            if (module.e()) {
                module.h(singleInstanceFactory4);
            }
            new KoinDefinition(module, singleInstanceFactory4);
            AnonymousClass7 anonymousClass7 = new Function2<Scope, ParametersHolder, MessageDirectionDetector>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.7
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final MessageDirectionDetector s(Scope factory, ParametersHolder it) {
                    Intrinsics.f(factory, "$this$factory");
                    Intrinsics.f(it, "it");
                    return MessageDirectionDetectorKt.a((ChatConfig) factory.f(Reflection.b(ChatConfig.class), null, null));
                }
            };
            StringQualifier a16 = companion.a();
            k25 = CollectionsKt__CollectionsKt.k();
            InstanceFactory<?> factoryInstanceFactory5 = new FactoryInstanceFactory<>(new BeanDefinition(a16, Reflection.b(MessageDirectionDetector.class), null, anonymousClass7, kind2, k25));
            module.g(factoryInstanceFactory5);
            new KoinDefinition(module, factoryInstanceFactory5);
            AnonymousClass8 anonymousClass8 = new Function2<Scope, ParametersHolder, ChatPushParser>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.8
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ChatPushParser s(Scope factory, ParametersHolder it) {
                    Intrinsics.f(factory, "$this$factory");
                    Intrinsics.f(it, "it");
                    return ChatPushParserKt.a((Logger) factory.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"ChatPushParser"})));
                }
            };
            StringQualifier a17 = companion.a();
            k26 = CollectionsKt__CollectionsKt.k();
            InstanceFactory<?> factoryInstanceFactory6 = new FactoryInstanceFactory<>(new BeanDefinition(a17, Reflection.b(ChatPushParser.class), null, anonymousClass8, kind2, k26));
            module.g(factoryInstanceFactory6);
            new KoinDefinition(module, factoryInstanceFactory6);
            AnonymousClass9 anonymousClass9 = new Function2<Scope, ParametersHolder, AppStateObserver>() { // from class: eu.bolt.chat.di.KoinKt$coreModule$1.9
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final AppStateObserver s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return new AppStateObserver(Dispatchers.a(), (Logger) single.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"AppStateObserver"})));
                }
            };
            StringQualifier a18 = companion.a();
            k27 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(a18, Reflection.b(AppStateObserver.class), null, anonymousClass9, kind, k27));
            module.g(singleInstanceFactory5);
            if (module.e()) {
                module.h(singleInstanceFactory5);
            }
            new KoinDefinition(module, singleInstanceFactory5);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            b(module);
            return Unit.f50853a;
        }
    }, 1, null);

    public static final KoinApplication b(final Module appModule) {
        Intrinsics.f(appModule, "appModule");
        return KoinApplicationKt.a(new Function1<KoinApplication, Unit>() { // from class: eu.bolt.chat.di.KoinKt$initKoin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(KoinApplication koinApplication) {
                Module module;
                Intrinsics.f(koinApplication, "$this$koinApplication");
                koinApplication.d(new KoinLogger(Level.NONE));
                module = KoinKt.f39061a;
                koinApplication.f(Module.this, KoinAndroid.a(), module);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KoinApplication koinApplication) {
                b(koinApplication);
                return Unit.f50853a;
            }
        });
    }
}
