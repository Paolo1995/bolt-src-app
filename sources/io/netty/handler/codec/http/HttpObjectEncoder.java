package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class HttpObjectEncoder<H extends HttpMessage> extends MessageToMessageEncoder<Object> {
    private static final ByteBuf CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2).writeByte(13).writeByte(10));
    private static final byte[] ZERO_CRLF_CRLF;
    private static final ByteBuf ZERO_CRLF_CRLF_BUF;
    private int state = 0;
    private float headersEncodedSizeAccumulator = 256.0f;
    private float trailersEncodedSizeAccumulator = 256.0f;

    static {
        byte[] bArr = {48, 13, 10, 13, 10};
        ZERO_CRLF_CRLF = bArr;
        ZERO_CRLF_CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(bArr.length).writeBytes(bArr));
    }

    private static long contentLength(Object obj) {
        if (obj instanceof HttpContent) {
            return ((HttpContent) obj).content().readableBytes();
        }
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    private static Object encodeAndRetain(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).retain();
        }
        if (obj instanceof HttpContent) {
            return ((HttpContent) obj).content().retain();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).retain();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    private void encodeChunkedContent(ChannelHandlerContext channelHandlerContext, Object obj, long j8, List<Object> list) {
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 > 0) {
            String hexString = Long.toHexString(j8);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(hexString.length() + 2);
            buffer.writeCharSequence(hexString, CharsetUtil.US_ASCII);
            ByteBufUtil.writeShortBE(buffer, 3338);
            list.add(buffer);
            list.add(encodeAndRetain(obj));
            list.add(CRLF_BUF.duplicate());
        }
        if (obj instanceof LastHttpContent) {
            HttpHeaders trailingHeaders = ((LastHttpContent) obj).trailingHeaders();
            if (trailingHeaders.isEmpty()) {
                list.add(ZERO_CRLF_CRLF_BUF.duplicate());
                return;
            }
            ByteBuf buffer2 = channelHandlerContext.alloc().buffer((int) this.trailersEncodedSizeAccumulator);
            ByteBufUtil.writeMediumBE(buffer2, 3149066);
            encodeHeaders(trailingHeaders, buffer2);
            ByteBufUtil.writeShortBE(buffer2, 3338);
            this.trailersEncodedSizeAccumulator = (padSizeForAccumulation(buffer2.readableBytes()) * 0.2f) + (this.trailersEncodedSizeAccumulator * 0.8f);
            list.add(buffer2);
        } else if (i8 == 0) {
            list.add(encodeAndRetain(obj));
        }
    }

    private static int padSizeForAccumulation(int i8) {
        return (i8 << 2) / 3;
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        if (!(obj instanceof HttpObject) && !(obj instanceof ByteBuf) && !(obj instanceof FileRegion)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encode(io.netty.channel.ChannelHandlerContext r11, java.lang.Object r12, java.util.List<java.lang.Object> r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectEncoder.encode(io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List):void");
    }

    protected void encodeHeaders(HttpHeaders httpHeaders, ByteBuf byteBuf) {
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            HttpHeadersEncoder.encoderHeader(next.getKey(), next.getValue(), byteBuf);
        }
    }

    protected abstract void encodeInitialLine(ByteBuf byteBuf, H h8) throws Exception;

    protected boolean isContentAlwaysEmpty(H h8) {
        return false;
    }

    protected void sanitizeHeadersBeforeEncode(H h8, boolean z7) {
    }
}
