package ee.mtakso.driver.ui.screens.history.details.banner;

/* compiled from: RecordingDuration.kt */
/* loaded from: classes3.dex */
public final class RecordingDuration {

    /* renamed from: a  reason: collision with root package name */
    private final int f29531a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29532b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29533c;

    public RecordingDuration(int i8, int i9, int i10) {
        this.f29531a = i8;
        this.f29532b = i9;
        this.f29533c = i10;
    }

    public final int a() {
        return this.f29531a;
    }

    public final int b() {
        return this.f29532b;
    }

    public final int c() {
        return this.f29533c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecordingDuration) {
            RecordingDuration recordingDuration = (RecordingDuration) obj;
            return this.f29531a == recordingDuration.f29531a && this.f29532b == recordingDuration.f29532b && this.f29533c == recordingDuration.f29533c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f29531a * 31) + this.f29532b) * 31) + this.f29533c;
    }

    public String toString() {
        int i8 = this.f29531a;
        int i9 = this.f29532b;
        int i10 = this.f29533c;
        return "RecordingDuration(hours=" + i8 + ", min=" + i9 + ", sec=" + i10 + ")";
    }
}
