package com.hivemq.client.internal.mqtt.handler;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientSslConfigImpl;
import com.hivemq.client.internal.mqtt.MqttWebSocketConfigImpl;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoder;
import com.hivemq.client.internal.mqtt.handler.auth.MqttAuthHandler;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnAckFlow;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnAckSingle;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnectHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectHandler;
import com.hivemq.client.internal.mqtt.handler.ssl.MqttSslInitializer;
import com.hivemq.client.internal.mqtt.handler.websocket.MqttWebSocketInitializer;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.mqtt.exceptions.ConnectionFailedException;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import dagger.Lazy;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import j$.util.function.Consumer;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttChannelInitializer extends ChannelInboundHandlerAdapter {

    /* renamed from: f */
    private final MqttClientConfig f18004f;

    /* renamed from: g */
    private final MqttConnect f18005g;

    /* renamed from: h */
    private final MqttConnAckFlow f18006h;

    /* renamed from: i */
    private final MqttEncoder f18007i;

    /* renamed from: j */
    private final MqttConnectHandler f18008j;

    /* renamed from: k */
    private final MqttDisconnectHandler f18009k;

    /* renamed from: l */
    private final MqttAuthHandler f18010l;

    /* renamed from: m */
    private final Lazy<MqttWebSocketInitializer> f18011m;

    @Inject
    public MqttChannelInitializer(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow, MqttEncoder mqttEncoder, MqttConnectHandler mqttConnectHandler, MqttDisconnectHandler mqttDisconnectHandler, MqttAuthHandler mqttAuthHandler, Lazy<MqttWebSocketInitializer> lazy) {
        this.f18004f = mqttClientConfig;
        this.f18005g = mqttConnect;
        this.f18006h = mqttConnAckFlow;
        this.f18007i = mqttEncoder;
        this.f18008j = mqttConnectHandler;
        this.f18009k = mqttDisconnectHandler;
        this.f18010l = mqttAuthHandler;
        this.f18011m = lazy;
    }

    public void f(Channel channel) {
        channel.pipeline().addLast("encoder", this.f18007i).addLast("auth", this.f18010l).addLast("connect", this.f18008j).addLast("disconnect", this.f18009k);
    }

    private void g(Channel channel) {
        this.f18004f.i().c();
        i(channel);
    }

    private void i(Channel channel) {
        MqttClientSslConfigImpl d8 = this.f18004f.i().d();
        if (d8 == null) {
            j(channel);
        } else {
            MqttSslInitializer.b(channel, this.f18004f, d8, new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.a
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    MqttChannelInitializer.this.j((Channel) obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            }, new b(this));
        }
    }

    public void j(Channel channel) {
        MqttWebSocketConfigImpl e8 = this.f18004f.i().e();
        if (e8 == null) {
            f(channel);
        } else {
            this.f18011m.get().a(channel, this.f18004f, e8, new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.c
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    MqttChannelInitializer.this.f((Channel) obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            }, new b(this));
        }
    }

    public void k(Channel channel, Throwable th) {
        channel.close();
        MqttConnAckSingle.i0(this.f18004f, MqttDisconnectSource.CLIENT, new ConnectionFailedException(th), this.f18005g, this.f18006h, channel.eventLoop());
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
        ((SocketChannel) channelHandlerContext.channel()).config().setAutoClose(false).setKeepAlive(true).setTcpNoDelay(true).setConnectTimeoutMillis(this.f18004f.i().h());
        g(channelHandlerContext.channel());
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return false;
    }
}
