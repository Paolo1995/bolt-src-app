package com.hivemq.client.internal.mqtt.handler.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import io.netty.util.concurrent.ScheduledFuture;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MqttWebsocketHandshakeHandler extends ChannelInboundHandlerAdapter {

    /* renamed from: f  reason: collision with root package name */
    private final WebSocketClientHandshaker f18358f;

    /* renamed from: g  reason: collision with root package name */
    private final int f18359g;

    /* renamed from: h  reason: collision with root package name */
    private final Consumer<Channel> f18360h;

    /* renamed from: i  reason: collision with root package name */
    private final BiConsumer<Channel, Throwable> f18361i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18362j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18363k = false;

    /* renamed from: l  reason: collision with root package name */
    private ScheduledFuture<?> f18364l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttWebsocketHandshakeHandler(WebSocketClientHandshaker webSocketClientHandshaker, int i8, Consumer<Channel> consumer, BiConsumer<Channel, Throwable> biConsumer) {
        this.f18358f = webSocketClientHandshaker;
        this.f18359g = i8;
        this.f18360h = consumer;
        this.f18361i = biConsumer;
    }

    private void b(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) {
        if (f(channelHandlerContext)) {
            try {
                this.f18358f.finishHandshake(channelHandlerContext.channel(), fullHttpResponse);
                this.f18360h.accept(channelHandlerContext.channel());
            } catch (Throwable th) {
                this.f18361i.accept(channelHandlerContext.channel(), th);
            }
        }
        fullHttpResponse.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(ChannelHandlerContext channelHandlerContext) {
        if (f(channelHandlerContext)) {
            BiConsumer<Channel, Throwable> biConsumer = this.f18361i;
            Channel channel = channelHandlerContext.channel();
            biConsumer.accept(channel, new WebSocketHandshakeException("handshake timed out after " + this.f18359g + "ms"));
        }
    }

    private boolean f(ChannelHandlerContext channelHandlerContext) {
        if (this.f18363k) {
            return false;
        }
        this.f18363k = true;
        channelHandlerContext.pipeline().remove(this);
        ScheduledFuture<?> scheduledFuture = this.f18364l;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f18364l = null;
        }
        return true;
    }

    private void g(final ChannelHandlerContext channelHandlerContext) {
        if (!this.f18362j) {
            this.f18362j = true;
            if (this.f18359g > 0) {
                this.f18364l = channelHandlerContext.channel().eventLoop().schedule(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.websocket.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        MqttWebsocketHandshakeHandler.this.d(channelHandlerContext);
                    }
                }, this.f18359g, TimeUnit.MILLISECONDS);
            }
            this.f18358f.handshake(channelHandlerContext.channel(), channelHandlerContext.voidPromise());
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        g(channelHandlerContext);
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        if (f(channelHandlerContext)) {
            this.f18361i.accept(channelHandlerContext.channel(), new WebSocketHandshakeException("connection was closed during handshake"));
        }
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof FullHttpResponse) {
            b(channelHandlerContext, (FullHttpResponse) obj);
        } else {
            channelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        if (f(channelHandlerContext)) {
            this.f18361i.accept(channelHandlerContext.channel(), th);
        } else {
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().isActive()) {
            g(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return false;
    }
}
