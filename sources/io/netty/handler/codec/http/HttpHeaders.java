package io.netty.handler.codec.http;

import io.netty.handler.codec.HeadersUtils;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class HttpHeaders implements Iterable<Map.Entry<String, String>> {
    @Deprecated
    public static final HttpHeaders EMPTY_HEADERS = EmptyHttpHeaders.instance();

    private static boolean containsCommaSeparatedTrimmed(CharSequence charSequence, CharSequence charSequence2, boolean z7) {
        if (z7) {
            int indexOf = AsciiString.indexOf(charSequence, ',', 0);
            if (indexOf == -1) {
                if (AsciiString.contentEqualsIgnoreCase(AsciiString.trim(charSequence), charSequence2)) {
                    return true;
                }
            } else {
                int i8 = 0;
                while (!AsciiString.contentEqualsIgnoreCase(AsciiString.trim(charSequence.subSequence(i8, indexOf)), charSequence2)) {
                    i8 = indexOf + 1;
                    indexOf = AsciiString.indexOf(charSequence, ',', i8);
                    if (indexOf == -1) {
                        if (i8 < charSequence.length() && AsciiString.contentEqualsIgnoreCase(AsciiString.trim(charSequence.subSequence(i8, charSequence.length())), charSequence2)) {
                            return true;
                        }
                    }
                }
                return true;
            }
        } else {
            int indexOf2 = AsciiString.indexOf(charSequence, ',', 0);
            if (indexOf2 == -1) {
                if (AsciiString.contentEquals(AsciiString.trim(charSequence), charSequence2)) {
                    return true;
                }
            } else {
                int i9 = 0;
                while (!AsciiString.contentEquals(AsciiString.trim(charSequence.subSequence(i9, indexOf2)), charSequence2)) {
                    i9 = indexOf2 + 1;
                    indexOf2 = AsciiString.indexOf(charSequence, ',', i9);
                    if (indexOf2 == -1) {
                        if (i9 < charSequence.length() && AsciiString.contentEquals(AsciiString.trim(charSequence.subSequence(i9, charSequence.length())), charSequence2)) {
                            return true;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public HttpHeaders add(CharSequence charSequence, Object obj) {
        return add(charSequence.toString(), obj);
    }

    public abstract HttpHeaders add(String str, Object obj);

    public abstract HttpHeaders clear();

    public boolean contains(CharSequence charSequence) {
        return contains(charSequence.toString());
    }

    public abstract boolean contains(String str);

    public boolean containsValue(CharSequence charSequence, CharSequence charSequence2, boolean z7) {
        Iterator<? extends CharSequence> valueCharSequenceIterator = valueCharSequenceIterator(charSequence);
        while (valueCharSequenceIterator.hasNext()) {
            if (containsCommaSeparatedTrimmed(valueCharSequenceIterator.next(), charSequence2, z7)) {
                return true;
            }
        }
        return false;
    }

    public HttpHeaders copy() {
        return new DefaultHttpHeaders().set(this);
    }

    public String get(CharSequence charSequence) {
        return get(charSequence.toString());
    }

    public abstract String get(String str);

    public List<String> getAll(CharSequence charSequence) {
        return getAll(charSequence.toString());
    }

    public abstract List<String> getAll(String str);

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    @Deprecated
    public abstract Iterator<Map.Entry<String, String>> iterator();

    public abstract Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence();

    public HttpHeaders remove(CharSequence charSequence) {
        return remove(charSequence.toString());
    }

    public abstract HttpHeaders remove(String str);

    public HttpHeaders set(CharSequence charSequence, Object obj) {
        return set(charSequence.toString(), obj);
    }

    public abstract HttpHeaders set(String str, Iterable<?> iterable);

    public abstract HttpHeaders set(String str, Object obj);

    public abstract int size();

    public String toString() {
        return HeadersUtils.toString(getClass(), iteratorCharSequence(), size());
    }

    public Iterator<? extends CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return valueStringIterator(charSequence);
    }

    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        return getAll(charSequence).iterator();
    }

    public HttpHeaders add(HttpHeaders httpHeaders) {
        ObjectUtil.checkNotNull(httpHeaders, "headers");
        Iterator<Map.Entry<String, String>> it = httpHeaders.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            add(next.getKey(), (Object) next.getValue());
        }
        return this;
    }

    public boolean contains(String str, String str2, boolean z7) {
        Iterator<String> valueStringIterator = valueStringIterator(str);
        if (z7) {
            while (valueStringIterator.hasNext()) {
                if (valueStringIterator.next().equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        }
        while (valueStringIterator.hasNext()) {
            if (valueStringIterator.next().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public HttpHeaders set(CharSequence charSequence, Iterable<?> iterable) {
        return set(charSequence.toString(), iterable);
    }

    public HttpHeaders set(HttpHeaders httpHeaders) {
        ObjectUtil.checkNotNull(httpHeaders, "headers");
        clear();
        if (httpHeaders.isEmpty()) {
            return this;
        }
        Iterator<Map.Entry<String, String>> it = httpHeaders.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            add(next.getKey(), (Object) next.getValue());
        }
        return this;
    }

    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z7) {
        return contains(charSequence.toString(), charSequence2.toString(), z7);
    }
}
