package ee.mtakso.driver.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentFactory;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import eu.bolt.driver.core.ui.translation.TranslatedContext;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public abstract class BaseActivity extends AppCompatActivity {
    @Inject

    /* renamed from: f  reason: collision with root package name */
    PermissionManager f26224f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    FragmentFactory f26225g;

    /* renamed from: h  reason: collision with root package name */
    PermissionWatchDog f26226h;

    /* renamed from: i  reason: collision with root package name */
    private Resources f26227i = null;

    private boolean N() {
        return false;
    }

    private void R() {
        if (O()) {
            setSupportActionBar(M());
        }
    }

    protected void L(Window window) {
        window.addFlags(4194304);
        window.addFlags(524288);
        window.addFlags(2097152);
    }

    protected Toolbar M() {
        if (O()) {
            return (Toolbar) findViewById(R.id.toolbar);
        }
        return null;
    }

    protected boolean O() {
        if (findViewById(R.id.toolbar) != null) {
            return true;
        }
        return false;
    }

    protected abstract void P();

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().s(true);
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i8 = configuration.uiMode;
            configuration.setTo(getResources().getConfiguration());
            configuration.uiMode = i8;
        }
        super.applyOverrideConfiguration(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(TranslatedContext.a(Injector.f2().a().b(context)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f26227i == null) {
            this.f26227i = new TranslatedResources(super.getResources());
        }
        return this.f26227i;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null && bundle.getInt("process_id") != Process.myPid()) {
            AppRoutingManager.a(this);
            finish();
        }
        P();
        getSupportFragmentManager().setFragmentFactory(this.f26225g);
        super.onCreate(bundle);
        this.f26226h = this.f26224f.f(this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332 && N()) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i8, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i8, strArr, iArr);
        PermissionWatchDog permissionWatchDog = this.f26226h;
        if (permissionWatchDog != null) {
            permissionWatchDog.c(i8, strArr, iArr);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("process_id", Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            L(window);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i8) {
        super.setTitle(getString(i8));
    }
}
