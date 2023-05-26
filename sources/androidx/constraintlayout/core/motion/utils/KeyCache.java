package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class KeyCache {

    /* renamed from: a  reason: collision with root package name */
    HashMap<Object, HashMap<String, float[]>> f4448a = new HashMap<>();

    public float a(Object obj, String str, int i8) {
        HashMap<String, float[]> hashMap;
        float[] fArr;
        if (!this.f4448a.containsKey(obj) || (hashMap = this.f4448a.get(obj)) == null || !hashMap.containsKey(str) || (fArr = hashMap.get(str)) == null || fArr.length <= i8) {
            return Float.NaN;
        }
        return fArr[i8];
    }

    public void b(Object obj, String str, int i8, float f8) {
        if (!this.f4448a.containsKey(obj)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            float[] fArr = new float[i8 + 1];
            fArr[i8] = f8;
            hashMap.put(str, fArr);
            this.f4448a.put(obj, hashMap);
            return;
        }
        HashMap<String, float[]> hashMap2 = this.f4448a.get(obj);
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[i8 + 1];
            fArr2[i8] = f8;
            hashMap2.put(str, fArr2);
            this.f4448a.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = hashMap2.get(str);
        if (fArr3 == null) {
            fArr3 = new float[0];
        }
        if (fArr3.length <= i8) {
            fArr3 = Arrays.copyOf(fArr3, i8 + 1);
        }
        fArr3[i8] = f8;
        hashMap2.put(str, fArr3);
    }
}
