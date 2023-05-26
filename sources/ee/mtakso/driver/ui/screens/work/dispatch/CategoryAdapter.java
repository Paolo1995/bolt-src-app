package ee.mtakso.driver.ui.screens.work.dispatch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.CustomCheckBox;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CategoryAdapter.kt */
/* loaded from: classes5.dex */
public final class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {

    /* renamed from: d  reason: collision with root package name */
    private final Function2<Integer, Boolean, Unit> f33949d;

    /* renamed from: e  reason: collision with root package name */
    private final Function1<Integer, Unit> f33950e;

    /* renamed from: f  reason: collision with root package name */
    private List<DispatchCategorySetting> f33951f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33952g;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryAdapter(Function2<? super Integer, ? super Boolean, Unit> checkedCallback, Function1<? super Integer, Unit> surgeButtonCallback) {
        List<DispatchCategorySetting> k8;
        Intrinsics.f(checkedCallback, "checkedCallback");
        Intrinsics.f(surgeButtonCallback, "surgeButtonCallback");
        this.f33949d = checkedCallback;
        this.f33950e = surgeButtonCallback;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f33951f = k8;
    }

    private final void X(final List<DispatchCategorySetting> list, final boolean z7) {
        DiffUtil.b(new DiffUtil.Callback() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.CategoryAdapter$updateAdapter$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean a(int i8, int i9) {
                boolean z8;
                List list2;
                z8 = CategoryAdapter.this.f33952g;
                if (z8 == z7) {
                    list2 = CategoryAdapter.this.f33951f;
                    if (Intrinsics.a(list2.get(i8), list.get(i9))) {
                        return true;
                    }
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean b(int i8, int i9) {
                List list2;
                list2 = CategoryAdapter.this.f33951f;
                return Intrinsics.a(((DispatchCategorySetting) list2.get(i8)).a().c(), list.get(i9).a().c());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int d() {
                return list.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int e() {
                List list2;
                list2 = CategoryAdapter.this.f33951f;
                return list2.size();
            }
        }).c(this);
    }

    public final List<DispatchCategorySetting> R() {
        return this.f33951f;
    }

    public final void S() {
        if (!this.f33952g) {
            return;
        }
        this.f33952g = false;
        w();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: T */
    public void E(CategoryHolder holder, int i8) {
        int a8;
        int a9;
        Intrinsics.f(holder, "holder");
        CustomCheckBox S = holder.S();
        DispatchCategorySetting dispatchCategorySetting = this.f33951f.get(i8);
        if (dispatchCategorySetting.a().e() != S.isChecked()) {
            S.setChecked(dispatchCategorySetting.a().e());
        }
        holder.W().setText(dispatchCategorySetting.a().d());
        if (TextUtils.isEmpty(dispatchCategorySetting.b())) {
            ViewExtKt.d(holder.T(), false, 0, 2, null);
        } else {
            holder.T().setText(dispatchCategorySetting.b());
            Context context = holder.T().getContext();
            if (dispatchCategorySetting.a().e()) {
                Color.Attr attr = new Color.Attr(R.attr.colorBgDangerSecondary);
                Intrinsics.e(context, "context");
                a8 = ColorKt.a(attr, context);
                a9 = ColorKt.a(new Color.Attr(R.attr.colorContentDangerPrimary), context);
            } else {
                Color.Attr attr2 = new Color.Attr(R.attr.labelBackgroundGraySmall);
                Intrinsics.e(context, "context");
                a8 = ColorKt.a(attr2, context);
                a9 = ColorKt.a(new Color.Attr(R.attr.labelContentGraySmall), context);
            }
            holder.T().setChipBackgroundColor(ColorStateList.valueOf(a8));
            holder.T().setTextColor(a9);
            holder.T().setChipIconTint(ColorStateList.valueOf(a9));
            ViewExtKt.d(holder.T(), false, 0, 3, null);
        }
        Boolean c8 = dispatchCategorySetting.c();
        if (Intrinsics.a(c8, Boolean.TRUE)) {
            ViewExtKt.d(holder.V(), false, 0, 3, null);
            holder.V().setImageResource(R.drawable.ic_show_fill_24dp);
            ImageButton V = holder.V();
            Context context2 = holder.V().getContext();
            Intrinsics.e(context2, "holder.surgeButton.context");
            ImageViewCompat.c(V, ContextUtilsKt.c(context2, R.attr.accentNeutral));
        } else if (Intrinsics.a(c8, Boolean.FALSE)) {
            ViewExtKt.d(holder.V(), false, 0, 3, null);
            holder.V().setImageResource(R.drawable.ic_hide_fill_24dp);
            ImageButton V2 = holder.V();
            Context context3 = holder.V().getContext();
            Intrinsics.e(context3, "holder.surgeButton.context");
            ImageViewCompat.c(V2, ContextUtilsKt.c(context3, R.attr.dynamicNeutral04));
        } else {
            ViewExtKt.d(holder.V(), false, 0, 2, null);
        }
        if (this.f33952g) {
            Color.Attr attr3 = new Color.Attr(R.attr.colorContentDangerPrimary);
            Context context4 = holder.f7332a.getContext();
            Intrinsics.e(context4, "holder.itemView.context");
            S.setBorderColor(ColorKt.a(attr3, context4));
            return;
        }
        Color.Attr attr4 = new Color.Attr(R.attr.colorBgActiveNeutralSecondaryHard);
        Context context5 = holder.f7332a.getContext();
        Intrinsics.e(context5, "holder.itemView.context");
        S.setBorderColor(ColorKt.a(attr4, context5));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: U */
    public CategoryHolder G(ViewGroup parent, int i8) {
        Intrinsics.f(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        Intrinsics.e(inflate, "from(parent.context).inf…_category, parent, false)");
        return new CategoryHolder(inflate, this.f33949d, this.f33950e);
    }

    public final void V() {
        this.f33952g = true;
        w();
    }

    public final void W(List<DispatchCategorySetting> itemsList, boolean z7) {
        Intrinsics.f(itemsList, "itemsList");
        X(itemsList, z7);
        this.f33951f = itemsList;
        this.f33952g = z7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f33951f.size();
    }
}
