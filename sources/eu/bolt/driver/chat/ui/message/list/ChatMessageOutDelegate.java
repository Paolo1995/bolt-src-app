package eu.bolt.driver.chat.ui.message.list;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import eu.bolt.driver.chat.R$layout;
import eu.bolt.driver.chat.ui.message.list.ChatMessageDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageOutDelegate.kt */
/* loaded from: classes5.dex */
public final class ChatMessageOutDelegate extends ChatMessageDelegate {

    /* renamed from: c  reason: collision with root package name */
    private final int f40533c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageOutDelegate(Function1<? super ChatMessageDelegate.Model, Unit> onMessageLongClick) {
        super(onMessageLongClick);
        Intrinsics.f(onMessageLongClick, "onMessageLongClick");
        this.f40533c = R$layout.delegate_chat_out_item;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f40533c;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        if ((model instanceof ChatMessageDelegate.Model) && ((ChatMessageDelegate.Model) model).p() == ChatMessageDelegate.Direction.OUT) {
            return true;
        }
        return false;
    }
}
