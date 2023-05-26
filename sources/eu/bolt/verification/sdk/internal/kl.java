package eu.bolt.verification.sdk.internal;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder;
import com.hannesdorfmann.adapterdelegates4.dsl.DslViewBindingListAdapterDelegate;
import eu.bolt.client.design.input.DesignTextfieldView;
import eu.bolt.verification.sdk.internal.w7;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class kl {

    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function3<w7, List<? extends w7>, Integer, Boolean> {
        public a() {
            super(3);
        }

        public final Boolean b(w7 w7Var, List<? extends w7> noName_1, int i8) {
            Intrinsics.f(noName_1, "$noName_1");
            return Boolean.valueOf(w7Var instanceof w7.j);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean l(w7 w7Var, List<? extends w7> list, Integer num) {
            return b(w7Var, list, num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<ViewGroup, LayoutInflater> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f43888f = new b();

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
    static final class c extends Lambda implements Function2<LayoutInflater, ViewGroup, za> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f43889f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b */
        public final za s(LayoutInflater layoutInflater, ViewGroup parent) {
            Intrinsics.f(layoutInflater, "layoutInflater");
            Intrinsics.f(parent, "parent");
            za b8 = za.b(layoutInflater, parent, false);
            Intrinsics.e(b8, "inflate(layoutInflater, parent, false)");
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<AdapterDelegateViewBindingViewHolder<w7.j, za>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Function2<String, String, Unit> f43890f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class a extends Lambda implements Function1<List<? extends Object>, Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder<w7.j, za> f43891f;

            /* renamed from: eu.bolt.verification.sdk.internal.kl$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public /* synthetic */ class C0069a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f43892a;

                static {
                    int[] iArr = new int[w7.j.a.values().length];
                    try {
                        iArr[w7.j.a.TEXT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[w7.j.a.NUMBERS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f43892a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AdapterDelegateViewBindingViewHolder<w7.j, za> adapterDelegateViewBindingViewHolder) {
                super(1);
                this.f43891f = adapterDelegateViewBindingViewHolder;
            }

            public final void b(List<? extends Object> it) {
                Intrinsics.f(it, "it");
                DesignTextfieldView root = this.f43891f.P().getRoot();
                AdapterDelegateViewBindingViewHolder<w7.j, za> adapterDelegateViewBindingViewHolder = this.f43891f;
                root.setHint(adapterDelegateViewBindingViewHolder.R().c());
                root.setText(adapterDelegateViewBindingViewHolder.R().e());
                root.setSelection(root.getText().length());
                int i8 = C0069a.f43892a[adapterDelegateViewBindingViewHolder.R().d().ordinal()];
                int i9 = 1;
                if (i8 != 1) {
                    i9 = 2;
                    if (i8 != 2) {
                        return;
                    }
                }
                root.getInputView().setInputType(i9);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Object> list) {
                b(list);
                return Unit.f50853a;
            }
        }

        /* loaded from: classes5.dex */
        public static final class b implements TextWatcher {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Function2 f43893f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ AdapterDelegateViewBindingViewHolder f43894g;

            public b(Function2 function2, AdapterDelegateViewBindingViewHolder adapterDelegateViewBindingViewHolder) {
                this.f43893f = function2;
                this.f43894g = adapterDelegateViewBindingViewHolder;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
                this.f43893f.s(((w7.j) this.f43894g.R()).a(), String.valueOf(charSequence));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super String, ? super String, Unit> function2) {
            super(1);
            this.f43890f = function2;
        }

        public final void b(AdapterDelegateViewBindingViewHolder<w7.j, za> adapterDelegateViewBinding) {
            Intrinsics.f(adapterDelegateViewBinding, "$this$adapterDelegateViewBinding");
            adapterDelegateViewBinding.P().getRoot().getInputView().addTextChangedListener(new b(this.f43890f, adapterDelegateViewBinding));
            adapterDelegateViewBinding.O(new a(adapterDelegateViewBinding));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AdapterDelegateViewBindingViewHolder<w7.j, za> adapterDelegateViewBindingViewHolder) {
            b(adapterDelegateViewBindingViewHolder);
            return Unit.f50853a;
        }
    }

    public static final AdapterDelegate<List<w7>> a(Function2<? super String, ? super String, Unit> onTextChanged) {
        Intrinsics.f(onTextChanged, "onTextChanged");
        return new DslViewBindingListAdapterDelegate(c.f43889f, new a(), new d(onTextChanged), b.f43888f);
    }
}
