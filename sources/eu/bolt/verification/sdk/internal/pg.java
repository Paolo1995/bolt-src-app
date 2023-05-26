package eu.bolt.verification.sdk.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.style.LineBackgroundSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes5.dex */
public final class pg implements LineBackgroundSpan {

    /* renamed from: m  reason: collision with root package name */
    public static final a f44538m = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final int f44539f;

    /* renamed from: g  reason: collision with root package name */
    private final float f44540g;

    /* renamed from: h  reason: collision with root package name */
    private final b f44541h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f44542i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f44543j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f44544k;

    /* renamed from: l  reason: collision with root package name */
    private final float[] f44545l;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        int a();

        Integer b(int i8);

        Integer c(int i8);

        Integer d(int i8);

        Integer e(int i8);
    }

    public pg(int i8, int i9, float f8, b lineInfoProvider) {
        Intrinsics.f(lineInfoProvider, "lineInfoProvider");
        this.f44539f = i9;
        this.f44540g = f8;
        this.f44541h = lineInfoProvider;
        this.f44542i = new Path();
        Paint paint = new Paint(1);
        paint.setColor(i8);
        this.f44543j = paint;
        this.f44544k = new RectF();
        this.f44545l = new float[8];
    }

    private final void a(int i8, int i9, int i10, int i11, float f8, float f9, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f44542i.rewind();
        qg.b(this.f44545l, 0, f8, f9, z7);
        qg.b(this.f44545l, 2, f8, f9, z8);
        qg.b(this.f44545l, 4, f8, f9, z9);
        qg.b(this.f44545l, 6, f8, f9, z10);
        this.f44544k.set(i8, i9, i10, i11);
        this.f44542i.addRoundRect(this.f44544k, this.f44545l, Path.Direction.CW);
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int i8, int i9, int i10, int i11, int i12, CharSequence text, int i13, int i14, int i15) {
        boolean y7;
        float i16;
        float i17;
        Intrinsics.f(canvas, "canvas");
        Intrinsics.f(paint, "paint");
        Intrinsics.f(text, "text");
        y7 = StringsKt__StringsJVMKt.y(text.subSequence(i13, i14));
        if (y7) {
            return;
        }
        Integer e8 = this.f44541h.e(i15);
        Integer d8 = this.f44541h.d(i15);
        boolean y8 = (e8 == null || d8 == null) ? false : StringsKt__StringsJVMKt.y(text.subSequence(e8.intValue(), d8.intValue()));
        Integer c8 = this.f44541h.c(i15);
        Integer b8 = this.f44541h.b(i15);
        boolean y9 = (c8 == null || b8 == null) ? false : StringsKt__StringsJVMKt.y(text.subSequence(c8.intValue(), b8.intValue()));
        int measureText = (int) paint.measureText(text, i13, i14);
        int i18 = this.f44539f;
        int i19 = i8 + measureText + i18;
        int i20 = i8 - i18;
        int i21 = y8 ? i10 - paint.getFontMetricsInt().leading : i10;
        i16 = RangesKt___RangesKt.i(this.f44540g, 0.0f, (i19 - i20) / 2.0f);
        i17 = RangesKt___RangesKt.i(this.f44540g, 0.0f, (i12 - i21) / 2.0f);
        a(i20, i21, i19, i12, i16, i17, i15 == 0 || y8, e8 == null || measureText > ((int) paint.measureText(text, e8.intValue(), i13)), b8 == null || measureText > ((int) paint.measureText(text, i14, b8.intValue())), i15 == this.f44541h.a() - 1 || y9);
        canvas.drawPath(this.f44542i, this.f44543j);
    }
}
