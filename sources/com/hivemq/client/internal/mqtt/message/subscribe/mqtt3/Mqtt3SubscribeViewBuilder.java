package com.hivemq.client.internal.mqtt.message.subscribe.mqtt3;

import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscribeViewBuilder;
import com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscriptionViewBuilder;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscribe;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Publishes$Args;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Publishes$Start;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Start;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscriptionBuilderBase;

/* loaded from: classes3.dex */
public abstract class Mqtt3SubscribeViewBuilder<B extends Mqtt3SubscribeViewBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList.Builder<MqttSubscription> f18609a = b.v();

    /* renamed from: b  reason: collision with root package name */
    private Mqtt3SubscriptionViewBuilder.Default f18610b;

    /* loaded from: classes3.dex */
    public static class Default extends Mqtt3SubscribeViewBuilder<Default> implements Mqtt3SubscribeBuilder$Start.Complete {
        @Override // com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscriptionBuilderBase.Complete
        public /* bridge */ /* synthetic */ Mqtt3SubscriptionBuilderBase.Complete a(MqttQos mqttQos) {
            return (Mqtt3SubscriptionBuilderBase.Complete) super.h(mqttQos);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscriptionBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3SubscriptionBuilderBase.Complete b(String str) {
            return (Mqtt3SubscriptionBuilderBase.Complete) super.j(str);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Complete
        public /* bridge */ /* synthetic */ Mqtt3Subscribe build() {
            return super.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscribeViewBuilder
        /* renamed from: k */
        public Default i() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Publishes<P> extends Mqtt3SubscribeViewBuilder<Publishes<P>> implements Mqtt3SubscribeBuilder$Publishes$Start.Complete<P>, Mqtt3SubscribeBuilder$Publishes$Args<P> {

        /* renamed from: c  reason: collision with root package name */
        protected boolean f18611c;

        @Override // com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscriptionBuilderBase.Complete
        public /* bridge */ /* synthetic */ Mqtt3SubscriptionBuilderBase.Complete a(MqttQos mqttQos) {
            return (Mqtt3SubscriptionBuilderBase.Complete) super.h(mqttQos);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscriptionBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3SubscriptionBuilderBase.Complete b(String str) {
            return (Mqtt3SubscriptionBuilderBase.Complete) super.j(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscribeViewBuilder
        /* renamed from: k */
        public Publishes<P> i() {
            return this;
        }
    }

    protected Mqtt3SubscribeViewBuilder() {
    }

    private void e() {
        Mqtt3SubscriptionViewBuilder.Default r02 = this.f18610b;
        if (r02 != null) {
            this.f18609a.a(r02.c().b());
            this.f18610b = null;
        }
    }

    private void f() {
        boolean z7;
        if (this.f18609a.e() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Checks.k(z7, "At least one subscription must be added.");
    }

    private Mqtt3SubscriptionViewBuilder.Default g() {
        if (this.f18610b == null) {
            this.f18610b = new Mqtt3SubscriptionViewBuilder.Default();
        }
        return this.f18610b;
    }

    public Mqtt3SubscribeView d() {
        e();
        f();
        return Mqtt3SubscribeView.d(this.f18609a.b());
    }

    public B h(MqttQos mqttQos) {
        g().d(mqttQos);
        return i();
    }

    protected abstract B i();

    public B j(String str) {
        g().f(str);
        return i();
    }
}
