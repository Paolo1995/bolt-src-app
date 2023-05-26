package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class RoundedCornersParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9587a = JsonReader.Options.a("nm", "r", "hd");

    private RoundedCornersParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RoundedCorners a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z7 = false;
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9587a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        jsonReader.O();
                    } else {
                        z7 = jsonReader.k();
                    }
                } else {
                    animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, true);
                }
            } else {
                str = jsonReader.t();
            }
        }
        if (z7) {
            return null;
        }
        return new RoundedCorners(str, animatableFloatValue);
    }
}
