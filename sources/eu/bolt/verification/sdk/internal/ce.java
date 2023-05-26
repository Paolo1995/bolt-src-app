package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.android.gms.common.api.Api;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder;
import com.hannesdorfmann.adapterdelegates4.dsl.DslViewBindingListAdapterDelegate;
import eu.bolt.android.engine.html.view.OnUrlClickListener;
import eu.bolt.client.design.listitem.DesignListItemView;
import eu.bolt.verification.sdk.internal.ce;
import eu.bolt.verification.sdk.internal.w7;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ce {

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function3<w7, List<? extends w7>, Integer, Boolean> {
        public a() {
            super(3);
        }

        public final Boolean b(w7 w7Var, List<? extends w7> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(w7Var instanceof w7.h);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(w7 w7Var, List<? extends w7> list, Integer num) {
            return b(w7Var, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f42496f = new b();

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
    static final class c extends Lambda implements Function2<LayoutInflater, ViewGroup, ya> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f42497f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final ya s(LayoutInflater layoutInflater, ViewGroup parent) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(parent, "parent");
            ya b8 = ya.b(layoutInflater, parent, false);
            Intrinsics.e(b8, "inflate(layoutInflater, parent, false)");
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<w7.h, ya>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Function2<String, List<cm>, Unit> f42498f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.h, ya> f42499f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ Function2<String, List<cm>, Unit> f42500g;

            /* renamed from: eu.bolt.verification.sdk.internal.ce$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public /* synthetic */ class C0041a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f42501a;

                static {
                    int[] iArr = new int[w7.i.values().length];
                    try {
                        iArr[w7.i.START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[w7.i.CENTER.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f42501a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(AdapterDelegateViewBindingViewHolder<w7.h, ya> adapterDelegateViewBindingViewHolder, Function2<? super String, ? super List<cm>, Unit> function2) {
                super(1);
                this.f42499f = adapterDelegateViewBindingViewHolder;
                this.f42500g = function2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean d(Function2 onClick, AdapterDelegateViewBindingViewHolder this_adapterDelegateViewBinding, String url) {
                Intrinsics.f(onClick, "$onClick");
                Intrinsics.f(this_adapterDelegateViewBinding, "$this_adapterDelegateViewBinding");
                Intrinsics.f(url, "url");
                onClick.s(url, ((w7.h) this_adapterDelegateViewBinding.R()).g());
                return true;
            }

            public final void c(List<? extends Object> it) {
                Intrinsics.f(it, "it");
                DesignListItemView root = this.f42499f.P().getRoot();
                final AdapterDelegateViewBindingViewHolder<w7.h, ya> adapterDelegateViewBindingViewHolder = this.f42499f;
                final Function2<String, List<cm>, Unit> function2 = this.f42500g;
                root.setBottomPaddingEnabled(false);
                int i8 = C0041a.f42501a[adapterDelegateViewBindingViewHolder.R().f().ordinal()];
                if (i8 == 1) {
                    root.H();
                } else if (i8 == 2) {
                    root.R();
                }
                root.setTitleTextModel(adapterDelegateViewBindingViewHolder.R().e());
                root.setIconImageModel(adapterDelegateViewBindingViewHolder.R().d());
                root.setIconMarginDp(adapterDelegateViewBindingViewHolder.R().c());
                if (!adapterDelegateViewBindingViewHolder.R().g().isEmpty()) {
                    root.J(new OnUrlClickListener() { // from class: eu.bolt.verification.sdk.internal.tm
                        @Override // eu.bolt.android.engine.html.view.OnUrlClickListener
                        public final boolean a(String str) {
                            boolean d8;
                            d8 = ce.d.a.d(Function2.this, adapterDelegateViewBindingViewHolder, str);
                            return d8;
                        }
                    });
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                c(list);
                return Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super String, ? super List<cm>, Unit> function2) {
            super(1);
            this.f42498f = function2;
        }

        public final void b(AdapterDelegateViewBindingViewHolder<w7.h, ya> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            DesignListItemView root = adapterDelegateViewBinding.P().getRoot();
            root.setIconVerticalAlignment(DesignListItemView.d.TOP);
            root.setTitleMaxLines(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding, this.f42498f));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<w7.h, ya> adapterDelegateViewBindingViewHolder) {
            b(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    public static final AdapterDelegate<List<w7>> a(Function2<? super String, ? super List<cm>, Unit> onClick) {
        Intrinsics.f(onClick, "onClick");
        return new DslViewBindingListAdapterDelegate(c.f42497f, new a(), new d(onClick), b.f42496f);
    }
}
