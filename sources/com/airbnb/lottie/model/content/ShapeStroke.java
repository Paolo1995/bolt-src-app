package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeStroke implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9414a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableFloatValue f9415b;

    /* renamed from: c  reason: collision with root package name */
    private final List<AnimatableFloatValue> f9416c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableColorValue f9417d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f9418e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f9419f;

    /* renamed from: g  reason: collision with root package name */
    private final LineCapType f9420g;

    /* renamed from: h  reason: collision with root package name */
    private final LineJoinType f9421h;

    /* renamed from: i  reason: collision with root package name */
    private final float f9422i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f9423j;

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9424a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9425b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f9425b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9425b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9425b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f9424a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9424a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9424a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i8 = AnonymousClass1.f9424a[ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i8 = AnonymousClass1.f9425b[ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f8, boolean z7) {
        this.f9414a = str;
        this.f9415b = animatableFloatValue;
        this.f9416c = list;
        this.f9417d = animatableColorValue;
        this.f9418e = animatableIntegerValue;
        this.f9419f = animatableFloatValue2;
        this.f9420g = lineCapType;
        this.f9421h = lineJoinType;
        this.f9422i = f8;
        this.f9423j = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }

    public LineCapType b() {
        return this.f9420g;
    }

    public AnimatableColorValue c() {
        return this.f9417d;
    }

    public AnimatableFloatValue d() {
        return this.f9415b;
    }

    public LineJoinType e() {
        return this.f9421h;
    }

    public List<AnimatableFloatValue> f() {
        return this.f9416c;
    }

    public float g() {
        return this.f9422i;
    }

    public String h() {
        return this.f9414a;
    }

    public AnimatableIntegerValue i() {
        return this.f9418e;
    }

    public AnimatableFloatValue j() {
        return this.f9419f;
    }

    public boolean k() {
        return this.f9423j;
    }
}
