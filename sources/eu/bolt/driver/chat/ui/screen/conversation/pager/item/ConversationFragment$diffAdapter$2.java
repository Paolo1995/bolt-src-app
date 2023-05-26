package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationFragment.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class ConversationFragment$diffAdapter$2 extends FunctionReferenceImpl implements Function1<ChatMessageDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConversationFragment$diffAdapter$2(Object obj) {
        super(1, obj, ConversationFragment.class, "copyMessageToClipboard", "copyMessageToClipboard(Leu/bolt/driver/chat/ui/message/list/ChatMessageDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChatMessageDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ChatMessageDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((ConversationFragment) this.f50989g).E0(p02);
    }
}
