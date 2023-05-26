package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* loaded from: classes.dex */
public abstract class PersistedEvent {
    public static PersistedEvent a(long j8, TransportContext transportContext, EventInternal eventInternal) {
        return new AutoValue_PersistedEvent(j8, transportContext, eventInternal);
    }

    public abstract EventInternal b();

    public abstract long c();

    public abstract TransportContext d();
}
