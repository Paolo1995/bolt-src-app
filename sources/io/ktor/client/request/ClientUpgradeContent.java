package io.ktor.client.request;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: ClientUpgradeContent.kt */
/* loaded from: classes5.dex */
public abstract class ClientUpgradeContent extends OutgoingContent.NoContent {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f46604a;

    public ClientUpgradeContent() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ByteChannel>() { // from class: io.ktor.client.request.ClientUpgradeContent$content$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ByteChannel invoke() {
                return ByteChannelKt.b(false, 1, null);
            }
        });
        this.f46604a = b8;
    }
}
