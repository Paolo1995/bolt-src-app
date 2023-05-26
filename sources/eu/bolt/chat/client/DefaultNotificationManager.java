package eu.bolt.chat.client;

import eu.bolt.chat.async.ObservableFlow;
import eu.bolt.chat.data.ChatPushMessage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: ChatNotificationManager.kt */
/* loaded from: classes5.dex */
final class DefaultNotificationManager implements InternalNotificationManager {

    /* renamed from: a  reason: collision with root package name */
    private final MutableSharedFlow<ChatPushMessage> f38915a = SharedFlowKt.b(0, 0, null, 7, null);

    /* renamed from: b  reason: collision with root package name */
    private final MutableSharedFlow<String> f38916b = SharedFlowKt.b(0, 0, null, 7, null);

    @Override // eu.bolt.chat.client.ChatNotificationManager
    public ObservableFlow<String> a() {
        return new ObservableFlow<>(this.f38916b);
    }

    @Override // eu.bolt.chat.client.InternalNotificationManager
    public Object b(String str, Continuation<? super Unit> continuation) {
        Object d8;
        Object b8 = this.f38916b.b(str, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.InternalNotificationManager
    public Object c(ChatPushMessage chatPushMessage, Continuation<? super Unit> continuation) {
        Object d8;
        Object b8 = this.f38915a.b(chatPushMessage, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (b8 == d8) {
            return b8;
        }
        return Unit.f50853a;
    }

    @Override // eu.bolt.chat.client.ChatNotificationManager
    public ObservableFlow<ChatPushMessage> d() {
        return new ObservableFlow<>(this.f38915a);
    }
}
