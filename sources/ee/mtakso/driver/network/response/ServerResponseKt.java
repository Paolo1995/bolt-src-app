package ee.mtakso.driver.network.response;

import ee.mtakso.driver.utils.Optional;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class ServerResponseKt {
    public static final <T> T a(DestinationServerResponse<T> destinationServerResponse) {
        Intrinsics.f(destinationServerResponse, "<this>");
        T d8 = destinationServerResponse.d();
        if (d8 != null) {
            return d8;
        }
        throw new NullPointerException("Data is null. " + destinationServerResponse);
    }

    public static final <T> T b(ServerResponse<T> serverResponse) {
        Intrinsics.f(serverResponse, "<this>");
        T d8 = serverResponse.d();
        if (d8 != null) {
            return d8;
        }
        throw new NullPointerException("Data is null. " + serverResponse);
    }

    public static final <T> Optional<T> c(ServerResponse<T> serverResponse) {
        Intrinsics.f(serverResponse, "<this>");
        if (serverResponse.d() == null) {
            Optional<T> a8 = Optional.a();
            Intrinsics.e(a8, "{\n        Optional.empty<T>()\n    }");
            return a8;
        }
        Optional<T> f8 = Optional.f(serverResponse.d());
        Intrinsics.e(f8, "{\n        Optional.of(data)\n    }");
        return f8;
    }
}
