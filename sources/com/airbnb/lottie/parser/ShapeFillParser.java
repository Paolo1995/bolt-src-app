package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;

/* loaded from: classes.dex */
class ShapeFillParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9591a = JsonReader.Options.a("nm", "c", "o", "fillEnabled", "r", "hd");

    private ShapeFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue;
        Path.FillType fillType;
        AnimatableIntegerValue animatableIntegerValue2 = null;
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        int i8 = 1;
        boolean z7 = false;
        boolean z8 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9591a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            if (I != 4) {
                                if (I != 5) {
                                    jsonReader.N();
                                    jsonReader.O();
                                } else {
                                    z8 = jsonReader.k();
                                }
                            } else {
                                i8 = jsonReader.m();
                            }
                        } else {
                            z7 = jsonReader.k();
                        }
                    } else {
                        animatableIntegerValue2 = AnimatableValueParser.h(jsonReader, lottieComposition);
                    }
                } else {
                    animatableColorValue = AnimatableValueParser.c(jsonReader, lottieComposition);
                }
            } else {
                str = jsonReader.t();
            }
        }
        if (animatableIntegerValue2 == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        } else {
            animatableIntegerValue = animatableIntegerValue2;
        }
        if (i8 == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new ShapeFill(str, z7, fillType, animatableColorValue, animatableIntegerValue, z8);
    }
}
