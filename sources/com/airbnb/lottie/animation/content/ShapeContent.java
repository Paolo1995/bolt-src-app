package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: b  reason: collision with root package name */
    private final String f9149b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9150c;

    /* renamed from: d  reason: collision with root package name */
    private final LottieDrawable f9151d;

    /* renamed from: e  reason: collision with root package name */
    private final ShapeKeyframeAnimation f9152e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9153f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f9148a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final CompoundTrimPathContent f9154g = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.f9149b = shapePath.b();
        this.f9150c = shapePath.d();
        this.f9151d = lottieDrawable;
        ShapeKeyframeAnimation a8 = shapePath.c().a();
        this.f9152e = a8;
        baseLayer.i(a8);
        a8.a(this);
    }

    private void d() {
        this.f9153f = false;
        this.f9151d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        d();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        ArrayList arrayList = null;
        for (int i8 = 0; i8 < list.size(); i8++) {
            Content content = list.get(i8);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f9154g.a(trimPathContent);
                    trimPathContent.d(this);
                }
            }
            if (content instanceof ShapeModifierContent) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((ShapeModifierContent) content);
            }
        }
        this.f9152e.q(arrayList);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.f9153f) {
            return this.f9148a;
        }
        this.f9148a.reset();
        if (this.f9150c) {
            this.f9153f = true;
            return this.f9148a;
        }
        Path h8 = this.f9152e.h();
        if (h8 == null) {
            return this.f9148a;
        }
        this.f9148a.set(h8);
        this.f9148a.setFillType(Path.FillType.EVEN_ODD);
        this.f9154g.b(this.f9148a);
        this.f9153f = true;
        return this.f9148a;
    }
}
