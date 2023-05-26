package eu.bolt.driver.chat.service.id;

import eu.bolt.chat.tools.uniqueid.IdGenerator;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatIdGenerator.kt */
/* loaded from: classes5.dex */
public final class ChatIdGenerator implements IdGenerator {
    @Override // eu.bolt.chat.tools.uniqueid.IdGenerator
    public String a() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.e(uuid, "randomUUID().toString()");
        return uuid;
    }
}
