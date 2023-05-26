package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;

/* loaded from: classes.dex */
public class AnimatableTransformParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9534a = JsonReader.Options.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9535b = JsonReader.Options.a("k");

    private AnimatableTransformParser() {
    }

    private static boolean a(AnimatablePathValue animatablePathValue) {
        if (animatablePathValue != null && (!animatablePathValue.c() || !animatablePathValue.b().get(0).f9661b.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    private static boolean b(AnimatableValue<PointF, PointF> animatableValue) {
        if (animatableValue != null && ((animatableValue instanceof AnimatableSplitDimensionPathValue) || !animatableValue.c() || !animatableValue.b().get(0).f9661b.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    private static boolean c(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.c() || ((Float) ((Keyframe) animatableFloatValue.b().get(0)).f9661b).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    private static boolean d(AnimatableScaleValue animatableScaleValue) {
        if (animatableScaleValue != null && (!animatableScaleValue.c() || !((ScaleXY) ((Keyframe) animatableScaleValue.b().get(0)).f9661b).a(1.0f, 1.0f))) {
            return false;
        }
        return true;
    }

    private static boolean e(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.c() || ((Float) ((Keyframe) animatableFloatValue.b().get(0)).f9661b).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    private static boolean f(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.c() || ((Float) ((Keyframe) animatableFloatValue.b().get(0)).f9661b).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.airbnb.lottie.model.animatable.AnimatableTransform g(com.airbnb.lottie.parser.moshi.JsonReader r27, com.airbnb.lottie.LottieComposition r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.g(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.animatable.AnimatableTransform");
    }
}
