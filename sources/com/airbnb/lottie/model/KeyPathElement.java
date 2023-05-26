package com.airbnb.lottie.model;

import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public interface KeyPathElement {
    <T> void d(T t7, LottieValueCallback<T> lottieValueCallback);

    void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2);
}
