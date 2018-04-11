import static org.junit.Assert.*;
import org.junit.*;

public class BitFieldTest
{
    private BitField m_bf = null;

    @Test
    public void intCtor()
    {
	m_bf = new BitField(5);
	assertEquals(5, m_bf.length());

	for(int i=0; i<m_bf.length(); i++){
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
        assertEquals(4, m_bf.length());
	assertTrue(m_bf.get(0));
	assertTrue(m_bf.get(1));
	assertFalse(m_bf.get(2));
	assertTrue(m_bf.get(3));
    }

    @Test
    public void stringCtor_2()
    {
	m_bf = new BitField("00000000");
        assertEquals(8, m_bf.length());
	for(int i=0; i<8; i++){
	    assertFalse(m_bf.get(i));
	}
    }

    @Test
    public void stringCtor_3()
    {
	m_bf = new BitField("001");
        assertEquals(3, m_bf.length());
        assertTrue(m_bf.get(0));
        assertFalse(m_bf.get(1));
        assertFalse(m_bf.get(2));
    }
    
    @Test
    public void stringCtor_4()
    {
	m_bf = new BitField("1000");
        assertEquals(4, m_bf.length());
        assertFalse(m_bf.get(0));
        assertFalse(m_bf.get(1));
        assertFalse(m_bf.get(2));
        assertTrue(m_bf.get(3));
    }
    
    @Test
    public void stringCtor_5()
    {
	m_bf = new BitField("111111111");
        assertEquals(9, m_bf.length());
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
	assertEquals(8, m_bf.length());
	for(int i=0; i<7; i++){
	    assertFalse(m_bf.get(i));
	}
	assertTrue(m_bf.get(7));
    }

    @Test
    public void byteArrayCtor_two_bytes()
    {
	m_bf = new BitField(new byte[] { 0x01, (byte)0xAB });
	assertEquals(16, m_bf.length());
	for(int i=0; i<7; i++){
	    assertFalse(m_bf.get(i));
	}
	assertTrue(m_bf.get(7));
	// A == 1010
	assertTrue(m_bf.get(8));
	assertFalse(m_bf.get(9));
	assertTrue(m_bf.get(10));
	assertFalse(m_bf.get(11));
	// B == 1011
	assertTrue(m_bf.get(12));
	assertFalse(m_bf.get(13));
	assertTrue(m_bf.get(14));
	assertTrue(m_bf.get(15));
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
	String expected = "[" + in.length() + ":" + in + "]";
	m_bf = new BitField(in);
	assertEquals(expected, m_bf.toString());
    }
}
