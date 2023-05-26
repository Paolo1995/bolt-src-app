package eu.bolt.chat.chatcore.connection;

import eu.bolt.chat.chatcore.entity.ChatConnectionState;
import io.reactivex.Observable;
import kotlin.Unit;

/* compiled from: ChatConnectionProvider.kt */
/* loaded from: classes5.dex */
public interface ChatConnectionProvider {
    ChatConnectionState c();

    Observable<ChatConnectionState> d();

    Observable<Unit> f();
}
