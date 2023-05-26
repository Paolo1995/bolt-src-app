package io.netty.util.internal.shaded.org.jctools.queues;

import com.google.android.gms.common.api.Api;

/* loaded from: classes5.dex */
public final class IndexedQueueSizeUtil {

    /* loaded from: classes5.dex */
    public interface IndexedQueue {
        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        if (indexedQueue.lvConsumerIndex() == indexedQueue.lvProducerIndex()) {
            return true;
        }
        return false;
    }

    public static int size(IndexedQueue indexedQueue) {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = indexedQueue.lvConsumerIndex();
        while (true) {
            lvProducerIndex = indexedQueue.lvProducerIndex();
            lvConsumerIndex = indexedQueue.lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j8 = lvProducerIndex - lvConsumerIndex;
        if (j8 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return (int) j8;
    }
}
