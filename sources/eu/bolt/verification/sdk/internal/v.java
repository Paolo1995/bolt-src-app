package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.analytics.events.VerificationScreen;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class v {
    public final VerificationScreen a(u analyticsScreen) {
        Intrinsics.f(analyticsScreen, "analyticsScreen");
        return new VerificationScreen(analyticsScreen.b(), analyticsScreen.a());
    }
}
