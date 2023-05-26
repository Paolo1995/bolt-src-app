package eu.bolt.driver.core.ui.routing.command.impl;

import android.app.Activity;
import android.os.Bundle;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityClassCommand.kt */
/* loaded from: classes5.dex */
public class ActivityClassCommand implements RoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Activity> f41160a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f41161b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41162c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimationResources f41163d;

    public ActivityClassCommand(Class<? extends Activity> clazz, Bundle args, int i8, AnimationResources animationResources) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(args, "args");
        this.f41160a = clazz;
        this.f41161b = args;
        this.f41162c = i8;
        this.f41163d = animationResources;
    }

    public final AnimationResources c() {
        return this.f41163d;
    }

    public final Bundle d() {
        return this.f41161b;
    }

    public final Class<? extends Activity> e() {
        return this.f41160a;
    }

    public final int f() {
        return this.f41162c;
    }

    public /* synthetic */ ActivityClassCommand(Class cls, Bundle bundle, int i8, AnimationResources animationResources, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i9 & 2) != 0 ? new Bundle() : bundle, (i9 & 4) != 0 ? 0 : i8, (i9 & 8) != 0 ? null : animationResources);
    }
}
