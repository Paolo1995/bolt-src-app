package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup D;
    private final CompositionLayer E;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer, CompositionLayer compositionLayer) {
        super(lottieDrawable, layer);
        this.E = compositionLayer;
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.n(), false));
        this.D = contentGroup;
        contentGroup.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void H(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        this.D.e(keyPath, i8, list, keyPath2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        super.f(rectF, matrix, z7);
        this.D.f(rectF, this.f9457o, z7);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void t(@NonNull Canvas canvas, Matrix matrix, int i8) {
        this.D.h(canvas, matrix, i8);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public BlurEffect v() {
        BlurEffect v7 = super.v();
        if (v7 != null) {
            return v7;
        }
        return this.E.v();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public DropShadowEffect x() {
        DropShadowEffect x7 = super.x();
        if (x7 != null) {
            return x7;
        }
        return this.E.x();
    }
}
