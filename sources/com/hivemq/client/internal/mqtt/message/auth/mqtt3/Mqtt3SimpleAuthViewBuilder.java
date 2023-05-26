package com.hivemq.client.internal.mqtt.message.auth.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.auth.mqtt3.Mqtt3SimpleAuthViewBuilder;
import com.hivemq.client.internal.mqtt.util.MqttChecks;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilder;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilderBase;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class Mqtt3SimpleAuthViewBuilder<B extends Mqtt3SimpleAuthViewBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private MqttUtf8StringImpl f18489a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f18490b;

    /* loaded from: classes3.dex */
    public static class Default extends Mqtt3SimpleAuthViewBuilder<Default> implements Mqtt3SimpleAuthBuilder.Complete {
        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilderBase$Complete, com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilder$Complete] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3SimpleAuthBuilder.Complete a(String str) {
            return (Mqtt3SimpleAuthBuilderBase.Complete) super.f(str);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilderBase$Complete, com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilder$Complete] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilderBase.Complete
        public /* bridge */ /* synthetic */ Mqtt3SimpleAuthBuilder.Complete b(byte[] bArr) {
            return (Mqtt3SimpleAuthBuilderBase.Complete) super.d(bArr);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuthBuilder.Complete
        public /* bridge */ /* synthetic */ Mqtt3SimpleAuth build() {
            return super.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.message.auth.mqtt3.Mqtt3SimpleAuthViewBuilder
        /* renamed from: g */
        public Default e() {
            return this;
        }
    }

    public Mqtt3SimpleAuthView c() {
        boolean z7;
        if (this.f18489a != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Checks.k(z7, "Username must be given.");
        return Mqtt3SimpleAuthView.c(this.f18489a, this.f18490b);
    }

    public B d(byte[] bArr) {
        this.f18490b = MqttChecks.a(bArr, "Password");
        return e();
    }

    abstract B e();

    public B f(String str) {
        this.f18489a = MqttUtf8StringImpl.l(str, "Username");
        return e();
    }
}
