package eu.bolt.driver.core.ui.base.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uicore.utils.WindowExtKt;
import ee.mtakso.driver.uikit.bottomsheet.SecondaryBottomSheetBehavior;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.R$id;
import eu.bolt.driver.core.R$layout;
import eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondaryBottomSheetFragment.kt */
/* loaded from: classes5.dex */
public abstract class SecondaryBottomSheetFragment extends BaseBottomSheetFragment {

    /* renamed from: o  reason: collision with root package name */
    private static final Companion f41017o = new Companion(null);
    @Deprecated

    /* renamed from: p  reason: collision with root package name */
    private static final int f41018p = Dimens.d(380);
    @Deprecated

    /* renamed from: q  reason: collision with root package name */
    private static final int f41019q = Dimens.d(56);

    /* renamed from: j  reason: collision with root package name */
    private final int f41020j;

    /* renamed from: k  reason: collision with root package name */
    private SecondaryBottomSheetBehavior<?> f41021k;

    /* renamed from: l  reason: collision with root package name */
    private View f41022l;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f41024n = new LinkedHashMap();

    /* renamed from: m  reason: collision with root package name */
    private boolean f41023m = true;

    /* compiled from: SecondaryBottomSheetFragment.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SecondaryBottomSheetFragment(int i8) {
        this.f41020j = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final SecondaryBottomSheetFragment this$0, Dialog dialog, DialogInterface dialogInterface) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(dialog, "$dialog");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        Intrinsics.e(window, "activity.window");
        int a8 = WindowExtKt.b(window).a();
        int i8 = f41019q;
        int i9 = a8 - i8;
        FrameLayout bottomSheet = (FrameLayout) dialog.findViewById(R$id.f40766e);
        Context requireContext = this$0.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        this$0.f41021k = new SecondaryBottomSheetBehavior<>(requireContext, null, 2, null);
        Intrinsics.e(bottomSheet, "bottomSheet");
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();
        if (layoutParams != null) {
            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
            layoutParams2.o(this$0.f41021k);
            bottomSheet.setLayoutParams(layoutParams2);
            SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior = this$0.f41021k;
            if (secondaryBottomSheetBehavior != null) {
                secondaryBottomSheetBehavior.Y(new BottomSheetBehavior.BottomSheetCallback() { // from class: eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment$onCreateDialog$1$2
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void b(View bottomSheet2, float f8) {
                        Intrinsics.f(bottomSheet2, "bottomSheet");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void c(View bottomSheet2, int i10) {
                        Intrinsics.f(bottomSheet2, "bottomSheet");
                        if (i10 == 5) {
                            SecondaryBottomSheetFragment.this.dismissAllowingStateLoss();
                        }
                    }
                });
            }
            SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior2 = this$0.f41021k;
            if (secondaryBottomSheetBehavior2 != null) {
                secondaryBottomSheetBehavior2.g1(i8);
            }
            SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior3 = this$0.f41021k;
            if (secondaryBottomSheetBehavior3 != null) {
                secondaryBottomSheetBehavior3.L0(Math.min(f41018p, i9));
            }
            SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior4 = this$0.f41021k;
            if (secondaryBottomSheetBehavior4 != null) {
                secondaryBottomSheetBehavior4.Q0(3);
            }
            SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior5 = this$0.f41021k;
            if (secondaryBottomSheetBehavior5 != null) {
                secondaryBottomSheetBehavior5.f1(this$0.f41023m);
            }
            this$0.W();
            View view = this$0.f41022l;
            if (view != null) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: c7.d
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                        SecondaryBottomSheetFragment.S(SecondaryBottomSheetFragment.this, view2, i10, i11, i12, i13, i14, i15, i16, i17);
                    }
                });
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(SecondaryBottomSheetFragment this$0, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(this$0, "this$0");
        this$0.W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(SecondaryBottomSheetFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q();
        this$0.dismissAllowingStateLoss();
    }

    private final void V() {
        if (getView() == null) {
            return;
        }
        RoundButton closeButton = (RoundButton) O(R$id.f40764b);
        Intrinsics.e(closeButton, "closeButton");
        ViewExtKt.e(closeButton, isCancelable(), 0, 2, null);
    }

    private final void W() {
        SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior;
        boolean z7;
        View view = this.f41022l;
        if (view == null || (secondaryBottomSheetBehavior = this.f41021k) == null) {
            return;
        }
        ImageView bottomSheetIndicator = (ImageView) O(R$id.bottomSheetIndicator);
        Intrinsics.e(bottomSheetIndicator, "bottomSheetIndicator");
        if (view.getHeight() > secondaryBottomSheetBehavior.o0()) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(bottomSheetIndicator, z7, 4);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f41024n.clear();
    }

    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f41024n;
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

    public final void P() {
        SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior = this.f41021k;
        if (secondaryBottomSheetBehavior != null) {
            secondaryBottomSheetBehavior.Q0(3);
        }
    }

    public void Q() {
    }

    public final void U(boolean z7) {
        this.f41023m = z7;
        SecondaryBottomSheetBehavior<?> secondaryBottomSheetBehavior = this.f41021k;
        if (secondaryBottomSheetBehavior != null) {
            secondaryBottomSheetBehavior.f1(z7);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: c7.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SecondaryBottomSheetFragment.R(SecondaryBottomSheetFragment.this, onCreateDialog, dialogInterface);
            }
        });
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        View inflate = inflater.inflate(R$layout.bottom_sheet_secondary, viewGroup, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        FrameLayout frameLayout = (FrameLayout) viewGroup2.findViewById(R$id.contentPlaceholder);
        View inflate2 = inflater.inflate(this.f41020j, viewGroup2, false);
        inflate2.setLayoutParams(frameLayout.getLayoutParams());
        viewGroup2.removeView(frameLayout);
        viewGroup2.addView(inflate2, 0);
        this.f41022l = inflate2;
        return viewGroup2;
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f41021k = null;
        this.f41022l = null;
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        V();
        ((RoundButton) O(R$id.f40764b)).setOnClickListener(new View.OnClickListener() { // from class: c7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SecondaryBottomSheetFragment.T(SecondaryBottomSheetFragment.this, view2);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean z7) {
        super.setCancelable(z7);
        V();
    }
}
