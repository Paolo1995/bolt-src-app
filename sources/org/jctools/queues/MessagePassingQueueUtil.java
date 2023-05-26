package org.jctools.queues;

import org.jctools.queues.MessagePassingQueue;

/* loaded from: classes5.dex */
public final class MessagePassingQueueUtil {
    private MessagePassingQueueUtil() {
    }

    public static <E> int drain(MessagePassingQueue<? extends E> messagePassingQueue, MessagePassingQueue.Consumer<? super E> consumer, int i8) {
        int i9 = 0;
        while (i9 < i8) {
            Object obj = (E) messagePassingQueue.relaxedPoll();
            if (obj == null) {
                break;
            }
            consumer.accept(obj);
            i9++;
        }
        return i9;
    }

    public static <E> int drain(MessagePassingQueue<? extends E> messagePassingQueue, MessagePassingQueue.Consumer<? super E> consumer) {
        int i8 = 0;
        while (true) {
            Object obj = (E) messagePassingQueue.relaxedPoll();
            if (obj == null) {
                return i8;
            }
            i8++;
            consumer.accept(obj);
        }
    }

    public static <E> void drain(MessagePassingQueue<? extends E> messagePassingQueue, MessagePassingQueue.Consumer<? super E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        Object obj;
        while (true) {
            while (exitCondition.keepRunning()) {
                obj = (E) messagePassingQueue.relaxedPoll();
                int idle = obj == null ? waitStrategy.idle(idle) : 0;
            }
            return;
            consumer.accept(obj);
        }
    }
}
