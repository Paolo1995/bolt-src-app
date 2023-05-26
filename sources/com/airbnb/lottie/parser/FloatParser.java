package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class FloatParser implements ValueParser<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final FloatParser f9555a = new FloatParser();

    private FloatParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public Float a(JsonReader jsonReader, float f8) throws IOException {
        return Float.valueOf(JsonUtils.g(jsonReader) * f8);
    }
}
