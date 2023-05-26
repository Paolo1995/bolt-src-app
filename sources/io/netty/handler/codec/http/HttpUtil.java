package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class HttpUtil {
    private static final AsciiString CHARSET_EQUALS = AsciiString.of(((Object) HttpHeaderValues.CHARSET) + "=");
    private static final AsciiString SEMICOLON = AsciiString.cached(";");

    private HttpUtil() {
    }

    public static long getContentLength(HttpMessage httpMessage, long j8) {
        String str = httpMessage.headers().get(HttpHeaderNames.CONTENT_LENGTH);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = getWebSocketContentLength(httpMessage);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }
        return j8;
    }

    private static int getWebSocketContentLength(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        if (httpMessage instanceof HttpRequest) {
            if (HttpMethod.GET.equals(((HttpRequest) httpMessage).method()) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY1) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2)) {
                return 8;
            }
            return -1;
        } else if ((httpMessage instanceof HttpResponse) && ((HttpResponse) httpMessage).status().code() == 101 && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN) && headers.contains(HttpHeaderNames.SEC_WEBSOCKET_LOCATION)) {
            return 16;
        } else {
            return -1;
        }
    }

    public static boolean is100ContinueExpected(HttpMessage httpMessage) {
        if (isExpectHeaderValid(httpMessage) && httpMessage.headers().contains((CharSequence) HttpHeaderNames.EXPECT, (CharSequence) HttpHeaderValues.CONTINUE, true)) {
            return true;
        }
        return false;
    }

    public static boolean isContentLengthSet(HttpMessage httpMessage) {
        return httpMessage.headers().contains(HttpHeaderNames.CONTENT_LENGTH);
    }

    private static boolean isExpectHeaderValid(HttpMessage httpMessage) {
        if ((httpMessage instanceof HttpRequest) && httpMessage.protocolVersion().compareTo(HttpVersion.HTTP_1_1) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean isKeepAlive(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        if (!headers.containsValue(asciiString, HttpHeaderValues.CLOSE, true) && (httpMessage.protocolVersion().isKeepAliveDefault() || httpMessage.headers().containsValue(asciiString, HttpHeaderValues.KEEP_ALIVE, true))) {
            return true;
        }
        return false;
    }

    public static boolean isTransferEncodingChunked(HttpMessage httpMessage) {
        return httpMessage.headers().contains((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (CharSequence) HttpHeaderValues.CHUNKED, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isUnsupportedExpectation(HttpMessage httpMessage) {
        String str;
        if (!isExpectHeaderValid(httpMessage) || (str = httpMessage.headers().get(HttpHeaderNames.EXPECT)) == null || HttpHeaderValues.CONTINUE.toString().equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void setTransferEncodingChunked(HttpMessage httpMessage, boolean z7) {
        if (z7) {
            httpMessage.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
            return;
        }
        List<String> all = httpMessage.headers().getAll(HttpHeaderNames.TRANSFER_ENCODING);
        if (all.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(all);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase((CharSequence) it.next())) {
                it.remove();
            }
        }
        if (arrayList.isEmpty()) {
            httpMessage.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
        } else {
            httpMessage.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Iterable<?>) arrayList);
        }
    }
}
