package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* loaded from: classes5.dex */
public class WebSocket08FrameEncoder extends MessageToMessageEncoder<WebSocketFrame> implements WebSocketFrameEncoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocket08FrameEncoder.class);
    private final boolean maskPayload;

    public WebSocket08FrameEncoder(boolean z7) {
        this.maskPayload = z7;
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        encode2(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [io.netty.util.ReferenceCounted] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        byte b8;
        ?? r42;
        boolean z7;
        int i8;
        ByteBuf buffer;
        ByteBuf content = webSocketFrame.content();
        int i9 = 0;
        if (webSocketFrame instanceof TextWebSocketFrame) {
            b8 = 1;
        } else if (webSocketFrame instanceof PingWebSocketFrame) {
            b8 = 9;
        } else if (webSocketFrame instanceof PongWebSocketFrame) {
            b8 = 10;
        } else if (webSocketFrame instanceof CloseWebSocketFrame) {
            b8 = 8;
        } else if (webSocketFrame instanceof BinaryWebSocketFrame) {
            b8 = 2;
        } else if (!(webSocketFrame instanceof ContinuationWebSocketFrame)) {
            throw new UnsupportedOperationException("Cannot encode frame of type: " + webSocketFrame.getClass().getName());
        } else {
            b8 = 0;
        }
        int readableBytes = content.readableBytes();
        InternalLogger internalLogger = logger;
        if (internalLogger.isTraceEnabled()) {
            internalLogger.trace("Encoding WebSocket Frame opCode={} length={}", Byte.valueOf(b8), Integer.valueOf(readableBytes));
        }
        int rsv = ((webSocketFrame.rsv() % 8) << 4) | (webSocketFrame.isFinalFragment() ? 128 : 0) | (b8 % 128);
        if (b8 == 9 && readableBytes > 125) {
            throw new TooLongFrameException("invalid payload for PING (payload length must be <= 125, was " + readableBytes);
        }
        try {
            z7 = this.maskPayload;
            i8 = z7 ? 4 : 0;
            r42 = 1024;
        } catch (Throwable th) {
            th = th;
            r42 = 0;
        }
        try {
            if (readableBytes <= 125) {
                int i10 = i8 + 2;
                if (z7 || readableBytes <= 1024) {
                    i10 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i10);
                buffer.writeByte(rsv);
                buffer.writeByte((byte) (this.maskPayload ? ((byte) readableBytes) | 128 : (byte) readableBytes));
            } else if (readableBytes <= 65535) {
                int i11 = i8 + 4;
                if (z7 || readableBytes <= 1024) {
                    i11 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i11);
                buffer.writeByte(rsv);
                buffer.writeByte(this.maskPayload ? 254 : 126);
                buffer.writeByte((readableBytes >>> 8) & 255);
                buffer.writeByte(readableBytes & 255);
            } else {
                int i12 = i8 + 10;
                if (z7 || readableBytes <= 1024) {
                    i12 += readableBytes;
                }
                buffer = channelHandlerContext.alloc().buffer(i12);
                buffer.writeByte(rsv);
                buffer.writeByte(this.maskPayload ? 255 : 127);
                buffer.writeLong(readableBytes);
            }
            if (this.maskPayload) {
                byte[] array = ByteBuffer.allocate(4).putInt((int) (Math.random() * 2.147483647E9d)).array();
                buffer.writeBytes(array);
                ByteOrder order = content.order();
                ByteOrder order2 = buffer.order();
                int readerIndex = content.readerIndex();
                int writerIndex = content.writerIndex();
                if (order == order2) {
                    int i13 = ((array[0] & 255) << 24) | ((array[1] & 255) << 16) | ((array[2] & 255) << 8) | (array[3] & 255);
                    if (order == ByteOrder.LITTLE_ENDIAN) {
                        i13 = Integer.reverseBytes(i13);
                    }
                    while (readerIndex + 3 < writerIndex) {
                        buffer.writeInt(content.getInt(readerIndex) ^ i13);
                        readerIndex += 4;
                    }
                }
                while (readerIndex < writerIndex) {
                    buffer.writeByte(content.getByte(readerIndex) ^ array[i9 % 4]);
                    readerIndex++;
                    i9++;
                }
                list.add(buffer);
            } else if (buffer.writableBytes() >= content.readableBytes()) {
                buffer.writeBytes(content);
                list.add(buffer);
            } else {
                list.add(buffer);
                list.add(content.retain());
            }
        } catch (Throwable th2) {
            th = th2;
            if (r42 != 0) {
                r42.release();
            }
            throw th;
        }
    }
}
