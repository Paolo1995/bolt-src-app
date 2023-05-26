package androidx.camera.core.internal;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.YuvToJpegProcessor;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class YuvToJpegProcessor implements CaptureProcessor {

    /* renamed from: k  reason: collision with root package name */
    private static final Rect f3914k = new Rect(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final int f3915a;

    /* renamed from: c  reason: collision with root package name */
    private int f3917c;

    /* renamed from: g  reason: collision with root package name */
    private ImageWriter f3921g;

    /* renamed from: i  reason: collision with root package name */
    CallbackToFutureAdapter.Completer<Void> f3923i;

    /* renamed from: j  reason: collision with root package name */
    private ListenableFuture<Void> f3924j;

    /* renamed from: b  reason: collision with root package name */
    private final Object f3916b = new Object();

    /* renamed from: d  reason: collision with root package name */
    private int f3918d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3919e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f3920f = 0;

    /* renamed from: h  reason: collision with root package name */
    private Rect f3922h = f3914k;

    public YuvToJpegProcessor(int i8, int i9) {
        this.f3917c = i8;
        this.f3915a = i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object f(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.f3916b) {
            this.f3923i = completer;
        }
        return "YuvToJpegProcessor-close";
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void a(@NonNull Surface surface, int i8) {
        boolean z7;
        if (i8 == 256) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.j(z7, "YuvToJpegProcessor only supports JPEG output format.");
        synchronized (this.f3916b) {
            if (!this.f3919e) {
                if (this.f3921g == null) {
                    this.f3921g = ImageWriterCompat.b(surface, this.f3915a, i8);
                } else {
                    throw new IllegalStateException("Output surface already set.");
                }
            } else {
                Logger.k("YuvToJpegProcessor", "Cannot set output surface. Processor is closed.");
            }
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    @NonNull
    public ListenableFuture<Void> b() {
        ListenableFuture<Void> j8;
        synchronized (this.f3916b) {
            if (this.f3919e && this.f3920f == 0) {
                j8 = Futures.h(null);
            } else {
                if (this.f3924j == null) {
                    this.f3924j = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: f.f
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object a(CallbackToFutureAdapter.Completer completer) {
                            Object f8;
                            f8 = YuvToJpegProcessor.this.f(completer);
                            return f8;
                        }
                    });
                }
                j8 = Futures.j(this.f3924j);
            }
        }
        return j8;
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void c(@NonNull Size size) {
        synchronized (this.f3916b) {
            this.f3922h = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void close() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.f3916b) {
            if (this.f3919e) {
                return;
            }
            this.f3919e = true;
            if (this.f3920f == 0 && this.f3921g != null) {
                Logger.a("YuvToJpegProcessor", "No processing in progress. Closing immediately.");
                this.f3921g.close();
                completer = this.f3923i;
            } else {
                Logger.a("YuvToJpegProcessor", "close() called while processing. Will close after completion.");
                completer = null;
            }
            if (completer != null) {
                completer.c(null);
            }
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void d(@NonNull ImageProxyBundle imageProxyBundle) {
        boolean z7;
        ImageWriter imageWriter;
        boolean z8;
        Rect rect;
        int i8;
        int i9;
        ImageProxy imageProxy;
        Image image;
        CallbackToFutureAdapter.Completer<Void> completer;
        CallbackToFutureAdapter.Completer<Void> completer2;
        boolean z9;
        CallbackToFutureAdapter.Completer<Void> completer3;
        List<Integer> a8 = imageProxyBundle.a();
        boolean z10 = false;
        if (a8.size() == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "Processing image bundle have single capture id, but found " + a8.size());
        ListenableFuture<ImageProxy> b8 = imageProxyBundle.b(a8.get(0).intValue());
        Preconditions.a(b8.isDone());
        synchronized (this.f3916b) {
            imageWriter = this.f3921g;
            if (!this.f3919e) {
                z8 = true;
            } else {
                z8 = false;
            }
            rect = this.f3922h;
            if (z8) {
                this.f3920f++;
            }
            i8 = this.f3917c;
            i9 = this.f3918d;
        }
        try {
            try {
                imageProxy = b8.get();
                try {
                } catch (Exception e8) {
                    e = e8;
                    image = null;
                } catch (Throwable th) {
                    th = th;
                    image = null;
                }
            } catch (Exception e9) {
                e = e9;
                imageProxy = null;
                image = null;
            } catch (Throwable th2) {
                th = th2;
                imageProxy = null;
                image = null;
            }
            if (!z8) {
                Logger.k("YuvToJpegProcessor", "Image enqueued for processing on closed processor.");
                imageProxy.close();
                synchronized (this.f3916b) {
                    if (z8) {
                        try {
                            int i10 = this.f3920f;
                            this.f3920f = i10 - 1;
                            if (i10 == 0 && this.f3919e) {
                                z10 = true;
                            }
                        } finally {
                        }
                    }
                    completer3 = this.f3923i;
                }
                if (z10) {
                    imageWriter.close();
                    Logger.a("YuvToJpegProcessor", "Closed after completion of last image processed.");
                    if (completer3 != null) {
                        completer3.c(null);
                        return;
                    }
                    return;
                }
                return;
            }
            image = imageWriter.dequeueInputImage();
            try {
                ImageProxy imageProxy2 = b8.get();
                try {
                    if (imageProxy2.getFormat() == 35) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    Preconditions.j(z9, "Input image is not expected YUV_420_888 image format");
                    YuvImage yuvImage = new YuvImage(ImageUtil.q(imageProxy2), 17, imageProxy2.getWidth(), imageProxy2.getHeight(), null);
                    ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                    int position = buffer.position();
                    yuvImage.compressToJpeg(rect, i8, new ExifOutputStream(new ByteBufferOutputStream(buffer), ExifData.b(imageProxy2, i9)));
                    imageProxy2.close();
                    try {
                        buffer.limit(buffer.position());
                        buffer.position(position);
                        imageWriter.queueInputImage(image);
                        synchronized (this.f3916b) {
                            if (z8) {
                                try {
                                    int i11 = this.f3920f;
                                    this.f3920f = i11 - 1;
                                    if (i11 == 0 && this.f3919e) {
                                        z10 = true;
                                    }
                                } finally {
                                }
                            }
                            completer2 = this.f3923i;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        imageProxy = null;
                        if (z8) {
                            Logger.d("YuvToJpegProcessor", "Failed to process YUV -> JPEG", e);
                            image = imageWriter.dequeueInputImage();
                            ByteBuffer buffer2 = image.getPlanes()[0].getBuffer();
                            buffer2.rewind();
                            buffer2.limit(0);
                            imageWriter.queueInputImage(image);
                        }
                        synchronized (this.f3916b) {
                            if (z8) {
                                try {
                                    int i12 = this.f3920f;
                                    this.f3920f = i12 - 1;
                                    if (i12 == 0 && this.f3919e) {
                                        z10 = true;
                                    }
                                } finally {
                                }
                            }
                            completer2 = this.f3923i;
                        }
                        if (image != null) {
                            image.close();
                        }
                        if (imageProxy != null) {
                            imageProxy.close();
                        }
                        if (z10) {
                            imageWriter.close();
                            Logger.a("YuvToJpegProcessor", "Closed after completion of last image processed.");
                            if (completer2 == null) {
                                return;
                            }
                            completer2.c(null);
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        imageProxy = null;
                        synchronized (this.f3916b) {
                            if (z8) {
                                try {
                                    int i13 = this.f3920f;
                                    this.f3920f = i13 - 1;
                                    if (i13 == 0 && this.f3919e) {
                                        z10 = true;
                                    }
                                } finally {
                                }
                            }
                            completer = this.f3923i;
                        }
                        if (image != null) {
                            image.close();
                        }
                        if (imageProxy != null) {
                            imageProxy.close();
                        }
                        if (z10) {
                            imageWriter.close();
                            Logger.a("YuvToJpegProcessor", "Closed after completion of last image processed.");
                            if (completer != null) {
                                completer.c(null);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    imageProxy = imageProxy2;
                } catch (Throwable th4) {
                    th = th4;
                    imageProxy = imageProxy2;
                }
            } catch (Exception e12) {
                e = e12;
            }
            if (z10) {
                imageWriter.close();
                Logger.a("YuvToJpegProcessor", "Closed after completion of last image processed.");
                if (completer2 == null) {
                    return;
                }
                completer2.c(null);
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public void g(int i8) {
        synchronized (this.f3916b) {
            this.f3917c = i8;
        }
    }

    public void h(int i8) {
        synchronized (this.f3916b) {
            this.f3918d = i8;
        }
    }
}
