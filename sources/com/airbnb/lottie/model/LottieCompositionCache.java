package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes.dex */
public class LottieCompositionCache {

    /* renamed from: b  reason: collision with root package name */
    private static final LottieCompositionCache f9295b = new LottieCompositionCache();

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<String, LottieComposition> f9296a = new LruCache<>(20);

    LottieCompositionCache() {
    }

    public static LottieCompositionCache b() {
        return f9295b;
    }

    public LottieComposition a(String str) {
        if (str == null) {
            return null;
        }
        return this.f9296a.get(str);
    }

    public void c(String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.f9296a.put(str, lottieComposition);
    }
}
