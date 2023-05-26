package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.processing.Packet;

/* loaded from: classes.dex */
final class AutoValue_Bitmap2JpegBytes_In extends Bitmap2JpegBytes.In {

    /* renamed from: a  reason: collision with root package name */
    private final Packet<Bitmap> f3425a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3426b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Bitmap2JpegBytes_In(Packet<Bitmap> packet, int i8) {
        if (packet != null) {
            this.f3425a = packet;
            this.f3426b = i8;
            return;
        }
        throw new NullPointerException("Null packet");
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.In
    int a() {
        return this.f3426b;
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.In
    Packet<Bitmap> b() {
        return this.f3425a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bitmap2JpegBytes.In)) {
            return false;
        }
        Bitmap2JpegBytes.In in = (Bitmap2JpegBytes.In) obj;
        if (this.f3425a.equals(in.b()) && this.f3426b == in.a()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3425a.hashCode() ^ 1000003) * 1000003) ^ this.f3426b;
    }

    public String toString() {
        return "In{packet=" + this.f3425a + ", jpegQuality=" + this.f3426b + "}";
    }
}
