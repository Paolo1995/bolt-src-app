package io.netty.handler.codec.http;

/* loaded from: classes5.dex */
public interface HttpRequest extends HttpMessage {
    HttpMethod method();

    String uri();
}
