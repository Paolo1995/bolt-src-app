package eu.bolt.android.audio_recording_engine.engine;

import i0.a;

/* compiled from: RecordingProperties.kt */
/* loaded from: classes5.dex */
public final class RecordingProperties {

    /* renamed from: a  reason: collision with root package name */
    private final long f36681a;

    /* renamed from: b  reason: collision with root package name */
    private final long f36682b;

    /* renamed from: c  reason: collision with root package name */
    private final long f36683c;

    public RecordingProperties(long j8, long j9, long j10) {
        this.f36681a = j8;
        this.f36682b = j9;
        this.f36683c = j10;
    }

    public final long a() {
        return this.f36681a;
    }

    public final long b() {
        return this.f36683c;
    }

    public final long c() {
        return this.f36682b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecordingProperties) {
            RecordingProperties recordingProperties = (RecordingProperties) obj;
            return this.f36681a == recordingProperties.f36681a && this.f36682b == recordingProperties.f36682b && this.f36683c == recordingProperties.f36683c;
        }
        return false;
    }

    public int hashCode() {
        return (((a.a(this.f36681a) * 31) + a.a(this.f36682b)) * 31) + a.a(this.f36683c);
    }

    public String toString() {
        return "RecordingProperties(createdTimeStampMs=" + this.f36681a + ", sizeBytes=" + this.f36682b + ", durationMillis=" + this.f36683c + ')';
    }
}
