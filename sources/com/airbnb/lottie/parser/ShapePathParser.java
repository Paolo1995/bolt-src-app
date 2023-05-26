package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class ShapePathParser {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.Options f9593a = JsonReader.Options.a("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapePath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        int i8 = 0;
        String str = null;
        AnimatableShapeValue animatableShapeValue = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9593a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            jsonReader.O();
                        } else {
                            z7 = jsonReader.k();
                        }
                    } else {
                        animatableShapeValue = AnimatableValueParser.k(jsonReader, lottieComposition);
                    }
                } else {
                    i8 = jsonReader.m();
                }
            } else {
                str = jsonReader.t();
            }
        }
        return new ShapePath(str, i8, animatableShapeValue, z7);
    }
}
