package ee.mtakso.driver.ui.screens.login.v2;

import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterFragmentRoutingCommand.kt */
/* loaded from: classes3.dex */
public final class RouterFragmentRoutingCommand implements RoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final RoutingCommand.FragmentClass f30459a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30460b;

    public RouterFragmentRoutingCommand(RoutingCommand.FragmentClass fragmentCommand, boolean z7) {
        Intrinsics.f(fragmentCommand, "fragmentCommand");
        this.f30459a = fragmentCommand;
        this.f30460b = z7;
    }

    @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
    public RoutingState a() {
        return RoutingCommand.DefaultImpls.a(this);
    }

    @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
    public RoutingState b() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final boolean c() {
        return this.f30460b;
    }

    public final RoutingCommand.FragmentClass d() {
        return this.f30459a;
    }

    public /* synthetic */ RouterFragmentRoutingCommand(RoutingCommand.FragmentClass fragmentClass, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentClass, (i8 & 2) != 0 ? true : z7);
    }
}
