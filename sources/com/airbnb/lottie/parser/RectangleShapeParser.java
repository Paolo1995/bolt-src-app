package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class RectangleShapeParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9585a = JsonReader.Options.a("nm", "p", "s", "r", "hd");

    private RectangleShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectangleShape a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9585a);
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
                            animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
                        }
                    } else {
                        animatablePointValue = AnimatableValueParser.i(jsonReader, lottieComposition);
                    }
                } else {
                    animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
                }
            } else {
                str = jsonReader.t();
            }
        }
        return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z7);
    }
}
