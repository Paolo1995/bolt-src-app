package ee.mtakso.driver.utils.urlcomand;

import eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPortalUrlRoutingCommand.kt */
/* loaded from: classes5.dex */
public final class DriverPortalUrlRoutingCommand implements BackpressureRoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final String f36476a;

    /* renamed from: b  reason: collision with root package name */
    private final RoutingState f36477b;

    public DriverPortalUrlRoutingCommand(String url, RoutingState routingState) {
        Intrinsics.f(url, "url");
        this.f36476a = url;
        this.f36477b = routingState;
    }

    @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
    public RoutingState a() {
        return this.f36477b;
    }

    public final String c() {
        return this.f36476a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverPortalUrlRoutingCommand) {
            DriverPortalUrlRoutingCommand driverPortalUrlRoutingCommand = (DriverPortalUrlRoutingCommand) obj;
            return Intrinsics.a(this.f36476a, driverPortalUrlRoutingCommand.f36476a) && Intrinsics.a(a(), driverPortalUrlRoutingCommand.a());
        }
        return false;
    }

    public int hashCode() {
        return (this.f36476a.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
    }

    public String toString() {
        String str = this.f36476a;
        RoutingState a8 = a();
        return "DriverPortalUrlRoutingCommand(url=" + str + ", expectedState=" + a8 + ")";
    }

    public /* synthetic */ DriverPortalUrlRoutingCommand(String str, RoutingState routingState, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? null : routingState);
    }
}
