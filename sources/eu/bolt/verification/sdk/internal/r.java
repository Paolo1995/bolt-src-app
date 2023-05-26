package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.analytics.events.VerificationEvent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r {
    public final VerificationEvent a(q analyticsEvent) {
        Intrinsics.f(analyticsEvent, "analyticsEvent");
        return new VerificationEvent(analyticsEvent.b(), analyticsEvent.a());
    }
}
