package com.hivemq.client.internal.mqtt.codec.decoder;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnectRestrictions;
import com.hivemq.client.mqtt.exceptions.MqttDecodeException;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttDecoder extends ByteToMessageDecoder {

    /* renamed from: f  reason: collision with root package name */
    private final MqttMessageDecoders f17858f;

    /* renamed from: g  reason: collision with root package name */
    private final MqttDecoderContext f17859g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttDecoder(MqttMessageDecoders mqttMessageDecoders, MqttClientConfig mqttClientConfig, MqttConnect mqttConnect) {
        this.f17858f = mqttMessageDecoders;
        MqttConnectRestrictions k8 = mqttConnect.k();
        this.f17859g = new MqttDecoderContext(k8.a(), k8.f(), k8.g(), k8.h(), mqttClientConfig.d().c(), false, false, false);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.readableBytes() < 2) {
            return;
        }
        int readerIndex = byteBuf.readerIndex();
        short readUnsignedByte = byteBuf.readUnsignedByte();
        int i8 = readUnsignedByte >> 4;
        int i9 = readUnsignedByte & 15;
        int a8 = MqttVariableByteInteger.a(byteBuf);
        try {
            if (a8 < 0) {
                if (a8 == -1) {
                    byteBuf.readerIndex(readerIndex);
                    return;
                }
                throw new MqttDecoderException("malformed remaining length");
            }
            int readerIndex2 = byteBuf.readerIndex();
            if ((readerIndex2 - readerIndex) + a8 <= this.f17859g.a()) {
                int writerIndex = byteBuf.writerIndex();
                int i10 = readerIndex2 + a8;
                if (writerIndex < i10) {
                    byteBuf.readerIndex(readerIndex);
                    return;
                }
                MqttMessageDecoder a9 = this.f17858f.a(i8);
                if (a9 != null) {
                    byteBuf.writerIndex(i10);
                    list.add(a9.a(i9, byteBuf, this.f17859g));
                    byteBuf.writerIndex(writerIndex);
                    return;
                }
                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "must not receive this packet type");
            }
            throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PACKET_TOO_LARGE, "incoming packet exceeded maximum packet size");
        } catch (MqttDecoderException e8) {
            byteBuf.clear();
            Object a10 = Mqtt5MessageType.a(i8);
            StringBuilder sb = new StringBuilder();
            sb.append("Exception while decoding ");
            if (a10 == null) {
                a10 = "UNKNOWN";
            }
            sb.append(a10);
            sb.append(": ");
            sb.append(e8.getMessage());
            MqttDisconnectUtil.d(channelHandlerContext.channel(), e8.a(), new MqttDecodeException(sb.toString()));
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return false;
    }
}
