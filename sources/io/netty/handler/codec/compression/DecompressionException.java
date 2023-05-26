package io.netty.handler.codec.compression;

import io.netty.handler.codec.DecoderException;

/* loaded from: classes5.dex */
public class DecompressionException extends DecoderException {
    public DecompressionException() {
    }

    public DecompressionException(String str, Throwable th) {
        super(str, th);
    }

    public DecompressionException(String str) {
        super(str);
    }
}
