package eu.bolt.driver.chat.ui.screen.conversation.pager;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.driver.chat.ActiveOrdersSource;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerViewModel;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.Conversation;
import eu.bolt.driver.core.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.ui.common.lifecycle.ObservableLiveData;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationPagerViewModel.kt */
/* loaded from: classes5.dex */
public final class ConversationPagerViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final ActiveOrdersSource f40618f;

    /* renamed from: g  reason: collision with root package name */
    private final ConversationMapper f40619g;

    /* renamed from: h  reason: collision with root package name */
    private final ChatManager f40620h;

    /* renamed from: i  reason: collision with root package name */
    private final ObservableLiveData<List<Conversation>> f40621i;

    @Inject
    public ConversationPagerViewModel(ActiveOrdersSource ordersSource, ConversationMapper conversationMapper) {
        Intrinsics.f(ordersSource, "ordersSource");
        Intrinsics.f(conversationMapper, "conversationMapper");
        this.f40618f = ordersSource;
        this.f40619g = conversationMapper;
        this.f40620h = DriverChatSdk.f40388a.c();
        this.f40621i = new ObservableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.core.ui.base.mvvm.BaseViewModel
    public void n() {
        ObservableLiveData<List<Conversation>> observableLiveData = this.f40621i;
        Observable<List<ChatEntity>> l8 = this.f40620h.l(this.f40618f);
        final Function1<List<? extends ChatEntity>, List<? extends Conversation>> function1 = new Function1<List<? extends ChatEntity>, List<? extends Conversation>>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<Conversation> invoke(List<ChatEntity> it) {
                ConversationMapper conversationMapper;
                Intrinsics.f(it, "it");
                conversationMapper = ConversationPagerViewModel.this.f40619g;
                return conversationMapper.a(it);
            }
        };
        Observable<R> map = l8.map(new Function() { // from class: x6.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List s7;
                s7 = ConversationPagerViewModel.s(Function1.this, obj);
                return s7;
            }
        });
        Intrinsics.e(map, "override fun onStart() {… handleError(it) })\n    }");
        ObservableLiveData.t(observableLiveData, map, null, new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                BaseViewModel.m(ConversationPagerViewModel.this, it, null, 2, null);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f40621i.dispose();
    }

    public final ObservableLiveData<List<Conversation>> r() {
        return this.f40621i;
    }
}
