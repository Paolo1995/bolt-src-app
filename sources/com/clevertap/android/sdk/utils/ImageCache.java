package com.clevertap.android.sdk.utils;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.LruCache;
import com.clevertap.android.sdk.Logger;
import j$.util.Spliterator;
import java.io.File;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class ImageCache {

    /* renamed from: a  reason: collision with root package name */
    private static final int f11819a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f11820b;

    /* renamed from: c  reason: collision with root package name */
    private static LruCache<String, Bitmap> f11821c;

    /* renamed from: d  reason: collision with root package name */
    private static File f11822d;

    /* renamed from: e  reason: collision with root package name */
    private static MessageDigest f11823e;

    static {
        int maxMemory = ((int) Runtime.getRuntime().maxMemory()) / Spliterator.IMMUTABLE;
        f11819a = maxMemory;
        f11820b = Math.max(maxMemory / 32, 20480);
    }

    public static boolean b(String str, Bitmap bitmap) {
        if (f11821c == null) {
            return false;
        }
        if (f(str) == null) {
            synchronized (ImageCache.class) {
                int h8 = h(bitmap);
                int d8 = d();
                Logger.n("CleverTap.ImageCache: image size: " + h8 + "KB. Available mem: " + d8 + "KB.");
                if (h8 > d()) {
                    Logger.n("CleverTap.ImageCache: insufficient memory to add image: " + str);
                    return false;
                }
                f11821c.put(str, bitmap);
                Logger.n("CleverTap.ImageCache: added image for key: " + str);
                return true;
            }
        }
        return true;
    }

    private static void c() {
        synchronized (ImageCache.class) {
            if (j()) {
                Logger.n("CTInAppNotification.ImageCache: cache is empty, removing it");
                f11821c = null;
            }
        }
    }

    private static int d() {
        int size;
        synchronized (ImageCache.class) {
            LruCache<String, Bitmap> lruCache = f11821c;
            if (lruCache == null) {
                size = 0;
            } else {
                size = f11820b - lruCache.size();
            }
        }
        return size;
    }

    public static Bitmap e(String str) {
        synchronized (ImageCache.class) {
            Bitmap bitmap = null;
            if (str == null) {
                return null;
            }
            LruCache<String, Bitmap> lruCache = f11821c;
            if (lruCache != null) {
                bitmap = lruCache.get(str);
            }
            return bitmap;
        }
    }

    private static Bitmap f(String str) {
        LruCache<String, Bitmap> lruCache;
        if (str == null || (lruCache = f11821c) == null) {
            return null;
        }
        return lruCache.get(str);
    }

    private static File g(String str) {
        MessageDigest messageDigest = f11823e;
        if (messageDigest == null) {
            return null;
        }
        byte[] digest = messageDigest.digest(str.getBytes());
        return new File(f11822d, "CT_IMAGE_" + Base64.encodeToString(digest, 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(Bitmap bitmap) {
        return bitmap.getByteCount() / Spliterator.IMMUTABLE;
    }

    public static void i() {
        synchronized (ImageCache.class) {
            if (f11821c == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("CleverTap.ImageCache: init with max device memory: ");
                sb.append(f11819a);
                sb.append("KB and allocated cache size: ");
                int i8 = f11820b;
                sb.append(i8);
                sb.append("KB");
                Logger.n(sb.toString());
                f11821c = new LruCache<String, Bitmap>(i8) { // from class: com.clevertap.android.sdk.utils.ImageCache.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.util.LruCache
                    /* renamed from: a */
                    public int sizeOf(String str, Bitmap bitmap) {
                        int h8 = ImageCache.h(bitmap);
                        Logger.n("CleverTap.ImageCache: have image of size: " + h8 + "KB for key: " + str);
                        return h8;
                    }
                };
            }
        }
    }

    private static boolean j() {
        boolean z7;
        synchronized (ImageCache.class) {
            if (f11821c.size() <= 0) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    public static void k(String str, boolean z7) {
        synchronized (ImageCache.class) {
            if (z7) {
                l(str);
            }
            LruCache<String, Bitmap> lruCache = f11821c;
            if (lruCache == null) {
                return;
            }
            lruCache.remove(str);
            Logger.n("CleverTap.ImageCache: removed image for key: " + str);
            c();
        }
    }

    private static void l(String str) {
        File g8 = g(str);
        if (g8 != null && g8.exists()) {
            g8.delete();
        }
    }
}
