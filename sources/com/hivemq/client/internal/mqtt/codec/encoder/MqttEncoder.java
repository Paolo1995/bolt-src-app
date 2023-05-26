package com.hivemq.client.internal.mqtt.codec.encoder;

import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttEncoder extends ChannelDuplexHandler {

    /* renamed from: f  reason: collision with root package name */
    private final MqttMessageEncoders f17912f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17914h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17915i = false;

    /* renamed from: g  reason: collision with root package name */
    private final MqttEncoderContext f17913g = new MqttEncoderContext(ByteBufAllocator.DEFAULT);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttEncoder(MqttMessageEncoders mqttMessageEncoders) {
        this.f17912f = mqttMessageEncoders;
    }

    public void a(MqttClientConnectionConfig mqttClientConnectionConfig) {
        this.f17913g.c(mqttClientConnectionConfig.h());
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        this.f17914h = true;
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelReadComplete();
        this.f17914h = false;
        if (this.f17915i) {
            this.f17915i = false;
            channelHandlerContext.flush();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        if (this.f17914h) {
            this.f17915i = true;
        } else {
            channelHandlerContext.flush();
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return false;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (obj instanceof MqttMessage) {
            MqttMessage mqttMessage = (MqttMessage) obj;
            MqttMessageEncoder<?> a8 = this.f17912f.a(mqttMessage.getType().c());
            if (a8 != null) {
                channelHandlerContext.write(a8.a(mqttMessage, this.f17913g), channelPromise);
                return;
            }
            throw new UnsupportedOperationException();
        }
        channelHandlerContext.write(obj, channelPromise);
    }
}
