import static org.junit.Assert.*;
import org.junit.*;

public class BitFieldTest
{
    private BitField m_bf = null;

    @Test
    public void intCtor()
    {
	m_bf = new BitField(5);
	assertEquals(5, m_bf.size());

	for(int i=0; i<m_bf.size(); i++){
	    assertFalse(m_bf.get(i));
	}
    }

    @Test(expected=IllegalArgumentException.class)
    public void intCtor_tooSmall()
    {
	new BitField(0);
    }

    @Test
    public void stringCtor_1()
    {
	m_bf = new BitField("1011");
        assertEquals(4, m_bf.size());
	assertTrue(m_bf.get(0));
	assertTrue(m_bf.get(1));
	assertFalse(m_bf.get(2));
	assertTrue(m_bf.get(3));
    }

    @Test
    public void stringCtor_2()
    {
	m_bf = new BitField("00000000");
        assertEquals(8, m_bf.size());
	for(int i=0; i<8; i++){
	    assertFalse(m_bf.get(i));
	}
    }

    @Test
    public void stringCtor_3()
    {
	m_bf = new BitField("001");
        assertEquals(3, m_bf.size());
        assertTrue(m_bf.get(0));
        assertFalse(m_bf.get(1));
        assertFalse(m_bf.get(2));
    }
    
    @Test
    public void stringCtor_4()
    {
	m_bf = new BitField("1000");
        assertEquals(4, m_bf.size());
        assertFalse(m_bf.get(0));
        assertFalse(m_bf.get(1));
        assertFalse(m_bf.get(2));
        assertTrue(m_bf.get(3));
    }
    
    @Test
    public void stringCtor_5()
    {
	m_bf = new BitField("111111111");
        assertEquals(9, m_bf.size());
	for(int i=0; i<9; i++){
	    assertTrue(m_bf.get(i));
	}
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void stringCtor_null()
    {
	new BitField((String)null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void stringCtor_empty()
    {
	new BitField("");
    }

    @Test(expected=IllegalArgumentException.class)
    public void intStringCtor_zeroSize()
    {
	new BitField(0, "101010");
    }

    @Test(expected=IllegalArgumentException.class)
    public void intStringCtor_null()
    {
	new BitField(1, (String)null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void intStringCtor_tooLong()
    {
	new BitField(2, "101");
    }

    @Test
    public void intStringCtor_basic1()
    {
	m_bf = new BitField(2, "10");
	assertTrue(m_bf.getMSB());
	assertFalse(m_bf.getLSB());
    }

    @Test
    public void intStringCtor_basic2()
    {
	m_bf = new BitField(2, "01");
	assertFalse(m_bf.getMSB());
	assertTrue(m_bf.getLSB());
    }

    @Test
    public void intStringCtor_basic3()
    {
	m_bf = new BitField(5, "101");
	assertFalse(m_bf.get(4));
	assertFalse(m_bf.get(3));
	assertTrue(m_bf.get(2));
	assertFalse(m_bf.get(1));
	assertTrue(m_bf.get(0));
    }

    @Test
    public void basicSetGet()
    {
	m_bf = new BitField(3);
	m_bf.set(1, true);
	assertFalse(m_bf.get(0));
	assertTrue(m_bf.get(1));
	assertFalse(m_bf.get(2));

	m_bf.set(2, true);
	assertFalse(m_bf.get(0));
	assertTrue(m_bf.get(1));
	assertTrue(m_bf.get(2));

	m_bf.set(1, false);
	assertFalse(m_bf.get(0));
	assertFalse(m_bf.get(1));
	assertTrue(m_bf.get(2));

	m_bf.setFalse(2);
	assertFalse(m_bf.get(0));
	assertFalse(m_bf.get(1));
	assertFalse(m_bf.get(2));

	m_bf.setTrue(0);
	assertTrue(m_bf.get(0));
	assertFalse(m_bf.get(1));
	assertFalse(m_bf.get(2));
    }

    @Test
    public void setAll()
    {
	m_bf = new BitField(3);
	m_bf.setAll(true);
	assertTrue(m_bf.get(0));
	assertTrue(m_bf.get(1));
	assertTrue(m_bf.get(2));

	m_bf.setAll(false);
	assertFalse(m_bf.get(0));
	assertFalse(m_bf.get(1));
	assertFalse(m_bf.get(2));

	m_bf.setAllTrue();
	assertTrue(m_bf.get(0));
	assertTrue(m_bf.get(1));
	assertTrue(m_bf.get(2));

	m_bf.setAllFalse();
	assertFalse(m_bf.get(0));
	assertFalse(m_bf.get(1));
	assertFalse(m_bf.get(2));

    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void set_OOB_negative()
    {
	m_bf = new BitField(3);
	m_bf.set(-1, true);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void set_OOB_tooBig()
    {
	m_bf = new BitField(3);
	m_bf.set(3, true);
    }

    @Test
    public void equalsBasic_true()
    {
	m_bf = new BitField("1010");
	BitField bf2 = new BitField("1010");

	assertTrue(m_bf.equals(bf2));
	assertTrue(bf2.equals(m_bf));
    }
    @Test
    public void equalsBasic_false()
    {
	m_bf = new BitField("1011");
	BitField bf2 = new BitField("1010");

	assertFalse(m_bf.equals(bf2));
	assertFalse(bf2.equals(m_bf));
    }

    @Test
    public void equals_null()
    {
	m_bf = new BitField(10);
	assertFalse(m_bf.equals(null));
    }

    @Test
    public void equals_other()
    {
	m_bf = new BitField(10);
	assertFalse(m_bf.equals(new Object()));
    }

    @Test
    public void byteArrayCtor_one_byte()
    {
	m_bf = new BitField(new byte[] { 0x01 });
	assertEquals(8, m_bf.size());
	for(int i=1; i<7; i++){
	    assertFalse(m_bf.get(i));
	}
	assertTrue(m_bf.get(0));
    }

    @Test
    public void byteArrayCtor_two_bytes()
    {
	m_bf = new BitField(new byte[] { 0x01, (byte)0xAB });
	// 0 = 0000
	assertFalse(m_bf.get(15));
	assertFalse(m_bf.get(14));
	assertFalse(m_bf.get(13));
	assertFalse(m_bf.get(12));
	// 1 = 0001
	assertFalse(m_bf.get(11));
	assertFalse(m_bf.get(10));
	assertFalse(m_bf.get(9));
	assertTrue(m_bf.get(8));
	// A == 1010
	assertTrue(m_bf.get(7));
	assertFalse(m_bf.get(6));
	assertTrue(m_bf.get(5));
	assertFalse(m_bf.get(4));
	// B == 1011
	assertTrue(m_bf.get(3));
	assertFalse(m_bf.get(2));
	assertTrue(m_bf.get(1));
	assertTrue(m_bf.get(0));
    }

    @Test(expected=IllegalArgumentException.class)
    public void byteArrayCtor_zeroSize()
    {
	new BitField(0, new byte[ 1 ]);
    }

    @Test
    public void byteArrayCtor_shorter()
    {
	m_bf = new BitField(9, new byte[] { (byte)0x51 }); // MSB 0101 0001 LSB

	// spare bit (MSB)
	assertFalse(m_bf.get(8));
	// 5 == 0101
	assertFalse(m_bf.get(7));
	assertTrue(m_bf.get(6));
	assertFalse(m_bf.get(5));
	assertTrue(m_bf.get(4));
	// 1 = 0001
	assertFalse(m_bf.get(3));
	assertFalse(m_bf.get(2));
	assertFalse(m_bf.get(1));
	assertTrue(m_bf.get(0));
	// LSB
    }

    @Test(expected=IllegalArgumentException.class)
    public void byteArrayCtor_null()
    {
	new BitField((byte[])null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void byteArrayCtor_zero_length()
    {
	new BitField(new byte[ 0 ]);
    }

    @Test
    public void toString_basic()
    {
	String in = "10100011";
	m_bf = new BitField(in);
	assertEquals(in, m_bf.toString());
    }

    @Test
    public void toLongSigned_basic()
    {
	m_bf = new BitField("0111");
	assertEquals((1+2+4), m_bf.toLongSigned());

	m_bf = new BitField("1111");
	assertEquals(-1, m_bf.toLongSigned());
    }

    @Test
    public void toLongSigned_min()
    {
	m_bf = new BitField("1000000000000000000000000000000000000000000000000000000000000000");
	assertEquals(Long.MIN_VALUE, m_bf.toLongSigned());
    }

    @Test
    public void toLongSigned_max()
    {
	m_bf = new BitField("0111111111111111111111111111111111111111111111111111111111111111");
	assertEquals(Long.MAX_VALUE, m_bf.toLongSigned());
    }

    @Test(expected=RuntimeException.class)
    public void toLongSigned_tooBig()
    {
	new BitField(65).toLongSigned();
    }

    @Test
    public void toIntSigned_basic()
    {
	m_bf = new BitField("0111");
	assertEquals((1+2+4), m_bf.toIntSigned());

	m_bf = new BitField("1111");
	assertEquals(-1, m_bf.toIntSigned());
    }

    @Test
    public void toIntSigned_min()
    {
	m_bf = new BitField("10000000000000000000000000000000");
	assertEquals(Integer.MIN_VALUE, m_bf.toIntSigned());
    }

    @Test
    public void toIntSigned_max()
    {
	m_bf = new BitField("01111111111111111111111111111111");
	assertEquals(Integer.MAX_VALUE, m_bf.toIntSigned());
    }

    @Test(expected=RuntimeException.class)
    public void toIntSigned_tooBig()
    {
	new BitField(33).toIntSigned();
    }

    @Test
    public void copy()
    {
	String in = "1010001100111";
	m_bf = new BitField(in);
	BitField c = m_bf.copy();
	assertEquals(m_bf, c);
	assertNotSame(m_bf, c);
    }

    @Test
    public void getMSB_LSB()
    {
	String in = "10101010";
	m_bf = new BitField(in);
	assertTrue(m_bf.getMSB());
	assertFalse(m_bf.getLSB());

	in = "010101";
	m_bf = new BitField(in);
	assertFalse(m_bf.getMSB());
	assertTrue(m_bf.getLSB());
    }
}
