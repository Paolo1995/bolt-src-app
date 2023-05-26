package kotlinx.coroutines.channels;

import kotlinx.coroutines.CoroutineScope;

/* compiled from: Produce.kt */
/* loaded from: classes5.dex */
public interface ProducerScope<E> extends CoroutineScope, SendChannel<E> {
    SendChannel<E> getChannel();
}
