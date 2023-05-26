package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public class LottieCompositionMoshiParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9577a = JsonReader.Options.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static JsonReader.Options f9578b = JsonReader.Options.a(Name.MARK, "layers", "w", "h", "p", "u");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.Options f9579c = JsonReader.Options.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final JsonReader.Options f9580d = JsonReader.Options.a("cm", "tm", "dr");

    public static LottieComposition a(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float e8 = Utils.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.e();
        int i8 = 0;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        int i9 = 0;
        while (jsonReader.j()) {
            switch (jsonReader2.I(f9577a)) {
                case 0:
                    i8 = jsonReader.m();
                    continue;
                    jsonReader2 = jsonReader;
                case 1:
                    i9 = jsonReader.m();
                    continue;
                    jsonReader2 = jsonReader;
                case 2:
                    f8 = (float) jsonReader.l();
                    continue;
                    jsonReader2 = jsonReader;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f9 = ((float) jsonReader.l()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f10 = (float) jsonReader.l();
                    break;
                case 5:
                    String[] split = jsonReader.t().split("\\.");
                    if (!Utils.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 6:
                    e(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    b(jsonReader2, lottieComposition, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    d(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    c(jsonReader2, lottieComposition, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    f(jsonReader2, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.N();
                    jsonReader.O();
                    break;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        lottieComposition.s(new Rect(0, 0, (int) (i8 * e8), (int) (i9 * e8)), f8, f9, f10, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return lottieComposition;
    }

    private static void b(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.c();
        while (jsonReader.j()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.e();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i8 = 0;
            int i9 = 0;
            while (jsonReader.j()) {
                int I = jsonReader.I(f9578b);
                if (I != 0) {
                    if (I != 1) {
                        if (I != 2) {
                            if (I != 3) {
                                if (I != 4) {
                                    if (I != 5) {
                                        jsonReader.N();
                                        jsonReader.O();
                                    } else {
                                        str3 = jsonReader.t();
                                    }
                                } else {
                                    str2 = jsonReader.t();
                                }
                            } else {
                                i9 = jsonReader.m();
                            }
                        } else {
                            i8 = jsonReader.m();
                        }
                    } else {
                        jsonReader.c();
                        while (jsonReader.j()) {
                            Layer b8 = LayerParser.b(jsonReader, lottieComposition);
                            longSparseArray.l(b8.d(), b8);
                            arrayList.add(b8);
                        }
                        jsonReader.g();
                    }
                } else {
                    str = jsonReader.t();
                }
            }
            jsonReader.h();
            if (str2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(i8, i9, str, str2, str3);
                map2.put(lottieImageAsset.d(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.g();
    }

    private static void c(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.c();
        while (jsonReader.j()) {
            FontCharacter a8 = FontCharacterParser.a(jsonReader, lottieComposition);
            sparseArrayCompat.j(a8.hashCode(), a8);
        }
        jsonReader.g();
    }

    private static void d(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.e();
        while (jsonReader.j()) {
            if (jsonReader.I(f9579c) != 0) {
                jsonReader.N();
                jsonReader.O();
            } else {
                jsonReader.c();
                while (jsonReader.j()) {
                    Font a8 = FontParser.a(jsonReader);
                    map.put(a8.b(), a8);
                }
                jsonReader.g();
            }
        }
        jsonReader.h();
    }

    private static void e(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.c();
        int i8 = 0;
        while (jsonReader.j()) {
            Layer b8 = LayerParser.b(jsonReader, lottieComposition);
            if (b8.f() == Layer.LayerType.IMAGE) {
                i8++;
            }
            list.add(b8);
            longSparseArray.l(b8.d(), b8);
            if (i8 > 4) {
                Logger.c("You have " + i8 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.g();
    }

    private static void f(JsonReader jsonReader, List<Marker> list) throws IOException {
        jsonReader.c();
        while (jsonReader.j()) {
            String str = null;
            jsonReader.e();
            float f8 = 0.0f;
            float f9 = 0.0f;
            while (jsonReader.j()) {
                int I = jsonReader.I(f9580d);
                if (I != 0) {
                    if (I != 1) {
                        if (I != 2) {
                            jsonReader.N();
                            jsonReader.O();
                        } else {
                            f9 = (float) jsonReader.l();
                        }
                    } else {
                        f8 = (float) jsonReader.l();
                    }
                } else {
                    str = jsonReader.t();
                }
            }
            jsonReader.h();
            list.add(new Marker(str, f8, f9));
        }
        jsonReader.g();
    }
}
