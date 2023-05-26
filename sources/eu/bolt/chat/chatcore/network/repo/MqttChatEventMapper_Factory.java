package eu.bolt.chat.chatcore.network.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MqttChatEventMapper_Factory implements Factory<MqttChatEventMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatEventMapper> f38370a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttEventMapper> f38371b;

    public MqttChatEventMapper_Factory(Provider<ChatEventMapper> provider, Provider<MqttEventMapper> provider2) {
        this.f38370a = provider;
        this.f38371b = provider2;
    }

    public static MqttChatEventMapper_Factory a(Provider<ChatEventMapper> provider, Provider<MqttEventMapper> provider2) {
        return new MqttChatEventMapper_Factory(provider, provider2);
    }

    public static MqttChatEventMapper c(ChatEventMapper chatEventMapper, MqttEventMapper mqttEventMapper) {
        return new MqttChatEventMapper(chatEventMapper, mqttEventMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttChatEventMapper get() {
        return c(this.f38370a.get(), this.f38371b.get());
    }
}
