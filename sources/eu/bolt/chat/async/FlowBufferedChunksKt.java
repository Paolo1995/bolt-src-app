package eu.bolt.chat.async;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FlowBufferedChunks.kt */
/* loaded from: classes5.dex */
public final class FlowBufferedChunksKt {
    public static final <T> Flow<List<T>> a(Flow<? extends T> flow, long j8) {
        Intrinsics.f(flow, "<this>");
        return new TimedChunkFlow(flow, j8).d();
    }
}
