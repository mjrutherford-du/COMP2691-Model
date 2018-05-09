public class BitField64 extends BitField
{
    public BitField64()
    {
	super(64);
    }

    public BitField64(String value)
    {
	super(64, value);
    }

    public BitField64(byte[] data)
    {
	super(64, data);
    }
}
