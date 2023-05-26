package eu.bolt.chat;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import co.touchlab.kermit.StaticConfig;
import eu.bolt.chat.client.ChatClientManager;
import eu.bolt.chat.client.ChatNotificationManager;
import eu.bolt.chat.client.ChatPushHandler;
import eu.bolt.chat.client.ChatPushHandlerKt;
import eu.bolt.chat.client.ChatPushParserKt;
import eu.bolt.chat.client.ChatPushReceiver;
import eu.bolt.chat.client.InternalChatPushHandler;
import eu.bolt.chat.data.connection.ChatConnectionSettings;
import eu.bolt.chat.di.KoinKt;
import eu.bolt.chat.logger.ClientChatLogger;
import eu.bolt.chat.logger.ClientLogWriter;
import eu.bolt.chat.network.engine.PlatformMqttClientFactory;
import eu.bolt.chat.util.AppStateObserver;
import eu.bolt.chat.util.ForegroundStateListener;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.DefinitionBindingKt;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: ChatCore.kt */
/* loaded from: classes5.dex */
public final class ChatCore {

    /* renamed from: a  reason: collision with root package name */
    public static final ChatCore f37837a = new ChatCore();

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f37838b = AtomicFU.a(false);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f37839c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicRef<KoinApplication> f37840d = AtomicFU.e(null);

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicRef<InternalChatPushHandler> f37841e = AtomicFU.e(null);

    private ChatCore() {
    }

    private final InternalChatPushHandler a(Logger logger) {
        return ChatPushHandlerKt.a(ChatPushParserKt.a(logger), logger);
    }

    private final Logger b(ClientChatLogger clientChatLogger, String str) {
        List e8;
        e8 = CollectionsKt__CollectionsJVMKt.e(new ClientLogWriter(clientChatLogger));
        return new Logger(new StaticConfig(null, e8, 1, null), str);
    }

    private final InternalChatPushHandler h(ClientChatLogger clientChatLogger) {
        AtomicRef<InternalChatPushHandler> atomicRef = f37841e;
        InternalChatPushHandler b8 = atomicRef.b();
        if (b8 == null) {
            InternalChatPushHandler a8 = a(b(clientChatLogger, "ChatPushHandler"));
            atomicRef.c(a8);
            return a8;
        }
        return b8;
    }

    private final KoinApplication j(final PlatformMqttClientFactory platformMqttClientFactory, final ChatConnectionSettings chatConnectionSettings, ClientChatLogger clientChatLogger) {
        Logger.f8826c.j("Chat SDK");
        final Logger b8 = b(clientChatLogger, "Chat SDK");
        final InternalChatPushHandler a8 = f37841e.a(null);
        if (a8 == null) {
            a8 = a(b8.i("ChatPushHandler"));
        }
        Severity a9 = b8.c().a();
        Severity severity = Severity.Debug;
        if (a9.compareTo(severity) <= 0) {
            String d8 = b8.d();
            b8.f(severity, d8, null, "Initializing ChatKit with " + chatConnectionSettings);
        }
        return KoinKt.b(ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: eu.bolt.chat.ChatCore$unsafeInitialization$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Module module) {
                List k8;
                List k9;
                List k10;
                List k11;
                Intrinsics.f(module, "$this$module");
                final Logger logger = Logger.this;
                Function2<Scope, ParametersHolder, Logger> function2 = new Function2<Scope, ParametersHolder, Logger>() { // from class: eu.bolt.chat.ChatCore$unsafeInitialization$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: b */
                    public final Logger s(Scope factory, ParametersHolder parametersHolder) {
                        Intrinsics.f(factory, "$this$factory");
                        Intrinsics.f(parametersHolder, "<name for destructuring parameter 0>");
                        String str = (String) parametersHolder.a(0, Reflection.b(String.class));
                        if (str != null) {
                            return Logger.this.i(str);
                        }
                        return Logger.this;
                    }
                };
                ScopeRegistry.Companion companion = ScopeRegistry.f52787e;
                StringQualifier a10 = companion.a();
                Kind kind = Kind.Factory;
                k8 = CollectionsKt__CollectionsKt.k();
                InstanceFactory<?> factoryInstanceFactory = new FactoryInstanceFactory<>(new BeanDefinition(a10, Reflection.b(Logger.class), null, function2, kind, k8));
                module.g(factoryInstanceFactory);
                new KoinDefinition(module, factoryInstanceFactory);
                final ChatConnectionSettings chatConnectionSettings2 = chatConnectionSettings;
                Function2<Scope, ParametersHolder, ChatConnectionSettings> function22 = new Function2<Scope, ParametersHolder, ChatConnectionSettings>() { // from class: eu.bolt.chat.ChatCore$unsafeInitialization$2.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: b */
                    public final ChatConnectionSettings s(Scope single, ParametersHolder it) {
                        Intrinsics.f(single, "$this$single");
                        Intrinsics.f(it, "it");
                        return ChatConnectionSettings.this;
                    }
                };
                StringQualifier a11 = companion.a();
                Kind kind2 = Kind.Singleton;
                k9 = CollectionsKt__CollectionsKt.k();
                SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(a11, Reflection.b(ChatConnectionSettings.class), null, function22, kind2, k9));
                module.g(singleInstanceFactory);
                if (module.e()) {
                    module.h(singleInstanceFactory);
                }
                new KoinDefinition(module, singleInstanceFactory);
                final PlatformMqttClientFactory platformMqttClientFactory2 = platformMqttClientFactory;
                Function2<Scope, ParametersHolder, PlatformMqttClientFactory> function23 = new Function2<Scope, ParametersHolder, PlatformMqttClientFactory>() { // from class: eu.bolt.chat.ChatCore$unsafeInitialization$2.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: b */
                    public final PlatformMqttClientFactory s(Scope single, ParametersHolder it) {
                        Intrinsics.f(single, "$this$single");
                        Intrinsics.f(it, "it");
                        return PlatformMqttClientFactory.this;
                    }
                };
                StringQualifier a12 = companion.a();
                k10 = CollectionsKt__CollectionsKt.k();
                SingleInstanceFactory<?> singleInstanceFactory2 = new SingleInstanceFactory<>(new BeanDefinition(a12, Reflection.b(PlatformMqttClientFactory.class), null, function23, kind2, k10));
                module.g(singleInstanceFactory2);
                if (module.e()) {
                    module.h(singleInstanceFactory2);
                }
                new KoinDefinition(module, singleInstanceFactory2);
                final InternalChatPushHandler internalChatPushHandler = a8;
                Function2<Scope, ParametersHolder, InternalChatPushHandler> function24 = new Function2<Scope, ParametersHolder, InternalChatPushHandler>() { // from class: eu.bolt.chat.ChatCore$unsafeInitialization$2.4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: b */
                    public final InternalChatPushHandler s(Scope single, ParametersHolder it) {
                        Intrinsics.f(single, "$this$single");
                        Intrinsics.f(it, "it");
                        return InternalChatPushHandler.this;
                    }
                };
                StringQualifier a13 = companion.a();
                k11 = CollectionsKt__CollectionsKt.k();
                SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(a13, Reflection.b(InternalChatPushHandler.class), null, function24, kind2, k11));
                module.g(singleInstanceFactory3);
                if (module.e()) {
                    module.h(singleInstanceFactory3);
                }
                DefinitionBindingKt.b(new KoinDefinition(module, singleInstanceFactory3), new KClass[]{Reflection.b(ChatPushReceiver.class), Reflection.b(ChatPushHandler.class)});
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) {
                b(module);
                return Unit.f50853a;
            }
        }, 1, null));
    }

    public final ChatClientManager c() {
        return (ChatClientManager) g().e().d().f(Reflection.b(ChatClientManager.class), null, null);
    }

    public final ChatNotificationManager d() {
        return (ChatNotificationManager) g().e().d().f(Reflection.b(ChatNotificationManager.class), null, null);
    }

    public final ChatPushHandler e(ClientChatLogger logger) {
        ChatPushHandler h8;
        Intrinsics.f(logger, "logger");
        synchronized (f37839c) {
            if (f37838b.b()) {
                h8 = (ChatPushHandler) f37837a.g().e().d().f(Reflection.b(ChatPushHandler.class), null, null);
            } else {
                h8 = f37837a.h(logger);
            }
        }
        return h8;
    }

    public final ForegroundStateListener f() {
        return (ForegroundStateListener) g().e().d().f(Reflection.b(AppStateObserver.class), null, null);
    }

    public final Koin g() {
        KoinApplication b8 = f37840d.b();
        if (b8 != null) {
            return b8.b();
        }
        throw new IllegalArgumentException("ChatCore is not initialized".toString());
    }

    public final void i(PlatformMqttClientFactory mqttClientFactory, ChatConnectionSettings settings, ClientChatLogger logger) {
        Intrinsics.f(mqttClientFactory, "mqttClientFactory");
        Intrinsics.f(settings, "settings");
        Intrinsics.f(logger, "logger");
        synchronized (f37839c) {
            if (f37838b.a(false, true)) {
                f37840d.c(f37837a.j(mqttClientFactory, settings, logger));
            }
            Unit unit = Unit.f50853a;
        }
    }
}
