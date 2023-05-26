package eu.bolt.chat.storage;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.storage.data.MessageUpdateResult;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: ChatStorage.kt */
/* loaded from: classes5.dex */
public interface ChatStorage {

    /* compiled from: ChatStorage.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object a(ChatStorage chatStorage, String str, Function1 function1, Continuation continuation, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    function1 = ChatStorageKt.f39537a;
                }
                return chatStorage.d(str, function1, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMessages");
        }
    }

    Object a(Chat chat, Continuation<? super Unit> continuation);

    Object b(ChatMessage chatMessage, Continuation<? super MessageUpdateResult> continuation);

    Object c(String str, Continuation<? super ChatMessage> continuation);

    Object d(String str, Function1<? super ChatMessage, Boolean> function1, Continuation<? super List<? extends ChatMessage>> continuation);

    Object e(String str, Continuation<? super Chat> continuation);

    Object f(String str, Function1<? super ChatMessage, Boolean> function1, Continuation<? super Integer> continuation);
}
