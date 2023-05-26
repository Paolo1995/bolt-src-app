package eu.bolt.chat.chatcore.di;

import dagger.Module;
import dagger.Provides;
import eu.bolt.chat.chatcore.hivemq.HiveMqttController;
import eu.bolt.chat.chatcore.mqtt.MqttController;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MqttControllerModule.kt */
@Module
/* loaded from: classes5.dex */
public final class MqttControllerModule {
    @Provides
    @Singleton
    public final MqttController a(HiveMqttController mqttController) {
        Intrinsics.f(mqttController, "mqttController");
        return mqttController;
    }
}
