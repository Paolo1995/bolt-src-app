package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class ShapeTrimPathParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9596a = JsonReader.Options.a("s", "e", "o", "nm", "m", "hd");

    private ShapeTrimPathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9596a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            if (I != 4) {
                                if (I != 5) {
                                    jsonReader.O();
                                } else {
                                    z7 = jsonReader.k();
                                }
                            } else {
                                type = ShapeTrimPath.Type.a(jsonReader.m());
                            }
                        } else {
                            str = jsonReader.t();
                        }
                    } else {
                        animatableFloatValue3 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    }
                } else {
                    animatableFloatValue2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                }
            } else {
                animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            }
        }
        return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, z7);
    }
}
