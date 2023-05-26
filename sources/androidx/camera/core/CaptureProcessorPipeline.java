package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CaptureProcessorPipeline implements CaptureProcessor {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CaptureProcessor f3087a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final CaptureProcessor f3088b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ListenableFuture<List<Void>> f3089c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final Executor f3090d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3091e;

    /* renamed from: f  reason: collision with root package name */
    private ImageReaderProxy f3092f = null;

    /* renamed from: g  reason: collision with root package name */
    private ImageInfo f3093g = null;

    /* renamed from: h  reason: collision with root package name */
    private final Object f3094h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private boolean f3095i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3096j = false;

    /* renamed from: k  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f3097k;

    /* renamed from: l  reason: collision with root package name */
    private ListenableFuture<Void> f3098l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CaptureProcessorPipeline(@NonNull CaptureProcessor captureProcessor, int i8, @NonNull CaptureProcessor captureProcessor2, @NonNull Executor executor) {
        this.f3087a = captureProcessor;
        this.f3088b = captureProcessor2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(captureProcessor.b());
        arrayList.add(captureProcessor2.b());
        this.f3089c = Futures.c(arrayList);
        this.f3090d = executor;
        this.f3091e = i8;
    }

    private void j() {
        boolean z7;
        boolean z8;
        final CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.f3094h) {
            z7 = this.f3095i;
            z8 = this.f3096j;
            completer = this.f3097k;
            if (z7 && !z8) {
                this.f3092f.close();
            }
        }
        if (z7 && !z8 && completer != null) {
            this.f3089c.f(new Runnable() { // from class: androidx.camera.core.k
                @Override // java.lang.Runnable
                public final void run() {
                    CallbackToFutureAdapter.Completer.this.c(null);
                }
            }, CameraXExecutors.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void l(List list) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object m(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.f3094h) {
            this.f3097k = completer;
        }
        return "CaptureProcessorPipeline-close";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ImageReaderProxy imageReaderProxy) {
        final ImageProxy g8 = imageReaderProxy.g();
        try {
            this.f3090d.execute(new Runnable() { // from class: androidx.camera.core.l
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureProcessorPipeline.this.n(g8);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.c("CaptureProcessorPipeline", "The executor for post-processing might have been shutting down or terminated!");
            g8.close();
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void a(@NonNull Surface surface, int i8) {
        this.f3088b.a(surface, i8);
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    @NonNull
    public ListenableFuture<Void> b() {
        ListenableFuture<Void> j8;
        synchronized (this.f3094h) {
            if (this.f3095i && !this.f3096j) {
                j8 = Futures.o(this.f3089c, new Function() { // from class: androidx.camera.core.i
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        Void l8;
                        l8 = CaptureProcessorPipeline.l((List) obj);
                        return l8;
                    }
                }, CameraXExecutors.a());
            } else {
                if (this.f3098l == null) {
                    this.f3098l = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.j
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object a(CallbackToFutureAdapter.Completer completer) {
                            Object m8;
                            m8 = CaptureProcessorPipeline.this.m(completer);
                            return m8;
                        }
                    });
                }
                j8 = Futures.j(this.f3098l);
            }
        }
        return j8;
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void c(@NonNull Size size) {
        AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(size.getWidth(), size.getHeight(), 35, this.f3091e));
        this.f3092f = androidImageReaderProxy;
        this.f3087a.a(androidImageReaderProxy.getSurface(), 35);
        this.f3087a.c(size);
        this.f3088b.c(size);
        this.f3092f.f(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.h
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void a(ImageReaderProxy imageReaderProxy) {
                CaptureProcessorPipeline.this.o(imageReaderProxy);
            }
        }, CameraXExecutors.a());
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void close() {
        synchronized (this.f3094h) {
            if (this.f3095i) {
                return;
            }
            this.f3095i = true;
            this.f3087a.close();
            this.f3088b.close();
            j();
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void d(@NonNull ImageProxyBundle imageProxyBundle) {
        synchronized (this.f3094h) {
            if (this.f3095i) {
                return;
            }
            this.f3096j = true;
            ListenableFuture<ImageProxy> b8 = imageProxyBundle.b(imageProxyBundle.a().get(0).intValue());
            Preconditions.a(b8.isDone());
            try {
                this.f3093g = b8.get().O0();
                this.f3087a.d(imageProxyBundle);
            } catch (InterruptedException | ExecutionException unused) {
                throw new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void n(ImageProxy imageProxy) {
        boolean z7;
        synchronized (this.f3094h) {
            z7 = this.f3095i;
        }
        if (!z7) {
            Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
            Preconditions.g(this.f3093g);
            String next = this.f3093g.b().d().iterator().next();
            int intValue = ((Integer) this.f3093g.b().c(next)).intValue();
            SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy, size, this.f3093g);
            this.f3093g = null;
            SettableImageProxyBundle settableImageProxyBundle = new SettableImageProxyBundle(Collections.singletonList(Integer.valueOf(intValue)), next);
            settableImageProxyBundle.c(settableImageProxy);
            try {
                this.f3088b.d(settableImageProxyBundle);
            } catch (Exception e8) {
                Logger.c("CaptureProcessorPipeline", "Post processing image failed! " + e8.getMessage());
            }
        }
        synchronized (this.f3094h) {
            this.f3096j = false;
        }
        j();
    }
}
