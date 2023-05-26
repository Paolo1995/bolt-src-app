package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f5749b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor<?> f5750c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f5751d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Method f5752e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f5753f = false;

    private static boolean k(Object obj, String str, int i8, boolean z7) {
        n();
        try {
            return ((Boolean) f5751d.invoke(obj, str, Integer.valueOf(i8), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    private static Typeface l(Object obj) {
        n();
        try {
            Object newInstance = Array.newInstance(f5749b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f5752e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    private File m(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f5753f) {
            return;
        }
        f5753f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            Log.e("TypefaceCompatApi21Impl", e8.getClass().getName(), e8);
            method = null;
            cls = null;
            method2 = null;
        }
        f5750c = constructor;
        f5749b = cls;
        f5751d = method2;
        f5752e = method;
    }

    private static Object o() {
        n();
        try {
            return f5750c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i8) {
        FontResourcesParserCompat.FontFileResourceEntry[] a8;
        Object o8 = o();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            File e8 = TypefaceCompatUtil.e(context);
            if (e8 == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.c(e8, resources, fontFileResourceEntry.b())) {
                    return null;
                }
                if (!k(o8, e8.getPath(), fontFileResourceEntry.e(), fontFileResourceEntry.f())) {
                    return null;
                }
                e8.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e8.delete();
            }
        }
        return l(o8);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface c(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i8) {
        if (fontInfoArr.length < 1) {
            return null;
        }
        FontsContractCompat.FontInfo i9 = i(fontInfoArr, i8);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(i9.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File m8 = m(openFileDescriptor);
            if (m8 != null && m8.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(m8);
                openFileDescriptor.close();
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface d8 = super.d(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return d8;
        } catch (IOException unused) {
            return null;
        }
    }
}
