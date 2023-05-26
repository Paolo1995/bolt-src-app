package ee.mtakso.driver.uicore.components.recyclerview.delegates.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoLinesItemTextDelegate.kt */
/* loaded from: classes5.dex */
public final class TwoLinesItemTextDelegate<T> extends TwoLinesItemDelegate<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<TwoLinesItemDelegate.Model<T>, Unit> f35154f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1<TwoLinesItemDelegate.Model<T>, Unit> f35155g;

    /* renamed from: h  reason: collision with root package name */
    private final Function1<TwoLinesItemDelegate.Model<T>, Unit> f35156h;

    /* compiled from: TwoLinesItemTextDelegate.kt */
    /* loaded from: classes5.dex */
    public static class ViewHolder extends TwoLinesItemDelegate.ViewHolder {
        private final TextView D;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R$id.indicatorText);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.D = textView;
        }

        public final TextView X() {
            return this.D;
        }
    }

    public /* synthetic */ TwoLinesItemTextDelegate(Function1 function1, Function1 function12, Function1 function13, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i8 & 2) != 0 ? new Function1<TwoLinesItemDelegate.Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemTextDelegate.1
            public final void b(TwoLinesItemDelegate.Model<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((TwoLinesItemDelegate.Model) obj);
                return Unit.f50853a;
            }
        } : function12, (i8 & 4) != 0 ? new Function1<TwoLinesItemDelegate.Model<T>, Unit>() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemTextDelegate.2
            public final void b(TwoLinesItemDelegate.Model<T> it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b((TwoLinesItemDelegate.Model) obj);
                return Unit.f50853a;
            }
        } : function13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(TwoLinesItemTextDelegate this$0, TwoLinesItemDelegate.Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f35156h.invoke(model);
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate, ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        if ((model instanceof TwoLinesItemDelegate.Model) && (((TwoLinesItemDelegate.Model) model).p() instanceof TwoLinesItemDelegate.Indicator.Label)) {
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
    public void g(TwoLinesItemDelegate.ViewHolder holder, final TwoLinesItemDelegate.Model<T> model) {
        ViewHolder viewHolder;
        TextView X;
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        super.g(holder, model);
        TwoLinesItemDelegate.Indicator p8 = model.p();
        Intrinsics.d(p8, "null cannot be cast to non-null type ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.Indicator.Label");
        TwoLinesItemDelegate.Indicator.Label label = (TwoLinesItemDelegate.Indicator.Label) p8;
        if (holder instanceof ViewHolder) {
            viewHolder = (ViewHolder) holder;
        } else {
            viewHolder = null;
        }
        if (viewHolder != null && (X = viewHolder.X()) != null) {
            Text a8 = label.a();
            Context context = X.getContext();
            Intrinsics.e(context, "context");
            X.setText(TextKt.a(a8, context));
            Integer b8 = label.b();
            if (b8 != null) {
                TextViewCompat.o(X, b8.intValue());
            }
            TextViewExtKt.i(X, label.c());
            X.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.recyclerview.delegates.common.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwoLinesItemTextDelegate.B(TwoLinesItemTextDelegate.this, model, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TwoLinesItemTextDelegate(Function1<? super TwoLinesItemDelegate.Model<T>, Unit> onItemClick, Function1<? super TwoLinesItemDelegate.Model<T>, Unit> onInfoClick, Function1<? super TwoLinesItemDelegate.Model<T>, Unit> onLabelClick) {
        super(onItemClick, onInfoClick, R$layout.delegate_two_lines_text_item, null, 8, null);
        Intrinsics.f(onItemClick, "onItemClick");
        Intrinsics.f(onInfoClick, "onInfoClick");
        Intrinsics.f(onLabelClick, "onLabelClick");
        this.f35154f = onItemClick;
        this.f35155g = onInfoClick;
        this.f35156h = onLabelClick;
    }
}
