package eu.bolt.android.engine.html.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import eu.bolt.android.engine.html.font.NativeFontStyle;
import eu.bolt.android.engine.html.util.ContextExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontSpan.kt */
/* loaded from: classes5.dex */
public final class FontSpan extends MetricAffectingSpan {

    /* renamed from: f  reason: collision with root package name */
    private final Context f36889f;

    /* renamed from: g  reason: collision with root package name */
    private final NativeFontStyle f36890g;

    public FontSpan(Context context, NativeFontStyle nativeFontStyle) {
        Intrinsics.f(context, "context");
        Intrinsics.f(nativeFontStyle, "nativeFontStyle");
        this.f36889f = context;
        this.f36890g = nativeFontStyle;
    }

    private final void a(TextPaint textPaint) {
        float a8 = ContextExtKt.a(this.f36889f, this.f36890g.a());
        if (textPaint != null) {
            textPaint.setTextSize(a8);
            Float b8 = this.f36890g.b();
            if (b8 != null) {
                textPaint.setLetterSpacing(b8.floatValue());
            }
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.f(textPaint, "textPaint");
        a(textPaint);
    }
}
