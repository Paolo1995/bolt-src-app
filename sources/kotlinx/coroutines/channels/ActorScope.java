package kotlinx.coroutines.channels;

import kotlinx.coroutines.CoroutineScope;

/* compiled from: Actor.kt */
/* loaded from: classes5.dex */
public interface ActorScope<E> extends CoroutineScope, ReceiveChannel<E> {
    Channel<E> getChannel();
}
