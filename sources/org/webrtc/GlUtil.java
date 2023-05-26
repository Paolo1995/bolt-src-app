package org.webrtc;

import android.opengl.GLES20;
import android.opengl.GLException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes4.dex */
public class GlUtil {

    /* loaded from: classes4.dex */
    public static class GlOutOfMemoryException extends GLException {
        public GlOutOfMemoryException(int i8, String str) {
            super(i8, str);
        }
    }

    private GlUtil() {
    }

    public static void checkNoGLES2Error(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            if (glGetError == 1285) {
                throw new GlOutOfMemoryException(glGetError, str);
            }
            throw new GLException(glGetError, str + ": GLES20 error: " + glGetError);
        }
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int generateTexture(int i8) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i9 = iArr[0];
        GLES20.glBindTexture(i8, i9);
        GLES20.glTexParameterf(i8, 10241, 9729.0f);
        GLES20.glTexParameterf(i8, 10240, 9729.0f);
        GLES20.glTexParameterf(i8, 10242, 33071.0f);
        GLES20.glTexParameterf(i8, 10243, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return i9;
    }
}
