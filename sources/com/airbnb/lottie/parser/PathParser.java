package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class PathParser implements ValueParser<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final PathParser f9582a = new PathParser();

    private PathParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f8) throws IOException {
        return JsonUtils.e(jsonReader, f8);
    }
}
