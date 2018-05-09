public class BitField32 extends BitField
{
    public BitField32()
    {
	super(32);
    }

    public BitField32(String value)
    {
	super(32, value);
    }

    public BitField32(byte[] data)
    {
	super(32, data);
    }
}
