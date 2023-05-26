package com.hivemq.client.internal.mqtt.message.connect;

import com.hivemq.client.internal.mqtt.datatypes.MqttClientIdentifierImpl;
import com.hivemq.client.internal.mqtt.message.MqttStatefulMessage;
import com.hivemq.client.internal.mqtt.message.auth.MqttEnhancedAuth;

/* loaded from: classes3.dex */
public class MqttStatefulConnect extends MqttStatefulMessage<MqttConnect> {

    /* renamed from: c  reason: collision with root package name */
    private final MqttClientIdentifierImpl f18507c;

    /* renamed from: d  reason: collision with root package name */
    private final MqttEnhancedAuth f18508d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttStatefulConnect(MqttConnect mqttConnect, MqttClientIdentifierImpl mqttClientIdentifierImpl, MqttEnhancedAuth mqttEnhancedAuth) {
        super(mqttConnect);
        this.f18507c = mqttClientIdentifierImpl;
        this.f18508d = mqttEnhancedAuth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttStatefulMessage
    public String d() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.d());
        sb.append(", clientIdentifier=");
        sb.append(this.f18507c);
        if (this.f18508d == null) {
            str = "";
        } else {
            str = ", enhancedAuth=" + this.f18508d;
        }
        sb.append(str);
        return sb.toString();
    }

    public MqttClientIdentifierImpl e() {
        return this.f18507c;
    }

    public MqttEnhancedAuth f() {
        return this.f18508d;
    }

    public String toString() {
        return "MqttStatefulConnect{" + d() + '}';
    }
}
