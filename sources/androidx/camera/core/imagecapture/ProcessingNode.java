package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Consumer;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ProcessingNode {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3468a;

    /* renamed from: b  reason: collision with root package name */
    private Operation<InputPacket, Packet<ImageProxy>> f3469b;

    /* renamed from: c  reason: collision with root package name */
    private Operation<Image2JpegBytes.In, Packet<byte[]>> f3470c;

    /* renamed from: d  reason: collision with root package name */
    private Operation<Bitmap2JpegBytes.In, Packet<byte[]>> f3471d;

    /* renamed from: e  reason: collision with root package name */
    private Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> f3472e;

    /* renamed from: f  reason: collision with root package name */
    private Operation<Packet<byte[]>, Packet<Bitmap>> f3473f;

    /* renamed from: g  reason: collision with root package name */
    private Operation<Packet<ImageProxy>, ImageProxy> f3474g;

    /* renamed from: h  reason: collision with root package name */
    private Operation<Packet<byte[]>, Packet<ImageProxy>> f3475h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class In {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static In c(int i8) {
            return new AutoValue_ProcessingNode_In(new Edge(), i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Edge<InputPacket> a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class InputPacket {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static InputPacket c(@NonNull ProcessingRequest processingRequest, @NonNull ImageProxy imageProxy) {
            return new AutoValue_ProcessingNode_InputPacket(processingRequest, imageProxy);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract ImageProxy a();

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public abstract ProcessingRequest b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessingNode(@NonNull Executor executor) {
        this.f3468a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(final InputPacket inputPacket) {
        if (inputPacket.b().h()) {
            return;
        }
        this.f3468a.execute(new Runnable() { // from class: androidx.camera.core.imagecapture.d
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingNode.this.i(inputPacket);
            }
        });
    }

    private static void o(@NonNull final ProcessingRequest processingRequest, @NonNull final ImageCaptureException imageCaptureException) {
        CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.g
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingRequest.this.m(imageCaptureException);
            }
        });
    }

    @NonNull
    ImageProxy k(@NonNull InputPacket inputPacket) throws ImageCaptureException {
        ProcessingRequest b8 = inputPacket.b();
        Packet<ImageProxy> apply = this.f3469b.apply(inputPacket);
        if (apply.e() == 35) {
            apply = this.f3475h.apply(this.f3470c.apply(Image2JpegBytes.In.c(apply, b8.b())));
        }
        return this.f3474g.apply(apply);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void i(@NonNull InputPacket inputPacket) {
        final ProcessingRequest b8 = inputPacket.b();
        try {
            if (inputPacket.b().i()) {
                final ImageProxy k8 = k(inputPacket);
                CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingRequest.this.k(k8);
                    }
                });
            } else {
                final ImageCapture.OutputFileResults m8 = m(inputPacket);
                CameraXExecutors.d().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingRequest.this.j(m8);
                    }
                });
            }
        } catch (ImageCaptureException e8) {
            o(b8, e8);
        } catch (RuntimeException e9) {
            o(b8, new ImageCaptureException(0, "Processing failed.", e9));
        }
    }

    @NonNull
    ImageCapture.OutputFileResults m(@NonNull InputPacket inputPacket) throws ImageCaptureException {
        ProcessingRequest b8 = inputPacket.b();
        Packet<byte[]> apply = this.f3470c.apply(Image2JpegBytes.In.c(this.f3469b.apply(inputPacket), b8.b()));
        if (apply.i()) {
            apply = this.f3471d.apply(Bitmap2JpegBytes.In.c(this.f3473f.apply(apply), b8.b()));
        }
        Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> operation = this.f3472e;
        ImageCapture.OutputFileOptions c8 = b8.c();
        Objects.requireNonNull(c8);
        return operation.apply(JpegBytes2Disk.In.c(apply, c8));
    }

    public void n() {
    }

    @NonNull
    public Void p(@NonNull In in) {
        in.a().a(new Consumer() { // from class: androidx.camera.core.imagecapture.c
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ProcessingNode.this.j((ProcessingNode.InputPacket) obj);
            }
        });
        this.f3469b = new ProcessingInput2Packet();
        this.f3470c = new Image2JpegBytes();
        this.f3473f = new JpegBytes2CroppedBitmap();
        this.f3471d = new Bitmap2JpegBytes();
        this.f3472e = new JpegBytes2Disk();
        this.f3474g = new JpegImage2Result();
        if (in.b() == 35) {
            this.f3475h = new JpegBytes2Image();
            return null;
        }
        return null;
    }
}
