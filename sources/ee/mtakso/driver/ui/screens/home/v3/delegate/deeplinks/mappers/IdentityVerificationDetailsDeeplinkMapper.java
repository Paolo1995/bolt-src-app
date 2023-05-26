package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.identity.verification.IdentityVerificationRoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityVerificationDetailsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class IdentityVerificationDetailsDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.IdentityVerification deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return new IdentityVerificationRoutingCommand(deeplink.b());
    }
}
