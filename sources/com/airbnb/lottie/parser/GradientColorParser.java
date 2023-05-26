package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class GradientColorParser implements ValueParser<GradientColor> {

    /* renamed from: a  reason: collision with root package name */
    private int f9559a;

    public GradientColorParser(int i8) {
        this.f9559a = i8;
    }

    private GradientColor b(GradientColor gradientColor, List<Float> list) {
        int i8 = this.f9559a * 4;
        if (list.size() <= i8) {
            return gradientColor;
        }
        float[] b8 = gradientColor.b();
        int[] a8 = gradientColor.a();
        int size = (list.size() - i8) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i9 = 0;
        while (i8 < list.size()) {
            if (i8 % 2 == 0) {
                fArr[i9] = list.get(i8).floatValue();
            } else {
                fArr2[i9] = list.get(i8).floatValue();
                i9++;
            }
            i8++;
        }
        float[] e8 = e(gradientColor.b(), fArr);
        int length = e8.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            float f8 = e8[i10];
            int binarySearch = Arrays.binarySearch(b8, f8);
            int binarySearch2 = Arrays.binarySearch(fArr, f8);
            if (binarySearch >= 0 && binarySearch2 <= 0) {
                iArr[i10] = d(f8, a8[binarySearch], fArr, fArr2);
            } else {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i10] = c(f8, fArr2[binarySearch2], b8, a8);
            }
        }
        return new GradientColor(e8, iArr);
    }

    private int c(float f8, float f9, float[] fArr, int[] iArr) {
        if (iArr.length >= 2 && f8 != fArr[0]) {
            for (int i8 = 1; i8 < fArr.length; i8++) {
                float f10 = fArr[i8];
                if (f10 >= f8 || i8 == fArr.length - 1) {
                    int i9 = i8 - 1;
                    float f11 = fArr[i9];
                    float f12 = (f8 - f11) / (f10 - f11);
                    int i10 = iArr[i8];
                    int i11 = iArr[i9];
                    return Color.argb((int) (f9 * 255.0f), MiscUtils.j(Color.red(i11), Color.red(i10), f12), MiscUtils.j(Color.green(i11), Color.green(i10), f12), MiscUtils.j(Color.blue(i11), Color.blue(i10), f12));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return iArr[0];
    }

    private int d(float f8, int i8, float[] fArr, float[] fArr2) {
        float i9;
        if (fArr2.length >= 2 && f8 > fArr[0]) {
            for (int i10 = 1; i10 < fArr.length; i10++) {
                float f9 = fArr[i10];
                int i11 = (f9 > f8 ? 1 : (f9 == f8 ? 0 : -1));
                if (i11 >= 0 || i10 == fArr.length - 1) {
                    if (i11 <= 0) {
                        i9 = fArr2[i10];
                    } else {
                        int i12 = i10 - 1;
                        float f10 = fArr[i12];
                        i9 = MiscUtils.i(fArr2[i12], fArr2[i10], (f8 - f10) / (f9 - f10));
                    }
                    return Color.argb((int) (i9 * 255.0f), Color.red(i8), Color.green(i8), Color.blue(i8));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i8), Color.green(i8), Color.blue(i8));
    }

    protected static float[] e(float[] fArr, float[] fArr2) {
        float f8;
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            float f9 = Float.NaN;
            if (i9 < fArr.length) {
                f8 = fArr[i9];
            } else {
                f8 = Float.NaN;
            }
            if (i10 < fArr2.length) {
                f9 = fArr2[i10];
            }
            if (!Float.isNaN(f9) && f8 >= f9) {
                if (!Float.isNaN(f8) && f9 >= f8) {
                    fArr3[i11] = f8;
                    i9++;
                    i10++;
                    i8++;
                } else {
                    fArr3[i11] = f9;
                    i10++;
                }
            } else {
                fArr3[i11] = f8;
                i9++;
            }
        }
        if (i8 == 0) {
            return fArr3;
        }
        return Arrays.copyOf(fArr3, length - i8);
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: f */
    public GradientColor a(JsonReader jsonReader, float f8) throws IOException {
        boolean z7;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            jsonReader.c();
        }
        while (jsonReader.j()) {
            arrayList.add(Float.valueOf((float) jsonReader.l()));
        }
        if (arrayList.size() == 4 && arrayList.get(0).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add(arrayList.get(1));
            arrayList.add(arrayList.get(2));
            arrayList.add(arrayList.get(3));
            this.f9559a = 2;
        }
        if (z7) {
            jsonReader.g();
        }
        if (this.f9559a == -1) {
            this.f9559a = arrayList.size() / 4;
        }
        int i8 = this.f9559a;
        float[] fArr = new float[i8];
        int[] iArr = new int[i8];
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f9559a * 4; i11++) {
            int i12 = i11 / 4;
            double floatValue = arrayList.get(i11).floatValue();
            int i13 = i11 % 4;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 == 3) {
                            iArr[i12] = Color.argb(255, i9, i10, (int) (floatValue * 255.0d));
                        }
                    } else {
                        i10 = (int) (floatValue * 255.0d);
                    }
                } else {
                    i9 = (int) (floatValue * 255.0d);
                }
            } else {
                if (i12 > 0) {
                    float f9 = (float) floatValue;
                    if (fArr[i12 - 1] >= f9) {
                        fArr[i12] = f9 + 0.01f;
                    }
                }
                fArr[i12] = (float) floatValue;
            }
        }
        return b(new GradientColor(fArr, iArr), arrayList);
    }
}
