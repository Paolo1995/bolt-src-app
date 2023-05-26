package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class LottieComposition {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<Layer>> f8885c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, LottieImageAsset> f8886d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Font> f8887e;

    /* renamed from: f  reason: collision with root package name */
    private List<Marker> f8888f;

    /* renamed from: g  reason: collision with root package name */
    private SparseArrayCompat<FontCharacter> f8889g;

    /* renamed from: h  reason: collision with root package name */
    private LongSparseArray<Layer> f8890h;

    /* renamed from: i  reason: collision with root package name */
    private List<Layer> f8891i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f8892j;

    /* renamed from: k  reason: collision with root package name */
    private float f8893k;

    /* renamed from: l  reason: collision with root package name */
    private float f8894l;

    /* renamed from: m  reason: collision with root package name */
    private float f8895m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8896n;

    /* renamed from: a  reason: collision with root package name */
    private final PerformanceTracker f8883a = new PerformanceTracker();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f8884b = new HashSet<>();

    /* renamed from: o  reason: collision with root package name */
    private int f8897o = 0;

    public void a(String str) {
        Logger.c(str);
        this.f8884b.add(str);
    }

    public Rect b() {
        return this.f8892j;
    }

    public SparseArrayCompat<FontCharacter> c() {
        return this.f8889g;
    }

    public float d() {
        return (e() / this.f8895m) * 1000.0f;
    }

    public float e() {
        return this.f8894l - this.f8893k;
    }

    public float f() {
        return this.f8894l;
    }

    public Map<String, Font> g() {
        return this.f8887e;
    }

    public float h(float f8) {
        return MiscUtils.i(this.f8893k, this.f8894l, f8);
    }

    public float i() {
        return this.f8895m;
    }

    public Map<String, LottieImageAsset> j() {
        return this.f8886d;
    }

    public List<Layer> k() {
        return this.f8891i;
    }

    public Marker l(String str) {
        int size = this.f8888f.size();
        for (int i8 = 0; i8 < size; i8++) {
            Marker marker = this.f8888f.get(i8);
            if (marker.a(str)) {
                return marker;
            }
        }
        return null;
    }

    public int m() {
        return this.f8897o;
    }

    public PerformanceTracker n() {
        return this.f8883a;
    }

    public List<Layer> o(String str) {
        return this.f8885c.get(str);
    }

    public float p() {
        return this.f8893k;
    }

    public boolean q() {
        return this.f8896n;
    }

    public void r(int i8) {
        this.f8897o += i8;
    }

    public void s(Rect rect, float f8, float f9, float f10, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2) {
        this.f8892j = rect;
        this.f8893k = f8;
        this.f8894l = f9;
        this.f8895m = f10;
        this.f8891i = list;
        this.f8890h = longSparseArray;
        this.f8885c = map;
        this.f8886d = map2;
        this.f8889g = sparseArrayCompat;
        this.f8887e = map3;
        this.f8888f = list2;
    }

    public Layer t(long j8) {
        return this.f8890h.f(j8);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f8891i) {
            sb.append(layer.y("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z7) {
        this.f8896n = z7;
    }

    public void v(boolean z7) {
        this.f8883a.b(z7);
    }
}
