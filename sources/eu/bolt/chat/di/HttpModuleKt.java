package eu.bolt.chat.di;

import co.touchlab.kermit.Logger;
import eu.bolt.chat.data.ChatCredentials;
import eu.bolt.chat.data.connection.ChatConnectionSettings;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import eu.bolt.chat.network.data.parser.ChatJsonParserKt;
import eu.bolt.chat.network.endpoint.ChatApiPathResolver;
import eu.bolt.chat.network.endpoint.ChatApiService;
import eu.bolt.chat.network.endpoint.ChatApiServiceImpl;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.cache.HttpCache;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.plugins.logging.LogLevel;
import io.ktor.client.plugins.logging.Logging;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
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

/* compiled from: HttpModule.kt */
/* loaded from: classes5.dex */
public final class HttpModuleKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Module f39045a = ModuleDSLKt.b(false, new Function1<Module, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt$httpModule$1
        public final void b(Module module) {
            List k8;
            List k9;
            Intrinsics.f(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, HttpClient>() { // from class: eu.bolt.chat.di.HttpModuleKt$httpModule$1.1
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final HttpClient s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    final ChatConnectionSettings chatConnectionSettings = (ChatConnectionSettings) single.f(Reflection.b(ChatConnectionSettings.class), null, null);
                    final Logger logger = (Logger) single.f(Reflection.b(Logger.class), null, new KoinKt$getWith$1(new Object[]{"HTTP"}));
                    return HttpClientKt.a((HttpClientEngine) single.f(Reflection.b(HttpClientEngine.class), null, null), new Function1<HttpClientConfig<?>, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt.httpModule.1.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void b(HttpClientConfig<?> HttpClient) {
                            Intrinsics.f(HttpClient, "$this$HttpClient");
                            HttpClient.g(HttpTimeout.f46390d, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt.httpModule.1.1.1.1
                                public final void b(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                                    long j8;
                                    Intrinsics.f(install, "$this$install");
                                    j8 = HttpModuleKt.f39046b;
                                    install.f(Long.valueOf(j8));
                                    install.g(Long.valueOf(j8));
                                    install.h(Long.valueOf(j8));
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
                                    b(httpTimeoutCapabilityConfiguration);
                                    return Unit.f50853a;
                                }
                            });
                            HttpClient.g(HttpCache.f46419c, new Function1<HttpCache.Config, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt.httpModule.1.1.1.2
                                public final void b(HttpCache.Config install) {
                                    Intrinsics.f(install, "$this$install");
                                    install.c(HttpCacheStorage.f46456a.a());
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(HttpCache.Config config) {
                                    b(config);
                                    return Unit.f50853a;
                                }
                            });
                            Logging.Companion companion = Logging.f46535d;
                            final Logger logger2 = Logger.this;
                            HttpClient.g(companion, new Function1<Logging.Config, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt.httpModule.1.1.1.3
                                {
                                    super(1);
                                }

                                public final void b(Logging.Config install) {
                                    Intrinsics.f(install, "$this$install");
                                    install.e(new HttpLogger(Logger.this));
                                    install.d(LogLevel.BODY);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Logging.Config config) {
                                    b(config);
                                    return Unit.f50853a;
                                }
                            });
                            HttpClient.g(ContentNegotiation.f46467c, new Function1<ContentNegotiation.Config, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt.httpModule.1.1.1.4
                                public final void b(ContentNegotiation.Config install) {
                                    Intrinsics.f(install, "$this$install");
                                    JsonSupportKt.b(install, ChatJsonParserKt.a(), null, 2, null);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ContentNegotiation.Config config) {
                                    b(config);
                                    return Unit.f50853a;
                                }
                            });
                            DefaultRequest.Plugin plugin = DefaultRequest.f46241b;
                            final ChatConnectionSettings chatConnectionSettings2 = chatConnectionSettings;
                            HttpClient.g(plugin, new Function1<DefaultRequest.DefaultRequestBuilder, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt.httpModule.1.1.1.5
                                {
                                    super(1);
                                }

                                public final void b(DefaultRequest.DefaultRequestBuilder install) {
                                    Intrinsics.f(install, "$this$install");
                                    final ChatConnectionSettings chatConnectionSettings3 = ChatConnectionSettings.this;
                                    install.c(new Function1<URLBuilder, Unit>() { // from class: eu.bolt.chat.di.HttpModuleKt.httpModule.1.1.1.5.1
                                        {
                                            super(1);
                                        }

                                        public final void b(URLBuilder url) {
                                            Intrinsics.f(url, "$this$url");
                                            url.y(URLProtocol.f46905c.d());
                                            url.w(ChatConnectionSettings.this.i());
                                            url.k().f("version", ChatConnectionSettings.this.a());
                                            url.k().f("deviceId", ChatConnectionSettings.this.e());
                                            url.k().f("device_name", ChatConnectionSettings.this.f());
                                            url.k().f("deviceType", ChatConnectionSettings.this.h());
                                            url.k().f("device_os_version", ChatConnectionSettings.this.g());
                                            if (ChatConnectionSettings.this.c() != null) {
                                                url.k().f("country", ChatConnectionSettings.this.c());
                                            }
                                            url.k().f("language", ChatConnectionSettings.this.j());
                                            url.k().f("session_id", ChatConnectionSettings.this.l());
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder) {
                                            b(uRLBuilder);
                                            return Unit.f50853a;
                                        }
                                    });
                                    ChatCredentials a8 = ChatConnectionSettings.this.d().a();
                                    if (a8 instanceof ChatCredentials.Basic) {
                                        ChatCredentials.Basic basic = (ChatCredentials.Basic) a8;
                                        UtilsKt.b(install, basic.c(), basic.b().c());
                                    } else if (a8 instanceof ChatCredentials.Bearer) {
                                        UtilsKt.c(install, ((ChatCredentials.Bearer) a8).b().c());
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DefaultRequest.DefaultRequestBuilder defaultRequestBuilder) {
                                    b(defaultRequestBuilder);
                                    return Unit.f50853a;
                                }
                            });
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                            b(httpClientConfig);
                            return Unit.f50853a;
                        }
                    });
                }
            };
            ScopeRegistry.Companion companion = ScopeRegistry.f52787e;
            StringQualifier a8 = companion.a();
            Kind kind = Kind.Singleton;
            k8 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(a8, Reflection.b(HttpClient.class), null, anonymousClass1, kind, k8));
            module.g(singleInstanceFactory);
            if (module.e()) {
                module.h(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory);
            AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, ChatApiService>() { // from class: eu.bolt.chat.di.HttpModuleKt$httpModule$1.2
                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ChatApiService s(Scope single, ParametersHolder it) {
                    Intrinsics.f(single, "$this$single");
                    Intrinsics.f(it, "it");
                    return new ChatApiServiceImpl((MessageDirectionDetector) single.f(Reflection.b(MessageDirectionDetector.class), null, null), (HttpClient) single.f(Reflection.b(HttpClient.class), null, null), new ChatApiPathResolver(((ChatConnectionSettings) single.f(Reflection.b(ChatConnectionSettings.class), null, null)).i()));
                }
            };
            StringQualifier a9 = companion.a();
            k9 = CollectionsKt__CollectionsKt.k();
            SingleInstanceFactory<?> singleInstanceFactory2 = new SingleInstanceFactory<>(new BeanDefinition(a9, Reflection.b(ChatApiService.class), null, anonymousClass2, kind, k9));
            module.g(singleInstanceFactory2);
            if (module.e()) {
                module.h(singleInstanceFactory2);
            }
            new KoinDefinition(module, singleInstanceFactory2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            b(module);
            return Unit.f50853a;
        }
    }, 1, null);

    /* renamed from: b  reason: collision with root package name */
    private static final long f39046b = Duration.t(DurationKt.s(20, DurationUnit.SECONDS));

    public static final Module b() {
        return f39045a;
    }
}
