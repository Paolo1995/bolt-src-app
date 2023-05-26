package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class LayerParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f9573a = JsonReader.Options.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f9574b = JsonReader.Options.a("d", "a");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.Options f9575c = JsonReader.Options.a("ty", "nm");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.parser.LayerParser$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9576a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f9576a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9576a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private LayerParser() {
    }

    public static Layer a(LottieComposition lottieComposition) {
        Rect b8 = lottieComposition.b();
        return new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, b8.width(), b8.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }

    public static Layer b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.e();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        BlurEffect blurEffect = null;
        DropShadowEffect dropShadowEffect = null;
        long j8 = -1;
        float f8 = 0.0f;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        float f9 = 1.0f;
        float f10 = 0.0f;
        int i11 = 0;
        int i12 = 0;
        boolean z7 = false;
        float f11 = 0.0f;
        long j9 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.j()) {
            switch (jsonReader.I(f9573a)) {
                case 0:
                    str3 = jsonReader.t();
                    break;
                case 1:
                    j9 = jsonReader.m();
                    break;
                case 2:
                    str = jsonReader.t();
                    break;
                case 3:
                    int m8 = jsonReader.m();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (m8 >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[m8];
                        break;
                    }
                case 4:
                    j8 = jsonReader.m();
                    break;
                case 5:
                    i8 = (int) (jsonReader.m() * Utils.e());
                    break;
                case 6:
                    i9 = (int) (jsonReader.m() * Utils.e());
                    break;
                case 7:
                    i10 = Color.parseColor(jsonReader.t());
                    break;
                case 8:
                    animatableTransform = AnimatableTransformParser.g(jsonReader, lottieComposition);
                    break;
                case 9:
                    int m9 = jsonReader.m();
                    if (m9 >= Layer.MatteType.values().length) {
                        lottieComposition.a("Unsupported matte type: " + m9);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[m9];
                        int i13 = AnonymousClass1.f9576a[matteType2.ordinal()];
                        if (i13 != 1) {
                            if (i13 == 2) {
                                lottieComposition.a("Unsupported matte type: Luma Inverted");
                            }
                        } else {
                            lottieComposition.a("Unsupported matte type: Luma");
                        }
                        lottieComposition.r(1);
                        break;
                    }
                case 10:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        arrayList3.add(MaskParser.a(jsonReader, lottieComposition));
                    }
                    lottieComposition.r(arrayList3.size());
                    jsonReader.g();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        ContentModel a8 = ContentModelParser.a(jsonReader, lottieComposition);
                        if (a8 != null) {
                            arrayList4.add(a8);
                        }
                    }
                    jsonReader.g();
                    break;
                case 12:
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int I = jsonReader.I(f9574b);
                        if (I != 0) {
                            if (I != 1) {
                                jsonReader.N();
                                jsonReader.O();
                            } else {
                                jsonReader.c();
                                if (jsonReader.j()) {
                                    animatableTextProperties = AnimatableTextPropertiesParser.a(jsonReader, lottieComposition);
                                }
                                while (jsonReader.j()) {
                                    jsonReader.O();
                                }
                                jsonReader.g();
                            }
                        } else {
                            animatableTextFrame = AnimatableValueParser.d(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.h();
                    break;
                case 13:
                    jsonReader.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        while (jsonReader.j()) {
                            int I2 = jsonReader.I(f9575c);
                            if (I2 != 0) {
                                if (I2 != 1) {
                                    jsonReader.N();
                                    jsonReader.O();
                                } else {
                                    arrayList5.add(jsonReader.t());
                                }
                            } else {
                                int m10 = jsonReader.m();
                                if (m10 == 29) {
                                    blurEffect = BlurEffectParser.b(jsonReader, lottieComposition);
                                } else if (m10 == 25) {
                                    dropShadowEffect = new DropShadowEffectParser().b(jsonReader, lottieComposition);
                                }
                            }
                        }
                        jsonReader.h();
                    }
                    jsonReader.g();
                    lottieComposition.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f9 = (float) jsonReader.l();
                    break;
                case 15:
                    f10 = (float) jsonReader.l();
                    break;
                case 16:
                    i11 = (int) (jsonReader.m() * Utils.e());
                    break;
                case 17:
                    i12 = (int) (jsonReader.m() * Utils.e());
                    break;
                case 18:
                    f8 = (float) jsonReader.l();
                    break;
                case 19:
                    f11 = (float) jsonReader.l();
                    break;
                case 20:
                    animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 21:
                    str2 = jsonReader.t();
                    break;
                case 22:
                    z7 = jsonReader.k();
                    break;
                default:
                    jsonReader.N();
                    jsonReader.O();
                    break;
            }
        }
        jsonReader.h();
        ArrayList arrayList6 = new ArrayList();
        if (f8 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f8)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f11 <= 0.0f) {
            f11 = lottieComposition.f();
        }
        arrayList2.add(new Keyframe(lottieComposition, valueOf, valueOf, null, f8, Float.valueOf(f11)));
        arrayList2.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, f11, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            lottieComposition.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, lottieComposition, str3, j9, layerType, j8, str, arrayList, animatableTransform, i8, i9, i10, f9, f10, i11, i12, animatableTextFrame, animatableTextProperties, arrayList2, matteType2, animatableFloatValue, z7, blurEffect, dropShadowEffect);
    }
}
