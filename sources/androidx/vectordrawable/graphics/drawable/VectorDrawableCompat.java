package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* renamed from: p  reason: collision with root package name */
    static final PorterDuff.Mode f7946p = PorterDuff.Mode.SRC_IN;

    /* renamed from: g  reason: collision with root package name */
    private VectorDrawableCompatState f7947g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuffColorFilter f7948h;

    /* renamed from: i  reason: collision with root package name */
    private ColorFilter f7949i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7950j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7951k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable.ConstantState f7952l;

    /* renamed from: m  reason: collision with root package name */
    private final float[] f7953m;

    /* renamed from: n  reason: collision with root package name */
    private final Matrix f7954n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f7955o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VClipPath extends VPath {
        VClipPath() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f7982b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f7981a = PathParser.d(string2);
            }
            this.f7983c = TypedArrayUtils.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!TypedArrayUtils.j(xmlPullParser, "pathData")) {
                return;
            }
            TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7917d);
            f(k8, xmlPullParser);
            k8.recycle();
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class VObject {
        private VObject() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f8002a;

        /* renamed from: b  reason: collision with root package name */
        VPathRenderer f8003b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f8004c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f8005d;

        /* renamed from: e  reason: collision with root package name */
        boolean f8006e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f8007f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f8008g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f8009h;

        /* renamed from: i  reason: collision with root package name */
        int f8010i;

        /* renamed from: j  reason: collision with root package name */
        boolean f8011j;

        /* renamed from: k  reason: collision with root package name */
        boolean f8012k;

        /* renamed from: l  reason: collision with root package name */
        Paint f8013l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f8004c = null;
            this.f8005d = VectorDrawableCompat.f7946p;
            if (vectorDrawableCompatState != null) {
                this.f8002a = vectorDrawableCompatState.f8002a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f8003b);
                this.f8003b = vPathRenderer;
                if (vectorDrawableCompatState.f8003b.f7990e != null) {
                    vPathRenderer.f7990e = new Paint(vectorDrawableCompatState.f8003b.f7990e);
                }
                if (vectorDrawableCompatState.f8003b.f7989d != null) {
                    this.f8003b.f7989d = new Paint(vectorDrawableCompatState.f8003b.f7989d);
                }
                this.f8004c = vectorDrawableCompatState.f8004c;
                this.f8005d = vectorDrawableCompatState.f8005d;
                this.f8006e = vectorDrawableCompatState.f8006e;
            }
        }

        public boolean a(int i8, int i9) {
            if (i8 == this.f8007f.getWidth() && i9 == this.f8007f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.f8012k && this.f8008g == this.f8004c && this.f8009h == this.f8005d && this.f8011j == this.f8006e && this.f8010i == this.f8003b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void c(int i8, int i9) {
            if (this.f8007f == null || !a(i8, i9)) {
                this.f8007f = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
                this.f8012k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f8007f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f8013l == null) {
                Paint paint = new Paint();
                this.f8013l = paint;
                paint.setFilterBitmap(true);
            }
            this.f8013l.setAlpha(this.f8003b.getRootAlpha());
            this.f8013l.setColorFilter(colorFilter);
            return this.f8013l;
        }

        public boolean f() {
            if (this.f8003b.getRootAlpha() < 255) {
                return true;
            }
            return false;
        }

        public boolean g() {
            return this.f8003b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8002a;
        }

        public boolean h(int[] iArr) {
            boolean g8 = this.f8003b.g(iArr);
            this.f8012k |= g8;
            return g8;
        }

        public void i() {
            this.f8008g = this.f8004c;
            this.f8009h = this.f8005d;
            this.f8010i = this.f8003b.getRootAlpha();
            this.f8011j = this.f8006e;
            this.f8012k = false;
        }

        public void j(int i8, int i9) {
            this.f8007f.eraseColor(0);
            this.f8003b.b(new Canvas(this.f8007f), i8, i9, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.f8004c = null;
            this.f8005d = VectorDrawableCompat.f7946p;
            this.f8003b = new VPathRenderer();
        }
    }

    VectorDrawableCompat() {
        this.f7951k = true;
        this.f7953m = new float[9];
        this.f7954n = new Matrix();
        this.f7955o = new Rect();
        this.f7947g = new VectorDrawableCompatState();
    }

    static int a(int i8, float f8) {
        return (i8 & 16777215) | (((int) (Color.alpha(i8) * f8)) << 24);
    }

    public static VectorDrawableCompat b(@NonNull Resources resources, int i8, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f7945f = ResourcesCompat.f(resources, i8, theme);
            vectorDrawableCompat.f7952l = new VectorDrawableDelegateState(vectorDrawableCompat.f7945f.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i8);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e8) {
            Log.e("VectorDrawableCompat", "parser error", e8);
            return null;
        } catch (XmlPullParserException e9) {
            Log.e("VectorDrawableCompat", "parser error", e9);
            return null;
        }
    }

    public static VectorDrawableCompat c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f7947g;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f8003b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f7993h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z7 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.g(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f7969b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.f8001p.put(vFullPath.getPathName(), vFullPath);
                    }
                    z7 = false;
                    vectorDrawableCompatState.f8002a = vFullPath.f7984d | vectorDrawableCompatState.f8002a;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.e(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f7969b.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.f8001p.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f8002a = vClipPath.f7984d | vectorDrawableCompatState.f8002a;
                } else if ("group".equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.c(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f7969b.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.f8001p.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f8002a = vGroup2.f7978k | vectorDrawableCompatState.f8002a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (!z7) {
            return;
        }
        throw new XmlPullParserException("no path defined");
    }

    private boolean f() {
        if (isAutoMirrored() && DrawableCompat.f(this) == 1) {
            return true;
        }
        return false;
    }

    private static PorterDuff.Mode g(int i8, PorterDuff.Mode mode) {
        if (i8 != 3) {
            if (i8 != 5) {
                if (i8 != 9) {
                    switch (i8) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f7947g;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f8003b;
        vectorDrawableCompatState.f8005d = g(TypedArrayUtils.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c8 = TypedArrayUtils.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c8 != null) {
            vectorDrawableCompatState.f8004c = c8;
        }
        vectorDrawableCompatState.f8006e = TypedArrayUtils.a(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f8006e);
        vPathRenderer.f7996k = TypedArrayUtils.f(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f7996k);
        float f8 = TypedArrayUtils.f(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.f7997l);
        vPathRenderer.f7997l = f8;
        if (vPathRenderer.f7996k > 0.0f) {
            if (f8 > 0.0f) {
                vPathRenderer.f7994i = typedArray.getDimension(3, vPathRenderer.f7994i);
                float dimension = typedArray.getDimension(2, vPathRenderer.f7995j);
                vPathRenderer.f7995j = dimension;
                if (vPathRenderer.f7994i > 0.0f) {
                    if (dimension > 0.0f) {
                        vPathRenderer.setAlpha(TypedArrayUtils.f(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            vPathRenderer.f7999n = string;
                            vPathRenderer.f8001p.put(string, vPathRenderer);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.b(drawable);
            return false;
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f7947g.f8003b.f8001p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f7955o);
        if (this.f7955o.width() > 0 && this.f7955o.height() > 0) {
            ColorFilter colorFilter = this.f7949i;
            if (colorFilter == null) {
                colorFilter = this.f7948h;
            }
            canvas.getMatrix(this.f7954n);
            this.f7954n.getValues(this.f7953m);
            float abs = Math.abs(this.f7953m[0]);
            float abs2 = Math.abs(this.f7953m[4]);
            float abs3 = Math.abs(this.f7953m[1]);
            float abs4 = Math.abs(this.f7953m[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.f7955o.width() * abs));
            int min2 = Math.min(2048, (int) (this.f7955o.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f7955o;
                canvas.translate(rect.left, rect.top);
                if (f()) {
                    canvas.translate(this.f7955o.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f7955o.offsetTo(0, 0);
                this.f7947g.c(min, min2);
                if (!this.f7951k) {
                    this.f7947g.j(min, min2);
                } else if (!this.f7947g.b()) {
                    this.f7947g.j(min, min2);
                    this.f7947g.i();
                }
                this.f7947g.d(canvas, colorFilter, this.f7955o);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return DrawableCompat.d(drawable);
        }
        return this.f7947g.f8003b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f7947g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return DrawableCompat.e(drawable);
        }
        return this.f7949i;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f7945f != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.f7945f.getConstantState());
        }
        this.f7947g.f8002a = getChangingConfigurations();
        return this.f7947g;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f7947g.f8003b.f7995j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f7947g.f8003b.f7994i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z7) {
        this.f7951k = z7;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return DrawableCompat.h(drawable);
        }
        return this.f7947g.f8006e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        ColorStateList colorStateList;
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful() && ((vectorDrawableCompatState = this.f7947g) == null || (!vectorDrawableCompatState.g() && ((colorStateList = this.f7947g.f8004c) == null || !colorStateList.isStateful())))) {
            return false;
        }
        return true;
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f7950j && super.mutate() == this) {
            this.f7947g = new VectorDrawableCompatState(this.f7947g);
            this.f7950j = true;
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z7 = false;
        VectorDrawableCompatState vectorDrawableCompatState = this.f7947g;
        ColorStateList colorStateList = vectorDrawableCompatState.f8004c;
        if (colorStateList != null && (mode = vectorDrawableCompatState.f8005d) != null) {
            this.f7948h = j(this.f7948h, colorStateList, mode);
            invalidateSelf();
            z7 = true;
        }
        if (vectorDrawableCompatState.g() && vectorDrawableCompatState.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z7;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j8);
        } else {
            super.scheduleSelf(runnable, j8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.setAlpha(i8);
        } else if (this.f7947g.f8003b.getRootAlpha() != i8) {
            this.f7947g.f8003b.setRootAlpha(i8);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.j(drawable, z7);
        } else {
            this.f7947g.f8006e = z7;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i8) {
        super.setChangingConfigurations(i8);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i8, PorterDuff.Mode mode) {
        super.setColorFilter(i8, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z7) {
        super.setFilterBitmap(z7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f8, float f9) {
        super.setHotspot(f8, f9);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i8, int i9, int i10, int i11) {
        super.setHotspotBounds(i8, i9, i10, i11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.n(drawable, i8);
        } else {
            setTintList(ColorStateList.valueOf(i8));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f7947g;
        if (vectorDrawableCompatState.f8004c != colorStateList) {
            vectorDrawableCompatState.f8004c = colorStateList;
            this.f7948h = j(this.f7948h, colorStateList, vectorDrawableCompatState.f8005d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f7947g;
        if (vectorDrawableCompatState.f8005d != mode) {
            vectorDrawableCompatState.f8005d = mode;
            this.f7948h = j(this.f7948h, vectorDrawableCompatState.f8004c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            return drawable.setVisible(z7, z8);
        }
        return super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f8014a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f8014a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f8014a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8014a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f7945f = (VectorDrawable) this.f8014a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f7945f = (VectorDrawable) this.f8014a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f7945f = (VectorDrawable) this.f8014a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f7949i = colorFilter;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class VPath extends VObject {

        /* renamed from: a  reason: collision with root package name */
        protected PathParser.PathDataNode[] f7981a;

        /* renamed from: b  reason: collision with root package name */
        String f7982b;

        /* renamed from: c  reason: collision with root package name */
        int f7983c;

        /* renamed from: d  reason: collision with root package name */
        int f7984d;

        public VPath() {
            super();
            this.f7981a = null;
            this.f7983c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f7981a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.e(pathDataNodeArr, path);
            }
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f7981a;
        }

        public String getPathName() {
            return this.f7982b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.b(this.f7981a, pathDataNodeArr)) {
                this.f7981a = PathParser.f(pathDataNodeArr);
            } else {
                PathParser.j(this.f7981a, pathDataNodeArr);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.f7981a = null;
            this.f7983c = 0;
            this.f7982b = vPath.f7982b;
            this.f7984d = vPath.f7984d;
            this.f7981a = PathParser.f(vPath.f7981a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f7945f;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f7947g;
        vectorDrawableCompatState.f8003b = new VPathRenderer();
        TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7914a);
        i(k8, xmlPullParser, theme);
        k8.recycle();
        vectorDrawableCompatState.f8002a = getChangingConfigurations();
        vectorDrawableCompatState.f8012k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f7948h = j(this.f7948h, vectorDrawableCompatState.f8004c, vectorDrawableCompatState.f8005d);
    }

    VectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        this.f7951k = true;
        this.f7953m = new float[9];
        this.f7954n = new Matrix();
        this.f7955o = new Rect();
        this.f7947g = vectorDrawableCompatState;
        this.f7948h = j(this.f7948h, vectorDrawableCompatState.f8004c, vectorDrawableCompatState.f8005d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VFullPath extends VPath {

        /* renamed from: e  reason: collision with root package name */
        private int[] f7956e;

        /* renamed from: f  reason: collision with root package name */
        ComplexColorCompat f7957f;

        /* renamed from: g  reason: collision with root package name */
        float f7958g;

        /* renamed from: h  reason: collision with root package name */
        ComplexColorCompat f7959h;

        /* renamed from: i  reason: collision with root package name */
        float f7960i;

        /* renamed from: j  reason: collision with root package name */
        float f7961j;

        /* renamed from: k  reason: collision with root package name */
        float f7962k;

        /* renamed from: l  reason: collision with root package name */
        float f7963l;

        /* renamed from: m  reason: collision with root package name */
        float f7964m;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f7965n;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f7966o;

        /* renamed from: p  reason: collision with root package name */
        float f7967p;

        VFullPath() {
            this.f7958g = 0.0f;
            this.f7960i = 1.0f;
            this.f7961j = 1.0f;
            this.f7962k = 0.0f;
            this.f7963l = 1.0f;
            this.f7964m = 0.0f;
            this.f7965n = Paint.Cap.BUTT;
            this.f7966o = Paint.Join.MITER;
            this.f7967p = 4.0f;
        }

        private Paint.Cap e(int i8, Paint.Cap cap) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        return cap;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int i8, Paint.Join join) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        return join;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f7956e = null;
            if (!TypedArrayUtils.j(xmlPullParser, "pathData")) {
                return;
            }
            String string = typedArray.getString(0);
            if (string != null) {
                this.f7982b = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.f7981a = PathParser.d(string2);
            }
            this.f7959h = TypedArrayUtils.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.f7961j = TypedArrayUtils.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f7961j);
            this.f7965n = e(TypedArrayUtils.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f7965n);
            this.f7966o = f(TypedArrayUtils.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f7966o);
            this.f7967p = TypedArrayUtils.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f7967p);
            this.f7957f = TypedArrayUtils.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.f7960i = TypedArrayUtils.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f7960i);
            this.f7958g = TypedArrayUtils.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f7958g);
            this.f7963l = TypedArrayUtils.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f7963l);
            this.f7964m = TypedArrayUtils.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f7964m);
            this.f7962k = TypedArrayUtils.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f7962k);
            this.f7983c = TypedArrayUtils.g(typedArray, xmlPullParser, "fillType", 13, this.f7983c);
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean a() {
            if (!this.f7959h.i() && !this.f7957f.i()) {
                return false;
            }
            return true;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean b(int[] iArr) {
            return this.f7957f.j(iArr) | this.f7959h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7916c);
            h(k8, xmlPullParser, theme);
            k8.recycle();
        }

        float getFillAlpha() {
            return this.f7961j;
        }

        int getFillColor() {
            return this.f7959h.e();
        }

        float getStrokeAlpha() {
            return this.f7960i;
        }

        int getStrokeColor() {
            return this.f7957f.e();
        }

        float getStrokeWidth() {
            return this.f7958g;
        }

        float getTrimPathEnd() {
            return this.f7963l;
        }

        float getTrimPathOffset() {
            return this.f7964m;
        }

        float getTrimPathStart() {
            return this.f7962k;
        }

        void setFillAlpha(float f8) {
            this.f7961j = f8;
        }

        void setFillColor(int i8) {
            this.f7959h.k(i8);
        }

        void setStrokeAlpha(float f8) {
            this.f7960i = f8;
        }

        void setStrokeColor(int i8) {
            this.f7957f.k(i8);
        }

        void setStrokeWidth(float f8) {
            this.f7958g = f8;
        }

        void setTrimPathEnd(float f8) {
            this.f7963l = f8;
        }

        void setTrimPathOffset(float f8) {
            this.f7964m = f8;
        }

        void setTrimPathStart(float f8) {
            this.f7962k = f8;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.f7958g = 0.0f;
            this.f7960i = 1.0f;
            this.f7961j = 1.0f;
            this.f7962k = 0.0f;
            this.f7963l = 1.0f;
            this.f7964m = 0.0f;
            this.f7965n = Paint.Cap.BUTT;
            this.f7966o = Paint.Join.MITER;
            this.f7967p = 4.0f;
            this.f7956e = vFullPath.f7956e;
            this.f7957f = vFullPath.f7957f;
            this.f7958g = vFullPath.f7958g;
            this.f7960i = vFullPath.f7960i;
            this.f7959h = vFullPath.f7959h;
            this.f7983c = vFullPath.f7983c;
            this.f7961j = vFullPath.f7961j;
            this.f7962k = vFullPath.f7962k;
            this.f7963l = vFullPath.f7963l;
            this.f7964m = vFullPath.f7964m;
            this.f7965n = vFullPath.f7965n;
            this.f7966o = vFullPath.f7966o;
            this.f7967p = vFullPath.f7967p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VPathRenderer {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f7985q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f7986a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f7987b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f7988c;

        /* renamed from: d  reason: collision with root package name */
        Paint f7989d;

        /* renamed from: e  reason: collision with root package name */
        Paint f7990e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f7991f;

        /* renamed from: g  reason: collision with root package name */
        private int f7992g;

        /* renamed from: h  reason: collision with root package name */
        final VGroup f7993h;

        /* renamed from: i  reason: collision with root package name */
        float f7994i;

        /* renamed from: j  reason: collision with root package name */
        float f7995j;

        /* renamed from: k  reason: collision with root package name */
        float f7996k;

        /* renamed from: l  reason: collision with root package name */
        float f7997l;

        /* renamed from: m  reason: collision with root package name */
        int f7998m;

        /* renamed from: n  reason: collision with root package name */
        String f7999n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f8000o;

        /* renamed from: p  reason: collision with root package name */
        final ArrayMap<String, Object> f8001p;

        public VPathRenderer() {
            this.f7988c = new Matrix();
            this.f7994i = 0.0f;
            this.f7995j = 0.0f;
            this.f7996k = 0.0f;
            this.f7997l = 0.0f;
            this.f7998m = 255;
            this.f7999n = null;
            this.f8000o = null;
            this.f8001p = new ArrayMap<>();
            this.f7993h = new VGroup();
            this.f7986a = new Path();
            this.f7987b = new Path();
        }

        private static float a(float f8, float f9, float f10, float f11) {
            return (f8 * f11) - (f9 * f10);
        }

        private void c(VGroup vGroup, Matrix matrix, Canvas canvas, int i8, int i9, ColorFilter colorFilter) {
            vGroup.f7968a.set(matrix);
            vGroup.f7968a.preConcat(vGroup.f7977j);
            canvas.save();
            for (int i10 = 0; i10 < vGroup.f7969b.size(); i10++) {
                VObject vObject = vGroup.f7969b.get(i10);
                if (vObject instanceof VGroup) {
                    c((VGroup) vObject, vGroup.f7968a, canvas, i8, i9, colorFilter);
                } else if (vObject instanceof VPath) {
                    d(vGroup, (VPath) vObject, canvas, i8, i9, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(VGroup vGroup, VPath vPath, Canvas canvas, int i8, int i9, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f8 = i8 / this.f7996k;
            float f9 = i9 / this.f7997l;
            float min = Math.min(f8, f9);
            Matrix matrix = vGroup.f7968a;
            this.f7988c.set(matrix);
            this.f7988c.postScale(f8, f9);
            float e8 = e(matrix);
            if (e8 == 0.0f) {
                return;
            }
            vPath.d(this.f7986a);
            Path path = this.f7986a;
            this.f7987b.reset();
            if (vPath.c()) {
                Path path2 = this.f7987b;
                if (vPath.f7983c == 0) {
                    fillType2 = Path.FillType.WINDING;
                } else {
                    fillType2 = Path.FillType.EVEN_ODD;
                }
                path2.setFillType(fillType2);
                this.f7987b.addPath(path, this.f7988c);
                canvas.clipPath(this.f7987b);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            float f10 = vFullPath.f7962k;
            if (f10 != 0.0f || vFullPath.f7963l != 1.0f) {
                float f11 = vFullPath.f7964m;
                float f12 = (f10 + f11) % 1.0f;
                float f13 = (vFullPath.f7963l + f11) % 1.0f;
                if (this.f7991f == null) {
                    this.f7991f = new PathMeasure();
                }
                this.f7991f.setPath(this.f7986a, false);
                float length = this.f7991f.getLength();
                float f14 = f12 * length;
                float f15 = f13 * length;
                path.reset();
                if (f14 > f15) {
                    this.f7991f.getSegment(f14, length, path, true);
                    this.f7991f.getSegment(0.0f, f15, path, true);
                } else {
                    this.f7991f.getSegment(f14, f15, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f7987b.addPath(path, this.f7988c);
            if (vFullPath.f7959h.l()) {
                ComplexColorCompat complexColorCompat = vFullPath.f7959h;
                if (this.f7990e == null) {
                    Paint paint = new Paint(1);
                    this.f7990e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f7990e;
                if (complexColorCompat.h()) {
                    Shader f16 = complexColorCompat.f();
                    f16.setLocalMatrix(this.f7988c);
                    paint2.setShader(f16);
                    paint2.setAlpha(Math.round(vFullPath.f7961j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(VectorDrawableCompat.a(complexColorCompat.e(), vFullPath.f7961j));
                }
                paint2.setColorFilter(colorFilter);
                Path path3 = this.f7987b;
                if (vFullPath.f7983c == 0) {
                    fillType = Path.FillType.WINDING;
                } else {
                    fillType = Path.FillType.EVEN_ODD;
                }
                path3.setFillType(fillType);
                canvas.drawPath(this.f7987b, paint2);
            }
            if (vFullPath.f7957f.l()) {
                ComplexColorCompat complexColorCompat2 = vFullPath.f7957f;
                if (this.f7989d == null) {
                    Paint paint3 = new Paint(1);
                    this.f7989d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f7989d;
                Paint.Join join = vFullPath.f7966o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = vFullPath.f7965n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(vFullPath.f7967p);
                if (complexColorCompat2.h()) {
                    Shader f17 = complexColorCompat2.f();
                    f17.setLocalMatrix(this.f7988c);
                    paint4.setShader(f17);
                    paint4.setAlpha(Math.round(vFullPath.f7960i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.e(), vFullPath.f7960i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(vFullPath.f7958g * min * e8);
                canvas.drawPath(this.f7987b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a8 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max <= 0.0f) {
                return 0.0f;
            }
            return Math.abs(a8) / max;
        }

        public void b(Canvas canvas, int i8, int i9, ColorFilter colorFilter) {
            c(this.f7993h, f7985q, canvas, i8, i9, colorFilter);
        }

        public boolean f() {
            if (this.f8000o == null) {
                this.f8000o = Boolean.valueOf(this.f7993h.a());
            }
            return this.f8000o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f7993h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f7998m;
        }

        public void setAlpha(float f8) {
            setRootAlpha((int) (f8 * 255.0f));
        }

        public void setRootAlpha(int i8) {
            this.f7998m = i8;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f7988c = new Matrix();
            this.f7994i = 0.0f;
            this.f7995j = 0.0f;
            this.f7996k = 0.0f;
            this.f7997l = 0.0f;
            this.f7998m = 255;
            this.f7999n = null;
            this.f8000o = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.f8001p = arrayMap;
            this.f7993h = new VGroup(vPathRenderer.f7993h, arrayMap);
            this.f7986a = new Path(vPathRenderer.f7986a);
            this.f7987b = new Path(vPathRenderer.f7987b);
            this.f7994i = vPathRenderer.f7994i;
            this.f7995j = vPathRenderer.f7995j;
            this.f7996k = vPathRenderer.f7996k;
            this.f7997l = vPathRenderer.f7997l;
            this.f7992g = vPathRenderer.f7992g;
            this.f7998m = vPathRenderer.f7998m;
            this.f7999n = vPathRenderer.f7999n;
            String str = vPathRenderer.f7999n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f8000o = vPathRenderer.f8000o;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VGroup extends VObject {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f7968a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<VObject> f7969b;

        /* renamed from: c  reason: collision with root package name */
        float f7970c;

        /* renamed from: d  reason: collision with root package name */
        private float f7971d;

        /* renamed from: e  reason: collision with root package name */
        private float f7972e;

        /* renamed from: f  reason: collision with root package name */
        private float f7973f;

        /* renamed from: g  reason: collision with root package name */
        private float f7974g;

        /* renamed from: h  reason: collision with root package name */
        private float f7975h;

        /* renamed from: i  reason: collision with root package name */
        private float f7976i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f7977j;

        /* renamed from: k  reason: collision with root package name */
        int f7978k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f7979l;

        /* renamed from: m  reason: collision with root package name */
        private String f7980m;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VPath vClipPath;
            this.f7968a = new Matrix();
            this.f7969b = new ArrayList<>();
            this.f7970c = 0.0f;
            this.f7971d = 0.0f;
            this.f7972e = 0.0f;
            this.f7973f = 1.0f;
            this.f7974g = 1.0f;
            this.f7975h = 0.0f;
            this.f7976i = 0.0f;
            Matrix matrix = new Matrix();
            this.f7977j = matrix;
            this.f7980m = null;
            this.f7970c = vGroup.f7970c;
            this.f7971d = vGroup.f7971d;
            this.f7972e = vGroup.f7972e;
            this.f7973f = vGroup.f7973f;
            this.f7974g = vGroup.f7974g;
            this.f7975h = vGroup.f7975h;
            this.f7976i = vGroup.f7976i;
            this.f7979l = vGroup.f7979l;
            String str = vGroup.f7980m;
            this.f7980m = str;
            this.f7978k = vGroup.f7978k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f7977j);
            ArrayList<VObject> arrayList = vGroup.f7969b;
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                VObject vObject = arrayList.get(i8);
                if (vObject instanceof VGroup) {
                    this.f7969b.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vClipPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f7969b.add(vClipPath);
                    String str2 = vClipPath.f7982b;
                    if (str2 != null) {
                        arrayMap.put(str2, vClipPath);
                    }
                }
            }
        }

        private void d() {
            this.f7977j.reset();
            this.f7977j.postTranslate(-this.f7971d, -this.f7972e);
            this.f7977j.postScale(this.f7973f, this.f7974g);
            this.f7977j.postRotate(this.f7970c, 0.0f, 0.0f);
            this.f7977j.postTranslate(this.f7975h + this.f7971d, this.f7976i + this.f7972e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f7979l = null;
            this.f7970c = TypedArrayUtils.f(typedArray, xmlPullParser, "rotation", 5, this.f7970c);
            this.f7971d = typedArray.getFloat(1, this.f7971d);
            this.f7972e = typedArray.getFloat(2, this.f7972e);
            this.f7973f = TypedArrayUtils.f(typedArray, xmlPullParser, "scaleX", 3, this.f7973f);
            this.f7974g = TypedArrayUtils.f(typedArray, xmlPullParser, "scaleY", 4, this.f7974g);
            this.f7975h = TypedArrayUtils.f(typedArray, xmlPullParser, "translateX", 6, this.f7975h);
            this.f7976i = TypedArrayUtils.f(typedArray, xmlPullParser, "translateY", 7, this.f7976i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f7980m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean a() {
            for (int i8 = 0; i8 < this.f7969b.size(); i8++) {
                if (this.f7969b.get(i8).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean b(int[] iArr) {
            boolean z7 = false;
            for (int i8 = 0; i8 < this.f7969b.size(); i8++) {
                z7 |= this.f7969b.get(i8).b(iArr);
            }
            return z7;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7915b);
            e(k8, xmlPullParser);
            k8.recycle();
        }

        public String getGroupName() {
            return this.f7980m;
        }

        public Matrix getLocalMatrix() {
            return this.f7977j;
        }

        public float getPivotX() {
            return this.f7971d;
        }

        public float getPivotY() {
            return this.f7972e;
        }

        public float getRotation() {
            return this.f7970c;
        }

        public float getScaleX() {
            return this.f7973f;
        }

        public float getScaleY() {
            return this.f7974g;
        }

        public float getTranslateX() {
            return this.f7975h;
        }

        public float getTranslateY() {
            return this.f7976i;
        }

        public void setPivotX(float f8) {
            if (f8 != this.f7971d) {
                this.f7971d = f8;
                d();
            }
        }

        public void setPivotY(float f8) {
            if (f8 != this.f7972e) {
                this.f7972e = f8;
                d();
            }
        }

        public void setRotation(float f8) {
            if (f8 != this.f7970c) {
                this.f7970c = f8;
                d();
            }
        }

        public void setScaleX(float f8) {
            if (f8 != this.f7973f) {
                this.f7973f = f8;
                d();
            }
        }

        public void setScaleY(float f8) {
            if (f8 != this.f7974g) {
                this.f7974g = f8;
                d();
            }
        }

        public void setTranslateX(float f8) {
            if (f8 != this.f7975h) {
                this.f7975h = f8;
                d();
            }
        }

        public void setTranslateY(float f8) {
            if (f8 != this.f7976i) {
                this.f7976i = f8;
                d();
            }
        }

        public VGroup() {
            super();
            this.f7968a = new Matrix();
            this.f7969b = new ArrayList<>();
            this.f7970c = 0.0f;
            this.f7971d = 0.0f;
            this.f7972e = 0.0f;
            this.f7973f = 1.0f;
            this.f7974g = 1.0f;
            this.f7975h = 0.0f;
            this.f7976i = 0.0f;
            this.f7977j = new Matrix();
            this.f7980m = null;
        }
    }
}
