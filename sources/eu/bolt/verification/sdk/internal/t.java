package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class t implements s {

    /* renamed from: a  reason: collision with root package name */
    private final r f45065a;

    /* renamed from: b  reason: collision with root package name */
    private final v f45066b;

    /* renamed from: c  reason: collision with root package name */
    private final VerificationAnalyticsManager f45067c;

    @Inject
    public t(r analyticsEventMapper, v analyticsScreenMapper, VerificationAnalyticsManager verificationAnalyticsManager) {
        Intrinsics.f(analyticsEventMapper, "analyticsEventMapper");
        Intrinsics.f(analyticsScreenMapper, "analyticsScreenMapper");
        Intrinsics.f(verificationAnalyticsManager, "verificationAnalyticsManager");
        this.f45065a = analyticsEventMapper;
        this.f45066b = analyticsScreenMapper;
        this.f45067c = verificationAnalyticsManager;
    }

    @Override // eu.bolt.verification.sdk.internal.s
    public void a(q analyticsEvent) {
        Intrinsics.f(analyticsEvent, "analyticsEvent");
        this.f45067c.a(this.f45065a.a(analyticsEvent));
    }

    @Override // eu.bolt.verification.sdk.internal.s
    public void b(u analyticsScreen) {
        Intrinsics.f(analyticsScreen, "analyticsScreen");
        this.f45067c.b(this.f45066b.a(analyticsScreen));
    }
}
