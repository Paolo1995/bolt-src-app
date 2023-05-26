package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes.dex */
public class LottieCompositionFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, LottieTask<LottieComposition>> f8898a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f8899b = {80, 75, 3, 4};

    private LottieCompositionFactory() {
    }

    private static boolean A(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    private static Boolean B(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b8 : f8899b) {
                if (peek.readByte() != b8) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e8) {
            Logger.b("Failed to check zip file header", e8);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(String str, AtomicBoolean atomicBoolean, Throwable th) {
        f8898a.remove(str);
        atomicBoolean.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult D(LottieComposition lottieComposition) throws Exception {
        return new LottieResult(lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        f8898a.remove(str);
        atomicBoolean.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult H(WeakReference weakReference, Context context, int i8, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i8, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult I(Context context, String str, String str2) throws Exception {
        LottieResult<LottieComposition> c8 = L.d(context).c(str, str2);
        if (str2 != null && c8.b() != null) {
            LottieCompositionCache.b().c(str2, c8.b());
        }
        return c8;
    }

    private static String J(Context context, int i8) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        if (A(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i8);
        return sb.toString();
    }

    private static LottieTask<LottieComposition> h(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition a8;
        if (str == null) {
            a8 = null;
        } else {
            a8 = LottieCompositionCache.b().a(str);
        }
        if (a8 != null) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult D;
                    D = LottieCompositionFactory.D(LottieComposition.this);
                    return D;
                }
            });
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = f8898a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.d(new LottieListener() { // from class: com.airbnb.lottie.h
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.E(str, atomicBoolean, (LottieComposition) obj);
                }
            });
            lottieTask.c(new LottieListener() { // from class: com.airbnb.lottie.i
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.C(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                f8898a.put(str, lottieTask);
            }
        }
        return lottieTask;
    }

    private static LottieImageAsset i(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.j().values()) {
            if (lottieImageAsset.b().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static LottieTask<LottieComposition> k(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: com.airbnb.lottie.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult m8;
                m8 = LottieCompositionFactory.m(applicationContext, str, str2);
                return m8;
            }
        });
    }

    public static LottieResult<LottieComposition> l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static LottieResult<LottieComposition> m(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return o(context.getAssets().open(str), str2);
            }
            return y(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e8) {
            return new LottieResult<>(e8);
        }
    }

    public static LottieTask<LottieComposition> n(final InputStream inputStream, final String str) {
        return h(str, new Callable() { // from class: com.airbnb.lottie.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult o8;
                o8 = LottieCompositionFactory.o(inputStream, str);
                return o8;
            }
        });
    }

    public static LottieResult<LottieComposition> o(InputStream inputStream, String str) {
        return p(inputStream, str, true);
    }

    private static LottieResult<LottieComposition> p(InputStream inputStream, String str, boolean z7) {
        try {
            return q(JsonReader.w(Okio.d(Okio.k(inputStream))), str);
        } finally {
            if (z7) {
                Utils.c(inputStream);
            }
        }
    }

    public static LottieResult<LottieComposition> q(JsonReader jsonReader, String str) {
        return r(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> r(JsonReader jsonReader, String str, boolean z7) {
        try {
            try {
                LottieComposition a8 = LottieCompositionMoshiParser.a(jsonReader);
                if (str != null) {
                    LottieCompositionCache.b().c(str, a8);
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(a8);
                if (z7) {
                    Utils.c(jsonReader);
                }
                return lottieResult;
            } catch (Exception e8) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e8);
                if (z7) {
                    Utils.c(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z7) {
                Utils.c(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> s(Context context, int i8) {
        return t(context, i8, J(context, i8));
    }

    public static LottieTask<LottieComposition> t(Context context, final int i8, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: com.airbnb.lottie.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult H;
                H = LottieCompositionFactory.H(weakReference, applicationContext, i8, str);
                return H;
            }
        });
    }

    public static LottieResult<LottieComposition> u(Context context, int i8) {
        return v(context, i8, J(context, i8));
    }

    public static LottieResult<LottieComposition> v(Context context, int i8, String str) {
        try {
            BufferedSource d8 = Okio.d(Okio.k(context.getResources().openRawResource(i8)));
            if (B(d8).booleanValue()) {
                return y(new ZipInputStream(d8.j1()), str);
            }
            return o(d8.j1(), str);
        } catch (Resources.NotFoundException e8) {
            return new LottieResult<>(e8);
        }
    }

    public static LottieTask<LottieComposition> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static LottieTask<LottieComposition> x(final Context context, final String str, final String str2) {
        return h(str2, new Callable() { // from class: com.airbnb.lottie.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult I;
                I = LottieCompositionFactory.I(context, str, str2);
                return I;
            }
        });
    }

    public static LottieResult<LottieComposition> y(ZipInputStream zipInputStream, String str) {
        try {
            return z(zipInputStream, str);
        } finally {
            Utils.c(zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> z(ZipInputStream zipInputStream, String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = r(JsonReader.w(Okio.d(Okio.k(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset i8 = i(lottieComposition, (String) entry.getKey());
                if (i8 != null) {
                    i8.f(Utils.l((Bitmap) entry.getValue(), i8.e(), i8.c()));
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.j().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new LottieResult<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                LottieCompositionCache.b().c(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e8) {
            return new LottieResult<>(e8);
        }
    }
}
