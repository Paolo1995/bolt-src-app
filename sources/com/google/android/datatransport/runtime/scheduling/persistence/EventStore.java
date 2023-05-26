package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

/* loaded from: classes.dex */
public interface EventStore extends Closeable {
    void A(TransportContext transportContext, long j8);

    Iterable<TransportContext> D();

    PersistedEvent X0(TransportContext transportContext, EventInternal eventInternal);

    long g0(TransportContext transportContext);

    boolean h0(TransportContext transportContext);

    void i0(Iterable<PersistedEvent> iterable);

    int o();

    void p(Iterable<PersistedEvent> iterable);

    Iterable<PersistedEvent> t0(TransportContext transportContext);
}
