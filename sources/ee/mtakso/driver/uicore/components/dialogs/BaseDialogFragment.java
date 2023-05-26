package ee.mtakso.driver.uicore.components.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.LogEntry;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: BaseDialogFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseDialogFragment extends RestoreableDialogFragment {

    /* renamed from: l  reason: collision with root package name */
    protected static final Companion f34743l = new Companion(null);

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f34744k = new LinkedHashMap();

    /* compiled from: BaseDialogFragment.kt */
    /* loaded from: classes5.dex */
    protected static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean M() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Kalev.n(Name.LABEL, getClass().getSimpleName()).n("host", null).n("args", getArguments()).o(new IllegalStateException("Skipped dialog start. Activity is null")).b("Dialog will not start");
            return false;
        } else if (activity.isFinishing()) {
            Kalev.n(Name.LABEL, getClass().getSimpleName()).n("host", activity.getClass().getSimpleName()).n("args", getArguments()).o(new IllegalStateException("Skipped dialog start. Activity is finishing")).b("Dialog will not start");
            return false;
        } else {
            return true;
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment
    public void D() {
        this.f34744k.clear();
    }

    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f34744k;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ViewGroup N() {
        LinearLayout container = (LinearLayout) L(R$id.f34598k);
        Intrinsics.e(container, "container");
        return container;
    }

    public abstract void O(ViewGroup viewGroup, Bundle bundle);

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Kalev.n(Name.LABEL, getClass().getSimpleName()).n("args", getArguments()).a("Dialog created");
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            Window window2 = onCreateDialog.getWindow();
            if (window2 != null && (layoutParams = window2.getAttributes()) != null) {
                layoutParams.dimAmount = 0.5f;
                layoutParams.flags |= 2;
            } else {
                layoutParams = null;
            }
            window.setAttributes(layoutParams);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R$layout.content_base_dialog, viewGroup, false);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        String str;
        double d8;
        double d9;
        Window window;
        Window window2;
        Window window3;
        M();
        String str2 = null;
        DisplayMetrics displayMetrics = null;
        try {
            super.onStart();
            LogEntry n8 = Kalev.n(Name.LABEL, getClass().getSimpleName());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                str = activity.getClass().getSimpleName();
            } else {
                str = null;
            }
            n8.n("host", str).n("args", getArguments()).a("Dialog started");
            Context context = getContext();
            if (context != null) {
                displayMetrics = ContextUtils.a(context);
            }
            if (displayMetrics == null) {
                Dialog dialog = getDialog();
                if (dialog != null && (window3 = dialog.getWindow()) != null) {
                    window3.setLayout(-1, -2);
                }
            } else {
                int i8 = displayMetrics.widthPixels;
                Context requireContext = requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                if (ContextUtils.b(requireContext)) {
                    d8 = i8;
                    d9 = 0.72d;
                } else {
                    d8 = i8;
                    d9 = 0.87d;
                }
                double d10 = d8 * d9;
                Dialog dialog2 = getDialog();
                if (dialog2 != null && (window = dialog2.getWindow()) != null) {
                    window.setLayout((int) d10, -2);
                }
            }
            Dialog dialog3 = getDialog();
            if (dialog3 != null && (window2 = dialog3.getWindow()) != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
        } catch (WindowManager.BadTokenException e8) {
            LogEntry n9 = Kalev.n(Name.LABEL, getClass().getSimpleName());
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                str2 = activity2.getClass().getSimpleName();
            }
            n9.n("host", str2).n("args", getArguments()).o(e8).b("Failed to start dialog");
            throw e8;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.f34598k);
        Intrinsics.e(linearLayout, "view.container");
        O(linearLayout, bundle);
    }
}
