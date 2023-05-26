package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class PerformanceTracker {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8966a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<FrameListener> f8967b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, MeanCalculator> f8968c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f8969d = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.f5909b.floatValue();
            float floatValue2 = pair2.f5909b.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    };

    /* loaded from: classes.dex */
    public interface FrameListener {
        void a(float f8);
    }

    public void a(String str, float f8) {
        if (!this.f8966a) {
            return;
        }
        MeanCalculator meanCalculator = this.f8968c.get(str);
        if (meanCalculator == null) {
            meanCalculator = new MeanCalculator();
            this.f8968c.put(str, meanCalculator);
        }
        meanCalculator.a(f8);
        if (str.equals("__container")) {
            for (FrameListener frameListener : this.f8967b) {
                frameListener.a(f8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z7) {
        this.f8966a = z7;
    }
}
