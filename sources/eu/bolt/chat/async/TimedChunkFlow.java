package eu.bolt.chat.async;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: FlowBufferedChunks.kt */
/* loaded from: classes5.dex */
final class TimedChunkFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Mutex f37857a;

    /* renamed from: b  reason: collision with root package name */
    private List<T> f37858b;

    /* renamed from: c  reason: collision with root package name */
    private final Flow<List<T>> f37859c;

    public TimedChunkFlow(Flow<? extends T> sourceFlow, long j8) {
        Intrinsics.f(sourceFlow, "sourceFlow");
        this.f37857a = MutexKt.a(false);
        this.f37858b = new ArrayList();
        this.f37859c = FlowKt.F(FlowKt.H(FlowKt.y(new TimedChunkFlow$resultFlow$1(sourceFlow, this, null)), j8), new TimedChunkFlow$resultFlow$2(this, null));
    }

    public final Flow<List<T>> d() {
        return this.f37859c;
    }
}
