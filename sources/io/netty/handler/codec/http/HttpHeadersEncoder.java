package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;

/* loaded from: classes5.dex */
final class HttpHeadersEncoder {
    private HttpHeadersEncoder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void encoderHeader(CharSequence charSequence, CharSequence charSequence2, ByteBuf byteBuf) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        byteBuf.ensureWritable(length + length2 + 4);
        int writerIndex = byteBuf.writerIndex();
        writeAscii(byteBuf, writerIndex, charSequence);
        int i8 = writerIndex + length;
        ByteBufUtil.setShortBE(byteBuf, i8, 14880);
        int i9 = i8 + 2;
        writeAscii(byteBuf, i9, charSequence2);
        int i10 = i9 + length2;
        ByteBufUtil.setShortBE(byteBuf, i10, 3338);
        byteBuf.writerIndex(i10 + 2);
    }

    private static void writeAscii(ByteBuf byteBuf, int i8, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i8, charSequence.length());
        } else {
            byteBuf.setCharSequence(i8, charSequence, CharsetUtil.US_ASCII);
        }
    }
}
