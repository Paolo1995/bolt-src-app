package io.netty.handler.codec.http;

import io.netty.buffer.ByteBufHolder;

/* loaded from: classes5.dex */
public interface HttpContent extends HttpObject, ByteBufHolder {
    HttpContent retain();
}
