package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppLocalesStorageHelper;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* renamed from: f  reason: collision with root package name */
    static AppLocalesStorageHelper.SerialExecutor f1172f = new AppLocalesStorageHelper.SerialExecutor(new AppLocalesStorageHelper.ThreadPerTaskExecutor());

    /* renamed from: g  reason: collision with root package name */
    private static int f1173g = -100;

    /* renamed from: h  reason: collision with root package name */
    private static LocaleListCompat f1174h = null;

    /* renamed from: i  reason: collision with root package name */
    private static LocaleListCompat f1175i = null;

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f1176j = null;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f1177k = false;

    /* renamed from: l  reason: collision with root package name */
    private static Object f1178l = null;

    /* renamed from: m  reason: collision with root package name */
    private static Context f1179m = null;

    /* renamed from: n  reason: collision with root package name */
    private static final ArraySet<WeakReference<AppCompatDelegate>> f1180n = new ArraySet<>();

    /* renamed from: o  reason: collision with root package name */
    private static final Object f1181o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private static final Object f1182p = new Object();

    /* loaded from: classes.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* loaded from: classes.dex */
    static class Api33Impl {
        private Api33Impl() {
        }

        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C(Context context) {
        if (f1176j == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f1176j = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f1176j = Boolean.FALSE;
            }
        }
        return f1176j.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Context context) {
        AppLocalesStorageHelper.c(context);
        f1177k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void N(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (f1181o) {
            O(appCompatDelegate);
        }
    }

    private static void O(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (f1181o) {
            Iterator<WeakReference<AppCompatDelegate>> it = f1180n.iterator();
            while (it.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = it.next().get();
                if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Q(Context context) {
        f1179m = context;
    }

    public static void R(@NonNull LocaleListCompat localeListCompat) {
        Objects.requireNonNull(localeListCompat);
        if (BuildCompat.d()) {
            Object v7 = v();
            if (v7 != null) {
                Api33Impl.b(v7, Api24Impl.a(localeListCompat.h()));
            }
        } else if (!localeListCompat.equals(f1174h)) {
            synchronized (f1181o) {
                f1174h = localeListCompat;
                j();
            }
        }
    }

    public static void S(boolean z7) {
        VectorEnabledTintResources.c(z7);
    }

    public static void W(int i8) {
        if (i8 != -1 && i8 != 0 && i8 != 1 && i8 != 2 && i8 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (f1173g != i8) {
            f1173g = i8;
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c0(final Context context) {
        if (!C(context)) {
            return;
        }
        if (BuildCompat.d()) {
            if (!f1177k) {
                f1172f.execute(new Runnable() { // from class: androidx.appcompat.app.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppCompatDelegate.E(context);
                    }
                });
                return;
            }
            return;
        }
        synchronized (f1182p) {
            LocaleListCompat localeListCompat = f1174h;
            if (localeListCompat == null) {
                if (f1175i == null) {
                    f1175i = LocaleListCompat.c(AppLocalesStorageHelper.b(context));
                }
                if (f1175i.f()) {
                    return;
                }
                f1174h = f1175i;
            } else if (!localeListCompat.equals(f1175i)) {
                LocaleListCompat localeListCompat2 = f1174h;
                f1175i = localeListCompat2;
                AppLocalesStorageHelper.a(context, localeListCompat2.h());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (f1181o) {
            O(appCompatDelegate);
            f1180n.add(new WeakReference<>(appCompatDelegate));
        }
    }

    private static void i() {
        synchronized (f1181o) {
            Iterator<WeakReference<AppCompatDelegate>> it = f1180n.iterator();
            while (it.hasNext()) {
                AppCompatDelegate appCompatDelegate = it.next().get();
                if (appCompatDelegate != null) {
                    appCompatDelegate.h();
                }
            }
        }
    }

    private static void j() {
        Iterator<WeakReference<AppCompatDelegate>> it = f1180n.iterator();
        while (it.hasNext()) {
            AppCompatDelegate appCompatDelegate = it.next().get();
            if (appCompatDelegate != null) {
                appCompatDelegate.g();
            }
        }
    }

    @NonNull
    public static AppCompatDelegate n(@NonNull Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    @NonNull
    public static AppCompatDelegate o(@NonNull Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    @NonNull
    public static LocaleListCompat q() {
        if (BuildCompat.d()) {
            Object v7 = v();
            if (v7 != null) {
                return LocaleListCompat.i(Api33Impl.a(v7));
            }
        } else {
            LocaleListCompat localeListCompat = f1174h;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.e();
    }

    public static int s() {
        return f1173g;
    }

    static Object v() {
        Context r7;
        Object obj = f1178l;
        if (obj != null) {
            return obj;
        }
        if (f1179m == null) {
            Iterator<WeakReference<AppCompatDelegate>> it = f1180n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AppCompatDelegate appCompatDelegate = it.next().get();
                if (appCompatDelegate != null && (r7 = appCompatDelegate.r()) != null) {
                    f1179m = r7;
                    break;
                }
            }
        }
        Context context = f1179m;
        if (context != null) {
            f1178l = context.getSystemService("locale");
        }
        return f1178l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocaleListCompat x() {
        return f1174h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocaleListCompat y() {
        return f1175i;
    }

    public abstract void A();

    public abstract void B();

    public abstract void F(Configuration configuration);

    public abstract void G(Bundle bundle);

    public abstract void H();

    public abstract void I(Bundle bundle);

    public abstract void J();

    public abstract void K(Bundle bundle);

    public abstract void L();

    public abstract void M();

    public abstract boolean P(int i8);

    public abstract void T(int i8);

    public abstract void U(View view);

    public abstract void V(View view, ViewGroup.LayoutParams layoutParams);

    public void X(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void Y(Toolbar toolbar);

    public void Z(int i8) {
    }

    public abstract void a0(CharSequence charSequence);

    public abstract ActionMode b0(@NonNull ActionMode.Callback callback);

    public abstract void f(View view, ViewGroup.LayoutParams layoutParams);

    boolean g() {
        return false;
    }

    public abstract boolean h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Context context) {
        f1172f.execute(new Runnable() { // from class: androidx.appcompat.app.b
            @Override // java.lang.Runnable
            public final void run() {
                AppCompatDelegate.c0(context);
            }
        });
    }

    @Deprecated
    public void l(Context context) {
    }

    @NonNull
    public Context m(@NonNull Context context) {
        l(context);
        return context;
    }

    public abstract <T extends View> T p(int i8);

    public Context r() {
        return null;
    }

    public abstract ActionBarDrawerToggle$Delegate t();

    public int u() {
        return -100;
    }

    public abstract MenuInflater w();

    public abstract ActionBar z();
}
