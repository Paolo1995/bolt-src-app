package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;

/* loaded from: classes.dex */
class GradientFillParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9560a = JsonReader.Options.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9561b = JsonReader.Options.a("p", "k");

    private GradientFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GradientFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue;
        GradientType gradientType;
        Path.FillType fillType;
        AnimatableIntegerValue animatableIntegerValue2 = null;
        Path.FillType fillType2 = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType2 = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            switch (jsonReader.I(f9560a)) {
                case 0:
                    str = jsonReader.t();
                    break;
                case 1:
                    int i8 = -1;
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int I = jsonReader.I(f9561b);
                        if (I != 0) {
                            if (I != 1) {
                                jsonReader.N();
                                jsonReader.O();
                            } else {
                                animatableGradientColorValue = AnimatableValueParser.g(jsonReader, lottieComposition, i8);
                            }
                        } else {
                            i8 = jsonReader.m();
                        }
                    }
                    jsonReader.h();
                    break;
                case 2:
                    animatableIntegerValue2 = AnimatableValueParser.h(jsonReader, lottieComposition);
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
                    if (jsonReader.m() == 1) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    fillType2 = fillType;
                    break;
                case 7:
                    z7 = jsonReader.k();
                    break;
                default:
                    jsonReader.N();
                    jsonReader.O();
                    break;
            }
        }
        if (animatableIntegerValue2 == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        } else {
            animatableIntegerValue = animatableIntegerValue2;
        }
        return new GradientFill(str, gradientType2, fillType2, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, null, null, z7);
    }
}
