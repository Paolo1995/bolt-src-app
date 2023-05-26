package eu.bolt.android.engine.html.span;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import android.widget.TextView;
import eu.bolt.android.engine.html.span.ViewBoundSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: FontLineHeightSpan.kt */
/* loaded from: classes5.dex */
public final class FontLineHeightSpan implements LineHeightSpan, ViewBoundSpan {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f36884j = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final float f36885f;

    /* renamed from: g  reason: collision with root package name */
    private int f36886g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f36887h = -1;

    /* renamed from: i  reason: collision with root package name */
    private float f36888i;

    /* compiled from: FontLineHeightSpan.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FontLineHeightSpan(float f8) {
        this.f36885f = f8;
    }

    @Override // eu.bolt.android.engine.html.span.ViewBoundSpan
    public void a(TextView textView) {
        ViewBoundSpan.DefaultImpls.a(this, textView);
    }

    @Override // eu.bolt.android.engine.html.span.ViewBoundSpan
    public void b(TextView textView) {
        Intrinsics.f(textView, "textView");
        c(textView.getLineSpacingExtra());
    }

    public final void c(float f8) {
        this.f36888i = this.f36885f - f8;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i8, int i9, int i10, int i11, Paint.FontMetricsInt fm) {
        int b8;
        int b9;
        int b10;
        Intrinsics.f(fm, "fm");
        if (this.f36887h == -1) {
            this.f36887h = fm.descent - fm.ascent;
        }
        if (this.f36886g == -1) {
            this.f36886g = fm.descent;
        }
        int i12 = this.f36887h;
        if (i12 <= 0) {
            return;
        }
        float f8 = i12 + this.f36888i;
        float f9 = (1.0f * f8) / i12;
        b8 = MathKt__MathJVMKt.b(this.f36886g * f9);
        fm.descent = b8;
        b9 = MathKt__MathJVMKt.b((this.f36886g * f9) - f8);
        fm.ascent = b9;
        b10 = MathKt__MathJVMKt.b(this.f36888i);
        fm.leading = b10;
    }
}
