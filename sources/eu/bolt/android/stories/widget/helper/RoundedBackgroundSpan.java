package eu.bolt.android.stories.widget.helper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.style.LineBackgroundSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: RoundedBackgroundSpan.kt */
/* loaded from: classes5.dex */
public final class RoundedBackgroundSpan implements LineBackgroundSpan {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f37618m = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final int f37619f;

    /* renamed from: g  reason: collision with root package name */
    private final float f37620g;

    /* renamed from: h  reason: collision with root package name */
    private final LineInfoProvider f37621h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f37622i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f37623j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f37624k;

    /* renamed from: l  reason: collision with root package name */
    private final float[] f37625l;

    /* compiled from: RoundedBackgroundSpan.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RoundedBackgroundSpan.kt */
    /* loaded from: classes5.dex */
    public interface LineInfoProvider {
        Integer a(int i8);

        int b();

        Integer c(int i8);
    }

    public RoundedBackgroundSpan(int i8, int i9, float f8, LineInfoProvider lineInfoProvider) {
        Intrinsics.f(lineInfoProvider, "lineInfoProvider");
        this.f37619f = i9;
        this.f37620g = f8;
        this.f37621h = lineInfoProvider;
        this.f37622i = new Path();
        Paint paint = new Paint(1);
        paint.setColor(i8);
        this.f37623j = paint;
        this.f37624k = new RectF();
        this.f37625l = new float[8];
    }

    private final void a(float[] fArr, int i8, float f8, float f9, boolean z7) {
        if (!z7) {
            f8 = 0.0f;
        }
        fArr[i8] = f8;
        int i9 = i8 + 1;
        if (!z7) {
            f9 = 0.0f;
        }
        fArr[i9] = f9;
    }

    private final void b(int i8, int i9, int i10, int i11, float f8, float f9, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f37622i.rewind();
        a(this.f37625l, 0, f8, f9, z7);
        a(this.f37625l, 2, f8, f9, z8);
        a(this.f37625l, 4, f8, f9, z9);
        a(this.f37625l, 6, f8, f9, z10);
        this.f37624k.set(i8, i9, i10, i11);
        this.f37622i.addRoundRect(this.f37624k, this.f37625l, Path.Direction.CW);
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int i8, int i9, int i10, int i11, int i12, CharSequence text, int i13, int i14, int i15) {
        float i16;
        float i17;
        Intrinsics.f(canvas, "canvas");
        Intrinsics.f(paint, "paint");
        Intrinsics.f(text, "text");
        int measureText = (int) paint.measureText(text, i13, i14);
        int i18 = this.f37619f;
        int i19 = i8 + measureText + i18;
        int i20 = i8 - i18;
        i16 = RangesKt___RangesKt.i(this.f37620g, 0.0f, (i19 - i20) / 2.0f);
        i17 = RangesKt___RangesKt.i(this.f37620g, 0.0f, (i12 - i10) / 2.0f);
        boolean z7 = i15 == 0;
        boolean z8 = i15 == this.f37621h.b() - 1;
        Integer c8 = this.f37621h.c(i15);
        Integer a8 = this.f37621h.a(i15);
        b(i20, i10, i19, i12, i16, i17, z7, c8 == null || measureText > ((int) paint.measureText(text, c8.intValue(), i13)), a8 == null || measureText > ((int) paint.measureText(text, i14, a8.intValue())), z8);
        canvas.drawPath(this.f37622i, this.f37623j);
    }
}
