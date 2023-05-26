package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class ReplayingDecoder<S> extends ByteToMessageDecoder {
    static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
    private int checkpoint;
    private final ReplayingDecoderByteBuf replayable;
    private S state;

    /* JADX INFO: Access modifiers changed from: protected */
    public ReplayingDecoder() {
        this(null);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i8;
        this.replayable.setCumulation(byteBuf);
        while (byteBuf.isReadable()) {
            try {
                int readerIndex = byteBuf.readerIndex();
                this.checkpoint = readerIndex;
                int size = list.size();
                if (size > 0) {
                    ByteToMessageDecoder.fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (!channelHandlerContext.isRemoved()) {
                        size = 0;
                    } else {
                        return;
                    }
                }
                S s7 = this.state;
                int readableBytes = byteBuf.readableBytes();
                try {
                    decodeRemovalReentryProtection(channelHandlerContext, this.replayable, list);
                    if (!channelHandlerContext.isRemoved()) {
                        if (size == list.size()) {
                            if (readableBytes == byteBuf.readableBytes() && s7 == this.state) {
                                throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() must consume the inbound data or change its state if it did not decode anything.");
                            }
                        } else {
                            if (readerIndex == byteBuf.readerIndex() && s7 == this.state) {
                                throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() method must consume the inbound data or change its state if it decoded something.");
                            }
                            if (isSingleDecode()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Signal e8) {
                    e8.expect(REPLAY);
                    if (!channelHandlerContext.isRemoved() && (i8 = this.checkpoint) >= 0) {
                        byteBuf.readerIndex(i8);
                        return;
                    }
                    return;
                }
            } catch (DecoderException e9) {
                throw e9;
            } catch (Exception e10) {
                throw new DecoderException(e10);
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    final void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        try {
            this.replayable.terminate();
            if (this.cumulation != null) {
                callDecode(channelHandlerContext, internalBuffer(), list);
            } else {
                this.replayable.setCumulation(Unpooled.EMPTY_BUFFER);
            }
            decodeLast(channelHandlerContext, this.replayable, list);
        } catch (Signal e8) {
            e8.expect(REPLAY);
        }
    }

    protected ReplayingDecoder(S s7) {
        this.replayable = new ReplayingDecoderByteBuf();
        this.checkpoint = -1;
        this.state = s7;
    }
}
