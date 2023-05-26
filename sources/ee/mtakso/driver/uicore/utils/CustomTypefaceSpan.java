package ee.mtakso.driver.uicore.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTypefaceSpan.kt */
/* loaded from: classes5.dex */
public final class CustomTypefaceSpan extends MetricAffectingSpan {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f35725g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Typeface f35726f;

    /* compiled from: CustomTypefaceSpan.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Paint paint, Typeface typeface) {
            int i8;
            Intrinsics.f(paint, "paint");
            Intrinsics.f(typeface, "typeface");
            Typeface typeface2 = paint.getTypeface();
            if (typeface2 != null) {
                i8 = typeface2.getStyle();
            } else {
                i8 = 0;
            }
            if ((i8 & (~typeface.getStyle()) & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            paint.setTypeface(typeface);
        }
    }

    public CustomTypefaceSpan(Typeface typeface) {
        Intrinsics.f(typeface, "typeface");
        this.f35726f = typeface;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint drawState) {
        Intrinsics.f(drawState, "drawState");
        f35725g.a(drawState, this.f35726f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.f(paint, "paint");
        f35725g.a(paint, this.f35726f);
    }
}
