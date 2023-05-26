package com.hivemq.client.internal.netty;

import io.netty.channel.Channel;
import io.netty.channel.DefaultChannelPromise;

/* loaded from: classes3.dex */
public class DefaultContextPromise<C> extends DefaultChannelPromise implements ContextFuture {

    /* renamed from: f  reason: collision with root package name */
    private final C f18633f;

    public DefaultContextPromise(Channel channel, C c8) {
        super(channel);
        this.f18633f = c8;
    }

    @Override // com.hivemq.client.internal.netty.ContextFuture
    public C getContext() {
        return this.f18633f;
    }
}
