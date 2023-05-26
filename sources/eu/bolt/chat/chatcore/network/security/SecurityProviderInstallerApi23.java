package eu.bolt.chat.chatcore.network.security;

import io.reactivex.Completable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecurityProviderInstallerApi23.kt */
/* loaded from: classes5.dex */
public final class SecurityProviderInstallerApi23 implements SecurityProviderInstaller {
    @Override // eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller
    public Completable a() {
        Completable g8 = Completable.g();
        Intrinsics.e(g8, "complete()");
        return g8;
    }
}
