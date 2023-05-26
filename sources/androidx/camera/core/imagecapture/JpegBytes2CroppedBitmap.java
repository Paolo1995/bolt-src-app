package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
final class JpegBytes2CroppedBitmap implements Operation<Packet<byte[]>, Packet<Bitmap>> {
    @NonNull
    private Bitmap b(@NonNull byte[] bArr, @NonNull Rect rect) throws ImageCaptureException {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (IOException e8) {
            throw new ImageCaptureException(1, "Failed to decode JPEG.", e8);
        }
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    /* renamed from: a */
    public Packet<Bitmap> apply(@NonNull Packet<byte[]> packet) throws ImageCaptureException {
        Rect b8 = packet.b();
        Bitmap b9 = b(packet.c(), b8);
        Exif d8 = packet.d();
        Objects.requireNonNull(d8);
        return Packet.j(b9, d8, new Rect(0, 0, b9.getWidth(), b9.getHeight()), packet.f(), TransformUtils.o(packet.g(), b8), packet.a());
    }
}
