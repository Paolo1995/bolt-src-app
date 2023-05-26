package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {

    /* renamed from: a  reason: collision with root package name */
    public static final ShapeDataParser f9589a = new ShapeDataParser();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9590b = JsonReader.Options.a("c", "v", "i", "o");

    private ShapeDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: b */
    public ShapeData a(JsonReader jsonReader, float f8) throws IOException {
        if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
        }
        jsonReader.e();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9590b);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            jsonReader.N();
                            jsonReader.O();
                        } else {
                            list3 = JsonUtils.f(jsonReader, f8);
                        }
                    } else {
                        list2 = JsonUtils.f(jsonReader, f8);
                    }
                } else {
                    list = JsonUtils.f(jsonReader, f8);
                }
            } else {
                z7 = jsonReader.k();
            }
        }
        jsonReader.h();
        if (jsonReader.y() == JsonReader.Token.END_ARRAY) {
            jsonReader.g();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new ShapeData(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i8 = 1; i8 < size; i8++) {
                PointF pointF2 = list.get(i8);
                int i9 = i8 - 1;
                arrayList.add(new CubicCurveData(MiscUtils.a(list.get(i9), list3.get(i9)), MiscUtils.a(pointF2, list2.get(i8)), pointF2));
            }
            if (z7) {
                PointF pointF3 = list.get(0);
                int i10 = size - 1;
                arrayList.add(new CubicCurveData(MiscUtils.a(list.get(i10), list3.get(i10)), MiscUtils.a(pointF3, list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z7, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
