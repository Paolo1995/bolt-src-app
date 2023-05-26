package androidx.camera.core.imagecapture;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.ByteBufferOutputStream;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import j$.util.Spliterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes.dex */
final class Image2JpegBytes implements Operation<In, Packet<byte[]>> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {
        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public static In c(@NonNull Packet<ImageProxy> packet, int i8) {
            return new AutoValue_Image2JpegBytes_In(packet, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Packet<ImageProxy> b();
    }

    private static byte[] b(@NonNull ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        byteBuffer.rewind();
        byteBuffer.get(bArr, 0, position);
        return bArr;
    }

    private static Exif c(@NonNull byte[] bArr) throws ImageCaptureException {
        try {
            return Exif.k(new ByteArrayInputStream(bArr));
        } catch (IOException e8) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e8);
        }
    }

    private Packet<byte[]> d(@NonNull In in) {
        Packet<ImageProxy> b8 = in.b();
        byte[] i8 = ImageUtil.i(b8.c());
        Exif d8 = b8.d();
        Objects.requireNonNull(d8);
        return Packet.l(i8, d8, Spliterator.NONNULL, b8.h(), b8.b(), b8.f(), b8.g(), b8.a());
    }

    private Packet<byte[]> e(@NonNull In in) throws ImageCaptureException {
        Packet<ImageProxy> b8 = in.b();
        ImageProxy c8 = b8.c();
        Rect b9 = b8.b();
        YuvImage yuvImage = new YuvImage(ImageUtil.q(c8), 17, c8.getWidth(), c8.getHeight(), null);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(b9.width() * b9.height() * 2);
        yuvImage.compressToJpeg(b9, in.a(), new ExifOutputStream(new ByteBufferOutputStream(allocateDirect), ExifData.b(c8, b8.f())));
        byte[] b10 = b(allocateDirect);
        return Packet.l(b10, c(b10), Spliterator.NONNULL, new Size(b9.width(), b9.height()), new Rect(0, 0, b9.width(), b9.height()), b8.f(), TransformUtils.o(b8.g(), b9), b8.a());
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    /* renamed from: a */
    public Packet<byte[]> apply(@NonNull In in) throws ImageCaptureException {
        Packet<byte[]> e8;
        try {
            int e9 = in.b().e();
            if (e9 != 35) {
                if (e9 == 256) {
                    e8 = d(in);
                } else {
                    throw new IllegalArgumentException("Unexpected format: " + e9);
                }
            } else {
                e8 = e(in);
            }
            return e8;
        } finally {
            in.b().c().close();
        }
    }
}
