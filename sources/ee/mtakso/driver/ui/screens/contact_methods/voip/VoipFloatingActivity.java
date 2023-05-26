package ee.mtakso.driver.ui.screens.contact_methods.voip;

import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import ee.mtakso.driver.ui.base.BaseActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import eu.bolt.kalev.Kalev;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import z2.a;

/* compiled from: VoipFloatingActivity.kt */
/* loaded from: classes3.dex */
public final class VoipFloatingActivity extends BaseActivity {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f27818p = new Companion(null);
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public VoipActiveWindowTracker f27819j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public VoipNotificationDrawer f27820k;

    /* renamed from: l  reason: collision with root package name */
    private DismissableDialog f27821l;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public AppThemeManager f27823n;

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f27824o = new LinkedHashMap();

    /* renamed from: m  reason: collision with root package name */
    private final DialogInterface.OnDismissListener f27822m = new DialogInterface.OnDismissListener() { // from class: b3.a
        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            VoipFloatingActivity.X(VoipFloatingActivity.this, dialogInterface);
        }
    };

    /* compiled from: VoipFloatingActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void T() {
        KeyguardManager keyguardManager;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 27) {
            setTurnScreenOn(true);
        } else {
            getWindow().addFlags(6816897);
        }
        if (i8 >= 26) {
            Object systemService = getSystemService("keyguard");
            if (systemService instanceof KeyguardManager) {
                keyguardManager = (KeyguardManager) systemService;
            } else {
                keyguardManager = null;
            }
            if (keyguardManager != null) {
                a.a(keyguardManager, this, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(VoipFloatingActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.f(this$0, "this$0");
        this$0.finish();
    }

    @Override // ee.mtakso.driver.ui.base.BaseActivity
    protected void P() {
        Injector.f20166d.b().Y1().u(this);
    }

    public final AppThemeManager U() {
        AppThemeManager appThemeManager = this.f27823n;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    public final VoipActiveWindowTracker V() {
        VoipActiveWindowTracker voipActiveWindowTracker = this.f27819j;
        if (voipActiveWindowTracker != null) {
            return voipActiveWindowTracker;
        }
        Intrinsics.w("voipActiveWindowManager");
        return null;
    }

    public final VoipNotificationDrawer W() {
        VoipNotificationDrawer voipNotificationDrawer = this.f27820k;
        if (voipNotificationDrawer != null) {
            return voipNotificationDrawer;
        }
        Intrinsics.w("voipNotificationDrawer");
        return null;
    }

    @Override // ee.mtakso.driver.ui.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Class cls;
        DialogFragment dialogFragment;
        super.onCreate(bundle);
        setContentView(new View(this));
        T();
        ThemeActivityExtKt.a(this, U().c());
        Serializable serializableExtra = getIntent().getSerializableExtra("dialog_class_argument");
        Object obj = null;
        if (serializableExtra instanceof Class) {
            cls = (Class) serializableExtra;
        } else {
            cls = null;
        }
        Bundle bundleExtra = getIntent().getBundleExtra("dialog_extra_params");
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("contact_methods_dialog");
        if (findFragmentByTag instanceof DialogFragment) {
            dialogFragment = (DialogFragment) findFragmentByTag;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
        if (cls == null) {
            Intent intent = getIntent();
            if (intent != null) {
                obj = intent.getExtras();
            }
            String str = "Extra \"dialog_class_argument\" is null. Intent extra: " + obj;
            Kalev.m(new IllegalArgumentException(str), str);
            finish();
            return;
        }
        Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        Intrinsics.d(newInstance, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.contact_methods.voip.DismissableDialog");
        DismissableDialog dismissableDialog = (DismissableDialog) newInstance;
        this.f27821l = dismissableDialog;
        if (dismissableDialog == null) {
            Intrinsics.w("currentDialog");
            dismissableDialog = null;
        }
        dismissableDialog.z(this.f27822m);
        DismissableDialog dismissableDialog2 = this.f27821l;
        if (dismissableDialog2 == null) {
            Intrinsics.w("currentDialog");
            dismissableDialog2 = null;
        }
        ((AppCompatDialogFragment) dismissableDialog2).setArguments(bundleExtra);
        Object obj2 = this.f27821l;
        if (obj2 == null) {
            Intrinsics.w("currentDialog");
        } else {
            obj = obj2;
        }
        ((AppCompatDialogFragment) obj).show(getSupportFragmentManager(), "contact_methods_dialog");
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
        }
        V().l(this);
        W().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        V().j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DismissableDialog dismissableDialog = this.f27821l;
        if (dismissableDialog == null) {
            Intrinsics.w("currentDialog");
            dismissableDialog = null;
        }
        dismissableDialog.z(this.f27822m);
    }
}
