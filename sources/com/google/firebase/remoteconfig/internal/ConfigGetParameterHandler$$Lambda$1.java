package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.common.util.BiConsumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class ConfigGetParameterHandler$$Lambda$1 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final BiConsumer f17114f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17115g;

    /* renamed from: h  reason: collision with root package name */
    private final ConfigContainer f17116h;

    private ConfigGetParameterHandler$$Lambda$1(BiConsumer biConsumer, String str, ConfigContainer configContainer) {
        this.f17114f = biConsumer;
        this.f17115g = str;
        this.f17116h = configContainer;
    }

    public static Runnable a(BiConsumer biConsumer, String str, ConfigContainer configContainer) {
        return new ConfigGetParameterHandler$$Lambda$1(biConsumer, str, configContainer);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17114f.accept(this.f17115g, this.f17116h);
    }
}
