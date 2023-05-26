package eu.bolt.verification.sdk.internal;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder;
import com.hannesdorfmann.adapterdelegates4.dsl.DslViewBindingListAdapterDelegate;
import eu.bolt.verification.sdk.internal.r9;
import eu.bolt.verification.sdk.internal.v9;
import eu.bolt.verification.sdk.internal.w7;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class r9 {

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function3<w7, List<? extends w7>, Integer, Boolean> {
        public a() {
            super(3);
        }

        public final Boolean b(w7 w7Var, List<? extends w7> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(w7Var instanceof w7.f);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(w7 w7Var, List<? extends w7> list, Integer num) {
            return b(w7Var, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f44799f = new b();

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
    static final class c extends Lambda implements Function2<LayoutInflater, ViewGroup, wa> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f44800f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final wa s(LayoutInflater layoutInflater, ViewGroup parent) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(parent, "parent");
            wa b8 = wa.b(layoutInflater, parent, false);
            Intrinsics.e(b8, "inflate(layoutInflater, parent, false)");
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<w7.f, wa>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Function2<aa, Integer, Unit> f44801f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.f, wa> f44802f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ Function2<aa, Integer, Unit> f44803g;

            /* renamed from: eu.bolt.verification.sdk.internal.r9$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0085a extends v9.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.f, wa> f44804a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Function2<aa, Integer, Unit> f44805b;

                /* JADX WARN: Multi-variable type inference failed */
                C0085a(AdapterDelegateViewBindingViewHolder<w7.f, wa> adapterDelegateViewBindingViewHolder, Function2<? super aa, ? super Integer, Unit> function2) {
                    this.f44804a = adapterDelegateViewBindingViewHolder;
                    this.f44805b = function2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(AdapterDelegateViewBindingViewHolder this_adapterDelegateViewBinding, Drawable image, Function2 onImageLoadedCallback) {
                    Intrinsics.f(this_adapterDelegateViewBinding, "$this_adapterDelegateViewBinding");
                    Intrinsics.f(image, "$image");
                    Intrinsics.f(onImageLoadedCallback, "$onImageLoadedCallback");
                    ViewGroup.LayoutParams layoutParams = ((wa) this_adapterDelegateViewBinding.P()).getRoot().getLayoutParams();
                    Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) image;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).height = (bitmapDrawable.getBitmap().getHeight() * ((wa) this_adapterDelegateViewBinding.P()).getRoot().getWidth()) / bitmapDrawable.getBitmap().getWidth();
                    onImageLoadedCallback.s(((w7.f) this_adapterDelegateViewBinding.R()).c(), Integer.valueOf(((ViewGroup.MarginLayoutParams) layoutParams2).height));
                }

                @Override // eu.bolt.verification.sdk.internal.v9.a, eu.bolt.verification.sdk.internal.v9
                public void b(final Drawable image) {
                    Intrinsics.f(image, "image");
                    super.b(image);
                    if (image instanceof BitmapDrawable) {
                        Handler handler = new Handler(Looper.getMainLooper());
                        final AdapterDelegateViewBindingViewHolder<w7.f, wa> adapterDelegateViewBindingViewHolder = this.f44804a;
                        final Function2<aa, Integer, Unit> function2 = this.f44805b;
                        handler.post(new Runnable() { // from class: eu.bolt.verification.sdk.internal.uv
                            @Override // java.lang.Runnable
                            public final void run() {
                                r9.d.a.C0085a.d(AdapterDelegateViewBindingViewHolder.this, image, function2);
                            }
                        });
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(AdapterDelegateViewBindingViewHolder<w7.f, wa> adapterDelegateViewBindingViewHolder, Function2<? super aa, ? super Integer, Unit> function2) {
                super(1);
                this.f44802f = adapterDelegateViewBindingViewHolder;
                this.f44803g = function2;
            }

            public final void b(List<? extends Object> it) {
                Intrinsics.f(it, "it");
                this.f44802f.P().getRoot().N(this.f44802f.R().c(), false, new C0085a(this.f44802f, this.f44803g));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                b(list);
                return Unit.f50853a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super aa, ? super Integer, Unit> function2) {
            super(1);
            this.f44801f = function2;
        }

        public final void b(AdapterDelegateViewBindingViewHolder<w7.f, wa> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding, this.f44801f));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<w7.f, wa> adapterDelegateViewBindingViewHolder) {
            b(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    public static final AdapterDelegate<List<w7>> a(Function2<? super aa, ? super Integer, Unit> onImageLoadedCallback) {
        Intrinsics.f(onImageLoadedCallback, "onImageLoadedCallback");
        return new DslViewBindingListAdapterDelegate(c.f44800f, new a(), new d(onImageLoadedCallback), b.f44799f);
    }
}
