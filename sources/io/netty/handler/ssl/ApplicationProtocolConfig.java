package io.netty.handler.ssl;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class ApplicationProtocolConfig {
    public static final ApplicationProtocolConfig DISABLED = new ApplicationProtocolConfig();
    private final List<String> supportedProtocols = Collections.emptyList();
    private final Protocol protocol = Protocol.NONE;
    private final SelectorFailureBehavior selectorBehavior = SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
    private final SelectedListenerFailureBehavior selectedBehavior = SelectedListenerFailureBehavior.ACCEPT;

    /* loaded from: classes5.dex */
    public enum Protocol {
        NONE,
        NPN,
        ALPN,
        NPN_AND_ALPN
    }

    /* loaded from: classes5.dex */
    public enum SelectedListenerFailureBehavior {
        ACCEPT,
        FATAL_ALERT,
        CHOOSE_MY_LAST_PROTOCOL
    }

    /* loaded from: classes5.dex */
    public enum SelectorFailureBehavior {
        FATAL_ALERT,
        NO_ADVERTISE,
        CHOOSE_MY_LAST_PROTOCOL
    }

    private ApplicationProtocolConfig() {
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return this.selectedBehavior;
    }

    public SelectorFailureBehavior selectorFailureBehavior() {
        return this.selectorBehavior;
    }

    public List<String> supportedProtocols() {
        return this.supportedProtocols;
    }
}
