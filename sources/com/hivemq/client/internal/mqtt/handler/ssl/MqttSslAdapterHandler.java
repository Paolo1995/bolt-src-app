package com.hivemq.client.internal.mqtt.handler.ssl;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MqttSslAdapterHandler extends ChannelInboundHandlerAdapter {

    /* renamed from: f  reason: collision with root package name */
    private final SslHandler f18323f;

    /* renamed from: g  reason: collision with root package name */
    private final String f18324g;

    /* renamed from: h  reason: collision with root package name */
    private final HostnameVerifier f18325h;

    /* renamed from: i  reason: collision with root package name */
    private final Consumer<Channel> f18326i;

    /* renamed from: j  reason: collision with root package name */
    private final BiConsumer<Channel, Throwable> f18327j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18328k = false;

    public MqttSslAdapterHandler(SslHandler sslHandler, String str, HostnameVerifier hostnameVerifier, Consumer<Channel> consumer, BiConsumer<Channel, Throwable> biConsumer) {
        this.f18323f = sslHandler;
        this.f18324g = str;
        this.f18325h = hostnameVerifier;
        this.f18326i = consumer;
        this.f18327j = biConsumer;
    }

    private void a(ChannelHandlerContext channelHandlerContext, SslHandshakeCompletionEvent sslHandshakeCompletionEvent) {
        if (b()) {
            if (sslHandshakeCompletionEvent.isSuccess()) {
                channelHandlerContext.pipeline().remove(this);
                HostnameVerifier hostnameVerifier = this.f18325h;
                if (hostnameVerifier != null && !hostnameVerifier.verify(this.f18324g, this.f18323f.engine().getSession())) {
                    this.f18327j.accept(channelHandlerContext.channel(), new SSLHandshakeException("Hostname verification failed"));
                    return;
                } else {
                    this.f18326i.accept(channelHandlerContext.channel());
                    return;
                }
            }
            this.f18327j.accept(channelHandlerContext.channel(), sslHandshakeCompletionEvent.cause());
        }
    }

    private boolean b() {
        if (!this.f18328k) {
            this.f18328k = true;
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.pipeline().remove(this);
        if (b()) {
            this.f18327j.accept(channelHandlerContext.channel(), th);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return false;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof SslHandshakeCompletionEvent) {
            a(channelHandlerContext, (SslHandshakeCompletionEvent) obj);
        } else {
            channelHandlerContext.fireUserEventTriggered(obj);
        }
    }
}
