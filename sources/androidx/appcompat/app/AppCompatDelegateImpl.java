package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* renamed from: q0  reason: collision with root package name */
    private static final SimpleArrayMap<String, Integer> f1183q0 = new SimpleArrayMap<>();

    /* renamed from: r0  reason: collision with root package name */
    private static final boolean f1184r0 = false;

    /* renamed from: s0  reason: collision with root package name */
    private static final int[] f1185s0 = {16842836};

    /* renamed from: t0  reason: collision with root package name */
    private static final boolean f1186t0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: u0  reason: collision with root package name */
    private static final boolean f1187u0 = true;
    private PanelMenuPresenterCallback A;
    ActionMode B;
    ActionBarContextView C;
    PopupWindow D;
    Runnable E;
    ViewPropertyAnimatorCompat F;
    private boolean G;
    private boolean H;
    ViewGroup I;
    private TextView J;
    private View K;
    private boolean L;
    private boolean M;
    boolean N;
    boolean O;
    boolean P;
    boolean Q;
    boolean R;
    private boolean S;
    private PanelFeatureState[] T;
    private PanelFeatureState U;
    private boolean V;
    private boolean W;
    private boolean X;
    boolean Y;
    private Configuration Z;

    /* renamed from: a0  reason: collision with root package name */
    private int f1188a0;

    /* renamed from: b0  reason: collision with root package name */
    private int f1189b0;

    /* renamed from: c0  reason: collision with root package name */
    private int f1190c0;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f1191d0;

    /* renamed from: e0  reason: collision with root package name */
    private AutoNightModeManager f1192e0;

    /* renamed from: f0  reason: collision with root package name */
    private AutoNightModeManager f1193f0;

    /* renamed from: g0  reason: collision with root package name */
    boolean f1194g0;

    /* renamed from: h0  reason: collision with root package name */
    int f1195h0;

    /* renamed from: i0  reason: collision with root package name */
    private final Runnable f1196i0;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f1197j0;

    /* renamed from: k0  reason: collision with root package name */
    private Rect f1198k0;

    /* renamed from: l0  reason: collision with root package name */
    private Rect f1199l0;

    /* renamed from: m0  reason: collision with root package name */
    private AppCompatViewInflater f1200m0;

    /* renamed from: n0  reason: collision with root package name */
    private LayoutIncludeDetector f1201n0;

    /* renamed from: o0  reason: collision with root package name */
    private OnBackInvokedDispatcher f1202o0;

    /* renamed from: p0  reason: collision with root package name */
    private OnBackInvokedCallback f1203p0;

    /* renamed from: q  reason: collision with root package name */
    final Object f1204q;

    /* renamed from: r  reason: collision with root package name */
    final Context f1205r;

    /* renamed from: s  reason: collision with root package name */
    Window f1206s;

    /* renamed from: t  reason: collision with root package name */
    private AppCompatWindowCallback f1207t;

    /* renamed from: u  reason: collision with root package name */
    final AppCompatCallback f1208u;

    /* renamed from: v  reason: collision with root package name */
    ActionBar f1209v;

    /* renamed from: w  reason: collision with root package name */
    MenuInflater f1210w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f1211x;

    /* renamed from: y  reason: collision with root package name */
    private DecorContentParent f1212y;

    /* renamed from: z  reason: collision with root package name */
    private ActionMenuPresenterCallback f1213z;

    /* loaded from: classes.dex */
    private class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle$Delegate {
        ActionBarDrawableToggleImpl() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ActionBarMenuCallback {
        boolean a(int i8);

        View onCreatePanelView(int i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(@NonNull MenuBuilder menuBuilder, boolean z7) {
            AppCompatDelegateImpl.this.k0(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(@NonNull MenuBuilder menuBuilder) {
            Window.Callback G0 = AppCompatDelegateImpl.this.G0();
            if (G0 != null) {
                G0.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private ActionMode.Callback f1222a;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f1222a = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void a(ActionMode actionMode) {
            this.f1222a.a(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.D != null) {
                appCompatDelegateImpl.f1206s.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.E);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.C != null) {
                appCompatDelegateImpl2.u0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.F = ViewCompat.e(appCompatDelegateImpl3.C).b(0.0f);
                AppCompatDelegateImpl.this.F.h(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void b(View view) {
                        AppCompatDelegateImpl.this.C.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl4.D;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl4.C.getParent() instanceof View) {
                            ViewCompat.p0((View) AppCompatDelegateImpl.this.C.getParent());
                        }
                        AppCompatDelegateImpl.this.C.k();
                        AppCompatDelegateImpl.this.F.h(null);
                        AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl5.F = null;
                        ViewCompat.p0(appCompatDelegateImpl5.I);
                    }
                });
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.f1208u;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.B);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.B = null;
            ViewCompat.p0(appCompatDelegateImpl5.I);
            AppCompatDelegateImpl.this.n1();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f1222a.b(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f1222a.c(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean d(ActionMode actionMode, Menu menu) {
            ViewCompat.p0(AppCompatDelegateImpl.this.I);
            return this.f1222a.d(actionMode, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static Context a(@NonNull Context context, @NonNull Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i8 = configuration.densityDpi;
            int i9 = configuration2.densityDpi;
            if (i8 != i9) {
                configuration3.densityDpi = i9;
            }
        }

        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales;
            LocaleList locales2;
            locales = configuration.getLocales();
            locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        static LocaleListCompat b(Configuration configuration) {
            LocaleList locales;
            locales = configuration.getLocales();
            return LocaleListCompat.c(locales.toLanguageTags());
        }

        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.h()));
        }

        static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i8 = configuration.colorMode & 3;
            int i9 = configuration2.colorMode;
            if (i8 != (i9 & 3)) {
                configuration3.colorMode |= i9 & 3;
            }
            int i10 = configuration.colorMode & 12;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 12)) {
                configuration3.colorMode |= i11 & 12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.e
                public final void onBackInvoked() {
                    AppCompatDelegateImpl.this.O0();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AutoBatteryNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f1230c;

        AutoBatteryNightModeManager(@NonNull Context context) {
            super();
            this.f1230c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int c() {
            if (Api21Impl.a(this.f1230c)) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void d() {
            AppCompatDelegateImpl.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class AutoNightModeManager {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f1232a;

        AutoNightModeManager() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f1232a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f1205r.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1232a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b8 = b();
            if (b8 != null && b8.countActions() != 0) {
                if (this.f1232a == null) {
                    this.f1232a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.d();
                        }
                    };
                }
                AppCompatDelegateImpl.this.f1205r.registerReceiver(this.f1232a, b8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AutoTimeNightModeManager extends AutoNightModeManager {

        /* renamed from: c  reason: collision with root package name */
        private final TwilightManager f1235c;

        AutoTimeNightModeManager(@NonNull TwilightManager twilightManager) {
            super();
            this.f1235c = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int c() {
            if (this.f1235c.d()) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void d() {
            AppCompatDelegateImpl.this.h();
        }
    }

    /* loaded from: classes.dex */
    private static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean b(int i8, int i9) {
            if (i8 >= -5 && i9 >= -5 && i8 <= getWidth() + 5 && i9 <= getHeight() + 5) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImpl.this.s0(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.m0(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i8) {
            setBackgroundDrawable(AppCompatResources.b(getContext(), i8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f1238a;

        /* renamed from: b  reason: collision with root package name */
        int f1239b;

        /* renamed from: c  reason: collision with root package name */
        int f1240c;

        /* renamed from: d  reason: collision with root package name */
        int f1241d;

        /* renamed from: e  reason: collision with root package name */
        int f1242e;

        /* renamed from: f  reason: collision with root package name */
        int f1243f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f1244g;

        /* renamed from: h  reason: collision with root package name */
        View f1245h;

        /* renamed from: i  reason: collision with root package name */
        View f1246i;

        /* renamed from: j  reason: collision with root package name */
        MenuBuilder f1247j;

        /* renamed from: k  reason: collision with root package name */
        ListMenuPresenter f1248k;

        /* renamed from: l  reason: collision with root package name */
        Context f1249l;

        /* renamed from: m  reason: collision with root package name */
        boolean f1250m;

        /* renamed from: n  reason: collision with root package name */
        boolean f1251n;

        /* renamed from: o  reason: collision with root package name */
        boolean f1252o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f1253p;

        /* renamed from: q  reason: collision with root package name */
        boolean f1254q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f1255r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f1256s;

        PanelFeatureState(int i8) {
            this.f1238a = i8;
        }

        MenuView a(MenuPresenter.Callback callback) {
            if (this.f1247j == null) {
                return null;
            }
            if (this.f1248k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f1249l, R$layout.f926j);
                this.f1248k = listMenuPresenter;
                listMenuPresenter.e(callback);
                this.f1247j.b(this.f1248k);
            }
            return this.f1248k.c(this.f1244g);
        }

        public boolean b() {
            if (this.f1245h == null) {
                return false;
            }
            if (this.f1246i == null && this.f1248k.b().getCount() <= 0) {
                return false;
            }
            return true;
        }

        void c(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f1247j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.O(this.f1248k);
            }
            this.f1247j = menuBuilder;
            if (menuBuilder != null && (listMenuPresenter = this.f1248k) != null) {
                menuBuilder.b(listMenuPresenter);
            }
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.f815a, typedValue, true);
            int i8 = typedValue.resourceId;
            if (i8 != 0) {
                newTheme.applyStyle(i8, true);
            }
            newTheme.resolveAttribute(R$attr.F, typedValue, true);
            int i9 = typedValue.resourceId;
            if (i9 != 0) {
                newTheme.applyStyle(i9, true);
            } else {
                newTheme.applyStyle(R$style.f953c, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1249l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.f1077y0);
            this.f1239b = obtainStyledAttributes.getResourceId(R$styleable.B0, 0);
            this.f1243f = obtainStyledAttributes.getResourceId(R$styleable.A0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(@NonNull MenuBuilder menuBuilder, boolean z7) {
            boolean z8;
            MenuBuilder D = menuBuilder.D();
            if (D != menuBuilder) {
                z8 = true;
            } else {
                z8 = false;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z8) {
                menuBuilder = D;
            }
            PanelFeatureState x02 = appCompatDelegateImpl.x0(menuBuilder);
            if (x02 != null) {
                if (z8) {
                    AppCompatDelegateImpl.this.j0(x02.f1238a, x02, D);
                    AppCompatDelegateImpl.this.n0(x02, true);
                    return;
                }
                AppCompatDelegateImpl.this.n0(x02, z7);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(@NonNull MenuBuilder menuBuilder) {
            Window.Callback G0;
            if (menuBuilder == menuBuilder.D()) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (appCompatDelegateImpl.N && (G0 = appCompatDelegateImpl.G0()) != null && !AppCompatDelegateImpl.this.Y) {
                    G0.onMenuOpened(108, menuBuilder);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
    }

    private int A0(Context context) {
        int i8;
        if (!this.f1191d0 && (this.f1204q instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i9 = Build.VERSION.SDK_INT;
                if (i9 >= 29) {
                    i8 = 269221888;
                } else if (i9 >= 24) {
                    i8 = 786432;
                } else {
                    i8 = 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f1204q.getClass()), i8);
                if (activityInfo != null) {
                    this.f1190c0 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e8) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e8);
                this.f1190c0 = 0;
            }
        }
        this.f1191d0 = true;
        return this.f1190c0;
    }

    private AutoNightModeManager B0(@NonNull Context context) {
        if (this.f1193f0 == null) {
            this.f1193f0 = new AutoBatteryNightModeManager(context);
        }
        return this.f1193f0;
    }

    private AutoNightModeManager C0(@NonNull Context context) {
        if (this.f1192e0 == null) {
            this.f1192e0 = new AutoTimeNightModeManager(TwilightManager.a(context));
        }
        return this.f1192e0;
    }

    private void H0() {
        v0();
        if (this.N && this.f1209v == null) {
            Object obj = this.f1204q;
            if (obj instanceof Activity) {
                this.f1209v = new WindowDecorActionBar((Activity) this.f1204q, this.O);
            } else if (obj instanceof Dialog) {
                this.f1209v = new WindowDecorActionBar((Dialog) this.f1204q);
            }
            ActionBar actionBar = this.f1209v;
            if (actionBar != null) {
                actionBar.r(this.f1197j0);
            }
        }
    }

    private boolean I0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f1246i;
        if (view != null) {
            panelFeatureState.f1245h = view;
            return true;
        } else if (panelFeatureState.f1247j == null) {
            return false;
        } else {
            if (this.A == null) {
                this.A = new PanelMenuPresenterCallback();
            }
            View view2 = (View) panelFeatureState.a(this.A);
            panelFeatureState.f1245h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    private boolean J0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(z0());
        panelFeatureState.f1244g = new ListMenuDecorView(panelFeatureState.f1249l);
        panelFeatureState.f1240c = 81;
        return true;
    }

    private boolean K0(PanelFeatureState panelFeatureState) {
        Context context = this.f1205r;
        int i8 = panelFeatureState.f1238a;
        if ((i8 == 0 || i8 == 108) && this.f1212y != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.f820f, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R$attr.f821g, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.f821g, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.R(this);
        panelFeatureState.c(menuBuilder);
        return true;
    }

    private void L0(int i8) {
        this.f1195h0 = (1 << i8) | this.f1195h0;
        if (!this.f1194g0) {
            ViewCompat.k0(this.f1206s.getDecorView(), this.f1196i0);
            this.f1194g0 = true;
        }
    }

    private boolean Q0(int i8, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState E0 = E0(i8, true);
            if (!E0.f1252o) {
                return a1(E0, keyEvent);
            }
            return false;
        }
        return false;
    }

    private boolean T0(int i8, KeyEvent keyEvent) {
        boolean z7;
        DecorContentParent decorContentParent;
        if (this.B != null) {
            return false;
        }
        boolean z8 = true;
        PanelFeatureState E0 = E0(i8, true);
        if (i8 == 0 && (decorContentParent = this.f1212y) != null && decorContentParent.a() && !ViewConfiguration.get(this.f1205r).hasPermanentMenuKey()) {
            if (!this.f1212y.e()) {
                if (!this.Y && a1(E0, keyEvent)) {
                    z8 = this.f1212y.c();
                }
                z8 = false;
            } else {
                z8 = this.f1212y.b();
            }
        } else {
            boolean z9 = E0.f1252o;
            if (!z9 && !E0.f1251n) {
                if (E0.f1250m) {
                    if (E0.f1255r) {
                        E0.f1250m = false;
                        z7 = a1(E0, keyEvent);
                    } else {
                        z7 = true;
                    }
                    if (z7) {
                        X0(E0, keyEvent);
                    }
                }
                z8 = false;
            } else {
                n0(E0, true);
                z8 = z9;
            }
        }
        if (z8) {
            AudioManager audioManager = (AudioManager) this.f1205r.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z8;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void X0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.X0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean Z0(PanelFeatureState panelFeatureState, int i8, KeyEvent keyEvent, int i9) {
        MenuBuilder menuBuilder;
        boolean z7 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f1250m || a1(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f1247j) != null) {
            z7 = menuBuilder.performShortcut(i8, keyEvent, i9);
        }
        if (z7 && (i9 & 1) == 0 && this.f1212y == null) {
            n0(panelFeatureState, true);
        }
        return z7;
    }

    private boolean a1(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z7;
        DecorContentParent decorContentParent;
        int i8;
        boolean z8;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.Y) {
            return false;
        }
        if (panelFeatureState.f1250m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.U;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            n0(panelFeatureState2, false);
        }
        Window.Callback G0 = G0();
        if (G0 != null) {
            panelFeatureState.f1246i = G0.onCreatePanelView(panelFeatureState.f1238a);
        }
        int i9 = panelFeatureState.f1238a;
        if (i9 != 0 && i9 != 108) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7 && (decorContentParent3 = this.f1212y) != null) {
            decorContentParent3.f();
        }
        if (panelFeatureState.f1246i == null && (!z7 || !(Y0() instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.f1247j;
            if (menuBuilder == null || panelFeatureState.f1255r) {
                if (menuBuilder == null && (!K0(panelFeatureState) || panelFeatureState.f1247j == null)) {
                    return false;
                }
                if (z7 && this.f1212y != null) {
                    if (this.f1213z == null) {
                        this.f1213z = new ActionMenuPresenterCallback();
                    }
                    this.f1212y.d(panelFeatureState.f1247j, this.f1213z);
                }
                panelFeatureState.f1247j.d0();
                if (!G0.onCreatePanelMenu(panelFeatureState.f1238a, panelFeatureState.f1247j)) {
                    panelFeatureState.c(null);
                    if (z7 && (decorContentParent = this.f1212y) != null) {
                        decorContentParent.d(null, this.f1213z);
                    }
                    return false;
                }
                panelFeatureState.f1255r = false;
            }
            panelFeatureState.f1247j.d0();
            Bundle bundle = panelFeatureState.f1256s;
            if (bundle != null) {
                panelFeatureState.f1247j.P(bundle);
                panelFeatureState.f1256s = null;
            }
            if (!G0.onPreparePanel(0, panelFeatureState.f1246i, panelFeatureState.f1247j)) {
                if (z7 && (decorContentParent2 = this.f1212y) != null) {
                    decorContentParent2.d(null, this.f1213z);
                }
                panelFeatureState.f1247j.c0();
                return false;
            }
            if (keyEvent != null) {
                i8 = keyEvent.getDeviceId();
            } else {
                i8 = -1;
            }
            if (KeyCharacterMap.load(i8).getKeyboardType() != 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            panelFeatureState.f1253p = z8;
            panelFeatureState.f1247j.setQwertyMode(z8);
            panelFeatureState.f1247j.c0();
        }
        panelFeatureState.f1250m = true;
        panelFeatureState.f1251n = false;
        this.U = panelFeatureState;
        return true;
    }

    private void b1(boolean z7) {
        DecorContentParent decorContentParent = this.f1212y;
        if (decorContentParent != null && decorContentParent.a() && (!ViewConfiguration.get(this.f1205r).hasPermanentMenuKey() || this.f1212y.g())) {
            Window.Callback G0 = G0();
            if (this.f1212y.e() && z7) {
                this.f1212y.b();
                if (!this.Y) {
                    G0.onPanelClosed(108, E0(0, true).f1247j);
                    return;
                }
                return;
            } else if (G0 != null && !this.Y) {
                if (this.f1194g0 && (this.f1195h0 & 1) != 0) {
                    this.f1206s.getDecorView().removeCallbacks(this.f1196i0);
                    this.f1196i0.run();
                }
                PanelFeatureState E0 = E0(0, true);
                MenuBuilder menuBuilder = E0.f1247j;
                if (menuBuilder != null && !E0.f1255r && G0.onPreparePanel(0, E0.f1246i, menuBuilder)) {
                    G0.onMenuOpened(108, E0.f1247j);
                    this.f1212y.c();
                    return;
                }
                return;
            } else {
                return;
            }
        }
        PanelFeatureState E02 = E0(0, true);
        E02.f1254q = true;
        n0(E02, false);
        X0(E02, null);
    }

    private int c1(int i8) {
        if (i8 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i8 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i8;
        }
    }

    private boolean d0(boolean z7) {
        return e0(z7, true);
    }

    private boolean e0(boolean z7, boolean z8) {
        if (this.Y) {
            return false;
        }
        int i02 = i0();
        int N0 = N0(this.f1205r, i02);
        LocaleListCompat localeListCompat = null;
        if (Build.VERSION.SDK_INT < 33) {
            localeListCompat = h0(this.f1205r);
        }
        if (!z8 && localeListCompat != null) {
            localeListCompat = D0(this.f1205r.getResources().getConfiguration());
        }
        boolean m12 = m1(N0, localeListCompat, z7);
        if (i02 == 0) {
            C0(this.f1205r).e();
        } else {
            AutoNightModeManager autoNightModeManager = this.f1192e0;
            if (autoNightModeManager != null) {
                autoNightModeManager.a();
            }
        }
        if (i02 == 3) {
            B0(this.f1205r).e();
        } else {
            AutoNightModeManager autoNightModeManager2 = this.f1193f0;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.a();
            }
        }
        return m12;
    }

    private void f0() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.I.findViewById(16908290);
        View decorView = this.f1206s.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f1205r.obtainStyledAttributes(R$styleable.f1077y0);
        obtainStyledAttributes.getValue(R$styleable.K0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.L0, contentFrameLayout.getMinWidthMinor());
        int i8 = R$styleable.I0;
        if (obtainStyledAttributes.hasValue(i8)) {
            obtainStyledAttributes.getValue(i8, contentFrameLayout.getFixedWidthMajor());
        }
        int i9 = R$styleable.J0;
        if (obtainStyledAttributes.hasValue(i9)) {
            obtainStyledAttributes.getValue(i9, contentFrameLayout.getFixedWidthMinor());
        }
        int i10 = R$styleable.G0;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedHeightMajor());
        }
        int i11 = R$styleable.H0;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void g0(@NonNull Window window) {
        if (this.f1206s == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.f1207t = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                TintTypedArray u7 = TintTypedArray.u(this.f1205r, null, f1185s0);
                Drawable h8 = u7.h(0);
                if (h8 != null) {
                    window.setBackgroundDrawable(h8);
                }
                u7.w();
                this.f1206s = window;
                if (Build.VERSION.SDK_INT >= 33 && this.f1202o0 == null) {
                    X(null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean g1(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1206s.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.V((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int i0() {
        int i8 = this.f1188a0;
        if (i8 == -100) {
            return AppCompatDelegate.s();
        }
        return i8;
    }

    private void j1() {
        if (!this.H) {
            return;
        }
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private AppCompatActivity k1() {
        for (Context context = this.f1205r; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void l0() {
        AutoNightModeManager autoNightModeManager = this.f1192e0;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
        AutoNightModeManager autoNightModeManager2 = this.f1193f0;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.a();
        }
    }

    private void l1(Configuration configuration) {
        Activity activity = (Activity) this.f1204q;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().b().a(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.X && !this.Y) {
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m1(int r9, androidx.core.os.LocaleListCompat r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.f1205r
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.o0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f1205r
            int r1 = r8.A0(r1)
            android.content.res.Configuration r2 = r8.Z
            if (r2 != 0) goto L1f
            android.content.Context r2 = r8.f1205r
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.LocaleListCompat r2 = r8.D0(r2)
            r5 = 0
            if (r10 != 0) goto L30
            r0 = r5
            goto L34
        L30:
            androidx.core.os.LocaleListCompat r0 = r8.D0(r0)
        L34:
            r6 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.17E-43)
            goto L3b
        L3a:
            r3 = 0
        L3b:
            if (r0 == 0) goto L47
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            r2 = r3 | 4
            r3 = r2 | 8192(0x2000, float:1.148E-41)
        L47:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L71
            if (r11 == 0) goto L71
            boolean r11 = r8.W
            if (r11 == 0) goto L71
            boolean r11 = androidx.appcompat.app.AppCompatDelegateImpl.f1186t0
            if (r11 != 0) goto L5a
            boolean r11 = r8.X
            if (r11 == 0) goto L71
        L5a:
            java.lang.Object r11 = r8.f1204q
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L71
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L71
            java.lang.Object r11 = r8.f1204q
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.ActivityCompat.f(r11)
            r11 = 1
            goto L72
        L71:
            r11 = 0
        L72:
            if (r11 != 0) goto L7f
            if (r3 == 0) goto L7f
            r11 = r3 & r1
            if (r11 != r3) goto L7b
            r6 = 1
        L7b:
            r8.o1(r4, r0, r6, r5)
            goto L80
        L7f:
            r7 = r11
        L80:
            if (r7 == 0) goto L9c
            java.lang.Object r11 = r8.f1204q
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L9c
            r1 = r3 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L91
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.onNightModeChanged(r9)
        L91:
            r9 = r3 & 4
            if (r9 == 0) goto L9c
            java.lang.Object r9 = r8.f1204q
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.onLocalesChanged(r10)
        L9c:
            if (r7 == 0) goto Lb1
            if (r0 == 0) goto Lb1
            android.content.Context r9 = r8.f1205r
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.LocaleListCompat r9 = r8.D0(r9)
            r8.e1(r9)
        Lb1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m1(int, androidx.core.os.LocaleListCompat, boolean):boolean");
    }

    @NonNull
    private Configuration o0(@NonNull Context context, int i8, LocaleListCompat localeListCompat, Configuration configuration, boolean z7) {
        int i9;
        if (i8 != 1) {
            if (i8 != 2) {
                if (z7) {
                    i9 = 0;
                } else {
                    i9 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                }
            } else {
                i9 = 32;
            }
        } else {
            i9 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i9 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            d1(configuration2, localeListCompat);
        }
        return configuration2;
    }

    private void o1(int i8, LocaleListCompat localeListCompat, boolean z7, Configuration configuration) {
        Resources resources = this.f1205r.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i8 | (resources.getConfiguration().uiMode & (-49));
        if (localeListCompat != null) {
            d1(configuration2, localeListCompat);
        }
        resources.updateConfiguration(configuration2, null);
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 26) {
            ResourcesFlusher.a(resources);
        }
        int i10 = this.f1189b0;
        if (i10 != 0) {
            this.f1205r.setTheme(i10);
            if (i9 >= 23) {
                this.f1205r.getTheme().applyStyle(this.f1189b0, true);
            }
        }
        if (z7 && (this.f1204q instanceof Activity)) {
            l1(configuration2);
        }
    }

    private ViewGroup p0() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f1205r.obtainStyledAttributes(R$styleable.f1077y0);
        int i8 = R$styleable.D0;
        if (obtainStyledAttributes.hasValue(i8)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.M0, false)) {
                P(1);
            } else if (obtainStyledAttributes.getBoolean(i8, false)) {
                P(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.E0, false)) {
                P(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.F0, false)) {
                P(10);
            }
            this.Q = obtainStyledAttributes.getBoolean(R$styleable.f1082z0, false);
            obtainStyledAttributes.recycle();
            w0();
            this.f1206s.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f1205r);
            if (!this.R) {
                if (this.Q) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.f922f, (ViewGroup) null);
                    this.O = false;
                    this.N = false;
                } else if (this.N) {
                    TypedValue typedValue = new TypedValue();
                    this.f1205r.getTheme().resolveAttribute(R$attr.f820f, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new androidx.appcompat.view.ContextThemeWrapper(this.f1205r, typedValue.resourceId);
                    } else {
                        context = this.f1205r;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.f932p, (ViewGroup) null);
                    DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R$id.f906p);
                    this.f1212y = decorContentParent;
                    decorContentParent.setWindowCallback(G0());
                    if (this.O) {
                        this.f1212y.h(109);
                    }
                    if (this.L) {
                        this.f1212y.h(2);
                    }
                    if (this.M) {
                        this.f1212y.h(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                viewGroup = this.P ? (ViewGroup) from.inflate(R$layout.f931o, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.f930n, (ViewGroup) null);
            }
            if (viewGroup != null) {
                ViewCompat.G0(viewGroup, new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                        int l8 = windowInsetsCompat.l();
                        int p12 = AppCompatDelegateImpl.this.p1(windowInsetsCompat, null);
                        if (l8 != p12) {
                            windowInsetsCompat = windowInsetsCompat.p(windowInsetsCompat.j(), p12, windowInsetsCompat.k(), windowInsetsCompat.i());
                        }
                        return ViewCompat.e0(view, windowInsetsCompat);
                    }
                });
                if (this.f1212y == null) {
                    this.J = (TextView) viewGroup.findViewById(R$id.M);
                }
                ViewUtils.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.f892b);
                ViewGroup viewGroup2 = (ViewGroup) this.f1206s.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f1206s.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
                    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
                    public void a() {
                    }

                    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
                    public void onDetachedFromWindow() {
                        AppCompatDelegateImpl.this.r0();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.N + ", windowActionBarOverlay: " + this.O + ", android:windowIsFloating: " + this.Q + ", windowActionModeOverlay: " + this.P + ", windowNoTitle: " + this.R + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void q1(View view) {
        boolean z7;
        int color;
        if ((ViewCompat.O(view) & FragmentTransaction.TRANSIT_EXIT_MASK) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            color = ContextCompat.getColor(this.f1205r, R$color.f843b);
        } else {
            color = ContextCompat.getColor(this.f1205r, R$color.f842a);
        }
        view.setBackgroundColor(color);
    }

    private void v0() {
        if (!this.H) {
            this.I = p0();
            CharSequence F0 = F0();
            if (!TextUtils.isEmpty(F0)) {
                DecorContentParent decorContentParent = this.f1212y;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(F0);
                } else if (Y0() != null) {
                    Y0().x(F0);
                } else {
                    TextView textView = this.J;
                    if (textView != null) {
                        textView.setText(F0);
                    }
                }
            }
            f0();
            W0(this.I);
            this.H = true;
            PanelFeatureState E0 = E0(0, false);
            if (!this.Y) {
                if (E0 == null || E0.f1247j == null) {
                    L0(108);
                }
            }
        }
    }

    private void w0() {
        if (this.f1206s == null) {
            Object obj = this.f1204q;
            if (obj instanceof Activity) {
                g0(((Activity) obj).getWindow());
            }
        }
        if (this.f1206s != null) {
            return;
        }
        throw new IllegalStateException("We have not been given a Window");
    }

    @NonNull
    private static Configuration y0(@NonNull Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f8 = configuration.fontScale;
            float f9 = configuration2.fontScale;
            if (f8 != f9) {
                configuration3.fontScale = f9;
            }
            int i8 = configuration.mcc;
            int i9 = configuration2.mcc;
            if (i8 != i9) {
                configuration3.mcc = i9;
            }
            int i10 = configuration.mnc;
            int i11 = configuration2.mnc;
            if (i10 != i11) {
                configuration3.mnc = i11;
            }
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 24) {
                Api24Impl.a(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i13 = configuration.touchscreen;
            int i14 = configuration2.touchscreen;
            if (i13 != i14) {
                configuration3.touchscreen = i14;
            }
            int i15 = configuration.keyboard;
            int i16 = configuration2.keyboard;
            if (i15 != i16) {
                configuration3.keyboard = i16;
            }
            int i17 = configuration.keyboardHidden;
            int i18 = configuration2.keyboardHidden;
            if (i17 != i18) {
                configuration3.keyboardHidden = i18;
            }
            int i19 = configuration.navigation;
            int i20 = configuration2.navigation;
            if (i19 != i20) {
                configuration3.navigation = i20;
            }
            int i21 = configuration.navigationHidden;
            int i22 = configuration2.navigationHidden;
            if (i21 != i22) {
                configuration3.navigationHidden = i22;
            }
            int i23 = configuration.orientation;
            int i24 = configuration2.orientation;
            if (i23 != i24) {
                configuration3.orientation = i24;
            }
            int i25 = configuration.screenLayout & 15;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 15)) {
                configuration3.screenLayout |= i26 & 15;
            }
            int i27 = configuration.screenLayout & 192;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 192)) {
                configuration3.screenLayout |= i28 & 192;
            }
            int i29 = configuration.screenLayout & 48;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 48)) {
                configuration3.screenLayout |= i30 & 48;
            }
            int i31 = configuration.screenLayout & 768;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 768)) {
                configuration3.screenLayout |= i32 & 768;
            }
            if (i12 >= 26) {
                Api26Impl.a(configuration, configuration2, configuration3);
            }
            int i33 = configuration.uiMode & 15;
            int i34 = configuration2.uiMode;
            if (i33 != (i34 & 15)) {
                configuration3.uiMode |= i34 & 15;
            }
            int i35 = configuration.uiMode & 48;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 48)) {
                configuration3.uiMode |= i36 & 48;
            }
            int i37 = configuration.screenWidthDp;
            int i38 = configuration2.screenWidthDp;
            if (i37 != i38) {
                configuration3.screenWidthDp = i38;
            }
            int i39 = configuration.screenHeightDp;
            int i40 = configuration2.screenHeightDp;
            if (i39 != i40) {
                configuration3.screenHeightDp = i40;
            }
            int i41 = configuration.smallestScreenWidthDp;
            int i42 = configuration2.smallestScreenWidthDp;
            if (i41 != i42) {
                configuration3.smallestScreenWidthDp = i42;
            }
            Api17Impl.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void A() {
        LayoutInflater from = LayoutInflater.from(this.f1205r);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.a(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void B() {
        if (Y0() != null && !z().l()) {
            L0(0);
        }
    }

    LocaleListCompat D0(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b(configuration);
        }
        return LocaleListCompat.c(Api21Impl.b(configuration.locale));
    }

    protected PanelFeatureState E0(int i8, boolean z7) {
        PanelFeatureState[] panelFeatureStateArr = this.T;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i8) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i8 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.T = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i8];
        if (panelFeatureState == null) {
            PanelFeatureState panelFeatureState2 = new PanelFeatureState(i8);
            panelFeatureStateArr[i8] = panelFeatureState2;
            return panelFeatureState2;
        }
        return panelFeatureState;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void F(Configuration configuration) {
        ActionBar z7;
        if (this.N && this.H && (z7 = z()) != null) {
            z7.m(configuration);
        }
        AppCompatDrawableManager.b().g(this.f1205r);
        this.Z = new Configuration(this.f1205r.getResources().getConfiguration());
        e0(false, false);
    }

    final CharSequence F0() {
        Object obj = this.f1204q;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f1211x;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void G(Bundle bundle) {
        this.W = true;
        d0(false);
        w0();
        Object obj = this.f1204q;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar Y0 = Y0();
                if (Y0 == null) {
                    this.f1197j0 = true;
                } else {
                    Y0.r(true);
                }
            }
            AppCompatDelegate.e(this);
        }
        this.Z = new Configuration(this.f1205r.getResources().getConfiguration());
        this.X = true;
    }

    final Window.Callback G0() {
        return this.f1206s.getCallback();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void H() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1204q
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.AppCompatDelegate.N(r3)
        L9:
            boolean r0 = r3.f1194g0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f1206s
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f1196i0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.Y = r0
            int r0 = r3.f1188a0
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f1204q
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1183q0
            java.lang.Object r1 = r3.f1204q
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f1188a0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1183q0
            java.lang.Object r1 = r3.f1204q
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.ActionBar r0 = r3.f1209v
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.l0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.H():void");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void I(Bundle bundle) {
        v0();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void J() {
        ActionBar z7 = z();
        if (z7 != null) {
            z7.u(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void K(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void L() {
        e0(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void M() {
        ActionBar z7 = z();
        if (z7 != null) {
            z7.u(false);
        }
    }

    public boolean M0() {
        return this.G;
    }

    int N0(@NonNull Context context, int i8) {
        if (i8 == -100) {
            return -1;
        }
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 != 1 && i8 != 2) {
                    if (i8 == 3) {
                        return B0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return C0(context).c();
            }
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O0() {
        boolean z7 = this.V;
        this.V = false;
        PanelFeatureState E0 = E0(0, false);
        if (E0 != null && E0.f1252o) {
            if (!z7) {
                n0(E0, true);
            }
            return true;
        }
        ActionMode actionMode = this.B;
        if (actionMode != null) {
            actionMode.c();
            return true;
        }
        ActionBar z8 = z();
        if (z8 == null || !z8.h()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean P(int i8) {
        int c12 = c1(i8);
        if (this.R && c12 == 108) {
            return false;
        }
        if (this.N && c12 == 1) {
            this.N = false;
        }
        if (c12 != 1) {
            if (c12 != 2) {
                if (c12 != 5) {
                    if (c12 != 10) {
                        if (c12 != 108) {
                            if (c12 != 109) {
                                return this.f1206s.requestFeature(c12);
                            }
                            j1();
                            this.O = true;
                            return true;
                        }
                        j1();
                        this.N = true;
                        return true;
                    }
                    j1();
                    this.P = true;
                    return true;
                }
                j1();
                this.M = true;
                return true;
            }
            j1();
            this.L = true;
            return true;
        }
        j1();
        this.R = true;
        return true;
    }

    boolean P0(int i8, KeyEvent keyEvent) {
        boolean z7 = true;
        if (i8 != 4) {
            if (i8 == 82) {
                Q0(0, keyEvent);
                return true;
            }
        } else {
            if ((keyEvent.getFlags() & 128) == 0) {
                z7 = false;
            }
            this.V = z7;
        }
        return false;
    }

    boolean R0(int i8, KeyEvent keyEvent) {
        ActionBar z7 = z();
        if (z7 != null && z7.o(i8, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.U;
        if (panelFeatureState != null && Z0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.U;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f1251n = true;
            }
            return true;
        }
        if (this.U == null) {
            PanelFeatureState E0 = E0(0, true);
            a1(E0, keyEvent);
            boolean Z0 = Z0(E0, keyEvent.getKeyCode(), keyEvent, 1);
            E0.f1250m = false;
            if (Z0) {
                return true;
            }
        }
        return false;
    }

    boolean S0(int i8, KeyEvent keyEvent) {
        if (i8 != 4) {
            if (i8 == 82) {
                T0(0, keyEvent);
                return true;
            }
        } else if (O0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void T(int i8) {
        v0();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1205r).inflate(i8, viewGroup);
        this.f1207t.c(this.f1206s.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void U(View view) {
        v0();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1207t.c(this.f1206s.getCallback());
    }

    void U0(int i8) {
        ActionBar z7;
        if (i8 == 108 && (z7 = z()) != null) {
            z7.i(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void V(View view, ViewGroup.LayoutParams layoutParams) {
        v0();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1207t.c(this.f1206s.getCallback());
    }

    void V0(int i8) {
        if (i8 == 108) {
            ActionBar z7 = z();
            if (z7 != null) {
                z7.i(false);
            }
        } else if (i8 == 0) {
            PanelFeatureState E0 = E0(i8, true);
            if (E0.f1252o) {
                n0(E0, false);
            }
        }
    }

    void W0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void X(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.X(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f1202o0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f1203p0) != null) {
            Api33Impl.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f1203p0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f1204q;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f1202o0 = Api33Impl.a((Activity) this.f1204q);
                n1();
            }
        }
        this.f1202o0 = onBackInvokedDispatcher;
        n1();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void Y(Toolbar toolbar) {
        if (!(this.f1204q instanceof Activity)) {
            return;
        }
        ActionBar z7 = z();
        if (!(z7 instanceof WindowDecorActionBar)) {
            this.f1210w = null;
            if (z7 != null) {
                z7.n();
            }
            this.f1209v = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, F0(), this.f1207t);
                this.f1209v = toolbarActionBar;
                this.f1207t.e(toolbarActionBar.f1279c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f1207t.e(null);
            }
            B();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    final ActionBar Y0() {
        return this.f1209v;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void Z(int i8) {
        this.f1189b0 = i8;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        PanelFeatureState x02;
        Window.Callback G0 = G0();
        if (G0 != null && !this.Y && (x02 = x0(menuBuilder.D())) != null) {
            return G0.onMenuItemSelected(x02.f1238a, menuItem);
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void a0(CharSequence charSequence) {
        this.f1211x = charSequence;
        DecorContentParent decorContentParent = this.f1212y;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (Y0() != null) {
            Y0().x(charSequence);
        } else {
            TextView textView = this.J;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void b(@NonNull MenuBuilder menuBuilder) {
        b1(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode b0(@NonNull ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            ActionMode actionMode = this.B;
            if (actionMode != null) {
                actionMode.c();
            }
            ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
            ActionBar z7 = z();
            if (z7 != null) {
                ActionMode y7 = z7.y(actionModeCallbackWrapperV9);
                this.B = y7;
                if (y7 != null && (appCompatCallback = this.f1208u) != null) {
                    appCompatCallback.onSupportActionModeStarted(y7);
                }
            }
            if (this.B == null) {
                this.B = i1(actionModeCallbackWrapperV9);
            }
            n1();
            return this.B;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    void d1(Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.d(configuration, localeListCompat);
            return;
        }
        Api17Impl.d(configuration, localeListCompat.d(0));
        Api17Impl.c(configuration, localeListCompat.d(0));
    }

    void e1(LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.c(localeListCompat);
        } else {
            Locale.setDefault(localeListCompat.d(0));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void f(View view, ViewGroup.LayoutParams layoutParams) {
        v0();
        ((ViewGroup) this.I.findViewById(16908290)).addView(view, layoutParams);
        this.f1207t.c(this.f1206s.getCallback());
    }

    final boolean f1() {
        ViewGroup viewGroup;
        if (this.H && (viewGroup = this.I) != null && ViewCompat.W(viewGroup)) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    boolean g() {
        if (AppCompatDelegate.C(this.f1205r) && AppCompatDelegate.x() != null && !AppCompatDelegate.x().equals(AppCompatDelegate.y())) {
            k(this.f1205r);
        }
        return d0(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean h() {
        return d0(true);
    }

    LocaleListCompat h0(@NonNull Context context) {
        LocaleListCompat x7;
        LocaleListCompat c8;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 33 || (x7 = AppCompatDelegate.x()) == null) {
            return null;
        }
        LocaleListCompat D0 = D0(context.getApplicationContext().getResources().getConfiguration());
        if (i8 >= 24) {
            c8 = LocaleOverlayHelper.b(x7, D0);
        } else if (x7.f()) {
            c8 = LocaleListCompat.e();
        } else {
            c8 = LocaleListCompat.c(x7.d(0).toString());
        }
        if (!c8.f()) {
            return c8;
        }
        return D0;
    }

    boolean h1() {
        if (this.f1202o0 == null) {
            return false;
        }
        PanelFeatureState E0 = E0(0, false);
        if ((E0 == null || !E0.f1252o) && this.B == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.appcompat.view.ActionMode i1(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.i1(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    void j0(int i8, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i8 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.T;
                if (i8 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i8];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1247j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1252o) && !this.Y) {
            this.f1207t.d(this.f1206s.getCallback(), i8, menu);
        }
    }

    void k0(@NonNull MenuBuilder menuBuilder) {
        if (this.S) {
            return;
        }
        this.S = true;
        this.f1212y.l();
        Window.Callback G0 = G0();
        if (G0 != null && !this.Y) {
            G0.onPanelClosed(108, menuBuilder);
        }
        this.S = false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @NonNull
    public Context m(@NonNull Context context) {
        boolean z7 = true;
        this.W = true;
        int N0 = N0(context, i0());
        if (AppCompatDelegate.C(context)) {
            AppCompatDelegate.c0(context);
        }
        LocaleListCompat h02 = h0(context);
        if (f1187u0 && (context instanceof ContextThemeWrapper)) {
            try {
                ContextThemeWrapperCompatApi17Impl.a((ContextThemeWrapper) context, o0(context, N0, h02, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).a(o0(context, N0, h02, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f1186t0) {
            return super.m(context);
        }
        Configuration configuration = null;
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = Api17Impl.a(context, configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = y0(configuration3, configuration4);
        }
        Configuration o02 = o0(context, N0, h02, configuration, true);
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R$style.f954d);
        contextThemeWrapper.a(o02);
        boolean z8 = false;
        try {
            if (context.getTheme() == null) {
                z7 = false;
            }
            z8 = z7;
        } catch (NullPointerException unused3) {
        }
        if (z8) {
            ResourcesCompat.ThemeCompat.a(contextThemeWrapper.getTheme());
        }
        return super.m(contextThemeWrapper);
    }

    void m0(int i8) {
        n0(E0(i8, true), true);
    }

    void n0(PanelFeatureState panelFeatureState, boolean z7) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z7 && panelFeatureState.f1238a == 0 && (decorContentParent = this.f1212y) != null && decorContentParent.e()) {
            k0(panelFeatureState.f1247j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1205r.getSystemService("window");
        if (windowManager != null && panelFeatureState.f1252o && (viewGroup = panelFeatureState.f1244g) != null) {
            windowManager.removeView(viewGroup);
            if (z7) {
                j0(panelFeatureState.f1238a, panelFeatureState, null);
            }
        }
        panelFeatureState.f1250m = false;
        panelFeatureState.f1251n = false;
        panelFeatureState.f1252o = false;
        panelFeatureState.f1245h = null;
        panelFeatureState.f1254q = true;
        if (this.U == panelFeatureState) {
            this.U = null;
        }
        if (panelFeatureState.f1238a == 0) {
            n1();
        }
    }

    void n1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean h12 = h1();
            if (h12 && this.f1203p0 == null) {
                this.f1203p0 = Api33Impl.b(this.f1202o0, this);
            } else if (!h12 && (onBackInvokedCallback = this.f1203p0) != null) {
                Api33Impl.c(this.f1202o0, onBackInvokedCallback);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return q0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public <T extends View> T p(int i8) {
        v0();
        return (T) this.f1206s.findViewById(i8);
    }

    final int p1(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int i8;
        boolean z7;
        int j8;
        int k8;
        boolean z8;
        int i9 = 0;
        if (windowInsetsCompat != null) {
            i8 = windowInsetsCompat.l();
        } else if (rect != null) {
            i8 = rect.top;
        } else {
            i8 = 0;
        }
        ActionBarContextView actionBarContextView = this.C;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
            boolean z9 = true;
            if (this.C.isShown()) {
                if (this.f1198k0 == null) {
                    this.f1198k0 = new Rect();
                    this.f1199l0 = new Rect();
                }
                Rect rect2 = this.f1198k0;
                Rect rect3 = this.f1199l0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.j(), windowInsetsCompat.l(), windowInsetsCompat.k(), windowInsetsCompat.i());
                }
                ViewUtils.a(this.I, rect2, rect3);
                int i10 = rect2.top;
                int i11 = rect2.left;
                int i12 = rect2.right;
                WindowInsetsCompat K = ViewCompat.K(this.I);
                if (K == null) {
                    j8 = 0;
                } else {
                    j8 = K.j();
                }
                if (K == null) {
                    k8 = 0;
                } else {
                    k8 = K.k();
                }
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z8 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z8 = true;
                }
                if (i10 > 0 && this.K == null) {
                    View view = new View(this.f1205r);
                    this.K = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = j8;
                    layoutParams.rightMargin = k8;
                    this.I.addView(this.K, -1, layoutParams);
                } else {
                    View view2 = this.K;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i13 = marginLayoutParams2.height;
                        int i14 = marginLayoutParams.topMargin;
                        if (i13 != i14 || marginLayoutParams2.leftMargin != j8 || marginLayoutParams2.rightMargin != k8) {
                            marginLayoutParams2.height = i14;
                            marginLayoutParams2.leftMargin = j8;
                            marginLayoutParams2.rightMargin = k8;
                            this.K.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.K;
                if (view3 == null) {
                    z9 = false;
                }
                if (z9 && view3.getVisibility() != 0) {
                    q1(this.K);
                }
                if (!this.P && z9) {
                    i8 = 0;
                }
                z7 = z9;
                z9 = z8;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z7 = false;
            } else {
                z7 = false;
                z9 = false;
            }
            if (z9) {
                this.C.setLayoutParams(marginLayoutParams);
            }
        } else {
            z7 = false;
        }
        View view4 = this.K;
        if (view4 != null) {
            if (!z7) {
                i9 = 8;
            }
            view4.setVisibility(i9);
        }
        return i8;
    }

    public View q0(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z7;
        boolean z8 = false;
        if (this.f1200m0 == null) {
            String string = this.f1205r.obtainStyledAttributes(R$styleable.f1077y0).getString(R$styleable.C0);
            if (string == null) {
                this.f1200m0 = new AppCompatViewInflater();
            } else {
                try {
                    this.f1200m0 = (AppCompatViewInflater) this.f1205r.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f1200m0 = new AppCompatViewInflater();
                }
            }
        }
        boolean z9 = f1184r0;
        if (z9) {
            if (this.f1201n0 == null) {
                this.f1201n0 = new LayoutIncludeDetector();
            }
            if (this.f1201n0.a(attributeSet)) {
                z7 = true;
            } else {
                if (attributeSet instanceof XmlPullParser) {
                    if (((XmlPullParser) attributeSet).getDepth() > 1) {
                        z8 = true;
                    }
                } else {
                    z8 = g1((ViewParent) view);
                }
                z7 = z8;
            }
        } else {
            z7 = false;
        }
        return this.f1200m0.createView(view, str, context, attributeSet, z7, z9, true, VectorEnabledTintResources.d());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context r() {
        return this.f1205r;
    }

    void r0() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.f1212y;
        if (decorContentParent != null) {
            decorContentParent.l();
        }
        if (this.D != null) {
            this.f1206s.getDecorView().removeCallbacks(this.E);
            if (this.D.isShowing()) {
                try {
                    this.D.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.D = null;
        }
        u0();
        PanelFeatureState E0 = E0(0, false);
        if (E0 != null && (menuBuilder = E0.f1247j) != null) {
            menuBuilder.close();
        }
    }

    boolean s0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1204q;
        boolean z7 = true;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f1206s.getDecorView()) != null && KeyEventDispatcher.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1207t.b(this.f1206s.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z7 = false;
        }
        if (z7) {
            return P0(keyCode, keyEvent);
        }
        return S0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle$Delegate t() {
        return new ActionBarDrawableToggleImpl();
    }

    void t0(int i8) {
        PanelFeatureState E0;
        PanelFeatureState E02 = E0(i8, true);
        if (E02.f1247j != null) {
            Bundle bundle = new Bundle();
            E02.f1247j.Q(bundle);
            if (bundle.size() > 0) {
                E02.f1256s = bundle;
            }
            E02.f1247j.d0();
            E02.f1247j.clear();
        }
        E02.f1255r = true;
        E02.f1254q = true;
        if ((i8 == 108 || i8 == 0) && this.f1212y != null && (E0 = E0(0, false)) != null) {
            E0.f1250m = false;
            a1(E0, null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int u() {
        return this.f1188a0;
    }

    void u0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.F;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater w() {
        Context context;
        if (this.f1210w == null) {
            H0();
            ActionBar actionBar = this.f1209v;
            if (actionBar != null) {
                context = actionBar.k();
            } else {
                context = this.f1205r;
            }
            this.f1210w = new SupportMenuInflater(context);
        }
        return this.f1210w;
    }

    PanelFeatureState x0(Menu menu) {
        int i8;
        PanelFeatureState[] panelFeatureStateArr = this.T;
        if (panelFeatureStateArr != null) {
            i8 = panelFeatureStateArr.length;
        } else {
            i8 = 0;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i9];
            if (panelFeatureState != null && panelFeatureState.f1247j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar z() {
        H0();
        return this.f1209v;
    }

    final Context z0() {
        Context context;
        ActionBar z7 = z();
        if (z7 != null) {
            context = z7.k();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f1205r;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        SimpleArrayMap<String, Integer> simpleArrayMap;
        Integer num;
        AppCompatActivity k12;
        this.F = null;
        this.G = true;
        this.f1188a0 = -100;
        this.f1196i0 = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl.f1195h0 & 1) != 0) {
                    appCompatDelegateImpl.t0(0);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl2.f1195h0 & 4096) != 0) {
                    appCompatDelegateImpl2.t0(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f1194g0 = false;
                appCompatDelegateImpl3.f1195h0 = 0;
            }
        };
        this.f1205r = context;
        this.f1208u = appCompatCallback;
        this.f1204q = obj;
        if (this.f1188a0 == -100 && (obj instanceof Dialog) && (k12 = k1()) != null) {
            this.f1188a0 = k12.getDelegate().u();
        }
        if (this.f1188a0 == -100 && (num = (simpleArrayMap = f1183q0).get(obj.getClass().getName())) != null) {
            this.f1188a0 = num.intValue();
            simpleArrayMap.remove(obj.getClass().getName());
        }
        if (window != null) {
            g0(window);
        }
        AppCompatDrawableManager.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AppCompatWindowCallback extends WindowCallbackWrapper {

        /* renamed from: g  reason: collision with root package name */
        private ActionBarMenuCallback f1225g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1226h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1227i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f1228j;

        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f1227i = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f1227i = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f1226h = true;
                callback.onContentChanged();
            } finally {
                this.f1226h = false;
            }
        }

        public void d(Window.Callback callback, int i8, Menu menu) {
            try {
                this.f1228j = true;
                callback.onPanelClosed(i8, menu);
            } finally {
                this.f1228j = false;
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f1227i) {
                return a().dispatchKeyEvent(keyEvent);
            }
            if (!AppCompatDelegateImpl.this.s0(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent) && !AppCompatDelegateImpl.this.R0(keyEvent.getKeyCode(), keyEvent)) {
                return false;
            }
            return true;
        }

        void e(ActionBarMenuCallback actionBarMenuCallback) {
            this.f1225g = actionBarMenuCallback;
        }

        final android.view.ActionMode f(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.f1205r, callback);
            androidx.appcompat.view.ActionMode b02 = AppCompatDelegateImpl.this.b0(callbackWrapper);
            if (b02 != null) {
                return callbackWrapper.e(b02);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f1226h) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i8, Menu menu) {
            if (i8 == 0 && !(menu instanceof MenuBuilder)) {
                return false;
            }
            return super.onCreatePanelMenu(i8, menu);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i8) {
            View onCreatePanelView;
            ActionBarMenuCallback actionBarMenuCallback = this.f1225g;
            if (actionBarMenuCallback != null && (onCreatePanelView = actionBarMenuCallback.onCreatePanelView(i8)) != null) {
                return onCreatePanelView;
            }
            return super.onCreatePanelView(i8);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i8, Menu menu) {
            super.onMenuOpened(i8, menu);
            AppCompatDelegateImpl.this.U0(i8);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i8, Menu menu) {
            if (this.f1228j) {
                a().onPanelClosed(i8, menu);
                return;
            }
            super.onPanelClosed(i8, menu);
            AppCompatDelegateImpl.this.V0(i8);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i8, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (i8 == 0 && menuBuilder == null) {
                return false;
            }
            boolean z7 = true;
            if (menuBuilder != null) {
                menuBuilder.a0(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.f1225g;
            z7 = (actionBarMenuCallback == null || !actionBarMenuCallback.a(i8)) ? false : false;
            if (!z7) {
                z7 = super.onPreparePanel(i8, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.a0(false);
            }
            return z7;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i8) {
            MenuBuilder menuBuilder;
            PanelFeatureState E0 = AppCompatDelegateImpl.this.E0(0, true);
            if (E0 != null && (menuBuilder = E0.f1247j) != null) {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i8);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i8);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.M0()) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i8) {
            if (AppCompatDelegateImpl.this.M0() && i8 == 0) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback, i8);
        }
    }
}
