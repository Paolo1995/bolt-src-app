package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3202a;

    /* renamed from: b  reason: collision with root package name */
    private CameraCaptureCallback f3203b;

    /* renamed from: c  reason: collision with root package name */
    private int f3204c;

    /* renamed from: d  reason: collision with root package name */
    private ImageReaderProxy.OnImageAvailableListener f3205d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3206e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageReaderProxy f3207f;

    /* renamed from: g  reason: collision with root package name */
    ImageReaderProxy.OnImageAvailableListener f3208g;

    /* renamed from: h  reason: collision with root package name */
    private Executor f3209h;

    /* renamed from: i  reason: collision with root package name */
    private final LongSparseArray<ImageInfo> f3210i;

    /* renamed from: j  reason: collision with root package name */
    private final LongSparseArray<ImageProxy> f3211j;

    /* renamed from: k  reason: collision with root package name */
    private int f3212k;

    /* renamed from: l  reason: collision with root package name */
    private final List<ImageProxy> f3213l;

    /* renamed from: m  reason: collision with root package name */
    private final List<ImageProxy> f3214m;

    public MetadataImageReader(int i8, int i9, int i10, int i11) {
        this(j(i8, i9, i10, i11));
    }

    private static ImageReaderProxy j(int i8, int i9, int i10, int i11) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i8, i9, i10, i11));
    }

    private void k(ImageProxy imageProxy) {
        synchronized (this.f3202a) {
            int indexOf = this.f3213l.indexOf(imageProxy);
            if (indexOf >= 0) {
                this.f3213l.remove(indexOf);
                int i8 = this.f3212k;
                if (indexOf <= i8) {
                    this.f3212k = i8 - 1;
                }
            }
            this.f3214m.remove(imageProxy);
            if (this.f3204c > 0) {
                n(this.f3207f);
            }
        }
    }

    private void l(SettableImageProxy settableImageProxy) {
        final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
        Executor executor;
        synchronized (this.f3202a) {
            onImageAvailableListener = null;
            if (this.f3213l.size() < e()) {
                settableImageProxy.a(this);
                this.f3213l.add(settableImageProxy);
                onImageAvailableListener = this.f3208g;
                executor = this.f3209h;
            } else {
                Logger.a("TAG", "Maximum image number reached.");
                settableImageProxy.close();
                executor = null;
            }
        }
        if (onImageAvailableListener != null) {
            if (executor != null) {
                executor.execute(new Runnable() { // from class: androidx.camera.core.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MetadataImageReader.this.o(onImageAvailableListener);
                    }
                });
            } else {
                onImageAvailableListener.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(ImageReaderProxy imageReaderProxy) {
        synchronized (this.f3202a) {
            this.f3204c++;
        }
        n(imageReaderProxy);
    }

    private void q() {
        synchronized (this.f3202a) {
            for (int size = this.f3210i.size() - 1; size >= 0; size--) {
                ImageInfo valueAt = this.f3210i.valueAt(size);
                long d8 = valueAt.d();
                ImageProxy imageProxy = this.f3211j.get(d8);
                if (imageProxy != null) {
                    this.f3211j.remove(d8);
                    this.f3210i.removeAt(size);
                    l(new SettableImageProxy(imageProxy, valueAt));
                }
            }
            r();
        }
    }

    private void r() {
        synchronized (this.f3202a) {
            if (this.f3211j.size() != 0 && this.f3210i.size() != 0) {
                boolean z7 = false;
                Long valueOf = Long.valueOf(this.f3211j.keyAt(0));
                Long valueOf2 = Long.valueOf(this.f3210i.keyAt(0));
                if (!valueOf2.equals(valueOf)) {
                    z7 = true;
                }
                Preconditions.a(z7);
                if (valueOf2.longValue() > valueOf.longValue()) {
                    for (int size = this.f3211j.size() - 1; size >= 0; size--) {
                        if (this.f3211j.keyAt(size) < valueOf2.longValue()) {
                            this.f3211j.valueAt(size).close();
                            this.f3211j.removeAt(size);
                        }
                    }
                } else {
                    for (int size2 = this.f3210i.size() - 1; size2 >= 0; size2--) {
                        if (this.f3210i.keyAt(size2) < valueOf.longValue()) {
                            this.f3210i.removeAt(size2);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void a(@NonNull ImageProxy imageProxy) {
        synchronized (this.f3202a) {
            k(imageProxy);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy b() {
        synchronized (this.f3202a) {
            if (this.f3213l.isEmpty()) {
                return null;
            }
            if (this.f3212k < this.f3213l.size()) {
                ArrayList<ImageProxy> arrayList = new ArrayList();
                for (int i8 = 0; i8 < this.f3213l.size() - 1; i8++) {
                    if (!this.f3214m.contains(this.f3213l.get(i8))) {
                        arrayList.add(this.f3213l.get(i8));
                    }
                }
                for (ImageProxy imageProxy : arrayList) {
                    imageProxy.close();
                }
                int size = this.f3213l.size() - 1;
                List<ImageProxy> list = this.f3213l;
                this.f3212k = size + 1;
                ImageProxy imageProxy2 = list.get(size);
                this.f3214m.add(imageProxy2);
                return imageProxy2;
            }
            throw new IllegalStateException("Maximum image number reached.");
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int c() {
        int c8;
        synchronized (this.f3202a) {
            c8 = this.f3207f.c();
        }
        return c8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.f3202a) {
            if (this.f3206e) {
                return;
            }
            for (ImageProxy imageProxy : new ArrayList(this.f3213l)) {
                imageProxy.close();
            }
            this.f3213l.clear();
            this.f3207f.close();
            this.f3206e = true;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void d() {
        synchronized (this.f3202a) {
            this.f3207f.d();
            this.f3208g = null;
            this.f3209h = null;
            this.f3204c = 0;
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int e() {
        int e8;
        synchronized (this.f3202a) {
            e8 = this.f3207f.e();
        }
        return e8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void f(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.f3202a) {
            this.f3208g = (ImageReaderProxy.OnImageAvailableListener) Preconditions.g(onImageAvailableListener);
            this.f3209h = (Executor) Preconditions.g(executor);
            this.f3207f.f(this.f3205d, executor);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy g() {
        synchronized (this.f3202a) {
            if (this.f3213l.isEmpty()) {
                return null;
            }
            if (this.f3212k < this.f3213l.size()) {
                List<ImageProxy> list = this.f3213l;
                int i8 = this.f3212k;
                this.f3212k = i8 + 1;
                ImageProxy imageProxy = list.get(i8);
                this.f3214m.add(imageProxy);
                return imageProxy;
            }
            throw new IllegalStateException("Maximum image number reached.");
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.f3202a) {
            height = this.f3207f.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Surface surface;
        synchronized (this.f3202a) {
            surface = this.f3207f.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.f3202a) {
            width = this.f3207f.getWidth();
        }
        return width;
    }

    @NonNull
    public CameraCaptureCallback m() {
        return this.f3203b;
    }

    void n(ImageReaderProxy imageReaderProxy) {
        synchronized (this.f3202a) {
            if (this.f3206e) {
                return;
            }
            int size = this.f3211j.size() + this.f3213l.size();
            if (size >= imageReaderProxy.e()) {
                Logger.a("MetadataImageReader", "Skip to acquire the next image because the acquired image count has reached the max images count.");
                return;
            }
            do {
                ImageProxy imageProxy = null;
                try {
                    imageProxy = imageReaderProxy.g();
                    if (imageProxy != null) {
                        this.f3204c--;
                        size++;
                        this.f3211j.put(imageProxy.O0().d(), imageProxy);
                        q();
                    }
                } catch (IllegalStateException e8) {
                    Logger.b("MetadataImageReader", "Failed to acquire next image.", e8);
                }
                if (imageProxy == null || this.f3204c <= 0) {
                    break;
                }
            } while (size < imageReaderProxy.e());
        }
    }

    void s(CameraCaptureResult cameraCaptureResult) {
        synchronized (this.f3202a) {
            if (this.f3206e) {
                return;
            }
            this.f3210i.put(cameraCaptureResult.d(), new CameraCaptureResultImageInfo(cameraCaptureResult));
            q();
        }
    }

    MetadataImageReader(@NonNull ImageReaderProxy imageReaderProxy) {
        this.f3202a = new Object();
        this.f3203b = new CameraCaptureCallback() { // from class: androidx.camera.core.MetadataImageReader.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void b(@NonNull CameraCaptureResult cameraCaptureResult) {
                super.b(cameraCaptureResult);
                MetadataImageReader.this.s(cameraCaptureResult);
            }
        };
        this.f3204c = 0;
        this.f3205d = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.i0
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void a(ImageReaderProxy imageReaderProxy2) {
                MetadataImageReader.this.p(imageReaderProxy2);
            }
        };
        this.f3206e = false;
        this.f3210i = new LongSparseArray<>();
        this.f3211j = new LongSparseArray<>();
        this.f3214m = new ArrayList();
        this.f3207f = imageReaderProxy;
        this.f3212k = 0;
        this.f3213l = new ArrayList(e());
    }
}
