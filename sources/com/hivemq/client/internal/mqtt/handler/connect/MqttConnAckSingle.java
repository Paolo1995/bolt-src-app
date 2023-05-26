package com.hivemq.client.internal.mqtt.handler.connect;

import androidx.camera.view.e;
import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientTransportConfigImpl;
import com.hivemq.client.internal.mqtt.exceptions.MqttClientStateExceptions;
import com.hivemq.client.internal.mqtt.lifecycle.MqttClientDisconnectedContextImpl;
import com.hivemq.client.internal.mqtt.lifecycle.MqttClientReconnector;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.exceptions.ConnectionFailedException;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;
import j$.util.function.BiConsumer;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public class MqttConnAckSingle extends Single<Mqtt5ConnAck> {

    /* renamed from: h  reason: collision with root package name */
    private static final InternalLogger f18104h = InternalLoggerFactory.a(MqttConnAckSingle.class);

    /* renamed from: f  reason: collision with root package name */
    private final MqttClientConfig f18105f;

    /* renamed from: g  reason: collision with root package name */
    private final MqttConnect f18106g;

    public MqttConnAckSingle(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect) {
        this.f18105f = mqttClientConfig;
        this.f18106g = mqttConnect.n(mqttClientConfig);
    }

    private static void c0(final MqttClientConfig mqttClientConfig, final MqttConnect mqttConnect, final MqttConnAckFlow mqttConnAckFlow, final EventLoop eventLoop) {
        if (mqttConnAckFlow.b().isDisposed()) {
            mqttClientConfig.s();
            mqttClientConfig.o().set(MqttClientState.DISCONNECTED);
            return;
        }
        Bootstrap a8 = mqttClientConfig.e().d().b(mqttConnect).a(mqttConnAckFlow).build().a();
        MqttClientTransportConfigImpl i8 = mqttClientConfig.i();
        a8.group(eventLoop).connect(i8.f(), i8.b()).addListener(new GenericFutureListener() { // from class: com.hivemq.client.internal.mqtt.handler.connect.a
            @Override // io.netty.util.concurrent.GenericFutureListener
            public final void operationComplete(Future future) {
                MqttConnAckSingle.d0(EventLoop.this, mqttClientConfig, mqttConnect, mqttConnAckFlow, future);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(final EventLoop eventLoop, final MqttClientConfig mqttClientConfig, final MqttConnect mqttConnect, final MqttConnAckFlow mqttConnAckFlow, Future future) throws Exception {
        Throwable cause = future.cause();
        if (cause != null) {
            final ConnectionFailedException connectionFailedException = new ConnectionFailedException(cause);
            if (eventLoop.inEventLoop()) {
                i0(mqttClientConfig, MqttDisconnectSource.CLIENT, connectionFailedException, mqttConnect, mqttConnAckFlow, eventLoop);
            } else {
                eventLoop.execute(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.connect.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MqttConnAckSingle.e0(MqttClientConfig.this, connectionFailedException, mqttConnect, mqttConnAckFlow, eventLoop);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(MqttClientConfig mqttClientConfig, ConnectionFailedException connectionFailedException, MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow, EventLoop eventLoop) {
        i0(mqttClientConfig, MqttDisconnectSource.CLIENT, connectionFailedException, mqttConnect, mqttConnAckFlow, eventLoop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(MqttClientReconnector mqttClientReconnector, MqttClientConfig mqttClientConfig, MqttConnAckFlow mqttConnAckFlow, EventLoop eventLoop, Object obj, Throwable th) {
        if (mqttClientReconnector.m()) {
            if (e.a(mqttClientConfig.o(), MqttClientState.DISCONNECTED_RECONNECT, MqttClientState.CONNECTING_RECONNECT)) {
                mqttClientConfig.w(mqttClientReconnector.l());
                c0(mqttClientConfig, mqttClientReconnector.i(), new MqttConnAckFlow(mqttConnAckFlow), eventLoop);
            }
        } else if (e.a(mqttClientConfig.o(), MqttClientState.DISCONNECTED_RECONNECT, MqttClientState.DISCONNECTED)) {
            mqttClientConfig.s();
            if (mqttConnAckFlow != null) {
                if (th == null) {
                    mqttConnAckFlow.c(new ConnectionFailedException("Reconnect was cancelled."));
                } else {
                    mqttConnAckFlow.c(new ConnectionFailedException(th));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(final MqttClientReconnector mqttClientReconnector, final MqttClientConfig mqttClientConfig, final MqttConnAckFlow mqttConnAckFlow, final EventLoop eventLoop) {
        mqttClientReconnector.k().whenComplete((BiConsumer<? super Object, ? super Throwable>) BiConsumer.Wrapper.convert(new j$.util.function.BiConsumer() { // from class: com.hivemq.client.internal.mqtt.handler.connect.d
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MqttConnAckSingle.f0(MqttClientReconnector.this, mqttClientConfig, mqttConnAckFlow, eventLoop, obj, (Throwable) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ j$.util.function.BiConsumer andThen(j$.util.function.BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }));
    }

    private static void h0(final MqttClientConfig mqttClientConfig, MqttDisconnectSource mqttDisconnectSource, Throwable th, MqttConnect mqttConnect, int i8, final MqttConnAckFlow mqttConnAckFlow, final EventLoop eventLoop) {
        final MqttClientReconnector mqttClientReconnector = new MqttClientReconnector(eventLoop, i8, mqttConnect, mqttClientConfig.i());
        MqttClientDisconnectedContext f8 = MqttClientDisconnectedContextImpl.f(mqttClientConfig, mqttDisconnectSource, th, mqttClientReconnector);
        ImmutableList.ImmutableListIterator<MqttClientDisconnectedListener> it = mqttClientConfig.j().iterator();
        while (it.hasNext()) {
            try {
                it.next().a(f8);
            } catch (Throwable th2) {
                f18104h.error("Unexpected exception thrown by disconnected listener.", th2);
            }
        }
        if (mqttClientReconnector.m()) {
            mqttClientConfig.o().set(MqttClientState.DISCONNECTED_RECONNECT);
            Runnable runnable = new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.connect.b
                @Override // java.lang.Runnable
                public final void run() {
                    MqttConnAckSingle.g0(MqttClientReconnector.this, mqttClientConfig, mqttConnAckFlow, eventLoop);
                }
            };
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            eventLoop.schedule(runnable, mqttClientReconnector.j(timeUnit), timeUnit);
            mqttClientConfig.y(mqttClientReconnector.o());
            mqttClientConfig.x(mqttClientReconnector.n());
            mqttClientReconnector.e();
            return;
        }
        mqttClientConfig.o().set(MqttClientState.DISCONNECTED);
        mqttClientConfig.s();
        if (mqttConnAckFlow != null) {
            mqttConnAckFlow.c(th);
        }
    }

    public static void i0(MqttClientConfig mqttClientConfig, MqttDisconnectSource mqttDisconnectSource, Throwable th, MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow, EventLoop eventLoop) {
        if (mqttConnAckFlow.e()) {
            h0(mqttClientConfig, mqttDisconnectSource, th, mqttConnect, mqttConnAckFlow.a() + 1, mqttConnAckFlow, eventLoop);
        }
    }

    public static void j0(MqttClientConfig mqttClientConfig, MqttDisconnectSource mqttDisconnectSource, Throwable th, MqttConnect mqttConnect, EventLoop eventLoop) {
        h0(mqttClientConfig, mqttDisconnectSource, th, mqttConnect, 0, null, eventLoop);
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super Mqtt5ConnAck> singleObserver) {
        if (!e.a(this.f18105f.o(), MqttClientState.DISCONNECTED, MqttClientState.CONNECTING)) {
            EmptyDisposable.j(MqttClientStateExceptions.a(), singleObserver);
            return;
        }
        MqttConnAckFlow mqttConnAckFlow = new MqttConnAckFlow(singleObserver);
        singleObserver.onSubscribe(mqttConnAckFlow.b());
        MqttClientConfig mqttClientConfig = this.f18105f;
        c0(mqttClientConfig, this.f18106g, mqttConnAckFlow, mqttClientConfig.b());
    }
}
