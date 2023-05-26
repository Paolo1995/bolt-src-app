package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class PointFParser implements ValueParser<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final PointFParser f9583a = new PointFParser();

    private PointFParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f8) throws IOException {
        JsonReader.Token y7 = jsonReader.y();
        if (y7 == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.e(jsonReader, f8);
        }
        if (y7 == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.e(jsonReader, f8);
        }
        if (y7 == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.l()) * f8, ((float) jsonReader.l()) * f8);
            while (jsonReader.j()) {
                jsonReader.O();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + y7);
    }
}
