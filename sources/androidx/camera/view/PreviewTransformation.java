package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.PreviewView;
import androidx.core.util.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PreviewTransformation {

    /* renamed from: g  reason: collision with root package name */
    private static final PreviewView.ScaleType f4092g = PreviewView.ScaleType.FILL_CENTER;

    /* renamed from: a  reason: collision with root package name */
    private Size f4093a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f4094b;

    /* renamed from: c  reason: collision with root package name */
    private int f4095c;

    /* renamed from: d  reason: collision with root package name */
    private int f4096d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4097e;

    /* renamed from: f  reason: collision with root package name */
    private PreviewView.ScaleType f4098f = f4092g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.camera.view.PreviewTransformation$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4099a;

        static {
            int[] iArr = new int[PreviewView.ScaleType.values().length];
            f4099a = iArr;
            try {
                iArr[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4099a[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4099a[PreviewView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4099a[PreviewView.ScaleType.FILL_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4099a[PreviewView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4099a[PreviewView.ScaleType.FILL_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static RectF b(RectF rectF, float f8) {
        float f9 = f8 + f8;
        return new RectF(f9 - rectF.right, rectF.top, f9 - rectF.left, rectF.bottom);
    }

    private Size e() {
        if (TransformUtils.f(this.f4095c)) {
            return new Size(this.f4094b.height(), this.f4094b.width());
        }
        return new Size(this.f4094b.width(), this.f4094b.height());
    }

    private RectF j(Size size, int i8) {
        Preconditions.i(k());
        Matrix h8 = h(size, i8);
        RectF rectF = new RectF(0.0f, 0.0f, this.f4093a.getWidth(), this.f4093a.getHeight());
        h8.mapRect(rectF);
        return rectF;
    }

    private boolean k() {
        if (this.f4094b != null && this.f4093a != null && this.f4096d != -1) {
            return true;
        }
        return false;
    }

    private static void n(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.ScaleType scaleType) {
        Matrix.ScaleToFit scaleToFit;
        boolean z7;
        switch (AnonymousClass1.f4099a[scaleType.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                Logger.c("PreviewTransform", "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (scaleType != PreviewView.ScaleType.FIT_CENTER && scaleType != PreviewView.ScaleType.FIT_START && scaleType != PreviewView.ScaleType.FIT_END) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            return;
        }
        matrix.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.invert(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a(@NonNull Bitmap bitmap, Size size, int i8) {
        if (!k()) {
            return bitmap;
        }
        Matrix i9 = i();
        RectF j8 = j(size, i8);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(i9);
        matrix.postScale(j8.width() / this.f4093a.getWidth(), j8.height() / this.f4093a.getHeight());
        matrix.postTranslate(j8.left, j8.top);
        canvas.drawBitmap(bitmap, matrix, new Paint(7));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix c(Size size, int i8) {
        if (!k()) {
            return null;
        }
        Matrix matrix = new Matrix();
        h(size, i8).invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(0.0f, 0.0f, this.f4093a.getWidth(), this.f4093a.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    RectF d(Size size, int i8) {
        RectF rectF = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        Size e8 = e();
        RectF rectF2 = new RectF(0.0f, 0.0f, e8.getWidth(), e8.getHeight());
        Matrix matrix = new Matrix();
        n(matrix, rectF2, rectF, this.f4098f);
        matrix.mapRect(rectF2);
        if (i8 == 1) {
            return b(rectF2, size.getWidth() / 2.0f);
        }
        return rectF2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewView.ScaleType f() {
        return this.f4098f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect g() {
        return this.f4094b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix h(Size size, int i8) {
        RectF d8;
        Preconditions.i(k());
        if (l(size)) {
            d8 = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        } else {
            d8 = d(size, i8);
        }
        Matrix c8 = TransformUtils.c(new RectF(this.f4094b), d8, this.f4095c);
        if (this.f4097e) {
            if (TransformUtils.f(this.f4095c)) {
                c8.preScale(1.0f, -1.0f, this.f4094b.centerX(), this.f4094b.centerY());
            } else {
                c8.preScale(-1.0f, 1.0f, this.f4094b.centerX(), this.f4094b.centerY());
            }
        }
        return c8;
    }

    Matrix i() {
        Preconditions.i(k());
        RectF rectF = new RectF(0.0f, 0.0f, this.f4093a.getWidth(), this.f4093a.getHeight());
        return TransformUtils.c(rectF, rectF, -CameraOrientationUtil.b(this.f4096d));
    }

    boolean l(Size size) {
        return TransformUtils.g(size, true, e(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i8, int i9) {
        this.f4095c = i8;
        this.f4096d = i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(PreviewView.ScaleType scaleType) {
        this.f4098f = scaleType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(@NonNull SurfaceRequest.TransformationInfo transformationInfo, Size size, boolean z7) {
        Logger.a("PreviewTransform", "Transformation info set: " + transformationInfo + " " + size + " " + z7);
        this.f4094b = transformationInfo.a();
        this.f4095c = transformationInfo.b();
        this.f4096d = transformationInfo.c();
        this.f4093a = size;
        this.f4097e = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Size size, int i8, @NonNull View view) {
        if (size.getHeight() != 0 && size.getWidth() != 0) {
            if (!k()) {
                return;
            }
            if (view instanceof TextureView) {
                ((TextureView) view).setTransform(i());
            } else {
                Display display = view.getDisplay();
                if (display != null && display.getRotation() != this.f4096d) {
                    Logger.c("PreviewTransform", "Non-display rotation not supported with SurfaceView / PERFORMANCE mode.");
                }
            }
            RectF j8 = j(size, i8);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(j8.width() / this.f4093a.getWidth());
            view.setScaleY(j8.height() / this.f4093a.getHeight());
            view.setTranslationX(j8.left - view.getLeft());
            view.setTranslationY(j8.top - view.getTop());
            return;
        }
        Logger.k("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
    }
}
