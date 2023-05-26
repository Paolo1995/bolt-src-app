package androidx.constraintlayout.core.motion.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {

    /* renamed from: a  reason: collision with root package name */
    private CycleOscillator f4449a;

    /* renamed from: b  reason: collision with root package name */
    private String f4450b;

    /* renamed from: c  reason: collision with root package name */
    private int f4451c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f4452d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f4453e = 0;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<WavePoint> f4454f = new ArrayList<>();

    /* loaded from: classes.dex */
    static class CycleOscillator {
        public double a(float f8) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    static class WavePoint {

        /* renamed from: a  reason: collision with root package name */
        int f4455a;

        /* renamed from: b  reason: collision with root package name */
        float f4456b;
    }

    public float a(float f8) {
        return (float) this.f4449a.a(f8);
    }

    public String toString() {
        String str = this.f4450b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.f4454f.iterator();
        while (it.hasNext()) {
            WavePoint next = it.next();
            str = str + "[" + next.f4455a + " , " + decimalFormat.format(next.f4456b) + "] ";
        }
        return str;
    }
}
