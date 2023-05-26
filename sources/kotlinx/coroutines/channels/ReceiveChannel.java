package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;

/* compiled from: Channel.kt */
/* loaded from: classes5.dex */
public interface ReceiveChannel<E> {
    Object A(Continuation<? super ChannelResult<? extends E>> continuation);

    void e(CancellationException cancellationException);

    ChannelIterator<E> iterator();

    SelectClause1<E> v();

    SelectClause1<ChannelResult<E>> x();

    Object z();
}
