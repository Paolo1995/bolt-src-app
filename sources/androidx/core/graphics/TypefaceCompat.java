package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;

/* loaded from: classes.dex */
public class TypefaceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final TypefaceCompatBaseImpl f5746a;

    /* renamed from: b  reason: collision with root package name */
    private static final LruCache<String, Typeface> f5747b;

    /* loaded from: classes.dex */
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        /* renamed from: a  reason: collision with root package name */
        private ResourcesCompat.FontCallback f5748a;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.f5748a = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void a(int i8) {
            ResourcesCompat.FontCallback fontCallback = this.f5748a;
            if (fontCallback != null) {
                fontCallback.f(i8);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void b(@NonNull Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f5748a;
            if (fontCallback != null) {
                fontCallback.g(typeface);
            }
        }
    }

    static {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            f5746a = new TypefaceCompatApi29Impl();
        } else if (i8 >= 28) {
            f5746a = new TypefaceCompatApi28Impl();
        } else if (i8 >= 26) {
            f5746a = new TypefaceCompatApi26Impl();
        } else if (i8 >= 24 && TypefaceCompatApi24Impl.m()) {
            f5746a = new TypefaceCompatApi24Impl();
        } else {
            f5746a = new TypefaceCompatApi21Impl();
        }
        f5747b = new LruCache<>(16);
    }

    private TypefaceCompat() {
    }

    @NonNull
    public static Typeface a(@NonNull Context context, Typeface typeface, int i8) {
        if (context != null) {
            return Typeface.create(typeface, i8);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(@NonNull Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i8) {
        return f5746a.c(context, cancellationSignal, fontInfoArr, i8);
    }

    public static Typeface c(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i8, String str, int i9, int i10, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z7) {
        Typeface b8;
        boolean z8;
        int i11;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            Typeface g8 = g(providerResourceEntry.c());
            if (g8 != null) {
                if (fontCallback != null) {
                    fontCallback.d(g8, handler);
                }
                return g8;
            }
            if (!z7 ? fontCallback == null : providerResourceEntry.a() == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z7) {
                i11 = providerResourceEntry.d();
            } else {
                i11 = -1;
            }
            b8 = FontsContractCompat.c(context, providerResourceEntry.b(), i10, z8, i11, ResourcesCompat.FontCallback.e(handler), new ResourcesCallbackAdapter(fontCallback));
        } else {
            b8 = f5746a.b(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i10);
            if (fontCallback != null) {
                if (b8 != null) {
                    fontCallback.d(b8, handler);
                } else {
                    fontCallback.c(-3, handler);
                }
            }
        }
        if (b8 != null) {
            f5747b.put(e(resources, i8, str, i9, i10), b8);
        }
        return b8;
    }

    public static Typeface d(@NonNull Context context, @NonNull Resources resources, int i8, String str, int i9, int i10) {
        Typeface e8 = f5746a.e(context, resources, i8, str, i10);
        if (e8 != null) {
            f5747b.put(e(resources, i8, str, i9, i10), e8);
        }
        return e8;
    }

    private static String e(Resources resources, int i8, String str, int i9, int i10) {
        return resources.getResourcePackageName(i8) + '-' + str + '-' + i9 + '-' + i8 + '-' + i10;
    }

    public static Typeface f(@NonNull Resources resources, int i8, String str, int i9, int i10) {
        return f5747b.get(e(resources, i8, str, i9, i10));
    }

    private static Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
