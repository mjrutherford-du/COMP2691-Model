/** Class representing the interface between the processor
 * and physical memory for instruction transactions.
 */
public class InstructionMemory
{
    private final Memory m_memory;
    
    public InstructionMemory(Memory memory)
    {
	m_memory = memory;
    }

    public BitField32 fetch(BitField64 pc)
    {
	int address = pc.toIntSigned();
	byte[] data = m_memory.read(address, 4);
	return new BitField32(data);
    }
}
