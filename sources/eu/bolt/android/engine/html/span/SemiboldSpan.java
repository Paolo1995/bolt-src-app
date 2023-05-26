package eu.bolt.android.engine.html.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.core.content.res.ResourcesCompat;
import eu.bolt.android.engine.html.R$font;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemiboldSpan.kt */
/* loaded from: classes5.dex */
public final class SemiboldSpan extends MetricAffectingSpan {

    /* renamed from: f  reason: collision with root package name */
    private final Context f36891f;

    public SemiboldSpan(Context context) {
        Intrinsics.f(context, "context");
        this.f36891f = context;
    }

    private final void a(TextPaint textPaint) {
        if (textPaint != null) {
            textPaint.setTypeface(ResourcesCompat.h(this.f36891f, R$font.f36747a));
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
