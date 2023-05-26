package eu.bolt.driver.chat.service;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatManager.kt */
/* loaded from: classes5.dex */
public final class ChatManager$observeActiveConversationPreviews$1 extends Lambda implements Function1<List<? extends ChatEntity>, ObservableSource<? extends List<? extends ConversationPreviewData>>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ChatManager f40459f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatManager$observeActiveConversationPreviews$1(ChatManager chatManager) {
        super(1);
        this.f40459f = chatManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationPreviewData e(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ConversationPreviewData) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: d */
    public final ObservableSource<? extends List<ConversationPreviewData>> invoke(List<ChatEntity> chatEntities) {
        int v7;
        ChatRepo chatRepo;
        ChatRepo chatRepo2;
        Intrinsics.f(chatEntities, "chatEntities");
        ChatManager chatManager = this.f40459f;
        v7 = CollectionsKt__IterablesKt.v(chatEntities, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (final ChatEntity chatEntity : chatEntities) {
            chatRepo = chatManager.f40456c;
            Observable<Integer> f02 = chatRepo.e(chatEntity.b()).f0();
            chatRepo2 = chatManager.f40456c;
            Observable<List<ChatMessageEntity>> f03 = chatRepo2.b(chatEntity.b()).f0();
            final Function2<Integer, List<? extends ChatMessageEntity>, ConversationPreviewData> function2 = new Function2<Integer, List<? extends ChatMessageEntity>, ConversationPreviewData>() { // from class: eu.bolt.driver.chat.service.ChatManager$observeActiveConversationPreviews$1$observables$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: b */
                public final ConversationPreviewData s(Integer count, List<ChatMessageEntity> messages) {
                    ChatMessageEntity chatMessageEntity;
                    boolean z7;
                    Intrinsics.f(count, "count");
                    Intrinsics.f(messages, "messages");
                    ListIterator<ChatMessageEntity> listIterator = messages.listIterator(messages.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            chatMessageEntity = listIterator.previous();
                            ChatMessageEntity chatMessageEntity2 = chatMessageEntity;
                            if (!chatMessageEntity2.o() && !chatMessageEntity2.n() && Intrinsics.a(chatMessageEntity2.i(), ChatMessageStatus.DeliveredToBackend.f38163b)) {
                                z7 = true;
                                continue;
                            } else {
                                z7 = false;
                                continue;
                            }
                            if (z7) {
                                break;
                            }
                        } else {
                            chatMessageEntity = null;
                            break;
                        }
                    }
                    return new ConversationPreviewData(ChatEntity.this, count.intValue(), chatMessageEntity);
                }
            };
            arrayList.add(Observable.combineLatest(f02, f03, new BiFunction() { // from class: eu.bolt.driver.chat.service.c
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    ConversationPreviewData e8;
                    e8 = ChatManager$observeActiveConversationPreviews$1.e(Function2.this, obj, obj2);
                    return e8;
                }
            }));
        }
        final ChatManager$observeActiveConversationPreviews$1$combined$1 chatManager$observeActiveConversationPreviews$1$combined$1 = new Function1<Object[], List<? extends ConversationPreviewData>>() { // from class: eu.bolt.driver.chat.service.ChatManager$observeActiveConversationPreviews$1$combined$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ConversationPreviewData> invoke(Object[] array) {
                Intrinsics.f(array, "array");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : array) {
                    if (obj instanceof ConversationPreviewData) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        };
        Observable combineLatest = Observable.combineLatest(arrayList, new Function() { // from class: eu.bolt.driver.chat.service.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List g8;
                g8 = ChatManager$observeActiveConversationPreviews$1.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(observable…Data>()\n                }");
        return combineLatest;
    }
}
