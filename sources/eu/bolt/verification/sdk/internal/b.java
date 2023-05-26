package eu.bolt.verification.sdk.internal;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: classes5.dex */
public final class b implements LineHeightSpan {

    /* renamed from: f  reason: collision with root package name */
    private final int f42246f;

    public b(int i8) {
        this.f42246f = i8;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int i8, int i9, int i10, int i11, Paint.FontMetricsInt fm) {
        int b8;
        Intrinsics.f(text, "text");
        Intrinsics.f(fm, "fm");
        int i12 = fm.descent;
        int i13 = i12 - fm.ascent;
        if (i13 <= 0) {
            return;
        }
        b8 = MathKt__MathJVMKt.b(i12 * ((this.f42246f * 1.0f) / i13));
        fm.descent = b8;
        fm.ascent = b8 - this.f42246f;
    }
}
