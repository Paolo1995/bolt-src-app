package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FontCharacterParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9556a = JsonReader.Options.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9557b = JsonReader.Options.a("shapes");

    private FontCharacterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontCharacter a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.e();
        String str = null;
        String str2 = null;
        double d8 = 0.0d;
        double d9 = 0.0d;
        char c8 = 0;
        while (jsonReader.j()) {
            int I = jsonReader.I(f9556a);
            if (I != 0) {
                if (I != 1) {
                    if (I != 2) {
                        if (I != 3) {
                            if (I != 4) {
                                if (I != 5) {
                                    jsonReader.N();
                                    jsonReader.O();
                                } else {
                                    jsonReader.e();
                                    while (jsonReader.j()) {
                                        if (jsonReader.I(f9557b) != 0) {
                                            jsonReader.N();
                                            jsonReader.O();
                                        } else {
                                            jsonReader.c();
                                            while (jsonReader.j()) {
                                                arrayList.add((ShapeGroup) ContentModelParser.a(jsonReader, lottieComposition));
                                            }
                                            jsonReader.g();
                                        }
                                    }
                                    jsonReader.h();
                                }
                            } else {
                                str2 = jsonReader.t();
                            }
                        } else {
                            str = jsonReader.t();
                        }
                    } else {
                        d9 = jsonReader.l();
                    }
                } else {
                    d8 = jsonReader.l();
                }
            } else {
                c8 = jsonReader.t().charAt(0);
            }
        }
        jsonReader.h();
        return new FontCharacter(arrayList, c8, d8, d9, str, str2);
    }
}
