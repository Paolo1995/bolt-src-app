package com.hivemq.client.internal.mqtt.message.connect.mqtt3;

import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.auth.mqtt3.Mqtt3SimpleAuthView;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnectRestrictions;
import com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectViewBuilder;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3Connect;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase;
import j$.util.function.Function;

/* loaded from: classes3.dex */
public abstract class Mqtt3ConnectViewBuilder<B extends Mqtt3ConnectViewBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private int f18532a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18533b;

    /* renamed from: c  reason: collision with root package name */
    private MqttConnectRestrictions f18534c;

    /* renamed from: d  reason: collision with root package name */
    private MqttSimpleAuth f18535d;

    /* loaded from: classes3.dex */
    public static class Default extends Mqtt3ConnectViewBuilder<Default> implements Mqtt3ConnectBuilder {
        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase, com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3ConnectBuilder a(Mqtt3SimpleAuth mqtt3SimpleAuth) {
            return (Mqtt3ConnectBuilderBase) super.i(mqtt3SimpleAuth);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder
        public /* bridge */ /* synthetic */ Mqtt3Connect build() {
            return super.e();
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase, com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3ConnectBuilder c(int i8) {
            return (Mqtt3ConnectBuilderBase) super.g(i8);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase, com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3ConnectBuilder d(boolean z7) {
            return (Mqtt3ConnectBuilderBase) super.f(z7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectViewBuilder
        /* renamed from: j */
        public Default h() {
            return this;
        }
    }

    Mqtt3ConnectViewBuilder() {
        this.f18532a = 60;
        this.f18533b = true;
        this.f18534c = MqttConnectRestrictions.f18498i;
    }

    public Mqtt3ConnectView e() {
        return Mqtt3ConnectView.h(this.f18532a, this.f18533b, this.f18534c, this.f18535d, null);
    }

    public B f(boolean z7) {
        this.f18533b = z7;
        return h();
    }

    public B g(int i8) {
        this.f18532a = Checks.n(i8, "Keep alive");
        return h();
    }

    abstract B h();

    public B i(Mqtt3SimpleAuth mqtt3SimpleAuth) {
        MqttSimpleAuth b8;
        if (mqtt3SimpleAuth == null) {
            b8 = null;
        } else {
            b8 = ((Mqtt3SimpleAuthView) Checks.g(mqtt3SimpleAuth, Mqtt3SimpleAuthView.class, "Simple auth")).b();
        }
        this.f18535d = b8;
        return h();
    }

    /* loaded from: classes3.dex */
    public static class Nested<P> extends Mqtt3ConnectViewBuilder<Nested<P>> implements Mqtt3ConnectBuilder.Nested<P> {

        /* renamed from: e  reason: collision with root package name */
        private final Function<? super Mqtt3ConnectView, P> f18536e;

        public Nested(Function<? super Mqtt3ConnectView, P> function) {
            this.f18536e = function;
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3ConnectBuilderBase a(Mqtt3SimpleAuth mqtt3SimpleAuth) {
            return (Mqtt3ConnectBuilderBase) super.i(mqtt3SimpleAuth);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder.Nested
        public P b() {
            return this.f18536e.apply(e());
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3ConnectBuilderBase c(int i8) {
            return (Mqtt3ConnectBuilderBase) super.g(i8);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3ConnectBuilderBase d(boolean z7) {
            return (Mqtt3ConnectBuilderBase) super.f(z7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectViewBuilder
        /* renamed from: j */
        public Nested<P> h() {
            return this;
        }

        public Nested(Mqtt3ConnectView mqtt3ConnectView, Function<? super Mqtt3ConnectView, P> function) {
            super(mqtt3ConnectView);
            this.f18536e = function;
        }
    }

    Mqtt3ConnectViewBuilder(Mqtt3ConnectView mqtt3ConnectView) {
        this.f18532a = 60;
        this.f18533b = true;
        this.f18534c = MqttConnectRestrictions.f18498i;
        MqttConnect b8 = mqtt3ConnectView.b();
        this.f18532a = b8.g();
        this.f18533b = b8.m();
        this.f18534c = b8.k();
        this.f18535d = b8.i();
        b8.j();
    }
}
