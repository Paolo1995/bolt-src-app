package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9566a = JsonReader.Options.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9567a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f9567a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9567a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9567a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private JsonUtils() {
    }

    private static PointF a(JsonReader jsonReader, float f8) throws IOException {
        jsonReader.c();
        float l8 = (float) jsonReader.l();
        float l9 = (float) jsonReader.l();
        while (jsonReader.y() != JsonReader.Token.END_ARRAY) {
            jsonReader.O();
        }
        jsonReader.g();
        return new PointF(l8 * f8, l9 * f8);
    }

    private static PointF b(JsonReader jsonReader, float f8) throws IOException {
        float l8 = (float) jsonReader.l();
        float l9 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.O();
        }
        return new PointF(l8 * f8, l9 * f8);
    }

    private static PointF c(JsonReader jsonReader, float f8) throws IOException {
        jsonReader.e();
        float f9 = 0.0f;
        float f10 = 0.0f;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9566a);
            if (I != 0) {
                if (I != 1) {
                    jsonReader.N();
                    jsonReader.O();
                } else {
                    f10 = g(jsonReader);
                }
            } else {
                f9 = g(jsonReader);
            }
        }
        jsonReader.h();
        return new PointF(f9 * f8, f10 * f8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.c();
        int l8 = (int) (jsonReader.l() * 255.0d);
        int l9 = (int) (jsonReader.l() * 255.0d);
        int l10 = (int) (jsonReader.l() * 255.0d);
        while (jsonReader.j()) {
            jsonReader.O();
        }
        jsonReader.g();
        return Color.argb(255, l8, l9, l10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF e(JsonReader jsonReader, float f8) throws IOException {
        int i8 = AnonymousClass1.f9567a[jsonReader.y().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return c(jsonReader, f8);
                }
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.y());
            }
            return a(jsonReader, f8);
        }
        return b(jsonReader, f8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> f(JsonReader jsonReader, float f8) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        while (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            arrayList.add(e(jsonReader, f8));
            jsonReader.g();
        }
        jsonReader.g();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token y7 = jsonReader.y();
        int i8 = AnonymousClass1.f9567a[y7.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                jsonReader.c();
                float l8 = (float) jsonReader.l();
                while (jsonReader.j()) {
                    jsonReader.O();
                }
                jsonReader.g();
                return l8;
            }
            throw new IllegalArgumentException("Unknown value for token of type " + y7);
        }
        return (float) jsonReader.l();
    }
}
