package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.google.android.gms.common.api.Api;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TypefaceCompatBaseImpl {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> f5765a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface StyleExtractor<T> {
        boolean a(T t7);

        int b(T t7);
    }

    private void a(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long j8 = j(typeface);
        if (j8 != 0) {
            this.f5765a.put(Long.valueOf(j8), fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry f(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i8) {
        return (FontResourcesParserCompat.FontFileResourceEntry) g(fontFamilyFilesResourceEntry.a(), i8, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.2
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* renamed from: c */
            public int b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.e();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* renamed from: d */
            public boolean a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.f();
            }
        });
    }

    private static <T> T g(T[] tArr, int i8, StyleExtractor<T> styleExtractor) {
        int i9;
        boolean z7;
        if ((i8 & 1) == 0) {
            i9 = 400;
        } else {
            i9 = 700;
        }
        if ((i8 & 2) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        return (T) h(tArr, i9, z7, styleExtractor);
    }

    private static <T> T h(T[] tArr, int i8, boolean z7, StyleExtractor<T> styleExtractor) {
        int i9;
        T t7 = null;
        int i10 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (T t8 : tArr) {
            int abs = Math.abs(styleExtractor.b(t8) - i8) * 2;
            if (styleExtractor.a(t8) == z7) {
                i9 = 0;
            } else {
                i9 = 1;
            }
            int i11 = abs + i9;
            if (t7 == null || i10 > i11) {
                t7 = t8;
                i10 = i11;
            }
        }
        return t7;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e8) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e8);
            return 0L;
        } catch (NoSuchFieldException e9) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e9);
            return 0L;
        }
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i8) {
        FontResourcesParserCompat.FontFileResourceEntry f8 = f(fontFamilyFilesResourceEntry, i8);
        if (f8 == null) {
            return null;
        }
        Typeface d8 = TypefaceCompat.d(context, resources, f8.b(), f8.a(), 0, i8);
        a(d8, fontFamilyFilesResourceEntry);
        return d8;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i8) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(i(fontInfoArr, i8).d());
            try {
                Typeface d8 = d(context, inputStream);
                TypefaceCompatUtil.a(inputStream);
                return d8;
            } catch (IOException unused) {
                TypefaceCompatUtil.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e8 = TypefaceCompatUtil.e(context);
        if (e8 == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.d(e8, inputStream)) {
                return null;
            }
            return Typeface.createFromFile(e8.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e8.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i8, String str, int i9) {
        File e8 = TypefaceCompatUtil.e(context);
        if (e8 == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.c(e8, resources, i8)) {
                return null;
            }
            return Typeface.createFromFile(e8.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e8.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FontsContractCompat.FontInfo i(FontsContractCompat.FontInfo[] fontInfoArr, int i8) {
        return (FontsContractCompat.FontInfo) g(fontInfoArr, i8, new StyleExtractor<FontsContractCompat.FontInfo>() { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.1
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* renamed from: c */
            public int b(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.e();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* renamed from: d */
            public boolean a(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.f();
            }
        });
    }
}
