package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

/* loaded from: classes.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {

    /* renamed from: a  reason: collision with root package name */
    public static final ScaleXYParser f9588a = new ScaleXYParser();

    private ScaleXYParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public ScaleXY a(JsonReader jsonReader, float f8) throws IOException {
        boolean z7;
        if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            jsonReader.c();
        }
        float l8 = (float) jsonReader.l();
        float l9 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.O();
        }
        if (z7) {
            jsonReader.g();
        }
        return new ScaleXY((l8 / 100.0f) * f8, (l9 / 100.0f) * f8);
    }
}
