package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class Layer {

    /* renamed from: a  reason: collision with root package name */
    private final List<ContentModel> f9472a;

    /* renamed from: b  reason: collision with root package name */
    private final LottieComposition f9473b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9474c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9475d;

    /* renamed from: e  reason: collision with root package name */
    private final LayerType f9476e;

    /* renamed from: f  reason: collision with root package name */
    private final long f9477f;

    /* renamed from: g  reason: collision with root package name */
    private final String f9478g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Mask> f9479h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableTransform f9480i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9481j;

    /* renamed from: k  reason: collision with root package name */
    private final int f9482k;

    /* renamed from: l  reason: collision with root package name */
    private final int f9483l;

    /* renamed from: m  reason: collision with root package name */
    private final float f9484m;

    /* renamed from: n  reason: collision with root package name */
    private final float f9485n;

    /* renamed from: o  reason: collision with root package name */
    private final int f9486o;

    /* renamed from: p  reason: collision with root package name */
    private final int f9487p;

    /* renamed from: q  reason: collision with root package name */
    private final AnimatableTextFrame f9488q;

    /* renamed from: r  reason: collision with root package name */
    private final AnimatableTextProperties f9489r;

    /* renamed from: s  reason: collision with root package name */
    private final AnimatableFloatValue f9490s;

    /* renamed from: t  reason: collision with root package name */
    private final List<Keyframe<Float>> f9491t;

    /* renamed from: u  reason: collision with root package name */
    private final MatteType f9492u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f9493v;

    /* renamed from: w  reason: collision with root package name */
    private final BlurEffect f9494w;

    /* renamed from: x  reason: collision with root package name */
    private final DropShadowEffect f9495x;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j8, LayerType layerType, long j9, String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i8, int i9, int i10, float f8, float f9, int i11, int i12, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean z7, BlurEffect blurEffect, DropShadowEffect dropShadowEffect) {
        this.f9472a = list;
        this.f9473b = lottieComposition;
        this.f9474c = str;
        this.f9475d = j8;
        this.f9476e = layerType;
        this.f9477f = j9;
        this.f9478g = str2;
        this.f9479h = list2;
        this.f9480i = animatableTransform;
        this.f9481j = i8;
        this.f9482k = i9;
        this.f9483l = i10;
        this.f9484m = f8;
        this.f9485n = f9;
        this.f9486o = i11;
        this.f9487p = i12;
        this.f9488q = animatableTextFrame;
        this.f9489r = animatableTextProperties;
        this.f9491t = list3;
        this.f9492u = matteType;
        this.f9490s = animatableFloatValue;
        this.f9493v = z7;
        this.f9494w = blurEffect;
        this.f9495x = dropShadowEffect;
    }

    public BlurEffect a() {
        return this.f9494w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieComposition b() {
        return this.f9473b;
    }

    public DropShadowEffect c() {
        return this.f9495x;
    }

    public long d() {
        return this.f9475d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Keyframe<Float>> e() {
        return this.f9491t;
    }

    public LayerType f() {
        return this.f9476e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> g() {
        return this.f9479h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType h() {
        return this.f9492u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return this.f9474c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j() {
        return this.f9477f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f9487p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f9486o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return this.f9478g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ContentModel> n() {
        return this.f9472a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f9483l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f9482k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f9481j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float r() {
        return this.f9485n / this.f9473b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTextFrame s() {
        return this.f9488q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTextProperties t() {
        return this.f9489r;
    }

    public String toString() {
        return y("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableFloatValue u() {
        return this.f9490s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float v() {
        return this.f9484m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTransform w() {
        return this.f9480i;
    }

    public boolean x() {
        return this.f9493v;
    }

    public String y(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i());
        sb.append("\n");
        Layer t7 = this.f9473b.t(j());
        if (t7 != null) {
            sb.append("\t\tParents: ");
            sb.append(t7.i());
            Layer t8 = this.f9473b.t(t7.j());
            while (t8 != null) {
                sb.append("->");
                sb.append(t8.i());
                t8 = this.f9473b.t(t8.j());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!g().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(g().size());
            sb.append("\n");
        }
        if (q() != 0 && p() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())));
        }
        if (!this.f9472a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel contentModel : this.f9472a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
