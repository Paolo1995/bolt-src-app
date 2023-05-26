package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import com.hivemq.client.internal.mqtt.message.unsubscribe.MqttUnsubscribe;
import com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback.mqtt3.Mqtt3UnsubAckView;
import com.hivemq.client.internal.util.collections.HandleList;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.MqttGlobalPublishFilter;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAckReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback.Mqtt5UnsubAckReasonCode;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class MqttIncomingPublishFlows {

    /* renamed from: a  reason: collision with root package name */
    private final MqttSubscribedPublishFlows f18204a = new MqttSubscribedPublishFlowTree();

    /* renamed from: b  reason: collision with root package name */
    private final HandleList<MqttGlobalIncomingPublishFlow>[] f18205b = new HandleList[MqttGlobalPublishFilter.values().length];

    private static void a(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows, HandleList<MqttGlobalIncomingPublishFlow> handleList) {
        if (handleList != null) {
            Object d8 = handleList.d();
            while (true) {
                HandleList.Handle handle = (HandleList.Handle) d8;
                if (handle != null) {
                    mqttStatefulPublishWithFlows.i((MqttIncomingPublishFlow) handle.c());
                    d8 = handle.a();
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(MqttSubscribedPublishFlow mqttSubscribedPublishFlow) {
        this.f18204a.g(mqttSubscribedPublishFlow);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(MqttGlobalIncomingPublishFlow mqttGlobalIncomingPublishFlow) {
        int ordinal = mqttGlobalIncomingPublishFlow.p().ordinal();
        HandleList<MqttGlobalIncomingPublishFlow> handleList = this.f18205b[ordinal];
        HandleList.Handle<MqttGlobalIncomingPublishFlow> q8 = mqttGlobalIncomingPublishFlow.q();
        if (handleList != null && q8 != null) {
            handleList.g(q8);
            if (handleList.f()) {
                this.f18205b[ordinal] = null;
            }
        }
    }

    public void d(Throwable th) {
        this.f18204a.d(th);
        int i8 = 0;
        while (true) {
            HandleList<MqttGlobalIncomingPublishFlow>[] handleListArr = this.f18205b;
            if (i8 < handleListArr.length) {
                HandleList<MqttGlobalIncomingPublishFlow> handleList = handleListArr[i8];
                if (handleList != null) {
                    Object d8 = handleList.d();
                    while (true) {
                        HandleList.Handle handle = (HandleList.Handle) d8;
                        if (handle != null) {
                            ((MqttGlobalIncomingPublishFlow) handle.c()).onError(th);
                            d8 = handle.a();
                        }
                    }
                }
                this.f18205b[i8] = null;
                i8++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        this.f18204a.a(mqttStatefulPublishWithFlows);
        if (mqttStatefulPublishWithFlows.f18231g) {
            a(mqttStatefulPublishWithFlows, this.f18205b[MqttGlobalPublishFilter.SUBSCRIBED.ordinal()]);
        } else {
            a(mqttStatefulPublishWithFlows, this.f18205b[MqttGlobalPublishFilter.UNSOLICITED.ordinal()]);
        }
        a(mqttStatefulPublishWithFlows, this.f18205b[MqttGlobalPublishFilter.ALL.ordinal()]);
        if (mqttStatefulPublishWithFlows.f()) {
            a(mqttStatefulPublishWithFlows, this.f18205b[MqttGlobalPublishFilter.REMAINING.ordinal()]);
        }
    }

    public Map<Integer, List<MqttSubscription>> f() {
        return this.f18204a.e();
    }

    public void g(MqttSubscribe mqttSubscribe, int i8, ImmutableList<Mqtt5SubAckReasonCode> immutableList) {
        boolean z7;
        boolean z8;
        ImmutableList<MqttSubscription> g8 = mqttSubscribe.g();
        if (g8.size() > immutableList.size()) {
            z7 = true;
        } else {
            z7 = false;
        }
        for (int i9 = 0; i9 < g8.size(); i9++) {
            MqttSubscribedPublishFlows mqttSubscribedPublishFlows = this.f18204a;
            MqttTopicFilterImpl g9 = g8.get(i9).g();
            if (!z7 && !immutableList.get(i9).a()) {
                z8 = false;
            } else {
                z8 = true;
            }
            mqttSubscribedPublishFlows.c(g9, i8, z8);
        }
    }

    public void h(MqttSubscribe mqttSubscribe, int i8, MqttSubscribedPublishFlow mqttSubscribedPublishFlow) {
        ImmutableList<MqttSubscription> g8 = mqttSubscribe.g();
        for (int i9 = 0; i9 < g8.size(); i9++) {
            this.f18204a.b(g8.get(i9), i8, mqttSubscribedPublishFlow);
        }
    }

    public void i(MqttUnsubscribe mqttUnsubscribe, ImmutableList<Mqtt5UnsubAckReasonCode> immutableList) {
        boolean z7;
        ImmutableList<MqttTopicFilterImpl> g8 = mqttUnsubscribe.g();
        if (immutableList == Mqtt3UnsubAckView.f18620a) {
            z7 = true;
        } else {
            z7 = false;
        }
        for (int i8 = 0; i8 < g8.size(); i8++) {
            if (z7 || !immutableList.get(i8).a()) {
                this.f18204a.f(g8.get(i8));
            }
        }
    }
}
