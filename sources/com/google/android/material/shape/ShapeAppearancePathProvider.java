package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ShapeAppearancePathProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ShapePath[] f14052a = new ShapePath[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f14053b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f14054c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f14055d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f14056e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f14057f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final ShapePath f14058g = new ShapePath();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f14059h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f14060i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f14061j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f14062k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f14063l = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Lazy {

        /* renamed from: a  reason: collision with root package name */
        static final ShapeAppearancePathProvider f14064a = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    /* loaded from: classes.dex */
    public interface PathListener {
        void a(ShapePath shapePath, Matrix matrix, int i8);

        void b(ShapePath shapePath, Matrix matrix, int i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ShapeAppearancePathSpec {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final ShapeAppearanceModel f14065a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Path f14066b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final RectF f14067c;

        /* renamed from: d  reason: collision with root package name */
        public final PathListener f14068d;

        /* renamed from: e  reason: collision with root package name */
        public final float f14069e;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f8, RectF rectF, PathListener pathListener, Path path) {
            this.f14068d = pathListener;
            this.f14065a = shapeAppearanceModel;
            this.f14069e = f8;
            this.f14067c = rectF;
            this.f14066b = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i8 = 0; i8 < 4; i8++) {
            this.f14052a[i8] = new ShapePath();
            this.f14053b[i8] = new Matrix();
            this.f14054c[i8] = new Matrix();
        }
    }

    private float a(int i8) {
        return ((i8 + 1) % 4) * 90;
    }

    private void b(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i8) {
        this.f14059h[0] = this.f14052a[i8].k();
        this.f14059h[1] = this.f14052a[i8].l();
        this.f14053b[i8].mapPoints(this.f14059h);
        if (i8 == 0) {
            Path path = shapeAppearancePathSpec.f14066b;
            float[] fArr = this.f14059h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.f14066b;
            float[] fArr2 = this.f14059h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f14052a[i8].d(this.f14053b[i8], shapeAppearancePathSpec.f14066b);
        PathListener pathListener = shapeAppearancePathSpec.f14068d;
        if (pathListener != null) {
            pathListener.a(this.f14052a[i8], this.f14053b[i8], i8);
        }
    }

    private void c(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i8) {
        int i9 = (i8 + 1) % 4;
        this.f14059h[0] = this.f14052a[i8].i();
        this.f14059h[1] = this.f14052a[i8].j();
        this.f14053b[i8].mapPoints(this.f14059h);
        this.f14060i[0] = this.f14052a[i9].k();
        this.f14060i[1] = this.f14052a[i9].l();
        this.f14053b[i9].mapPoints(this.f14060i);
        float[] fArr = this.f14059h;
        float f8 = fArr[0];
        float[] fArr2 = this.f14060i;
        float max = Math.max(((float) Math.hypot(f8 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float i10 = i(shapeAppearancePathSpec.f14067c, i8);
        this.f14058g.n(0.0f, 0.0f);
        EdgeTreatment j8 = j(i8, shapeAppearancePathSpec.f14065a);
        j8.b(max, i10, shapeAppearancePathSpec.f14069e, this.f14058g);
        this.f14061j.reset();
        this.f14058g.d(this.f14054c[i8], this.f14061j);
        if (this.f14063l && (j8.a() || l(this.f14061j, i8) || l(this.f14061j, i9))) {
            Path path = this.f14061j;
            path.op(path, this.f14057f, Path.Op.DIFFERENCE);
            this.f14059h[0] = this.f14058g.k();
            this.f14059h[1] = this.f14058g.l();
            this.f14054c[i8].mapPoints(this.f14059h);
            Path path2 = this.f14056e;
            float[] fArr3 = this.f14059h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f14058g.d(this.f14054c[i8], this.f14056e);
        } else {
            this.f14058g.d(this.f14054c[i8], shapeAppearancePathSpec.f14066b);
        }
        PathListener pathListener = shapeAppearancePathSpec.f14068d;
        if (pathListener != null) {
            pathListener.b(this.f14058g, this.f14054c[i8], i8);
        }
    }

    private void f(int i8, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    pointF.set(rectF.right, rectF.top);
                    return;
                } else {
                    pointF.set(rectF.left, rectF.top);
                    return;
                }
            }
            pointF.set(rectF.left, rectF.bottom);
            return;
        }
        pointF.set(rectF.right, rectF.bottom);
    }

    private CornerSize g(int i8, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return shapeAppearanceModel.t();
                }
                return shapeAppearanceModel.r();
            }
            return shapeAppearanceModel.j();
        }
        return shapeAppearanceModel.l();
    }

    private CornerTreatment h(int i8, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return shapeAppearanceModel.s();
                }
                return shapeAppearanceModel.q();
            }
            return shapeAppearanceModel.i();
        }
        return shapeAppearanceModel.k();
    }

    private float i(@NonNull RectF rectF, int i8) {
        float[] fArr = this.f14059h;
        ShapePath shapePath = this.f14052a[i8];
        fArr[0] = shapePath.f14072c;
        fArr[1] = shapePath.f14073d;
        this.f14053b[i8].mapPoints(fArr);
        if (i8 != 1 && i8 != 3) {
            return Math.abs(rectF.centerY() - this.f14059h[1]);
        }
        return Math.abs(rectF.centerX() - this.f14059h[0]);
    }

    private EdgeTreatment j(int i8, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return shapeAppearanceModel.o();
                }
                return shapeAppearanceModel.p();
            }
            return shapeAppearanceModel.n();
        }
        return shapeAppearanceModel.h();
    }

    @NonNull
    public static ShapeAppearancePathProvider k() {
        return Lazy.f14064a;
    }

    private boolean l(Path path, int i8) {
        this.f14062k.reset();
        this.f14052a[i8].d(this.f14053b[i8], this.f14062k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f14062k.computeBounds(rectF, true);
        path.op(this.f14062k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }

    private void m(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i8) {
        h(i8, shapeAppearancePathSpec.f14065a).c(this.f14052a[i8], 90.0f, shapeAppearancePathSpec.f14069e, shapeAppearancePathSpec.f14067c, g(i8, shapeAppearancePathSpec.f14065a));
        float a8 = a(i8);
        this.f14053b[i8].reset();
        f(i8, shapeAppearancePathSpec.f14067c, this.f14055d);
        Matrix matrix = this.f14053b[i8];
        PointF pointF = this.f14055d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f14053b[i8].preRotate(a8);
    }

    private void n(int i8) {
        this.f14059h[0] = this.f14052a[i8].i();
        this.f14059h[1] = this.f14052a[i8].j();
        this.f14053b[i8].mapPoints(this.f14059h);
        float a8 = a(i8);
        this.f14054c[i8].reset();
        Matrix matrix = this.f14054c[i8];
        float[] fArr = this.f14059h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f14054c[i8].preRotate(a8);
    }

    public void d(ShapeAppearanceModel shapeAppearanceModel, float f8, RectF rectF, @NonNull Path path) {
        e(shapeAppearanceModel, f8, rectF, null, path);
    }

    public void e(ShapeAppearanceModel shapeAppearanceModel, float f8, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.f14056e.rewind();
        this.f14057f.rewind();
        this.f14057f.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f8, rectF, pathListener, path);
        for (int i8 = 0; i8 < 4; i8++) {
            m(shapeAppearancePathSpec, i8);
            n(i8);
        }
        for (int i9 = 0; i9 < 4; i9++) {
            b(shapeAppearancePathSpec, i9);
            c(shapeAppearancePathSpec, i9);
        }
        path.close();
        this.f14056e.close();
        if (!this.f14056e.isEmpty()) {
            path.op(this.f14056e, Path.Op.UNION);
        }
    }
}
