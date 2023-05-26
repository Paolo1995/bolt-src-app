package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class PolystarShapeParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9584a = JsonReader.Options.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", "d");

    private PolystarShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i8) throws IOException {
        boolean z7;
        if (i8 == 3) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean z8 = z7;
        String str = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        boolean z9 = false;
        while (jsonReader.j()) {
            switch (jsonReader.I(f9584a)) {
                case 0:
                    str = jsonReader.t();
                    break;
                case 1:
                    type = PolystarShape.Type.a(jsonReader.m());
                    break;
                case 2:
                    animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValue2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    animatableFloatValue4 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue6 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    animatableFloatValue3 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 8:
                    animatableFloatValue5 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 9:
                    z9 = jsonReader.k();
                    break;
                case 10:
                    if (jsonReader.m() == 3) {
                        z8 = true;
                        break;
                    } else {
                        z8 = false;
                        break;
                    }
                default:
                    jsonReader.N();
                    jsonReader.O();
                    break;
            }
        }
        return new PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, z9, z8);
    }
}
