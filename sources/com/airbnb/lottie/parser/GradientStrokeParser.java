package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
class GradientStrokeParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9562a = JsonReader.Options.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9563b = JsonReader.Options.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.Options f9564c = JsonReader.Options.a("n", "v");

    private GradientStrokeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GradientStroke a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableGradientColorValue animatableGradientColorValue;
        GradientType gradientType;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType2 = null;
        AnimatableGradientColorValue animatableGradientColorValue2 = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f8 = 0.0f;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z7 = false;
        AnimatableIntegerValue animatableIntegerValue = null;
        while (jsonReader.j()) {
            switch (jsonReader.I(f9562a)) {
                case 0:
                    str = jsonReader.t();
                    break;
                case 1:
                    int i8 = -1;
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int I = jsonReader.I(f9563b);
                        if (I != 0) {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            if (I != 1) {
                                jsonReader.N();
                                jsonReader.O();
                            } else {
                                animatableGradientColorValue2 = AnimatableValueParser.g(jsonReader, lottieComposition, i8);
                            }
                        } else {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            i8 = jsonReader.m();
                        }
                        animatableGradientColorValue2 = animatableGradientColorValue;
                    }
                    jsonReader.h();
                    break;
                case 2:
                    animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
                    break;
                case 3:
                    if (jsonReader.m() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    animatablePointValue = AnimatableValueParser.i(jsonReader, lottieComposition);
                    break;
                case 5:
                    animatablePointValue2 = AnimatableValueParser.i(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m() - 1];
                    break;
                case 9:
                    f8 = (float) jsonReader.l();
                    break;
                case 10:
                    z7 = jsonReader.k();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        String str2 = null;
                        AnimatableFloatValue animatableFloatValue3 = null;
                        while (jsonReader.j()) {
                            int I2 = jsonReader.I(f9564c);
                            if (I2 != 0) {
                                AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                                if (I2 != 1) {
                                    jsonReader.N();
                                    jsonReader.O();
                                } else {
                                    animatableFloatValue3 = AnimatableValueParser.e(jsonReader, lottieComposition);
                                }
                                animatableFloatValue2 = animatableFloatValue4;
                            } else {
                                str2 = jsonReader.t();
                            }
                        }
                        AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                        jsonReader.h();
                        if (str2.equals("o")) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                lottieComposition.u(true);
                                arrayList.add(animatableFloatValue3);
                            }
                            animatableFloatValue2 = animatableFloatValue5;
                        }
                    }
                    AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                    jsonReader.g();
                    if (arrayList.size() == 1) {
                        arrayList.add((AnimatableFloatValue) arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue6;
                    break;
                default:
                    jsonReader.N();
                    jsonReader.O();
                    break;
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return new GradientStroke(str, gradientType2, animatableGradientColorValue2, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f8, arrayList, animatableFloatValue2, z7);
    }
}
