package eu.bolt.chat.chatcore.engine;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChatEngineType.kt */
/* loaded from: classes5.dex */
public abstract class ChatEngineType {

    /* compiled from: ChatEngineType.kt */
    /* loaded from: classes5.dex */
    public static final class ChatSdk extends ChatEngineType {

        /* renamed from: a  reason: collision with root package name */
        public static final ChatSdk f38127a = new ChatSdk();

        private ChatSdk() {
            super(null);
        }
    }

    /* compiled from: ChatEngineType.kt */
    /* loaded from: classes5.dex */
    public static final class Default extends ChatEngineType {

        /* renamed from: a  reason: collision with root package name */
        public static final Default f38128a = new Default();

        private Default() {
            super(null);
        }
    }

    private ChatEngineType() {
    }

    public /* synthetic */ ChatEngineType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
