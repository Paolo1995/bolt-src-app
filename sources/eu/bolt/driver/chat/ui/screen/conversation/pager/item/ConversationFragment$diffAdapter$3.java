package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import eu.bolt.driver.chat.ui.message.list.ChatTranslatedMessageDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationFragment.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class ConversationFragment$diffAdapter$3 extends FunctionReferenceImpl implements Function1<ChatTranslatedMessageDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConversationFragment$diffAdapter$3(Object obj) {
        super(1, obj, ConversationFragment.class, "openTranslatedMessageMenu", "openTranslatedMessageMenu(Leu/bolt/driver/chat/ui/message/list/ChatTranslatedMessageDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChatTranslatedMessageDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ChatTranslatedMessageDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((ConversationFragment) this.f50989g).h1(p02);
    }
}
