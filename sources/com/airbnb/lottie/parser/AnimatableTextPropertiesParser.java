package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class AnimatableTextPropertiesParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9532a = JsonReader.Options.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9533b = JsonReader.Options.a("fc", "sc", "sw", "t");

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.e();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.j()) {
            if (jsonReader.I(f9532a) != 0) {
                jsonReader.N();
                jsonReader.O();
            } else {
                animatableTextProperties = b(jsonReader, lottieComposition);
            }
        }
        jsonReader.h();
        if (animatableTextProperties == null) {
            return new AnimatableTextProperties(null, null, null, null);
        }
        return animatableTextProperties;
    }

    private static AnimatableTextProperties b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.e();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9533b);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            jsonReader.N();
                            jsonReader.O();
                        } else {
                            animatableFloatValue2 = AnimatableValueParser.e(jsonReader, lottieComposition);
                        }
                    } else {
                        animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
                    }
                } else {
                    animatableColorValue2 = AnimatableValueParser.c(jsonReader, lottieComposition);
                }
            } else {
                animatableColorValue = AnimatableValueParser.c(jsonReader, lottieComposition);
            }
        }
        jsonReader.h();
        return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }
}
