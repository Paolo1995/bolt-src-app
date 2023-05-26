package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class CircleShapeParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9538a = JsonReader.Options.a("nm", "p", "s", "hd", "d");

    private CircleShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CircleShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i8) throws IOException {
        boolean z7;
        if (i8 == 3) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean z8 = z7;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        boolean z9 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9538a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            if (I != 4) {
                                jsonReader.N();
                                jsonReader.O();
                            } else if (jsonReader.m() == 3) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                        } else {
                            z9 = jsonReader.k();
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
        return new CircleShape(str, animatableValue, animatablePointValue, z8, z9);
    }
}
