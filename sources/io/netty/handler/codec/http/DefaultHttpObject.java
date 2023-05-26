package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes5.dex */
public class DefaultHttpObject implements HttpObject {
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpObject)) {
            return false;
        }
        return decoderResult().equals(((DefaultHttpObject) obj).decoderResult());
    }

    public int hashCode() {
        return 31 + this.decoderResult.hashCode();
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        this.decoderResult = (DecoderResult) ObjectUtil.checkNotNull(decoderResult, "decoderResult");
    }
}
