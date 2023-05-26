package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ShapeGroupParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9592a = JsonReader.Options.a("nm", "hd", "it");

    private ShapeGroupParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeGroup a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z7 = false;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9592a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        jsonReader.O();
                    } else {
                        jsonReader.c();
                        while (jsonReader.j()) {
                            ContentModel a8 = ContentModelParser.a(jsonReader, lottieComposition);
                            if (a8 != null) {
                                arrayList.add(a8);
                            }
                        }
                        jsonReader.g();
                    }
                } else {
                    z7 = jsonReader.k();
                }
            } else {
                str = jsonReader.t();
            }
        }
        return new ShapeGroup(str, arrayList, z7);
    }
}
