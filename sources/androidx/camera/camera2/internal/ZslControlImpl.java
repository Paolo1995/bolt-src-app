package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.RingBuffer$OnRemoveCallback;
import androidx.camera.core.internal.utils.ZslRingBuffer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ZslControlImpl implements ZslControl {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Size> f2729a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final CameraCharacteristicsCompat f2730b;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2734f;

    /* renamed from: g  reason: collision with root package name */
    SafeCloseImageReaderProxy f2735g;

    /* renamed from: h  reason: collision with root package name */
    private CameraCaptureCallback f2736h;

    /* renamed from: i  reason: collision with root package name */
    private DeferrableSurface f2737i;

    /* renamed from: j  reason: collision with root package name */
    ImageWriter f2738j;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2732d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2733e = false;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final ZslRingBuffer f2731c = new ZslRingBuffer(3, new RingBuffer$OnRemoveCallback() { // from class: androidx.camera.camera2.internal.r1
        @Override // androidx.camera.core.internal.utils.RingBuffer$OnRemoveCallback
        public final void a(Object obj) {
            ((ImageProxy) obj).close();
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZslControlImpl(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.f2734f = false;
        this.f2730b = cameraCharacteristicsCompat;
        this.f2734f = ZslUtil.a(cameraCharacteristicsCompat, 4);
        this.f2729a = k(cameraCharacteristicsCompat);
    }

    private void j() {
        ZslRingBuffer zslRingBuffer = this.f2731c;
        while (!zslRingBuffer.c()) {
            zslRingBuffer.a().close();
        }
        DeferrableSurface deferrableSurface = this.f2737i;
        if (deferrableSurface != null) {
            SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.f2735g;
            if (safeCloseImageReaderProxy != null) {
                deferrableSurface.i().f(new q1(safeCloseImageReaderProxy), CameraXExecutors.d());
                this.f2735g = null;
            }
            deferrableSurface.c();
            this.f2737i = null;
        }
        ImageWriter imageWriter = this.f2738j;
        if (imageWriter != null) {
            imageWriter.close();
            this.f2738j = null;
        }
    }

    @NonNull
    private Map<Integer, Size> k(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        int[] inputFormats;
        int[] inputFormats2;
        Size[] inputSizes;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            inputFormats = streamConfigurationMap.getInputFormats();
            if (inputFormats != null) {
                HashMap hashMap = new HashMap();
                inputFormats2 = streamConfigurationMap.getInputFormats();
                for (int i8 : inputFormats2) {
                    inputSizes = streamConfigurationMap.getInputSizes(i8);
                    if (inputSizes != null) {
                        Arrays.sort(inputSizes, new CompareSizesByArea(true));
                        hashMap.put(Integer.valueOf(i8), inputSizes[0]);
                    }
                }
                return hashMap;
            }
        }
        return new HashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
        r5 = r5.getValidOutputFormatsForInput(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean l(@androidx.annotation.NonNull androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat r5, int r6) {
        /*
            r4 = this;
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
            java.lang.Object r5 = r5.a(r0)
            android.hardware.camera2.params.StreamConfigurationMap r5 = (android.hardware.camera2.params.StreamConfigurationMap) r5
            r0 = 0
            if (r5 != 0) goto Lc
            return r0
        Lc:
            int[] r5 = androidx.camera.camera2.internal.m1.a(r5, r6)
            if (r5 != 0) goto L13
            return r0
        L13:
            int r6 = r5.length
            r1 = 0
        L15:
            if (r1 >= r6) goto L22
            r2 = r5[r1]
            r3 = 256(0x100, float:3.59E-43)
            if (r2 != r3) goto L1f
            r5 = 1
            return r5
        L1f:
            int r1 = r1 + 1
            goto L15
        L22:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.ZslControlImpl.l(androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy b8 = imageReaderProxy.b();
            if (b8 != null) {
                this.f2731c.d(b8);
            }
        } catch (IllegalStateException e8) {
            Logger.c("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e8.getMessage());
        }
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void a(@NonNull SessionConfig.Builder builder) {
        j();
        if (!this.f2732d && this.f2734f && !this.f2729a.isEmpty() && this.f2729a.containsKey(34) && l(this.f2730b, 34)) {
            Size size = this.f2729a.get(34);
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), 34, 9);
            this.f2736h = metadataImageReader.m();
            this.f2735g = new SafeCloseImageReaderProxy(metadataImageReader);
            metadataImageReader.f(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.camera2.internal.p1
                @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
                public final void a(ImageReaderProxy imageReaderProxy) {
                    ZslControlImpl.this.m(imageReaderProxy);
                }
            }, CameraXExecutors.c());
            ImmediateSurface immediateSurface = new ImmediateSurface(this.f2735g.getSurface(), new Size(this.f2735g.getWidth(), this.f2735g.getHeight()), 34);
            this.f2737i = immediateSurface;
            SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.f2735g;
            ListenableFuture<Void> i8 = immediateSurface.i();
            Objects.requireNonNull(safeCloseImageReaderProxy);
            i8.f(new q1(safeCloseImageReaderProxy), CameraXExecutors.d());
            builder.k(this.f2737i);
            builder.d(this.f2736h);
            builder.j(new CameraCaptureSession.StateCallback() { // from class: androidx.camera.camera2.internal.ZslControlImpl.1
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                    Surface inputSurface;
                    inputSurface = cameraCaptureSession.getInputSurface();
                    if (inputSurface != null) {
                        ZslControlImpl.this.f2738j = ImageWriterCompat.a(inputSurface, 1);
                    }
                }
            });
            builder.r(new InputConfiguration(this.f2735g.getWidth(), this.f2735g.getHeight(), this.f2735g.c()));
        }
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean b() {
        return this.f2732d;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void c(boolean z7) {
        this.f2733e = z7;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void d(boolean z7) {
        this.f2732d = z7;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public ImageProxy e() {
        try {
            return this.f2731c.a();
        } catch (NoSuchElementException unused) {
            Logger.c("ZslControlImpl", "dequeueImageFromBuffer no such element");
            return null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean f(@NonNull ImageProxy imageProxy) {
        ImageWriter imageWriter;
        Image V0 = imageProxy.V0();
        if (Build.VERSION.SDK_INT >= 23 && (imageWriter = this.f2738j) != null && V0 != null) {
            try {
                ImageWriterCompat.c(imageWriter, V0);
                return true;
            } catch (IllegalStateException e8) {
                Logger.c("ZslControlImpl", "enqueueImageToImageWriter throws IllegalStateException = " + e8.getMessage());
            }
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean g() {
        return this.f2733e;
    }
}
