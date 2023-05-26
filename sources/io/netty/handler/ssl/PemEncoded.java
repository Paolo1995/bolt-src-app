package io.netty.handler.ssl;

import io.netty.buffer.ByteBufHolder;

/* loaded from: classes5.dex */
interface PemEncoded extends ByteBufHolder {
    boolean isSensitive();

    @Override // io.netty.util.ReferenceCounted
    PemEncoded retain();
}
