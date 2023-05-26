package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder;
import com.hannesdorfmann.adapterdelegates4.dsl.DslViewBindingListAdapterDelegate;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.core.rib.camera.view.CameraOverlayView;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.w7;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class dc {

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function3<w7, List<? extends w7>, Integer, Boolean> {
        public a() {
            super(3);
        }

        public final Boolean b(w7 w7Var, List<? extends w7> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(w7Var instanceof w7.g);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(w7 w7Var, List<? extends w7> list, Integer num) {
            return b(w7Var, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f42632f = new b();

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
    static final class c extends Lambda implements Function2<LayoutInflater, ViewGroup, xa> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f42633f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final xa s(LayoutInflater layoutInflater, ViewGroup parent) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(parent, "parent");
            xa b8 = xa.b(layoutInflater, parent, false);
            Intrinsics.e(b8, "inflate(layoutInflater, parent, false)");
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<w7.g, xa>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final d f42634f = new d();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.g, xa> f42635f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: eu.bolt.verification.sdk.internal.dc$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0044a extends Lambda implements Function0<Unit> {

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.g, xa> f42636f;

                /* renamed from: eu.bolt.verification.sdk.internal.dc$d$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public /* synthetic */ class C0045a {

                    /* renamed from: a  reason: collision with root package name */
                    public static final /* synthetic */ int[] f42637a;

                    static {
                        int[] iArr = new int[hh.values().length];
                        try {
                            iArr[hh.RECTANGLE.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[hh.OVAL.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        f42637a = iArr;
                    }
                }

                /* renamed from: eu.bolt.verification.sdk.internal.dc$d$a$a$b */
                /* loaded from: classes5.dex */
                public static final class b implements zd {

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.g, xa> f42638f;

                    b(AdapterDelegateViewBindingViewHolder<w7.g, xa> adapterDelegateViewBindingViewHolder) {
                        this.f42638f = adapterDelegateViewBindingViewHolder;
                    }

                    @Override // eu.bolt.verification.sdk.internal.zd
                    public DesignImageView getOverlayImage() {
                        return null;
                    }

                    @Override // eu.bolt.verification.sdk.internal.zd
                    public CameraOverlayView getOverlayView() {
                        CameraOverlayView cameraOverlayView = this.f42638f.P().f45640b;
                        Intrinsics.e(cameraOverlayView, "binding.cameraOverlayView");
                        return cameraOverlayView;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0044a(AdapterDelegateViewBindingViewHolder<w7.g, xa> adapterDelegateViewBindingViewHolder) {
                    super(0);
                    this.f42636f = adapterDelegateViewBindingViewHolder;
                }

                public final void b() {
                    b bVar = new b(this.f42636f);
                    int b8 = f2.b(this.f42636f.Q(), 17170443);
                    Context context = this.f42636f.P().getRoot().getContext();
                    Intrinsics.e(context, "binding.root.context");
                    xd xdVar = new xd(context, true, false, bVar);
                    Context context2 = this.f42636f.P().getRoot().getContext();
                    Intrinsics.e(context2, "binding.root.context");
                    mf mfVar = new mf(context2, true, false, bVar);
                    int i8 = C0045a.f42637a[this.f42636f.R().c().b().ordinal()];
                    if (i8 == 1) {
                        mfVar.b(this.f42636f.R().c().a(), Integer.valueOf(b8));
                    } else if (i8 != 2) {
                    } else {
                        xdVar.b(this.f42636f.R().c().a(), Integer.valueOf(b8));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AdapterDelegateViewBindingViewHolder<w7.g, xa> adapterDelegateViewBindingViewHolder) {
                super(1);
                this.f42635f = adapterDelegateViewBindingViewHolder;
            }

            public final void b(List<? extends Object> it) {
                aa.f e8;
                Intrinsics.f(it, "it");
                ViewGroup.LayoutParams layoutParams = this.f42635f.P().getRoot().getLayoutParams();
                Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                aa d8 = this.f42635f.R().d();
                aa.g gVar = d8 instanceof aa.g ? (aa.g) d8 : null;
                if (gVar != null && (e8 = gVar.e()) != null) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (e8.a() * this.f42635f.Q().getResources().getDisplayMetrics().density);
                }
                DesignImageView designImageView = this.f42635f.P().f45641c;
                Intrinsics.e(designImageView, "binding.image");
                uq.m(designImageView, new C0044a(this.f42635f));
                DesignImageView designImageView2 = this.f42635f.P().f45641c;
                Intrinsics.e(designImageView2, "binding.image");
                DesignImageView.K(designImageView2, this.f42635f.R().d(), false, null, 4, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                b(list);
                return Unit.f50853a;
            }
        }

        d() {
            super(1);
        }

        public final void b(AdapterDelegateViewBindingViewHolder<w7.g, xa> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<w7.g, xa> adapterDelegateViewBindingViewHolder) {
            b(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    public static final AdapterDelegate<List<w7>> a() {
        return new DslViewBindingListAdapterDelegate(c.f42633f, new a(), d.f42634f, b.f42632f);
    }
}
