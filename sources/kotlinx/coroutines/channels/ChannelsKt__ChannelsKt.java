package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Channels.kt */
/* loaded from: classes5.dex */
final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object a(SendChannel<? super E> sendChannel, E e8) {
        Object b8;
        Object u7 = sendChannel.u(e8);
        if (u7 instanceof ChannelResult.Failed) {
            b8 = BuildersKt__BuildersKt.b(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, e8, null), 1, null);
            return ((ChannelResult) b8).l();
        }
        Unit unit = (Unit) u7;
        return ChannelResult.f51406b.c(Unit.f50853a);
    }
}
