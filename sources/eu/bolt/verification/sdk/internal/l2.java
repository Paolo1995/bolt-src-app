package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter;
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder;
import com.hannesdorfmann.adapterdelegates4.dsl.DslViewBindingListAdapterDelegate;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.sdk.internal.l2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class l2 extends AsyncListDifferDelegationAdapter<sb> {

    /* renamed from: f  reason: collision with root package name */
    private static final a f43933f = new a(null);

    /* loaded from: classes5.dex */
    private static final class a extends DiffUtil.ItemCallback<sb> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: d */
        public boolean a(sb oldItem, sb newItem) {
            Intrinsics.f(oldItem, "oldItem");
            Intrinsics.f(newItem, "newItem");
            return Intrinsics.a(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: e */
        public boolean b(sb oldItem, sb newItem) {
            Intrinsics.f(oldItem, "oldItem");
            Intrinsics.f(newItem, "newItem");
            return Intrinsics.a(oldItem.a(), newItem.a());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function3<sb, List<? extends sb>, Integer, Boolean> {
        public b() {
            super(3);
        }

        public final Boolean b(sb sbVar, List<? extends sb> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(sbVar instanceof j2);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(sb sbVar, List<? extends sb> list, Integer num) {
            return b(sbVar, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f43934f = new c();

        public c() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function2<LayoutInflater, ViewGroup, n2> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f43935f = new d();

        d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final n2 s(LayoutInflater layoutInflater, ViewGroup root) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(root, "root");
            n2 b8 = n2.b(layoutInflater, root, false);
            Intrinsics.e(b8, "inflate(layoutInflater, root, false)");
            return b8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<j2, n2>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Function1<j2, Unit> f43936f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f43937g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<j2, n2> f43938f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ boolean f43939g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AdapterDelegateViewBindingViewHolder<j2, n2> adapterDelegateViewBindingViewHolder, boolean z7) {
                super(1);
                this.f43938f = adapterDelegateViewBindingViewHolder;
                this.f43939g = z7;
            }

            public final void b(List<? extends Object> it) {
                Intrinsics.f(it, "it");
                this.f43938f.P().f44238c.setText(this.f43938f.R().d());
                this.f43938f.P().f44239d.setText(this.f43938f.R().c());
                this.f43938f.P().f44237b.setImageResource(this.f43938f.R().e());
                DesignTextView designTextView = this.f43938f.P().f44239d;
                Intrinsics.e(designTextView, "binding.phonePrefix");
                designTextView.setVisibility(this.f43939g ? 0 : 8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                b(list);
                return Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super j2, Unit> function1, boolean z7) {
            super(1);
            this.f43936f = function1;
            this.f43937g = z7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function1 itemClickListener, AdapterDelegateViewBindingViewHolder this_adapterDelegateViewBinding, View view) {
            Intrinsics.f(itemClickListener, "$itemClickListener");
            Intrinsics.f(this_adapterDelegateViewBinding, "$this_adapterDelegateViewBinding");
            itemClickListener.invoke(this_adapterDelegateViewBinding.R());
        }

        public final void c(final AdapterDelegateViewBindingViewHolder<j2, n2> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            ConstraintLayout root = adapterDelegateViewBinding.P().getRoot();
            final Function1<j2, Unit> function1 = this.f43936f;
            root.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.gu
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l2.e.d(Function1.this, adapterDelegateViewBinding, view);
                }
            });
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding, this.f43937g));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<j2, n2> adapterDelegateViewBindingViewHolder) {
            c(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends Lambda implements Function3<sb, List<? extends sb>, Integer, Boolean> {
        public f() {
            super(3);
        }

        public final Boolean b(sb sbVar, List<? extends sb> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(sbVar instanceof x5);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(sb sbVar, List<? extends sb> list, Integer num) {
            return b(sbVar, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final g f43940f = new g();

        public g() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function2<LayoutInflater, ViewGroup, w5> {

        /* renamed from: f  reason: collision with root package name */
        public static final h f43941f = new h();

        h() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final w5 s(LayoutInflater layoutInflater, ViewGroup root) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(root, "root");
            w5 a8 = w5.a(layoutInflater, root, false);
            Intrinsics.e(a8, "inflate(layoutInflater, root, false)");
            return a8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class i extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<x5, w5>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final i f43942f = new i();

        i() {
            super(1);
        }

        public final void b(AdapterDelegateViewBindingViewHolder<x5, w5> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<x5, w5> adapterDelegateViewBindingViewHolder) {
            b(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class j extends Lambda implements Function3<sb, List<? extends sb>, Integer, Boolean> {
        public j() {
            super(3);
        }

        public final Boolean b(sb sbVar, List<? extends sb> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(sbVar instanceof fa);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(sb sbVar, List<? extends sb> list, Integer num) {
            return b(sbVar, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class k extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final k f43943f = new k();

        public k() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class l extends Lambda implements Function2<LayoutInflater, ViewGroup, z2> {

        /* renamed from: f  reason: collision with root package name */
        public static final l f43944f = new l();

        l() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final z2 s(LayoutInflater layoutInflater, ViewGroup root) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(root, "root");
            z2 b8 = z2.b(layoutInflater, root, false);
            Intrinsics.e(b8, "inflate(layoutInflater, root, false)");
            return b8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class m extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<fa, z2>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final m f43945f = new m();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<fa, z2> f43946f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AdapterDelegateViewBindingViewHolder<fa, z2> adapterDelegateViewBindingViewHolder) {
                super(1);
                this.f43946f = adapterDelegateViewBindingViewHolder;
            }

            public final void b(List<? extends Object> it) {
                Intrinsics.f(it, "it");
                this.f43946f.P().getRoot().setText(this.f43946f.R().b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                b(list);
                return Unit.f50853a;
            }
        }

        m() {
            super(1);
        }

        public final void b(AdapterDelegateViewBindingViewHolder<fa, z2> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<fa, z2> adapterDelegateViewBindingViewHolder) {
            b(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(Function1<? super j2, Unit> itemClickListener, boolean z7) {
        super(f43933f);
        Intrinsics.f(itemClickListener, "itemClickListener");
        this.f17747d.b(T()).b(S(itemClickListener, z7)).b(R());
    }

    private final AdapterDelegate<List<sb>> R() {
        return new DslViewBindingListAdapterDelegate(h.f43941f, new f(), i.f43942f, g.f43940f);
    }

    private final AdapterDelegate<List<sb>> S(Function1<? super j2, Unit> function1, boolean z7) {
        return new DslViewBindingListAdapterDelegate(d.f43935f, new b(), new e(function1, z7), c.f43934f);
    }

    private final AdapterDelegate<List<sb>> T() {
        return new DslViewBindingListAdapterDelegate(l.f43944f, new j(), m.f43945f, k.f43943f);
    }
}
