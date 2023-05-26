package kotlinx.coroutines.channels;

/* loaded from: classes5.dex */
public final class ChannelsKt {
    public static final void a(ReceiveChannel<?> receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    public static final <E> Object b(SendChannel<? super E> sendChannel, E e8) {
        return ChannelsKt__ChannelsKt.a(sendChannel, e8);
    }
}
