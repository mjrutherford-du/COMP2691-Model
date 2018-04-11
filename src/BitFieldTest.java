import static org.junit.Assert.*;
import org.junit.*;

public class BitFieldTest
{
    private BitField m_bf = null;

    @Test
    public void intCtor()
    {
	m_bf = new BitField(5);
	assertEquals("failure - BitField.length() is not correct.", 5, m_bf.length());

	for(int i=0; i<m_bf.length(); i++){
	    assertFalse("failure - BitField initial value is not FALSE.", m_bf.get(i));
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
        assertEquals("failure -- BitField.length() is not correct.", 4, m_bf.length());
	assertTrue("failure -- BitField(String) value", m_bf.get(0));
	assertTrue("failure -- BitField(String) value", m_bf.get(1));
	assertFalse("failure -- BitField(String) value", m_bf.get(2));
	assertTrue("failure -- BitField(String) value", m_bf.get(3));
    }

    @Test
    public void stringCtor_2()
    {
	m_bf = new BitField("00000000");
        assertEquals("failure -- BitField.length() is not correct.", 8, m_bf.length());
	for(int i=0; i<8; i++){
	    assertFalse("failure -- BitField(String)[2] value", m_bf.get(i));
	}
    }

    @Test
    public void stringCtor_3()
    {
	m_bf = new BitField("001");
        assertEquals("failure -- BitField.length() is not correct.", 3, m_bf.length());
        assertTrue("failure -- BitField(String) 3 value", m_bf.get(0));
        assertFalse("failure -- BitField(String) 3 value", m_bf.get(1));
        assertFalse("failure -- BitField(String) 3 value", m_bf.get(2));
    }
    
    @Test
    public void stringCtor_4()
    {
	m_bf = new BitField("1000");
        assertEquals("failure -- BitField.length() is not correct.", 4, m_bf.length());
        assertFalse("failure -- BitField(String) 4 value", m_bf.get(0));
        assertFalse("failure -- BitField(String) 4 value", m_bf.get(1));
        assertFalse("failure -- BitField(String) 4 value", m_bf.get(2));
        assertTrue("failure -- BitField(String) 4 value", m_bf.get(3));
    }
    
    @Test
    public void stringCtor_5()
    {
	m_bf = new BitField("111111111");
        assertEquals("failure -- BitField.length() is not correct.", 9, m_bf.length());
	for(int i=0; i<9; i++){
	    assertTrue("failure -- BitField(String)[2] value", m_bf.get(i));
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
	assertFalse("failure - BitField set/get[1]", m_bf.get(0));
	assertTrue("failure - BitField set/get[1]", m_bf.get(1));
	assertFalse("failure - BitField set/get[1]", m_bf.get(2));

	m_bf.set(2, true);
	assertFalse("failure - BitField set/get[2]", m_bf.get(0));
	assertTrue("failure - BitField set/get[2]", m_bf.get(1));
	assertTrue("failure - BitField set/get[2]", m_bf.get(2));

	m_bf.set(1, false);
	assertFalse("failure - BitField set/get[3]", m_bf.get(0));
	assertFalse("failure - BitField set/get[3]", m_bf.get(1));
	assertTrue("failure - BitField set/get[3]", m_bf.get(2));

	m_bf.setFalse(2);
	assertFalse("failure - BitField set/get[4]", m_bf.get(0));
	assertFalse("failure - BitField set/get[4]", m_bf.get(1));
	assertFalse("failure - BitField set/get[4]", m_bf.get(2));

	m_bf.setTrue(0);
	assertTrue("failure - BitField set/get[4]", m_bf.get(0));
	assertFalse("failure - BitField set/get[4]", m_bf.get(1));
	assertFalse("failure - BitField set/get[4]", m_bf.get(2));
    }

    @Test
    public void setAll()
    {
	m_bf = new BitField(3);
	m_bf.setAll(true);
	assertTrue("failure - BitField setAll[1]", m_bf.get(0));
	assertTrue("failure - BitField setAll[1]", m_bf.get(1));
	assertTrue("failure - BitField setAll[1]", m_bf.get(2));

	m_bf.setAll(false);
	assertFalse("failure - BitField setAll[2]", m_bf.get(0));
	assertFalse("failure - BitField setAll[2]", m_bf.get(1));
	assertFalse("failure - BitField setAll[2]", m_bf.get(2));

	m_bf.setAllTrue();
	assertTrue("failure - BitField setAll[3]", m_bf.get(0));
	assertTrue("failure - BitField setAll[3]", m_bf.get(1));
	assertTrue("failure - BitField setAll[3]", m_bf.get(2));

	m_bf.setAllFalse();
	assertFalse("failure - BitField setAll[4]", m_bf.get(0));
	assertFalse("failure - BitField setAll[4]", m_bf.get(1));
	assertFalse("failure - BitField setAll[4]", m_bf.get(2));

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
}
