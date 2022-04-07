/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dtrondoli.kafka.avro.generated;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AvroTransaction extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7063915052668222079L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroTransaction\",\"namespace\":\"com.dtrondoli.kafka.avro.generated\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"accountSource\",\"type\":[\"null\",\"long\"]},{\"name\":\"accountTarget\",\"type\":[\"null\",\"long\"]},{\"name\":\"amount\",\"type\":\"double\"},{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroTransaction> ENCODER =
      new BinaryMessageEncoder<AvroTransaction>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroTransaction> DECODER =
      new BinaryMessageDecoder<AvroTransaction>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AvroTransaction> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AvroTransaction> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AvroTransaction> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroTransaction>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AvroTransaction to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AvroTransaction from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AvroTransaction instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AvroTransaction fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long id;
  @Deprecated public java.lang.Long accountSource;
  @Deprecated public java.lang.Long accountTarget;
  @Deprecated public double amount;
  @Deprecated public java.lang.String type;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroTransaction() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param accountSource The new value for accountSource
   * @param accountTarget The new value for accountTarget
   * @param amount The new value for amount
   * @param type The new value for type
   */
  public AvroTransaction(java.lang.Long id, java.lang.Long accountSource, java.lang.Long accountTarget, java.lang.Double amount, java.lang.String type) {
    this.id = id;
    this.accountSource = accountSource;
    this.accountTarget = accountTarget;
    this.amount = amount;
    this.type = type;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return accountSource;
    case 2: return accountTarget;
    case 3: return amount;
    case 4: return type;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: accountSource = (java.lang.Long)value$; break;
    case 2: accountTarget = (java.lang.Long)value$; break;
    case 3: amount = (java.lang.Double)value$; break;
    case 4: type = value$ != null ? value$.toString() : null; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public long getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'accountSource' field.
   * @return The value of the 'accountSource' field.
   */
  public java.lang.Long getAccountSource() {
    return accountSource;
  }


  /**
   * Sets the value of the 'accountSource' field.
   * @param value the value to set.
   */
  public void setAccountSource(java.lang.Long value) {
    this.accountSource = value;
  }

  /**
   * Gets the value of the 'accountTarget' field.
   * @return The value of the 'accountTarget' field.
   */
  public java.lang.Long getAccountTarget() {
    return accountTarget;
  }


  /**
   * Sets the value of the 'accountTarget' field.
   * @param value the value to set.
   */
  public void setAccountTarget(java.lang.Long value) {
    this.accountTarget = value;
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public double getAmount() {
    return amount;
  }


  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(double value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.String getType() {
    return type;
  }


  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.String value) {
    this.type = value;
  }

  /**
   * Creates a new AvroTransaction RecordBuilder.
   * @return A new AvroTransaction RecordBuilder
   */
  public static com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder newBuilder() {
    return new com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder();
  }

  /**
   * Creates a new AvroTransaction RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroTransaction RecordBuilder
   */
  public static com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder newBuilder(com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder other) {
    if (other == null) {
      return new com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder();
    } else {
      return new com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder(other);
    }
  }

  /**
   * Creates a new AvroTransaction RecordBuilder by copying an existing AvroTransaction instance.
   * @param other The existing instance to copy.
   * @return A new AvroTransaction RecordBuilder
   */
  public static com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder newBuilder(com.dtrondoli.kafka.avro.generated.AvroTransaction other) {
    if (other == null) {
      return new com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder();
    } else {
      return new com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder(other);
    }
  }

  /**
   * RecordBuilder for AvroTransaction instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroTransaction>
    implements org.apache.avro.data.RecordBuilder<AvroTransaction> {

    private long id;
    private java.lang.Long accountSource;
    private java.lang.Long accountTarget;
    private double amount;
    private java.lang.String type;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.accountSource)) {
        this.accountSource = data().deepCopy(fields()[1].schema(), other.accountSource);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.accountTarget)) {
        this.accountTarget = data().deepCopy(fields()[2].schema(), other.accountTarget);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.amount)) {
        this.amount = data().deepCopy(fields()[3].schema(), other.amount);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.type)) {
        this.type = data().deepCopy(fields()[4].schema(), other.type);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing AvroTransaction instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dtrondoli.kafka.avro.generated.AvroTransaction other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accountSource)) {
        this.accountSource = data().deepCopy(fields()[1].schema(), other.accountSource);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accountTarget)) {
        this.accountTarget = data().deepCopy(fields()[2].schema(), other.accountTarget);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.amount)) {
        this.amount = data().deepCopy(fields()[3].schema(), other.amount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.type)) {
        this.type = data().deepCopy(fields()[4].schema(), other.type);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public long getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountSource' field.
      * @return The value.
      */
    public java.lang.Long getAccountSource() {
      return accountSource;
    }


    /**
      * Sets the value of the 'accountSource' field.
      * @param value The value of 'accountSource'.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder setAccountSource(java.lang.Long value) {
      validate(fields()[1], value);
      this.accountSource = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'accountSource' field has been set.
      * @return True if the 'accountSource' field has been set, false otherwise.
      */
    public boolean hasAccountSource() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'accountSource' field.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder clearAccountSource() {
      accountSource = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountTarget' field.
      * @return The value.
      */
    public java.lang.Long getAccountTarget() {
      return accountTarget;
    }


    /**
      * Sets the value of the 'accountTarget' field.
      * @param value The value of 'accountTarget'.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder setAccountTarget(java.lang.Long value) {
      validate(fields()[2], value);
      this.accountTarget = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'accountTarget' field has been set.
      * @return True if the 'accountTarget' field has been set, false otherwise.
      */
    public boolean hasAccountTarget() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'accountTarget' field.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder clearAccountTarget() {
      accountTarget = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public double getAmount() {
      return amount;
    }


    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder setAmount(double value) {
      validate(fields()[3], value);
      this.amount = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder clearAmount() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.String getType() {
      return type;
    }


    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder setType(java.lang.String value) {
      validate(fields()[4], value);
      this.type = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public com.dtrondoli.kafka.avro.generated.AvroTransaction.Builder clearType() {
      type = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroTransaction build() {
      try {
        AvroTransaction record = new AvroTransaction();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.accountSource = fieldSetFlags()[1] ? this.accountSource : (java.lang.Long) defaultValue(fields()[1]);
        record.accountTarget = fieldSetFlags()[2] ? this.accountTarget : (java.lang.Long) defaultValue(fields()[2]);
        record.amount = fieldSetFlags()[3] ? this.amount : (java.lang.Double) defaultValue(fields()[3]);
        record.type = fieldSetFlags()[4] ? this.type : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroTransaction>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroTransaction>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroTransaction>
    READER$ = (org.apache.avro.io.DatumReader<AvroTransaction>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.id);

    if (this.accountSource == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.accountSource);
    }

    if (this.accountTarget == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.accountTarget);
    }

    out.writeDouble(this.amount);

    out.writeString(this.type);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readLong();

      if (in.readIndex() != 1) {
        in.readNull();
        this.accountSource = null;
      } else {
        this.accountSource = in.readLong();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.accountTarget = null;
      } else {
        this.accountTarget = in.readLong();
      }

      this.amount = in.readDouble();

      this.type = in.readString();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readLong();
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.accountSource = null;
          } else {
            this.accountSource = in.readLong();
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.accountTarget = null;
          } else {
            this.accountTarget = in.readLong();
          }
          break;

        case 3:
          this.amount = in.readDouble();
          break;

        case 4:
          this.type = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










