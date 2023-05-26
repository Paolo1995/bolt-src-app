package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ImageAssetManager {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f9258e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f9259a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9260b;

    /* renamed from: c  reason: collision with root package name */
    private ImageAssetDelegate f9261c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, LottieImageAsset> f9262d;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f9260b = str + '/';
        } else {
            this.f9260b = str;
        }
        if (!(callback instanceof View)) {
            Logger.c("LottieDrawable must be inside of a view for images to work.");
            this.f9262d = new HashMap();
            this.f9259a = null;
            return;
        }
        this.f9259a = ((View) callback).getContext();
        this.f9262d = map;
        d(imageAssetDelegate);
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f9258e) {
            this.f9262d.get(str).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        LottieImageAsset lottieImageAsset = this.f9262d.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap a8 = lottieImageAsset.a();
        if (a8 != null) {
            return a8;
        }
        ImageAssetDelegate imageAssetDelegate = this.f9261c;
        if (imageAssetDelegate != null) {
            Bitmap a9 = imageAssetDelegate.a(lottieImageAsset);
            if (a9 != null) {
                c(str, a9);
            }
            return a9;
        }
        String b8 = lottieImageAsset.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b8.startsWith("data:") && b8.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b8.substring(b8.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e8) {
                Logger.d("data URL did not have correct base64 format.", e8);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f9260b)) {
                AssetManager assets = this.f9259a.getAssets();
                try {
                    return c(str, Utils.l(BitmapFactory.decodeStream(assets.open(this.f9260b + b8), null, options), lottieImageAsset.e(), lottieImageAsset.c()));
                } catch (IllegalArgumentException e9) {
                    Logger.d("Unable to decode image.", e9);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e10) {
            Logger.d("Unable to open asset.", e10);
            return null;
        }
    }

    public boolean b(Context context) {
        if ((context == null && this.f9259a == null) || this.f9259a.equals(context)) {
            return true;
        }
        return false;
    }

    public void d(ImageAssetDelegate imageAssetDelegate) {
        this.f9261c = imageAssetDelegate;
    }
}
