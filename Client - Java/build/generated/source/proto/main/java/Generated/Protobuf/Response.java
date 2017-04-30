// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AppService.proto

package Generated.Protobuf;

/**
 * Protobuf type {@code Response}
 */
public  final class Response extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Response)
    ResponseOrBuilder {
  // Use Response.newBuilder() to construct.
  private Response(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Response() {
    type_ = 0;
    error_ = "";
    matchList_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Response(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            int rawValue = input.readEnum();

            type_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            error_ = s;
            break;
          }
          case 26: {
            Generated.Protobuf.MatchDTO.Builder subBuilder = null;
            if (match_ != null) {
              subBuilder = match_.toBuilder();
            }
            match_ = input.readMessage(Generated.Protobuf.MatchDTO.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(match_);
              match_ = subBuilder.buildPartial();
            }

            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              matchList_ = new java.util.ArrayList<Generated.Protobuf.MatchDTO>();
              mutable_bitField0_ |= 0x00000008;
            }
            matchList_.add(
                input.readMessage(Generated.Protobuf.MatchDTO.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        matchList_ = java.util.Collections.unmodifiableList(matchList_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Generated.Protobuf.AppServiceOuterClass.internal_static_Response_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Generated.Protobuf.AppServiceOuterClass.internal_static_Response_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Generated.Protobuf.Response.class, Generated.Protobuf.Response.Builder.class);
  }

  /**
   * Protobuf enum {@code Response.Type}
   */
  public enum Type
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>UNKNOW = 0;</code>
     */
    UNKNOW(0),
    /**
     * <code>OK = 1;</code>
     */
    OK(1),
    /**
     * <code>ERROR = 2;</code>
     */
    ERROR(2),
    /**
     * <code>SHOW_UPDATED_ENTITIES = 3;</code>
     */
    SHOW_UPDATED_ENTITIES(3),
    /**
     * <code>GET_LOGGED_FRIENDS = 4;</code>
     */
    GET_LOGGED_FRIENDS(4),
    /**
     * <code>FRIEND_LOGGED_IN = 5;</code>
     */
    FRIEND_LOGGED_IN(5),
    /**
     * <code>FRIEND_LOGGED_OUT = 6;</code>
     */
    FRIEND_LOGGED_OUT(6),
    /**
     * <code>SOLD = 7;</code>
     */
    SOLD(7),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>UNKNOW = 0;</code>
     */
    public static final int UNKNOW_VALUE = 0;
    /**
     * <code>OK = 1;</code>
     */
    public static final int OK_VALUE = 1;
    /**
     * <code>ERROR = 2;</code>
     */
    public static final int ERROR_VALUE = 2;
    /**
     * <code>SHOW_UPDATED_ENTITIES = 3;</code>
     */
    public static final int SHOW_UPDATED_ENTITIES_VALUE = 3;
    /**
     * <code>GET_LOGGED_FRIENDS = 4;</code>
     */
    public static final int GET_LOGGED_FRIENDS_VALUE = 4;
    /**
     * <code>FRIEND_LOGGED_IN = 5;</code>
     */
    public static final int FRIEND_LOGGED_IN_VALUE = 5;
    /**
     * <code>FRIEND_LOGGED_OUT = 6;</code>
     */
    public static final int FRIEND_LOGGED_OUT_VALUE = 6;
    /**
     * <code>SOLD = 7;</code>
     */
    public static final int SOLD_VALUE = 7;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Type valueOf(int value) {
      return forNumber(value);
    }

    public static Type forNumber(int value) {
      switch (value) {
        case 0: return UNKNOW;
        case 1: return OK;
        case 2: return ERROR;
        case 3: return SHOW_UPDATED_ENTITIES;
        case 4: return GET_LOGGED_FRIENDS;
        case 5: return FRIEND_LOGGED_IN;
        case 6: return FRIEND_LOGGED_OUT;
        case 7: return SOLD;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Type>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Type> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Type>() {
            public Type findValueByNumber(int number) {
              return Type.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return Generated.Protobuf.Response.getDescriptor().getEnumTypes().get(0);
    }

    private static final Type[] VALUES = values();

    public static Type valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Type(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:Response.Type)
  }

  private int bitField0_;
  public static final int TYPE_FIELD_NUMBER = 1;
  private int type_;
  /**
   * <code>optional .Response.Type type = 1;</code>
   */
  public int getTypeValue() {
    return type_;
  }
  /**
   * <code>optional .Response.Type type = 1;</code>
   */
  public Generated.Protobuf.Response.Type getType() {
    Generated.Protobuf.Response.Type result = Generated.Protobuf.Response.Type.valueOf(type_);
    return result == null ? Generated.Protobuf.Response.Type.UNRECOGNIZED : result;
  }

  public static final int ERROR_FIELD_NUMBER = 2;
  private volatile java.lang.Object error_;
  /**
   * <code>optional string error = 2;</code>
   */
  public java.lang.String getError() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      error_ = s;
      return s;
    }
  }
  /**
   * <code>optional string error = 2;</code>
   */
  public com.google.protobuf.ByteString
      getErrorBytes() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      error_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MATCH_FIELD_NUMBER = 3;
  private Generated.Protobuf.MatchDTO match_;
  /**
   * <pre>
   *Match shold be modified match,getAll match or getAllFilteredAndSorted match
   * </pre>
   *
   * <code>optional .MatchDTO match = 3;</code>
   */
  public boolean hasMatch() {
    return match_ != null;
  }
  /**
   * <pre>
   *Match shold be modified match,getAll match or getAllFilteredAndSorted match
   * </pre>
   *
   * <code>optional .MatchDTO match = 3;</code>
   */
  public Generated.Protobuf.MatchDTO getMatch() {
    return match_ == null ? Generated.Protobuf.MatchDTO.getDefaultInstance() : match_;
  }
  /**
   * <pre>
   *Match shold be modified match,getAll match or getAllFilteredAndSorted match
   * </pre>
   *
   * <code>optional .MatchDTO match = 3;</code>
   */
  public Generated.Protobuf.MatchDTOOrBuilder getMatchOrBuilder() {
    return getMatch();
  }

  public static final int MATCHLIST_FIELD_NUMBER = 4;
  private java.util.List<Generated.Protobuf.MatchDTO> matchList_;
  /**
   * <code>repeated .MatchDTO matchList = 4;</code>
   */
  public java.util.List<Generated.Protobuf.MatchDTO> getMatchListList() {
    return matchList_;
  }
  /**
   * <code>repeated .MatchDTO matchList = 4;</code>
   */
  public java.util.List<? extends Generated.Protobuf.MatchDTOOrBuilder> 
      getMatchListOrBuilderList() {
    return matchList_;
  }
  /**
   * <code>repeated .MatchDTO matchList = 4;</code>
   */
  public int getMatchListCount() {
    return matchList_.size();
  }
  /**
   * <code>repeated .MatchDTO matchList = 4;</code>
   */
  public Generated.Protobuf.MatchDTO getMatchList(int index) {
    return matchList_.get(index);
  }
  /**
   * <code>repeated .MatchDTO matchList = 4;</code>
   */
  public Generated.Protobuf.MatchDTOOrBuilder getMatchListOrBuilder(
      int index) {
    return matchList_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (type_ != Generated.Protobuf.Response.Type.UNKNOW.getNumber()) {
      output.writeEnum(1, type_);
    }
    if (!getErrorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, error_);
    }
    if (match_ != null) {
      output.writeMessage(3, getMatch());
    }
    for (int i = 0; i < matchList_.size(); i++) {
      output.writeMessage(4, matchList_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (type_ != Generated.Protobuf.Response.Type.UNKNOW.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, type_);
    }
    if (!getErrorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, error_);
    }
    if (match_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getMatch());
    }
    for (int i = 0; i < matchList_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, matchList_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Generated.Protobuf.Response)) {
      return super.equals(obj);
    }
    Generated.Protobuf.Response other = (Generated.Protobuf.Response) obj;

    boolean result = true;
    result = result && type_ == other.type_;
    result = result && getError()
        .equals(other.getError());
    result = result && (hasMatch() == other.hasMatch());
    if (hasMatch()) {
      result = result && getMatch()
          .equals(other.getMatch());
    }
    result = result && getMatchListList()
        .equals(other.getMatchListList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (37 * hash) + ERROR_FIELD_NUMBER;
    hash = (53 * hash) + getError().hashCode();
    if (hasMatch()) {
      hash = (37 * hash) + MATCH_FIELD_NUMBER;
      hash = (53 * hash) + getMatch().hashCode();
    }
    if (getMatchListCount() > 0) {
      hash = (37 * hash) + MATCHLIST_FIELD_NUMBER;
      hash = (53 * hash) + getMatchListList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Generated.Protobuf.Response parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Generated.Protobuf.Response parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Generated.Protobuf.Response parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Generated.Protobuf.Response parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Generated.Protobuf.Response parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Generated.Protobuf.Response parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Generated.Protobuf.Response parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Generated.Protobuf.Response parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Generated.Protobuf.Response parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Generated.Protobuf.Response parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Generated.Protobuf.Response prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code Response}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Response)
      Generated.Protobuf.ResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Generated.Protobuf.AppServiceOuterClass.internal_static_Response_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Generated.Protobuf.AppServiceOuterClass.internal_static_Response_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Generated.Protobuf.Response.class, Generated.Protobuf.Response.Builder.class);
    }

    // Construct using Generated.Protobuf.Response.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getMatchListFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      type_ = 0;

      error_ = "";

      if (matchBuilder_ == null) {
        match_ = null;
      } else {
        match_ = null;
        matchBuilder_ = null;
      }
      if (matchListBuilder_ == null) {
        matchList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
      } else {
        matchListBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Generated.Protobuf.AppServiceOuterClass.internal_static_Response_descriptor;
    }

    public Generated.Protobuf.Response getDefaultInstanceForType() {
      return Generated.Protobuf.Response.getDefaultInstance();
    }

    public Generated.Protobuf.Response build() {
      Generated.Protobuf.Response result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public Generated.Protobuf.Response buildPartial() {
      Generated.Protobuf.Response result = new Generated.Protobuf.Response(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.type_ = type_;
      result.error_ = error_;
      if (matchBuilder_ == null) {
        result.match_ = match_;
      } else {
        result.match_ = matchBuilder_.build();
      }
      if (matchListBuilder_ == null) {
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          matchList_ = java.util.Collections.unmodifiableList(matchList_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.matchList_ = matchList_;
      } else {
        result.matchList_ = matchListBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Generated.Protobuf.Response) {
        return mergeFrom((Generated.Protobuf.Response)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Generated.Protobuf.Response other) {
      if (other == Generated.Protobuf.Response.getDefaultInstance()) return this;
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (!other.getError().isEmpty()) {
        error_ = other.error_;
        onChanged();
      }
      if (other.hasMatch()) {
        mergeMatch(other.getMatch());
      }
      if (matchListBuilder_ == null) {
        if (!other.matchList_.isEmpty()) {
          if (matchList_.isEmpty()) {
            matchList_ = other.matchList_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureMatchListIsMutable();
            matchList_.addAll(other.matchList_);
          }
          onChanged();
        }
      } else {
        if (!other.matchList_.isEmpty()) {
          if (matchListBuilder_.isEmpty()) {
            matchListBuilder_.dispose();
            matchListBuilder_ = null;
            matchList_ = other.matchList_;
            bitField0_ = (bitField0_ & ~0x00000008);
            matchListBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMatchListFieldBuilder() : null;
          } else {
            matchListBuilder_.addAllMessages(other.matchList_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Generated.Protobuf.Response parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Generated.Protobuf.Response) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int type_ = 0;
    /**
     * <code>optional .Response.Type type = 1;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>optional .Response.Type type = 1;</code>
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .Response.Type type = 1;</code>
     */
    public Generated.Protobuf.Response.Type getType() {
      Generated.Protobuf.Response.Type result = Generated.Protobuf.Response.Type.valueOf(type_);
      return result == null ? Generated.Protobuf.Response.Type.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .Response.Type type = 1;</code>
     */
    public Builder setType(Generated.Protobuf.Response.Type value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .Response.Type type = 1;</code>
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object error_ = "";
    /**
     * <code>optional string error = 2;</code>
     */
    public java.lang.String getError() {
      java.lang.Object ref = error_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        error_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string error = 2;</code>
     */
    public com.google.protobuf.ByteString
        getErrorBytes() {
      java.lang.Object ref = error_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        error_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string error = 2;</code>
     */
    public Builder setError(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      error_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string error = 2;</code>
     */
    public Builder clearError() {
      
      error_ = getDefaultInstance().getError();
      onChanged();
      return this;
    }
    /**
     * <code>optional string error = 2;</code>
     */
    public Builder setErrorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      error_ = value;
      onChanged();
      return this;
    }

    private Generated.Protobuf.MatchDTO match_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        Generated.Protobuf.MatchDTO, Generated.Protobuf.MatchDTO.Builder, Generated.Protobuf.MatchDTOOrBuilder> matchBuilder_;
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public boolean hasMatch() {
      return matchBuilder_ != null || match_ != null;
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public Generated.Protobuf.MatchDTO getMatch() {
      if (matchBuilder_ == null) {
        return match_ == null ? Generated.Protobuf.MatchDTO.getDefaultInstance() : match_;
      } else {
        return matchBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public Builder setMatch(Generated.Protobuf.MatchDTO value) {
      if (matchBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        match_ = value;
        onChanged();
      } else {
        matchBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public Builder setMatch(
        Generated.Protobuf.MatchDTO.Builder builderForValue) {
      if (matchBuilder_ == null) {
        match_ = builderForValue.build();
        onChanged();
      } else {
        matchBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public Builder mergeMatch(Generated.Protobuf.MatchDTO value) {
      if (matchBuilder_ == null) {
        if (match_ != null) {
          match_ =
            Generated.Protobuf.MatchDTO.newBuilder(match_).mergeFrom(value).buildPartial();
        } else {
          match_ = value;
        }
        onChanged();
      } else {
        matchBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public Builder clearMatch() {
      if (matchBuilder_ == null) {
        match_ = null;
        onChanged();
      } else {
        match_ = null;
        matchBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public Generated.Protobuf.MatchDTO.Builder getMatchBuilder() {
      
      onChanged();
      return getMatchFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    public Generated.Protobuf.MatchDTOOrBuilder getMatchOrBuilder() {
      if (matchBuilder_ != null) {
        return matchBuilder_.getMessageOrBuilder();
      } else {
        return match_ == null ?
            Generated.Protobuf.MatchDTO.getDefaultInstance() : match_;
      }
    }
    /**
     * <pre>
     *Match shold be modified match,getAll match or getAllFilteredAndSorted match
     * </pre>
     *
     * <code>optional .MatchDTO match = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Generated.Protobuf.MatchDTO, Generated.Protobuf.MatchDTO.Builder, Generated.Protobuf.MatchDTOOrBuilder> 
        getMatchFieldBuilder() {
      if (matchBuilder_ == null) {
        matchBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Generated.Protobuf.MatchDTO, Generated.Protobuf.MatchDTO.Builder, Generated.Protobuf.MatchDTOOrBuilder>(
                getMatch(),
                getParentForChildren(),
                isClean());
        match_ = null;
      }
      return matchBuilder_;
    }

    private java.util.List<Generated.Protobuf.MatchDTO> matchList_ =
      java.util.Collections.emptyList();
    private void ensureMatchListIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        matchList_ = new java.util.ArrayList<Generated.Protobuf.MatchDTO>(matchList_);
        bitField0_ |= 0x00000008;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        Generated.Protobuf.MatchDTO, Generated.Protobuf.MatchDTO.Builder, Generated.Protobuf.MatchDTOOrBuilder> matchListBuilder_;

    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public java.util.List<Generated.Protobuf.MatchDTO> getMatchListList() {
      if (matchListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(matchList_);
      } else {
        return matchListBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public int getMatchListCount() {
      if (matchListBuilder_ == null) {
        return matchList_.size();
      } else {
        return matchListBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Generated.Protobuf.MatchDTO getMatchList(int index) {
      if (matchListBuilder_ == null) {
        return matchList_.get(index);
      } else {
        return matchListBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder setMatchList(
        int index, Generated.Protobuf.MatchDTO value) {
      if (matchListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMatchListIsMutable();
        matchList_.set(index, value);
        onChanged();
      } else {
        matchListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder setMatchList(
        int index, Generated.Protobuf.MatchDTO.Builder builderForValue) {
      if (matchListBuilder_ == null) {
        ensureMatchListIsMutable();
        matchList_.set(index, builderForValue.build());
        onChanged();
      } else {
        matchListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder addMatchList(Generated.Protobuf.MatchDTO value) {
      if (matchListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMatchListIsMutable();
        matchList_.add(value);
        onChanged();
      } else {
        matchListBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder addMatchList(
        int index, Generated.Protobuf.MatchDTO value) {
      if (matchListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMatchListIsMutable();
        matchList_.add(index, value);
        onChanged();
      } else {
        matchListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder addMatchList(
        Generated.Protobuf.MatchDTO.Builder builderForValue) {
      if (matchListBuilder_ == null) {
        ensureMatchListIsMutable();
        matchList_.add(builderForValue.build());
        onChanged();
      } else {
        matchListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder addMatchList(
        int index, Generated.Protobuf.MatchDTO.Builder builderForValue) {
      if (matchListBuilder_ == null) {
        ensureMatchListIsMutable();
        matchList_.add(index, builderForValue.build());
        onChanged();
      } else {
        matchListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder addAllMatchList(
        java.lang.Iterable<? extends Generated.Protobuf.MatchDTO> values) {
      if (matchListBuilder_ == null) {
        ensureMatchListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, matchList_);
        onChanged();
      } else {
        matchListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder clearMatchList() {
      if (matchListBuilder_ == null) {
        matchList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
      } else {
        matchListBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Builder removeMatchList(int index) {
      if (matchListBuilder_ == null) {
        ensureMatchListIsMutable();
        matchList_.remove(index);
        onChanged();
      } else {
        matchListBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Generated.Protobuf.MatchDTO.Builder getMatchListBuilder(
        int index) {
      return getMatchListFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Generated.Protobuf.MatchDTOOrBuilder getMatchListOrBuilder(
        int index) {
      if (matchListBuilder_ == null) {
        return matchList_.get(index);  } else {
        return matchListBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public java.util.List<? extends Generated.Protobuf.MatchDTOOrBuilder> 
         getMatchListOrBuilderList() {
      if (matchListBuilder_ != null) {
        return matchListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(matchList_);
      }
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Generated.Protobuf.MatchDTO.Builder addMatchListBuilder() {
      return getMatchListFieldBuilder().addBuilder(
          Generated.Protobuf.MatchDTO.getDefaultInstance());
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public Generated.Protobuf.MatchDTO.Builder addMatchListBuilder(
        int index) {
      return getMatchListFieldBuilder().addBuilder(
          index, Generated.Protobuf.MatchDTO.getDefaultInstance());
    }
    /**
     * <code>repeated .MatchDTO matchList = 4;</code>
     */
    public java.util.List<Generated.Protobuf.MatchDTO.Builder> 
         getMatchListBuilderList() {
      return getMatchListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        Generated.Protobuf.MatchDTO, Generated.Protobuf.MatchDTO.Builder, Generated.Protobuf.MatchDTOOrBuilder> 
        getMatchListFieldBuilder() {
      if (matchListBuilder_ == null) {
        matchListBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            Generated.Protobuf.MatchDTO, Generated.Protobuf.MatchDTO.Builder, Generated.Protobuf.MatchDTOOrBuilder>(
                matchList_,
                ((bitField0_ & 0x00000008) == 0x00000008),
                getParentForChildren(),
                isClean());
        matchList_ = null;
      }
      return matchListBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:Response)
  }

  // @@protoc_insertion_point(class_scope:Response)
  private static final Generated.Protobuf.Response DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Generated.Protobuf.Response();
  }

  public static Generated.Protobuf.Response getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Response>
      PARSER = new com.google.protobuf.AbstractParser<Response>() {
    public Response parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Response(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Response> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Response> getParserForType() {
    return PARSER;
  }

  public Generated.Protobuf.Response getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

