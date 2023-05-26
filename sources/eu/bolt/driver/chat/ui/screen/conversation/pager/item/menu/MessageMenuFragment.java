package eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.uicore.components.views.CustomListItem;
import ee.mtakso.driver.uikit.utils.Image;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.R$layout;
import eu.bolt.driver.chat.R$string;
import eu.bolt.driver.chat.R$style;
import eu.bolt.driver.chat.helper.ClipboardHelper;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu.MessageMenuFragment;
import eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageMenuFragment.kt */
/* loaded from: classes5.dex */
public final class MessageMenuFragment extends BaseMvvmBottomSheetFragment<ConversationViewModel> {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f40731s = new Companion(null);

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f40732m;

    /* renamed from: n  reason: collision with root package name */
    private final Lazy f40733n;

    /* renamed from: o  reason: collision with root package name */
    private ClipboardHelper f40734o;

    /* renamed from: p  reason: collision with root package name */
    private CustomListItem f40735p;

    /* renamed from: q  reason: collision with root package name */
    private CustomListItem f40736q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f40737r;

    /* compiled from: MessageMenuFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String id, CharSequence originalMessage, CharSequence translatedMessage, CharSequence attributionText, Image image) {
            Intrinsics.f(id, "id");
            Intrinsics.f(originalMessage, "originalMessage");
            Intrinsics.f(translatedMessage, "translatedMessage");
            Intrinsics.f(attributionText, "attributionText");
            return BundleKt.a(TuplesKt.a("MESSAGE_ARG", new TranslatedMessageUiModel(id, originalMessage, translatedMessage, attributionText, image)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MessageMenuFragment(ViewModelFactory viewModelFactory) {
        super(viewModelFactory);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        this.f40737r = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu.MessageMenuFragment$copyMessageFeedbackText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final String invoke() {
                return MessageMenuFragment.this.getResources().getString(R$string.copy_clipboard);
            }
        });
        this.f40732m = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<TranslatedMessageUiModel>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu.MessageMenuFragment$message$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final TranslatedMessageUiModel invoke() {
                Parcelable parcelable = MessageMenuFragment.this.requireArguments().getParcelable("MESSAGE_ARG");
                Intrinsics.c(parcelable);
                return (TranslatedMessageUiModel) parcelable;
            }
        });
        this.f40733n = b9;
    }

    private final void U() {
        CustomListItem customListItem = this.f40735p;
        CustomListItem customListItem2 = null;
        if (customListItem == null) {
            Intrinsics.w("copyOriginalButton");
            customListItem = null;
        }
        customListItem.setOnClickListener(new View.OnClickListener() { // from class: y6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageMenuFragment.V(MessageMenuFragment.this, view);
            }
        });
        CustomListItem customListItem3 = this.f40736q;
        if (customListItem3 == null) {
            Intrinsics.w("copyTranslatedButton");
        } else {
            customListItem2 = customListItem3;
        }
        customListItem2.setOnClickListener(new View.OnClickListener() { // from class: y6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageMenuFragment.W(MessageMenuFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(MessageMenuFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.X(this$0.Z().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(MessageMenuFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.X(this$0.Z().b());
    }

    private final void X(CharSequence charSequence) {
        ClipboardHelper clipboardHelper = this.f40734o;
        if (clipboardHelper == null) {
            Intrinsics.w("clipboardHelper");
            clipboardHelper = null;
        }
        clipboardHelper.a(charSequence);
        getParentFragmentManager().setFragmentResult("RESULT_FEEDBACK", BundleKt.a(TuplesKt.a("ARGS_FEEDBACK", Y())));
        dismiss();
    }

    private final String Y() {
        return (String) this.f40732m.getValue();
    }

    private final TranslatedMessageUiModel Z() {
        return (TranslatedMessageUiModel) this.f40733n.getValue();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f40737r.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment
    /* renamed from: a0 */
    public ConversationViewModel R() {
        ViewModelProvider.Factory factory;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        factory = ((BaseMvvmBottomSheetFragment) this).f41011j;
        return (ConversationViewModel) new ViewModelProvider(requireActivity, factory).a(ConversationViewModel.class);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.Theme_ContactMethodsBottomSheetDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_menu_message, viewGroup, false);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.BaseMvvmBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R$id.copyOriginalButton);
        Intrinsics.e(findViewById, "view.findViewById(R.id.copyOriginalButton)");
        this.f40735p = (CustomListItem) findViewById;
        View findViewById2 = view.findViewById(R$id.copyTranslatedButton);
        Intrinsics.e(findViewById2, "view.findViewById(R.id.copyTranslatedButton)");
        this.f40736q = (CustomListItem) findViewById2;
        ClipboardHelper.Companion companion = ClipboardHelper.f40412b;
        Context context = view.getContext();
        Intrinsics.e(context, "view.context");
        this.f40734o = companion.a(context);
        U();
    }
}
