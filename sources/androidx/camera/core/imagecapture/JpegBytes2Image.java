package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import j$.util.Spliterator;
import java.util.Objects;

/* loaded from: classes.dex */
public class JpegBytes2Image implements Operation<Packet<byte[]>, Packet<ImageProxy>> {
    @Override // androidx.camera.core.processing.Operation
    @NonNull
    /* renamed from: a */
    public Packet<ImageProxy> apply(@NonNull Packet<byte[]> packet) throws ImageCaptureException {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = new SafeCloseImageReaderProxy(ImageReaderProxys.a(packet.h().getWidth(), packet.h().getHeight(), Spliterator.NONNULL, 2));
        ImageProxy a8 = ImageProcessingUtil.a(safeCloseImageReaderProxy, packet.c());
        safeCloseImageReaderProxy.l();
        Objects.requireNonNull(a8);
        Exif d8 = packet.d();
        Objects.requireNonNull(d8);
        return Packet.k(a8, d8, packet.b(), packet.f(), packet.g(), packet.a());
    }
}
