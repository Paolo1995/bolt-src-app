package ee.mtakso.driver.uicore.components.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RestoreableDialogFragment.kt */
/* loaded from: classes5.dex */
public abstract class RestoreableDialogFragment extends DialogFragment {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f34751j = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private Function3<? super DialogFragment, ? super View, Object, Unit> f34752f;

    /* renamed from: g  reason: collision with root package name */
    private Function3<? super DialogFragment, ? super View, Object, Unit> f34753g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f34754h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, View> f34755i = new LinkedHashMap();

    /* compiled from: RestoreableDialogFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(Companion companion, FragmentManager fragmentManager, String str, Function3 function3, Function3 function32, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                function3 = null;
            }
            if ((i8 & 8) != 0) {
                function32 = null;
            }
            companion.a(fragmentManager, str, function3, function32);
        }

        public final void a(FragmentManager fragmentManager, String tag, Function3<? super DialogFragment, ? super View, Object, Unit> function3, Function3<? super DialogFragment, ? super View, Object, Unit> function32) {
            Fragment fragment;
            Intrinsics.f(tag, "tag");
            RestoreableDialogFragment restoreableDialogFragment = null;
            if (fragmentManager != null) {
                fragment = fragmentManager.findFragmentByTag(tag);
            } else {
                fragment = null;
            }
            if (fragment instanceof RestoreableDialogFragment) {
                restoreableDialogFragment = (RestoreableDialogFragment) fragment;
            }
            if (restoreableDialogFragment == null) {
                return;
            }
            restoreableDialogFragment.K(function3);
            restoreableDialogFragment.J(function32);
        }
    }

    public void D() {
        this.f34755i.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int E(String key) {
        Intrinsics.f(key, "key");
        return requireArguments().getInt(key);
    }

    public final Function3<DialogFragment, View, Object, Unit> F() {
        return this.f34753g;
    }

    public final Function3<DialogFragment, View, Object, Unit> G() {
        return this.f34752f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String H(String key, String fallback) {
        Intrinsics.f(key, "key");
        Intrinsics.f(fallback, "fallback");
        String string = requireArguments().getString(key, fallback);
        Intrinsics.e(string, "requireArguments().getString(key, fallback)");
        return string;
    }

    protected boolean I() {
        return this.f34754h;
    }

    public final void J(Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
        this.f34753g = function3;
    }

    public final void K(Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
        this.f34752f = function3;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        super.onCancel(dialog);
        Function3<? super DialogFragment, ? super View, Object, Unit> function3 = this.f34752f;
        if (function3 != null) {
            function3.l(this, null, "dialog_cancel");
        }
        Function3<? super DialogFragment, ? super View, Object, Unit> function32 = this.f34753g;
        if (function32 != null) {
            function32.l(this, null, "dialog_cancel");
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        if (I() && (window = onCreateDialog.getWindow()) != null) {
            window.addFlags(4194304);
            window.addFlags(524288);
            window.addFlags(2097152);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Function3<? super DialogFragment, ? super View, Object, Unit> function3 = this.f34753g;
        if (function3 != null) {
            function3.l(this, null, "dialog_shown");
        }
    }
}
