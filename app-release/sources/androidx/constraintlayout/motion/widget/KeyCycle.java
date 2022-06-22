package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.C0174R;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    /* access modifiers changed from: private */
    public float mAlpha = Float.NaN;
    /* access modifiers changed from: private */
    public int mCurveFit = 0;
    /* access modifiers changed from: private */
    public String mCustomWaveShape = null;
    /* access modifiers changed from: private */
    public float mElevation = Float.NaN;
    /* access modifiers changed from: private */
    public float mProgress = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotation = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotationX = Float.NaN;
    /* access modifiers changed from: private */
    public float mRotationY = Float.NaN;
    /* access modifiers changed from: private */
    public float mScaleX = Float.NaN;
    /* access modifiers changed from: private */
    public float mScaleY = Float.NaN;
    /* access modifiers changed from: private */
    public String mTransitionEasing = null;
    /* access modifiers changed from: private */
    public float mTransitionPathRotate = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationX = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationY = Float.NaN;
    /* access modifiers changed from: private */
    public float mTranslationZ = Float.NaN;
    /* access modifiers changed from: private */
    public float mWaveOffset = 0.0f;
    /* access modifiers changed from: private */
    public float mWavePeriod = Float.NaN;
    /* access modifiers changed from: private */
    public float mWavePhase = 0.0f;
    /* access modifiers changed from: private */
    public int mWaveShape = -1;
    /* access modifiers changed from: private */
    public int mWaveVariesBy = -1;

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap();
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0174R.styleable.KeyCycle));
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (this.mCustomConstraints.size() > 0) {
            for (String str : this.mCustomConstraints.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void addCycleValues(HashMap<String, ViewOscillator> hashMap) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        HashMap<String, ViewOscillator> hashMap2 = hashMap;
        for (String next : hashMap.keySet()) {
            if (next.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.mCustomConstraints.get(next.substring(7));
                if (!(constraintAttribute == null || constraintAttribute.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE || (viewOscillator2 = hashMap2.get(next)) == null)) {
                    viewOscillator2.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(next);
                if (!Float.isNaN(value) && (viewOscillator = hashMap2.get(next)) != null) {
                    viewOscillator.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float getValue(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x0095;
                case -1249320805: goto L_0x008b;
                case -1225497657: goto L_0x0080;
                case -1225497656: goto L_0x0075;
                case -1225497655: goto L_0x006a;
                case -1001078227: goto L_0x005f;
                case -908189618: goto L_0x0055;
                case -908189617: goto L_0x004b;
                case -40300674: goto L_0x0041;
                case -4379043: goto L_0x0037;
                case 37232917: goto L_0x002c;
                case 92909918: goto L_0x0021;
                case 156108012: goto L_0x0015;
                case 1530034690: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x009f
        L_0x0009:
            java.lang.String r0 = "wavePhase"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 12
            goto L_0x00a0
        L_0x0015:
            java.lang.String r0 = "waveOffset"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 11
            goto L_0x00a0
        L_0x0021:
            java.lang.String r0 = "alpha"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 0
            goto L_0x00a0
        L_0x002c:
            java.lang.String r0 = "transitionPathRotate"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 5
            goto L_0x00a0
        L_0x0037:
            java.lang.String r0 = "elevation"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 1
            goto L_0x00a0
        L_0x0041:
            java.lang.String r0 = "rotation"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 2
            goto L_0x00a0
        L_0x004b:
            java.lang.String r0 = "scaleY"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 7
            goto L_0x00a0
        L_0x0055:
            java.lang.String r0 = "scaleX"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 6
            goto L_0x00a0
        L_0x005f:
            java.lang.String r0 = "progress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 13
            goto L_0x00a0
        L_0x006a:
            java.lang.String r0 = "translationZ"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 10
            goto L_0x00a0
        L_0x0075:
            java.lang.String r0 = "translationY"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 9
            goto L_0x00a0
        L_0x0080:
            java.lang.String r0 = "translationX"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 8
            goto L_0x00a0
        L_0x008b:
            java.lang.String r0 = "rotationY"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 4
            goto L_0x00a0
        L_0x0095:
            java.lang.String r0 = "rotationX"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x009f
            r0 = 3
            goto L_0x00a0
        L_0x009f:
            r0 = -1
        L_0x00a0:
            switch(r0) {
                case 0: goto L_0x00e9;
                case 1: goto L_0x00e6;
                case 2: goto L_0x00e3;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00dd;
                case 5: goto L_0x00da;
                case 6: goto L_0x00d7;
                case 7: goto L_0x00d4;
                case 8: goto L_0x00d1;
                case 9: goto L_0x00ce;
                case 10: goto L_0x00cb;
                case 11: goto L_0x00c8;
                case 12: goto L_0x00c5;
                case 13: goto L_0x00c2;
                default: goto L_0x00a3;
            }
        L_0x00a3:
            java.lang.String r0 = "CUSTOM"
            boolean r0 = r3.startsWith(r0)
            if (r0 != 0) goto L_0x00ec
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "  UNKNOWN  "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "WARNING! KeyCycle"
            android.util.Log.v(r0, r3)
            goto L_0x00ec
        L_0x00c2:
            float r3 = r2.mProgress
            return r3
        L_0x00c5:
            float r3 = r2.mWavePhase
            return r3
        L_0x00c8:
            float r3 = r2.mWaveOffset
            return r3
        L_0x00cb:
            float r3 = r2.mTranslationZ
            return r3
        L_0x00ce:
            float r3 = r2.mTranslationY
            return r3
        L_0x00d1:
            float r3 = r2.mTranslationX
            return r3
        L_0x00d4:
            float r3 = r2.mScaleY
            return r3
        L_0x00d7:
            float r3 = r2.mScaleX
            return r3
        L_0x00da:
            float r3 = r2.mTransitionPathRotate
            return r3
        L_0x00dd:
            float r3 = r2.mRotationY
            return r3
        L_0x00e0:
            float r3 = r2.mRotationX
            return r3
        L_0x00e3:
            float r3 = r2.mRotation
            return r3
        L_0x00e6:
            float r3 = r2.mElevation
            return r3
        L_0x00e9:
            float r3 = r2.mAlpha
            return r3
        L_0x00ec:
            r3 = 2143289344(0x7fc00000, float:NaN)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyCycle.getValue(java.lang.String):float");
    }

    public void addValues(HashMap<String, ViewSpline> hashMap) {
        Debug.logStack(TypedValues.CycleType.NAME, "add " + hashMap.size() + " values", 2);
        for (String next : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(next);
            if (splineSet != null) {
                char c = 65535;
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c = 8;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c = 9;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c = 10;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c = 13;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (next.equals(Key.ROTATION)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 156108012:
                        if (next.equals("waveOffset")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (next.equals("wavePhase")) {
                            c = 12;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        splineSet.setPoint(this.mFramePosition, this.mAlpha);
                        break;
                    case 1:
                        splineSet.setPoint(this.mFramePosition, this.mElevation);
                        break;
                    case 2:
                        splineSet.setPoint(this.mFramePosition, this.mRotation);
                        break;
                    case 3:
                        splineSet.setPoint(this.mFramePosition, this.mRotationX);
                        break;
                    case 4:
                        splineSet.setPoint(this.mFramePosition, this.mRotationY);
                        break;
                    case 5:
                        splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                        break;
                    case 6:
                        splineSet.setPoint(this.mFramePosition, this.mScaleX);
                        break;
                    case 7:
                        splineSet.setPoint(this.mFramePosition, this.mScaleY);
                        break;
                    case 8:
                        splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                        break;
                    case 9:
                        splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                        break;
                    case 10:
                        splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                        break;
                    case 11:
                        splineSet.setPoint(this.mFramePosition, this.mWaveOffset);
                        break;
                    case 12:
                        splineSet.setPoint(this.mFramePosition, this.mWavePhase);
                        break;
                    case 13:
                        splineSet.setPoint(this.mFramePosition, this.mProgress);
                        break;
                    default:
                        if (next.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + next);
                            break;
                        }
                }
            }
        }
    }

    private static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_PHASE = 21;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0174R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(C0174R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(C0174R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(C0174R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(C0174R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(C0174R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(C0174R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(C0174R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(C0174R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(C0174R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(C0174R.styleable.KeyCycle_motionProgress, 20);
            mAttrMap.append(C0174R.styleable.KeyCycle_wavePhase, 21);
        }

        /* access modifiers changed from: private */
        public static void read(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                                break;
                            } else {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            if (keyCycle.mTargetId != -1) {
                                break;
                            } else {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                        break;
                    case 3:
                        String unused = keyCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 4:
                        int unused2 = keyCycle.mCurveFit = typedArray.getInteger(index, keyCycle.mCurveFit);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type != 3) {
                            int unused3 = keyCycle.mWaveShape = typedArray.getInt(index, keyCycle.mWaveShape);
                            break;
                        } else {
                            String unused4 = keyCycle.mCustomWaveShape = typedArray.getString(index);
                            int unused5 = keyCycle.mWaveShape = 7;
                            break;
                        }
                    case 6:
                        float unused6 = keyCycle.mWavePeriod = typedArray.getFloat(index, keyCycle.mWavePeriod);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused7 = keyCycle.mWaveOffset = typedArray.getFloat(index, keyCycle.mWaveOffset);
                            break;
                        } else {
                            float unused8 = keyCycle.mWaveOffset = typedArray.getDimension(index, keyCycle.mWaveOffset);
                            break;
                        }
                    case 8:
                        int unused9 = keyCycle.mWaveVariesBy = typedArray.getInt(index, keyCycle.mWaveVariesBy);
                        break;
                    case 9:
                        float unused10 = keyCycle.mAlpha = typedArray.getFloat(index, keyCycle.mAlpha);
                        break;
                    case 10:
                        float unused11 = keyCycle.mElevation = typedArray.getDimension(index, keyCycle.mElevation);
                        break;
                    case 11:
                        float unused12 = keyCycle.mRotation = typedArray.getFloat(index, keyCycle.mRotation);
                        break;
                    case 12:
                        float unused13 = keyCycle.mRotationX = typedArray.getFloat(index, keyCycle.mRotationX);
                        break;
                    case 13:
                        float unused14 = keyCycle.mRotationY = typedArray.getFloat(index, keyCycle.mRotationY);
                        break;
                    case 14:
                        float unused15 = keyCycle.mTransitionPathRotate = typedArray.getFloat(index, keyCycle.mTransitionPathRotate);
                        break;
                    case 15:
                        float unused16 = keyCycle.mScaleX = typedArray.getFloat(index, keyCycle.mScaleX);
                        break;
                    case 16:
                        float unused17 = keyCycle.mScaleY = typedArray.getFloat(index, keyCycle.mScaleY);
                        break;
                    case 17:
                        float unused18 = keyCycle.mTranslationX = typedArray.getDimension(index, keyCycle.mTranslationX);
                        break;
                    case 18:
                        float unused19 = keyCycle.mTranslationY = typedArray.getDimension(index, keyCycle.mTranslationY);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused20 = keyCycle.mTranslationZ = typedArray.getDimension(index, keyCycle.mTranslationZ);
                            break;
                        }
                    case 20:
                        float unused21 = keyCycle.mProgress = typedArray.getFloat(index, keyCycle.mProgress);
                        break;
                    case 21:
                        float unused22 = keyCycle.mWavePhase = typedArray.getFloat(index, keyCycle.mWavePhase) / 360.0f;
                        break;
                    default:
                        Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.String r3, java.lang.Object r4) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 7
            switch(r0) {
                case -1913008125: goto L_0x00c6;
                case -1812823328: goto L_0x00bb;
                case -1249320806: goto L_0x00b1;
                case -1249320805: goto L_0x00a7;
                case -1225497657: goto L_0x009c;
                case -1225497656: goto L_0x0091;
                case -1225497655: goto L_0x0086;
                case -908189618: goto L_0x007c;
                case -908189617: goto L_0x0071;
                case -40300674: goto L_0x0067;
                case -4379043: goto L_0x005c;
                case 37232917: goto L_0x0050;
                case 92909918: goto L_0x0045;
                case 156108012: goto L_0x0039;
                case 184161818: goto L_0x002d;
                case 579057826: goto L_0x0022;
                case 1530034690: goto L_0x0016;
                case 1532805160: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x00d0
        L_0x000a:
            java.lang.String r0 = "waveShape"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 17
            goto L_0x00d1
        L_0x0016:
            java.lang.String r0 = "wavePhase"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 16
            goto L_0x00d1
        L_0x0022:
            java.lang.String r0 = "curveFit"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 1
            goto L_0x00d1
        L_0x002d:
            java.lang.String r0 = "wavePeriod"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 14
            goto L_0x00d1
        L_0x0039:
            java.lang.String r0 = "waveOffset"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 15
            goto L_0x00d1
        L_0x0045:
            java.lang.String r0 = "alpha"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 0
            goto L_0x00d1
        L_0x0050:
            java.lang.String r0 = "transitionPathRotate"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 10
            goto L_0x00d1
        L_0x005c:
            java.lang.String r0 = "elevation"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 2
            goto L_0x00d1
        L_0x0067:
            java.lang.String r0 = "rotation"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 4
            goto L_0x00d1
        L_0x0071:
            java.lang.String r0 = "scaleY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 8
            goto L_0x00d1
        L_0x007c:
            java.lang.String r0 = "scaleX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 7
            goto L_0x00d1
        L_0x0086:
            java.lang.String r0 = "translationZ"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 13
            goto L_0x00d1
        L_0x0091:
            java.lang.String r0 = "translationY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 12
            goto L_0x00d1
        L_0x009c:
            java.lang.String r0 = "translationX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 11
            goto L_0x00d1
        L_0x00a7:
            java.lang.String r0 = "rotationY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 6
            goto L_0x00d1
        L_0x00b1:
            java.lang.String r0 = "rotationX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 5
            goto L_0x00d1
        L_0x00bb:
            java.lang.String r0 = "transitionEasing"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 9
            goto L_0x00d1
        L_0x00c6:
            java.lang.String r0 = "motionProgress"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x00d0
            r3 = 3
            goto L_0x00d1
        L_0x00d0:
            r3 = -1
        L_0x00d1:
            switch(r3) {
                case 0: goto L_0x015e;
                case 1: goto L_0x0157;
                case 2: goto L_0x0150;
                case 3: goto L_0x0149;
                case 4: goto L_0x0142;
                case 5: goto L_0x013b;
                case 6: goto L_0x0134;
                case 7: goto L_0x012d;
                case 8: goto L_0x0126;
                case 9: goto L_0x011f;
                case 10: goto L_0x0118;
                case 11: goto L_0x0111;
                case 12: goto L_0x010a;
                case 13: goto L_0x0103;
                case 14: goto L_0x00fc;
                case 15: goto L_0x00f4;
                case 16: goto L_0x00ec;
                case 17: goto L_0x00d6;
                default: goto L_0x00d4;
            }
        L_0x00d4:
            goto L_0x0164
        L_0x00d6:
            boolean r3 = r4 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x00e2
            int r3 = r2.toInt(r4)
            r2.mWaveShape = r3
            goto L_0x0164
        L_0x00e2:
            r2.mWaveShape = r1
            java.lang.String r3 = r4.toString()
            r2.mCustomWaveShape = r3
            goto L_0x0164
        L_0x00ec:
            float r3 = r2.toFloat(r4)
            r2.mWavePhase = r3
            goto L_0x0164
        L_0x00f4:
            float r3 = r2.toFloat(r4)
            r2.mWaveOffset = r3
            goto L_0x0164
        L_0x00fc:
            float r3 = r2.toFloat(r4)
            r2.mWavePeriod = r3
            goto L_0x0164
        L_0x0103:
            float r3 = r2.toFloat(r4)
            r2.mTranslationZ = r3
            goto L_0x0164
        L_0x010a:
            float r3 = r2.toFloat(r4)
            r2.mTranslationY = r3
            goto L_0x0164
        L_0x0111:
            float r3 = r2.toFloat(r4)
            r2.mTranslationX = r3
            goto L_0x0164
        L_0x0118:
            float r3 = r2.toFloat(r4)
            r2.mTransitionPathRotate = r3
            goto L_0x0164
        L_0x011f:
            java.lang.String r3 = r4.toString()
            r2.mTransitionEasing = r3
            goto L_0x0164
        L_0x0126:
            float r3 = r2.toFloat(r4)
            r2.mScaleY = r3
            goto L_0x0164
        L_0x012d:
            float r3 = r2.toFloat(r4)
            r2.mScaleX = r3
            goto L_0x0164
        L_0x0134:
            float r3 = r2.toFloat(r4)
            r2.mRotationY = r3
            goto L_0x0164
        L_0x013b:
            float r3 = r2.toFloat(r4)
            r2.mRotationX = r3
            goto L_0x0164
        L_0x0142:
            float r3 = r2.toFloat(r4)
            r2.mRotation = r3
            goto L_0x0164
        L_0x0149:
            float r3 = r2.toFloat(r4)
            r2.mProgress = r3
            goto L_0x0164
        L_0x0150:
            float r3 = r2.toFloat(r4)
            r2.mElevation = r3
            goto L_0x0164
        L_0x0157:
            int r3 = r2.toInt(r4)
            r2.mCurveFit = r3
            goto L_0x0164
        L_0x015e:
            float r3 = r2.toFloat(r4)
            r2.mAlpha = r3
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyCycle.setValue(java.lang.String, java.lang.Object):void");
    }

    public Key copy(Key key) {
        super.copy(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.mTransitionEasing = keyCycle.mTransitionEasing;
        this.mCurveFit = keyCycle.mCurveFit;
        this.mWaveShape = keyCycle.mWaveShape;
        this.mCustomWaveShape = keyCycle.mCustomWaveShape;
        this.mWavePeriod = keyCycle.mWavePeriod;
        this.mWaveOffset = keyCycle.mWaveOffset;
        this.mWavePhase = keyCycle.mWavePhase;
        this.mProgress = keyCycle.mProgress;
        this.mWaveVariesBy = keyCycle.mWaveVariesBy;
        this.mAlpha = keyCycle.mAlpha;
        this.mElevation = keyCycle.mElevation;
        this.mRotation = keyCycle.mRotation;
        this.mTransitionPathRotate = keyCycle.mTransitionPathRotate;
        this.mRotationX = keyCycle.mRotationX;
        this.mRotationY = keyCycle.mRotationY;
        this.mScaleX = keyCycle.mScaleX;
        this.mScaleY = keyCycle.mScaleY;
        this.mTranslationX = keyCycle.mTranslationX;
        this.mTranslationY = keyCycle.mTranslationY;
        this.mTranslationZ = keyCycle.mTranslationZ;
        return this;
    }

    public Key clone() {
        return new KeyCycle().copy(this);
    }
}
