package androidx.camera.core;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import com.google.common.util.concurrent.ListenableFuture;
import j$.util.Spliterator;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: classes.dex */
public final class VideoCapture extends UseCase {
    public static final Defaults K = new Defaults();
    private static final int[] L = {8, 6, 5, 4};
    private volatile AudioRecord A;
    private volatile int B;
    private volatile boolean C;
    private int D;
    private int E;
    private int F;
    private DeferrableSurface G;
    private final AtomicBoolean H;
    private VideoEncoderInitStatus I;
    private Throwable J;

    /* renamed from: m  reason: collision with root package name */
    private final Object f3342m;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f3343n;

    /* renamed from: o  reason: collision with root package name */
    private final AtomicBoolean f3344o;

    /* renamed from: p  reason: collision with root package name */
    private HandlerThread f3345p;

    /* renamed from: q  reason: collision with root package name */
    private Handler f3346q;

    /* renamed from: r  reason: collision with root package name */
    private HandlerThread f3347r;

    /* renamed from: s  reason: collision with root package name */
    private Handler f3348s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    MediaCodec f3349t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    private MediaCodec f3350u;

    /* renamed from: v  reason: collision with root package name */
    private ListenableFuture<Void> f3351v;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private SessionConfig.Builder f3352w;

    /* renamed from: x  reason: collision with root package name */
    private int f3353x;

    /* renamed from: y  reason: collision with root package name */
    private int f3354y;

    /* renamed from: z  reason: collision with root package name */
    Surface f3355z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static int a(MediaCodec.CodecException codecException) {
            int errorCode;
            errorCode = codecException.getErrorCode();
            return errorCode;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder implements UseCaseConfig.Builder<VideoCapture, VideoCaptureConfig, Builder> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableOptionsBundle f3359a;

        public Builder() {
            this(MutableOptionsBundle.L());
        }

        @NonNull
        static Builder c(@NonNull Config config) {
            return new Builder(MutableOptionsBundle.M(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig a() {
            return this.f3359a;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        /* renamed from: d */
        public VideoCaptureConfig b() {
            return new VideoCaptureConfig(OptionsBundle.J(this.f3359a));
        }

        @NonNull
        public Builder e(int i8) {
            a().o(VideoCaptureConfig.E, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder f(int i8) {
            a().o(VideoCaptureConfig.G, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder g(int i8) {
            a().o(VideoCaptureConfig.H, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder h(int i8) {
            a().o(VideoCaptureConfig.F, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder i(int i8) {
            a().o(VideoCaptureConfig.C, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder j(int i8) {
            a().o(VideoCaptureConfig.D, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder k(@NonNull Size size) {
            a().o(ImageOutputConfig.f3658l, size);
            return this;
        }

        @NonNull
        public Builder l(int i8) {
            a().o(UseCaseConfig.f3720r, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder m(int i8) {
            a().o(ImageOutputConfig.f3653g, Integer.valueOf(i8));
            return this;
        }

        @NonNull
        public Builder n(@NonNull Class<VideoCapture> cls) {
            a().o(TargetConfig.f3911x, cls);
            if (a().e(TargetConfig.f3910w, null) == null) {
                o(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public Builder o(@NonNull String str) {
            a().o(TargetConfig.f3910w, str);
            return this;
        }

        @NonNull
        public Builder p(int i8) {
            a().o(VideoCaptureConfig.B, Integer.valueOf(i8));
            return this;
        }

        private Builder(@NonNull MutableOptionsBundle mutableOptionsBundle) {
            this.f3359a = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.e(TargetConfig.f3911x, null);
            if (cls != null && !cls.equals(VideoCapture.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            n(VideoCapture.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class Defaults {

        /* renamed from: a  reason: collision with root package name */
        private static final Size f3360a;

        /* renamed from: b  reason: collision with root package name */
        private static final VideoCaptureConfig f3361b;

        static {
            Size size = new Size(1920, 1080);
            f3360a = size;
            f3361b = new Builder().p(30).i(8388608).j(1).e(64000).h(8000).f(1).g(Spliterator.IMMUTABLE).k(size).l(3).m(1).b();
        }

        @NonNull
        public VideoCaptureConfig a() {
            return f3361b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum VideoEncoderInitStatus {
        VIDEO_ENCODER_INIT_STATUS_UNINITIALIZED,
        VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED,
        VIDEO_ENCODER_INIT_STATUS_INSUFFICIENT_RESOURCE,
        VIDEO_ENCODER_INIT_STATUS_RESOURCE_RECLAIMED
    }

    private AudioRecord O(VideoCaptureConfig videoCaptureConfig) {
        int i8;
        if (this.D == 1) {
            i8 = 16;
        } else {
            i8 = 12;
        }
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(this.E, i8, 2);
            if (minBufferSize <= 0) {
                minBufferSize = videoCaptureConfig.J();
            }
            int i9 = minBufferSize;
            AudioRecord audioRecord = new AudioRecord(5, this.E, i8, 2, i9 * 2);
            if (audioRecord.getState() == 1) {
                this.B = i9;
                Logger.e("VideoCapture", "source: 5 audioSampleRate: " + this.E + " channelConfig: " + i8 + " audioFormat: 2 bufferSize: " + i9);
                return audioRecord;
            }
            return null;
        } catch (Exception e8) {
            Logger.d("VideoCapture", "Exception, keep trying.", e8);
            return null;
        }
    }

    private MediaFormat P() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.E, this.D);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("bitrate", this.F);
        return createAudioFormat;
    }

    private static MediaFormat Q(VideoCaptureConfig videoCaptureConfig, Size size) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", size.getWidth(), size.getHeight());
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", videoCaptureConfig.L());
        createVideoFormat.setInteger("frame-rate", videoCaptureConfig.N());
        createVideoFormat.setInteger("i-frame-interval", videoCaptureConfig.M());
        return createVideoFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(boolean z7, MediaCodec mediaCodec) {
        if (z7 && mediaCodec != null) {
            mediaCodec.release();
        }
    }

    private void U() {
        this.f3347r.quitSafely();
        MediaCodec mediaCodec = this.f3350u;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.f3350u = null;
        }
        if (this.A != null) {
            this.A.release();
            this.A = null;
        }
    }

    private void V(final boolean z7) {
        DeferrableSurface deferrableSurface = this.G;
        if (deferrableSurface == null) {
            return;
        }
        final MediaCodec mediaCodec = this.f3349t;
        deferrableSurface.c();
        this.G.i().f(new Runnable() { // from class: androidx.camera.core.g1
            @Override // java.lang.Runnable
            public final void run() {
                VideoCapture.S(z7, mediaCodec);
            }
        }, CameraXExecutors.d());
        if (z7) {
            this.f3349t = null;
        }
        this.f3355z = null;
        this.G = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public void R() {
        this.f3345p.quitSafely();
        U();
        if (this.f3355z != null) {
            V(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        r7.D = r4.audioChannels;
        r7.E = r4.audioSampleRate;
        r7.F = r4.audioBitRate;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void X(android.util.Size r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            int[] r1 = androidx.camera.core.VideoCapture.L     // Catch: java.lang.NumberFormatException -> L3d
            int r2 = r1.length     // Catch: java.lang.NumberFormatException -> L3d
            r3 = 0
        L5:
            if (r3 >= r2) goto L44
            r4 = r1[r3]     // Catch: java.lang.NumberFormatException -> L3d
            int r5 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.NumberFormatException -> L3d
            boolean r5 = android.media.CamcorderProfile.hasProfile(r5, r4)     // Catch: java.lang.NumberFormatException -> L3d
            if (r5 == 0) goto L3a
            int r5 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.NumberFormatException -> L3d
            android.media.CamcorderProfile r4 = android.media.CamcorderProfile.get(r5, r4)     // Catch: java.lang.NumberFormatException -> L3d
            int r5 = r8.getWidth()     // Catch: java.lang.NumberFormatException -> L3d
            int r6 = r4.videoFrameWidth     // Catch: java.lang.NumberFormatException -> L3d
            if (r5 != r6) goto L3a
            int r5 = r8.getHeight()     // Catch: java.lang.NumberFormatException -> L3d
            int r6 = r4.videoFrameHeight     // Catch: java.lang.NumberFormatException -> L3d
            if (r5 != r6) goto L3a
            int r8 = r4.audioChannels     // Catch: java.lang.NumberFormatException -> L3d
            r7.D = r8     // Catch: java.lang.NumberFormatException -> L3d
            int r8 = r4.audioSampleRate     // Catch: java.lang.NumberFormatException -> L3d
            r7.E = r8     // Catch: java.lang.NumberFormatException -> L3d
            int r8 = r4.audioBitRate     // Catch: java.lang.NumberFormatException -> L3d
            r7.F = r8     // Catch: java.lang.NumberFormatException -> L3d
            r8 = 1
            r0 = 1
            goto L44
        L3a:
            int r3 = r3 + 1
            goto L5
        L3d:
            java.lang.String r8 = "VideoCapture"
            java.lang.String r9 = "The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings."
            androidx.camera.core.Logger.e(r8, r9)
        L44:
            if (r0 != 0) goto L5e
            androidx.camera.core.impl.UseCaseConfig r8 = r7.g()
            androidx.camera.core.impl.VideoCaptureConfig r8 = (androidx.camera.core.impl.VideoCaptureConfig) r8
            int r9 = r8.I()
            r7.D = r9
            int r9 = r8.K()
            r7.E = r9
            int r8 = r8.H()
            r7.F = r8
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.VideoCapture.X(android.util.Size, java.lang.String):void");
    }

    @Override // androidx.camera.core.UseCase
    public void B() {
        T();
        ListenableFuture<Void> listenableFuture = this.f3351v;
        if (listenableFuture != null) {
            listenableFuture.f(new Runnable() { // from class: androidx.camera.core.h1
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCapture.this.R();
                }
            }, CameraXExecutors.d());
        } else {
            R();
        }
    }

    @Override // androidx.camera.core.UseCase
    public void E() {
        T();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    protected Size F(@NonNull Size size) {
        if (this.f3355z != null) {
            this.f3349t.stop();
            this.f3349t.release();
            this.f3350u.stop();
            this.f3350u.release();
            V(false);
        }
        try {
            this.f3349t = MediaCodec.createEncoderByType("video/avc");
            this.f3350u = MediaCodec.createEncoderByType("audio/mp4a-latm");
            Y(f(), size);
            s();
            return size;
        } catch (IOException e8) {
            throw new IllegalStateException("Unable to create MediaCodec due to: " + e8.getCause());
        }
    }

    void Y(@NonNull final String str, @NonNull final Size size) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) g();
        this.f3349t.reset();
        this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_UNINITIALIZED;
        try {
            this.f3349t.configure(Q(videoCaptureConfig, size), (Surface) null, (MediaCrypto) null, 1);
            if (this.f3355z != null) {
                V(false);
            }
            final Surface createInputSurface = this.f3349t.createInputSurface();
            this.f3355z = createInputSurface;
            this.f3352w = SessionConfig.Builder.o(videoCaptureConfig);
            DeferrableSurface deferrableSurface = this.G;
            if (deferrableSurface != null) {
                deferrableSurface.c();
            }
            ImmediateSurface immediateSurface = new ImmediateSurface(this.f3355z, size, i());
            this.G = immediateSurface;
            ListenableFuture<Void> i8 = immediateSurface.i();
            Objects.requireNonNull(createInputSurface);
            i8.f(new Runnable() { // from class: androidx.camera.core.i1
                @Override // java.lang.Runnable
                public final void run() {
                    createInputSurface.release();
                }
            }, CameraXExecutors.d());
            this.f3352w.h(this.G);
            this.f3352w.f(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.VideoCapture.1
                @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
                public void a(@NonNull SessionConfig sessionConfig, @NonNull SessionConfig.SessionError sessionError) {
                    if (VideoCapture.this.q(str)) {
                        VideoCapture.this.Y(str, size);
                        VideoCapture.this.u();
                    }
                }
            });
            J(this.f3352w.m());
            this.H.set(true);
            X(size, str);
            this.f3350u.reset();
            this.f3350u.configure(P(), (Surface) null, (MediaCrypto) null, 1);
            if (this.A != null) {
                this.A.release();
            }
            this.A = O(videoCaptureConfig);
            if (this.A == null) {
                Logger.c("VideoCapture", "AudioRecord object cannot initialized correctly!");
                this.H.set(false);
            }
            synchronized (this.f3342m) {
                this.f3353x = -1;
                this.f3354y = -1;
            }
            this.C = false;
        } catch (MediaCodec.CodecException e8) {
            if (Build.VERSION.SDK_INT >= 23) {
                int a8 = Api23Impl.a(e8);
                String diagnosticInfo = e8.getDiagnosticInfo();
                if (a8 == 1100) {
                    Logger.e("VideoCapture", "CodecException: code: " + a8 + " diagnostic: " + diagnosticInfo);
                    this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_INSUFFICIENT_RESOURCE;
                } else if (a8 == 1101) {
                    Logger.e("VideoCapture", "CodecException: code: " + a8 + " diagnostic: " + diagnosticInfo);
                    this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_RESOURCE_RECLAIMED;
                }
            } else {
                this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED;
            }
            this.J = e8;
        } catch (IllegalArgumentException e9) {
            e = e9;
            this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED;
            this.J = e;
        } catch (IllegalStateException e10) {
            e = e10;
            this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED;
            this.J = e;
        }
    }

    /* renamed from: Z */
    public void T() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.f1
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCapture.this.T();
                }
            });
            return;
        }
        Logger.e("VideoCapture", "stopRecording");
        this.f3352w.n();
        this.f3352w.h(this.G);
        J(this.f3352w.m());
        w();
        if (this.C) {
            if (this.H.get()) {
                this.f3344o.set(true);
            } else {
                this.f3343n.set(true);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> h(boolean z7, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a8 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE, 1);
        if (z7) {
            a8 = androidx.camera.core.impl.g.b(a8, K.a());
        }
        if (a8 == null) {
            return null;
        }
        return o(a8).b();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig.Builder<?, ?, ?> o(@NonNull Config config) {
        return Builder.c(config);
    }

    @Override // androidx.camera.core.UseCase
    public void y() {
        this.f3345p = new HandlerThread("CameraX-video encoding thread");
        this.f3347r = new HandlerThread("CameraX-audio encoding thread");
        this.f3345p.start();
        this.f3346q = new Handler(this.f3345p.getLooper());
        this.f3347r.start();
        this.f3348s = new Handler(this.f3347r.getLooper());
    }
}
