package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

/* loaded from: classes.dex */
class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PathKeyframe a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z7;
        if (jsonReader.y() == JsonReader.Token.BEGIN_OBJECT) {
            z7 = true;
        } else {
            z7 = false;
        }
        return new PathKeyframe(lottieComposition, KeyframeParser.c(jsonReader, lottieComposition, Utils.e(), PathParser.f9582a, z7, false));
    }
}
