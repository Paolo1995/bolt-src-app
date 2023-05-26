package io.netty.handler.codec.http;

/* loaded from: classes5.dex */
public interface HttpMessage extends HttpObject {
    HttpHeaders headers();

    HttpVersion protocolVersion();
}
