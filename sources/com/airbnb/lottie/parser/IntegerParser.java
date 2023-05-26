package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class IntegerParser implements ValueParser<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final IntegerParser f9565a = new IntegerParser();

    private IntegerParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f8) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.g(jsonReader) * f8));
    }
}
