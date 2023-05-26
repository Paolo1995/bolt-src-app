package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MaskKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<ShapeData, Path>> f9191a;

    /* renamed from: b  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<Integer, Integer>> f9192b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mask> f9193c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.f9193c = list;
        this.f9191a = new ArrayList(list.size());
        this.f9192b = new ArrayList(list.size());
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.f9191a.add(list.get(i8).b().a());
            this.f9192b.add(list.get(i8).c().a());
        }
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> a() {
        return this.f9191a;
    }

    public List<Mask> b() {
        return this.f9193c;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> c() {
        return this.f9192b;
    }
}
