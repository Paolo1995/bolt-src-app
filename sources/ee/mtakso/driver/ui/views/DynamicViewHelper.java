package ee.mtakso.driver.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicViewHelper.kt */
/* loaded from: classes5.dex */
public final class DynamicViewHelper<VH extends ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f34322a;

    /* renamed from: b  reason: collision with root package name */
    private final List<VH> f34323b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintHelper f34324c;

    /* renamed from: d  reason: collision with root package name */
    private final Function2<LayoutInflater, ViewGroup, VH> f34325d;

    /* compiled from: DynamicViewHelper.kt */
    /* loaded from: classes5.dex */
    public interface ViewHolder {
        View a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DynamicViewHelper(ViewGroup containerView, List<VH> viewHolders, ConstraintHelper constraintHelper, Function2<? super LayoutInflater, ? super ViewGroup, ? extends VH> inflater) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(viewHolders, "viewHolders");
        Intrinsics.f(inflater, "inflater");
        this.f34322a = containerView;
        this.f34323b = viewHolders;
        this.f34324c = constraintHelper;
        this.f34325d = inflater;
    }

    public final void a(int i8, Function2<? super VH, ? super Integer, Unit> binder) {
        int v7;
        int[] G0;
        Intrinsics.f(binder, "binder");
        for (int size = this.f34323b.size(); size < i8; size++) {
            Function2<LayoutInflater, ViewGroup, VH> function2 = this.f34325d;
            LayoutInflater from = LayoutInflater.from(this.f34322a.getContext());
            Intrinsics.e(from, "from(containerView.context)");
            VH s7 = function2.s(from, this.f34322a);
            s7.a().setId(View.generateViewId());
            this.f34322a.addView(s7.a());
            this.f34323b.add(s7);
            ConstraintHelper constraintHelper = this.f34324c;
            if (constraintHelper != null) {
                List<VH> list = this.f34323b;
                v7 = CollectionsKt__IterablesKt.v(list, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (VH vh : list) {
                    arrayList.add(Integer.valueOf(vh.a().getId()));
                }
                G0 = CollectionsKt___CollectionsKt.G0(arrayList);
                constraintHelper.setReferencedIds(G0);
            }
        }
        for (int i9 = 0; i9 < i8; i9++) {
            VH vh2 = this.f34323b.get(i9);
            ViewExtKt.d(vh2.a(), false, 0, 3, null);
            binder.s(vh2, Integer.valueOf(i9));
        }
        int size2 = this.f34323b.size();
        while (i8 < size2) {
            ViewExtKt.d(this.f34323b.get(i8).a(), false, 0, 2, null);
            i8++;
        }
    }

    public /* synthetic */ DynamicViewHelper(ViewGroup viewGroup, List list, ConstraintHelper constraintHelper, Function2 function2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i8 & 2) != 0 ? new ArrayList() : list, (i8 & 4) != 0 ? null : constraintHelper, function2);
    }
}
