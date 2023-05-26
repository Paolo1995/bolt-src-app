package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    private static Configuration f1433f;

    /* renamed from: a  reason: collision with root package name */
    private int f1434a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f1435b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f1436c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f1437d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f1438e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static Context a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            return contextThemeWrapper.createConfigurationContext(configuration);
        }
    }

    public ContextThemeWrapper() {
        super(null);
    }

    private Resources b() {
        if (this.f1438e == null) {
            Configuration configuration = this.f1437d;
            if (configuration != null && (Build.VERSION.SDK_INT < 26 || !e(configuration))) {
                this.f1438e = Api17Impl.a(this, this.f1437d).getResources();
            } else {
                this.f1438e = super.getResources();
            }
        }
        return this.f1438e;
    }

    private void d() {
        boolean z7;
        if (this.f1435b == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f1435b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1435b.setTo(theme);
            }
        }
        f(this.f1435b, this.f1434a, z7);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f1433f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f1433f = configuration2;
        }
        return configuration.equals(f1433f);
    }

    public void a(Configuration configuration) {
        if (this.f1438e == null) {
            if (this.f1437d == null) {
                this.f1437d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f1434a;
    }

    protected void f(Resources.Theme theme, int i8, boolean z7) {
        theme.applyStyle(i8, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f1436c == null) {
                this.f1436c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f1436c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1435b;
        if (theme != null) {
            return theme;
        }
        if (this.f1434a == 0) {
            this.f1434a = R$style.f955e;
        }
        d();
        return this.f1435b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i8) {
        if (this.f1434a != i8) {
            this.f1434a = i8;
            d();
        }
    }

    public ContextThemeWrapper(Context context, int i8) {
        super(context);
        this.f1434a = i8;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f1435b = theme;
    }
}
