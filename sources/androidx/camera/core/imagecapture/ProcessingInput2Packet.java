package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.io.IOException;

/* loaded from: classes.dex */
final class ProcessingInput2Packet implements Operation<ProcessingNode.InputPacket, Packet<ImageProxy>> {
    @NonNull
    private static Matrix b(int i8, @NonNull Size size, int i9) {
        Size size2;
        int i10 = i8 - i9;
        if (TransformUtils.f(TransformUtils.p(i10))) {
            size2 = new Size(size.getHeight(), size.getWidth());
        } else {
            size2 = size;
        }
        return TransformUtils.c(new RectF(0.0f, 0.0f, size2.getWidth(), size2.getHeight()), new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), i10);
    }

    @NonNull
    private static Rect c(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @NonNull
    private static Matrix d(@NonNull Matrix matrix, @NonNull Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    private static boolean e(@NonNull Exif exif, @NonNull ImageProxy imageProxy) {
        if (exif.u() == imageProxy.getWidth() && exif.p() == imageProxy.getHeight()) {
            return true;
        }
        return false;
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    /* renamed from: a */
    public Packet<ImageProxy> apply(@NonNull ProcessingNode.InputPacket inputPacket) throws ImageCaptureException {
        Exif j8;
        Matrix matrix;
        int i8;
        ImageProxy a8 = inputPacket.a();
        ProcessingRequest b8 = inputPacket.b();
        if (a8.getFormat() == 256) {
            try {
                j8 = Exif.j(a8);
                a8.n0()[0].b().rewind();
            } catch (IOException e8) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e8);
            }
        } else {
            j8 = null;
        }
        CameraCaptureResult f8 = ((CameraCaptureResultImageInfo) a8.O0()).f();
        Rect a9 = b8.a();
        Matrix e9 = b8.e();
        int d8 = b8.d();
        if (ImagePipeline.f3461g.b(a8)) {
            Preconditions.h(j8, "The image must have JPEG exif.");
            Preconditions.j(e(j8, a8), "Exif size does not match image size.");
            Matrix b9 = b(b8.d(), new Size(j8.u(), j8.p()), j8.s());
            Rect c8 = c(b8.a(), b9);
            matrix = d(b8.e(), b9);
            i8 = j8.s();
            a9 = c8;
        } else {
            matrix = e9;
            i8 = d8;
        }
        return Packet.k(a8, j8, a9, i8, matrix, f8);
    }
}
