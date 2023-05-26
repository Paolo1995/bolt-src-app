package eu.bolt.driver.core.ui.base.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import eu.bolt.driver.core.R$id;
import eu.bolt.driver.core.R$layout;
import eu.bolt.driver.core.ui.common.dialog.helper.ItemViewInflater;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinearScrollableDialogFragment.kt */
/* loaded from: classes5.dex */
public abstract class LinearScrollableDialogFragment extends BaseDialogFragment {

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f41033j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f41034k;

    public LinearScrollableDialogFragment() {
        this(false, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearScrollableDialogFragment(boolean z7) {
        super(z7);
        Lazy b8;
        this.f41034k = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<ItemViewInflater>() { // from class: eu.bolt.driver.core.ui.base.dialog.LinearScrollableDialogFragment$inflater$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ItemViewInflater invoke() {
                LayoutInflater layoutInflater;
                layoutInflater = super/*androidx.fragment.app.Fragment*/.getLayoutInflater();
                Intrinsics.e(layoutInflater, "super.getLayoutInflater()");
                return new ItemViewInflater(layoutInflater);
            }
        });
        this.f41033j = b8;
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment
    public void D() {
        this.f41034k.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ItemViewInflater M() {
        return (ItemViewInflater) this.f41033j.getValue();
    }

    public abstract void N(ViewGroup viewGroup, Bundle bundle);

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater infl, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(infl, "infl");
        return infl.inflate(R$layout.dialog_linear, viewGroup, false);
    }

    @Override // eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.f40765c);
        Intrinsics.e(linearLayout, "view.container");
        N(linearLayout, bundle);
    }

    public /* synthetic */ LinearScrollableDialogFragment(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7);
    }
}
