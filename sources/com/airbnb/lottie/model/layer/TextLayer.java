package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TextLayer extends BaseLayer {
    private final StringBuilder D;
    private final RectF E;
    private final Matrix F;
    private final Paint G;
    private final Paint H;
    private final Map<FontCharacter, List<ContentGroup>> I;
    private final LongSparseArray<String> J;
    private final TextKeyframeAnimation K;
    private final LottieDrawable L;
    private final LottieComposition M;
    private BaseKeyframeAnimation<Integer, Integer> N;
    private BaseKeyframeAnimation<Integer, Integer> O;
    private BaseKeyframeAnimation<Integer, Integer> P;
    private BaseKeyframeAnimation<Integer, Integer> Q;
    private BaseKeyframeAnimation<Float, Float> R;
    private BaseKeyframeAnimation<Float, Float> S;
    private BaseKeyframeAnimation<Float, Float> T;
    private BaseKeyframeAnimation<Float, Float> U;
    private BaseKeyframeAnimation<Float, Float> V;
    private BaseKeyframeAnimation<Typeface, Typeface> W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9513a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f9513a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9513a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9513a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new Paint(1) { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.H = new Paint(1) { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.I = new HashMap();
        this.J = new LongSparseArray<>();
        this.L = lottieDrawable;
        this.M = layer.b();
        TextKeyframeAnimation a8 = layer.s().a();
        this.K = a8;
        a8.a(this);
        i(a8);
        AnimatableTextProperties t7 = layer.t();
        if (t7 != null && (animatableColorValue2 = t7.f9305a) != null) {
            BaseKeyframeAnimation<Integer, Integer> a9 = animatableColorValue2.a();
            this.N = a9;
            a9.a(this);
            i(this.N);
        }
        if (t7 != null && (animatableColorValue = t7.f9306b) != null) {
            BaseKeyframeAnimation<Integer, Integer> a10 = animatableColorValue.a();
            this.P = a10;
            a10.a(this);
            i(this.P);
        }
        if (t7 != null && (animatableFloatValue2 = t7.f9307c) != null) {
            BaseKeyframeAnimation<Float, Float> a11 = animatableFloatValue2.a();
            this.R = a11;
            a11.a(this);
            i(this.R);
        }
        if (t7 != null && (animatableFloatValue = t7.f9308d) != null) {
            BaseKeyframeAnimation<Float, Float> a12 = animatableFloatValue.a();
            this.T = a12;
            a12.a(this);
            i(this.T);
        }
    }

    private void O(DocumentData.Justification justification, Canvas canvas, float f8) {
        int i8 = AnonymousClass3.f9513a[justification.ordinal()];
        if (i8 != 2) {
            if (i8 == 3) {
                canvas.translate((-f8) / 2.0f, 0.0f);
                return;
            }
            return;
        }
        canvas.translate(-f8, 0.0f);
    }

    private String P(String str, int i8) {
        int codePointAt = str.codePointAt(i8);
        int charCount = Character.charCount(codePointAt) + i8;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!c0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j8 = codePointAt;
        if (this.J.d(j8)) {
            return this.J.f(j8);
        }
        this.D.setLength(0);
        while (i8 < charCount) {
            int codePointAt3 = str.codePointAt(i8);
            this.D.appendCodePoint(codePointAt3);
            i8 += Character.charCount(codePointAt3);
        }
        String sb = this.D.toString();
        this.J.l(j8, sb);
        return sb;
    }

    private void Q(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void R(FontCharacter fontCharacter, Matrix matrix, float f8, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> Y = Y(fontCharacter);
        for (int i8 = 0; i8 < Y.size(); i8++) {
            Path path = Y.get(i8).getPath();
            path.computeBounds(this.E, false);
            this.F.set(matrix);
            this.F.preTranslate(0.0f, (-documentData.f9272g) * Utils.e());
            this.F.preScale(f8, f8);
            path.transform(this.F);
            if (documentData.f9276k) {
                U(path, this.G, canvas);
                U(path, this.H, canvas);
            } else {
                U(path, this.H, canvas);
                U(path, this.G, canvas);
            }
        }
    }

    private void S(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f9276k) {
            Q(str, this.G, canvas);
            Q(str, this.H, canvas);
            return;
        }
        Q(str, this.H, canvas);
        Q(str, this.G, canvas);
    }

    private void T(String str, DocumentData documentData, Canvas canvas, float f8) {
        int i8 = 0;
        while (i8 < str.length()) {
            String P = P(str, i8);
            i8 += P.length();
            S(P, documentData, canvas);
            canvas.translate(this.G.measureText(P) + f8, 0.0f);
        }
    }

    private void U(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void V(String str, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f8, float f9) {
        float floatValue;
        for (int i8 = 0; i8 < str.length(); i8++) {
            FontCharacter e8 = this.M.c().e(FontCharacter.c(str.charAt(i8), font.a(), font.c()));
            if (e8 != null) {
                R(e8, matrix, f9, documentData, canvas);
                float b8 = ((float) e8.b()) * f9 * Utils.e() * f8;
                float f10 = documentData.f9270e / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.U;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.h().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.T;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.h().floatValue();
                    }
                    canvas.translate(b8 + (f10 * f8), 0.0f);
                }
                f10 += floatValue;
                canvas.translate(b8 + (f10 * f8), 0.0f);
            }
        }
    }

    private void W(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f8;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.V;
        if (baseKeyframeAnimation != null) {
            f8 = baseKeyframeAnimation.h().floatValue();
        } else {
            f8 = documentData.f9268c;
        }
        float f9 = f8 / 100.0f;
        float g8 = Utils.g(matrix);
        String str = documentData.f9266a;
        float e8 = documentData.f9271f * Utils.e();
        List<String> a02 = a0(str);
        int size = a02.size();
        for (int i8 = 0; i8 < size; i8++) {
            String str2 = a02.get(i8);
            float Z = Z(str2, font, f9, g8);
            canvas.save();
            O(documentData.f9269d, canvas, Z);
            canvas.translate(0.0f, (i8 * e8) - (((size - 1) * e8) / 2.0f));
            V(str2, documentData, matrix, font, canvas, g8, f9);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0093 A[LOOP:0: B:20:0x0091->B:21:0x0093, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void X(com.airbnb.lottie.model.DocumentData r8, com.airbnb.lottie.model.Font r9, android.graphics.Canvas r10) {
        /*
            r7 = this;
            android.graphics.Typeface r9 = r7.b0(r9)
            if (r9 != 0) goto L7
            return
        L7:
            java.lang.String r0 = r8.f9266a
            com.airbnb.lottie.LottieDrawable r1 = r7.L
            com.airbnb.lottie.TextDelegate r1 = r1.W()
            if (r1 == 0) goto L19
            java.lang.String r2 = r7.getName()
            java.lang.String r0 = r1.c(r2, r0)
        L19:
            android.graphics.Paint r1 = r7.G
            r1.setTypeface(r9)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r9 = r7.V
            if (r9 == 0) goto L2d
            java.lang.Object r9 = r9.h()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            goto L2f
        L2d:
            float r9 = r8.f9268c
        L2f:
            android.graphics.Paint r1 = r7.G
            float r2 = com.airbnb.lottie.utils.Utils.e()
            float r2 = r2 * r9
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r7.H
            android.graphics.Paint r2 = r7.G
            android.graphics.Typeface r2 = r2.getTypeface()
            r1.setTypeface(r2)
            android.graphics.Paint r1 = r7.H
            android.graphics.Paint r2 = r7.G
            float r2 = r2.getTextSize()
            r1.setTextSize(r2)
            float r1 = r8.f9271f
            float r2 = com.airbnb.lottie.utils.Utils.e()
            float r1 = r1 * r2
            int r2 = r8.f9270e
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r3 = r7.U
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L6c:
            float r2 = r2 + r3
            goto L7d
        L6e:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r3 = r7.T
            if (r3 == 0) goto L7d
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L6c
        L7d:
            float r3 = com.airbnb.lottie.utils.Utils.e()
            float r2 = r2 * r3
            float r2 = r2 * r9
            r9 = 1120403456(0x42c80000, float:100.0)
            float r2 = r2 / r9
            java.util.List r9 = r7.a0(r0)
            int r0 = r9.size()
            r3 = 0
        L91:
            if (r3 >= r0) goto Lca
            java.lang.Object r4 = r9.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            android.graphics.Paint r5 = r7.H
            float r5 = r5.measureText(r4)
            int r6 = r4.length()
            int r6 = r6 + (-1)
            float r6 = (float) r6
            float r6 = r6 * r2
            float r5 = r5 + r6
            r10.save()
            com.airbnb.lottie.model.DocumentData$Justification r6 = r8.f9269d
            r7.O(r6, r10, r5)
            int r5 = r0 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r6 = (float) r3
            float r6 = r6 * r1
            float r6 = r6 - r5
            r5 = 0
            r10.translate(r5, r6)
            r7.T(r4, r8, r10, r2)
            r10.restore()
            int r3 = r3 + 1
            goto L91
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.X(com.airbnb.lottie.model.DocumentData, com.airbnb.lottie.model.Font, android.graphics.Canvas):void");
    }

    private List<ContentGroup> Y(FontCharacter fontCharacter) {
        if (this.I.containsKey(fontCharacter)) {
            return this.I.get(fontCharacter);
        }
        List<ShapeGroup> a8 = fontCharacter.a();
        int size = a8.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i8 = 0; i8 < size; i8++) {
            arrayList.add(new ContentGroup(this.L, this, a8.get(i8)));
        }
        this.I.put(fontCharacter, arrayList);
        return arrayList;
    }

    private float Z(String str, Font font, float f8, float f9) {
        float f10 = 0.0f;
        for (int i8 = 0; i8 < str.length(); i8++) {
            FontCharacter e8 = this.M.c().e(FontCharacter.c(str.charAt(i8), font.a(), font.c()));
            if (e8 != null) {
                f10 = (float) (f10 + (e8.b() * f8 * Utils.e() * f9));
            }
        }
        return f10;
    }

    private List<String> a0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface b0(Font font) {
        Typeface h8;
        BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation = this.W;
        if (baseKeyframeAnimation != null && (h8 = baseKeyframeAnimation.h()) != null) {
            return h8;
        }
        Typeface X = this.L.X(font.a(), font.c());
        if (X != null) {
            return X;
        }
        return font.d();
    }

    private boolean c0(int i8) {
        if (Character.getType(i8) != 16 && Character.getType(i8) != 27 && Character.getType(i8) != 6 && Character.getType(i8) != 28 && Character.getType(i8) != 8 && Character.getType(i8) != 19) {
            return false;
        }
        return true;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        super.d(t7, lottieValueCallback);
        if (t7 == LottieProperty.f8932a) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.O;
            if (baseKeyframeAnimation != null) {
                G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.O = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.O = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            i(this.O);
        } else if (t7 == LottieProperty.f8933b) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.Q;
            if (baseKeyframeAnimation2 != null) {
                G(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.Q = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.Q = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            i(this.Q);
        } else if (t7 == LottieProperty.f8950s) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.S;
            if (baseKeyframeAnimation3 != null) {
                G(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.S = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.S = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            i(this.S);
        } else if (t7 == LottieProperty.f8951t) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.U;
            if (baseKeyframeAnimation4 != null) {
                G(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.U = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.U = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a(this);
            i(this.U);
        } else if (t7 == LottieProperty.F) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.V;
            if (baseKeyframeAnimation5 != null) {
                G(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.V = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.V = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.a(this);
            i(this.V);
        } else if (t7 == LottieProperty.M) {
            BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation6 = this.W;
            if (baseKeyframeAnimation6 != null) {
                G(baseKeyframeAnimation6);
            }
            if (lottieValueCallback == null) {
                this.W = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation6 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.W = valueCallbackKeyframeAnimation6;
            valueCallbackKeyframeAnimation6.a(this);
            i(this.W);
        } else if (t7 == LottieProperty.O) {
            this.K.q(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        super.f(rectF, matrix, z7);
        rectF.set(0.0f, 0.0f, this.M.b().width(), this.M.b().height());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void t(Canvas canvas, Matrix matrix, int i8) {
        int intValue;
        canvas.save();
        if (!this.L.W0()) {
            canvas.concat(matrix);
        }
        DocumentData h8 = this.K.h();
        Font font = this.M.g().get(h8.f9267b);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.O;
        if (baseKeyframeAnimation != null) {
            this.G.setColor(baseKeyframeAnimation.h().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.N;
            if (baseKeyframeAnimation2 != null) {
                this.G.setColor(baseKeyframeAnimation2.h().intValue());
            } else {
                this.G.setColor(h8.f9273h);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.Q;
        if (baseKeyframeAnimation3 != null) {
            this.H.setColor(baseKeyframeAnimation3.h().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.P;
            if (baseKeyframeAnimation4 != null) {
                this.H.setColor(baseKeyframeAnimation4.h().intValue());
            } else {
                this.H.setColor(h8.f9274i);
            }
        }
        if (this.f9466x.h() == null) {
            intValue = 100;
        } else {
            intValue = this.f9466x.h().h().intValue();
        }
        int i9 = (intValue * 255) / 100;
        this.G.setAlpha(i9);
        this.H.setAlpha(i9);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.S;
        if (baseKeyframeAnimation5 != null) {
            this.H.setStrokeWidth(baseKeyframeAnimation5.h().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.R;
            if (baseKeyframeAnimation6 != null) {
                this.H.setStrokeWidth(baseKeyframeAnimation6.h().floatValue());
            } else {
                this.H.setStrokeWidth(h8.f9275j * Utils.e() * Utils.g(matrix));
            }
        }
        if (this.L.W0()) {
            W(h8, matrix, font, canvas);
        } else {
            X(h8, font, canvas);
        }
        canvas.restore();
    }
}
