package ee.mtakso.driver.utils.ext;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.network.exception.HttpTransportException;
import ee.mtakso.driver.network.exception.InvalidDestinationRequestException;
import ee.mtakso.driver.network.response.DestinationValidationError;
import ee.mtakso.driver.service.token.UnavailableAccessTokenException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThrowableExt.kt */
/* loaded from: classes5.dex */
public final class ApiExceptionUtils {
    private static final Throwable a(Throwable th) {
        if (th instanceof UnavailableAccessTokenException) {
            return ((UnavailableAccessTokenException) th).getCause();
        }
        return th;
    }

    public static final int b(Throwable th) {
        Intrinsics.f(th, "<this>");
        if (!(th instanceof ApiException)) {
            return -1;
        }
        return ((ApiException) th).c();
    }

    private static final String c(Throwable th, Context context) {
        if (!(th instanceof ApiException)) {
            return null;
        }
        ApiException apiException = (ApiException) th;
        String e8 = apiException.e();
        if (e8 == null) {
            int c8 = apiException.c();
            if (c8 == 0) {
                return null;
            }
            if (c8 != 237) {
                if (c8 != 402) {
                    if (c8 != 412) {
                        if (c8 != 424) {
                            if (c8 != 503) {
                                if (c8 != 17000) {
                                    if (c8 != 100) {
                                        if (c8 != 101) {
                                            if (c8 != 999 && c8 != 1000) {
                                                if (c8 != 9003) {
                                                    if (c8 != 9004) {
                                                        switch (c8) {
                                                            case 10:
                                                                return context.getString(R.string.bad_credentials);
                                                            case 11:
                                                                return context.getString(R.string.bad_credentials);
                                                            case 12:
                                                                return context.getString(R.string.invalidPhoneNumberError);
                                                            case 13:
                                                                return context.getString(R.string.invalidEmailError);
                                                            case 14:
                                                                return context.getString(R.string.bad_credentials);
                                                            case 15:
                                                                return context.getString(R.string.emailAlreadyTakenError);
                                                            case 16:
                                                                return context.getString(R.string.phoneNumberAlreadyTakenError);
                                                            case 17:
                                                                return context.getString(R.string.registrationCodeNotFoundError);
                                                            case 18:
                                                                return context.getString(R.string.tooManyUserPassResetsError);
                                                            case 19:
                                                                return context.getString(R.string.sendingSmsFailedError);
                                                            case 20:
                                                                return context.getString(R.string.resendSmsFailedError);
                                                            case 21:
                                                                return context.getString(R.string.invalidPhoneUUIDError);
                                                            case 22:
                                                            case 23:
                                                                return context.getString(R.string.userIsBlockedError);
                                                            case 24:
                                                                return context.getString(R.string.driverNotApprovedError);
                                                            case 25:
                                                                return context.getString(R.string.bad_credentials);
                                                            default:
                                                                switch (c8) {
                                                                    case 200:
                                                                        return context.getString(R.string.bad_credentials);
                                                                    case 201:
                                                                        return context.getString(R.string.driverNotAvailableError);
                                                                    case 202:
                                                                        return context.getString(R.string.orderNotAvailableError);
                                                                    case 203:
                                                                        return context.getString(R.string.waitBeforeNextNotificationError);
                                                                    default:
                                                                        return null;
                                                                }
                                                        }
                                                    }
                                                    return context.getString(R.string.error_destinations_quota_exceeded);
                                                }
                                                return context.getString(R.string.error_destinations_not_allowed);
                                            }
                                            return context.getString(R.string.serverSideError);
                                        }
                                        return context.getString(R.string.orderNotFoundError);
                                    }
                                    return context.getString(R.string.invalidRatingError);
                                }
                                return context.getString(R.string.error_destination_type_already_exists);
                            }
                            return context.getString(R.string.unauthorizedError);
                        }
                        return context.getString(R.string.too_fast_switch_to_driving_with_client);
                    }
                    return context.getString(R.string.no_car_selected);
                }
                return context.getString(R.string.noDrivePriceFuncError);
            }
            return context.getString(R.string.error_device_model_not_supported);
        }
        return e8;
    }

    private static final String d(Throwable th, Context context) {
        if (th instanceof ApiException) {
            return context.getString(R.string.error);
        }
        return null;
    }

    public static final DestinationValidationError e(Throwable th) {
        Intrinsics.f(th, "<this>");
        if (!(th instanceof InvalidDestinationRequestException)) {
            return null;
        }
        return (DestinationValidationError) CollectionsKt___CollectionsKt.Y(((InvalidDestinationRequestException) th).g());
    }

    private static final String f(Throwable th, Context context) {
        String str;
        if (!(th instanceof InvalidDestinationRequestException)) {
            return null;
        }
        InvalidDestinationRequestException invalidDestinationRequestException = (InvalidDestinationRequestException) th;
        String e8 = invalidDestinationRequestException.e();
        if (e8 == null) {
            DestinationValidationError destinationValidationError = (DestinationValidationError) CollectionsKt___CollectionsKt.Y(invalidDestinationRequestException.g());
            if (destinationValidationError != null) {
                str = destinationValidationError.a();
            } else {
                str = null;
            }
            if (str == null) {
                return null;
            }
            int hashCode = str.hashCode();
            if (hashCode != -1910919878) {
                if (hashCode != -210089684) {
                    if (hashCode != 1862381937 || !str.equals("close_to_destination")) {
                        return null;
                    }
                    return context.getString(R.string.error_destination_too_close);
                } else if (!str.equals("too_far_from_destination")) {
                    return null;
                } else {
                    return context.getString(R.string.error_destination_too_far);
                }
            } else if (!str.equals("quota_exceeded")) {
                return null;
            } else {
                return context.getString(R.string.error_set_destination_quota_exceeded);
            }
        }
        return e8;
    }

    private static final String g(Throwable th, Context context) {
        if (th instanceof InvalidDestinationRequestException) {
            return context.getString(R.string.error);
        }
        return null;
    }

    public static final int h(Throwable th) {
        Intrinsics.f(th, "<this>");
        Throwable a8 = a(th);
        if (!(a8 instanceof HttpTransportException) && ((a8 instanceof InvalidDestinationRequestException) || (a8 instanceof ApiException))) {
            return R.drawable.ic_error;
        }
        return 0;
    }

    private static final String i(Throwable th, Context context) {
        if (th instanceof HttpTransportException) {
            return context.getString(R.string.error_not_internet_connection_message);
        }
        return null;
    }

    private static final String j(Throwable th, Context context) {
        if (th instanceof HttpTransportException) {
            return context.getString(R.string.error_not_internet_connection_title);
        }
        return null;
    }

    public static final String k(Throwable th, Context context) {
        Intrinsics.f(th, "<this>");
        Intrinsics.f(context, "context");
        Throwable a8 = a(th);
        String i8 = i(a8, context);
        if (i8 != null) {
            return i8;
        }
        String f8 = f(a8, context);
        if (f8 != null) {
            return f8;
        }
        String c8 = c(a8, context);
        if (c8 != null) {
            return c8;
        }
        String string = context.getString(R.string.unkown_error_desc);
        Intrinsics.e(string, "context.getString(R.string.unkown_error_desc)");
        return string;
    }

    public static final String l(Throwable th, Context context) {
        Intrinsics.f(th, "<this>");
        Intrinsics.f(context, "context");
        Throwable a8 = a(th);
        String j8 = j(a8, context);
        if (j8 != null) {
            return j8;
        }
        String g8 = g(a8, context);
        if (g8 != null) {
            return g8;
        }
        String d8 = d(a8, context);
        if (d8 != null) {
            return d8;
        }
        String string = context.getString(R.string.error_default_title);
        Intrinsics.e(string, "context.getString(R.string.error_default_title)");
        return string;
    }

    public static final boolean m(Throwable th, int... errorCodes) {
        Intrinsics.f(th, "<this>");
        Intrinsics.f(errorCodes, "errorCodes");
        return ArraysKt.x(errorCodes, b(th));
    }
}
