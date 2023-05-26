package eu.bolt.driver.chat.ui.screen.conversation.pager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior;
import eu.bolt.driver.chat.R$dimen;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.R$layout;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment;
import eu.bolt.driver.chat.ui.screen.conversation.pager.callback.ConversationHost;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.Conversation;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: ConversationPagerFragment.kt */
/* loaded from: classes5.dex */
public final class ConversationPagerFragment extends BaseMvvmFragment<ConversationPagerViewModel> implements ConversationHost {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f40594s = new Companion(null);

    /* renamed from: t  reason: collision with root package name */
    private static final int f40595t = Dimens.c(460);

    /* renamed from: l  reason: collision with root package name */
    private final CoreFragmentFactory f40596l;

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f40597m;

    /* renamed from: n  reason: collision with root package name */
    private final Lazy f40598n;

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f40599o;

    /* renamed from: p  reason: collision with root package name */
    private float f40600p;

    /* renamed from: q  reason: collision with root package name */
    private int f40601q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f40602r;

    /* compiled from: ConversationPagerFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ConversationPagerFragment.f40595t;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ConversationPagerFragment(BaseFragmentParams params, ViewModelFactory viewModelFactory, CoreFragmentFactory coreFragmentFactory) {
        super(params, viewModelFactory);
        Lazy a8;
        Lazy b8;
        Lazy b9;
        Intrinsics.f(params, "params");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        Intrinsics.f(coreFragmentFactory, "coreFragmentFactory");
        this.f40602r = new LinkedHashMap();
        this.f40596l = coreFragmentFactory;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<Float>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$chatTopGap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Float invoke() {
                return Float.valueOf(ConversationPagerFragment.this.getResources().getDimension(R$dimen.chat_top_gap));
            }
        });
        this.f40597m = a8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ViewPagerBottomSheetBehavior<View>>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$bottomSheetBehavior$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ViewPagerBottomSheetBehavior<View> invoke() {
                ViewPagerBottomSheetBehavior.Companion companion = ViewPagerBottomSheetBehavior.f36174x;
                ConstraintLayout chat_bottom_sheet = (ConstraintLayout) ConversationPagerFragment.this.R(R$id.chat_bottom_sheet);
                Intrinsics.e(chat_bottom_sheet, "chat_bottom_sheet");
                return companion.a(chat_bottom_sheet);
            }
        });
        this.f40598n = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<ConversationPagerAdapter>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$tabAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ConversationPagerAdapter invoke() {
                CoreFragmentFactory coreFragmentFactory2;
                FragmentManager childFragmentManager = ConversationPagerFragment.this.getChildFragmentManager();
                Intrinsics.e(childFragmentManager, "childFragmentManager");
                Context requireContext = ConversationPagerFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                coreFragmentFactory2 = ConversationPagerFragment.this.f40596l;
                return new ConversationPagerAdapter(childFragmentManager, requireContext, coreFragmentFactory2);
            }
        });
        this.f40599o = b9;
        this.f40601q = f40595t;
    }

    private final ViewPagerBottomSheetBehavior<?> Z() {
        return (ViewPagerBottomSheetBehavior) this.f40598n.getValue();
    }

    private final float a0() {
        return ((Number) this.f40597m.getValue()).floatValue();
    }

    private final ConversationPagerAdapter b0() {
        return (ConversationPagerAdapter) this.f40599o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ConversationPagerFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(ConversationPagerFragment this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(ConversationPagerFragment this$0, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(this$0, "this$0");
        this$0.h0();
    }

    private final void g0(List<Conversation> list) {
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        b0().a(list);
        int i8 = R$id.E;
        ((ViewPager) R(i8)).setAdapter(b0());
        int i9 = R$id.B;
        ((TabLayout) R(i9)).setupWithViewPager((ViewPager) R(i8));
        TabLayout tab = (TabLayout) R(i9);
        Intrinsics.e(tab, "tab");
        ViewExtKt.c(tab, new Function0<Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$setupViewPager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                Ref$IntRef ref$IntRef2 = Ref$IntRef.this;
                ConversationPagerFragment conversationPagerFragment = this;
                int i10 = R$id.B;
                ref$IntRef2.f51014f = ((TabLayout) conversationPagerFragment.R(i10)).getWidth() / ((TabLayout) this.R(i10)).getTabCount();
                ConversationPagerFragment conversationPagerFragment2 = this;
                int i11 = R$id.f40403o;
                ViewGroup.LayoutParams layoutParams = conversationPagerFragment2.R(i11).getLayoutParams();
                Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = Ref$IntRef.this.f51014f;
                this.R(i11).setLayoutParams(layoutParams2);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        ((ViewPager) R(i8)).c(new ViewPager.OnPageChangeListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$setupViewPager$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void a(int i10, float f8, int i11) {
                ConversationPagerFragment conversationPagerFragment = ConversationPagerFragment.this;
                int i12 = R$id.f40403o;
                ViewGroup.LayoutParams layoutParams = conversationPagerFragment.R(i12).getLayoutParams();
                Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = (int) ((f8 + i10) * ref$IntRef.f51014f);
                ConversationPagerFragment.this.R(i12).setLayoutParams(marginLayoutParams);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void c(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void d(int i10) {
            }
        });
        j0();
        ViewPager viewPager = (ViewPager) R(i8);
        Intrinsics.e(viewPager, "viewPager");
        ViewExtKt.c(viewPager, new Function0<Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$setupViewPager$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                ConversationPagerFragment.this.h0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        if (((ViewPager) R(R$id.E)) == null) {
            return;
        }
        final int height = (int) (((ConstraintLayout) R(R$id.rootChat)).getHeight() - a0());
        Z().Y(Math.min(this.f40601q, height));
        int i8 = R$id.chat_bottom_sheet;
        if (height != ((ConstraintLayout) R(i8)).getLayoutParams().height) {
            ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) R(i8)).getLayoutParams();
            layoutParams.height = height;
            ((ConstraintLayout) R(i8)).setLayoutParams(layoutParams);
            ConstraintLayout chat_bottom_sheet = (ConstraintLayout) R(i8);
            Intrinsics.e(chat_bottom_sheet, "chat_bottom_sheet");
            ViewExtKt.c(chat_bottom_sheet, new Function0<Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$updatePageSizeAndOffset$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void b() {
                    float f8;
                    ConversationPagerFragment conversationPagerFragment = ConversationPagerFragment.this;
                    int i9 = height;
                    f8 = conversationPagerFragment.f40600p;
                    conversationPagerFragment.k0(i9, f8);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(List<Conversation> list) {
        if (list.isEmpty()) {
            return;
        }
        g0(list);
        FrameLayout indicatorLayout = (FrameLayout) R(R$id.indicatorLayout);
        Intrinsics.e(indicatorLayout, "indicatorLayout");
        boolean z7 = true;
        if (list.size() <= 1) {
            z7 = false;
        }
        ee.mtakso.driver.uikit.utils.ViewExtKt.d(indicatorLayout, z7, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        int i8 = R$id.chat_bottom_sheet;
        if (((ConstraintLayout) R(i8)) == null) {
            return;
        }
        k0(((ConstraintLayout) R(i8)).getHeight(), this.f40600p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(int i8, float f8) {
        List<ConversationFragment> L;
        if (((FrameLayout) R(R$id.indicatorLayout)) == null) {
            return;
        }
        this.f40600p = f8;
        if (Float.isNaN(f8)) {
            if (Z().T() == 3) {
                f8 = 1.0f;
            } else {
                f8 = 0.0f;
            }
        }
        int height = ((ConstraintLayout) R(R$id.rootChat)).getHeight();
        int height2 = ((ConstraintLayout) R(R$id.chat_bottom_sheet)).getHeight();
        int T = Z().T();
        Kalev.b("rootChat: " + height + ", chat_bottom_sheet: " + height2 + ", bsb.state: " + T);
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.e(fragments, "childFragmentManager.fragments");
        L = CollectionsKt___CollectionsJvmKt.L(fragments, ConversationFragment.class);
        for (ConversationFragment conversationFragment : L) {
            conversationFragment.T0(i8, Z().S(), f8);
        }
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment
    public void D() {
        this.f40602r.clear();
    }

    public View R(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f40602r;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment
    /* renamed from: f0 */
    public ConversationPagerViewModel N() {
        ViewModelProvider.Factory factory;
        factory = ((BaseMvvmFragment) this).f41040i;
        return (ConversationPagerViewModel) new ViewModelProvider(this, factory).a(ConversationPagerViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_conversation_pager, viewGroup, false);
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Z().Z(4);
        Z().X(new ViewPagerBottomSheetBehavior.BottomSheetCallback() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$onStart$1
            @Override // ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.BottomSheetCallback
            public void a(View bottomSheet, int i8) {
                Intrinsics.f(bottomSheet, "bottomSheet");
            }

            @Override // ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.BottomSheetCallback
            public void b(View bottomSheet, float f8) {
                Intrinsics.f(bottomSheet, "bottomSheet");
                ConversationPagerFragment conversationPagerFragment = ConversationPagerFragment.this;
                int i8 = R$id.chat_bottom_sheet;
                if (((ConstraintLayout) conversationPagerFragment.R(i8)) == null) {
                    return;
                }
                ConversationPagerFragment conversationPagerFragment2 = ConversationPagerFragment.this;
                conversationPagerFragment2.k0(((ConstraintLayout) conversationPagerFragment2.R(i8)).getHeight(), f8);
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R$id.rootChat;
        ((ConstraintLayout) R(i8)).setOnClickListener(new View.OnClickListener() { // from class: x6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationPagerFragment.c0(ConversationPagerFragment.this, view2);
            }
        });
        j0();
        ((ConstraintLayout) R(i8)).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: x6.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ConversationPagerFragment.d0(ConversationPagerFragment.this);
            }
        });
        ((ConstraintLayout) R(i8)).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: x6.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
                ConversationPagerFragment.e0(ConversationPagerFragment.this, view2, i9, i10, i11, i12, i13, i14, i15, i16);
            }
        });
        K(J().r(), new Function1<List<? extends Conversation>, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<Conversation> conversations) {
                Intrinsics.f(conversations, "conversations");
                ConversationPagerFragment.this.i0(conversations);
                ConversationPagerFragment.this.j0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Conversation> list) {
                b(list);
                return Unit.f50853a;
            }
        });
    }

    @Override // eu.bolt.driver.chat.ui.screen.conversation.pager.callback.ConversationHost
    public void t(int i8) {
        this.f40601q = i8;
    }
}
