package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import eu.bolt.android.chat.recyclerview.ChatAdapter;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.driver.chat.ui.message.list.MessageModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatAdapterProxy.kt */
/* loaded from: classes5.dex */
public final class ChatAdapterProxy implements ChatAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final DiffAdapter f40626a;

    public ChatAdapterProxy(DiffAdapter diffAdapter) {
        Intrinsics.f(diffAdapter, "diffAdapter");
        this.f40626a = diffAdapter;
    }

    @Override // eu.bolt.android.chat.recyclerview.ChatAdapter
    public ChatMessageEntity a(int i8) {
        MessageModel messageModel;
        ListModel R = this.f40626a.R(i8);
        if (R instanceof MessageModel) {
            messageModel = (MessageModel) R;
        } else {
            messageModel = null;
        }
        if (messageModel == null) {
            return null;
        }
        return messageModel.getMessage();
    }
}
