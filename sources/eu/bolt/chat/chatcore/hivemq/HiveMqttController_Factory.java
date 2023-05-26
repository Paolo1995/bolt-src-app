package eu.bolt.chat.chatcore.hivemq;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider;
import eu.bolt.chat.chatcore.network.repo.MqttChatEventMapper;
import eu.bolt.chat.chatcore.user.MqttInfoProvider;
import eu.bolt.chat.tools.logger.Logger;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class HiveMqttController_Factory implements Factory<HiveMqttController> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientProvider> f38219a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Logger> f38220b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Gson> f38221c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ChatConnectionProvider> f38222d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<MqttInfoProvider> f38223e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<MqttChatEventMapper> f38224f;

    public HiveMqttController_Factory(Provider<MqttClientProvider> provider, Provider<Logger> provider2, Provider<Gson> provider3, Provider<ChatConnectionProvider> provider4, Provider<MqttInfoProvider> provider5, Provider<MqttChatEventMapper> provider6) {
        this.f38219a = provider;
        this.f38220b = provider2;
        this.f38221c = provider3;
        this.f38222d = provider4;
        this.f38223e = provider5;
        this.f38224f = provider6;
    }

    public static HiveMqttController_Factory a(Provider<MqttClientProvider> provider, Provider<Logger> provider2, Provider<Gson> provider3, Provider<ChatConnectionProvider> provider4, Provider<MqttInfoProvider> provider5, Provider<MqttChatEventMapper> provider6) {
        return new HiveMqttController_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static HiveMqttController c(MqttClientProvider mqttClientProvider, Logger logger, Gson gson, ChatConnectionProvider chatConnectionProvider, MqttInfoProvider mqttInfoProvider, MqttChatEventMapper mqttChatEventMapper) {
        return new HiveMqttController(mqttClientProvider, logger, gson, chatConnectionProvider, mqttInfoProvider, mqttChatEventMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HiveMqttController get() {
        return c(this.f38219a.get(), this.f38220b.get(), this.f38221c.get(), this.f38222d.get(), this.f38223e.get(), this.f38224f.get());
    }
}
