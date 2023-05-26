package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeeplinkRoutingCommand.kt */
/* loaded from: classes3.dex */
public final class DeeplinkRoutingCommand implements RoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final DeeplinkCall f29962a;

    public DeeplinkRoutingCommand(DeeplinkCall deeplinkCall) {
        Intrinsics.f(deeplinkCall, "deeplinkCall");
        this.f29962a = deeplinkCall;
    }

    @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
    public RoutingState a() {
        return RoutingCommand.DefaultImpls.a(this);
    }

    @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
    public RoutingState b() {
        return new RoutingState(SimpleActivity.class, null, 2, null);
    }

    public final DeeplinkCall c() {
        return this.f29962a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeeplinkRoutingCommand) && Intrinsics.a(this.f29962a, ((DeeplinkRoutingCommand) obj).f29962a);
    }

    public int hashCode() {
        return this.f29962a.hashCode();
    }

    public String toString() {
        DeeplinkCall deeplinkCall = this.f29962a;
        return "DeeplinkRoutingCommand(deeplinkCall=" + deeplinkCall + ")";
    }
}
