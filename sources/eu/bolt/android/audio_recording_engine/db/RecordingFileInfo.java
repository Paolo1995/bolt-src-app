package eu.bolt.android.audio_recording_engine.db;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordingFileInfo.kt */
/* loaded from: classes5.dex */
public final class RecordingFileInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f36628a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36629b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f36630c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f36631d;

    public RecordingFileInfo(int i8, String parentOrderKey, boolean z7, Long l8) {
        Intrinsics.f(parentOrderKey, "parentOrderKey");
        this.f36628a = i8;
        this.f36629b = parentOrderKey;
        this.f36630c = z7;
        this.f36631d = l8;
    }

    public final Long a() {
        return this.f36631d;
    }

    public final int b() {
        return this.f36628a;
    }

    public final String c() {
        return this.f36629b;
    }

    public final boolean d() {
        return this.f36630c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecordingFileInfo) {
            RecordingFileInfo recordingFileInfo = (RecordingFileInfo) obj;
            return this.f36628a == recordingFileInfo.f36628a && Intrinsics.a(this.f36629b, recordingFileInfo.f36629b) && this.f36630c == recordingFileInfo.f36630c && Intrinsics.a(this.f36631d, recordingFileInfo.f36631d);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f36628a * 31) + this.f36629b.hashCode()) * 31;
        boolean z7 = this.f36630c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        Long l8 = this.f36631d;
        return i9 + (l8 == null ? 0 : l8.hashCode());
    }

    public String toString() {
        return "RecordingFileInfo(fileIndex=" + this.f36628a + ", parentOrderKey=" + this.f36629b + ", isUploaded=" + this.f36630c + ", durationMilliSecs=" + this.f36631d + ')';
    }
}
