package kotlinx.coroutines.internal;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: FastServiceLoader.kt */
/* loaded from: classes5.dex */
public final class FastServiceLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final FastServiceLoader f51789a = new FastServiceLoader();

    private FastServiceLoader() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> H0;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            H0 = CollectionsKt___CollectionsKt.H0(ServiceLoader.load(cls, classLoader));
            return H0;
        }
    }

    private final List<String> e(URL url) {
        boolean L;
        String N0;
        String U0;
        String N02;
        String url2 = url.toString();
        L = StringsKt__StringsJVMKt.L(url2, "jar", false, 2, null);
        if (L) {
            N0 = StringsKt__StringsKt.N0(url2, "jar:file:", null, 2, null);
            U0 = StringsKt__StringsKt.U0(N0, '!', null, 2, null);
            N02 = StringsKt__StringsKt.N0(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(U0, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(N02)), "UTF-8"));
                List<String> f8 = f51789a.f(bufferedReader);
                CloseableKt.a(bufferedReader, null);
                jarFile.close();
                return f8;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        ExceptionsKt__ExceptionsKt.a(th, th3);
                        throw th;
                    }
                }
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(FirebasePerfUrlConnection.openStream(url)));
        try {
            List<String> f9 = f51789a.f(bufferedReader2);
            CloseableKt.a(bufferedReader2, null);
            return f9;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                CloseableKt.a(bufferedReader2, th4);
                throw th5;
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> H0;
        String V0;
        CharSequence Y0;
        boolean z7;
        boolean z8;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                H0 = CollectionsKt___CollectionsKt.H0(linkedHashSet);
                return H0;
            }
            V0 = StringsKt__StringsKt.V0(readLine, "#", null, 2, null);
            Y0 = StringsKt__StringsKt.Y0(V0);
            String obj = Y0.toString();
            boolean z9 = false;
            int i8 = 0;
            while (true) {
                if (i8 < obj.length()) {
                    char charAt = obj.charAt(i8);
                    if (charAt != '.' && !Character.isJavaIdentifierPart(charAt)) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                    if (!z8) {
                        z7 = false;
                        break;
                    }
                    i8++;
                } else {
                    z7 = true;
                    break;
                }
            }
            if (z7) {
                if (obj.length() > 0) {
                    z9 = true;
                }
                if (z9) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
            }
        }
    }

    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!FastServiceLoaderKt.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set<String> L0;
        int v7;
        ArrayList<URL> list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        Intrinsics.e(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            CollectionsKt__MutableCollectionsKt.A(arrayList, f51789a.e(url));
        }
        L0 = CollectionsKt___CollectionsKt.L0(arrayList);
        if (!L0.isEmpty()) {
            v7 = CollectionsKt__IterablesKt.v(L0, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            for (String str : L0) {
                arrayList2.add(f51789a.a(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
