package eu.bolt.chat.chatcore.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.hivemq.HiveMqttController;
import eu.bolt.chat.chatcore.mqtt.MqttController;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MqttControllerModule_ProvideMqttController$chat_core_releaseFactory implements Factory<MqttController> {

    /* renamed from: a  reason: collision with root package name */
    private final MqttControllerModule f38099a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HiveMqttController> f38100b;

    public MqttControllerModule_ProvideMqttController$chat_core_releaseFactory(MqttControllerModule mqttControllerModule, Provider<HiveMqttController> provider) {
        this.f38099a = mqttControllerModule;
        this.f38100b = provider;
    }

    public static MqttControllerModule_ProvideMqttController$chat_core_releaseFactory a(MqttControllerModule mqttControllerModule, Provider<HiveMqttController> provider) {
        return new MqttControllerModule_ProvideMqttController$chat_core_releaseFactory(mqttControllerModule, provider);
    }

    public static MqttController c(MqttControllerModule mqttControllerModule, HiveMqttController hiveMqttController) {
        return (MqttController) Preconditions.checkNotNullFromProvides(mqttControllerModule.a(hiveMqttController));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttController get() {
        return c(this.f38099a, this.f38100b.get());
    }
}
