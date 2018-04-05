/** Class to represent a single instruction.  Each instruction tells
 * the computer to do a certain operation and has different
 * parameters, depending on its functionality.
 */
public abstract class Instruction
{
    private final String m_label;

    public Instruction(String label)
    {
	m_label = label;
    }

    public String getLabel()
    {
	return m_label;
    }

    public boolean hasLabel()
    {
	return m_label != null;
    }
    
    public MachineInstruction encode()
    {
	return new MachineInstruction(new byte [ 4 ]);
    }
}
