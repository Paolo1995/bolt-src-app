package com.hivemq.client.internal.mqtt.handler.ping;

import com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.internal.mqtt.message.ping.MqttPingReq;
import com.hivemq.client.internal.mqtt.message.ping.MqttPingResp;
import com.hivemq.client.internal.netty.DefaultChannelOutboundHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;
import m0.a;

/* loaded from: classes3.dex */
public class MqttPingHandler extends MqttConnectionAwareHandler implements DefaultChannelOutboundHandler, Runnable, ChannelFutureListener {

    /* renamed from: g  reason: collision with root package name */
    private final long f18179g;

    /* renamed from: h  reason: collision with root package name */
    private long f18180h;

    /* renamed from: i  reason: collision with root package name */
    private long f18181i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18182j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18183k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18184l;

    /* renamed from: m  reason: collision with root package name */
    private ScheduledFuture<?> f18185m;

    public MqttPingHandler(int i8, long j8, long j9) {
        this.f18179g = TimeUnit.SECONDS.toNanos(i8) - TimeUnit.MILLISECONDS.toNanos(100L);
        this.f18180h = j8;
        this.f18181i = j9;
    }

    private long b(long j8) {
        return this.f18179g - (j8 - Math.min(this.f18181i, this.f18180h));
    }

    private void f(ChannelHandlerContext channelHandlerContext, long j8) {
        this.f18185m = channelHandlerContext.executor().schedule((Runnable) this, j8, TimeUnit.NANOSECONDS);
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler
    protected void a(ChannelHandlerContext channelHandlerContext, MqttDisconnectEvent mqttDisconnectEvent) {
        ScheduledFuture<?> scheduledFuture = this.f18185m;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f18185m = null;
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        this.f18181i = System.nanoTime();
        if (obj instanceof MqttPingResp) {
            this.f18184l = true;
            return;
        }
        this.f18184l = true;
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        a.a(this, channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        a.b(this, channelHandlerContext, socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    /* renamed from: d */
    public void operationComplete(ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            this.f18183k = true;
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        a.c(this, channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        this.f18180h = System.nanoTime();
        channelHandlerContext.flush();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        super.handlerAdded(channelHandlerContext);
        f(channelHandlerContext, b(System.nanoTime()));
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void read(ChannelHandlerContext channelHandlerContext) {
        a.e(this, channelHandlerContext);
    }

    @Override // java.lang.Runnable
    public void run() {
        ChannelHandlerContext channelHandlerContext = this.f18020f;
        if (channelHandlerContext == null) {
            return;
        }
        if (this.f18182j) {
            if (!this.f18183k) {
                MqttDisconnectUtil.a(channelHandlerContext.channel(), "Timeout while writing PINGREQ");
                return;
            } else if (!this.f18184l) {
                MqttDisconnectUtil.a(channelHandlerContext.channel(), "Timeout while waiting for PINGRESP");
                return;
            }
        }
        this.f18183k = false;
        this.f18184l = false;
        long nanoTime = System.nanoTime();
        long b8 = b(nanoTime);
        if (b8 > 1000) {
            this.f18182j = false;
            f(this.f18020f, b8);
            return;
        }
        this.f18182j = true;
        f(this.f18020f, this.f18179g);
        this.f18180h = nanoTime;
        this.f18020f.writeAndFlush(MqttPingReq.f18547b).addListener((GenericFutureListener<? extends Future<? super Void>>) this);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public /* synthetic */ void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        a.f(this, channelHandlerContext, obj, channelPromise);
    }
}
