package eu.bolt.android.audio_recording_engine.db;

import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderRecordingsData.kt */
/* loaded from: classes5.dex */
public final class OrderRecordingsData {

    /* renamed from: a  reason: collision with root package name */
    private final String f36601a;

    /* renamed from: b  reason: collision with root package name */
    private final long f36602b;

    /* renamed from: c  reason: collision with root package name */
    private final long f36603c;

    public OrderRecordingsData(String orderKey, long j8, long j9) {
        Intrinsics.f(orderKey, "orderKey");
        this.f36601a = orderKey;
        this.f36602b = j8;
        this.f36603c = j9;
    }

    public final long a() {
        return this.f36602b;
    }

    public final long b() {
        return this.f36603c;
    }

    public final String c() {
        return this.f36601a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderRecordingsData) {
            OrderRecordingsData orderRecordingsData = (OrderRecordingsData) obj;
            return Intrinsics.a(this.f36601a, orderRecordingsData.f36601a) && this.f36602b == orderRecordingsData.f36602b && this.f36603c == orderRecordingsData.f36603c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f36601a.hashCode() * 31) + a.a(this.f36602b)) * 31) + a.a(this.f36603c);
    }

    public String toString() {
        return "OrderRecordingsData(orderKey=" + this.f36601a + ", createdTimeStamp=" + this.f36602b + ", fileSize=" + this.f36603c + ')';
    }
}
