package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class KeyframeParser {

    /* renamed from: b  reason: collision with root package name */
    private static SparseArrayCompat<WeakReference<Interpolator>> f9569b;

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f9568a = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    static JsonReader.Options f9570c = JsonReader.Options.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* renamed from: d  reason: collision with root package name */
    static JsonReader.Options f9571d = JsonReader.Options.a("x", "y");

    KeyframeParser() {
    }

    private static WeakReference<Interpolator> a(int i8) {
        WeakReference<Interpolator> e8;
        synchronized (KeyframeParser.class) {
            e8 = g().e(i8);
        }
        return e8;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        Interpolator linearInterpolator;
        pointF.x = MiscUtils.b(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.b(pointF2.x, -1.0f, 1.0f);
        float b8 = MiscUtils.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b8;
        int i8 = Utils.i(pointF.x, pointF.y, pointF2.x, b8);
        WeakReference<Interpolator> a8 = a(i8);
        if (a8 != null) {
            interpolator = a8.get();
        } else {
            interpolator = null;
        }
        if (a8 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e8) {
                if ("The Path cannot loop back on itself.".equals(e8.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                h(i8, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Keyframe<T> c(JsonReader jsonReader, LottieComposition lottieComposition, float f8, ValueParser<T> valueParser, boolean z7, boolean z8) throws IOException {
        if (z7 && z8) {
            return e(lottieComposition, jsonReader, f8, valueParser);
        }
        if (z7) {
            return d(lottieComposition, jsonReader, f8, valueParser);
        }
        return f(jsonReader, f8, valueParser);
    }

    private static <T> Keyframe<T> d(LottieComposition lottieComposition, JsonReader jsonReader, float f8, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t7;
        jsonReader.e();
        PointF pointF = null;
        PointF pointF2 = null;
        T t8 = null;
        T t9 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z7 = false;
        float f9 = 0.0f;
        while (jsonReader.j()) {
            switch (jsonReader.I(f9570c)) {
                case 0:
                    f9 = (float) jsonReader.l();
                    break;
                case 1:
                    t9 = valueParser.a(jsonReader, f8);
                    break;
                case 2:
                    t8 = valueParser.a(jsonReader, f8);
                    break;
                case 3:
                    pointF = JsonUtils.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF2 = JsonUtils.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.m() == 1) {
                        z7 = true;
                        break;
                    } else {
                        z7 = false;
                        break;
                    }
                case 6:
                    pointF3 = JsonUtils.e(jsonReader, f8);
                    break;
                case 7:
                    pointF4 = JsonUtils.e(jsonReader, f8);
                    break;
                default:
                    jsonReader.O();
                    break;
            }
        }
        jsonReader.h();
        if (z7) {
            interpolator2 = f9568a;
            t7 = t9;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = b(pointF, pointF2);
            } else {
                interpolator = f9568a;
            }
            interpolator2 = interpolator;
            t7 = t8;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t9, t7, interpolator2, f9, null);
        keyframe.f9674o = pointF3;
        keyframe.f9675p = pointF4;
        return keyframe;
    }

    private static <T> Keyframe<T> e(LottieComposition lottieComposition, JsonReader jsonReader, float f8, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        Interpolator b8;
        Interpolator b9;
        T t7;
        PointF pointF;
        Keyframe<T> keyframe;
        PointF pointF2;
        float f9;
        PointF pointF3;
        float f10;
        jsonReader.e();
        PointF pointF4 = null;
        boolean z7 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t8 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f11 = 0.0f;
        PointF pointF11 = null;
        T t9 = null;
        while (jsonReader.j()) {
            switch (jsonReader.I(f9570c)) {
                case 0:
                    pointF2 = pointF4;
                    f11 = (float) jsonReader.l();
                    break;
                case 1:
                    pointF2 = pointF4;
                    t8 = valueParser.a(jsonReader, f8);
                    break;
                case 2:
                    pointF2 = pointF4;
                    t9 = valueParser.a(jsonReader, f8);
                    break;
                case 3:
                    pointF2 = pointF4;
                    f9 = f11;
                    PointF pointF12 = pointF11;
                    if (jsonReader.y() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.e();
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        float f14 = 0.0f;
                        float f15 = 0.0f;
                        while (jsonReader.j()) {
                            int I = jsonReader.I(f9571d);
                            if (I != 0) {
                                if (I != 1) {
                                    jsonReader.O();
                                } else {
                                    JsonReader.Token y7 = jsonReader.y();
                                    JsonReader.Token token = JsonReader.Token.NUMBER;
                                    if (y7 == token) {
                                        f15 = (float) jsonReader.l();
                                        f13 = f15;
                                    } else {
                                        jsonReader.c();
                                        f13 = (float) jsonReader.l();
                                        if (jsonReader.y() == token) {
                                            f15 = (float) jsonReader.l();
                                        } else {
                                            f15 = f13;
                                        }
                                        jsonReader.g();
                                    }
                                }
                            } else {
                                JsonReader.Token y8 = jsonReader.y();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (y8 == token2) {
                                    f14 = (float) jsonReader.l();
                                    f12 = f14;
                                } else {
                                    jsonReader.c();
                                    f12 = (float) jsonReader.l();
                                    if (jsonReader.y() == token2) {
                                        f14 = (float) jsonReader.l();
                                    } else {
                                        f14 = f12;
                                    }
                                    jsonReader.g();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f12, f13);
                        PointF pointF14 = new PointF(f14, f15);
                        jsonReader.h();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f11 = f9;
                        break;
                    } else {
                        pointF5 = JsonUtils.e(jsonReader, f8);
                        f11 = f9;
                        pointF11 = pointF12;
                        break;
                    }
                case 4:
                    if (jsonReader.y() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.e();
                        float f16 = 0.0f;
                        float f17 = 0.0f;
                        float f18 = 0.0f;
                        float f19 = 0.0f;
                        while (jsonReader.j()) {
                            PointF pointF15 = pointF11;
                            int I2 = jsonReader.I(f9571d);
                            if (I2 != 0) {
                                pointF3 = pointF4;
                                if (I2 != 1) {
                                    jsonReader.O();
                                } else {
                                    JsonReader.Token y9 = jsonReader.y();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (y9 == token3) {
                                        f19 = (float) jsonReader.l();
                                        f11 = f11;
                                        f17 = f19;
                                    } else {
                                        float f20 = f11;
                                        jsonReader.c();
                                        float l8 = (float) jsonReader.l();
                                        if (jsonReader.y() == token3) {
                                            f10 = (float) jsonReader.l();
                                        } else {
                                            f10 = l8;
                                        }
                                        jsonReader.g();
                                        f11 = f20;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f19 = f10;
                                        f17 = l8;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f21 = f11;
                                JsonReader.Token y10 = jsonReader.y();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (y10 == token4) {
                                    f18 = (float) jsonReader.l();
                                    f11 = f21;
                                    f16 = f18;
                                } else {
                                    jsonReader.c();
                                    f16 = (float) jsonReader.l();
                                    if (jsonReader.y() == token4) {
                                        f18 = (float) jsonReader.l();
                                    } else {
                                        f18 = f16;
                                    }
                                    jsonReader.g();
                                    f11 = f21;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f9 = f11;
                        PointF pointF16 = new PointF(f16, f17);
                        PointF pointF17 = new PointF(f18, f19);
                        jsonReader.h();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f11 = f9;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = JsonUtils.e(jsonReader, f8);
                        break;
                    }
                case 5:
                    if (jsonReader.m() == 1) {
                        z7 = true;
                    } else {
                        z7 = false;
                        continue;
                    }
                case 6:
                    pointF11 = JsonUtils.e(jsonReader, f8);
                    continue;
                case 7:
                    pointF4 = JsonUtils.e(jsonReader, f8);
                    continue;
                default:
                    pointF2 = pointF4;
                    jsonReader.O();
                    break;
            }
            pointF4 = pointF2;
        }
        PointF pointF18 = pointF4;
        float f22 = f11;
        PointF pointF19 = pointF11;
        jsonReader.h();
        if (z7) {
            interpolator = f9568a;
            t7 = t8;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                b8 = b(pointF7, pointF9);
                b9 = b(pointF8, pointF10);
                t7 = t9;
                interpolator = null;
                if (b8 == null && b9 != null) {
                    pointF = pointF19;
                    keyframe = new Keyframe<>(lottieComposition, t8, t7, b8, b9, f22, null);
                } else {
                    pointF = pointF19;
                    keyframe = new Keyframe<>(lottieComposition, t8, t7, interpolator, f22, null);
                }
                keyframe.f9674o = pointF;
                keyframe.f9675p = pointF18;
                return keyframe;
            } else {
                interpolator = f9568a;
            }
            t7 = t9;
        }
        b8 = null;
        b9 = null;
        if (b8 == null) {
        }
        pointF = pointF19;
        keyframe = new Keyframe<>(lottieComposition, t8, t7, interpolator, f22, null);
        keyframe.f9674o = pointF;
        keyframe.f9675p = pointF18;
        return keyframe;
    }

    private static <T> Keyframe<T> f(JsonReader jsonReader, float f8, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.a(jsonReader, f8));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (f9569b == null) {
            f9569b = new SparseArrayCompat<>();
        }
        return f9569b;
    }

    private static void h(int i8, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            f9569b.j(i8, weakReference);
        }
    }
}
