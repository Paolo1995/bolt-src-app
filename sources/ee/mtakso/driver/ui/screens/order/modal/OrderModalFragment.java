package ee.mtakso.driver.ui.screens.order.modal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.modal.ModalAction;
import ee.mtakso.driver.network.client.order.modal.ModalImage;
import ee.mtakso.driver.network.client.order.modal.ModalItem;
import ee.mtakso.driver.network.client.order.modal.ModalWithList;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalFragment;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalItemDelegate;
import ee.mtakso.driver.ui.utils.ThemedImageKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.android.engine.html.HtmlEngine;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderModalFragment.kt */
/* loaded from: classes3.dex */
public final class OrderModalFragment extends BazeFragment {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f31506r = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private final HtmlEngine f31507m;

    /* renamed from: n  reason: collision with root package name */
    private final DeeplinkDelegate f31508n;

    /* renamed from: o  reason: collision with root package name */
    private final DiffAdapter f31509o;

    /* renamed from: p  reason: collision with root package name */
    private final int f31510p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f31511q;

    /* compiled from: OrderModalFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(ModalWithList modal) {
            Intrinsics.f(modal, "modal");
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_modal", modal);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OrderModalFragment(BaseUiDependencies deps, HtmlEngine htmlEngine, DeeplinkDelegate deeplinkDelegate) {
        super(deps, R.layout.fragment_order_modal, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(deeplinkDelegate, "deeplinkDelegate");
        this.f31511q = new LinkedHashMap();
        this.f31507m = htmlEngine;
        this.f31508n = deeplinkDelegate;
        this.f31509o = new DiffAdapter().P(new OrderModalItemDelegate(new OrderModalFragment$adapter$1(this)));
        this.f31510p = 2132017818;
    }

    private final ModalWithList N() {
        ModalWithList modalWithList = (ModalWithList) requireArguments().getParcelable("arg_modal");
        if (modalWithList != null) {
            return modalWithList;
        }
        throw new IllegalArgumentException();
    }

    private final Navigator O() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.d(requireActivity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) requireActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(OrderModalItemDelegate.Model<ModalItem.Action> model) {
        Q(model.p().a());
    }

    private final void Q(ModalAction modalAction) {
        boolean z7;
        if (modalAction instanceof ModalAction.DeepLink) {
            O().c();
            DeeplinkDelegate.f(this.f31508n, ((ModalAction.DeepLink) modalAction).a(), null, 2, null);
            return;
        }
        if (modalAction instanceof ModalAction.Text) {
            z7 = true;
        } else {
            z7 = modalAction instanceof ModalAction.Empty;
        }
        if (z7) {
            O().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(OrderModalFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.O().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(OrderModalFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q(this$0.N().d());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f31511q.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f31510p);
    }

    public View L(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f31511q;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Unit unit;
        CharSequence charSequence;
        boolean z7;
        List L;
        int v7;
        Text.Value value;
        ModalImage.Variant a8;
        Image a9;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.H9;
        ((RecyclerView) L(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) L(i8)).setAdapter(this.f31509o);
        ModalImage b8 = N().b();
        if (b8 != null && (a8 = b8.a()) != null && (a9 = ThemedImageKt.a(a8)) != null) {
            ImageView image = (ImageView) L(R.id.S5);
            Intrinsics.e(image, "image");
            ImageKt.b(a9, image, null, 2, null);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((ImageView) L(R.id.S5)).setImageDrawable(null);
        }
        ((TextView) L(R.id.cc)).setText(this.f31507m.a(N().f()));
        TextView textView = (TextView) L(R.id.f19830k7);
        String a10 = N().a();
        if (a10 != null) {
            charSequence = this.f31507m.a(a10);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        int i9 = R.id.secondaryAction;
        RoundButton secondaryAction = (RoundButton) L(i9);
        Intrinsics.e(secondaryAction, "secondaryAction");
        String e8 = N().e();
        int i10 = 0;
        if (e8 != null && e8.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        ViewExtKt.d(secondaryAction, !z7, 0, 2, null);
        ((RoundButton) L(i9)).setText(N().e());
        DiffAdapter diffAdapter = this.f31509o;
        L = CollectionsKt___CollectionsJvmKt.L(N().c(), ModalItem.Action.class);
        v7 = CollectionsKt__IterablesKt.v(L, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Object obj : L) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            ModalItem.Action action = (ModalItem.Action) obj;
            String str = "item_" + i10;
            Image.Url url = new Image.Url(action.d());
            Text.Value value2 = new Text.Value(action.c());
            String b9 = action.b();
            if (b9 != null) {
                value = new Text.Value(b9);
            } else {
                value = null;
            }
            arrayList.add(new OrderModalItemDelegate.Model(str, url, value2, value, action));
            i10 = i11;
        }
        DiffAdapter.V(diffAdapter, arrayList, null, 2, null);
        ((ImageView) L(R.id.f19838z2)).setOnClickListener(new View.OnClickListener() { // from class: v4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderModalFragment.R(OrderModalFragment.this, view2);
            }
        });
        ((RoundButton) L(R.id.secondaryAction)).setOnClickListener(new View.OnClickListener() { // from class: v4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderModalFragment.S(OrderModalFragment.this, view2);
            }
        });
    }
}
