package eu.bolt.chat.chatcore.network.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.mqtt.MqttController;
import eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatNetworkRepoImpl_Factory implements Factory<ChatNetworkRepoImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttController> f38366a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ChatExternalNetworkRepo> f38367b;

    public ChatNetworkRepoImpl_Factory(Provider<MqttController> provider, Provider<ChatExternalNetworkRepo> provider2) {
        this.f38366a = provider;
        this.f38367b = provider2;
    }

    public static ChatNetworkRepoImpl_Factory a(Provider<MqttController> provider, Provider<ChatExternalNetworkRepo> provider2) {
        return new ChatNetworkRepoImpl_Factory(provider, provider2);
    }

    public static ChatNetworkRepoImpl c(MqttController mqttController, ChatExternalNetworkRepo chatExternalNetworkRepo) {
        return new ChatNetworkRepoImpl(mqttController, chatExternalNetworkRepo);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatNetworkRepoImpl get() {
        return c(this.f38366a.get(), this.f38367b.get());
    }
}
