package com.hivemq.client.internal.netty;

import io.netty.channel.ChannelFuture;

/* loaded from: classes3.dex */
public interface ContextFuture<C> extends ChannelFuture {
    C getContext();
}
