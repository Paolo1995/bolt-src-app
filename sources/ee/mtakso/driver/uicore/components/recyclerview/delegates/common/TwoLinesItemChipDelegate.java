package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.R$style;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoLinesItemChipDelegate.kt */
/* loaded from: classes5.dex */
public final class TwoLinesItemChipDelegate<T> extends TwoLinesItemDelegate<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<TwoLinesItemDelegate.Model<T>, Unit> f35085f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1<TwoLinesItemDelegate.Model<T>, Unit> f35086g;

    /* compiled from: TwoLinesItemChipDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends TwoLinesItemDelegate.ViewHolder {
        private final Chip D;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            Chip chip = (Chip) itemView.findViewById(R$id.indicatorChip);
            Intrinsics.d(chip, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            this.D = chip;
        }

        public final Chip X() {
            return this.D;
        }
    }

    public /* synthetic */ TwoLinesItemChipDelegate(Function1 function1, Function1 function12, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i8 & 2) != 0 ? new Function1<TwoLinesItemDelegate.Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemChipDelegate.1
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
        if ((model instanceof TwoLinesItemDelegate.Model) && (((TwoLinesItemDelegate.Model) model).p() instanceof TwoLinesItemDelegate.Indicator.Chip)) {
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
        Chip X;
        Drawable drawable;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        super.g(holder, model);
        TwoLinesItemDelegate.Indicator p8 = model.p();
        Intrinsics.d(p8, "null cannot be cast to non-null type ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.Indicator.Chip");
        TwoLinesItemDelegate.Indicator.Chip chip = (TwoLinesItemDelegate.Indicator.Chip) p8;
        ColorStateList colorStateList = null;
        if (holder instanceof ViewHolder) {
            viewHolder = (ViewHolder) holder;
        } else {
            viewHolder = null;
        }
        if (viewHolder != null && (X = viewHolder.X()) != null) {
            X.setTextAppearanceResource(R$style.smallChipTextAppearance);
            X.setText(chip.d());
            TextViewExtKt.i(X, chip.e());
            Color a8 = chip.a();
            Context context = X.getContext();
            Intrinsics.e(context, "context");
            X.setChipBackgroundColor(ColorStateList.valueOf(ColorKt.a(a8, context)));
            Integer b8 = chip.b();
            if (b8 != null) {
                drawable = ContextCompat.getDrawable(X.getContext(), b8.intValue());
            } else {
                drawable = null;
            }
            X.setChipIcon(drawable);
            Color c8 = chip.c();
            if (c8 != null) {
                Context context2 = X.getContext();
                Intrinsics.e(context2, "context");
                colorStateList = ColorStateList.valueOf(ColorKt.a(c8, context2));
            }
            X.setChipIconTint(colorStateList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TwoLinesItemChipDelegate(Function1<? super TwoLinesItemDelegate.Model<T>, Unit> onItemClick, Function1<? super TwoLinesItemDelegate.Model<T>, Unit> onInfoClick) {
        super(onItemClick, onInfoClick, R$layout.delegate_menu_chip_item, null, 8, null);
        Intrinsics.f(onItemClick, "onItemClick");
        Intrinsics.f(onInfoClick, "onInfoClick");
        this.f35085f = onItemClick;
        this.f35086g = onInfoClick;
    }
}
