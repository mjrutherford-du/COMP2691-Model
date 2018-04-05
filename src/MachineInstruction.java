/** Class representing a single machine instruction.  This is the encoded version of
* an assembly instruction.  In ARM, all instructions are encoded in 4 bytes.
*/
public class MachineInstruction
{
    private final byte[] m_bytes;

    public MachineInstruction(byte[] bytes)
    {
	if(bytes.length != 4){
	    throw new RuntimeException("MachineInstruction must be 4 bytes");
	}
	m_bytes = bytes;
    }

    public byte[] getBytes()
    {
	return m_bytes.clone();
    }
}
