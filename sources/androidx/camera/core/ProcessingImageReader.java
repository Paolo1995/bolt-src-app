package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ProcessingImageReader implements ImageReaderProxy {

    /* renamed from: g  reason: collision with root package name */
    final ImageReaderProxy f3240g;

    /* renamed from: h  reason: collision with root package name */
    final ImageReaderProxy f3241h;

    /* renamed from: i  reason: collision with root package name */
    ImageReaderProxy.OnImageAvailableListener f3242i;

    /* renamed from: j  reason: collision with root package name */
    Executor f3243j;

    /* renamed from: k  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f3244k;

    /* renamed from: l  reason: collision with root package name */
    private ListenableFuture<Void> f3245l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    final Executor f3246m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    final CaptureProcessor f3247n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    private final ListenableFuture<Void> f3248o;

    /* renamed from: t  reason: collision with root package name */
    OnProcessingErrorCallback f3253t;

    /* renamed from: u  reason: collision with root package name */
    Executor f3254u;

    /* renamed from: a  reason: collision with root package name */
    final Object f3234a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private ImageReaderProxy.OnImageAvailableListener f3235b = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.ProcessingImageReader.1
        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void a(@NonNull ImageReaderProxy imageReaderProxy) {
            ProcessingImageReader.this.o(imageReaderProxy);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private ImageReaderProxy.OnImageAvailableListener f3236c = new AnonymousClass2();

    /* renamed from: d  reason: collision with root package name */
    private FutureCallback<List<ImageProxy>> f3237d = new AnonymousClass3();

    /* renamed from: e  reason: collision with root package name */
    boolean f3238e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f3239f = false;

    /* renamed from: p  reason: collision with root package name */
    private String f3249p = new String();
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    SettableImageProxyBundle f3250q = new SettableImageProxyBundle(Collections.emptyList(), this.f3249p);

    /* renamed from: r  reason: collision with root package name */
    private final List<Integer> f3251r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private ListenableFuture<List<ImageProxy>> f3252s = Futures.h(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.core.ProcessingImageReader$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements ImageReaderProxy.OnImageAvailableListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
            onImageAvailableListener.a(ProcessingImageReader.this);
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
        public void a(@NonNull ImageReaderProxy imageReaderProxy) {
            final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
            Executor executor;
            synchronized (ProcessingImageReader.this.f3234a) {
                ProcessingImageReader processingImageReader = ProcessingImageReader.this;
                onImageAvailableListener = processingImageReader.f3242i;
                executor = processingImageReader.f3243j;
                processingImageReader.f3250q.e();
                ProcessingImageReader.this.u();
            }
            if (onImageAvailableListener != null) {
                if (executor != null) {
                    executor.execute(new Runnable() { // from class: androidx.camera.core.q0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ProcessingImageReader.AnonymousClass2.this.c(onImageAvailableListener);
                        }
                    });
                } else {
                    onImageAvailableListener.a(ProcessingImageReader.this);
                }
            }
        }
    }

    /* renamed from: androidx.camera.core.ProcessingImageReader$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements FutureCallback<List<ImageProxy>> {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(OnProcessingErrorCallback onProcessingErrorCallback, Exception exc) {
            onProcessingErrorCallback.a(exc.getMessage(), exc.getCause());
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        /* renamed from: c */
        public void onSuccess(List<ImageProxy> list) {
            ProcessingImageReader processingImageReader;
            synchronized (ProcessingImageReader.this.f3234a) {
                ProcessingImageReader processingImageReader2 = ProcessingImageReader.this;
                if (processingImageReader2.f3238e) {
                    return;
                }
                processingImageReader2.f3239f = true;
                SettableImageProxyBundle settableImageProxyBundle = processingImageReader2.f3250q;
                final OnProcessingErrorCallback onProcessingErrorCallback = processingImageReader2.f3253t;
                Executor executor = processingImageReader2.f3254u;
                try {
                    processingImageReader2.f3247n.d(settableImageProxyBundle);
                } catch (Exception e8) {
                    synchronized (ProcessingImageReader.this.f3234a) {
                        ProcessingImageReader.this.f3250q.e();
                        if (onProcessingErrorCallback != null && executor != null) {
                            executor.execute(new Runnable() { // from class: androidx.camera.core.r0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ProcessingImageReader.AnonymousClass3.b(ProcessingImageReader.OnProcessingErrorCallback.this, e8);
                                }
                            });
                        }
                    }
                }
                synchronized (ProcessingImageReader.this.f3234a) {
                    processingImageReader = ProcessingImageReader.this;
                    processingImageReader.f3239f = false;
                }
                processingImageReader.k();
            }
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(@NonNull Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnProcessingErrorCallback {
        void a(String str, Throwable th);
    }

    ProcessingImageReader(@NonNull Builder builder) {
        if (builder.f3259a.e() >= builder.f3260b.a().size()) {
            ImageReaderProxy imageReaderProxy = builder.f3259a;
            this.f3240g = imageReaderProxy;
            int width = imageReaderProxy.getWidth();
            int height = imageReaderProxy.getHeight();
            int i8 = builder.f3262d;
            if (i8 == 256) {
                width = ((int) (width * height * 1.5f)) + 64000;
                height = 1;
            }
            AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(width, height, i8, imageReaderProxy.e()));
            this.f3241h = androidImageReaderProxy;
            this.f3246m = builder.f3263e;
            CaptureProcessor captureProcessor = builder.f3261c;
            this.f3247n = captureProcessor;
            captureProcessor.a(androidImageReaderProxy.getSurface(), builder.f3262d);
            captureProcessor.c(new Size(imageReaderProxy.getWidth(), imageReaderProxy.getHeight()));
            this.f3248o = captureProcessor.b();
            s(builder.f3260b);
            return;
        }
        throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
    }

    private void j() {
        synchronized (this.f3234a) {
            if (!this.f3252s.isDone()) {
                this.f3252s.cancel(true);
            }
            this.f3250q.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(CallbackToFutureAdapter.Completer completer) {
        j();
        if (completer != null) {
            completer.c(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void q(Void r02) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.f3234a) {
            this.f3244k = completer;
        }
        return "ProcessingImageReader-close";
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy b() {
        ImageProxy b8;
        synchronized (this.f3234a) {
            b8 = this.f3241h.b();
        }
        return b8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int c() {
        int c8;
        synchronized (this.f3234a) {
            c8 = this.f3241h.c();
        }
        return c8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.f3234a) {
            if (this.f3238e) {
                return;
            }
            this.f3240g.d();
            this.f3241h.d();
            this.f3238e = true;
            this.f3247n.close();
            k();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void d() {
        synchronized (this.f3234a) {
            this.f3242i = null;
            this.f3243j = null;
            this.f3240g.d();
            this.f3241h.d();
            if (!this.f3239f) {
                this.f3250q.d();
            }
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int e() {
        int e8;
        synchronized (this.f3234a) {
            e8 = this.f3240g.e();
        }
        return e8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void f(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.f3234a) {
            this.f3242i = (ImageReaderProxy.OnImageAvailableListener) Preconditions.g(onImageAvailableListener);
            this.f3243j = (Executor) Preconditions.g(executor);
            this.f3240g.f(this.f3235b, executor);
            this.f3241h.f(this.f3236c, executor);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy g() {
        ImageProxy g8;
        synchronized (this.f3234a) {
            g8 = this.f3241h.g();
        }
        return g8;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.f3234a) {
            height = this.f3240g.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Surface surface;
        synchronized (this.f3234a) {
            surface = this.f3240g.getSurface();
        }
        return surface;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.f3234a) {
            width = this.f3240g.getWidth();
        }
        return width;
    }

    void k() {
        boolean z7;
        boolean z8;
        final CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.f3234a) {
            z7 = this.f3238e;
            z8 = this.f3239f;
            completer = this.f3244k;
            if (z7 && !z8) {
                this.f3240g.close();
                this.f3250q.d();
                this.f3241h.close();
            }
        }
        if (z7 && !z8) {
            this.f3248o.f(new Runnable() { // from class: androidx.camera.core.p0
                @Override // java.lang.Runnable
                public final void run() {
                    ProcessingImageReader.this.p(completer);
                }
            }, CameraXExecutors.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraCaptureCallback l() {
        synchronized (this.f3234a) {
            ImageReaderProxy imageReaderProxy = this.f3240g;
            if (imageReaderProxy instanceof MetadataImageReader) {
                return ((MetadataImageReader) imageReaderProxy).m();
            }
            return new CameraCaptureCallback() { // from class: androidx.camera.core.ProcessingImageReader.4
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ListenableFuture<Void> m() {
        ListenableFuture<Void> j8;
        synchronized (this.f3234a) {
            if (this.f3238e && !this.f3239f) {
                j8 = Futures.o(this.f3248o, new Function() { // from class: androidx.camera.core.n0
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        Void q8;
                        q8 = ProcessingImageReader.q((Void) obj);
                        return q8;
                    }
                }, CameraXExecutors.a());
            } else {
                if (this.f3245l == null) {
                    this.f3245l = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.o0
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object a(CallbackToFutureAdapter.Completer completer) {
                            Object r7;
                            r7 = ProcessingImageReader.this.r(completer);
                            return r7;
                        }
                    });
                }
                j8 = Futures.j(this.f3245l);
            }
        }
        return j8;
    }

    @NonNull
    public String n() {
        return this.f3249p;
    }

    void o(ImageReaderProxy imageReaderProxy) {
        synchronized (this.f3234a) {
            if (this.f3238e) {
                return;
            }
            try {
                ImageProxy g8 = imageReaderProxy.g();
                if (g8 != null) {
                    Integer num = (Integer) g8.O0().b().c(this.f3249p);
                    if (!this.f3251r.contains(num)) {
                        Logger.k("ProcessingImageReader", "ImageProxyBundle does not contain this id: " + num);
                        g8.close();
                    } else {
                        this.f3250q.c(g8);
                    }
                }
            } catch (IllegalStateException e8) {
                Logger.d("ProcessingImageReader", "Failed to acquire latest image.", e8);
            }
        }
    }

    public void s(@NonNull CaptureBundle captureBundle) {
        synchronized (this.f3234a) {
            if (this.f3238e) {
                return;
            }
            j();
            if (captureBundle.a() != null) {
                if (this.f3240g.e() >= captureBundle.a().size()) {
                    this.f3251r.clear();
                    for (CaptureStage captureStage : captureBundle.a()) {
                        if (captureStage != null) {
                            this.f3251r.add(Integer.valueOf(captureStage.getId()));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
                }
            }
            String num = Integer.toString(captureBundle.hashCode());
            this.f3249p = num;
            this.f3250q = new SettableImageProxyBundle(this.f3251r, num);
            u();
        }
    }

    public void t(@NonNull Executor executor, @NonNull OnProcessingErrorCallback onProcessingErrorCallback) {
        synchronized (this.f3234a) {
            this.f3254u = executor;
            this.f3253t = onProcessingErrorCallback;
        }
    }

    void u() {
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.f3251r) {
            arrayList.add(this.f3250q.b(num.intValue()));
        }
        this.f3252s = Futures.c(arrayList);
        Futures.b(Futures.c(arrayList), this.f3237d, this.f3246m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        protected final ImageReaderProxy f3259a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        protected final CaptureBundle f3260b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        protected final CaptureProcessor f3261c;

        /* renamed from: d  reason: collision with root package name */
        protected int f3262d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        protected Executor f3263e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull ImageReaderProxy imageReaderProxy, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
            this.f3263e = Executors.newSingleThreadExecutor();
            this.f3259a = imageReaderProxy;
            this.f3260b = captureBundle;
            this.f3261c = captureProcessor;
            this.f3262d = imageReaderProxy.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProcessingImageReader a() {
            return new ProcessingImageReader(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public Builder b(int i8) {
            this.f3262d = i8;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public Builder c(@NonNull Executor executor) {
            this.f3263e = executor;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int i8, int i9, int i10, int i11, @NonNull CaptureBundle captureBundle, @NonNull CaptureProcessor captureProcessor) {
            this(new MetadataImageReader(i8, i9, i10, i11), captureBundle, captureProcessor);
        }
    }
}
