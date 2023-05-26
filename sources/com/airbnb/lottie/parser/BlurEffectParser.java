package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BlurEffectParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9536a = JsonReader.Options.a("ef");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9537b = JsonReader.Options.a("ty", "v");

    BlurEffectParser() {
    }

    private static BlurEffect a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.e();
        BlurEffect blurEffect = null;
        while (true) {
            boolean z7 = false;
            while (jsonReader.j()) {
                int I = jsonReader.I(f9537b);
                if (I != 0) {
                    if (I != 1) {
                        jsonReader.N();
                        jsonReader.O();
                    } else if (z7) {
                        blurEffect = new BlurEffect(AnimatableValueParser.e(jsonReader, lottieComposition));
                    } else {
                        jsonReader.O();
                    }
                } else if (jsonReader.m() == 0) {
                    z7 = true;
                }
            }
            jsonReader.h();
            return blurEffect;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BlurEffect b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        BlurEffect blurEffect = null;
        while (jsonReader.j()) {
            if (jsonReader.I(f9536a) != 0) {
                jsonReader.N();
                jsonReader.O();
            } else {
                jsonReader.c();
                while (jsonReader.j()) {
                    BlurEffect a8 = a(jsonReader, lottieComposition);
                    if (a8 != null) {
                        blurEffect = a8;
                    }
                }
                jsonReader.g();
            }
        }
        return blurEffect;
    }
}
