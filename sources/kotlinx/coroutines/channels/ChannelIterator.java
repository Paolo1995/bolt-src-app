package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* loaded from: classes5.dex */
public interface ChannelIterator<E> {
    Object a(Continuation<? super Boolean> continuation);

    E next();
}
