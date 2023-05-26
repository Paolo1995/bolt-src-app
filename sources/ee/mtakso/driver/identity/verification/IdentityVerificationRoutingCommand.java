package ee.mtakso.driver.identity.verification;

import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityVerificationRoutingCommand.kt */
/* loaded from: classes3.dex */
public final class IdentityVerificationRoutingCommand implements RoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final String f20984a;

    public IdentityVerificationRoutingCommand(String flowRunId) {
        Intrinsics.f(flowRunId, "flowRunId");
        this.f20984a = flowRunId;
    }

    public final String c() {
        return this.f20984a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IdentityVerificationRoutingCommand) && Intrinsics.a(this.f20984a, ((IdentityVerificationRoutingCommand) obj).f20984a);
    }

    public int hashCode() {
        return this.f20984a.hashCode();
    }

    public String toString() {
        String str = this.f20984a;
        return "IdentityVerificationRoutingCommand(flowRunId=" + str + ")";
    }
}
