package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_PersistedEvent extends PersistedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f12296a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f12297b;

    /* renamed from: c  reason: collision with root package name */
    private final EventInternal f12298c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_PersistedEvent(long j8, TransportContext transportContext, EventInternal eventInternal) {
        this.f12296a = j8;
        if (transportContext != null) {
            this.f12297b = transportContext;
            if (eventInternal != null) {
                this.f12298c = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public EventInternal b() {
        return this.f12298c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public long c() {
        return this.f12296a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public TransportContext d() {
        return this.f12297b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.f12296a == persistedEvent.c() && this.f12297b.equals(persistedEvent.d()) && this.f12298c.equals(persistedEvent.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f12296a;
        return this.f12298c.hashCode() ^ ((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f12297b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f12296a + ", transportContext=" + this.f12297b + ", event=" + this.f12298c + "}";
    }
}
