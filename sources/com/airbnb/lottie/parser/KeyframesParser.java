package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class KeyframesParser {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.Options f9572a = JsonReader.Options.a("k");

    private KeyframesParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<Keyframe<T>> a(JsonReader jsonReader, LottieComposition lottieComposition, float f8, ValueParser<T> valueParser, boolean z7) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.y() == JsonReader.Token.STRING) {
            lottieComposition.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.e();
        while (jsonReader.j()) {
            if (jsonReader.I(f9572a) != 0) {
                jsonReader.O();
            } else if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.c();
                if (jsonReader.y() == JsonReader.Token.NUMBER) {
                    arrayList.add(KeyframeParser.c(jsonReader, lottieComposition, f8, valueParser, false, z7));
                } else {
                    while (jsonReader.j()) {
                        arrayList.add(KeyframeParser.c(jsonReader, lottieComposition, f8, valueParser, true, z7));
                    }
                }
                jsonReader.g();
            } else {
                arrayList.add(KeyframeParser.c(jsonReader, lottieComposition, f8, valueParser, false, z7));
            }
        }
        jsonReader.h();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends Keyframe<T>> list) {
        int i8;
        T t7;
        int size = list.size();
        int i9 = 0;
        while (true) {
            i8 = size - 1;
            if (i9 >= i8) {
                break;
            }
            Keyframe<T> keyframe = list.get(i9);
            i9++;
            Keyframe<T> keyframe2 = list.get(i9);
            keyframe.f9667h = Float.valueOf(keyframe2.f9666g);
            if (keyframe.f9662c == null && (t7 = keyframe2.f9661b) != null) {
                keyframe.f9662c = t7;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).i();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i8);
        if ((keyframe3.f9661b == null || keyframe3.f9662c == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
