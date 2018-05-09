/**
 * Class to represent the Random Access Memory (RAM) of a
 * computer. Data can be read and written at any valid address.
 *
 * Multi-byte data are organized in big-endian order (i.e., most
 * significant byte is at the lowest address).
 */
public class Memory
{
    private final byte[] m_data;
    public Memory(int nBytes)
    {
	m_data = new byte [ nBytes ];
    }

    public byte read1(int address)
    {
	return m_data[address];
    }

    public byte[] read(int address, int nBytes)
    {
	byte[] out = new byte [ nBytes ];
	for(int i=0; i<nBytes; i++){
	    out[i] = m_data[address+i];
	}
	return out;
    }

    public byte[] read2(int address)
    {
	return read(address, 2);
    }

    public byte[] read4(int address)
    {
	return read(address, 4);
    }

    public byte[] read8(int address)
    {
	return read(address, 8);
    }

    public void write(int address, byte[] data)
    {
	for(int i=0; i<data.length; i++){
	    m_data[address+i] = data[i];
	}
    }

    public void write1(int address, byte data)
    {
	m_data[address] = data;
    }
}
