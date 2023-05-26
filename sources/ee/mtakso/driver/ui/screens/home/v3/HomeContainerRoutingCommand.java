package ee.mtakso.driver.ui.screens.home.v3;

import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeContainerRoutingCommand.kt */
/* loaded from: classes3.dex */
public final class HomeContainerRoutingCommand implements RoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final RoutingCommand.FragmentClass f29748a;

    public HomeContainerRoutingCommand(RoutingCommand.FragmentClass fragmentCommand) {
        Intrinsics.f(fragmentCommand, "fragmentCommand");
        this.f29748a = fragmentCommand;
    }

    @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
    public RoutingState a() {
        return RoutingCommand.DefaultImpls.a(this);
    }

    @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
    public RoutingState b() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final RoutingCommand.FragmentClass c() {
        return this.f29748a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HomeContainerRoutingCommand) && Intrinsics.a(this.f29748a, ((HomeContainerRoutingCommand) obj).f29748a);
    }

    public int hashCode() {
        return this.f29748a.hashCode();
    }

    public String toString() {
        RoutingCommand.FragmentClass fragmentClass = this.f29748a;
        return "HomeContainerRoutingCommand(fragmentCommand=" + fragmentClass + ")";
    }
}
