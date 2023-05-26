package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShapePath {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f14070a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f14071b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f14072c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f14073d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f14074e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f14075f;

    /* renamed from: g  reason: collision with root package name */
    private final List<PathOperation> f14076g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<ShadowCompatOperation> f14077h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f14078i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ArcShadowOperation extends ShadowCompatOperation {

        /* renamed from: c  reason: collision with root package name */
        private final PathArcOperation f14082c;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.f14082c = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i8, @NonNull Canvas canvas) {
            shadowRenderer.a(canvas, matrix, new RectF(this.f14082c.k(), this.f14082c.o(), this.f14082c.l(), this.f14082c.j()), i8, this.f14082c.m(), this.f14082c.n());
        }
    }

    /* loaded from: classes.dex */
    static class LineShadowOperation extends ShadowCompatOperation {

        /* renamed from: c  reason: collision with root package name */
        private final PathLineOperation f14083c;

        /* renamed from: d  reason: collision with root package name */
        private final float f14084d;

        /* renamed from: e  reason: collision with root package name */
        private final float f14085e;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f8, float f9) {
            this.f14083c = pathLineOperation;
            this.f14084d = f8;
            this.f14085e = f9;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i8, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f14083c.f14094c - this.f14085e, this.f14083c.f14093b - this.f14084d), 0.0f);
            this.f14097a.set(matrix);
            this.f14097a.preTranslate(this.f14084d, this.f14085e);
            this.f14097a.preRotate(c());
            shadowRenderer.b(canvas, this.f14097a, rectF, i8);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f14083c.f14094c - this.f14085e) / (this.f14083c.f14093b - this.f14084d)));
        }
    }

    /* loaded from: classes.dex */
    public static class PathArcOperation extends PathOperation {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f14086h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f14087b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f14088c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f14089d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f14090e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f14091f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f14092g;

        public PathArcOperation(float f8, float f9, float f10, float f11) {
            q(f8);
            u(f9);
            r(f10);
            p(f11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f14090e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f14087b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f14089d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f14091f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f14092g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f14088c;
        }

        private void p(float f8) {
            this.f14090e = f8;
        }

        private void q(float f8) {
            this.f14087b = f8;
        }

        private void r(float f8) {
            this.f14089d = f8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f8) {
            this.f14091f = f8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f8) {
            this.f14092g = f8;
        }

        private void u(float f8) {
            this.f14088c = f8;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f14095a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f14086h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class PathLineOperation extends PathOperation {

        /* renamed from: b  reason: collision with root package name */
        private float f14093b;

        /* renamed from: c  reason: collision with root package name */
        private float f14094c;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f14095a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f14093b, this.f14094c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PathOperation {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f14095a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class ShadowCompatOperation {

        /* renamed from: b  reason: collision with root package name */
        static final Matrix f14096b = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        final Matrix f14097a = new Matrix();

        ShadowCompatOperation() {
        }

        public abstract void a(Matrix matrix, ShadowRenderer shadowRenderer, int i8, Canvas canvas);

        public final void b(ShadowRenderer shadowRenderer, int i8, Canvas canvas) {
            a(f14096b, shadowRenderer, i8, canvas);
        }
    }

    public ShapePath() {
        n(0.0f, 0.0f);
    }

    private void b(float f8) {
        if (g() == f8) {
            return;
        }
        float g8 = ((f8 - g()) + 360.0f) % 360.0f;
        if (g8 > 180.0f) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(i(), j(), i(), j());
        pathArcOperation.s(g());
        pathArcOperation.t(g8);
        this.f14077h.add(new ArcShadowOperation(pathArcOperation));
        p(f8);
    }

    private void c(ShadowCompatOperation shadowCompatOperation, float f8, float f9) {
        b(f8);
        this.f14077h.add(shadowCompatOperation);
        p(f9);
    }

    private float g() {
        return this.f14074e;
    }

    private float h() {
        return this.f14075f;
    }

    private void p(float f8) {
        this.f14074e = f8;
    }

    private void q(float f8) {
        this.f14075f = f8;
    }

    private void r(float f8) {
        this.f14072c = f8;
    }

    private void s(float f8) {
        this.f14073d = f8;
    }

    private void t(float f8) {
        this.f14070a = f8;
    }

    private void u(float f8) {
        this.f14071b = f8;
    }

    public void a(float f8, float f9, float f10, float f11, float f12, float f13) {
        boolean z7;
        float f14;
        PathArcOperation pathArcOperation = new PathArcOperation(f8, f9, f10, f11);
        pathArcOperation.s(f12);
        pathArcOperation.t(f13);
        this.f14076g.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f15 = f12 + f13;
        if (f13 < 0.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            f12 = (f12 + 180.0f) % 360.0f;
        }
        if (z7) {
            f14 = (180.0f + f15) % 360.0f;
        } else {
            f14 = f15;
        }
        c(arcShadowOperation, f12, f14);
        double d8 = f15;
        r(((f8 + f10) * 0.5f) + (((f10 - f8) / 2.0f) * ((float) Math.cos(Math.toRadians(d8)))));
        s(((f9 + f11) * 0.5f) + (((f11 - f9) / 2.0f) * ((float) Math.sin(Math.toRadians(d8)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f14076g.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f14076g.get(i8).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f14078i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ShadowCompatOperation f(Matrix matrix) {
        b(h());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.f14077h);
        return new ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void a(Matrix matrix3, ShadowRenderer shadowRenderer, int i8, Canvas canvas) {
                for (ShadowCompatOperation shadowCompatOperation : arrayList) {
                    shadowCompatOperation.a(matrix2, shadowRenderer, i8, canvas);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f14072c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f14073d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f14070a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f14071b;
    }

    public void m(float f8, float f9) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f14093b = f8;
        pathLineOperation.f14094c = f9;
        this.f14076g.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, i(), j());
        c(lineShadowOperation, lineShadowOperation.c() + 270.0f, lineShadowOperation.c() + 270.0f);
        r(f8);
        s(f9);
    }

    public void n(float f8, float f9) {
        o(f8, f9, 270.0f, 0.0f);
    }

    public void o(float f8, float f9, float f10, float f11) {
        t(f8);
        u(f9);
        r(f8);
        s(f9);
        p(f10);
        q((f10 + f11) % 360.0f);
        this.f14076g.clear();
        this.f14077h.clear();
        this.f14078i = false;
    }
}
