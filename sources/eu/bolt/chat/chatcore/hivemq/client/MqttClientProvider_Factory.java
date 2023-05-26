package eu.bolt.chat.chatcore.hivemq.client;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.connection.ChatConnectionController;
import eu.bolt.chat.tools.logger.Logger;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MqttClientProvider_Factory implements Factory<MqttClientProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatConnectionController> f38241a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Logger> f38242b;

    public MqttClientProvider_Factory(Provider<ChatConnectionController> provider, Provider<Logger> provider2) {
        this.f38241a = provider;
        this.f38242b = provider2;
    }

    public static MqttClientProvider_Factory a(Provider<ChatConnectionController> provider, Provider<Logger> provider2) {
        return new MqttClientProvider_Factory(provider, provider2);
    }

    public static MqttClientProvider c(ChatConnectionController chatConnectionController, Logger logger) {
        return new MqttClientProvider(chatConnectionController, logger);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttClientProvider get() {
        return c(this.f38241a.get(), this.f38242b.get());
    }
}
