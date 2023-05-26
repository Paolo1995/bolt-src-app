package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.processing.Packet;

/* loaded from: classes.dex */
final class AutoValue_Image2JpegBytes_In extends Image2JpegBytes.In {

    /* renamed from: a  reason: collision with root package name */
    private final Packet<ImageProxy> f3433a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Image2JpegBytes_In(Packet<ImageProxy> packet, int i8) {
        if (packet != null) {
            this.f3433a = packet;
            this.f3434b = i8;
            return;
        }
        throw new NullPointerException("Null packet");
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.In
    int a() {
        return this.f3434b;
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.In
    Packet<ImageProxy> b() {
        return this.f3433a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Image2JpegBytes.In)) {
            return false;
        }
        Image2JpegBytes.In in = (Image2JpegBytes.In) obj;
        if (this.f3433a.equals(in.b()) && this.f3434b == in.a()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3433a.hashCode() ^ 1000003) * 1000003) ^ this.f3434b;
    }

    public String toString() {
        return "In{packet=" + this.f3433a + ", jpegQuality=" + this.f3434b + "}";
    }
}
