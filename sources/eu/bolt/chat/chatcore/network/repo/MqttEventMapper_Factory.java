package eu.bolt.chat.chatcore.network.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.user.MqttMessageExtrasProvider;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MqttEventMapper_Factory implements Factory<MqttEventMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttMessageExtrasProvider> f38374a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IdGenerator> f38375b;

    public MqttEventMapper_Factory(Provider<MqttMessageExtrasProvider> provider, Provider<IdGenerator> provider2) {
        this.f38374a = provider;
        this.f38375b = provider2;
    }

    public static MqttEventMapper_Factory a(Provider<MqttMessageExtrasProvider> provider, Provider<IdGenerator> provider2) {
        return new MqttEventMapper_Factory(provider, provider2);
    }

    public static MqttEventMapper c(MqttMessageExtrasProvider mqttMessageExtrasProvider, IdGenerator idGenerator) {
        return new MqttEventMapper(mqttMessageExtrasProvider, idGenerator);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttEventMapper get() {
        return c(this.f38374a.get(), this.f38375b.get());
    }
}
