package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.R$styleable;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GradientColorInflaterCompat {
    private GradientColorInflaterCompat() {
    }

    private static ColorStops a(ColorStops colorStops, int i8, int i9, boolean z7, int i10) {
        if (colorStops != null) {
            return colorStops;
        }
        if (z7) {
            return new ColorStops(i8, i10, i9);
        }
        return new ColorStops(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, R$styleable.A);
            float f8 = TypedArrayUtils.f(k8, xmlPullParser, "startX", R$styleable.J, 0.0f);
            float f9 = TypedArrayUtils.f(k8, xmlPullParser, "startY", R$styleable.K, 0.0f);
            float f10 = TypedArrayUtils.f(k8, xmlPullParser, "endX", R$styleable.L, 0.0f);
            float f11 = TypedArrayUtils.f(k8, xmlPullParser, "endY", R$styleable.M, 0.0f);
            float f12 = TypedArrayUtils.f(k8, xmlPullParser, "centerX", R$styleable.E, 0.0f);
            float f13 = TypedArrayUtils.f(k8, xmlPullParser, "centerY", R$styleable.F, 0.0f);
            int g8 = TypedArrayUtils.g(k8, xmlPullParser, "type", R$styleable.D, 0);
            int b8 = TypedArrayUtils.b(k8, xmlPullParser, "startColor", R$styleable.B, 0);
            boolean j8 = TypedArrayUtils.j(xmlPullParser, "centerColor");
            int b9 = TypedArrayUtils.b(k8, xmlPullParser, "centerColor", R$styleable.I, 0);
            int b10 = TypedArrayUtils.b(k8, xmlPullParser, "endColor", R$styleable.C, 0);
            int g9 = TypedArrayUtils.g(k8, xmlPullParser, "tileMode", R$styleable.H, 0);
            float f14 = TypedArrayUtils.f(k8, xmlPullParser, "gradientRadius", R$styleable.G, 0.0f);
            k8.recycle();
            ColorStops a8 = a(c(resources, xmlPullParser, attributeSet, theme), b8, b10, j8, b9);
            if (g8 != 1) {
                if (g8 != 2) {
                    return new LinearGradient(f8, f9, f10, f11, a8.f5707a, a8.f5708b, d(g9));
                }
                return new SweepGradient(f12, f13, a8.f5707a, a8.f5708b);
            } else if (f14 > 0.0f) {
                return new RadialGradient(f12, f13, f14, a8.f5707a, a8.f5708b, d(g9));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops c(@androidx.annotation.NonNull android.content.res.Resources r9, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r10, @androidx.annotation.NonNull android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L81
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L81
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R$styleable.N
            android.content.res.TypedArray r3 = androidx.core.content.res.TypedArrayUtils.k(r9, r12, r11, r3)
            int r5 = androidx.core.R$styleable.O
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R$styleable.P
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L81:
            int r9 = r4.size()
            if (r9 <= 0) goto L8d
            androidx.core.content.res.GradientColorInflaterCompat$ColorStops r9 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops
            r9.<init>(r4, r2)
            return r9
        L8d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.GradientColorInflaterCompat.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.GradientColorInflaterCompat$ColorStops");
    }

    private static Shader.TileMode d(int i8) {
        if (i8 != 1) {
            if (i8 != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ColorStops {

        /* renamed from: a  reason: collision with root package name */
        final int[] f5707a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f5708b;

        ColorStops(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            int size = list.size();
            this.f5707a = new int[size];
            this.f5708b = new float[size];
            for (int i8 = 0; i8 < size; i8++) {
                this.f5707a[i8] = list.get(i8).intValue();
                this.f5708b[i8] = list2.get(i8).floatValue();
            }
        }

        ColorStops(int i8, int i9) {
            this.f5707a = new int[]{i8, i9};
            this.f5708b = new float[]{0.0f, 1.0f};
        }

        ColorStops(int i8, int i9, int i10) {
            this.f5707a = new int[]{i8, i9, i10};
            this.f5708b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
