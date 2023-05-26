package eu.bolt.android.rib.xray;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: XRayDrawable.kt */
/* loaded from: classes5.dex */
public final class XRayDrawable extends Drawable {

    /* renamed from: m  reason: collision with root package name */
    private static final Companion f37406m = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f37407a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Boolean> f37408b;

    /* renamed from: c  reason: collision with root package name */
    private final Random f37409c;

    /* renamed from: d  reason: collision with root package name */
    private final float f37410d;

    /* renamed from: e  reason: collision with root package name */
    private final float f37411e;

    /* renamed from: f  reason: collision with root package name */
    private final int f37412f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f37413g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f37414h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f37415i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f37416j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f37417k;

    /* renamed from: l  reason: collision with root package name */
    private final Rect f37418l;

    /* compiled from: XRayDrawable.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XRayDrawable(String text, Function0<Boolean> shouldDraw) {
        int g8;
        int d8;
        int g9;
        int d9;
        int g10;
        Intrinsics.f(text, "text");
        Intrinsics.f(shouldDraw, "shouldDraw");
        this.f37407a = text;
        this.f37408b = shouldDraw;
        Random a8 = RandomKt.a(System.currentTimeMillis());
        this.f37409c = a8;
        this.f37410d = (-25) + (50 * a8.c());
        this.f37411e = (a8.c() * 0.8f) + 0.1f;
        g8 = RangesKt___RangesKt.g(360, 255);
        int e8 = a8.e(g8);
        d8 = RangesKt___RangesKt.d(360 - e8, 0);
        g9 = RangesKt___RangesKt.g(d8, 255);
        int e9 = a8.e(g9);
        d9 = RangesKt___RangesKt.d(d8 - e9, 0);
        g10 = RangesKt___RangesKt.g(d9, 255);
        int argb = Color.argb(255, e8, e9, a8.e(g10));
        this.f37412f = argb;
        Paint paint = new Paint();
        paint.setTextSize(30.0f);
        paint.setColor(-1);
        this.f37413g = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(argb);
        this.f37414h = paint2;
        Paint paint3 = new Paint();
        paint3.setStrokeWidth(12.0f);
        paint3.setColor(argb);
        paint3.setStyle(Paint.Style.STROKE);
        this.f37415i = paint3;
        Paint paint4 = new Paint();
        paint4.setStrokeWidth(4.0f);
        paint4.setColor(argb);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        this.f37416j = paint4;
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        this.f37417k = rect;
        this.f37418l = new Rect();
    }

    @Override // android.graphics.drawable.Drawable
    @SuppressLint({"CanvasSize"})
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        if (!this.f37408b.invoke().booleanValue()) {
            return;
        }
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        float width2 = (width - this.f37417k.width()) * this.f37411e;
        float height2 = ((this.f37417k.height() + height) / 2.0f) + this.f37410d;
        this.f37418l.set(0, 0, width, height);
        canvas.drawRect(this.f37418l, this.f37415i);
        this.f37418l.set(this.f37417k);
        this.f37418l.inset(-8, -8);
        this.f37418l.offset((int) width2, (int) height2);
        canvas.drawRect(this.f37418l, this.f37414h);
        canvas.drawText(this.f37407a, width2, height2, this.f37413g);
        float centerY = this.f37418l.centerY();
        canvas.drawLine(0.0f, centerY, width2, centerY, this.f37416j);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
