package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes5.dex */
public abstract class DefaultHttpMessage extends DefaultHttpObject implements HttpMessage {
    private final HttpHeaders headers;
    private HttpVersion version;

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultHttpMessage(HttpVersion httpVersion, boolean z7, boolean z8) {
        this(httpVersion, z8 ? new CombinedHttpHeaders(z7) : new DefaultHttpHeaders(z7));
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpMessage)) {
            return false;
        }
        DefaultHttpMessage defaultHttpMessage = (DefaultHttpMessage) obj;
        if (!headers().equals(defaultHttpMessage.headers()) || !protocolVersion().equals(defaultHttpMessage.protocolVersion()) || !super.equals(obj)) {
            return false;
        }
        return true;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((((this.headers.hashCode() + 31) * 31) + this.version.hashCode()) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpVersion protocolVersion() {
        return this.version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultHttpMessage(HttpVersion httpVersion, HttpHeaders httpHeaders) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, "version");
        this.headers = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders, "headers");
    }
}
