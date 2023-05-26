package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;

/* loaded from: classes.dex */
public class JpegImage2Result implements Operation<Packet<ImageProxy>, ImageProxy> {
    @Override // androidx.camera.core.processing.Operation
    @NonNull
    /* renamed from: a */
    public ImageProxy apply(@NonNull Packet<ImageProxy> packet) throws ImageCaptureException {
        ImageProxy c8 = packet.c();
        SettableImageProxy settableImageProxy = new SettableImageProxy(c8, packet.h(), ImmutableImageInfo.f(c8.O0().b(), c8.O0().d(), packet.f(), packet.g()));
        settableImageProxy.W(packet.b());
        return settableImageProxy;
    }
}
