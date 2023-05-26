package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import com.google.android.material.math.MathUtils;

/* loaded from: classes.dex */
public interface CircularRevealWidget {

    /* loaded from: classes.dex */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<RevealInfo> f13238b = new CircularRevealEvaluator();

        /* renamed from: a  reason: collision with root package name */
        private final RevealInfo f13239a = new RevealInfo();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* renamed from: a */
        public RevealInfo evaluate(float f8, @NonNull RevealInfo revealInfo, @NonNull RevealInfo revealInfo2) {
            this.f13239a.a(MathUtils.c(revealInfo.f13242a, revealInfo2.f13242a, f8), MathUtils.c(revealInfo.f13243b, revealInfo2.f13243b, f8), MathUtils.c(revealInfo.f13244c, revealInfo2.f13244c, f8));
            return this.f13239a;
        }
    }

    /* loaded from: classes.dex */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<CircularRevealWidget, RevealInfo> f13240a = new CircularRevealProperty("circularReveal");

        private CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public RevealInfo get(@NonNull CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    /* loaded from: classes.dex */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<CircularRevealWidget, Integer> f13241a = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull CircularRevealWidget circularRevealWidget, @NonNull Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class RevealInfo {

        /* renamed from: a  reason: collision with root package name */
        public float f13242a;

        /* renamed from: b  reason: collision with root package name */
        public float f13243b;

        /* renamed from: c  reason: collision with root package name */
        public float f13244c;

        private RevealInfo() {
        }

        public void a(float f8, float f9, float f10) {
            this.f13242a = f8;
            this.f13243b = f9;
            this.f13244c = f10;
        }

        public RevealInfo(float f8, float f9, float f10) {
            this.f13242a = f8;
            this.f13243b = f9;
            this.f13244c = f10;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i8);

    void setRevealInfo(RevealInfo revealInfo);
}
