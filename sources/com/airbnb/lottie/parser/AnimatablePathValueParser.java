package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AnimatablePathValueParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9531a = JsonReader.Options.a("k", "x", "y");

    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.j()) {
                arrayList.add(PathKeyframeParser.a(jsonReader, lottieComposition));
            }
            jsonReader.g();
            KeyframesParser.b(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.e(jsonReader, Utils.e())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableValue<PointF, PointF> b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.e();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z7 = false;
        while (jsonReader.y() != JsonReader.Token.END_OBJECT) {
            int I = jsonReader.I(f9531a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        jsonReader.N();
                        jsonReader.O();
                    } else if (jsonReader.y() == JsonReader.Token.STRING) {
                        jsonReader.O();
                        z7 = true;
                    } else {
                        animatableFloatValue2 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    }
                } else if (jsonReader.y() == JsonReader.Token.STRING) {
                    jsonReader.O();
                    z7 = true;
                } else {
                    animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
                }
            } else {
                animatablePathValue = a(jsonReader, lottieComposition);
            }
        }
        jsonReader.h();
        if (z7) {
            lottieComposition.a("Lottie doesn't support expressions.");
        }
        if (animatablePathValue != null) {
            return animatablePathValue;
        }
        return new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
