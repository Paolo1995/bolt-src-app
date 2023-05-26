package eu.bolt.driver.chat.ui.routing;

import eu.bolt.driver.chat.ui.screen.conversation.pager.item.OrderHandleUi;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;

/* compiled from: ContactOptionsFromChatCommand.kt */
/* loaded from: classes5.dex */
public final class ContactOptionsFromChatCommand implements RoutingCommand {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandleUi f40585a;

    /* renamed from: b  reason: collision with root package name */
    private final RoutingState f40586b;

    public ContactOptionsFromChatCommand(OrderHandleUi orderHandleUi) {
        this.f40585a = orderHandleUi;
    }

    @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
    public RoutingState a() {
        return RoutingCommand.DefaultImpls.a(this);
    }

    @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
    public RoutingState b() {
        return this.f40586b;
    }

    public final OrderHandleUi c() {
        return this.f40585a;
    }
}
