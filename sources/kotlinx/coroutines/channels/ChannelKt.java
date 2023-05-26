package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Channel.kt */
/* loaded from: classes5.dex */
public final class ChannelKt {
    public static final <E> Channel<E> a(int i8, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        int i9 = 1;
        if (i8 != -2) {
            if (i8 != -1) {
                if (i8 != 0) {
                    if (i8 != Integer.MAX_VALUE) {
                        if (i8 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                            return new ConflatedChannel(function1);
                        }
                        return new ArrayChannel(i8, bufferOverflow, function1);
                    }
                    return new LinkedListChannel(function1);
                } else if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new RendezvousChannel(function1);
                } else {
                    return new ArrayChannel(1, bufferOverflow, function1);
                }
            }
            if (bufferOverflow != BufferOverflow.SUSPEND) {
                i9 = 0;
            }
            if (i9 != 0) {
                return new ConflatedChannel(function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            i9 = Channel.f51402e.a();
        }
        return new ArrayChannel(i9, bufferOverflow, function1);
    }

    public static /* synthetic */ Channel b(int i8, BufferOverflow bufferOverflow, Function1 function1, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 0;
        }
        if ((i9 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i9 & 4) != 0) {
            function1 = null;
        }
        return a(i8, bufferOverflow, function1);
    }
}
