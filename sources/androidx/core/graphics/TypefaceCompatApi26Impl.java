package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* renamed from: g  reason: collision with root package name */
    protected final Class<?> f5758g;

    /* renamed from: h  reason: collision with root package name */
    protected final Constructor<?> f5759h;

    /* renamed from: i  reason: collision with root package name */
    protected final Method f5760i;

    /* renamed from: j  reason: collision with root package name */
    protected final Method f5761j;

    /* renamed from: k  reason: collision with root package name */
    protected final Method f5762k;

    /* renamed from: l  reason: collision with root package name */
    protected final Method f5763l;

    /* renamed from: m  reason: collision with root package name */
    protected final Method f5764m;

    public TypefaceCompatApi26Impl() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> y7 = y();
            constructor = z(y7);
            method2 = v(y7);
            method3 = w(y7);
            method4 = A(y7);
            method5 = u(y7);
            method = x(y7);
            cls = y7;
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e8.getClass().getName(), e8);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f5758g = cls;
        this.f5759h = constructor;
        this.f5760i = method2;
        this.f5761j = method3;
        this.f5762k = method4;
        this.f5763l = method5;
        this.f5764m = method;
    }

    private Object o() {
        try {
            return this.f5759h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void p(Object obj) {
        try {
            this.f5763l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean q(Context context, Object obj, String str, int i8, int i9, int i10, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f5760i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r(Object obj, ByteBuffer byteBuffer, int i8, int i9, int i10) {
        try {
            return ((Boolean) this.f5761j.invoke(obj, byteBuffer, Integer.valueOf(i8), null, Integer.valueOf(i9), Integer.valueOf(i10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj) {
        try {
            return ((Boolean) this.f5762k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t() {
        if (this.f5760i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (this.f5760i != null) {
            return true;
        }
        return false;
    }

    protected Method A(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i8) {
        FontResourcesParserCompat.FontFileResourceEntry[] a8;
        if (!t()) {
            return super.b(context, fontFamilyFilesResourceEntry, resources, i8);
        }
        Object o8 = o();
        if (o8 == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            if (!q(context, o8, fontFileResourceEntry.a(), fontFileResourceEntry.c(), fontFileResourceEntry.e(), fontFileResourceEntry.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.d()))) {
                p(o8);
                return null;
            }
        }
        if (!s(o8)) {
            return null;
        }
        return l(o8);
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [android.graphics.Typeface$Builder] */
    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface c(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i8) {
        Typeface l8;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (!t()) {
            FontsContractCompat.FontInfo i9 = i(fontInfoArr, i8);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(i9.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                final FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
                Typeface build = new Object(fileDescriptor) { // from class: android.graphics.Typeface$Builder
                    static {
                        throw new NoClassDefFoundError();
                    }

                    public native /* synthetic */ Typeface build();

                    public native /* synthetic */ Typeface$Builder setItalic(boolean z7);

                    public native /* synthetic */ Typeface$Builder setWeight(int i10);
                }.setWeight(i9.e()).setItalic(i9.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> h8 = TypefaceCompatUtil.h(context, fontInfoArr, cancellationSignal);
        Object o8 = o();
        if (o8 == null) {
            return null;
        }
        boolean z7 = false;
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            ByteBuffer byteBuffer = h8.get(fontInfo.d());
            if (byteBuffer != null) {
                if (!r(o8, byteBuffer, fontInfo.c(), fontInfo.e(), fontInfo.f() ? 1 : 0)) {
                    p(o8);
                    return null;
                }
                z7 = true;
            }
        }
        if (!z7) {
            p(o8);
            return null;
        } else if (!s(o8) || (l8 = l(o8)) == null) {
            return null;
        } else {
            return Typeface.create(l8, i8);
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface e(Context context, Resources resources, int i8, String str, int i9) {
        if (!t()) {
            return super.e(context, resources, i8, str, i9);
        }
        Object o8 = o();
        if (o8 == null) {
            return null;
        }
        if (!q(context, o8, str, 0, -1, -1, null)) {
            p(o8);
            return null;
        } else if (!s(o8)) {
            return null;
        } else {
            return l(o8);
        }
    }

    protected Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f5758g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f5764m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method u(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method v(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method w(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> y() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> z(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
