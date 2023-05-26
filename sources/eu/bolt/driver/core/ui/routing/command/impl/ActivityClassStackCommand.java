package eu.bolt.driver.core.ui.routing.command.impl;

import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityClassStackCommand.kt */
/* loaded from: classes5.dex */
public final class ActivityClassStackCommand implements RoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final List<ActivityClassCommand> f41164a;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityClassStackCommand(List<? extends ActivityClassCommand> stack) {
        Intrinsics.f(stack, "stack");
        this.f41164a = stack;
    }

    public final List<ActivityClassCommand> c() {
        return this.f41164a;
    }

    public String toString() {
        String f02;
        f02 = CollectionsKt___CollectionsKt.f0(this.f41164a, "\n", null, null, 0, null, null, 62, null);
        return "ActivitiesListClass(stack=" + f02 + ")";
    }
}
