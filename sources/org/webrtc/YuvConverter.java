package org.webrtc;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLException;
import java.nio.ByteBuffer;
import org.webrtc.GlGenericDrawer;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoFrame;

/* loaded from: classes4.dex */
public final class YuvConverter {
    private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    private static final String TAG = "YuvConverter";
    private final GlGenericDrawer drawer;
    private final GlTextureFrameBuffer i420TextureFrameBuffer;
    private final ShaderCallbacks shaderCallbacks;
    private final ThreadUtils.ThreadChecker threadChecker;
    private final VideoFrameDrawer videoFrameDrawer;

    /* loaded from: classes4.dex */
    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private float[] coeffs;
        private int coeffsLoc;
        private float stepSize;
        private int xUnitLoc;
        private static final float[] yCoeffs = {0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
        private static final float[] uCoeffs = {-0.148223f, -0.290993f, 0.439216f, 0.501961f};
        private static final float[] vCoeffs = {0.439216f, -0.367788f, -0.0714274f, 0.501961f};

        private ShaderCallbacks() {
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
            this.xUnitLoc = glShader.getUniformLocation("xUnit");
            this.coeffsLoc = glShader.getUniformLocation("coeffs");
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i8, int i9, int i10, int i11) {
            GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
            int i12 = this.xUnitLoc;
            float f8 = this.stepSize;
            float f9 = i8;
            GLES20.glUniform2f(i12, (fArr[0] * f8) / f9, (f8 * fArr[1]) / f9);
        }

        public void setPlaneU() {
            this.coeffs = uCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneV() {
            this.coeffs = vCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneY() {
            this.coeffs = yCoeffs;
            this.stepSize = 1.0f;
        }
    }

    public YuvConverter() {
        this(new VideoFrameDrawer());
    }

    public YuvConverter(VideoFrameDrawer videoFrameDrawer) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
        ShaderCallbacks shaderCallbacks = new ShaderCallbacks();
        this.shaderCallbacks = shaderCallbacks;
        this.drawer = new GlGenericDrawer(FRAGMENT_SHADER, shaderCallbacks);
        this.videoFrameDrawer = videoFrameDrawer;
        threadChecker.detachThread();
    }

    private VideoFrame.I420Buffer convertInternal(VideoFrame.TextureBuffer textureBuffer) {
        VideoFrame.TextureBuffer textureBuffer2 = (VideoFrame.TextureBuffer) this.videoFrameDrawer.prepareBufferForViewportSize(textureBuffer, textureBuffer.getWidth(), textureBuffer.getHeight());
        int width = textureBuffer2.getWidth();
        int height = textureBuffer2.getHeight();
        int i8 = ((width + 7) / 8) * 8;
        int i9 = (height + 1) / 2;
        int i10 = height + i9;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i8 * i10);
        int i11 = i8 / 4;
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preScale(1.0f, -1.0f);
        matrix.preTranslate(-0.5f, -0.5f);
        this.i420TextureFrameBuffer.setSize(i11, i10);
        GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
        GlUtil.checkNoGLES2Error("glBindFramebuffer");
        this.shaderCallbacks.setPlaneY();
        VideoFrameDrawer.drawTexture(this.drawer, textureBuffer2, matrix, width, height, 0, 0, i11, height);
        this.shaderCallbacks.setPlaneU();
        int i12 = i11 / 2;
        VideoFrameDrawer.drawTexture(this.drawer, textureBuffer2, matrix, width, height, 0, height, i12, i9);
        this.shaderCallbacks.setPlaneV();
        VideoFrameDrawer.drawTexture(this.drawer, textureBuffer2, matrix, width, height, i12, height, i12, i9);
        GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, 5121, nativeAllocateByteBuffer);
        GlUtil.checkNoGLES2Error("YuvConverter.convert");
        GLES20.glBindFramebuffer(36160, 0);
        int i13 = (i8 * height) + 0;
        int i14 = i8 / 2;
        int i15 = i13 + i14;
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i13);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i13);
        int i16 = ((i9 - 1) * i8) + i14;
        nativeAllocateByteBuffer.limit(i13 + i16);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i15);
        nativeAllocateByteBuffer.limit(i15 + i16);
        ByteBuffer slice3 = nativeAllocateByteBuffer.slice();
        textureBuffer2.release();
        return JavaI420Buffer.wrap(width, height, slice, i8, slice2, i8, slice3, i8, new Runnable() { // from class: org.webrtc.b1
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer textureBuffer) {
        try {
            return convertInternal(textureBuffer);
        } catch (GLException e8) {
            Logging.w(TAG, "Failed to convert TextureBuffer", e8);
            return null;
        }
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.drawer.release();
        this.i420TextureFrameBuffer.release();
        this.videoFrameDrawer.release();
        this.threadChecker.detachThread();
    }
}
