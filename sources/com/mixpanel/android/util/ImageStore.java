package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.LruCache;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.util.RemoteService;
import j$.util.Spliterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes3.dex */
public class ImageStore {

    /* renamed from: e  reason: collision with root package name */
    private static LruCache<String, Bitmap> f19427e;

    /* renamed from: a  reason: collision with root package name */
    private final File f19428a;

    /* renamed from: b  reason: collision with root package name */
    private final RemoteService f19429b;

    /* renamed from: c  reason: collision with root package name */
    private final MessageDigest f19430c;

    /* renamed from: d  reason: collision with root package name */
    private final MPConfig f19431d;

    /* loaded from: classes3.dex */
    public static class CantGetImageException extends Exception {
        public CantGetImageException(String str) {
            super(str);
        }

        public CantGetImageException(String str, Throwable th) {
            super(str, th);
        }
    }

    public ImageStore(Context context, String str) {
        this(context, "MixpanelAPI.Images." + str, new HttpService());
    }

    public static void a(String str, Bitmap bitmap) {
        if (e(str) == null) {
            synchronized (f19427e) {
                f19427e.put(str, bitmap);
            }
        }
    }

    private static Bitmap b(File file) throws CantGetImageException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        if (options.outHeight * options.outWidth * 4.0f <= d()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (decodeFile != null) {
                return decodeFile;
            }
            file.delete();
            throw new CantGetImageException("Bitmap on disk can't be opened or was corrupt");
        }
        throw new CantGetImageException("Do not have enough memory for the image");
    }

    private static float d() {
        Runtime runtime = Runtime.getRuntime();
        return ((float) runtime.maxMemory()) - ((float) (runtime.totalMemory() - runtime.freeMemory()));
    }

    public static Bitmap e(String str) {
        Bitmap bitmap;
        synchronized (f19427e) {
            bitmap = f19427e.get(str);
        }
        return bitmap;
    }

    public static void h(String str) {
        synchronized (f19427e) {
            f19427e.remove(str);
        }
    }

    private File i(String str) {
        MessageDigest messageDigest = this.f19430c;
        if (messageDigest == null) {
            return null;
        }
        byte[] digest = messageDigest.digest(str.getBytes());
        return new File(this.f19428a, "MP_IMG_" + Base64.encodeToString(digest, 10));
    }

    public void c(String str) {
        File i8 = i(str);
        if (i8 != null) {
            i8.delete();
            h(str);
        }
    }

    public Bitmap f(String str) throws CantGetImageException {
        Bitmap e8 = e(str);
        if (e8 == null) {
            Bitmap b8 = b(g(str));
            a(str, b8);
            return b8;
        }
        return e8;
    }

    public File g(String str) throws CantGetImageException {
        File i8 = i(str);
        if (i8 == null || !i8.exists()) {
            try {
                FileOutputStream fileOutputStream = null;
                byte[] a8 = this.f19429b.a(str, null, this.f19431d.C());
                if (a8 != null && i8 != null) {
                    try {
                        if (a8.length < 10000000) {
                            try {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(i8);
                                try {
                                    fileOutputStream2.write(a8);
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e8) {
                                        MPLog.l("MixpanelAPI.ImageStore", "Problem closing output file", e8);
                                    }
                                } catch (FileNotFoundException e9) {
                                    e = e9;
                                    throw new CantGetImageException("It appears that ImageStore is misconfigured, or disk storage is unavailable- can't write to bitmap directory", e);
                                } catch (IOException e10) {
                                    e = e10;
                                    throw new CantGetImageException("Can't store bitmap", e);
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e11) {
                                            MPLog.l("MixpanelAPI.ImageStore", "Problem closing output file", e11);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (FileNotFoundException e12) {
                                e = e12;
                            } catch (IOException e13) {
                                e = e13;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (RemoteService.ServiceUnavailableException e14) {
                throw new CantGetImageException("Couldn't download image due to service availability", e14);
            } catch (IOException e15) {
                throw new CantGetImageException("Can't download bitmap", e15);
            }
        }
        return i8;
    }

    public ImageStore(Context context, String str, RemoteService remoteService) {
        MessageDigest messageDigest;
        this.f19428a = context.getDir(str, 0);
        this.f19429b = remoteService;
        this.f19431d = MPConfig.s(context);
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException unused) {
            MPLog.k("MixpanelAPI.ImageStore", "Images won't be stored because this platform doesn't supply a SHA1 hash function");
            messageDigest = null;
        }
        this.f19430c = messageDigest;
        if (f19427e == null) {
            synchronized (ImageStore.class) {
                if (f19427e == null) {
                    f19427e = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE)) / this.f19431d.r()) { // from class: com.mixpanel.android.util.ImageStore.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.util.LruCache
                        /* renamed from: a */
                        public int sizeOf(String str2, Bitmap bitmap) {
                            return (bitmap.getRowBytes() * bitmap.getHeight()) / Spliterator.IMMUTABLE;
                        }
                    };
                }
            }
        }
    }
}
