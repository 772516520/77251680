package com.i77251680.entity.proto;

public final class Tlv52D {
    private Tlv52D() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface bufOrBuilder extends
            // @@protoc_insertion_point(interface_extends:buf)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required string bootloader = 1;</code>
         *
         * @return Whether the bootloader field is set.
         */
        boolean hasBootloader();

        /**
         * <code>required string bootloader = 1;</code>
         *
         * @return The bootloader.
         */
        java.lang.String getBootloader();

        /**
         * <code>required string bootloader = 1;</code>
         *
         * @return The bytes for bootloader.
         */
        com.google.protobuf.ByteString
        getBootloaderBytes();

        /**
         * <code>required string proc_version = 2;</code>
         *
         * @return Whether the procVersion field is set.
         */
        boolean hasProcVersion();

        /**
         * <code>required string proc_version = 2;</code>
         *
         * @return The procVersion.
         */
        java.lang.String getProcVersion();

        /**
         * <code>required string proc_version = 2;</code>
         *
         * @return The bytes for procVersion.
         */
        com.google.protobuf.ByteString
        getProcVersionBytes();

        /**
         * <code>required string version_codename = 3;</code>
         *
         * @return Whether the versionCodename field is set.
         */
        boolean hasVersionCodename();

        /**
         * <code>required string version_codename = 3;</code>
         *
         * @return The versionCodename.
         */
        java.lang.String getVersionCodename();

        /**
         * <code>required string version_codename = 3;</code>
         *
         * @return The bytes for versionCodename.
         */
        com.google.protobuf.ByteString
        getVersionCodenameBytes();

        /**
         * <code>required int64 version_incremental = 4;</code>
         *
         * @return Whether the versionIncremental field is set.
         */
        boolean hasVersionIncremental4();

        /**
         * <code>required int64 version_incremental = 4;</code>
         *
         * @return The versionIncremental.
         */
        long getVersionIncremental4();

        /**
         * <code>required string fingerprint = 5;</code>
         *
         * @return Whether the fingerprint field is set.
         */
        boolean hasFingerprint();

        /**
         * <code>required string fingerprint = 5;</code>
         *
         * @return The fingerprint.
         */
        java.lang.String getFingerprint();

        /**
         * <code>required string fingerprint = 5;</code>
         *
         * @return The bytes for fingerprint.
         */
        com.google.protobuf.ByteString
        getFingerprintBytes();

        /**
         * <code>required string boot_id = 6;</code>
         *
         * @return Whether the bootId field is set.
         */
        boolean hasBootId();

        /**
         * <code>required string boot_id = 6;</code>
         *
         * @return The bootId.
         */
        java.lang.String getBootId();

        /**
         * <code>required string boot_id = 6;</code>
         *
         * @return The bytes for bootId.
         */
        com.google.protobuf.ByteString
        getBootIdBytes();

        /**
         * <code>required string android_id = 7;</code>
         *
         * @return Whether the androidId field is set.
         */
        boolean hasAndroidId();

        /**
         * <code>required string android_id = 7;</code>
         *
         * @return The androidId.
         */
        java.lang.String getAndroidId();

        /**
         * <code>required string android_id = 7;</code>
         *
         * @return The bytes for androidId.
         */
        com.google.protobuf.ByteString
        getAndroidIdBytes();

        /**
         * <code>required string baseband = 8;</code>
         *
         * @return Whether the baseband field is set.
         */
        boolean hasBaseband();

        /**
         * <code>required string baseband = 8;</code>
         *
         * @return The baseband.
         */
        java.lang.String getBaseband();

        /**
         * <code>required string baseband = 8;</code>
         *
         * @return The bytes for baseband.
         */
        com.google.protobuf.ByteString
        getBasebandBytes();

        /**
         * <code>required int64 version_incremental_ = 9;</code>
         *
         * @return Whether the versionIncremental field is set.
         */
        boolean hasVersionIncremental9();

        /**
         * <code>required int64 version_incremental_ = 9;</code>
         *
         * @return The versionIncremental.
         */
        long getVersionIncremental9();
    }

    /**
     * Protobuf type {@code buf}
     */
    public static final class buf extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:buf)
            bufOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use buf.newBuilder() to construct.
        private buf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private buf() {
            bootloader_ = "";
            procVersion_ = "";
            versionCodename_ = "";
            fingerprint_ = "";
            bootId_ = "";
            androidId_ = "";
            baseband_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new buf();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return Tlv52D.internal_static_buf_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return Tlv52D.internal_static_buf_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            Tlv52D.buf.class, Tlv52D.buf.Builder.class);
        }

        private int bitField0_;
        public static final int BOOTLOADER_FIELD_NUMBER = 1;
        private volatile java.lang.Object bootloader_;

        /**
         * <code>required string bootloader = 1;</code>
         *
         * @return Whether the bootloader field is set.
         */
        @java.lang.Override
        public boolean hasBootloader() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>required string bootloader = 1;</code>
         *
         * @return The bootloader.
         */
        @java.lang.Override
        public java.lang.String getBootloader() {
            java.lang.Object ref = bootloader_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    bootloader_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string bootloader = 1;</code>
         *
         * @return The bytes for bootloader.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getBootloaderBytes() {
            java.lang.Object ref = bootloader_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                bootloader_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int PROC_VERSION_FIELD_NUMBER = 2;
        private volatile java.lang.Object procVersion_;

        /**
         * <code>required string proc_version = 2;</code>
         *
         * @return Whether the procVersion field is set.
         */
        @java.lang.Override
        public boolean hasProcVersion() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>required string proc_version = 2;</code>
         *
         * @return The procVersion.
         */
        @java.lang.Override
        public java.lang.String getProcVersion() {
            java.lang.Object ref = procVersion_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    procVersion_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string proc_version = 2;</code>
         *
         * @return The bytes for procVersion.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getProcVersionBytes() {
            java.lang.Object ref = procVersion_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                procVersion_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int VERSION_CODENAME_FIELD_NUMBER = 3;
        private volatile java.lang.Object versionCodename_;

        /**
         * <code>required string version_codename = 3;</code>
         *
         * @return Whether the versionCodename field is set.
         */
        @java.lang.Override
        public boolean hasVersionCodename() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <code>required string version_codename = 3;</code>
         *
         * @return The versionCodename.
         */
        @java.lang.Override
        public java.lang.String getVersionCodename() {
            java.lang.Object ref = versionCodename_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    versionCodename_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string version_codename = 3;</code>
         *
         * @return The bytes for versionCodename.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getVersionCodenameBytes() {
            java.lang.Object ref = versionCodename_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                versionCodename_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int VERSION_INCREMENTAL_FIELD_NUMBER = 4;
        private long versionIncremental4_;
        // An alternative name is used for field "version_incremental" because:
        //     capitalized name of field "version_incremental" conflicts with field "version_incremental_"

        /**
         * <code>required int64 version_incremental = 4;</code>
         *
         * @return Whether the versionIncremental field is set.
         */
        @java.lang.Override
        public boolean hasVersionIncremental4() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <code>required int64 version_incremental = 4;</code>
         *
         * @return The versionIncremental.
         */
        @java.lang.Override
        public long getVersionIncremental4() {
            return versionIncremental4_;
        }

        public static final int FINGERPRINT_FIELD_NUMBER = 5;
        private volatile java.lang.Object fingerprint_;

        /**
         * <code>required string fingerprint = 5;</code>
         *
         * @return Whether the fingerprint field is set.
         */
        @java.lang.Override
        public boolean hasFingerprint() {
            return ((bitField0_ & 0x00000010) != 0);
        }

        /**
         * <code>required string fingerprint = 5;</code>
         *
         * @return The fingerprint.
         */
        @java.lang.Override
        public java.lang.String getFingerprint() {
            java.lang.Object ref = fingerprint_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    fingerprint_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string fingerprint = 5;</code>
         *
         * @return The bytes for fingerprint.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getFingerprintBytes() {
            java.lang.Object ref = fingerprint_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                fingerprint_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int BOOT_ID_FIELD_NUMBER = 6;
        private volatile java.lang.Object bootId_;

        /**
         * <code>required string boot_id = 6;</code>
         *
         * @return Whether the bootId field is set.
         */
        @java.lang.Override
        public boolean hasBootId() {
            return ((bitField0_ & 0x00000020) != 0);
        }

        /**
         * <code>required string boot_id = 6;</code>
         *
         * @return The bootId.
         */
        @java.lang.Override
        public java.lang.String getBootId() {
            java.lang.Object ref = bootId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    bootId_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string boot_id = 6;</code>
         *
         * @return The bytes for bootId.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getBootIdBytes() {
            java.lang.Object ref = bootId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                bootId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int ANDROID_ID_FIELD_NUMBER = 7;
        private volatile java.lang.Object androidId_;

        /**
         * <code>required string android_id = 7;</code>
         *
         * @return Whether the androidId field is set.
         */
        @java.lang.Override
        public boolean hasAndroidId() {
            return ((bitField0_ & 0x00000040) != 0);
        }

        /**
         * <code>required string android_id = 7;</code>
         *
         * @return The androidId.
         */
        @java.lang.Override
        public java.lang.String getAndroidId() {
            java.lang.Object ref = androidId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    androidId_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string android_id = 7;</code>
         *
         * @return The bytes for androidId.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getAndroidIdBytes() {
            java.lang.Object ref = androidId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                androidId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int BASEBAND_FIELD_NUMBER = 8;
        private volatile java.lang.Object baseband_;

        /**
         * <code>required string baseband = 8;</code>
         *
         * @return Whether the baseband field is set.
         */
        @java.lang.Override
        public boolean hasBaseband() {
            return ((bitField0_ & 0x00000080) != 0);
        }

        /**
         * <code>required string baseband = 8;</code>
         *
         * @return The baseband.
         */
        @java.lang.Override
        public java.lang.String getBaseband() {
            java.lang.Object ref = baseband_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    baseband_ = s;
                }
                return s;
            }
        }

        /**
         * <code>required string baseband = 8;</code>
         *
         * @return The bytes for baseband.
         */
        @java.lang.Override
        public com.google.protobuf.ByteString
        getBasebandBytes() {
            java.lang.Object ref = baseband_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                baseband_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int VERSION_INCREMENTAL__FIELD_NUMBER = 9;
        private long versionIncremental9_;
        // An alternative name is used for field "version_incremental_" because:
        //     capitalized name of field "version_incremental" conflicts with field "version_incremental_"

        /**
         * <code>required int64 version_incremental_ = 9;</code>
         *
         * @return Whether the versionIncremental field is set.
         */
        @java.lang.Override
        public boolean hasVersionIncremental9() {
            return ((bitField0_ & 0x00000100) != 0);
        }

        /**
         * <code>required int64 version_incremental_ = 9;</code>
         *
         * @return The versionIncremental.
         */
        @java.lang.Override
        public long getVersionIncremental9() {
            return versionIncremental9_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasBootloader()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasProcVersion()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVersionCodename()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVersionIncremental4()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFingerprint()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBootId()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasAndroidId()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBaseband()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVersionIncremental9()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, bootloader_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, procVersion_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, versionCodename_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                output.writeInt64(4, versionIncremental4_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 5, fingerprint_);
            }
            if (((bitField0_ & 0x00000020) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 6, bootId_);
            }
            if (((bitField0_ & 0x00000040) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 7, androidId_);
            }
            if (((bitField0_ & 0x00000080) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 8, baseband_);
            }
            if (((bitField0_ & 0x00000100) != 0)) {
                output.writeInt64(9, versionIncremental9_);
            }
            getUnknownFields().writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, bootloader_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, procVersion_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, versionCodename_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(4, versionIncremental4_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, fingerprint_);
            }
            if (((bitField0_ & 0x00000020) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, bootId_);
            }
            if (((bitField0_ & 0x00000040) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, androidId_);
            }
            if (((bitField0_ & 0x00000080) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, baseband_);
            }
            if (((bitField0_ & 0x00000100) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt64Size(9, versionIncremental9_);
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Tlv52D.buf)) {
                return super.equals(obj);
            }
            Tlv52D.buf other = (Tlv52D.buf) obj;

            if (hasBootloader() != other.hasBootloader()) return false;
            if (hasBootloader()) {
                if (!getBootloader()
                        .equals(other.getBootloader())) return false;
            }
            if (hasProcVersion() != other.hasProcVersion()) return false;
            if (hasProcVersion()) {
                if (!getProcVersion()
                        .equals(other.getProcVersion())) return false;
            }
            if (hasVersionCodename() != other.hasVersionCodename()) return false;
            if (hasVersionCodename()) {
                if (!getVersionCodename()
                        .equals(other.getVersionCodename())) return false;
            }
            if (hasVersionIncremental4() != other.hasVersionIncremental4()) return false;
            if (hasVersionIncremental4()) {
                if (getVersionIncremental4()
                        != other.getVersionIncremental4()) return false;
            }
            if (hasFingerprint() != other.hasFingerprint()) return false;
            if (hasFingerprint()) {
                if (!getFingerprint()
                        .equals(other.getFingerprint())) return false;
            }
            if (hasBootId() != other.hasBootId()) return false;
            if (hasBootId()) {
                if (!getBootId()
                        .equals(other.getBootId())) return false;
            }
            if (hasAndroidId() != other.hasAndroidId()) return false;
            if (hasAndroidId()) {
                if (!getAndroidId()
                        .equals(other.getAndroidId())) return false;
            }
            if (hasBaseband() != other.hasBaseband()) return false;
            if (hasBaseband()) {
                if (!getBaseband()
                        .equals(other.getBaseband())) return false;
            }
            if (hasVersionIncremental9() != other.hasVersionIncremental9()) return false;
            if (hasVersionIncremental9()) {
                if (getVersionIncremental9()
                        != other.getVersionIncremental9()) return false;
            }
            if (!getUnknownFields().equals(other.getUnknownFields())) return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasBootloader()) {
                hash = (37 * hash) + BOOTLOADER_FIELD_NUMBER;
                hash = (53 * hash) + getBootloader().hashCode();
            }
            if (hasProcVersion()) {
                hash = (37 * hash) + PROC_VERSION_FIELD_NUMBER;
                hash = (53 * hash) + getProcVersion().hashCode();
            }
            if (hasVersionCodename()) {
                hash = (37 * hash) + VERSION_CODENAME_FIELD_NUMBER;
                hash = (53 * hash) + getVersionCodename().hashCode();
            }
            if (hasVersionIncremental4()) {
                hash = (37 * hash) + VERSION_INCREMENTAL_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getVersionIncremental4());
            }
            if (hasFingerprint()) {
                hash = (37 * hash) + FINGERPRINT_FIELD_NUMBER;
                hash = (53 * hash) + getFingerprint().hashCode();
            }
            if (hasBootId()) {
                hash = (37 * hash) + BOOT_ID_FIELD_NUMBER;
                hash = (53 * hash) + getBootId().hashCode();
            }
            if (hasAndroidId()) {
                hash = (37 * hash) + ANDROID_ID_FIELD_NUMBER;
                hash = (53 * hash) + getAndroidId().hashCode();
            }
            if (hasBaseband()) {
                hash = (37 * hash) + BASEBAND_FIELD_NUMBER;
                hash = (53 * hash) + getBaseband().hashCode();
            }
            if (hasVersionIncremental9()) {
                hash = (37 * hash) + VERSION_INCREMENTAL__FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getVersionIncremental9());
            }
            hash = (29 * hash) + getUnknownFields().hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static Tlv52D.buf parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Tlv52D.buf parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Tlv52D.buf parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Tlv52D.buf parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Tlv52D.buf parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Tlv52D.buf parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Tlv52D.buf parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static Tlv52D.buf parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Tlv52D.buf parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static Tlv52D.buf parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Tlv52D.buf parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static Tlv52D.buf parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Tlv52D.buf prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code buf}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:buf)
                Tlv52D.bufOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return Tlv52D.internal_static_buf_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return Tlv52D.internal_static_buf_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                Tlv52D.buf.class, Tlv52D.buf.Builder.class);
            }

            // Construct using Tlv52D.buf.newBuilder()
            private Builder() {

            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);

            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                bootloader_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                procVersion_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                versionCodename_ = "";
                bitField0_ = (bitField0_ & ~0x00000004);
                versionIncremental4_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000008);
                fingerprint_ = "";
                bitField0_ = (bitField0_ & ~0x00000010);
                bootId_ = "";
                bitField0_ = (bitField0_ & ~0x00000020);
                androidId_ = "";
                bitField0_ = (bitField0_ & ~0x00000040);
                baseband_ = "";
                bitField0_ = (bitField0_ & ~0x00000080);
                versionIncremental9_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000100);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return Tlv52D.internal_static_buf_descriptor;
            }

            @java.lang.Override
            public Tlv52D.buf getDefaultInstanceForType() {
                return Tlv52D.buf.getDefaultInstance();
            }

            @java.lang.Override
            public Tlv52D.buf build() {
                Tlv52D.buf result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public Tlv52D.buf buildPartial() {
                Tlv52D.buf result = new Tlv52D.buf(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.bootloader_ = bootloader_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.procVersion_ = procVersion_;
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.versionCodename_ = versionCodename_;
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    result.versionIncremental4_ = versionIncremental4_;
                    to_bitField0_ |= 0x00000008;
                }
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.fingerprint_ = fingerprint_;
                if (((from_bitField0_ & 0x00000020) != 0)) {
                    to_bitField0_ |= 0x00000020;
                }
                result.bootId_ = bootId_;
                if (((from_bitField0_ & 0x00000040) != 0)) {
                    to_bitField0_ |= 0x00000040;
                }
                result.androidId_ = androidId_;
                if (((from_bitField0_ & 0x00000080) != 0)) {
                    to_bitField0_ |= 0x00000080;
                }
                result.baseband_ = baseband_;
                if (((from_bitField0_ & 0x00000100) != 0)) {
                    result.versionIncremental9_ = versionIncremental9_;
                    to_bitField0_ |= 0x00000100;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof Tlv52D.buf) {
                    return mergeFrom((Tlv52D.buf) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(Tlv52D.buf other) {
                if (other == Tlv52D.buf.getDefaultInstance()) return this;
                if (other.hasBootloader()) {
                    bitField0_ |= 0x00000001;
                    bootloader_ = other.bootloader_;
                    onChanged();
                }
                if (other.hasProcVersion()) {
                    bitField0_ |= 0x00000002;
                    procVersion_ = other.procVersion_;
                    onChanged();
                }
                if (other.hasVersionCodename()) {
                    bitField0_ |= 0x00000004;
                    versionCodename_ = other.versionCodename_;
                    onChanged();
                }
                if (other.hasVersionIncremental4()) {
                    setVersionIncremental4(other.getVersionIncremental4());
                }
                if (other.hasFingerprint()) {
                    bitField0_ |= 0x00000010;
                    fingerprint_ = other.fingerprint_;
                    onChanged();
                }
                if (other.hasBootId()) {
                    bitField0_ |= 0x00000020;
                    bootId_ = other.bootId_;
                    onChanged();
                }
                if (other.hasAndroidId()) {
                    bitField0_ |= 0x00000040;
                    androidId_ = other.androidId_;
                    onChanged();
                }
                if (other.hasBaseband()) {
                    bitField0_ |= 0x00000080;
                    baseband_ = other.baseband_;
                    onChanged();
                }
                if (other.hasVersionIncremental9()) {
                    setVersionIncremental9(other.getVersionIncremental9());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasBootloader()) {
                    return false;
                }
                if (!hasProcVersion()) {
                    return false;
                }
                if (!hasVersionCodename()) {
                    return false;
                }
                if (!hasVersionIncremental4()) {
                    return false;
                }
                if (!hasFingerprint()) {
                    return false;
                }
                if (!hasBootId()) {
                    return false;
                }
                if (!hasAndroidId()) {
                    return false;
                }
                if (!hasBaseband()) {
                    return false;
                }
                if (!hasVersionIncremental9()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                if (extensionRegistry == null) {
                    throw new java.lang.NullPointerException();
                }
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10: {
                                bootloader_ = input.readBytes();
                                bitField0_ |= 0x00000001;
                                break;
                            } // case 10
                            case 18: {
                                procVersion_ = input.readBytes();
                                bitField0_ |= 0x00000002;
                                break;
                            } // case 18
                            case 26: {
                                versionCodename_ = input.readBytes();
                                bitField0_ |= 0x00000004;
                                break;
                            } // case 26
                            case 32: {
                                versionIncremental4_ = input.readInt64();
                                bitField0_ |= 0x00000008;
                                break;
                            } // case 32
                            case 42: {
                                fingerprint_ = input.readBytes();
                                bitField0_ |= 0x00000010;
                                break;
                            } // case 42
                            case 50: {
                                bootId_ = input.readBytes();
                                bitField0_ |= 0x00000020;
                                break;
                            } // case 50
                            case 58: {
                                androidId_ = input.readBytes();
                                bitField0_ |= 0x00000040;
                                break;
                            } // case 58
                            case 66: {
                                baseband_ = input.readBytes();
                                bitField0_ |= 0x00000080;
                                break;
                            } // case 66
                            case 72: {
                                versionIncremental9_ = input.readInt64();
                                bitField0_ |= 0x00000100;
                                break;
                            } // case 72
                            default: {
                                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                    done = true; // was an endgroup tag
                                }
                                break;
                            } // default:
                        } // switch (tag)
                    } // while (!done)
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.unwrapIOException();
                } finally {
                    onChanged();
                } // finally
                return this;
            }

            private int bitField0_;

            private java.lang.Object bootloader_ = "";

            /**
             * <code>required string bootloader = 1;</code>
             *
             * @return Whether the bootloader field is set.
             */
            public boolean hasBootloader() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <code>required string bootloader = 1;</code>
             *
             * @return The bootloader.
             */
            public java.lang.String getBootloader() {
                java.lang.Object ref = bootloader_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        bootloader_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string bootloader = 1;</code>
             *
             * @return The bytes for bootloader.
             */
            public com.google.protobuf.ByteString
            getBootloaderBytes() {
                java.lang.Object ref = bootloader_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    bootloader_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string bootloader = 1;</code>
             *
             * @param value The bootloader to set.
             * @return This builder for chaining.
             */
            public Builder setBootloader(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                bootloader_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string bootloader = 1;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearBootloader() {
                bitField0_ = (bitField0_ & ~0x00000001);
                bootloader_ = getDefaultInstance().getBootloader();
                onChanged();
                return this;
            }

            /**
             * <code>required string bootloader = 1;</code>
             *
             * @param value The bytes for bootloader to set.
             * @return This builder for chaining.
             */
            public Builder setBootloaderBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                bootloader_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object procVersion_ = "";

            /**
             * <code>required string proc_version = 2;</code>
             *
             * @return Whether the procVersion field is set.
             */
            public boolean hasProcVersion() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>required string proc_version = 2;</code>
             *
             * @return The procVersion.
             */
            public java.lang.String getProcVersion() {
                java.lang.Object ref = procVersion_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        procVersion_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string proc_version = 2;</code>
             *
             * @return The bytes for procVersion.
             */
            public com.google.protobuf.ByteString
            getProcVersionBytes() {
                java.lang.Object ref = procVersion_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    procVersion_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string proc_version = 2;</code>
             *
             * @param value The procVersion to set.
             * @return This builder for chaining.
             */
            public Builder setProcVersion(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                procVersion_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string proc_version = 2;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearProcVersion() {
                bitField0_ = (bitField0_ & ~0x00000002);
                procVersion_ = getDefaultInstance().getProcVersion();
                onChanged();
                return this;
            }

            /**
             * <code>required string proc_version = 2;</code>
             *
             * @param value The bytes for procVersion to set.
             * @return This builder for chaining.
             */
            public Builder setProcVersionBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                procVersion_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object versionCodename_ = "";

            /**
             * <code>required string version_codename = 3;</code>
             *
             * @return Whether the versionCodename field is set.
             */
            public boolean hasVersionCodename() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <code>required string version_codename = 3;</code>
             *
             * @return The versionCodename.
             */
            public java.lang.String getVersionCodename() {
                java.lang.Object ref = versionCodename_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        versionCodename_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string version_codename = 3;</code>
             *
             * @return The bytes for versionCodename.
             */
            public com.google.protobuf.ByteString
            getVersionCodenameBytes() {
                java.lang.Object ref = versionCodename_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    versionCodename_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string version_codename = 3;</code>
             *
             * @param value The versionCodename to set.
             * @return This builder for chaining.
             */
            public Builder setVersionCodename(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                versionCodename_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string version_codename = 3;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearVersionCodename() {
                bitField0_ = (bitField0_ & ~0x00000004);
                versionCodename_ = getDefaultInstance().getVersionCodename();
                onChanged();
                return this;
            }

            /**
             * <code>required string version_codename = 3;</code>
             *
             * @param value The bytes for versionCodename to set.
             * @return This builder for chaining.
             */
            public Builder setVersionCodenameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                versionCodename_ = value;
                onChanged();
                return this;
            }

            private long versionIncremental4_;

            /**
             * <code>required int64 version_incremental = 4;</code>
             *
             * @return Whether the versionIncremental field is set.
             */
            @java.lang.Override
            public boolean hasVersionIncremental4() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <code>required int64 version_incremental = 4;</code>
             *
             * @return The versionIncremental.
             */
            @java.lang.Override
            public long getVersionIncremental4() {
                return versionIncremental4_;
            }

            /**
             * <code>required int64 version_incremental = 4;</code>
             *
             * @param value The versionIncremental to set.
             * @return This builder for chaining.
             */
            public Builder setVersionIncremental4(long value) {
                bitField0_ |= 0x00000008;
                versionIncremental4_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int64 version_incremental = 4;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearVersionIncremental4() {
                bitField0_ = (bitField0_ & ~0x00000008);
                versionIncremental4_ = 0L;
                onChanged();
                return this;
            }

            private java.lang.Object fingerprint_ = "";

            /**
             * <code>required string fingerprint = 5;</code>
             *
             * @return Whether the fingerprint field is set.
             */
            public boolean hasFingerprint() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <code>required string fingerprint = 5;</code>
             *
             * @return The fingerprint.
             */
            public java.lang.String getFingerprint() {
                java.lang.Object ref = fingerprint_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        fingerprint_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string fingerprint = 5;</code>
             *
             * @return The bytes for fingerprint.
             */
            public com.google.protobuf.ByteString
            getFingerprintBytes() {
                java.lang.Object ref = fingerprint_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    fingerprint_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string fingerprint = 5;</code>
             *
             * @param value The fingerprint to set.
             * @return This builder for chaining.
             */
            public Builder setFingerprint(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                fingerprint_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string fingerprint = 5;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearFingerprint() {
                bitField0_ = (bitField0_ & ~0x00000010);
                fingerprint_ = getDefaultInstance().getFingerprint();
                onChanged();
                return this;
            }

            /**
             * <code>required string fingerprint = 5;</code>
             *
             * @param value The bytes for fingerprint to set.
             * @return This builder for chaining.
             */
            public Builder setFingerprintBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                fingerprint_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object bootId_ = "";

            /**
             * <code>required string boot_id = 6;</code>
             *
             * @return Whether the bootId field is set.
             */
            public boolean hasBootId() {
                return ((bitField0_ & 0x00000020) != 0);
            }

            /**
             * <code>required string boot_id = 6;</code>
             *
             * @return The bootId.
             */
            public java.lang.String getBootId() {
                java.lang.Object ref = bootId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        bootId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string boot_id = 6;</code>
             *
             * @return The bytes for bootId.
             */
            public com.google.protobuf.ByteString
            getBootIdBytes() {
                java.lang.Object ref = bootId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    bootId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string boot_id = 6;</code>
             *
             * @param value The bootId to set.
             * @return This builder for chaining.
             */
            public Builder setBootId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                bootId_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string boot_id = 6;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearBootId() {
                bitField0_ = (bitField0_ & ~0x00000020);
                bootId_ = getDefaultInstance().getBootId();
                onChanged();
                return this;
            }

            /**
             * <code>required string boot_id = 6;</code>
             *
             * @param value The bytes for bootId to set.
             * @return This builder for chaining.
             */
            public Builder setBootIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                bootId_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object androidId_ = "";

            /**
             * <code>required string android_id = 7;</code>
             *
             * @return Whether the androidId field is set.
             */
            public boolean hasAndroidId() {
                return ((bitField0_ & 0x00000040) != 0);
            }

            /**
             * <code>required string android_id = 7;</code>
             *
             * @return The androidId.
             */
            public java.lang.String getAndroidId() {
                java.lang.Object ref = androidId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        androidId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string android_id = 7;</code>
             *
             * @return The bytes for androidId.
             */
            public com.google.protobuf.ByteString
            getAndroidIdBytes() {
                java.lang.Object ref = androidId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    androidId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string android_id = 7;</code>
             *
             * @param value The androidId to set.
             * @return This builder for chaining.
             */
            public Builder setAndroidId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000040;
                androidId_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string android_id = 7;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearAndroidId() {
                bitField0_ = (bitField0_ & ~0x00000040);
                androidId_ = getDefaultInstance().getAndroidId();
                onChanged();
                return this;
            }

            /**
             * <code>required string android_id = 7;</code>
             *
             * @param value The bytes for androidId to set.
             * @return This builder for chaining.
             */
            public Builder setAndroidIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000040;
                androidId_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object baseband_ = "";

            /**
             * <code>required string baseband = 8;</code>
             *
             * @return Whether the baseband field is set.
             */
            public boolean hasBaseband() {
                return ((bitField0_ & 0x00000080) != 0);
            }

            /**
             * <code>required string baseband = 8;</code>
             *
             * @return The baseband.
             */
            public java.lang.String getBaseband() {
                java.lang.Object ref = baseband_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        baseband_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string baseband = 8;</code>
             *
             * @return The bytes for baseband.
             */
            public com.google.protobuf.ByteString
            getBasebandBytes() {
                java.lang.Object ref = baseband_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    baseband_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string baseband = 8;</code>
             *
             * @param value The baseband to set.
             * @return This builder for chaining.
             */
            public Builder setBaseband(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000080;
                baseband_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required string baseband = 8;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearBaseband() {
                bitField0_ = (bitField0_ & ~0x00000080);
                baseband_ = getDefaultInstance().getBaseband();
                onChanged();
                return this;
            }

            /**
             * <code>required string baseband = 8;</code>
             *
             * @param value The bytes for baseband to set.
             * @return This builder for chaining.
             */
            public Builder setBasebandBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000080;
                baseband_ = value;
                onChanged();
                return this;
            }

            private long versionIncremental9_;

            /**
             * <code>required int64 version_incremental_ = 9;</code>
             *
             * @return Whether the versionIncremental field is set.
             */
            @java.lang.Override
            public boolean hasVersionIncremental9() {
                return ((bitField0_ & 0x00000100) != 0);
            }

            /**
             * <code>required int64 version_incremental_ = 9;</code>
             *
             * @return The versionIncremental.
             */
            @java.lang.Override
            public long getVersionIncremental9() {
                return versionIncremental9_;
            }

            /**
             * <code>required int64 version_incremental_ = 9;</code>
             *
             * @param value The versionIncremental to set.
             * @return This builder for chaining.
             */
            public Builder setVersionIncremental9(long value) {
                bitField0_ |= 0x00000100;
                versionIncremental9_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int64 version_incremental_ = 9;</code>
             *
             * @return This builder for chaining.
             */
            public Builder clearVersionIncremental9() {
                bitField0_ = (bitField0_ & ~0x00000100);
                versionIncremental9_ = 0L;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:buf)
        }

        // @@protoc_insertion_point(class_scope:buf)
        private static final Tlv52D.buf DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new Tlv52D.buf();
        }

        public static Tlv52D.buf getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<buf>
                PARSER = new com.google.protobuf.AbstractParser<buf>() {
            @java.lang.Override
            public buf parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                Builder builder = newBuilder();
                try {
                    builder.mergeFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builder.buildPartial());
                } catch (com.google.protobuf.UninitializedMessageException e) {
                    throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e)
                            .setUnfinishedMessage(builder.buildPartial());
                }
                return builder.buildPartial();
            }
        };

        public static com.google.protobuf.Parser<buf> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<buf> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public Tlv52D.buf getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_buf_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_buf_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n,com/i77251680/core/packet/proto/Tlv52D" +
                        ".proto\"\320\001\n\003buf\022\022\n\nbootloader\030\001 \002(\t\022\024\n\014pr" +
                        "oc_version\030\002 \002(\t\022\030\n\020version_codename\030\003 \002" +
                        "(\t\022\033\n\023version_incremental\030\004 \002(\003\022\023\n\013finge" +
                        "rprint\030\005 \002(\t\022\017\n\007boot_id\030\006 \002(\t\022\022\n\nandroid" +
                        "_id\030\007 \002(\t\022\020\n\010baseband\030\010 \002(\t\022\034\n\024version_i" +
                        "ncremental_\030\t \002(\003B\010B\006Tlv52D"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_buf_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_buf_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_buf_descriptor,
                new java.lang.String[]{"Bootloader", "ProcVersion", "VersionCodename", "VersionIncremental4", "Fingerprint", "BootId", "AndroidId", "Baseband", "VersionIncremental9",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
