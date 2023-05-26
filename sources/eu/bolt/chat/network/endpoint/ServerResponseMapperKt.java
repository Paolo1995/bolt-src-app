package eu.bolt.chat.network.endpoint;

import eu.bolt.chat.network.data.ServerResponse;
import eu.bolt.chat.util.Outcome;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponseMapper.kt */
/* loaded from: classes5.dex */
public final class ServerResponseMapperKt {
    public static final <T, R> Outcome<R, EndpointError> a(ServerResponse<T> serverResponse, Function1<? super T, ? extends R> mapper) {
        Intrinsics.f(serverResponse, "<this>");
        Intrinsics.f(mapper, "mapper");
        if (serverResponse.a() == 0 && serverResponse.b() != null) {
            return new Outcome.Success(mapper.invoke(serverResponse.b()));
        }
        if (serverResponse.a() == 0) {
            return new Outcome.Failure(EndpointError.f39364a.a(-1, "Empty payload"));
        }
        return new Outcome.Failure(EndpointError.f39364a.a(serverResponse.a(), serverResponse.c()));
    }
}
