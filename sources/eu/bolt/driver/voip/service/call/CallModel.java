package eu.bolt.driver.voip.service.call;

import ee.mtakso.voip_client.VoipCall;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallModel.kt */
/* loaded from: classes5.dex */
public final class CallModel {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41633b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final VoipCall f41634a;

    /* compiled from: CallModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CallModel(VoipCall impl) {
        Intrinsics.f(impl, "impl");
        this.f41634a = impl;
    }

    public final String a(String key) {
        Intrinsics.f(key, "key");
        return this.f41634a.g().a().get(key);
    }
}
