package ee.mtakso.driver.utils.urlcomand;

import eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlRoutingCommand.kt */
/* loaded from: classes5.dex */
public final class UrlRoutingCommand implements BackpressureRoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final String f36482a;

    /* renamed from: b  reason: collision with root package name */
    private final RoutingState f36483b;

    public UrlRoutingCommand(String url, RoutingState routingState) {
        Intrinsics.f(url, "url");
        this.f36482a = url;
        this.f36483b = routingState;
    }

    @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
    public RoutingState a() {
        return this.f36483b;
    }

    public final String c() {
        return this.f36482a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UrlRoutingCommand) {
            UrlRoutingCommand urlRoutingCommand = (UrlRoutingCommand) obj;
            return Intrinsics.a(this.f36482a, urlRoutingCommand.f36482a) && Intrinsics.a(a(), urlRoutingCommand.a());
        }
        return false;
    }

    public int hashCode() {
        return (this.f36482a.hashCode() * 31) + (a() == null ? 0 : a().hashCode());
    }

    public String toString() {
        String str = this.f36482a;
        RoutingState a8 = a();
        return "UrlRoutingCommand(url=" + str + ", expectedState=" + a8 + ")";
    }

    public /* synthetic */ UrlRoutingCommand(String str, RoutingState routingState, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? null : routingState);
    }
}
