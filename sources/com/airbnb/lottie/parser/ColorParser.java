package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class ColorParser implements ValueParser<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final ColorParser f9539a = new ColorParser();

    private ColorParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f8) throws IOException {
        boolean z7;
        double d8;
        if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            jsonReader.c();
        }
        double l8 = jsonReader.l();
        double l9 = jsonReader.l();
        double l10 = jsonReader.l();
        if (jsonReader.y() == JsonReader.Token.NUMBER) {
            d8 = jsonReader.l();
        } else {
            d8 = 1.0d;
        }
        if (z7) {
            jsonReader.g();
        }
        if (l8 <= 1.0d && l9 <= 1.0d && l10 <= 1.0d) {
            l8 *= 255.0d;
            l9 *= 255.0d;
            l10 *= 255.0d;
            if (d8 <= 1.0d) {
                d8 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d8, (int) l8, (int) l9, (int) l10));
    }
}
