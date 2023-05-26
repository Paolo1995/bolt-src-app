package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.CharsetUtil;

/* loaded from: classes5.dex */
public class HttpRequestEncoder extends HttpObjectEncoder<HttpRequest> {
    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        if (super.acceptOutboundMessage(obj) && !(obj instanceof HttpResponse)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void encodeInitialLine(ByteBuf byteBuf, HttpRequest httpRequest) throws Exception {
        ByteBufUtil.copy(httpRequest.method().asciiName(), byteBuf);
        String uri = httpRequest.uri();
        if (uri.isEmpty()) {
            ByteBufUtil.writeMediumBE(byteBuf, 2109216);
        } else {
            int indexOf = uri.indexOf("://");
            boolean z7 = false;
            StringBuilder sb = uri;
            if (indexOf != -1) {
                char charAt = uri.charAt(0);
                sb = uri;
                if (charAt != '/') {
                    int i8 = indexOf + 3;
                    int indexOf2 = uri.indexOf(63, i8);
                    if (indexOf2 == -1) {
                        int lastIndexOf = uri.lastIndexOf(47);
                        sb = uri;
                        if (lastIndexOf < i8) {
                            z7 = true;
                            sb = uri;
                        }
                    } else {
                        int lastIndexOf2 = uri.lastIndexOf(47, indexOf2);
                        sb = uri;
                        if (lastIndexOf2 < i8) {
                            sb = new StringBuilder(uri).insert(indexOf2, '/');
                        }
                    }
                }
            }
            byteBuf.writeByte(32).writeCharSequence(sb, CharsetUtil.UTF_8);
            if (z7) {
                ByteBufUtil.writeShortBE(byteBuf, 12064);
            } else {
                byteBuf.writeByte(32);
            }
        }
        httpRequest.protocolVersion().encode(byteBuf);
        ByteBufUtil.writeShortBE(byteBuf, 3338);
    }
}
