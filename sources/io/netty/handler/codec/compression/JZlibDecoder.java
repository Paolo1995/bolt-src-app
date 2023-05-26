package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* loaded from: classes5.dex */
public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;

    /* renamed from: z  reason: collision with root package name */
    private final Inflater f47562z;

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB, 0);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return;
        }
        try {
            this.f47562z.avail_in = readableBytes;
            if (byteBuf.hasArray()) {
                this.f47562z.next_in = byteBuf.array();
                this.f47562z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
            } else {
                byte[] bArr = new byte[readableBytes];
                byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                this.f47562z.next_in = bArr;
                this.f47562z.next_in_index = 0;
            }
            int i8 = this.f47562z.next_in_index;
            ByteBuf prepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, null, readableBytes << 1);
            while (true) {
                prepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, prepareDecompressBuffer, this.f47562z.avail_in << 1);
                this.f47562z.avail_out = prepareDecompressBuffer.writableBytes();
                this.f47562z.next_out = prepareDecompressBuffer.array();
                this.f47562z.next_out_index = prepareDecompressBuffer.arrayOffset() + prepareDecompressBuffer.writerIndex();
                int i9 = this.f47562z.next_out_index;
                int inflate = this.f47562z.inflate(2);
                int i10 = this.f47562z.next_out_index - i9;
                if (i10 > 0) {
                    prepareDecompressBuffer.writerIndex(prepareDecompressBuffer.writerIndex() + i10);
                }
                if (inflate != -5) {
                    if (inflate != 0) {
                        if (inflate != 1) {
                            if (inflate != 2) {
                                ZlibUtil.fail(this.f47562z, "decompression failure", inflate);
                            } else {
                                byte[] bArr2 = this.dictionary;
                                if (bArr2 == null) {
                                    ZlibUtil.fail(this.f47562z, "decompression failure", inflate);
                                } else {
                                    int inflateSetDictionary = this.f47562z.inflateSetDictionary(bArr2, bArr2.length);
                                    if (inflateSetDictionary != 0) {
                                        ZlibUtil.fail(this.f47562z, "failed to set the dictionary", inflateSetDictionary);
                                    }
                                }
                            }
                        } else {
                            this.finished = true;
                            this.f47562z.inflateEnd();
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (this.f47562z.avail_in <= 0) {
                    break;
                }
            }
            byteBuf.skipBytes(this.f47562z.next_in_index - i8);
            if (prepareDecompressBuffer.isReadable()) {
                list.add(prepareDecompressBuffer);
            } else {
                prepareDecompressBuffer.release();
            }
        } finally {
            this.f47562z.next_in = null;
            this.f47562z.next_out = null;
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    protected void decompressionBufferExhausted(ByteBuf byteBuf) {
        this.finished = true;
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 0);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper, int i8) {
        super(i8);
        Inflater inflater = new Inflater();
        this.f47562z = inflater;
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        int init = inflater.init(ZlibUtil.convertWrapperType(zlibWrapper));
        if (init != 0) {
            ZlibUtil.fail(inflater, "initialization failure", init);
        }
    }
}
