package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import j$.util.Spliterator;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
class Bitmap2JpegBytes implements Operation<In, Packet<byte[]>> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {
        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public static In c(@NonNull Packet<Bitmap> packet, int i8) {
            return new AutoValue_Bitmap2JpegBytes_In(packet, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Packet<Bitmap> b();
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    /* renamed from: a */
    public Packet<byte[]> apply(@NonNull In in) throws ImageCaptureException {
        Packet<Bitmap> b8 = in.b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b8.c().compress(Bitmap.CompressFormat.JPEG, in.a(), byteArrayOutputStream);
        b8.c().recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Exif d8 = b8.d();
        Objects.requireNonNull(d8);
        return Packet.l(byteArray, d8, Spliterator.NONNULL, b8.h(), b8.b(), b8.f(), b8.g(), b8.a());
    }
}
