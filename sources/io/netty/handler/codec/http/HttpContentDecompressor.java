package io.netty.handler.codec.http;

import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;

/* loaded from: classes5.dex */
public class HttpContentDecompressor extends HttpContentDecoder {
    private final boolean strict;

    public HttpContentDecompressor() {
        this(false);
    }

    @Override // io.netty.handler.codec.http.HttpContentDecoder
    protected EmbeddedChannel newContentDecoder(String str) throws Exception {
        ZlibWrapper zlibWrapper;
        if (!HttpHeaderValues.GZIP.contentEqualsIgnoreCase(str) && !HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(str)) {
            if (!HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(str) && !HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(str)) {
                return null;
            }
            if (this.strict) {
                zlibWrapper = ZlibWrapper.ZLIB;
            } else {
                zlibWrapper = ZlibWrapper.ZLIB_OR_NONE;
            }
            return new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibDecoder(zlibWrapper));
        }
        return new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));
    }

    public HttpContentDecompressor(boolean z7) {
        this.strict = z7;
    }
}
