package eu.bolt.chat.di;

import eu.bolt.chat.ChatCore;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponent;

/* compiled from: ChatKitScopeComponent.kt */
/* loaded from: classes5.dex */
public interface ChatKitScopeComponent extends KoinScopeComponent {

    /* compiled from: ChatKitScopeComponent.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void a(ChatKitScopeComponent chatKitScopeComponent) {
            KoinScopeComponent.DefaultImpls.a(chatKitScopeComponent);
        }

        public static Koin b(ChatKitScopeComponent chatKitScopeComponent) {
            return ChatCore.f37837a.g();
        }
    }
}
