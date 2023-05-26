package eu.bolt.chat.network.data.parser;

import eu.bolt.chat.client.MessageBox;
import eu.bolt.chat.network.data.MqttMessage;

/* compiled from: MqttMessageParser.kt */
/* loaded from: classes5.dex */
public interface MqttMessageParser {
    MessageBox a(MqttMessage mqttMessage);
}
