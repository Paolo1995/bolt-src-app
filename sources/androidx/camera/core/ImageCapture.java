package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageSaver;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.imagecapture.ImageCaptureControl;
import androidx.camera.core.imagecapture.ImagePipeline;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.YuvToJpegProcessor;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import j$.util.Spliterator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ImageCapture extends UseCase {
    public static final Defaults L = new Defaults();
    static final ExifRotationAvailability M = new ExifRotationAvailability();
    SessionConfig.Builder A;
    SafeCloseImageReaderProxy B;
    ProcessingImageReader C;
    private ListenableFuture<Void> D;
    private CameraCaptureCallback E;
    private DeferrableSurface F;
    private ImageCaptureRequestProcessor G;
    final Executor H;
    private ImagePipeline I;
    private TakePictureManager J;
    private final ImageCaptureControl K;

    /* renamed from: m  reason: collision with root package name */
    boolean f3121m;

    /* renamed from: n  reason: collision with root package name */
    private final ImageReaderProxy.OnImageAvailableListener f3122n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    final Executor f3123o;

    /* renamed from: p  reason: collision with root package name */
    private final int f3124p;

    /* renamed from: q  reason: collision with root package name */
    private final AtomicReference<Integer> f3125q;

    /* renamed from: r  reason: collision with root package name */
    private final int f3126r;

    /* renamed from: s  reason: collision with root package name */
    private int f3127s;

    /* renamed from: t  reason: collision with root package name */
    private Rational f3128t;

    /* renamed from: u  reason: collision with root package name */
    private ExecutorService f3129u;

    /* renamed from: v  reason: collision with root package name */
    private CaptureConfig f3130v;

    /* renamed from: w  reason: collision with root package name */
    private CaptureBundle f3131w;

    /* renamed from: x  reason: collision with root package name */
    private int f3132x;

    /* renamed from: y  reason: collision with root package name */
    private CaptureProcessor f3133y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3134z;

    /* loaded from: classes.dex */
    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableOptionsBundle f3150a;

        public Builder() {
            this(MutableOptionsBundle.L());
        }

        @NonNull
        public static Builder d(@NonNull Config config) {
            return new Builder(MutableOptionsBundle.M(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig a() {
            return this.f3150a;
        }

        @NonNull
        public ImageCapture c() {
            Integer num;
            boolean z7;
            if (a().e(ImageOutputConfig.f3653g, null) != null && a().e(ImageOutputConfig.f3656j, null) != null) {
                throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
            }
            Integer num2 = (Integer) a().e(ImageCaptureConfig.F, null);
            boolean z8 = false;
            if (num2 != null) {
                if (a().e(ImageCaptureConfig.E, null) == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Preconditions.b(z7, "Cannot set buffer format with CaptureProcessor defined.");
                a().o(ImageInputConfig.f3652f, num2);
            } else if (a().e(ImageCaptureConfig.E, null) != null) {
                a().o(ImageInputConfig.f3652f, 35);
            } else {
                a().o(ImageInputConfig.f3652f, Integer.valueOf((int) Spliterator.NONNULL));
            }
            ImageCapture imageCapture = new ImageCapture(b());
            Size size = (Size) a().e(ImageOutputConfig.f3656j, null);
            if (size != null) {
                imageCapture.G0(new Rational(size.getWidth(), size.getHeight()));
            }
            Integer num3 = (Integer) a().e(ImageCaptureConfig.G, 2);
            Preconditions.h(num3, "Maximum outstanding image count must be at least 1");
            if (num3.intValue() >= 1) {
                z8 = true;
            }
            Preconditions.b(z8, "Maximum outstanding image count must be at least 1");
            Preconditions.h((Executor) a().e(IoConfig.f3909v, CameraXExecutors.c()), "The IO executor can't be null");
            MutableConfig a8 = a();
            Config.Option<Integer> option = ImageCaptureConfig.C;
            if (a8.b(option) && ((num = (Integer) a().a(option)) == null || (num.intValue() != 0 && num.intValue() != 1 && num.intValue() != 2))) {
                throw new IllegalArgumentException("The flash mode is not allowed to set: " + num);
            }
            return imageCapture;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        /* renamed from: e */
        public ImageCaptureConfig b() {
            return new ImageCaptureConfig(OptionsBundle.J(this.f3150a));
        }

        @NonNull
        public Builder f(int i8) {
            Preconditions.c(i8, 1, 100, "jpegQuality");
            a().o(ImageCaptureConfig.K, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder g(int i8) {
            a().o(UseCaseConfig.f3720r, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder h(int i8) {
            a().o(ImageOutputConfig.f3653g, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder i(@NonNull Class<ImageCapture> cls) {
            a().o(TargetConfig.f3911x, cls);
            if (a().e(TargetConfig.f3910w, null) == null) {
                j(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public Builder j(@NonNull String str) {
            a().o(TargetConfig.f3910w, str);
            return this;
        }

        @NonNull
        public Builder k(@NonNull Size size) {
            a().o(ImageOutputConfig.f3656j, size);
            return this;
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.f3150a = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.e(TargetConfig.f3911x, null);
            if (cls != null && !cls.equals(ImageCapture.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            i(ImageCapture.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class Defaults {

        /* renamed from: a  reason: collision with root package name */
        private static final ImageCaptureConfig f3151a = new Builder().g(4).h(0).b();

        @NonNull
        public ImageCaptureConfig a() {
            return f3151a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ImageCaptureRequest {

        /* renamed from: a  reason: collision with root package name */
        final int f3152a;

        /* renamed from: b  reason: collision with root package name */
        final int f3153b;

        /* renamed from: c  reason: collision with root package name */
        private final Rational f3154c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final Executor f3155d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final OnImageCapturedCallback f3156e;

        /* renamed from: f  reason: collision with root package name */
        AtomicBoolean f3157f = new AtomicBoolean(false);

        /* renamed from: g  reason: collision with root package name */
        private final Rect f3158g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private final Matrix f3159h;

        ImageCaptureRequest(int i8, int i9, Rational rational, Rect rect, @NonNull Matrix matrix, @NonNull Executor executor, @NonNull OnImageCapturedCallback onImageCapturedCallback) {
            this.f3152a = i8;
            this.f3153b = i9;
            if (rational != null) {
                Preconditions.b(!rational.isZero(), "Target ratio cannot be zero");
                Preconditions.b(rational.floatValue() > 0.0f, "Target ratio must be positive");
            }
            this.f3154c = rational;
            this.f3158g = rect;
            this.f3159h = matrix;
            this.f3155d = executor;
            this.f3156e = onImageCapturedCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(ImageProxy imageProxy) {
            this.f3156e.a(imageProxy);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i8, String str, Throwable th) {
            this.f3156e.b(new ImageCaptureException(i8, str, th));
        }

        void c(ImageProxy imageProxy) {
            Size size;
            int s7;
            if (!this.f3157f.compareAndSet(false, true)) {
                imageProxy.close();
                return;
            }
            if (ImageCapture.M.b(imageProxy)) {
                try {
                    ByteBuffer b8 = imageProxy.n0()[0].b();
                    b8.rewind();
                    byte[] bArr = new byte[b8.capacity()];
                    b8.get(bArr);
                    Exif k8 = Exif.k(new ByteArrayInputStream(bArr));
                    b8.rewind();
                    size = new Size(k8.u(), k8.p());
                    s7 = k8.s();
                } catch (IOException e8) {
                    f(1, "Unable to parse JPEG exif", e8);
                    imageProxy.close();
                    return;
                }
            } else {
                size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
                s7 = this.f3152a;
            }
            final SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy, size, ImmutableImageInfo.f(imageProxy.O0().b(), imageProxy.O0().d(), s7, this.f3159h));
            settableImageProxy.W(ImageCapture.b0(this.f3158g, this.f3154c, this.f3152a, size, s7));
            try {
                this.f3155d.execute(new Runnable() { // from class: androidx.camera.core.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageCapture.ImageCaptureRequest.this.d(settableImageProxy);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.c("ImageCapture", "Unable to post to the supplied executor.");
                imageProxy.close();
            }
        }

        void f(final int i8, final String str, final Throwable th) {
            if (!this.f3157f.compareAndSet(false, true)) {
                return;
            }
            try {
                this.f3155d.execute(new Runnable() { // from class: androidx.camera.core.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageCapture.ImageCaptureRequest.this.e(i8, str, th);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.c("ImageCapture", "Unable to post to the supplied executor.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ImageCaptureRequestProcessor implements ForwardingImageProxy.OnImageCloseListener {

        /* renamed from: e  reason: collision with root package name */
        private final ImageCaptor f3164e;

        /* renamed from: f  reason: collision with root package name */
        private final int f3165f;

        /* renamed from: g  reason: collision with root package name */
        private final RequestProcessCallback f3166g;

        /* renamed from: a  reason: collision with root package name */
        private final Deque<ImageCaptureRequest> f3160a = new ArrayDeque();

        /* renamed from: b  reason: collision with root package name */
        ImageCaptureRequest f3161b = null;

        /* renamed from: c  reason: collision with root package name */
        ListenableFuture<ImageProxy> f3162c = null;

        /* renamed from: d  reason: collision with root package name */
        int f3163d = 0;

        /* renamed from: h  reason: collision with root package name */
        final Object f3167h = new Object();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface ImageCaptor {
            @NonNull
            ListenableFuture<ImageProxy> a(@NonNull ImageCaptureRequest imageCaptureRequest);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface RequestProcessCallback {
            void a(@NonNull ImageCaptureRequest imageCaptureRequest);
        }

        ImageCaptureRequestProcessor(int i8, @NonNull ImageCaptor imageCaptor, RequestProcessCallback requestProcessCallback) {
            this.f3165f = i8;
            this.f3164e = imageCaptor;
            this.f3166g = requestProcessCallback;
        }

        @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
        public void a(@NonNull ImageProxy imageProxy) {
            synchronized (this.f3167h) {
                this.f3163d--;
                CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageCapture.ImageCaptureRequestProcessor.this.c();
                    }
                });
            }
        }

        public void b(@NonNull Throwable th) {
            ImageCaptureRequest imageCaptureRequest;
            ListenableFuture<ImageProxy> listenableFuture;
            ArrayList<ImageCaptureRequest> arrayList;
            synchronized (this.f3167h) {
                imageCaptureRequest = this.f3161b;
                this.f3161b = null;
                listenableFuture = this.f3162c;
                this.f3162c = null;
                arrayList = new ArrayList(this.f3160a);
                this.f3160a.clear();
            }
            if (imageCaptureRequest != null && listenableFuture != null) {
                imageCaptureRequest.f(ImageCapture.i0(th), th.getMessage(), th);
                listenableFuture.cancel(true);
            }
            for (ImageCaptureRequest imageCaptureRequest2 : arrayList) {
                imageCaptureRequest2.f(ImageCapture.i0(th), th.getMessage(), th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f3167h) {
                if (this.f3161b != null) {
                    return;
                }
                if (this.f3163d >= this.f3165f) {
                    Logger.k("ImageCapture", "Too many acquire images. Close image to be able to process next.");
                    return;
                }
                final ImageCaptureRequest poll = this.f3160a.poll();
                if (poll == null) {
                    return;
                }
                this.f3161b = poll;
                RequestProcessCallback requestProcessCallback = this.f3166g;
                if (requestProcessCallback != null) {
                    requestProcessCallback.a(poll);
                }
                ListenableFuture<ImageProxy> a8 = this.f3164e.a(poll);
                this.f3162c = a8;
                Futures.b(a8, new FutureCallback<ImageProxy>() { // from class: androidx.camera.core.ImageCapture.ImageCaptureRequestProcessor.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    /* renamed from: a */
                    public void onSuccess(ImageProxy imageProxy) {
                        synchronized (ImageCaptureRequestProcessor.this.f3167h) {
                            Preconditions.g(imageProxy);
                            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxy);
                            singleCloseImageProxy.a(ImageCaptureRequestProcessor.this);
                            ImageCaptureRequestProcessor.this.f3163d++;
                            poll.c(singleCloseImageProxy);
                            ImageCaptureRequestProcessor imageCaptureRequestProcessor = ImageCaptureRequestProcessor.this;
                            imageCaptureRequestProcessor.f3161b = null;
                            imageCaptureRequestProcessor.f3162c = null;
                            imageCaptureRequestProcessor.c();
                        }
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(@NonNull Throwable th) {
                        String str;
                        synchronized (ImageCaptureRequestProcessor.this.f3167h) {
                            if (!(th instanceof CancellationException)) {
                                ImageCaptureRequest imageCaptureRequest = poll;
                                int i02 = ImageCapture.i0(th);
                                if (th != null) {
                                    str = th.getMessage();
                                } else {
                                    str = "Unknown error";
                                }
                                imageCaptureRequest.f(i02, str, th);
                            }
                            ImageCaptureRequestProcessor imageCaptureRequestProcessor = ImageCaptureRequestProcessor.this;
                            imageCaptureRequestProcessor.f3161b = null;
                            imageCaptureRequestProcessor.f3162c = null;
                            imageCaptureRequestProcessor.c();
                        }
                    }
                }, CameraXExecutors.d());
            }
        }

        @NonNull
        public List<ImageCaptureRequest> d() {
            ArrayList arrayList;
            ListenableFuture<ImageProxy> listenableFuture;
            synchronized (this.f3167h) {
                arrayList = new ArrayList(this.f3160a);
                this.f3160a.clear();
                ImageCaptureRequest imageCaptureRequest = this.f3161b;
                this.f3161b = null;
                if (imageCaptureRequest != null && (listenableFuture = this.f3162c) != null && listenableFuture.cancel(true)) {
                    arrayList.add(0, imageCaptureRequest);
                }
            }
            return arrayList;
        }

        public void e(@NonNull ImageCaptureRequest imageCaptureRequest) {
            int i8;
            synchronized (this.f3167h) {
                this.f3160a.offer(imageCaptureRequest);
                Locale locale = Locale.US;
                Object[] objArr = new Object[2];
                if (this.f3161b != null) {
                    i8 = 1;
                } else {
                    i8 = 0;
                }
                objArr[0] = Integer.valueOf(i8);
                objArr[1] = Integer.valueOf(this.f3160a.size());
                Logger.a("ImageCapture", String.format(locale, "Send image capture request [current, pending] = [%d, %d]", objArr));
                c();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Metadata {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3170a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3171b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3172c;

        /* renamed from: d  reason: collision with root package name */
        private Location f3173d;

        public Location a() {
            return this.f3173d;
        }

        public boolean b() {
            return this.f3170a;
        }

        public boolean c() {
            return this.f3172c;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnImageCapturedCallback {
        public void a(@NonNull ImageProxy imageProxy) {
        }

        public void b(@NonNull ImageCaptureException imageCaptureException) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnImageSavedCallback {
        void a(@NonNull OutputFileResults outputFileResults);

        void b(@NonNull ImageCaptureException imageCaptureException);
    }

    /* loaded from: classes.dex */
    public static final class OutputFileOptions {

        /* renamed from: a  reason: collision with root package name */
        private final File f3174a;

        /* renamed from: b  reason: collision with root package name */
        private final ContentResolver f3175b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f3176c;

        /* renamed from: d  reason: collision with root package name */
        private final ContentValues f3177d;

        /* renamed from: e  reason: collision with root package name */
        private final OutputStream f3178e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private final Metadata f3179f;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private File f3180a;

            /* renamed from: b  reason: collision with root package name */
            private ContentResolver f3181b;

            /* renamed from: c  reason: collision with root package name */
            private Uri f3182c;

            /* renamed from: d  reason: collision with root package name */
            private ContentValues f3183d;

            /* renamed from: e  reason: collision with root package name */
            private OutputStream f3184e;

            /* renamed from: f  reason: collision with root package name */
            private Metadata f3185f;

            public Builder(@NonNull File file) {
                this.f3180a = file;
            }

            @NonNull
            public OutputFileOptions a() {
                return new OutputFileOptions(this.f3180a, this.f3181b, this.f3182c, this.f3183d, this.f3184e, this.f3185f);
            }
        }

        OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, Metadata metadata) {
            this.f3174a = file;
            this.f3175b = contentResolver;
            this.f3176c = uri;
            this.f3177d = contentValues;
            this.f3178e = outputStream;
            this.f3179f = metadata == null ? new Metadata() : metadata;
        }

        public ContentResolver a() {
            return this.f3175b;
        }

        public ContentValues b() {
            return this.f3177d;
        }

        public File c() {
            return this.f3174a;
        }

        @NonNull
        public Metadata d() {
            return this.f3179f;
        }

        public OutputStream e() {
            return this.f3178e;
        }

        public Uri f() {
            return this.f3176c;
        }
    }

    /* loaded from: classes.dex */
    public static class OutputFileResults {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f3186a;

        public OutputFileResults(Uri uri) {
            this.f3186a = uri;
        }
    }

    ImageCapture(@NonNull ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        this.f3121m = false;
        this.f3122n = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.o
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void a(ImageReaderProxy imageReaderProxy) {
                ImageCapture.v0(imageReaderProxy);
            }
        };
        this.f3125q = new AtomicReference<>(null);
        this.f3127s = -1;
        this.f3128t = null;
        this.f3134z = false;
        this.D = Futures.h(null);
        this.K = new ImageCaptureControl() { // from class: androidx.camera.core.ImageCapture.7
            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            @NonNull
            public ListenableFuture<Void> a(@NonNull List<CaptureConfig> list) {
                return ImageCapture.this.H0(list);
            }

            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            public void b() {
                ImageCapture.this.D0();
            }

            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            public void c() {
                ImageCapture.this.M0();
            }
        };
        ImageCaptureConfig imageCaptureConfig2 = (ImageCaptureConfig) g();
        if (imageCaptureConfig2.b(ImageCaptureConfig.B)) {
            this.f3124p = imageCaptureConfig2.I();
        } else {
            this.f3124p = 1;
        }
        this.f3126r = imageCaptureConfig2.L(0);
        Executor executor = (Executor) Preconditions.g(imageCaptureConfig2.N(CameraXExecutors.c()));
        this.f3123o = executor;
        this.H = CameraXExecutors.f(executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A0(CallbackToFutureAdapter.Completer completer, ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy b8 = imageReaderProxy.b();
            if (b8 != null) {
                if (!completer.c(b8)) {
                    b8.close();
                }
            } else {
                completer.f(new IllegalStateException("Unable to acquire image"));
            }
        } catch (IllegalStateException e8) {
            completer.f(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object C0(ImageCaptureRequest imageCaptureRequest, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.B.f(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.q
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void a(ImageReaderProxy imageReaderProxy) {
                ImageCapture.A0(CallbackToFutureAdapter.Completer.this, imageReaderProxy);
            }
        }, CameraXExecutors.d());
        D0();
        final ListenableFuture<Void> q02 = q0(imageCaptureRequest);
        Futures.b(q02, new FutureCallback<Void>() { // from class: androidx.camera.core.ImageCapture.5
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            /* renamed from: a */
            public void onSuccess(Void r12) {
                ImageCapture.this.M0();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                ImageCapture.this.M0();
                completer.f(th);
            }
        }, this.f3129u);
        completer.a(new Runnable() { // from class: androidx.camera.core.r
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFuture.this.cancel(true);
            }
        }, CameraXExecutors.a());
        return "takePictureInternal";
    }

    private void E0(@NonNull Executor executor, @NonNull final OnImageCapturedCallback onImageCapturedCallback, boolean z7) {
        CameraInternal d8 = d();
        if (d8 == null) {
            executor.execute(new Runnable() { // from class: androidx.camera.core.z
                @Override // java.lang.Runnable
                public final void run() {
                    ImageCapture.this.w0(onImageCapturedCallback);
                }
            });
            return;
        }
        ImageCaptureRequestProcessor imageCaptureRequestProcessor = this.G;
        if (imageCaptureRequestProcessor == null) {
            executor.execute(new Runnable() { // from class: androidx.camera.core.a0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageCapture.x0(ImageCapture.OnImageCapturedCallback.this);
                }
            });
        } else {
            imageCaptureRequestProcessor.e(new ImageCaptureRequest(k(d8), k0(d8, z7), this.f3128t, p(), l(), executor, onImageCapturedCallback));
        }
    }

    private void F0(@NonNull Executor executor, OnImageCapturedCallback onImageCapturedCallback, OnImageSavedCallback onImageSavedCallback) {
        ImageCaptureException imageCaptureException = new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", null);
        if (onImageCapturedCallback != null) {
            onImageCapturedCallback.b(imageCaptureException);
        } else if (onImageSavedCallback != null) {
            onImageSavedCallback.b(imageCaptureException);
        } else {
            throw new IllegalArgumentException("Must have either in-memory or on-disk callback.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ListenableFuture<ImageProxy> J0(@NonNull final ImageCaptureRequest imageCaptureRequest) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.b0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object a(CallbackToFutureAdapter.Completer completer) {
                Object C0;
                C0 = ImageCapture.this.C0(imageCaptureRequest, completer);
                return C0;
            }
        });
    }

    private void K0(@NonNull Executor executor, OnImageCapturedCallback onImageCapturedCallback, OnImageSavedCallback onImageSavedCallback, OutputFileOptions outputFileOptions) {
        Threads.a();
        Log.d("ImageCapture", "takePictureWithNode");
        CameraInternal d8 = d();
        if (d8 == null) {
            F0(executor, onImageCapturedCallback, onImageSavedCallback);
        } else {
            this.J.i(TakePictureRequest.q(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, m0(), l(), k(d8), l0(), g0(), this.A.p()));
        }
    }

    private void L0() {
        synchronized (this.f3125q) {
            if (this.f3125q.get() != null) {
                return;
            }
            e().d(j0());
        }
    }

    private void Y() {
        if (this.G != null) {
            this.G.b(new CameraClosedException("Camera is closed."));
        }
    }

    private void a0() {
        Log.d("ImageCapture", "clearPipelineWithNode");
        Threads.a();
        this.I.a();
        this.I = null;
        this.J.d();
        this.J = null;
    }

    @NonNull
    static Rect b0(Rect rect, Rational rational, int i8, @NonNull Size size, int i9) {
        if (rect != null) {
            return ImageUtil.b(rect, i8, size, i9);
        }
        if (rational != null) {
            if (i9 % 180 != 0) {
                rational = new Rational(rational.getDenominator(), rational.getNumerator());
            }
            if (ImageUtil.g(size, rational)) {
                Rect a8 = ImageUtil.a(size, rational);
                Objects.requireNonNull(a8);
                return a8;
            }
        }
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    private SessionConfig.Builder d0(@NonNull final String str, @NonNull ImageCaptureConfig imageCaptureConfig, @NonNull Size size) {
        boolean z7;
        Threads.a();
        boolean z8 = false;
        Log.d("ImageCapture", String.format("createPipelineWithNode(cameraId: %s, resolution: %s)", str, size));
        if (this.I == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.i(z7);
        this.I = new ImagePipeline(imageCaptureConfig, size);
        if (this.J == null) {
            z8 = true;
        }
        Preconditions.i(z8);
        this.J = new TakePictureManager(this.K, this.I);
        SessionConfig.Builder f8 = this.I.f();
        if (Build.VERSION.SDK_INT >= 23 && g0() == 2) {
            e().a(f8);
        }
        f8.f(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.y
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                ImageCapture.this.t0(str, sessionConfig, sessionError);
            }
        });
        return f8;
    }

    static boolean e0(@NonNull MutableConfig mutableConfig) {
        Boolean bool = Boolean.TRUE;
        Config.Option<Boolean> option = ImageCaptureConfig.I;
        Boolean bool2 = Boolean.FALSE;
        boolean z7 = false;
        if (bool.equals(mutableConfig.e(option, bool2))) {
            boolean z8 = true;
            int i8 = Build.VERSION.SDK_INT;
            if (i8 < 26) {
                Logger.k("ImageCapture", "Software JPEG only supported on API 26+, but current API level is " + i8);
                z8 = false;
            }
            Integer num = (Integer) mutableConfig.e(ImageCaptureConfig.F, null);
            if (num != null && num.intValue() != 256) {
                Logger.k("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            } else {
                z7 = z8;
            }
            if (!z7) {
                Logger.k("ImageCapture", "Unable to support software JPEG. Disabling.");
                mutableConfig.o(option, bool2);
            }
        }
        return z7;
    }

    private CaptureBundle f0(CaptureBundle captureBundle) {
        List<CaptureStage> a8 = this.f3131w.a();
        if (a8 != null && !a8.isEmpty()) {
            return CaptureBundles.a(a8);
        }
        return captureBundle;
    }

    private int h0(@NonNull ImageCaptureConfig imageCaptureConfig) {
        List<CaptureStage> a8;
        CaptureBundle H = imageCaptureConfig.H(null);
        if (H == null || (a8 = H.a()) == null) {
            return 1;
        }
        return a8.size();
    }

    static int i0(Throwable th) {
        if (th instanceof CameraClosedException) {
            return 3;
        }
        if (th instanceof ImageCaptureException) {
            return ((ImageCaptureException) th).a();
        }
        return 0;
    }

    private int k0(@NonNull CameraInternal cameraInternal, boolean z7) {
        if (z7) {
            int k8 = k(cameraInternal);
            Size c8 = c();
            Objects.requireNonNull(c8);
            Rect b02 = b0(p(), this.f3128t, k8, c8, k8);
            if (ImageUtil.m(c8.getWidth(), c8.getHeight(), b02.width(), b02.height())) {
                if (this.f3124p == 0) {
                    return 100;
                }
                return 95;
            }
            return l0();
        }
        return l0();
    }

    private int l0() {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) g();
        if (imageCaptureConfig.b(ImageCaptureConfig.K)) {
            return imageCaptureConfig.O();
        }
        int i8 = this.f3124p;
        if (i8 != 0) {
            if (i8 != 1 && i8 != 2) {
                throw new IllegalStateException("CaptureMode " + this.f3124p + " is invalid");
            }
            return 95;
        }
        return 100;
    }

    @NonNull
    private Rect m0() {
        Rect p8 = p();
        Size c8 = c();
        Objects.requireNonNull(c8);
        if (p8 != null) {
            return p8;
        }
        if (ImageUtil.f(this.f3128t)) {
            CameraInternal d8 = d();
            Objects.requireNonNull(d8);
            int k8 = k(d8);
            Rational rational = new Rational(this.f3128t.getDenominator(), this.f3128t.getNumerator());
            if (!TransformUtils.f(k8)) {
                rational = this.f3128t;
            }
            Rect a8 = ImageUtil.a(c8, rational);
            Objects.requireNonNull(a8);
            return a8;
        }
        return new Rect(0, 0, c8.getWidth(), c8.getHeight());
    }

    private static boolean n0(List<Pair<Integer, Size[]>> list, int i8) {
        if (list == null) {
            return false;
        }
        for (Pair<Integer, Size[]> pair : list) {
            if (((Integer) pair.first).equals(Integer.valueOf(i8))) {
                return true;
            }
        }
        return false;
    }

    private boolean o0() {
        Threads.a();
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) g();
        if (imageCaptureConfig.M() != null || p0() || this.f3133y != null || h0(imageCaptureConfig) > 1) {
            return false;
        }
        Integer num = (Integer) imageCaptureConfig.e(ImageInputConfig.f3652f, Integer.valueOf((int) Spliterator.NONNULL));
        Objects.requireNonNull(num);
        if (num.intValue() != 256) {
            return false;
        }
        return this.f3121m;
    }

    private boolean p0() {
        if (d() == null || d().e().G(null) == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(YuvToJpegProcessor yuvToJpegProcessor, ImageCaptureRequest imageCaptureRequest) {
        if (Build.VERSION.SDK_INT >= 26) {
            yuvToJpegProcessor.g(imageCaptureRequest.f3153b);
            yuvToJpegProcessor.h(imageCaptureRequest.f3152a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(String str, ImageCaptureConfig imageCaptureConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        List<ImageCaptureRequest> emptyList;
        ImageCaptureRequestProcessor imageCaptureRequestProcessor = this.G;
        if (imageCaptureRequestProcessor != null) {
            emptyList = imageCaptureRequestProcessor.d();
        } else {
            emptyList = Collections.emptyList();
        }
        Z();
        if (q(str)) {
            this.A = c0(str, imageCaptureConfig, size);
            if (this.G != null) {
                for (ImageCaptureRequest imageCaptureRequest : emptyList) {
                    this.G.e(imageCaptureRequest);
                }
            }
            J(this.A.m());
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(String str, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (q(str)) {
            this.J.j();
            J(this.A.m());
            u();
            this.J.k();
            return;
        }
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u0(ImageCaptureRequest imageCaptureRequest, String str, Throwable th) {
        Logger.c("ImageCapture", "Processing image failed! " + str);
        imageCaptureRequest.f(2, str, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v0(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy b8 = imageReaderProxy.b();
            Log.d("ImageCapture", "Discarding ImageProxy which was inadvertently acquired: " + b8);
            if (b8 != null) {
                b8.close();
            }
        } catch (IllegalStateException e8) {
            Log.e("ImageCapture", "Failed to acquire latest image.", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(OnImageCapturedCallback onImageCapturedCallback) {
        onImageCapturedCallback.b(new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x0(OnImageCapturedCallback onImageCapturedCallback) {
        onImageCapturedCallback.b(new ImageCaptureException(0, "Request is canceled", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void y0(List list) {
        return null;
    }

    @Override // androidx.camera.core.UseCase
    public void B() {
        ListenableFuture<Void> listenableFuture = this.D;
        Y();
        Z();
        this.f3134z = false;
        final ExecutorService executorService = this.f3129u;
        Objects.requireNonNull(executorService);
        listenableFuture.f(new Runnable() { // from class: androidx.camera.core.x
            @Override // java.lang.Runnable
            public final void run() {
                executorService.shutdown();
            }
        }, CameraXExecutors.a());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.UseCaseConfig] */
    /* JADX WARN: Type inference failed for: r8v22, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @NonNull
    protected UseCaseConfig<?> C(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        boolean z7;
        ?? b8 = builder.b();
        Config.Option<CaptureProcessor> option = ImageCaptureConfig.E;
        if (b8.e(option, null) != null && Build.VERSION.SDK_INT >= 29) {
            Logger.e("ImageCapture", "Requesting software JPEG due to a CaptureProcessor is set.");
            builder.a().o(ImageCaptureConfig.I, Boolean.TRUE);
        } else if (cameraInfoInternal.d().a(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            MutableConfig a8 = builder.a();
            Config.Option<Boolean> option2 = ImageCaptureConfig.I;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(a8.e(option2, bool2))) {
                Logger.k("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                Logger.e("ImageCapture", "Requesting software JPEG due to device quirk.");
                builder.a().o(option2, bool2);
            }
        }
        boolean e02 = e0(builder.a());
        Integer num = (Integer) builder.a().e(ImageCaptureConfig.F, null);
        boolean z8 = false;
        int i8 = 35;
        if (num != null) {
            if (builder.a().e(option, null) == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.b(z7, "Cannot set buffer format with CaptureProcessor defined.");
            MutableConfig a9 = builder.a();
            Config.Option<Integer> option3 = ImageInputConfig.f3652f;
            if (!e02) {
                i8 = num.intValue();
            }
            a9.o(option3, Integer.valueOf(i8));
        } else if (builder.a().e(option, null) == null && !e02) {
            List list = (List) builder.a().e(ImageOutputConfig.f3659m, null);
            if (list == null) {
                builder.a().o(ImageInputConfig.f3652f, Integer.valueOf((int) Spliterator.NONNULL));
            } else if (n0(list, Spliterator.NONNULL)) {
                builder.a().o(ImageInputConfig.f3652f, Integer.valueOf((int) Spliterator.NONNULL));
            } else if (n0(list, 35)) {
                builder.a().o(ImageInputConfig.f3652f, 35);
            }
        } else {
            builder.a().o(ImageInputConfig.f3652f, 35);
        }
        Integer num2 = (Integer) builder.a().e(ImageCaptureConfig.G, 2);
        Preconditions.h(num2, "Maximum outstanding image count must be at least 1");
        if (num2.intValue() >= 1) {
            z8 = true;
        }
        Preconditions.b(z8, "Maximum outstanding image count must be at least 1");
        return builder.b();
    }

    void D0() {
        synchronized (this.f3125q) {
            if (this.f3125q.get() != null) {
                return;
            }
            this.f3125q.set(Integer.valueOf(j0()));
        }
    }

    @Override // androidx.camera.core.UseCase
    public void E() {
        Y();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    protected Size F(@NonNull Size size) {
        SessionConfig.Builder c02 = c0(f(), (ImageCaptureConfig) g(), size);
        this.A = c02;
        J(c02.m());
        s();
        return size;
    }

    public void G0(@NonNull Rational rational) {
        this.f3128t = rational;
    }

    ListenableFuture<Void> H0(@NonNull List<CaptureConfig> list) {
        Threads.a();
        return Futures.o(e().b(list, this.f3124p, this.f3126r), new Function() { // from class: androidx.camera.core.p
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Void y02;
                y02 = ImageCapture.y0((List) obj);
                return y02;
            }
        }, CameraXExecutors.a());
    }

    /* renamed from: I0 */
    public void z0(@NonNull final OutputFileOptions outputFileOptions, @NonNull final Executor executor, @NonNull final OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.t
                @Override // java.lang.Runnable
                public final void run() {
                    ImageCapture.this.z0(outputFileOptions, executor, onImageSavedCallback);
                }
            });
        } else if (o0()) {
            K0(executor, null, onImageSavedCallback, outputFileOptions);
        } else {
            final ImageSaver.OnImageSavedCallback onImageSavedCallback2 = new ImageSaver.OnImageSavedCallback() { // from class: androidx.camera.core.ImageCapture.3
                @Override // androidx.camera.core.ImageSaver.OnImageSavedCallback
                public void a(@NonNull OutputFileResults outputFileResults) {
                    onImageSavedCallback.a(outputFileResults);
                }

                @Override // androidx.camera.core.ImageSaver.OnImageSavedCallback
                public void b(@NonNull ImageSaver.SaveError saveError, @NonNull String str, Throwable th) {
                    int i8;
                    if (saveError == ImageSaver.SaveError.FILE_IO_FAILED) {
                        i8 = 1;
                    } else {
                        i8 = 0;
                    }
                    onImageSavedCallback.b(new ImageCaptureException(i8, str, th));
                }
            };
            final int l02 = l0();
            E0(CameraXExecutors.d(), new OnImageCapturedCallback() { // from class: androidx.camera.core.ImageCapture.4
                @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
                public void a(@NonNull ImageProxy imageProxy) {
                    ImageCapture.this.f3123o.execute(new ImageSaver(imageProxy, outputFileOptions, imageProxy.O0().c(), l02, executor, ImageCapture.this.H, onImageSavedCallback2));
                }

                @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
                public void b(@NonNull ImageCaptureException imageCaptureException) {
                    onImageSavedCallback.b(imageCaptureException);
                }
            }, true);
        }
    }

    void M0() {
        synchronized (this.f3125q) {
            Integer andSet = this.f3125q.getAndSet(null);
            if (andSet == null) {
                return;
            }
            if (andSet.intValue() != j0()) {
                L0();
            }
        }
    }

    void Z() {
        Threads.a();
        if (o0()) {
            a0();
            return;
        }
        ImageCaptureRequestProcessor imageCaptureRequestProcessor = this.G;
        if (imageCaptureRequestProcessor != null) {
            imageCaptureRequestProcessor.b(new CancellationException("Request is canceled."));
            this.G = null;
        }
        DeferrableSurface deferrableSurface = this.F;
        this.F = null;
        this.B = null;
        this.C = null;
        this.D = Futures.h(null);
        if (deferrableSurface != null) {
            deferrableSurface.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.camera.core.impl.SessionConfig.Builder c0(@androidx.annotation.NonNull final java.lang.String r15, @androidx.annotation.NonNull final androidx.camera.core.impl.ImageCaptureConfig r16, @androidx.annotation.NonNull final android.util.Size r17) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageCapture.c0(java.lang.String, androidx.camera.core.impl.ImageCaptureConfig, android.util.Size):androidx.camera.core.impl.SessionConfig$Builder");
    }

    public int g0() {
        return this.f3124p;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> h(boolean z7, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a8 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE, g0());
        if (z7) {
            a8 = androidx.camera.core.impl.g.b(a8, L.a());
        }
        if (a8 == null) {
            return null;
        }
        return o(a8).b();
    }

    public int j0() {
        int i8;
        synchronized (this.f3125q) {
            i8 = this.f3127s;
            if (i8 == -1) {
                i8 = ((ImageCaptureConfig) g()).K(2);
            }
        }
        return i8;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig.Builder<?, ?, ?> o(@NonNull Config config) {
        return Builder.d(config);
    }

    ListenableFuture<Void> q0(@NonNull final ImageCaptureRequest imageCaptureRequest) {
        CaptureBundle f02;
        String str;
        Logger.a("ImageCapture", "issueTakePicture");
        ArrayList arrayList = new ArrayList();
        if (this.C != null) {
            f02 = f0(CaptureBundles.c());
            if (f02 == null) {
                return Futures.f(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            List<CaptureStage> a8 = f02.a();
            if (a8 == null) {
                return Futures.f(new IllegalArgumentException("ImageCapture has CaptureBundle with null capture stages"));
            }
            if (this.f3133y == null && a8.size() > 1) {
                return Futures.f(new IllegalArgumentException("No CaptureProcessor can be found to process the images captured for multiple CaptureStages."));
            }
            if (a8.size() > this.f3132x) {
                return Futures.f(new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size"));
            }
            this.C.s(f02);
            this.C.t(CameraXExecutors.a(), new ProcessingImageReader.OnProcessingErrorCallback() { // from class: androidx.camera.core.s
                @Override // androidx.camera.core.ProcessingImageReader.OnProcessingErrorCallback
                public final void a(String str2, Throwable th) {
                    ImageCapture.u0(ImageCapture.ImageCaptureRequest.this, str2, th);
                }
            });
            str = this.C.n();
        } else {
            f02 = f0(CaptureBundles.c());
            if (f02 == null) {
                return Futures.f(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            List<CaptureStage> a9 = f02.a();
            if (a9 == null) {
                return Futures.f(new IllegalArgumentException("ImageCapture has CaptureBundle with null capture stages"));
            }
            if (a9.size() > 1) {
                return Futures.f(new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1."));
            }
            str = null;
        }
        for (CaptureStage captureStage : f02.a()) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.p(this.f3130v.g());
            builder.e(this.f3130v.d());
            builder.a(this.A.p());
            builder.f(this.F);
            if (i() == 256) {
                if (M.a()) {
                    builder.d(CaptureConfig.f3613h, Integer.valueOf(imageCaptureRequest.f3152a));
                }
                builder.d(CaptureConfig.f3614i, Integer.valueOf(imageCaptureRequest.f3153b));
            }
            builder.e(captureStage.a().d());
            if (str != null) {
                builder.g(str, Integer.valueOf(captureStage.getId()));
            }
            builder.c(this.E);
            arrayList.add(builder.h());
        }
        return H0(arrayList);
    }

    @NonNull
    public String toString() {
        return "ImageCapture:" + j();
    }

    @Override // androidx.camera.core.UseCase
    public void y() {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) g();
        this.f3130v = CaptureConfig.Builder.j(imageCaptureConfig).h();
        this.f3133y = imageCaptureConfig.J(null);
        this.f3132x = imageCaptureConfig.P(2);
        this.f3131w = imageCaptureConfig.H(CaptureBundles.c());
        this.f3134z = imageCaptureConfig.R();
        Preconditions.h(d(), "Attached camera cannot be null");
        this.f3129u = Executors.newFixedThreadPool(1, new ThreadFactory() { // from class: androidx.camera.core.ImageCapture.6

            /* renamed from: f  reason: collision with root package name */
            private final AtomicInteger f3147f = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "CameraX-image_capture_" + this.f3147f.getAndIncrement());
            }
        });
    }

    @Override // androidx.camera.core.UseCase
    protected void z() {
        L0();
    }
}
