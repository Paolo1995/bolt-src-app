package com.mixpanel.android.java_websocket.util;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* loaded from: classes3.dex */
public class Charsetfunctions {

    /* renamed from: a  reason: collision with root package name */
    public static CodingErrorAction f19065a = CodingErrorAction.REPORT;

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static String b(byte[] bArr, int i8, int i9) {
        try {
            return new String(bArr, i8, i9, "ASCII");
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static String c(ByteBuffer byteBuffer) throws InvalidDataException {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(f19065a);
        newDecoder.onUnmappableCharacter(f19065a);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e8) {
            throw new InvalidDataException(1007, e8);
        }
    }

    public static byte[] d(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException(e8);
        }
    }
}
