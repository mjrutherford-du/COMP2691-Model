import java.util.Arrays;

/**
 * Class representing a bit-field of arbitrary (greater than zero)
 * size.  There are a number of constructors for creating BitField
 * objects from various other types.  There are a number of toXXX()
 * methods for getting the value in different types.
 */
public class BitField
{
    private final boolean[] m_bits;

    /**
     * Constructor to create a bit-field of the specified
     * size, with all bits set to zero.
     *
     * @param size value greater than zero indicating the number of bits to represent.
     */
    public BitField(int size)
    {
	if(size <= 0){
	    throw new IllegalArgumentException(String.format("BitField.BitField(%d) is not allowed.", size));
	}
	m_bits = new boolean [ size ];
    }

    /**
     * Constructor to create a bit field out of a String containing
     * '1' and '0' characters.  The MSB is assumed to be on the left
     * size of the string (index zero), with the LSB on the right side
     * of the string (length - 1).
     *
     * In the parsing logic, '0' characters are 'false' and all other
     * characters are 'true'.
     *
     * @param value non-null, non-empty string to be converted to a
     * byte array.
     */
    public BitField(String value)
    {
	if(null == value){
	    throw new IllegalArgumentException("BitField.BitField((String)null) is not allowed.");
	}
	if(value.length() == 0){
	    throw new IllegalArgumentException("BitField.BitField(\"\") is not allowed.");
	}
	m_bits = new boolean [ value.length() ];
	// change the order
	for(int i=value.length()-1, idx = 0; i >= 0; i--, idx++){
	    m_bits[idx] = !(value.charAt(i) == '0');
	}
    }

    /**
     * Constructor to create a bit-field from a byte array.  In the
     * argument byte array, the LSB is (data[0] AND 0x80) and the MSB
     * is (data[data.length-1] AND 0x1).
     *
     * @param data non-null, non-zero-length byte array that is
     * converted into a bit field.
     */
    public BitField(byte[] data)
    {
	if(null == data){
	    throw new IllegalArgumentException("BitField.BitField((byte[])null) is not allowed.");
	}
	if(data.length == 0){
	    throw new IllegalArgumentException("BitField.BitField((byte[]){}) is not allowed.");
	}
	m_bits = new boolean [ data.length * Constants.BITS_PER_BYTE ];
	int idx = 0;
	for(int i=0; i<data.length; i++){
	    int bits = data[i];
	    int mask = 0x80;
	    for(int j=0; j<Constants.BITS_PER_BYTE; j++){
		m_bits[idx++] = (bits & mask) != 0;
		mask >>= 1;
	    }
	}
    }

    /**
     * Method to compare two BitField objects.
     *
     * @param other Object to compare this object to
     *
     * @return true if the other object is a BitField object with the
     * same number of bits, and all bits have the same value.  False
     * otherwise.
     */
    public boolean equals(Object other)
    {
	// checks type consistency and not-null:
	if(!(other instanceof BitField)){
	    return false;
	}
	BitField that = (BitField)other;
	return Arrays.equals(m_bits, that.m_bits);
    }

    /**
     * @param index value between (0,lenth-1)
     * @return the bit value at the specified index.
     */
    public boolean get(int index)
    {
	return m_bits[index];
    }

    /**
     * Sets the bit value at the specified index.
     * @param index value between (0,lenth-1)
     * @param value boolean value
     */
    public void set(int index, boolean value)
    {
	m_bits[index] = value;
    }

    /**
     * Sets the bit at the specified index to false.
     * @param index value between (0,lenth-1)
     */
    public void setFalse(int index)
    {
	m_bits[index] = false;
    }

    /**
     * Sets the bit at the specified index to true.
     * @param index value between (0,lenth-1)
     */
    public void setTrue(int index)
    {
	m_bits[index] = true;
    }

    /**
     * @return the number of bits in the BitField.
     */
    public int size()
    {
	return m_bits.length;
    }
}
