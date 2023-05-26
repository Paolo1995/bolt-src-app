package io.netty.channel;

import java.util.Queue;

/* loaded from: classes5.dex */
public interface EventLoopTaskQueueFactory {
    Queue<Runnable> newTaskQueue(int i8);
}
