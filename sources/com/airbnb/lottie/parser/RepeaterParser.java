package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class RepeaterParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9586a = JsonReader.Options.a("nm", "c", "o", "tr", "hd");

    private RepeaterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Repeater a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9586a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            if (I != 4) {
                                jsonReader.O();
                            } else {
                                z7 = jsonReader.k();
                            }
                        } else {
                            animatableTransform = AnimatableTransformParser.g(jsonReader, lottieComposition);
                        }
                    } else {
                        animatableFloatValue2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    }
                } else {
                    animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                }
            } else {
                str = jsonReader.t();
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform, z7);
    }
}
