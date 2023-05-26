package ee.mtakso.driver.uicore.components.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.R$id;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.WindowExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseScrollableBottomSheetDialogFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseScrollableBottomSheetDialogFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: o  reason: collision with root package name */
    private static final Companion f34745o = new Companion(null);
    @Deprecated

    /* renamed from: p  reason: collision with root package name */
    private static final int f34746p = Dimens.d(48);

    /* renamed from: k  reason: collision with root package name */
    private final int f34747k;

    /* renamed from: l  reason: collision with root package name */
    private final Integer f34748l;

    /* renamed from: m  reason: collision with root package name */
    private Context f34749m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f34750n;

    /* compiled from: BaseScrollableBottomSheetDialogFragment.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseScrollableBottomSheetDialogFragment(int i8, Integer num) {
        this.f34750n = new LinkedHashMap();
        this.f34747k = i8;
        this.f34748l = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(BaseScrollableBottomSheetDialogFragment this$0, Dialog dialog, DialogInterface dialogInterface) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(dialog, "$dialog");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) dialog.findViewById(R$id.f12491f);
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(frameLayout);
        Intrinsics.e(k02, "from(bottomSheet)");
        if (frameLayout != null) {
            layoutParams = frameLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Window window = activity.getWindow();
        Intrinsics.e(window, "activity.window");
        int a8 = WindowExtKt.b(window).a() - f34746p;
        if (frameLayout.getHeight() > a8) {
            if (layoutParams != null) {
                layoutParams.height = a8;
            }
            frameLayout.setLayoutParams(layoutParams);
            k02.L0(a8);
        } else {
            k02.L0(frameLayout.getHeight());
        }
        k02.Q0(3);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f34750n.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        Context context = this.f34749m;
        if (context == null) {
            return super.getContext();
        }
        return context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        Integer num = this.f34748l;
        if (num != null && num.intValue() != 0) {
            this.f34749m = new ContextThemeWrapper(context, num.intValue());
        }
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: o5.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BaseScrollableBottomSheetDialogFragment.K(BaseScrollableBottomSheetDialogFragment.this, onCreateDialog, dialogInterface);
            }
        });
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        NestedScrollView nestedScrollView;
        Intrinsics.f(inflater, "inflater");
        View inflate = inflater.inflate(R$layout.content_scroolable_bottom_sheet_dialog, viewGroup, false);
        View rootView = inflate.getRootView();
        if (rootView instanceof NestedScrollView) {
            nestedScrollView = (NestedScrollView) rootView;
        } else {
            nestedScrollView = null;
        }
        if (nestedScrollView == null) {
            return inflater.inflate(this.f34747k, viewGroup, false);
        }
        inflater.inflate(this.f34747k, (ViewGroup) nestedScrollView, true);
        return inflate;
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    public /* synthetic */ BaseScrollableBottomSheetDialogFragment(int i8, Integer num, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8, (i9 & 2) != 0 ? null : num);
    }
}
