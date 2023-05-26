package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.processing.Edge;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CaptureNode {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Set<Integer> f3453a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<ImageProxy> f3454b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private ProcessingRequest f3455c = null;

    /* renamed from: d  reason: collision with root package name */
    SafeCloseImageReaderProxy f3456d;

    /* renamed from: e  reason: collision with root package name */
    private Out f3457e;

    /* renamed from: f  reason: collision with root package name */
    private In f3458f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {

        /* renamed from: a  reason: collision with root package name */
        private CameraCaptureCallback f3459a;

        /* renamed from: b  reason: collision with root package name */
        private DeferrableSurface f3460b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public static In g(Size size, int i8) {
            return new AutoValue_CaptureNode_In(size, i8, new Edge());
        }

        void a() {
            this.f3460b.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CameraCaptureCallback b() {
            return this.f3459a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int c();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract Edge<ProcessingRequest> d();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Size e();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public DeferrableSurface f() {
            return this.f3460b;
        }

        void h(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.f3459a = cameraCaptureCallback;
        }

        void i(@NonNull Surface surface) {
            boolean z7;
            if (this.f3460b == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "The surface is already set.");
            this.f3460b = new ImmediateSurface(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Out {
        static Out d(int i8) {
            return new AutoValue_CaptureNode_Out(new Edge(), new Edge(), i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<ImageProxy> b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<ProcessingRequest> c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(ImageReaderProxy imageReaderProxy) {
        ImageProxy g8 = imageReaderProxy.g();
        Objects.requireNonNull(g8);
        e(g8);
    }

    private void d(@NonNull ImageProxy imageProxy) {
        Object c8 = imageProxy.O0().b().c(this.f3455c.g());
        Objects.requireNonNull(c8);
        int intValue = ((Integer) c8).intValue();
        boolean contains = this.f3453a.contains(Integer.valueOf(intValue));
        Preconditions.j(contains, "Received an unexpected stage id" + intValue);
        this.f3453a.remove(Integer.valueOf(intValue));
        if (this.f3453a.isEmpty()) {
            this.f3455c.l();
            this.f3455c = null;
        }
        this.f3457e.b().accept(imageProxy);
    }

    public int b() {
        boolean z7;
        Threads.a();
        if (this.f3456d != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.j(z7, "The ImageReader is not initialized.");
        return this.f3456d.i();
    }

    void e(@NonNull ImageProxy imageProxy) {
        Threads.a();
        if (this.f3455c == null) {
            this.f3454b.add(imageProxy);
        } else {
            d(imageProxy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(@NonNull ProcessingRequest processingRequest) {
        boolean z7;
        Threads.a();
        boolean z8 = true;
        if (b() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.j(z7, "Too many acquire images. Close image to be able to process next.");
        if (this.f3455c != null && !this.f3453a.isEmpty()) {
            z8 = false;
        }
        Preconditions.j(z8, "The previous request is not complete");
        this.f3455c = processingRequest;
        this.f3453a.addAll(processingRequest.f());
        this.f3457e.c().accept(processingRequest);
        for (ImageProxy imageProxy : this.f3454b) {
            d(imageProxy);
        }
        this.f3454b.clear();
    }

    public void g() {
        Threads.a();
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.f3456d;
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.l();
        }
        In in = this.f3458f;
        if (in != null) {
            in.a();
        }
    }

    public void h(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        boolean z7;
        Threads.a();
        if (this.f3456d != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.j(z7, "The ImageReader is not initialized.");
        this.f3456d.m(onImageCloseListener);
    }

    @NonNull
    public Out i(@NonNull In in) {
        this.f3458f = in;
        Size e8 = in.e();
        MetadataImageReader metadataImageReader = new MetadataImageReader(e8.getWidth(), e8.getHeight(), in.c(), 4);
        this.f3456d = new SafeCloseImageReaderProxy(metadataImageReader);
        in.h(metadataImageReader.m());
        Surface surface = metadataImageReader.getSurface();
        Objects.requireNonNull(surface);
        in.i(surface);
        metadataImageReader.f(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.imagecapture.a
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void a(ImageReaderProxy imageReaderProxy) {
                CaptureNode.this.c(imageReaderProxy);
            }
        }, CameraXExecutors.d());
        in.d().a(new Consumer() { // from class: androidx.camera.core.imagecapture.b
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CaptureNode.this.f((ProcessingRequest) obj);
            }
        });
        Out d8 = Out.d(in.c());
        this.f3457e = d8;
        return d8;
    }
}
