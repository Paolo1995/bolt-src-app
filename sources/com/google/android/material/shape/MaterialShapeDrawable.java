package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.util.BitSet;

/* loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    private static final String C = MaterialShapeDrawable.class.getSimpleName();
    private static final Paint D;
    @NonNull
    private final RectF A;
    private boolean B;

    /* renamed from: f  reason: collision with root package name */
    private MaterialShapeDrawableState f13979f;

    /* renamed from: g  reason: collision with root package name */
    private final ShapePath.ShadowCompatOperation[] f13980g;

    /* renamed from: h  reason: collision with root package name */
    private final ShapePath.ShadowCompatOperation[] f13981h;

    /* renamed from: i  reason: collision with root package name */
    private final BitSet f13982i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13983j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f13984k;

    /* renamed from: l  reason: collision with root package name */
    private final Path f13985l;

    /* renamed from: m  reason: collision with root package name */
    private final Path f13986m;

    /* renamed from: n  reason: collision with root package name */
    private final RectF f13987n;

    /* renamed from: o  reason: collision with root package name */
    private final RectF f13988o;

    /* renamed from: p  reason: collision with root package name */
    private final Region f13989p;

    /* renamed from: q  reason: collision with root package name */
    private final Region f13990q;

    /* renamed from: r  reason: collision with root package name */
    private ShapeAppearanceModel f13991r;

    /* renamed from: s  reason: collision with root package name */
    private final Paint f13992s;

    /* renamed from: t  reason: collision with root package name */
    private final Paint f13993t;

    /* renamed from: u  reason: collision with root package name */
    private final ShadowRenderer f13994u;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    private final ShapeAppearancePathProvider.PathListener f13995v;

    /* renamed from: w  reason: collision with root package name */
    private final ShapeAppearancePathProvider f13996w;

    /* renamed from: x  reason: collision with root package name */
    private PorterDuffColorFilter f13997x;

    /* renamed from: y  reason: collision with root package name */
    private PorterDuffColorFilter f13998y;

    /* renamed from: z  reason: collision with root package name */
    private int f13999z;

    static {
        Paint paint = new Paint(1);
        D = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private float H() {
        if (Q()) {
            return this.f13993t.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean O() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        int i8 = materialShapeDrawableState.f14019q;
        if (i8 != 1 && materialShapeDrawableState.f14020r > 0 && (i8 == 2 || Y())) {
            return true;
        }
        return false;
    }

    private boolean P() {
        Paint.Style style = this.f13979f.f14024v;
        if (style != Paint.Style.FILL_AND_STROKE && style != Paint.Style.FILL) {
            return false;
        }
        return true;
    }

    private boolean Q() {
        Paint.Style style = this.f13979f.f14024v;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f13993t.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    private void S() {
        super.invalidateSelf();
    }

    private void V(@NonNull Canvas canvas) {
        if (!O()) {
            return;
        }
        canvas.save();
        X(canvas);
        if (!this.B) {
            n(canvas);
            canvas.restore();
            return;
        }
        int width = (int) (this.A.width() - getBounds().width());
        int height = (int) (this.A.height() - getBounds().height());
        if (width >= 0 && height >= 0) {
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.A.width()) + (this.f13979f.f14020r * 2) + width, ((int) this.A.height()) + (this.f13979f.f14020r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f8 = (getBounds().left - this.f13979f.f14020r) - width;
            float f9 = (getBounds().top - this.f13979f.f14020r) - height;
            canvas2.translate(-f8, -f9);
            n(canvas2);
            canvas.drawBitmap(createBitmap, f8, f9, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int W(int i8, int i9) {
        return (i8 * (i9 + (i9 >>> 7))) >>> 8;
    }

    private void X(@NonNull Canvas canvas) {
        canvas.translate(C(), D());
    }

    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z7) {
        if (z7) {
            int color = paint.getColor();
            int l8 = l(color);
            this.f13999z = l8;
            if (l8 != color) {
                return new PorterDuffColorFilter(l8, PorterDuff.Mode.SRC_IN);
            }
            return null;
        }
        return null;
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.f13979f.f14012j != 1.0f) {
            this.f13984k.reset();
            Matrix matrix = this.f13984k;
            float f8 = this.f13979f.f14012j;
            matrix.setScale(f8, f8, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f13984k);
        }
        path.computeBounds(this.A, true);
    }

    private void i() {
        final float f8 = -H();
        ShapeAppearanceModel y7 = F().y(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.shape.MaterialShapeDrawable.2
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            @NonNull
            public CornerSize a(@NonNull CornerSize cornerSize) {
                if (!(cornerSize instanceof RelativeCornerSize)) {
                    return new AdjustedCornerSize(f8, cornerSize);
                }
                return cornerSize;
            }
        });
        this.f13991r = y7;
        this.f13996w.d(y7, this.f13979f.f14013k, v(), this.f13986m);
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z7) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z7) {
            colorForState = l(colorForState);
        }
        this.f13999z = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, @NonNull Paint paint, boolean z7) {
        if (colorStateList != null && mode != null) {
            return j(colorStateList, mode, z7);
        }
        return f(paint, z7);
    }

    @NonNull
    public static MaterialShapeDrawable m(Context context, float f8) {
        int c8 = MaterialColors.c(context, R$attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.R(context);
        materialShapeDrawable.c0(ColorStateList.valueOf(c8));
        materialShapeDrawable.b0(f8);
        return materialShapeDrawable;
    }

    private void n(@NonNull Canvas canvas) {
        if (this.f13982i.cardinality() > 0) {
            Log.w(C, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f13979f.f14021s != 0) {
            canvas.drawPath(this.f13985l, this.f13994u.c());
        }
        for (int i8 = 0; i8 < 4; i8++) {
            this.f13980g[i8].b(this.f13994u, this.f13979f.f14020r, canvas);
            this.f13981h[i8].b(this.f13994u, this.f13979f.f14020r, canvas);
        }
        if (this.B) {
            int C2 = C();
            int D2 = D();
            canvas.translate(-C2, -D2);
            canvas.drawPath(this.f13985l, D);
            canvas.translate(C2, D2);
        }
    }

    private void o(@NonNull Canvas canvas) {
        q(canvas, this.f13992s, this.f13985l, this.f13979f.f14003a, u());
    }

    private boolean o0(int[] iArr) {
        boolean z7;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f13979f.f14006d != null && color2 != (colorForState2 = this.f13979f.f14006d.getColorForState(iArr, (color2 = this.f13992s.getColor())))) {
            this.f13992s.setColor(colorForState2);
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f13979f.f14007e != null && color != (colorForState = this.f13979f.f14007e.getColorForState(iArr, (color = this.f13993t.getColor())))) {
            this.f13993t.setColor(colorForState);
            return true;
        }
        return z7;
    }

    private boolean p0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f13997x;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f13998y;
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        this.f13997x = k(materialShapeDrawableState.f14009g, materialShapeDrawableState.f14010h, this.f13992s, true);
        MaterialShapeDrawableState materialShapeDrawableState2 = this.f13979f;
        this.f13998y = k(materialShapeDrawableState2.f14008f, materialShapeDrawableState2.f14010h, this.f13993t, false);
        MaterialShapeDrawableState materialShapeDrawableState3 = this.f13979f;
        if (materialShapeDrawableState3.f14023u) {
            this.f13994u.d(materialShapeDrawableState3.f14009g.getColorForState(getState(), 0));
        }
        if (!ObjectsCompat.a(porterDuffColorFilter, this.f13997x) || !ObjectsCompat.a(porterDuffColorFilter2, this.f13998y)) {
            return true;
        }
        return false;
    }

    private void q(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
        if (shapeAppearanceModel.u(rectF)) {
            float a8 = shapeAppearanceModel.t().a(rectF) * this.f13979f.f14013k;
            canvas.drawRoundRect(rectF, a8, a8, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void q0() {
        float N = N();
        this.f13979f.f14020r = (int) Math.ceil(0.75f * N);
        this.f13979f.f14021s = (int) Math.ceil(N * 0.25f);
        p0();
        S();
    }

    @NonNull
    private RectF v() {
        this.f13988o.set(u());
        float H = H();
        this.f13988o.inset(H, H);
        return this.f13988o;
    }

    @Deprecated
    public void A(int i8, int i9, @NonNull Path path) {
        h(new RectF(0.0f, 0.0f, i8, i9), path);
    }

    public int B() {
        return this.f13999z;
    }

    public int C() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        return (int) (materialShapeDrawableState.f14021s * Math.sin(Math.toRadians(materialShapeDrawableState.f14022t)));
    }

    public int D() {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        return (int) (materialShapeDrawableState.f14021s * Math.cos(Math.toRadians(materialShapeDrawableState.f14022t)));
    }

    public int E() {
        return this.f13979f.f14020r;
    }

    @NonNull
    public ShapeAppearanceModel F() {
        return this.f13979f.f14003a;
    }

    public ColorStateList G() {
        return this.f13979f.f14007e;
    }

    public float I() {
        return this.f13979f.f14014l;
    }

    public ColorStateList J() {
        return this.f13979f.f14009g;
    }

    public float K() {
        return this.f13979f.f14003a.r().a(u());
    }

    public float L() {
        return this.f13979f.f14003a.t().a(u());
    }

    public float M() {
        return this.f13979f.f14018p;
    }

    public float N() {
        return w() + M();
    }

    public void R(Context context) {
        this.f13979f.f14004b = new ElevationOverlayProvider(context);
        q0();
    }

    public boolean T() {
        ElevationOverlayProvider elevationOverlayProvider = this.f13979f.f14004b;
        if (elevationOverlayProvider != null && elevationOverlayProvider.e()) {
            return true;
        }
        return false;
    }

    public boolean U() {
        return this.f13979f.f14003a.u(u());
    }

    public boolean Y() {
        int i8 = Build.VERSION.SDK_INT;
        if (!U() && !this.f13985l.isConvex() && i8 < 29) {
            return true;
        }
        return false;
    }

    public void Z(float f8) {
        setShapeAppearanceModel(this.f13979f.f14003a.w(f8));
    }

    public void a0(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.f13979f.f14003a.x(cornerSize));
    }

    public void b0(float f8) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14017o != f8) {
            materialShapeDrawableState.f14017o = f8;
            q0();
        }
    }

    public void c0(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14006d != colorStateList) {
            materialShapeDrawableState.f14006d = colorStateList;
            onStateChange(getState());
        }
    }

    public void d0(float f8) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14013k != f8) {
            materialShapeDrawableState.f14013k = f8;
            this.f13983j = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f13992s.setColorFilter(this.f13997x);
        int alpha = this.f13992s.getAlpha();
        this.f13992s.setAlpha(W(alpha, this.f13979f.f14015m));
        this.f13993t.setColorFilter(this.f13998y);
        this.f13993t.setStrokeWidth(this.f13979f.f14014l);
        int alpha2 = this.f13993t.getAlpha();
        this.f13993t.setAlpha(W(alpha2, this.f13979f.f14015m));
        if (this.f13983j) {
            i();
            g(u(), this.f13985l);
            this.f13983j = false;
        }
        V(canvas);
        if (P()) {
            o(canvas);
        }
        if (Q()) {
            r(canvas);
        }
        this.f13992s.setAlpha(alpha);
        this.f13993t.setAlpha(alpha2);
    }

    public void e0(int i8, int i9, int i10, int i11) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14011i == null) {
            materialShapeDrawableState.f14011i = new Rect();
        }
        this.f13979f.f14011i.set(i8, i9, i10, i11);
        invalidateSelf();
    }

    public void f0(Paint.Style style) {
        this.f13979f.f14024v = style;
        S();
    }

    public void g0(float f8) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14016n != f8) {
            materialShapeDrawableState.f14016n = f8;
            q0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f13979f.f14015m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f13979f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f13979f.f14019q == 2) {
            return;
        }
        if (U()) {
            outline.setRoundRect(getBounds(), K() * this.f13979f.f14013k);
            return;
        }
        g(u(), this.f13985l);
        DrawableUtils.f(outline, this.f13985l);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f13979f.f14011i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f13989p.set(getBounds());
        g(u(), this.f13985l);
        this.f13990q.setPath(this.f13985l, this.f13989p);
        this.f13989p.op(this.f13990q, Region.Op.DIFFERENCE);
        return this.f13989p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(@NonNull RectF rectF, @NonNull Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.f13996w;
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        shapeAppearancePathProvider.e(materialShapeDrawableState.f14003a, materialShapeDrawableState.f14013k, rectF, this.f13995v, path);
    }

    public void h0(boolean z7) {
        this.B = z7;
    }

    public void i0(int i8) {
        this.f13994u.d(i8);
        this.f13979f.f14023u = false;
        S();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f13983j = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (!super.isStateful() && (((colorStateList = this.f13979f.f14009g) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.f13979f.f14008f) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.f13979f.f14007e) == null || !colorStateList3.isStateful()) && ((colorStateList4 = this.f13979f.f14006d) == null || !colorStateList4.isStateful()))))) {
            return false;
        }
        return true;
    }

    public void j0(int i8) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14019q != i8) {
            materialShapeDrawableState.f14019q = i8;
            S();
        }
    }

    public void k0(float f8, int i8) {
        n0(f8);
        m0(ColorStateList.valueOf(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int l(int i8) {
        float N = N() + z();
        ElevationOverlayProvider elevationOverlayProvider = this.f13979f.f14004b;
        if (elevationOverlayProvider != null) {
            return elevationOverlayProvider.c(i8, N);
        }
        return i8;
    }

    public void l0(float f8, ColorStateList colorStateList) {
        n0(f8);
        m0(colorStateList);
    }

    public void m0(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14007e != colorStateList) {
            materialShapeDrawableState.f14007e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f13979f = new MaterialShapeDrawableState(this.f13979f);
        return this;
    }

    public void n0(float f8) {
        this.f13979f.f14014l = f8;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f13983j = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z7;
        boolean o02 = o0(iArr);
        boolean p02 = p0();
        if (!o02 && !p02) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            invalidateSelf();
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        q(canvas, paint, path, this.f13979f.f14003a, rectF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(@NonNull Canvas canvas) {
        q(canvas, this.f13993t, this.f13986m, this.f13991r, v());
    }

    public float s() {
        return this.f13979f.f14003a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14015m != i8) {
            materialShapeDrawableState.f14015m = i8;
            S();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13979f.f14005c = colorFilter;
        S();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13979f.f14003a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i8) {
        setTintList(ColorStateList.valueOf(i8));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f13979f.f14009g = colorStateList;
        p0();
        S();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.f13979f;
        if (materialShapeDrawableState.f14010h != mode) {
            materialShapeDrawableState.f14010h = mode;
            p0();
            S();
        }
    }

    public float t() {
        return this.f13979f.f14003a.l().a(u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public RectF u() {
        this.f13987n.set(getBounds());
        return this.f13987n;
    }

    public float w() {
        return this.f13979f.f14017o;
    }

    public ColorStateList x() {
        return this.f13979f.f14006d;
    }

    public float y() {
        return this.f13979f.f14013k;
    }

    public float z() {
        return this.f13979f.f14016n;
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public MaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        this(ShapeAppearanceModel.e(context, attributeSet, i8, i9).m());
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    private MaterialShapeDrawable(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.f13980g = new ShapePath.ShadowCompatOperation[4];
        this.f13981h = new ShapePath.ShadowCompatOperation[4];
        this.f13982i = new BitSet(8);
        this.f13984k = new Matrix();
        this.f13985l = new Path();
        this.f13986m = new Path();
        this.f13987n = new RectF();
        this.f13988o = new RectF();
        this.f13989p = new Region();
        this.f13990q = new Region();
        Paint paint = new Paint(1);
        this.f13992s = paint;
        Paint paint2 = new Paint(1);
        this.f13993t = paint2;
        this.f13994u = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = ShapeAppearancePathProvider.k();
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.f13996w = shapeAppearancePathProvider;
        this.A = new RectF();
        this.B = true;
        this.f13979f = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        p0();
        o0(getState());
        this.f13995v = new ShapeAppearancePathProvider.PathListener() { // from class: com.google.android.material.shape.MaterialShapeDrawable.1
            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void a(@NonNull ShapePath shapePath, Matrix matrix, int i8) {
                MaterialShapeDrawable.this.f13982i.set(i8, shapePath.e());
                MaterialShapeDrawable.this.f13980g[i8] = shapePath.f(matrix);
            }

            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void b(@NonNull ShapePath shapePath, Matrix matrix, int i8) {
                MaterialShapeDrawable.this.f13982i.set(i8 + 4, shapePath.e());
                MaterialShapeDrawable.this.f13981h[i8] = shapePath.f(matrix);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public ShapeAppearanceModel f14003a;

        /* renamed from: b  reason: collision with root package name */
        public ElevationOverlayProvider f14004b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f14005c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f14006d;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f14007e;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f14008f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f14009g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f14010h;

        /* renamed from: i  reason: collision with root package name */
        public Rect f14011i;

        /* renamed from: j  reason: collision with root package name */
        public float f14012j;

        /* renamed from: k  reason: collision with root package name */
        public float f14013k;

        /* renamed from: l  reason: collision with root package name */
        public float f14014l;

        /* renamed from: m  reason: collision with root package name */
        public int f14015m;

        /* renamed from: n  reason: collision with root package name */
        public float f14016n;

        /* renamed from: o  reason: collision with root package name */
        public float f14017o;

        /* renamed from: p  reason: collision with root package name */
        public float f14018p;

        /* renamed from: q  reason: collision with root package name */
        public int f14019q;

        /* renamed from: r  reason: collision with root package name */
        public int f14020r;

        /* renamed from: s  reason: collision with root package name */
        public int f14021s;

        /* renamed from: t  reason: collision with root package name */
        public int f14022t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f14023u;

        /* renamed from: v  reason: collision with root package name */
        public Paint.Style f14024v;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.f14006d = null;
            this.f14007e = null;
            this.f14008f = null;
            this.f14009g = null;
            this.f14010h = PorterDuff.Mode.SRC_IN;
            this.f14011i = null;
            this.f14012j = 1.0f;
            this.f14013k = 1.0f;
            this.f14015m = 255;
            this.f14016n = 0.0f;
            this.f14017o = 0.0f;
            this.f14018p = 0.0f;
            this.f14019q = 0;
            this.f14020r = 0;
            this.f14021s = 0;
            this.f14022t = 0;
            this.f14023u = false;
            this.f14024v = Paint.Style.FILL_AND_STROKE;
            this.f14003a = shapeAppearanceModel;
            this.f14004b = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.f13983j = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
            this.f14006d = null;
            this.f14007e = null;
            this.f14008f = null;
            this.f14009g = null;
            this.f14010h = PorterDuff.Mode.SRC_IN;
            this.f14011i = null;
            this.f14012j = 1.0f;
            this.f14013k = 1.0f;
            this.f14015m = 255;
            this.f14016n = 0.0f;
            this.f14017o = 0.0f;
            this.f14018p = 0.0f;
            this.f14019q = 0;
            this.f14020r = 0;
            this.f14021s = 0;
            this.f14022t = 0;
            this.f14023u = false;
            this.f14024v = Paint.Style.FILL_AND_STROKE;
            this.f14003a = materialShapeDrawableState.f14003a;
            this.f14004b = materialShapeDrawableState.f14004b;
            this.f14014l = materialShapeDrawableState.f14014l;
            this.f14005c = materialShapeDrawableState.f14005c;
            this.f14006d = materialShapeDrawableState.f14006d;
            this.f14007e = materialShapeDrawableState.f14007e;
            this.f14010h = materialShapeDrawableState.f14010h;
            this.f14009g = materialShapeDrawableState.f14009g;
            this.f14015m = materialShapeDrawableState.f14015m;
            this.f14012j = materialShapeDrawableState.f14012j;
            this.f14021s = materialShapeDrawableState.f14021s;
            this.f14019q = materialShapeDrawableState.f14019q;
            this.f14023u = materialShapeDrawableState.f14023u;
            this.f14013k = materialShapeDrawableState.f14013k;
            this.f14016n = materialShapeDrawableState.f14016n;
            this.f14017o = materialShapeDrawableState.f14017o;
            this.f14018p = materialShapeDrawableState.f14018p;
            this.f14020r = materialShapeDrawableState.f14020r;
            this.f14022t = materialShapeDrawableState.f14022t;
            this.f14008f = materialShapeDrawableState.f14008f;
            this.f14024v = materialShapeDrawableState.f14024v;
            if (materialShapeDrawableState.f14011i != null) {
                this.f14011i = new Rect(materialShapeDrawableState.f14011i);
            }
        }
    }
}
