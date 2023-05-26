package ee.mtakso.driver.ui.screens.navigator_chooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.ExternalNavigator;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserAdapter;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserDiffCallback;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorChooserAdapter.kt */
/* loaded from: classes3.dex */
public final class NavigatorChooserAdapter extends RecyclerView.Adapter<NavigatorChooserViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    private final Function1<NavigatorItem, Unit> f30902d;

    /* renamed from: e  reason: collision with root package name */
    private final List<NavigatorItem> f30903e;

    /* renamed from: f  reason: collision with root package name */
    private final CompositeDisposable f30904f;

    /* compiled from: NavigatorChooserAdapter.kt */
    /* loaded from: classes3.dex */
    public final class NavigatorChooserViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f30905u;

        /* renamed from: v  reason: collision with root package name */
        private final Chip f30906v;

        /* renamed from: w  reason: collision with root package name */
        private final AppCompatRadioButton f30907w;

        /* renamed from: x  reason: collision with root package name */
        final /* synthetic */ NavigatorChooserAdapter f30908x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigatorChooserViewHolder(NavigatorChooserAdapter navigatorChooserAdapter, View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            this.f30908x = navigatorChooserAdapter;
            this.f30905u = (TextView) itemView.findViewById(R.id.navigatorChooserListItemTitle);
            this.f30906v = (Chip) itemView.findViewById(R.id.navigatorChooserListItemRecommendBadge);
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) itemView.findViewById(R.id.navigatorChooserListItemRadioButton);
            this.f30907w = appCompatRadioButton;
            itemView.setClickable(true);
            itemView.setFocusable(true);
            appCompatRadioButton.setClickable(false);
            appCompatRadioButton.setFocusable(false);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: m4.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NavigatorChooserAdapter.NavigatorChooserViewHolder.P(NavigatorChooserAdapter.NavigatorChooserViewHolder.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void P(NavigatorChooserViewHolder this$0, View view) {
            Intrinsics.f(this$0, "this$0");
            this$0.S();
        }

        private final void S() {
            this.f30908x.f30902d.invoke(this.f30908x.f30903e.get(k()));
        }

        public final void Q(NavigatorItem item) {
            Intrinsics.f(item, "item");
            TextView textView = this.f30905u;
            ExternalNavigator c8 = item.c();
            Context context = this.f30905u.getContext();
            Intrinsics.e(context, "titleView.context");
            textView.setText(c8.a(context));
            Chip recommendedBadgeView = this.f30906v;
            Intrinsics.e(recommendedBadgeView, "recommendedBadgeView");
            ViewExtKt.e(recommendedBadgeView, item.c().i(), 0, 2, null);
            this.f30907w.setChecked(item.d());
        }

        public final AppCompatRadioButton R() {
            return this.f30907w;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NavigatorChooserAdapter(Function1<? super NavigatorItem, Unit> onItemClickListener) {
        Intrinsics.f(onItemClickListener, "onItemClickListener");
        this.f30902d = onItemClickListener;
        this.f30903e = new ArrayList();
        this.f30904f = new CompositeDisposable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiffUtil.DiffResult X(NavigatorChooserAdapter this$0, List newItems) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(newItems, "$newItems");
        return DiffUtil.c(new NavigatorChooserDiffCallback(this$0.f30903e, newItems), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: T */
    public void E(NavigatorChooserViewHolder holder, int i8) {
        Intrinsics.f(holder, "holder");
        holder.Q(this.f30903e.get(i8));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: U */
    public void F(NavigatorChooserViewHolder holder, int i8, List<Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        ArrayList<NavigatorChooserDiffCallback.Payload> arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof NavigatorChooserDiffCallback.Payload) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            E(holder, i8);
            return;
        }
        for (NavigatorChooserDiffCallback.Payload payload : arrayList) {
            Boolean a8 = payload.a();
            if (a8 != null) {
                holder.R().setChecked(a8.booleanValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: V */
    public NavigatorChooserViewHolder G(ViewGroup parent, int i8) {
        Intrinsics.f(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selector, parent, false);
        Intrinsics.e(view, "view");
        return new NavigatorChooserViewHolder(this, view);
    }

    public final void W(final List<NavigatorItem> newItems) {
        Intrinsics.f(newItems, "newItems");
        CompositeDisposable compositeDisposable = this.f30904f;
        Single z7 = Single.u(new Callable() { // from class: m4.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DiffUtil.DiffResult X;
                X = NavigatorChooserAdapter.X(NavigatorChooserAdapter.this, newItems);
                return X;
            }
        }).K(Schedulers.c()).z(AndroidSchedulers.a());
        final Function1<DiffUtil.DiffResult, Unit> function1 = new Function1<DiffUtil.DiffResult, Unit>() { // from class: ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserAdapter$setItems$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(DiffUtil.DiffResult diffResult) {
                NavigatorChooserAdapter.this.f30903e.clear();
                NavigatorChooserAdapter.this.f30903e.addAll(newItems);
                diffResult.c(NavigatorChooserAdapter.this);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DiffUtil.DiffResult diffResult) {
                b(diffResult);
                return Unit.f50853a;
            }
        };
        compositeDisposable.b(z7.H(new Consumer() { // from class: m4.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NavigatorChooserAdapter.Y(Function1.this, obj);
            }
        }));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f30903e.size();
    }
}
