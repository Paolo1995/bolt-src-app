package eu.bolt.verification.sdk.internal;

import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface pe {

    /* loaded from: classes5.dex */
    public static final class a {
        public static void a(pe peVar, List<? extends je> permissions) {
            Intrinsics.f(permissions, "permissions");
        }
    }

    void k(List<? extends je> list);

    Single<Boolean> l(List<? extends je> list);
}
