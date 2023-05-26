package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FontRequestWorker {

    /* renamed from: a  reason: collision with root package name */
    static final LruCache<String, Typeface> f5832a = new LruCache<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f5833b = RequestExecutor.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f5834c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> f5835d = new SimpleArrayMap<>();

    private FontRequestWorker() {
    }

    private static String a(@NonNull FontRequest fontRequest, int i8) {
        return fontRequest.d() + "-" + i8;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(@NonNull FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i8 = 1;
        if (fontFamilyResult.c() != 0) {
            if (fontFamilyResult.c() != 1) {
                return -3;
            }
            return -2;
        }
        FontsContractCompat.FontInfo[] b8 = fontFamilyResult.b();
        if (b8 != null && b8.length != 0) {
            i8 = 0;
            for (FontsContractCompat.FontInfo fontInfo : b8) {
                int b9 = fontInfo.b();
                if (b9 != 0) {
                    if (b9 < 0) {
                        return -3;
                    }
                    return b9;
                }
            }
        }
        return i8;
    }

    @NonNull
    static TypefaceResult c(@NonNull String str, @NonNull Context context, @NonNull FontRequest fontRequest, int i8) {
        LruCache<String, Typeface> lruCache = f5832a;
        Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult e8 = FontProvider.e(context, fontRequest, null);
            int b8 = b(e8);
            if (b8 != 0) {
                return new TypefaceResult(b8);
            }
            Typeface b9 = TypefaceCompat.b(context, null, e8.b(), i8);
            if (b9 != null) {
                lruCache.put(str, b9);
                return new TypefaceResult(b9);
            }
            return new TypefaceResult(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(@NonNull final Context context, @NonNull final FontRequest fontRequest, final int i8, Executor executor, @NonNull final CallbackWithHandler callbackWithHandler) {
        final String a8 = a(fontRequest, i8);
        Typeface typeface = f5832a.get(a8);
        if (typeface != null) {
            callbackWithHandler.b(new TypefaceResult(typeface));
            return typeface;
        }
        Consumer<TypefaceResult> consumer = new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.2
            @Override // androidx.core.util.Consumer
            /* renamed from: a */
            public void accept(TypefaceResult typefaceResult) {
                if (typefaceResult == null) {
                    typefaceResult = new TypefaceResult(-3);
                }
                CallbackWithHandler.this.b(typefaceResult);
            }
        };
        synchronized (f5834c) {
            SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap = f5835d;
            ArrayList<Consumer<TypefaceResult>> arrayList = simpleArrayMap.get(a8);
            if (arrayList != null) {
                arrayList.add(consumer);
                return null;
            }
            ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
            arrayList2.add(consumer);
            simpleArrayMap.put(a8, arrayList2);
            Callable<TypefaceResult> callable = new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.3
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public TypefaceResult call() {
                    try {
                        return FontRequestWorker.c(a8, context, fontRequest, i8);
                    } catch (Throwable unused) {
                        return new TypefaceResult(-3);
                    }
                }
            };
            if (executor == null) {
                executor = f5833b;
            }
            RequestExecutor.b(executor, callable, new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.4
                @Override // androidx.core.util.Consumer
                /* renamed from: a */
                public void accept(TypefaceResult typefaceResult) {
                    synchronized (FontRequestWorker.f5834c) {
                        SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap2 = FontRequestWorker.f5835d;
                        ArrayList<Consumer<TypefaceResult>> arrayList3 = simpleArrayMap2.get(a8);
                        if (arrayList3 == null) {
                            return;
                        }
                        simpleArrayMap2.remove(a8);
                        for (int i9 = 0; i9 < arrayList3.size(); i9++) {
                            arrayList3.get(i9).accept(typefaceResult);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(@NonNull final Context context, @NonNull final FontRequest fontRequest, @NonNull CallbackWithHandler callbackWithHandler, final int i8, int i9) {
        final String a8 = a(fontRequest, i8);
        Typeface typeface = f5832a.get(a8);
        if (typeface != null) {
            callbackWithHandler.b(new TypefaceResult(typeface));
            return typeface;
        } else if (i9 == -1) {
            TypefaceResult c8 = c(a8, context, fontRequest, i8);
            callbackWithHandler.b(c8);
            return c8.f5846a;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.c(f5833b, new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public TypefaceResult call() {
                        return FontRequestWorker.c(a8, context, fontRequest, i8);
                    }
                }, i9);
                callbackWithHandler.b(typefaceResult);
                return typefaceResult.f5846a;
            } catch (InterruptedException unused) {
                callbackWithHandler.b(new TypefaceResult(-3));
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class TypefaceResult {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f5846a;

        /* renamed from: b  reason: collision with root package name */
        final int f5847b;

        TypefaceResult(int i8) {
            this.f5846a = null;
            this.f5847b = i8;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            if (this.f5847b == 0) {
                return true;
            }
            return false;
        }

        @SuppressLint({"WrongConstant"})
        TypefaceResult(@NonNull Typeface typeface) {
            this.f5846a = typeface;
            this.f5847b = 0;
        }
    }
}
