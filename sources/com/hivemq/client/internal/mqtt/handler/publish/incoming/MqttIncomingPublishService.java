package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.checkpoint.Confirmable;
import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishConfirmable;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.util.collections.ChunkedArrayQueue;
import com.hivemq.client.internal.util.collections.HandleList;
import com.hivemq.client.mqtt.datatypes.MqttQos;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MqttIncomingPublishService {

    /* renamed from: k  reason: collision with root package name */
    private static final InternalLogger f18207k = InternalLoggerFactory.a(MqttIncomingPublishService.class);

    /* renamed from: a  reason: collision with root package name */
    private final MqttIncomingQosHandler f18208a;

    /* renamed from: b  reason: collision with root package name */
    final MqttIncomingPublishFlows f18209b;

    /* renamed from: c  reason: collision with root package name */
    private final ChunkedArrayQueue<MqttStatefulPublishWithFlows> f18210c;

    /* renamed from: d  reason: collision with root package name */
    private final ChunkedArrayQueue<MqttStatefulPublishWithFlows>.Iterator f18211d;

    /* renamed from: e  reason: collision with root package name */
    private final ChunkedArrayQueue<MqttStatefulPublishWithFlows> f18212e;

    /* renamed from: f  reason: collision with root package name */
    private final ChunkedArrayQueue<MqttStatefulPublishWithFlows>.Iterator f18213f;

    /* renamed from: g  reason: collision with root package name */
    private long f18214g;

    /* renamed from: h  reason: collision with root package name */
    private int f18215h;

    /* renamed from: i  reason: collision with root package name */
    private int f18216i;

    /* renamed from: j  reason: collision with root package name */
    private int f18217j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttIncomingPublishService(MqttIncomingQosHandler mqttIncomingQosHandler, MqttIncomingPublishFlows mqttIncomingPublishFlows) {
        ChunkedArrayQueue<MqttStatefulPublishWithFlows> chunkedArrayQueue = new ChunkedArrayQueue<>(32);
        this.f18210c = chunkedArrayQueue;
        this.f18211d = chunkedArrayQueue.iterator();
        ChunkedArrayQueue<MqttStatefulPublishWithFlows> chunkedArrayQueue2 = new ChunkedArrayQueue<>(32);
        this.f18212e = chunkedArrayQueue2;
        this.f18213f = chunkedArrayQueue2.iterator();
        this.f18214g = 1L;
        this.f18208a = mqttIncomingQosHandler;
        this.f18209b = mqttIncomingPublishFlows;
    }

    private void b(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        Confirmable mqttIncomingPublishConfirmable;
        Object d8 = mqttStatefulPublishWithFlows.d();
        while (true) {
            HandleList.Handle handle = (HandleList.Handle) d8;
            if (handle != null) {
                MqttIncomingPublishFlow mqttIncomingPublishFlow = (MqttIncomingPublishFlow) handle.c();
                if (mqttIncomingPublishFlow.isCancelled()) {
                    mqttStatefulPublishWithFlows.g(handle);
                    if (mqttIncomingPublishFlow.j() == 0) {
                        this.f18215h--;
                    }
                } else {
                    int i8 = (mqttIncomingPublishFlow.n(this.f18216i) > 0L ? 1 : (mqttIncomingPublishFlow.n(this.f18216i) == 0L ? 0 : -1));
                    if (i8 > 0) {
                        MqttPublish mqttPublish = (MqttPublish) mqttStatefulPublishWithFlows.f18228d.c();
                        if (mqttIncomingPublishFlow.f18194k) {
                            if (mqttPublish.j() == MqttQos.AT_MOST_ONCE) {
                                mqttIncomingPublishConfirmable = new MqttIncomingPublishConfirmable.Qos0();
                            } else {
                                mqttIncomingPublishConfirmable = new MqttIncomingPublishConfirmable(mqttIncomingPublishFlow, mqttStatefulPublishWithFlows);
                            }
                            mqttPublish = mqttPublish.s(mqttIncomingPublishConfirmable);
                        }
                        mqttIncomingPublishFlow.l(mqttPublish);
                        mqttStatefulPublishWithFlows.g(handle);
                        if (mqttIncomingPublishFlow.j() == 0) {
                            this.f18215h--;
                            mqttIncomingPublishFlow.i();
                        }
                    } else if (i8 == 0) {
                        int i9 = this.f18217j + 1;
                        this.f18217j = i9;
                        if (i9 == this.f18215h) {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
                d8 = handle.a();
            } else {
                return;
            }
        }
    }

    private void c(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        this.f18209b.e(mqttStatefulPublishWithFlows);
        if (mqttStatefulPublishWithFlows.f()) {
            f18207k.warn("No publish flow registered for {}.", mqttStatefulPublishWithFlows.f18228d);
        }
        a();
        Object d8 = mqttStatefulPublishWithFlows.d();
        while (true) {
            HandleList.Handle handle = (HandleList.Handle) d8;
            if (handle != null) {
                if (((MqttIncomingPublishFlow) handle.c()).m() == 1) {
                    this.f18215h++;
                }
                d8 = handle.a();
            } else {
                b(mqttStatefulPublishWithFlows);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f18216i++;
        this.f18217j = 0;
        this.f18213f.c();
        while (this.f18213f.hasNext()) {
            MqttStatefulPublishWithFlows next = this.f18213f.next();
            b(next);
            if (this.f18213f.b() == 1 && next.f() && next.l()) {
                this.f18213f.remove();
                this.f18208a.g(next);
            } else if (this.f18217j == this.f18215h) {
                return;
            }
        }
        this.f18211d.c();
        while (this.f18211d.hasNext()) {
            MqttStatefulPublishWithFlows next2 = this.f18211d.next();
            b(next2);
            if (this.f18211d.b() == 1 && next2.f()) {
                this.f18211d.remove();
            } else if (this.f18217j == this.f18215h) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows, int i8) {
        if (this.f18210c.size() >= i8) {
            f18207k.warn("QoS 0 publish message dropped.");
            this.f18211d.c();
            this.f18211d.remove();
            Object d8 = this.f18211d.next().d();
            while (true) {
                HandleList.Handle handle = (HandleList.Handle) d8;
                if (handle == null) {
                    break;
                }
                if (((MqttIncomingPublishFlow) handle.c()).j() == 0) {
                    this.f18215h--;
                }
                d8 = handle.a();
            }
        }
        c(mqttStatefulPublishWithFlows);
        if (!mqttStatefulPublishWithFlows.f()) {
            this.f18210c.m(mqttStatefulPublishWithFlows);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows, int i8) {
        if (this.f18212e.size() >= i8) {
            return false;
        }
        long j8 = this.f18214g;
        this.f18214g = 1 + j8;
        mqttStatefulPublishWithFlows.f18229e = j8;
        c(mqttStatefulPublishWithFlows);
        if (this.f18212e.isEmpty() && mqttStatefulPublishWithFlows.f() && mqttStatefulPublishWithFlows.l()) {
            this.f18208a.g(mqttStatefulPublishWithFlows);
            return true;
        }
        this.f18212e.m(mqttStatefulPublishWithFlows);
        return true;
    }
}
