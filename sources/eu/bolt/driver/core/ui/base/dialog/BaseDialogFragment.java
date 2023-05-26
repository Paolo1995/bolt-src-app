package eu.bolt.driver.core.ui.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDialogFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseDialogFragment extends DialogFragment {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f41026i = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final boolean f41027f;

    /* renamed from: g  reason: collision with root package name */
    private DialogCallback f41028g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f41029h = new LinkedHashMap();

    /* compiled from: BaseDialogFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, String fragmentTag, DialogCallback callback) {
            Fragment fragment;
            Intrinsics.f(fragmentTag, "fragmentTag");
            Intrinsics.f(callback, "callback");
            BaseDialogFragment baseDialogFragment = null;
            if (fragmentManager != null) {
                fragment = fragmentManager.findFragmentByTag(fragmentTag);
            } else {
                fragment = null;
            }
            if (fragment instanceof BaseDialogFragment) {
                baseDialogFragment = (BaseDialogFragment) fragment;
            }
            if (baseDialogFragment == null) {
                return;
            }
            baseDialogFragment.K(callback);
        }
    }

    public BaseDialogFragment(boolean z7) {
        this.f41027f = z7;
    }

    public static final void J(FragmentManager fragmentManager, String str, DialogCallback dialogCallback) {
        f41026i.a(fragmentManager, str, dialogCallback);
    }

    public void D() {
        this.f41029h.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DialogCallback E() {
        return this.f41028g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CharSequence F(String key, CharSequence fallback) {
        Intrinsics.f(key, "key");
        Intrinsics.f(fallback, "fallback");
        CharSequence charSequence = requireArguments().getCharSequence(key, fallback);
        Intrinsics.e(charSequence, "requireArguments().getCharSequence(key, fallback)");
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int G(String key) {
        Intrinsics.f(key, "key");
        int i8 = requireArguments().getInt(key, 0);
        if (i8 != 0) {
            return i8;
        }
        throw new IllegalStateException("Resource id not found by key " + key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String H(String key, String fallback) {
        Intrinsics.f(key, "key");
        Intrinsics.f(fallback, "fallback");
        String string = requireArguments().getString(key, fallback);
        Intrinsics.e(string, "requireArguments().getString(key, fallback)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DialogCallback I() {
        DialogCallback dialogCallback = this.f41028g;
        if (dialogCallback != null) {
            return dialogCallback;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(DialogCallback dialogCallback) {
        this.f41028g = dialogCallback;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.f(dialog, "dialog");
        super.onCancel(dialog);
        I().b(this, DialogLifecycleEvent.CANCELLED, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.requestWindowFeature(1);
        Window window = onCreateDialog.getWindow();
        if (window == null) {
            Kalev.e(new NullPointerException("Dialog window is null"), "Failed to adjust dialog dimming / lock screen appearance");
        } else {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            if (this.f41027f) {
                window.addFlags(4194304);
                window.addFlags(524288);
                window.addFlags(2097152);
            }
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
        double d8;
        double d9;
        super.onStart();
        DialogCallback dialogCallback = this.f41028g;
        Window window = null;
        if (dialogCallback != null) {
            dialogCallback.b(this, DialogLifecycleEvent.STARTED, null);
        }
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        Dialog dialog = getDialog();
        if (dialog != null) {
            window = dialog.getWindow();
        }
        if (window == null) {
            Kalev.e(new NullPointerException("Dialog window is null"), "Failed to adjust dialog size");
            return;
        }
        int i8 = ContextUtils.a(requireContext).widthPixels;
        if (ContextUtils.b(requireContext)) {
            d8 = i8;
            d9 = 0.72d;
        } else {
            d8 = i8;
            d9 = 0.87d;
        }
        window.setLayout((int) (d8 * d9), -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }
}
