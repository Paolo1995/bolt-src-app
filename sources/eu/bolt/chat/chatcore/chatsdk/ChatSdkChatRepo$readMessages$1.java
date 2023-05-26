package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.client.ChatClient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$readMessages$1", f = "ChatSdkChatRepo.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ChatSdkChatRepo$readMessages$1 extends SuspendLambda implements Function2<ChatClient, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38037g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f38038h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ List<ChatMessageEntity> f38039i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$readMessages$1(List<ChatMessageEntity> list, Continuation<? super ChatSdkChatRepo$readMessages$1> continuation) {
        super(2, continuation);
        this.f38039i = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatSdkChatRepo$readMessages$1 chatSdkChatRepo$readMessages$1 = new ChatSdkChatRepo$readMessages$1(this.f38039i, continuation);
        chatSdkChatRepo$readMessages$1.f38038h = obj;
        return chatSdkChatRepo$readMessages$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(ChatClient chatClient, Continuation<? super Unit> continuation) {
        return ((ChatSdkChatRepo$readMessages$1) create(chatClient, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int v7;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38037g == 0) {
            ResultKt.b(obj);
            ChatClient chatClient = (ChatClient) this.f38038h;
            List<ChatMessageEntity> list = this.f38039i;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : list) {
                String b8 = ((ChatMessageEntity) obj2).b();
                Object obj3 = linkedHashMap.get(b8);
                if (obj3 == null) {
                    obj3 = new ArrayList();
                    linkedHashMap.put(b8, obj3);
                }
                ((List) obj3).add(obj2);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List<ChatMessageEntity> list2 = (List) entry.getValue();
                v7 = CollectionsKt__IterablesKt.v(list2, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (ChatMessageEntity chatMessageEntity : list2) {
                    arrayList.add(chatMessageEntity.d());
                }
                chatClient.c(str).c(arrayList);
            }
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
