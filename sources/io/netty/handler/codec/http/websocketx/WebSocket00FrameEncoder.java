package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

@ChannelHandler.Sharable
/* loaded from: classes5.dex */
public class WebSocket00FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final ByteBuf _0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(0));
    private static final ByteBuf _0XFF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(-1));
    private static final ByteBuf _0XFF_0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2, 2).writeByte(-1).writeByte(0));

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (webSocketFrame instanceof TextWebSocketFrame) {
            ByteBuf content = webSocketFrame.content();
            list.add(_0X00.duplicate());
            list.add(content.retain());
            list.add(_0XFF.duplicate());
        } else if (webSocketFrame instanceof CloseWebSocketFrame) {
            list.add(_0XFF_0X00.duplicate());
        } else {
            ByteBuf content2 = webSocketFrame.content();
            int readableBytes = content2.readableBytes();
            ByteBuf buffer = channelHandlerContext.alloc().buffer(5);
            try {
                buffer.writeByte(-128);
                int i8 = (readableBytes >>> 28) & 127;
                int i9 = (readableBytes >>> 14) & 127;
                int i10 = (readableBytes >>> 7) & 127;
                int i11 = readableBytes & 127;
                if (i8 != 0) {
                    buffer.writeByte(i8 | 128);
                    buffer.writeByte(i9 | 128);
                    buffer.writeByte(i10 | 128);
                    buffer.writeByte(i11);
                } else if (i9 != 0) {
                    buffer.writeByte(i9 | 128);
                    buffer.writeByte(i10 | 128);
                    buffer.writeByte(i11);
                } else if (i10 == 0) {
                    buffer.writeByte(i11);
                } else {
                    buffer.writeByte(i10 | 128);
                    buffer.writeByte(i11);
                }
                list.add(buffer);
                list.add(content2.retain());
            } catch (Throwable th) {
                buffer.release();
                throw th;
            }
        }
    }
}
