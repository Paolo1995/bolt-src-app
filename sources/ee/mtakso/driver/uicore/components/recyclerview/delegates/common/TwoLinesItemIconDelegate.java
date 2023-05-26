package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoLinesItemIconDelegate.kt */
/* loaded from: classes5.dex */
public final class TwoLinesItemIconDelegate<T> extends TwoLinesItemDelegate<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<TwoLinesItemDelegate.Model<T>, Unit> f35135f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1<TwoLinesItemDelegate.Model<T>, Unit> f35136g;

    /* compiled from: TwoLinesItemIconDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends TwoLinesItemDelegate.ViewHolder {
        private final ImageView D;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R$id.indicatorIcon);
            Intrinsics.d(appCompatImageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.D = appCompatImageView;
        }

        public final ImageView X() {
            return this.D;
        }
    }

    public /* synthetic */ TwoLinesItemIconDelegate(Function1 function1, Function1 function12, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i8 & 2) != 0 ? new Function1<TwoLinesItemDelegate.Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemIconDelegate.1
            public final void b(TwoLinesItemDelegate.Model<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((TwoLinesItemDelegate.Model) obj);
                return Unit.f50853a;
            }
        } : function12);
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate, ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        if ((model instanceof TwoLinesItemDelegate.Model) && (((TwoLinesItemDelegate.Model) model).p() instanceof TwoLinesItemDelegate.Indicator.Icon)) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate, ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View v7 = inflater.inflate(e(), parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate, ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void g(TwoLinesItemDelegate.ViewHolder holder, TwoLinesItemDelegate.Model<T> model) {
        ViewHolder viewHolder;
        ImageView X;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        super.g(holder, model);
        TwoLinesItemDelegate.Indicator p8 = model.p();
        Intrinsics.d(p8, "null cannot be cast to non-null type ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.Indicator.Icon");
        TwoLinesItemDelegate.Indicator.Icon icon = (TwoLinesItemDelegate.Indicator.Icon) p8;
        if (holder instanceof ViewHolder) {
            viewHolder = (ViewHolder) holder;
        } else {
            viewHolder = null;
        }
        if (viewHolder != null && (X = viewHolder.X()) != null) {
            X.setImageResource(icon.a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TwoLinesItemIconDelegate(Function1<? super TwoLinesItemDelegate.Model<T>, Unit> onItemClick, Function1<? super TwoLinesItemDelegate.Model<T>, Unit> onInfoClick) {
        super(onItemClick, onInfoClick, R$layout.delegate_two_lines_icon_item, null, 8, null);
        Intrinsics.f(onItemClick, "onItemClick");
        Intrinsics.f(onInfoClick, "onInfoClick");
        this.f35135f = onItemClick;
        this.f35136g = onInfoClick;
    }
}
