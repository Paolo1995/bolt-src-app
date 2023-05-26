package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.recyclerview.layoutmanagers.CentredHorizontalStaggeredGridLayoutManager;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.android.chat.recyclerview.ChatReadDelegate;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.driver.chat.R$attr;
import eu.bolt.driver.chat.R$dimen;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.R$integer;
import eu.bolt.driver.chat.R$layout;
import eu.bolt.driver.chat.R$raw;
import eu.bolt.driver.chat.R$string;
import eu.bolt.driver.chat.helper.ClipboardHelper;
import eu.bolt.driver.chat.helper.SoundEffectsPool;
import eu.bolt.driver.chat.service.conversation.ConversationData;
import eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatMessageInDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatMessageOutDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatNewMessageDelimiterDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatQuickReplyDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatTerminalMessageDelegate;
import eu.bolt.driver.chat.ui.message.list.ChatTranslatedMessageDelegate;
import eu.bolt.driver.chat.ui.routing.ContactOptionsFromChatCommand;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment;
import eu.bolt.driver.chat.ui.screen.conversation.pager.callback.ConversationHost;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu.MessageMenuFragment;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationDialog;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarDelegate;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarModel;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ConversationFragment.kt */
/* loaded from: classes5.dex */
public final class ConversationFragment extends BaseMvvmFragment<ConversationViewModel> {
    public static final Companion H = new Companion(null);
    private static final int I = R$raw.chat_incoming_message;
    private static final int J = R$raw.ui_tap;
    private String A;
    private boolean B;
    private ViewPropertyAnimator C;
    private QuickReplyAnimationMode D;
    private LinearLayoutManager E;
    private final Lazy F;
    public Map<Integer, View> G;

    /* renamed from: l  reason: collision with root package name */
    private final MessageMapper f40631l;

    /* renamed from: m  reason: collision with root package name */
    private final CoreFragmentFactory f40632m;

    /* renamed from: n  reason: collision with root package name */
    private final ChatReadDelegate f40633n;

    /* renamed from: o  reason: collision with root package name */
    private final SoundEffectsPool f40634o;

    /* renamed from: p  reason: collision with root package name */
    private final RoutingManager f40635p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f40636q;

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f40637r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f40638s;

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f40639t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f40640u;

    /* renamed from: v  reason: collision with root package name */
    private final Function0<Unit> f40641v;

    /* renamed from: w  reason: collision with root package name */
    private final DiffAdapter f40642w;

    /* renamed from: x  reason: collision with root package name */
    private final DiffAdapter f40643x;

    /* renamed from: y  reason: collision with root package name */
    private final ChatAdapterProxy f40644y;

    /* renamed from: z  reason: collision with root package name */
    private final ConversationFragment$notificationIssueDialogCallback$1 f40645z;

    /* compiled from: ConversationFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(Conversation chatParams) {
            Intrinsics.f(chatParams, "chatParams");
            return BundleKt.a(TuplesKt.a("ARG_CONVERSATION_PARAMS", chatParams));
        }
    }

    /* compiled from: ConversationFragment.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40646a;

        static {
            int[] iArr = new int[ReconnectionState.values().length];
            try {
                iArr[ReconnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReconnectionState.RECONNECTION_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f40646a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v19, types: [eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$notificationIssueDialogCallback$1] */
    @Inject
    public ConversationFragment(BaseFragmentParams params, ViewModelFactory viewModelFactory, MessageMapper messageMapper, CoreFragmentFactory coreFragmentFactory, ChatReadDelegate chatReadDelegate, SoundEffectsPool soundsPool, RoutingManager routingManager) {
        super(params, viewModelFactory);
        Lazy b8;
        Lazy b9;
        Lazy a8;
        Lazy a9;
        Lazy b10;
        Lazy b11;
        Intrinsics.f(params, "params");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        Intrinsics.f(messageMapper, "messageMapper");
        Intrinsics.f(coreFragmentFactory, "coreFragmentFactory");
        Intrinsics.f(chatReadDelegate, "chatReadDelegate");
        Intrinsics.f(soundsPool, "soundsPool");
        Intrinsics.f(routingManager, "routingManager");
        this.G = new LinkedHashMap();
        this.f40631l = messageMapper;
        this.f40632m = coreFragmentFactory;
        this.f40633n = chatReadDelegate;
        this.f40634o = soundsPool;
        this.f40635p = routingManager;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Conversation>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$chatParams$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Conversation invoke() {
                Parcelable parcelable = ConversationFragment.this.requireArguments().getParcelable("ARG_CONVERSATION_PARAMS");
                Intrinsics.d(parcelable, "null cannot be cast to non-null type eu.bolt.driver.chat.ui.screen.conversation.pager.item.Conversation");
                return (Conversation) parcelable;
            }
        });
        this.f40636q = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<ClipboardHelper>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$clipboardHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ClipboardHelper invoke() {
                ClipboardHelper.Companion companion = ClipboardHelper.f40412b;
                Context requireContext = ConversationFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                return companion.a(requireContext);
            }
        });
        this.f40637r = b9;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        a8 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<Integer>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$quickReplyRows$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Integer invoke() {
                return Integer.valueOf(ConversationFragment.this.getResources().getInteger(R$integer.chat_quick_replies_rows));
            }
        });
        this.f40638s = a8;
        a9 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<Integer>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$quickReplyHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Integer invoke() {
                int L0;
                int dimensionPixelSize = ConversationFragment.this.getResources().getDimensionPixelSize(R$dimen.chat_quick_replies_height);
                L0 = ConversationFragment.this.L0();
                return Integer.valueOf(L0 * dimensionPixelSize);
            }
        });
        this.f40639t = a9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<SnackBarDelegate>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$snackBarDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SnackBarDelegate invoke() {
                View requireView = ConversationFragment.this.requireView();
                Intrinsics.e(requireView, "requireView()");
                return new SnackBarDelegate(requireView, null, 2, null);
            }
        });
        this.f40640u = b10;
        this.f40641v = new Function0<Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$scrollToLastPositionAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                DiffAdapter diffAdapter;
                RecyclerView recyclerView;
                DiffAdapter diffAdapter2;
                diffAdapter = ConversationFragment.this.f40642w;
                if (diffAdapter.r() > 1 && (recyclerView = (RecyclerView) ConversationFragment.this.f0(R$id.messagesRecyclerView)) != null) {
                    diffAdapter2 = ConversationFragment.this.f40642w;
                    recyclerView.x1(diffAdapter2.r() - 1);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        };
        DiffAdapter P = new DiffAdapter().P(new ChatNewMessageDelimiterDelegate()).P(new ChatMessageInDelegate(new ConversationFragment$diffAdapter$1(this))).P(new ChatMessageOutDelegate(new ConversationFragment$diffAdapter$2(this))).P(new ChatTerminalMessageDelegate()).P(new InfoBlockDelegate()).P(new DividerDelegate()).P(new TextCenteredDelegate(null, 1, null)).P(new ChatTranslatedMessageDelegate(new ConversationFragment$diffAdapter$3(this)));
        this.f40642w = P;
        this.f40643x = new DiffAdapter().P(new ChatQuickReplyDelegate(new ConversationFragment$quickReplyiffAdapter$1(this)));
        this.f40644y = new ChatAdapterProxy(P);
        this.f40645z = new DialogCallback() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$notificationIssueDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "ITEM_CONFIRM_TAG")) {
                    ConversationFragment.this.s1();
                }
                dialog.dismiss();
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
            }
        };
        this.D = QuickReplyAnimationMode.IDLE;
        b11 = LazyKt__LazyJVMKt.b(new Function0<ConversationHost>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$conversationHost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ConversationHost invoke() {
                ConversationHost C0;
                C0 = ConversationFragment.this.C0();
                return C0;
            }
        });
        this.F = b11;
    }

    private final void A0(float f8, float f9) {
        boolean z7;
        ViewPropertyAnimator viewPropertyAnimator = this.C;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        int i8 = R$id.quickReplyRecycler;
        if (f9 == ((RecyclerView) f0(i8)).getTranslationY()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        ((RecyclerView) f0(i8)).getTranslationY();
        this.C = ((RecyclerView) f0(i8)).animate().translationY(f9).withEndAction(new Runnable() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.e
            @Override // java.lang.Runnable
            public final void run() {
                ConversationFragment.B0(ConversationFragment.this);
            }
        }).setDuration(((f9 - ((RecyclerView) f0(i8)).getTranslationY()) / (f9 - f8)) * ((float) 400));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ConversationFragment this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.C = null;
        this$0.D = QuickReplyAnimationMode.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationHost C0() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof ConversationHost) {
            return (ConversationHost) parentFragment;
        }
        return null;
    }

    private final void D0() {
        View chatErrorPlacholder = f0(R$id.chatErrorPlacholder);
        Intrinsics.e(chatErrorPlacholder, "chatErrorPlacholder");
        ViewExtKt.e(chatErrorPlacholder, false, 0, 2, null);
        Group chatContent = (Group) f0(R$id.chatContent);
        Intrinsics.e(chatContent, "chatContent");
        ViewExtKt.e(chatContent, false, 0, 3, null);
        ConversationHost J0 = J0();
        if (J0 != null) {
            J0.t(ConversationPagerFragment.f40594s.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(ChatMessageDelegate.Model model) {
        I0().a(model.t());
        String string = getResources().getString(R$string.copy_clipboard);
        Intrinsics.e(string, "resources.getString(R.string.copy_clipboard)");
        r1(string);
    }

    private final List<ListModel> F0(int i8) {
        List<ListModel> n8;
        n8 = CollectionsKt__CollectionsKt.n(new DividerDelegate.Model("listid-empty-spacer", i8, 0, null, null, 0, 0, 124, null), new TextCenteredDelegate.Model("listid-empty-banner", getString(R$string.chat_empty_screen_hint), 0, null, false, null, null, 0.0f, false, false, false, 2044, null));
        return n8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(boolean z7) {
        int d8;
        Context context = getContext();
        if (context == null) {
            return;
        }
        ImageView imageView = (ImageView) f0(R$id.iconSend);
        if (z7) {
            d8 = ContextUtilsKt.d(context, R$attr.linkAlternative);
        } else {
            d8 = ContextUtilsKt.d(context, R$attr.dynamicNeutral04);
        }
        imageView.setColorFilter(ContextCompat.getColor(context, d8), PorterDuff.Mode.SRC_IN);
    }

    private final Conversation H0() {
        return (Conversation) this.f40636q.getValue();
    }

    private final ClipboardHelper I0() {
        return (ClipboardHelper) this.f40637r.getValue();
    }

    private final ConversationHost J0() {
        return (ConversationHost) this.F.getValue();
    }

    private final int K0() {
        return ((Number) this.f40639t.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L0() {
        return ((Number) this.f40638s.getValue()).intValue();
    }

    private final SnackBarDelegate M0() {
        return (SnackBarDelegate) this.f40640u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(ReconnectionState reconnectionState) {
        int i8 = WhenMappings.f40646a[reconnectionState.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                v1();
                return;
            }
            return;
        }
        D0();
    }

    private final void O0() {
        Kalev.b("hideQuickReplies");
        QuickReplyAnimationMode quickReplyAnimationMode = this.D;
        QuickReplyAnimationMode quickReplyAnimationMode2 = QuickReplyAnimationMode.HIDE;
        if (quickReplyAnimationMode == quickReplyAnimationMode2) {
            return;
        }
        this.D = quickReplyAnimationMode2;
        A0(0.0f, K0());
    }

    private final void P0(int i8) {
        if (i8 < this.f40642w.r() && getView() != null) {
            int i9 = R$id.messagesRecyclerView;
            final Function0<Unit> function0 = this.f40641v;
            ((RecyclerView) f0(i9)).removeCallbacks(new Runnable() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.h
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationFragment.Q0(Function0.this);
                }
            });
            ((RecyclerView) f0(i9)).p1(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[LOOP:0: B:7:0x0023->B:21:0x0061, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0065 A[EDGE_INSN: B:59:0x0065->B:23:0x0065 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void R0(java.util.List<eu.bolt.chat.chatcore.entity.ChatMessageEntity> r11, eu.bolt.chat.chatcore.entity.TerminationInfo r12) {
        /*
            r10 = this;
            ee.mtakso.driver.uikit.recyclerview.DiffAdapter r0 = r10.f40642w
            int r0 = r0.r()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            eu.bolt.driver.chat.ui.screen.conversation.pager.item.MessageMapper r3 = r10.f40631l
            java.lang.String r4 = r10.A
            android.content.Context r5 = r10.requireContext()
            java.lang.String r6 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.e(r5, r6)
            java.util.List r3 = r3.f(r11, r4, r5)
            java.util.Iterator r4 = r3.iterator()
            r5 = 0
        L23:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L64
            java.lang.Object r7 = r4.next()
            ee.mtakso.driver.uikit.recyclerview.ListModel r7 = (ee.mtakso.driver.uikit.recyclerview.ListModel) r7
            boolean r8 = r7 instanceof eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate.Model
            if (r8 == 0) goto L5d
            eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate$Model r7 = (eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate.Model) r7
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r8 = r7.getMessage()
            boolean r8 = r8.n()
            if (r8 != 0) goto L5d
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r8 = r7.getMessage()
            eu.bolt.chat.chatcore.entity.ChatMessageType r8 = r8.m()
            eu.bolt.chat.chatcore.entity.ChatMessageType r9 = eu.bolt.chat.chatcore.entity.ChatMessageType.SERVICE
            if (r8 == r9) goto L5d
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r7 = r7.getMessage()
            eu.bolt.chat.chatcore.entity.ChatMessageStatus r7 = r7.i()
            eu.bolt.chat.chatcore.entity.ChatMessageStatus$DeliveredToBackend r8 = eu.bolt.chat.chatcore.entity.ChatMessageStatus.DeliveredToBackend.f38163b
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r8)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            if (r7 == 0) goto L61
            goto L65
        L61:
            int r5 = r5 + 1
            goto L23
        L64:
            r5 = -1
        L65:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            int r5 = r4.intValue()
            if (r5 < 0) goto L70
            r1 = 1
        L70:
            r5 = 0
            if (r1 == 0) goto L74
            goto L75
        L74:
            r4 = r5
        L75:
            if (r0 == 0) goto L93
            if (r4 == 0) goto L93
            int r0 = r4.intValue()
            if (r0 == 0) goto L93
            int r0 = r4.intValue()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.Z(r11, r0)
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r0 = (eu.bolt.chat.chatcore.entity.ChatMessageEntity) r0
            if (r0 == 0) goto L90
            java.lang.String r0 = r0.d()
            goto L91
        L90:
            r0 = r5
        L91:
            r10.A = r0
        L93:
            if (r12 == 0) goto L9a
            java.util.List r11 = kotlin.collections.CollectionsKt.k()
            goto Ld2
        L9a:
            int r0 = r11.size()
            if (r0 != r2) goto Lbd
            java.lang.Object r0 = kotlin.collections.CollectionsKt.Y(r11)
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r0 = (eu.bolt.chat.chatcore.entity.ChatMessageEntity) r0
            if (r0 == 0) goto Lad
            eu.bolt.chat.chatcore.entity.ChatMessageType r0 = r0.m()
            goto Lae
        Lad:
            r0 = r5
        Lae:
            eu.bolt.chat.chatcore.entity.ChatMessageType r1 = eu.bolt.chat.chatcore.entity.ChatMessageType.SERVICE
            if (r0 != r1) goto Lbd
            r11 = 8
            int r11 = ee.mtakso.driver.uicore.utils.Dimens.d(r11)
            java.util.List r11 = r10.F0(r11)
            goto Ld2
        Lbd:
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto Lce
            r11 = 36
            int r11 = ee.mtakso.driver.uicore.utils.Dimens.d(r11)
            java.util.List r11 = r10.F0(r11)
            goto Ld2
        Lce:
            java.util.List r11 = kotlin.collections.CollectionsKt.k()
        Ld2:
            if (r12 == 0) goto Le1
            eu.bolt.driver.chat.ui.screen.conversation.pager.item.MessageMapper r0 = r10.f40631l
            android.content.Context r1 = r10.requireContext()
            kotlin.jvm.internal.Intrinsics.e(r1, r6)
            eu.bolt.driver.chat.ui.message.list.ChatTerminalMessageDelegate$Model r5 = r0.j(r12, r1)
        Le1:
            java.util.List r11 = kotlin.collections.CollectionsKt.n0(r3, r11)
            java.util.List r12 = kotlin.collections.CollectionsKt.o(r5)
            java.util.List r11 = kotlin.collections.CollectionsKt.n0(r11, r12)
            ee.mtakso.driver.uikit.recyclerview.DiffAdapter r12 = r10.f40642w
            eu.bolt.driver.chat.ui.screen.conversation.pager.item.f r0 = new eu.bolt.driver.chat.ui.screen.conversation.pager.item.f
            r0.<init>()
            r12.U(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment.R0(java.util.List, eu.bolt.chat.chatcore.entity.TerminationInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(List uiMessages, ConversationFragment this$0, Integer num) {
        Intrinsics.f(uiMessages, "$uiMessages");
        Intrinsics.f(this$0, "this$0");
        int size = uiMessages.size() - 1;
        if (this$0.getView() != null) {
            if (num != null) {
                size = num.intValue();
            }
            this$0.P0(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(ConversationData conversationData) {
        int K0;
        boolean z7;
        List<ChatQuickReplyDelegate.Model> g8 = this.f40631l.g(conversationData.b());
        this.B = !g8.isEmpty();
        DiffAdapter.V(this.f40643x, g8, null, 2, null);
        if (g8.isEmpty()) {
            K0 = getResources().getDimensionPixelSize(R$dimen.padding_8);
        } else {
            K0 = K0();
        }
        y1(K0);
        RecyclerView quickReplyRecycler = (RecyclerView) f0(R$id.quickReplyRecycler);
        Intrinsics.e(quickReplyRecycler, "quickReplyRecycler");
        if (conversationData.c() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(quickReplyRecycler, z7, 0, 2, null);
        if (!this.B) {
            O0();
        } else if (!((RecyclerView) f0(R$id.messagesRecyclerView)).canScrollVertically(1)) {
            u1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(ConversationFragment this$0, String str, Bundle result) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(str, "<anonymous parameter 0>");
        Intrinsics.f(result, "result");
        String string = result.getString("ARGS_FEEDBACK");
        if (string == null) {
            return;
        }
        this$0.r1(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(ConversationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Kalev.b("Close icon activity finish");
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(ConversationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Kalev.b("Activity finish");
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(ConversationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.J().Y();
        RoutingManager.d(this$0.f40635p, new ContactOptionsFromChatCommand(this$0.H0().c()), false, 2, null);
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(ConversationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Kalev.b("Icon send tapped");
        this$0.n1(String.valueOf(((AppCompatEditText) this$0.f0(R$id.messageInput)).getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(ConversationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Kalev.b("Retry tapped- conversationViewModel connect initiated");
        this$0.J().F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(ConversationFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(ChatTranslatedMessageDelegate.Model model) {
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ((MessageMenuFragment) this.f40632m.a(requireContext, MessageMenuFragment.class, MessageMenuFragment.f40731s.a(model.m(), TextKt.a(model.q(), requireContext), TextKt.a(model.r(), requireContext), TextKt.a(model.o(), requireContext), model.n()))).show(getParentFragmentManager(), "MessageMenuFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(ChatQuickReplyDelegate.Model model) {
        QuickReplyEntity quickReplyEntity;
        Kalev.b("Quick Reply Textview tapped");
        Object n8 = model.n();
        if (n8 instanceof QuickReplyEntity) {
            quickReplyEntity = (QuickReplyEntity) n8;
        } else {
            quickReplyEntity = null;
        }
        if (quickReplyEntity != null) {
            o1(quickReplyEntity);
        }
    }

    private final void k1() {
        int i8 = R$id.messagesRecyclerView;
        final Function0<Unit> function0 = this.f40641v;
        ((RecyclerView) f0(i8)).removeCallbacks(new Runnable() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.i
            @Override // java.lang.Runnable
            public final void run() {
                ConversationFragment.l1(Function0.this);
            }
        });
        final Function0<Unit> function02 = this.f40641v;
        ((RecyclerView) f0(i8)).postDelayed(new Runnable() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.j
            @Override // java.lang.Runnable
            public final void run() {
                ConversationFragment.m1(Function0.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(Function0 tmp0) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void n1(String str) {
        CharSequence Y0;
        boolean y7;
        Kalev.b("Edittext message sent");
        ((AppCompatEditText) f0(R$id.messageInput)).setText("");
        Y0 = StringsKt__StringsKt.Y0(str);
        String obj = Y0.toString();
        y7 = StringsKt__StringsJVMKt.y(obj);
        if (y7) {
            return;
        }
        ConversationViewModel.T(J(), obj, null, 2, null);
        k1();
    }

    private final void o1(QuickReplyEntity quickReplyEntity) {
        Kalev.b("Quick reply message sent");
        J().S(quickReplyEntity.b(), quickReplyEntity.a());
        k1();
    }

    private final void p1() {
        SimpleItemAnimator simpleItemAnimator;
        RecyclerView recyclerView = (RecyclerView) f0(R$id.messagesRecyclerView);
        final Context requireContext = requireContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext) { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$setupMessagesRecyclerView$1$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void h1(RecyclerView.State state) {
                ChatReadDelegate chatReadDelegate;
                ChatAdapterProxy chatAdapterProxy;
                super.h1(state);
                chatReadDelegate = ConversationFragment.this.f40633n;
                RecyclerView messagesRecyclerView = (RecyclerView) ConversationFragment.this.f0(R$id.messagesRecyclerView);
                Intrinsics.e(messagesRecyclerView, "messagesRecyclerView");
                chatAdapterProxy = ConversationFragment.this.f40644y;
                chatReadDelegate.i(messagesRecyclerView, chatAdapterProxy);
            }
        };
        this.E = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.f40642w);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        } else {
            simpleItemAnimator = null;
        }
        if (simpleItemAnimator != null) {
            simpleItemAnimator.R(false);
        }
        recyclerView.h(new ListItemDepthDecoration(Dimens.d(24)));
        recyclerView.h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ChatReadDelegate chatReadDelegate = this.f40633n;
        Intrinsics.e(recyclerView, "this");
        chatReadDelegate.g(recyclerView, this.f40644y);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.l(new RecyclerView.OnScrollListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$setupMessagesRecyclerView$1$2

            /* renamed from: a  reason: collision with root package name */
            private Boolean f40660a = Boolean.TRUE;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(RecyclerView recyclerView2, int i8) {
                Intrinsics.f(recyclerView2, "recyclerView");
                super.a(recyclerView2, i8);
                if (!((RecyclerView) ConversationFragment.this.f0(R$id.messagesRecyclerView)).canScrollVertically(1)) {
                    ConversationFragment.this.u1();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i8, int i9) {
                Intrinsics.f(recyclerView2, "recyclerView");
                super.b(recyclerView2, i8, i9);
                if (i9 > 0) {
                    Boolean bool = this.f40660a;
                    Boolean bool2 = Boolean.TRUE;
                    if (!Intrinsics.a(bool, bool2)) {
                        this.f40660a = bool2;
                        return;
                    }
                }
                if (i9 < 0) {
                    this.f40660a = Boolean.FALSE;
                    ConversationFragment.this.W0();
                }
            }
        });
    }

    private final void q1() {
        RecyclerView recyclerView = (RecyclerView) f0(R$id.quickReplyRecycler);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = K0();
        recyclerView.setLayoutParams(layoutParams);
        recyclerView.setLayoutManager(new CentredHorizontalStaggeredGridLayoutManager(L0(), true, Dimens.d(8), Dimens.d(8)));
        recyclerView.setAdapter(this.f40643x);
    }

    private final void r1(String str) {
        M0().b(new SnackBarModel(-1, new Text.Value(str), null, null, null, null, 60, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1() {
        String str;
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        Context context = getContext();
        if (context != null) {
            str = context.getPackageName();
        } else {
            str = null;
        }
        intent.putExtra("android.provider.extra.APP_PACKAGE", str);
        startActivity(intent);
    }

    private final void t1() {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f41075m;
        String string = getResources().getString(R$string.chat_dialog_notifications_title);
        Intrinsics.e(string, "resources.getString(R.st…alog_notifications_title)");
        String string2 = getResources().getString(R$string.chat_dialog_notifications_text);
        Intrinsics.e(string2, "resources.getString(R.st…ialog_notifications_text)");
        String string3 = getString(R$string.action_turn_on);
        Intrinsics.e(string3, "getString(R.string.action_turn_on)");
        String string4 = getString(R$string.action_cancel);
        Intrinsics.e(string4, "getString(R.string.action_cancel)");
        ConfirmationDialog b8 = ConfirmationDialog.Companion.b(companion, string, string2, string3, null, string4, this.f40645z, null, 72, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(b8, requireActivity, "TAG_CONFIRM_NOTIFICATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        Kalev.b("showQuickReplies");
        if (!this.B) {
            return;
        }
        QuickReplyAnimationMode quickReplyAnimationMode = this.D;
        QuickReplyAnimationMode quickReplyAnimationMode2 = QuickReplyAnimationMode.SHOW;
        if (quickReplyAnimationMode == quickReplyAnimationMode2) {
            return;
        }
        this.D = quickReplyAnimationMode2;
        A0(K0(), 0.0f);
    }

    private final void v1() {
        int i8 = R$id.chatErrorPlacholder;
        View chatErrorPlacholder = f0(i8);
        Intrinsics.e(chatErrorPlacholder, "chatErrorPlacholder");
        ViewExtKt.e(chatErrorPlacholder, false, 0, 3, null);
        Group chatContent = (Group) f0(R$id.chatContent);
        Intrinsics.e(chatContent, "chatContent");
        ViewExtKt.e(chatContent, false, 0, 2, null);
        f0(i8).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.g
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
                ConversationFragment.w1(ConversationFragment.this, view, i9, i10, i11, i12, i13, i14, i15, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(ConversationFragment this$0, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        boolean z7;
        ConversationHost J0;
        Intrinsics.f(this$0, "this$0");
        int i16 = R$id.chatErrorPlacholder;
        View chatErrorPlacholder = this$0.f0(i16);
        Intrinsics.e(chatErrorPlacholder, "chatErrorPlacholder");
        if (chatErrorPlacholder.getVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && (J0 = this$0.J0()) != null) {
            J0.t(this$0.f0(i16).getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(boolean z7) {
        int i8;
        boolean z8;
        AppCompatImageView appCompatImageView = (AppCompatImageView) f0(R$id.callIcon);
        boolean z9 = false;
        if (z7) {
            i8 = 0;
        } else {
            i8 = 4;
        }
        appCompatImageView.setVisibility(i8);
        ((ImageView) f0(R$id.iconSend)).setEnabled(z7);
        int i9 = R$id.messageInput;
        ((AppCompatEditText) f0(i9)).setEnabled(z7);
        if (String.valueOf(((AppCompatEditText) f0(i9)).getText()).length() > 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8 && z7) {
            z9 = true;
        }
        G0(z9);
        if (!z7) {
            ((AppCompatEditText) f0(i9)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(int i8) {
        int i9;
        RecyclerView recyclerView = (RecyclerView) f0(R$id.messagesRecyclerView);
        if (recyclerView != null) {
            LinearLayout linearLayout = (LinearLayout) f0(R$id.messageLayout);
            if (linearLayout != null) {
                i9 = linearLayout.getHeight();
            } else {
                i9 = 0;
            }
            recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), i8 + i9);
        }
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment
    public void D() {
        this.G.clear();
    }

    public final void T0(int i8, int i9, float f8) {
        ConstraintLayout constraintLayout;
        boolean z7 = true;
        int i10 = (i8 - i9) * ((int) (1 - f8));
        Kalev.b("bottomSheetHeight = " + i8 + ", slideOffset = " + f8 + ", resultMargin = " + i10);
        int i11 = R$id.rootChat;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) f0(i11);
        if (!((constraintLayout2 == null || constraintLayout2.getPaddingBottom() != i10) ? false : false) && (constraintLayout = (ConstraintLayout) f0(i11)) != null) {
            constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), constraintLayout.getPaddingRight(), i10);
        }
    }

    public final void W0() {
        O0();
    }

    public View f0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.G;
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
    /* renamed from: i1 */
    public ConversationViewModel N() {
        ViewModelProvider.Factory factory;
        factory = ((BaseMvvmFragment) this).f41040i;
        return (ConversationViewModel) new ViewModelProvider(this, factory).a(ConversationViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_conversation, viewGroup, false);
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        J().X();
        super.onPause();
        final Function0<Unit> function0 = this.f40641v;
        ((RecyclerView) f0(R$id.messagesRecyclerView)).removeCallbacks(new Runnable() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.a
            @Override // java.lang.Runnable
            public final void run() {
                ConversationFragment.U0(Function0.this);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        J().W();
        if (!J().E(H0().a())) {
            t1();
        }
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "TAG_CONFIRM_NOTIFICATION", this.f40645z);
        this.f40634o.b(I);
        this.f40634o.b(J);
        p1();
        q1();
        ((TextView) f0(R$id.userName)).setText(H0().d());
        TextView textView = (TextView) f0(R$id.address);
        String b8 = H0().b();
        if (b8 == null) {
            b8 = "";
        }
        textView.setText(b8);
        J().K(H0().a());
        LiveData<ConversationData> H2 = J().H();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ConversationData, Unit> function1 = new Function1<ConversationData, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ConversationData data) {
                boolean z7;
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    FastLog.DefaultImpls.a(g8, "Draw conversation: " + data, null, 2, null);
                }
                ConversationFragment.this.R0(data.a(), data.c());
                ConversationFragment conversationFragment = ConversationFragment.this;
                if (data.c() == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                conversationFragment.x1(z7);
                ConversationFragment conversationFragment2 = ConversationFragment.this;
                Intrinsics.e(data, "data");
                conversationFragment2.V0(data);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConversationData conversationData) {
                b(conversationData);
                return Unit.f50853a;
            }
        };
        H2.i(viewLifecycleOwner, new Observer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConversationFragment.X0(Function1.this, obj);
            }
        });
        K(J().I(), new Function1<ConversationNotification, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$onViewCreated$2

            /* compiled from: ConversationFragment.kt */
            /* loaded from: classes5.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f40655a;

                static {
                    int[] iArr = new int[ConversationNotification.values().length];
                    try {
                        iArr[ConversationNotification.NEW_MESSAGE_RECEIVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ConversationNotification.NEW_MESSAGE_SENT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f40655a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ConversationNotification notification) {
                SoundEffectsPool soundEffectsPool;
                int i8;
                SoundEffectsPool soundEffectsPool2;
                int i9;
                Intrinsics.f(notification, "notification");
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    FastLog.DefaultImpls.a(g8, "Conversation notification: " + notification, null, 2, null);
                }
                int i10 = WhenMappings.f40655a[notification.ordinal()];
                if (i10 == 1) {
                    soundEffectsPool = ConversationFragment.this.f40634o;
                    i8 = ConversationFragment.I;
                    soundEffectsPool.a(i8);
                } else if (i10 == 2) {
                    soundEffectsPool2 = ConversationFragment.this.f40634o;
                    i9 = ConversationFragment.J;
                    soundEffectsPool2.a(i9);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConversationNotification conversationNotification) {
                b(conversationNotification);
                return Unit.f50853a;
            }
        });
        LiveData<ReconnectionState> J2 = J().J();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<ReconnectionState, Unit> function12 = new Function1<ReconnectionState, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ReconnectionState state) {
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    FastLog.DefaultImpls.a(g8, "Connection status: " + state, null, 2, null);
                }
                ConversationFragment conversationFragment = ConversationFragment.this;
                Intrinsics.e(state, "state");
                conversationFragment.N0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReconnectionState reconnectionState) {
                b(reconnectionState);
                return Unit.f50853a;
            }
        };
        J2.i(viewLifecycleOwner2, new Observer() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConversationFragment.Y0(Function1.this, obj);
            }
        });
        getParentFragmentManager().setFragmentResultListener("RESULT_FEEDBACK", getViewLifecycleOwner(), new FragmentResultListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.m
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                ConversationFragment.Z0(ConversationFragment.this, str, bundle2);
            }
        });
        ((AppCompatImageView) f0(R$id.f40400h)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationFragment.a1(ConversationFragment.this, view2);
            }
        });
        ((ConstraintLayout) f0(R$id.rootChat)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationFragment.b1(ConversationFragment.this, view2);
            }
        });
        ((AppCompatImageView) f0(R$id.callIcon)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationFragment.c1(ConversationFragment.this, view2);
            }
        });
        ((ImageView) f0(R$id.iconSend)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationFragment.d1(ConversationFragment.this, view2);
            }
        });
        ((RoundButton) f0(R$id.f40406y)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationFragment.e1(ConversationFragment.this, view2);
            }
        });
        ((AppCompatImageView) f0(R$id.f40401l)).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationFragment.f1(ConversationFragment.this, view2);
            }
        });
        f0(R$id.chatErrorPlacholder).setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConversationFragment.g1(view2);
            }
        });
        LinearLayout messageLayout = (LinearLayout) f0(R$id.messageLayout);
        Intrinsics.e(messageLayout, "messageLayout");
        ViewExtKt.c(messageLayout, new Function0<Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$onViewCreated$12
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                Resources resources;
                Context context = ConversationFragment.this.getContext();
                if (context != null) {
                    resources = context.getResources();
                } else {
                    resources = null;
                }
                if (resources != null) {
                    ConversationFragment.this.y1(resources.getDimensionPixelSize(R$dimen.padding_8));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        ((AppCompatEditText) f0(R$id.messageInput)).addTextChangedListener(new TextWatcher() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment$onViewCreated$13
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z7;
                ConversationViewModel J3;
                TerminationInfo terminationInfo;
                boolean z8;
                String obj;
                boolean z9 = true;
                if (editable != null && (obj = editable.toString()) != null && obj.length() > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                J3 = ConversationFragment.this.J();
                ConversationData f8 = J3.H().f();
                if (f8 != null) {
                    terminationInfo = f8.c();
                } else {
                    terminationInfo = null;
                }
                if (terminationInfo == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                ConversationFragment.this.G0((z7 && z8) ? false : false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
            }
        });
    }
}
