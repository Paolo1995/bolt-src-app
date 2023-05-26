package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.processing.Packet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_JpegBytes2Disk_In extends JpegBytes2Disk.In {

    /* renamed from: a  reason: collision with root package name */
    private final Packet<byte[]> f3435a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageCapture.OutputFileOptions f3436b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_JpegBytes2Disk_In(Packet<byte[]> packet, ImageCapture.OutputFileOptions outputFileOptions) {
        if (packet != null) {
            this.f3435a = packet;
            if (outputFileOptions != null) {
                this.f3436b = outputFileOptions;
                return;
            }
            throw new NullPointerException("Null outputFileOptions");
        }
        throw new NullPointerException("Null packet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.In
    @NonNull
    public ImageCapture.OutputFileOptions a() {
        return this.f3436b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.In
    @NonNull
    public Packet<byte[]> b() {
        return this.f3435a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JpegBytes2Disk.In)) {
            return false;
        }
        JpegBytes2Disk.In in = (JpegBytes2Disk.In) obj;
        if (this.f3435a.equals(in.b()) && this.f3436b.equals(in.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3435a.hashCode() ^ 1000003) * 1000003) ^ this.f3436b.hashCode();
    }

    public String toString() {
        return "In{packet=" + this.f3435a + ", outputFileOptions=" + this.f3436b + "}";
    }
}
