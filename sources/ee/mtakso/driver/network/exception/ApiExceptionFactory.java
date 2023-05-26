package ee.mtakso.driver.network.exception;

import ee.mtakso.driver.network.response.BasicServerResponse;
import ee.mtakso.driver.network.response.DestinationServerResponse;
import ee.mtakso.driver.network.response.DestinationValidationError;
import ee.mtakso.driver.network.response.EmptyDestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ErrorData;
import ee.mtakso.driver.network.response.ServerResponse;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiExceptionFactory.kt */
/* loaded from: classes3.dex */
public final class ApiExceptionFactory {
    private final ApiException b(String str, BasicServerResponse basicServerResponse) {
        ApiException invalidDestinationRequestException;
        if (basicServerResponse instanceof EmptyServerResponse) {
            int a8 = basicServerResponse.a();
            ErrorData b8 = basicServerResponse.b();
            String c8 = basicServerResponse.c();
            List<Object> d8 = ((EmptyServerResponse) basicServerResponse).d();
            if (d8 == null) {
                d8 = CollectionsKt__CollectionsKt.k();
            }
            invalidDestinationRequestException = new InvalidRequestException(a8, b8, c8, str, d8);
        } else if (basicServerResponse instanceof ServerResponse) {
            int a9 = basicServerResponse.a();
            ErrorData b9 = basicServerResponse.b();
            String c9 = basicServerResponse.c();
            List<Object> e8 = ((ServerResponse) basicServerResponse).e();
            if (e8 == null) {
                e8 = CollectionsKt__CollectionsKt.k();
            }
            invalidDestinationRequestException = new InvalidRequestException(a9, b9, c9, str, e8);
        } else if (basicServerResponse instanceof DestinationServerResponse) {
            int a10 = basicServerResponse.a();
            ErrorData b10 = basicServerResponse.b();
            String c10 = basicServerResponse.c();
            List<DestinationValidationError> e9 = ((DestinationServerResponse) basicServerResponse).e();
            if (e9 == null) {
                e9 = CollectionsKt__CollectionsKt.k();
            }
            invalidDestinationRequestException = new InvalidDestinationRequestException(a10, b10, c10, str, e9);
        } else if (basicServerResponse instanceof EmptyDestinationServerResponse) {
            int a11 = basicServerResponse.a();
            ErrorData b11 = basicServerResponse.b();
            String c11 = basicServerResponse.c();
            List<DestinationValidationError> d9 = ((EmptyDestinationServerResponse) basicServerResponse).d();
            if (d9 == null) {
                d9 = CollectionsKt__CollectionsKt.k();
            }
            invalidDestinationRequestException = new InvalidDestinationRequestException(a11, b11, c11, str, d9);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return invalidDestinationRequestException;
    }

    public final ApiException a(String path, BasicServerResponse response) {
        Intrinsics.f(path, "path");
        Intrinsics.f(response, "response");
        int a8 = response.a();
        if (a8 != 0) {
            if (a8 != 702) {
                return new ApiException(a8, response.b(), response.c(), path);
            }
            return b(path, response);
        }
        return null;
    }
}
