package eu.bolt.android.audio_recording_engine.engine;

/* compiled from: UploadParams.kt */
/* loaded from: classes5.dex */
public final class UploadParams {

    /* renamed from: a  reason: collision with root package name */
    private final int f36685a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36686b;

    public UploadParams(int i8, int i9) {
        this.f36685a = i8;
        this.f36686b = i9;
    }

    public final int a() {
        return this.f36685a;
    }

    public final int b() {
        return this.f36686b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UploadParams) {
            UploadParams uploadParams = (UploadParams) obj;
            return this.f36685a == uploadParams.f36685a && this.f36686b == uploadParams.f36686b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f36685a * 31) + this.f36686b;
    }

    public String toString() {
        return "UploadParams(fileIndex=" + this.f36685a + ", totalFilesCount=" + this.f36686b + ')';
    }
}
