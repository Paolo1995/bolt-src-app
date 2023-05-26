package eu.bolt.driver.core.ui.base.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import ee.mtakso.driver.uicore.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBottomSheetFragment.kt */
/* loaded from: classes5.dex */
public abstract class BaseBottomSheetFragment extends BottomSheetDialogFragment {

    /* renamed from: h  reason: collision with root package name */
    private static final Companion f41008h = new Companion(null);
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    private static final int f41009i = Dimens.d(460);

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, View> f41010g = new LinkedHashMap();

    /* compiled from: BaseBottomSheetFragment.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void H() {
        this.f41010g.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(Throwable error) {
        Intrinsics.f(error, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Dialog dialog;
        Window window;
        super.onResume();
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        if (ContextUtils.b(requireContext) && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
            window.setLayout(f41009i, -1);
        }
    }
}
