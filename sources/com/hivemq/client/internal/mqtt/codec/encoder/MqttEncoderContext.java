package com.hivemq.client.internal.mqtt.codec.encoder;

import io.netty.buffer.ByteBufAllocator;

/* loaded from: classes3.dex */
public class MqttEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBufAllocator f17916a;

    /* renamed from: b  reason: collision with root package name */
    private int f17917b = 268435460;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttEncoderContext(ByteBufAllocator byteBufAllocator) {
        this.f17916a = byteBufAllocator;
    }

    public ByteBufAllocator a() {
        return this.f17916a;
    }

    public int b() {
        return this.f17917b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i8) {
        this.f17917b = i8;
    }
}
