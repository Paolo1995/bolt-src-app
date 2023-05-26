package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FontAssetManager {

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f9255d;

    /* renamed from: e  reason: collision with root package name */
    private FontAssetDelegate f9256e;

    /* renamed from: a  reason: collision with root package name */
    private final MutablePair<String> f9252a = new MutablePair<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<MutablePair<String>, Typeface> f9253b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f9254c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f9257f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        this.f9256e = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.c("LottieDrawable must be inside of a view for images to work.");
            this.f9255d = null;
            return;
        }
        this.f9255d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(String str) {
        String b8;
        Typeface typeface = this.f9254c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        FontAssetDelegate fontAssetDelegate = this.f9256e;
        if (fontAssetDelegate != null) {
            typeface2 = fontAssetDelegate.a(str);
        }
        FontAssetDelegate fontAssetDelegate2 = this.f9256e;
        if (fontAssetDelegate2 != null && typeface2 == null && (b8 = fontAssetDelegate2.b(str)) != null) {
            typeface2 = Typeface.createFromAsset(this.f9255d, b8);
        }
        if (typeface2 == null) {
            typeface2 = Typeface.createFromAsset(this.f9255d, "fonts/" + str + this.f9257f);
        }
        this.f9254c.put(str, typeface2);
        return typeface2;
    }

    private Typeface d(Typeface typeface, String str) {
        int i8;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i8 = 3;
        } else if (contains) {
            i8 = 2;
        } else if (contains2) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        if (typeface.getStyle() == i8) {
            return typeface;
        }
        return Typeface.create(typeface, i8);
    }

    public Typeface b(String str, String str2) {
        this.f9252a.b(str, str2);
        Typeface typeface = this.f9253b.get(this.f9252a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d8 = d(a(str), str2);
        this.f9253b.put(this.f9252a, d8);
        return d8;
    }

    public void c(FontAssetDelegate fontAssetDelegate) {
        this.f9256e = fontAssetDelegate;
    }
}
