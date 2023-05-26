package ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager;

import ee.mtakso.voip_client.VoipCall;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateCallWindowAppearanceDelegate.kt */
/* loaded from: classes3.dex */
public final class RateCallWindowAppearanceDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f26182a;

    public RateCallWindowAppearanceDelegate() {
        Set<String> synchronizedSet = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.e(synchronizedSet, "synchronizedSet(mutableSetOf<String>())");
        this.f26182a = synchronizedSet;
    }

    public final void a(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26182a.add(call.getId());
    }

    public final void b(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26182a.remove(call.getId());
    }

    public final boolean c(VoipCall call) {
        Intrinsics.f(call, "call");
        return this.f26182a.contains(call.getId());
    }
}
