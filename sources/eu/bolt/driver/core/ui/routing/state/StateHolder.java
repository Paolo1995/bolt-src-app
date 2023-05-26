package eu.bolt.driver.core.ui.routing.state;

import android.os.SystemClock;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateHolder.kt */
/* loaded from: classes5.dex */
public final class StateHolder {

    /* renamed from: a  reason: collision with root package name */
    private RoutingState f41175a;

    /* renamed from: b  reason: collision with root package name */
    private RoutingState f41176b;

    /* renamed from: c  reason: collision with root package name */
    private Long f41177c;

    public final RoutingState a() {
        return this.f41175a;
    }

    public final boolean b(RoutingState state) {
        long j8;
        Intrinsics.f(state, "state");
        if (!Intrinsics.a(state, this.f41176b) && this.f41175a != null && !Intrinsics.a(state.a().getSimpleName(), "LauncherActivity")) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.a(g8, "Unexpected state skipped. " + state + " ; " + this.f41176b, null, 2, null);
            }
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l8 = this.f41177c;
        if (l8 != null) {
            j8 = l8.longValue();
        } else {
            j8 = 0;
        }
        RoutingState routingState = this.f41175a;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) (elapsedRealtime - j8)) / 1000.0f)}, 1));
        Intrinsics.e(format, "format(this, *args)");
        Kalev.b("Switched state from " + routingState + " to " + state + " in " + format + " seconds. Expected state was: " + this.f41176b);
        this.f41177c = 0L;
        this.f41176b = null;
        this.f41175a = state;
        return true;
    }

    public final boolean c(RoutingState routingState) {
        if (Intrinsics.a(this.f41175a, routingState)) {
            return false;
        }
        this.f41176b = routingState;
        this.f41177c = Long.valueOf(SystemClock.elapsedRealtime());
        return true;
    }
}
