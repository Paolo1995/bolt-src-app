package com.hivemq.client.internal.mqtt.handler.websocket;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientTransportConfigImpl;
import com.hivemq.client.internal.mqtt.MqttWebSocketConfigImpl;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import javax.inject.Inject;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MqttWebSocketInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final MqttWebSocketCodec f18356a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttWebSocketInitializer(MqttWebSocketCodec mqttWebSocketCodec) {
        this.f18356a = mqttWebSocketCodec;
    }

    public void a(Channel channel, MqttClientConfig mqttClientConfig, MqttWebSocketConfigImpl mqttWebSocketConfigImpl, Consumer<Channel> consumer, BiConsumer<Channel, Throwable> biConsumer) {
        String str;
        try {
            MqttClientTransportConfigImpl i8 = mqttClientConfig.i();
            InetSocketAddress g8 = i8.g();
            if (i8.d() == null) {
                str = "ws";
            } else {
                str = "wss";
            }
            String str2 = str;
            String hostString = g8.getHostString();
            int port = g8.getPort();
            channel.pipeline().addLast("http.codec", new HttpClientCodec()).addLast("http.aggregator", new HttpObjectAggregator(Settings.DEFAULT_INITIAL_WINDOW_SIZE)).addLast("ws.handshake", new MqttWebsocketHandshakeHandler(WebSocketClientHandshakerFactory.newHandshaker(new URI(str2, null, hostString, port, "/" + mqttWebSocketConfigImpl.c(), mqttWebSocketConfigImpl.b(), null), WebSocketVersion.V13, mqttWebSocketConfigImpl.d(), true, null, 268435460, true, false), mqttWebSocketConfigImpl.a(), consumer, biConsumer)).addLast("ws.mqtt", this.f18356a);
        } catch (URISyntaxException e8) {
            biConsumer.accept(channel, e8);
        }
    }
}
