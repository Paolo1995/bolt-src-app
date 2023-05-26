package eu.bolt.chat.network.engine;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PublishingEvent.kt */
/* loaded from: classes5.dex */
public final class IdentifiablePublishingEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f39411a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishingEvent f39412b;

    public IdentifiablePublishingEvent(int i8, PublishingEvent event) {
        Intrinsics.f(event, "event");
        this.f39411a = i8;
        this.f39412b = event;
    }

    public final PublishingEvent a() {
        return this.f39412b;
    }

    public final int b() {
        return this.f39411a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IdentifiablePublishingEvent) {
            IdentifiablePublishingEvent identifiablePublishingEvent = (IdentifiablePublishingEvent) obj;
            return this.f39411a == identifiablePublishingEvent.f39411a && Intrinsics.a(this.f39412b, identifiablePublishingEvent.f39412b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f39411a * 31) + this.f39412b.hashCode();
    }

    public String toString() {
        return "IdentifiablePublishingEvent(publishingId=" + this.f39411a + ", event=" + this.f39412b + ')';
    }
}
