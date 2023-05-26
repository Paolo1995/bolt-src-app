package org.jctools.queues;

import java.util.AbstractQueue;
import org.jctools.queues.IndexedQueueSizeUtil;

/* compiled from: BaseSpscLinkedArrayQueue.java */
/* loaded from: classes5.dex */
abstract class BaseSpscLinkedArrayQueuePrePad<E> extends AbstractQueue<E> implements IndexedQueueSizeUtil.IndexedQueue {

    /* renamed from: p0  reason: collision with root package name */
    long f52723p0;

    /* renamed from: p1  reason: collision with root package name */
    long f52724p1;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;

    /* renamed from: p2  reason: collision with root package name */
    long f52725p2;

    /* renamed from: p3  reason: collision with root package name */
    long f52726p3;

    /* renamed from: p4  reason: collision with root package name */
    long f52727p4;

    /* renamed from: p5  reason: collision with root package name */
    long f52728p5;

    /* renamed from: p6  reason: collision with root package name */
    long f52729p6;

    /* renamed from: p7  reason: collision with root package name */
    long f52730p7;

    public abstract /* synthetic */ long lvConsumerIndex();

    public abstract /* synthetic */ long lvProducerIndex();
}
