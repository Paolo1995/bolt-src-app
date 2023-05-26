package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder;
import com.hannesdorfmann.adapterdelegates4.dsl.DslViewBindingListAdapterDelegate;
import eu.bolt.client.design.input.DesignDateInputView;
import eu.bolt.verification.sdk.internal.q3;
import eu.bolt.verification.sdk.internal.w7;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class q3 {

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function3<w7, List<? extends w7>, Integer, Boolean> {
        public a() {
            super(3);
        }

        public final Boolean b(w7 w7Var, List<? extends w7> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(w7Var instanceof w7.d);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(w7 w7Var, List<? extends w7> list, Integer num) {
            return b(w7Var, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f44615f = new b();

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
    static final class c extends Lambda implements Function2<LayoutInflater, ViewGroup, va> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f44616f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final va s(LayoutInflater layoutInflater, ViewGroup parent) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(parent, "parent");
            va b8 = va.b(layoutInflater, parent, false);
            Intrinsics.e(b8, "inflate(layoutInflater, parent, false)");
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<w7.d, va>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Function2<String, Date, Unit> f44617f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ pr f44618g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.d, va> f44619f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ pr f44620g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AdapterDelegateViewBindingViewHolder<w7.d, va> adapterDelegateViewBindingViewHolder, pr prVar) {
                super(1);
                this.f44619f = adapterDelegateViewBindingViewHolder;
                this.f44620g = prVar;
            }

            public final void b(List<? extends Object> it) {
                Intrinsics.f(it, "it");
                Long c8 = this.f44619f.R().c();
                if (c8 != null) {
                    this.f44619f.P().getRoot().setDate(new Date(c8.longValue()));
                }
                Long d8 = this.f44619f.R().d();
                if (d8 != null) {
                    this.f44619f.P().getRoot().setDate(new Date(d8.longValue()));
                }
                this.f44619f.P().getRoot().setYearRange(this.f44620g);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                b(list);
                return Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super String, ? super Date, Unit> function2, pr prVar) {
            super(1);
            this.f44617f = function2;
            this.f44618g = prVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function2 onDateChanged, AdapterDelegateViewBindingViewHolder this_adapterDelegateViewBinding, Date date) {
            Intrinsics.f(onDateChanged, "$onDateChanged");
            Intrinsics.f(this_adapterDelegateViewBinding, "$this_adapterDelegateViewBinding");
            onDateChanged.s(((w7.d) this_adapterDelegateViewBinding.R()).a(), date);
        }

        public final void c(final AdapterDelegateViewBindingViewHolder<w7.d, va> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            DesignDateInputView root = adapterDelegateViewBinding.P().getRoot();
            final Function2<String, Date, Unit> function2 = this.f44617f;
            root.setListener(new DesignDateInputView.b() { // from class: eu.bolt.verification.sdk.internal.kv
                @Override // eu.bolt.client.design.input.DesignDateInputView.b
                public final void a(Date date) {
                    q3.d.d(Function2.this, adapterDelegateViewBinding, date);
                }
            });
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding, this.f44618g));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<w7.d, va> adapterDelegateViewBindingViewHolder) {
            c(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    public static final AdapterDelegate<List<w7>> a(Function2<? super String, ? super Date, Unit> onDateChanged, pr prVar) {
        Intrinsics.f(onDateChanged, "onDateChanged");
        return new DslViewBindingListAdapterDelegate(c.f44616f, new a(), new d(onDateChanged, prVar), b.f44615f);
    }
}
