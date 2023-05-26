package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
interface ValueParser<V> {
    V a(JsonReader jsonReader, float f8) throws IOException;
}
