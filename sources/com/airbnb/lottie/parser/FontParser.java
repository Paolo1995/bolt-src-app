package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
class FontParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9558a = JsonReader.Options.a("fFamily", "fName", "fStyle", "ascent");

    private FontParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Font a(JsonReader jsonReader) throws IOException {
        jsonReader.e();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f8 = 0.0f;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9558a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            jsonReader.N();
                            jsonReader.O();
                        } else {
                            f8 = (float) jsonReader.l();
                        }
                    } else {
                        str3 = jsonReader.t();
                    }
                } else {
                    str2 = jsonReader.t();
                }
            } else {
                str = jsonReader.t();
            }
        }
        jsonReader.h();
        return new Font(str, str2, str3, f8);
    }
}
