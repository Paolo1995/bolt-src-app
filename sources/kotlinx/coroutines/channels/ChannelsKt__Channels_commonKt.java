package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ExceptionsKt;

/* compiled from: Channels.common.kt */
/* loaded from: classes5.dex */
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final void a(ReceiveChannel<?> receiveChannel, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.a("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.e(cancellationException);
    }
}
