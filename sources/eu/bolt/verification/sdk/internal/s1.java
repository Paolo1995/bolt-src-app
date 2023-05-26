package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder;
import com.hannesdorfmann.adapterdelegates4.dsl.DslViewBindingListAdapterDelegate;
import eu.bolt.client.design.listitem.DesignListItemView;
import eu.bolt.verification.sdk.internal.s1;
import eu.bolt.verification.sdk.internal.w7;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class s1 {

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function3<w7, List<? extends w7>, Integer, Boolean> {
        public a() {
            super(3);
        }

        public final Boolean b(w7 w7Var, List<? extends w7> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(w7Var instanceof w7.a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(w7 w7Var, List<? extends w7> list, Integer num) {
            return b(w7Var, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f44925f = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final LayoutInflater invoke(ViewGroup parent) {
            Intrinsics.f(parent, "parent");
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            Intrinsics.e(from, "from(parent.context)");
            return from;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function2<LayoutInflater, ViewGroup, ta> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f44926f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final ta s(LayoutInflater layoutInflater, ViewGroup parent) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(parent, "parent");
            ta b8 = ta.b(layoutInflater, parent, false);
            Intrinsics.e(b8, "inflate(layoutInflater, parent, false)");
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<w7.a, ta>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Function1<ud, Unit> f44927f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.a, ta> f44928f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AdapterDelegateViewBindingViewHolder<w7.a, ta> adapterDelegateViewBindingViewHolder) {
                super(1);
                this.f44928f = adapterDelegateViewBindingViewHolder;
            }

            public final void b(List<? extends Object> it) {
                Intrinsics.f(it, "it");
                DesignListItemView root = this.f44928f.P().getRoot();
                AdapterDelegateViewBindingViewHolder<w7.a, ta> adapterDelegateViewBindingViewHolder = this.f44928f;
                if (adapterDelegateViewBindingViewHolder.R().d().c()) {
                    root.setEndCheckBoxVisible(false);
                    root.setStartCheckBoxVisible(true);
                    root.setCheckBoxRound(false);
                } else {
                    root.setEndCheckBoxVisible(true);
                    root.setStartCheckBoxVisible(false);
                    root.setCheckBoxRound(true);
                }
                root.setSelected(adapterDelegateViewBindingViewHolder.R().e());
                root.setTitleTextModel(adapterDelegateViewBindingViewHolder.R().g());
                root.setSubtitleTextModel(adapterDelegateViewBindingViewHolder.R().f());
                root.setIconImageModel(adapterDelegateViewBindingViewHolder.R().c());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                b(list);
                return Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super ud, Unit> function1) {
            super(1);
            this.f44927f = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function1 onItemSelected, AdapterDelegateViewBindingViewHolder this_adapterDelegateViewBinding, View view) {
            Intrinsics.f(onItemSelected, "$onItemSelected");
            Intrinsics.f(this_adapterDelegateViewBinding, "$this_adapterDelegateViewBinding");
            onItemSelected.invoke(((w7.a) this_adapterDelegateViewBinding.R()).d());
        }

        public final void c(final AdapterDelegateViewBindingViewHolder<w7.a, ta> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            DesignListItemView root = adapterDelegateViewBinding.P().getRoot();
            final Function1<ud, Unit> function1 = this.f44927f;
            root.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.bw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s1.d.d(Function1.this, adapterDelegateViewBinding, view);
                }
            });
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<w7.a, ta> adapterDelegateViewBindingViewHolder) {
            c(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    public static final AdapterDelegate<List<w7>> a(Function1<? super ud, Unit> onItemSelected) {
        Intrinsics.f(onItemSelected, "onItemSelected");
        return new DslViewBindingListAdapterDelegate(c.f44926f, new a(), new d(onItemSelected), b.f44925f);
    }
}
