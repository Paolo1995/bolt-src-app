package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    private static <T> List<Keyframe<T>> a(JsonReader jsonReader, float f8, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, f8, valueParser, false);
    }

    private static <T> List<Keyframe<T>> b(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, 1.0f, valueParser, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableColorValue c(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(b(jsonReader, lottieComposition, ColorParser.f9539a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableTextFrame d(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(b(jsonReader, lottieComposition, DocumentDataParser.f9541a));
    }

    public static AnimatableFloatValue e(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return f(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue f(JsonReader jsonReader, LottieComposition lottieComposition, boolean z7) throws IOException {
        float f8;
        if (z7) {
            f8 = Utils.e();
        } else {
            f8 = 1.0f;
        }
        return new AnimatableFloatValue(a(jsonReader, f8, lottieComposition, FloatParser.f9555a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableGradientColorValue g(JsonReader jsonReader, LottieComposition lottieComposition, int i8) throws IOException {
        return new AnimatableGradientColorValue(b(jsonReader, lottieComposition, new GradientColorParser(i8)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableIntegerValue h(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(b(jsonReader, lottieComposition, IntegerParser.f9565a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatablePointValue i(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(KeyframesParser.a(jsonReader, lottieComposition, Utils.e(), PointFParser.f9583a, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableScaleValue j(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue(b(jsonReader, lottieComposition, ScaleXYParser.f9588a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableShapeValue k(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(a(jsonReader, Utils.e(), lottieComposition, ShapeDataParser.f9589a));
    }
}
