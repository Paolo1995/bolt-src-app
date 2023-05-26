package eu.bolt.client.chatdb.repo;

import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessageDBModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalChatTerminalInfoRepoImpl.kt */
/* loaded from: classes5.dex */
public final class LocalChatTerminalInfoRepoImplKt {
    public static final TerminationInfo a(TerminalMessageDBModel terminalMessageDBModel) {
        Intrinsics.f(terminalMessageDBModel, "<this>");
        return new TerminationInfo(terminalMessageDBModel.c(), terminalMessageDBModel.a(), terminalMessageDBModel.d(), terminalMessageDBModel.e(), terminalMessageDBModel.b());
    }
}
