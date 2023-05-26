package com.hivemq.client.internal.mqtt.codec.decoder;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicImpl;

/* loaded from: classes3.dex */
public class MqttDecoderContext {

    /* renamed from: a  reason: collision with root package name */
    private final int f17860a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttTopicImpl[] f17861b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17862c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17863d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17864e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17865f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f17866g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17867h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttDecoderContext(int i8, int i9, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        MqttTopicImpl[] mqttTopicImplArr;
        this.f17860a = i8;
        if (i9 == 0) {
            mqttTopicImplArr = null;
        } else {
            mqttTopicImplArr = new MqttTopicImpl[i9];
        }
        this.f17861b = mqttTopicImplArr;
        this.f17862c = z7;
        this.f17863d = z8;
        this.f17864e = z9;
        this.f17865f = z10;
        this.f17866g = z11;
        this.f17867h = z12;
    }

    public int a() {
        return this.f17860a;
    }

    public MqttTopicImpl[] b() {
        return this.f17861b;
    }

    public boolean c() {
        return this.f17862c;
    }

    public boolean d() {
        return this.f17863d;
    }

    public boolean e() {
        return this.f17866g;
    }

    public boolean f() {
        return this.f17867h;
    }

    public boolean g() {
        return this.f17865f;
    }

    public boolean h() {
        return this.f17864e;
    }
}
