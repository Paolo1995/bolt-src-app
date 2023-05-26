package eu.bolt.android.rib.flipper;

import kotlin.Unit;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FlipperRibEventBus.kt */
/* loaded from: classes5.dex */
public final class FlipperRibEventBus {

    /* renamed from: a  reason: collision with root package name */
    public static final FlipperRibEventBus f37128a = new FlipperRibEventBus();

    /* renamed from: b  reason: collision with root package name */
    private static final MutableSharedFlow<Unit> f37129b = SharedFlowKt.b(1, 0, BufferOverflow.DROP_OLDEST, 2, null);

    /* renamed from: c  reason: collision with root package name */
    private static final MutableStateFlow<Object> f37130c = StateFlowKt.a(null);

    /* renamed from: d  reason: collision with root package name */
    private static boolean f37131d;

    private FlipperRibEventBus() {
    }

    public final void a() {
        if (f37131d) {
            f37129b.d(Unit.f50853a);
        }
    }
}
